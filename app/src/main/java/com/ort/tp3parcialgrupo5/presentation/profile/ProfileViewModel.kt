package com.ort.tp3parcialgrupo5.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ort.tp3parcialgrupo5.domain.repository.UserRepository
import com.ort.tp3parcialgrupo5.domain.model.DbUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: UserRepository
): ViewModel() {
    private val _popupState = MutableStateFlow<PopupState>(PopupState.Hidden)
    val popupState: StateFlow<PopupState> = _popupState.asStateFlow()
    private val _username = MutableStateFlow<String?>(null)
    val username: StateFlow<String?> = _username.asStateFlow()
    private var argumentsHandled = false

    fun handleArguments(
        userCreated: Boolean,
        fromLogin: Boolean,
        createdUsername: String? = null,
        createdEmail: String? = null
    ) {
        if (argumentsHandled) return
        argumentsHandled = true

        viewModelScope.launch {
            if (!createdUsername.isNullOrBlank() && !createdEmail.isNullOrBlank()) {
                repository.insertUser(DbUser(id = 0, username = createdUsername, email = createdEmail))
            }

            val last = repository.getLastUser()
            _username.value = last?.username

            when {
                userCreated -> {
                    if (last != null) {
                        _popupState.value = PopupState.UserCreated(last.username, last.email)
                    } else {
                        _popupState.value = PopupState.Hidden
                    }
                }
                fromLogin -> {
                    if (repository.getUserCount() == 0) {
                        _popupState.value = PopupState.NoUser
                    }
                }
                else -> {
                    _popupState.value = PopupState.Hidden
                }
            }
        }
    }

    fun loadProfileUser() {
        viewModelScope.launch {
            val user = repository.getLastUser()
            _username.value = user?.username
        }
    }
    fun dismissPopup() {
        _popupState.value = PopupState.Hidden
    }
}
sealed class PopupState {
    object Hidden : PopupState()
    data class UserCreated(val username: String, val email: String) : PopupState()
    object NoUser : PopupState()
}
