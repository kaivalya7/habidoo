package com.lateinit.habidoo.auth

import androidx.lifecycle.ViewModel
import com.lateinit.habidoo.auth.data.SignInResult
import com.lateinit.habidoo.auth.data.SignInState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SignInViewModel : ViewModel() {

    private val _state = MutableStateFlow(SignInState())
    val state = _state.asStateFlow()

    fun updateSignInStateOnSignInResult(result: SignInResult) {
        _state.update {
            it.copy(
                isSignInSuccessful = result.userDetails != null,
                signInError = result.error,
            )
        }
    }

    fun resetState() {
        _state.update { SignInState() }
    }
}