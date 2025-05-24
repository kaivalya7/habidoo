package com.lateinit.habidoo.auth.data

/**
 * Class to hold signed in user information
 *
 * @param userId a unique user id
 * @param userName display name of the user
 * @param profilePictureUrl Remote url of user's profile picture
 */
data class UserDetails(
    val userId: String,
    val userName: String?,
    val profilePictureUrl: String?,
)
