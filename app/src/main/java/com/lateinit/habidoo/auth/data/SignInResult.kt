package com.lateinit.habidoo.auth.data

/**
 * Class to hold result of sign-in -> user details if successful, else an error message.
 *
 * @param userDetails details of the signed in user
 * @param error error message in case sign-in fails
 */
data class SignInResult(
    val userDetails: UserDetails?,
    val error: String? = null,
)
