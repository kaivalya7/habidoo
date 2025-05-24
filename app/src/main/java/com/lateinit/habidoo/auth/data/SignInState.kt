package com.lateinit.habidoo.auth.data

/**
 * Holds the state of sign-in, if it was successful or not.
 *
 * @param isSignInSuccessful a [Boolean] to know if the sign in was completed successfully or not.
 *        Defaults to false as user will not be signed it initially.
 * @param signInError a error message in case the sign-in has failed.
 */
data class SignInState(
    val isSignInSuccessful: Boolean = false,
    val signInError: String? = null,
)
