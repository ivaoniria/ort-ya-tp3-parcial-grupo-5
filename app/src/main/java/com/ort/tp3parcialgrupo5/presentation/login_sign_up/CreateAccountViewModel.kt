package com.ort.tp3parcialgrupo5.presentation.login_sign_up

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ort.tp3parcialgrupo5.domain.repository.UserRepository
import com.ort.tp3parcialgrupo5.domain.model.DbUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateAccountViewModel @Inject constructor(
    private val repository: UserRepository
): ViewModel() {
    fun insertUser(username: String, email: String) {
        viewModelScope.launch {
            val newUser = DbUser(id = 0, username = username, email = email)
            repository.insertUser(newUser)
        }
    }
}
