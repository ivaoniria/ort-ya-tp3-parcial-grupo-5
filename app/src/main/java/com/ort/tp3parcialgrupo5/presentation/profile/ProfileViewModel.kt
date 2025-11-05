package com.ort.tp3parcialgrupo5.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ort.tp3parcialgrupo5.domain.repository.UserRepository
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

    private var argumentsHandled = false

    fun handleArguments(userCreated: Boolean, fromLogin: Boolean) {
        if (argumentsHandled) return
        argumentsHandled = true

        if (userCreated) {
            showSuccessPopup()
        } else if (fromLogin) {
            checkIfUserExists()
        }
    }

    private fun showSuccessPopup() {
        viewModelScope.launch {
            val user = repository.getLastUser()
            if (user != null) {
                _popupState.value = PopupState.UserCreated(user.username, user.email)
            }
        }
    }

    private fun checkIfUserExists() {
        viewModelScope.launch {
            if (repository.getUserCount() == 0) {
                _popupState.value = PopupState.NoUser
            }
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
