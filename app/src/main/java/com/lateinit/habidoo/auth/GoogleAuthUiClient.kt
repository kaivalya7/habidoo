package com.lateinit.habidoo.auth

import android.content.Context
import android.content.Intent
import android.content.IntentSender
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.BeginSignInRequest.GoogleIdTokenRequestOptions
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.Firebase
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.auth
import com.lateinit.habidoo.R
import com.lateinit.habidoo.auth.data.SignInResult
import com.lateinit.habidoo.auth.data.UserDetails
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.tasks.await

/**
 * Class to sign-in and sign-out the user. ALso, to be used to get the user information of the
 * signed-in user.
 *
 * @param context
 * @param oneTapClient the client that comes from the Firebase SDK which shows the dialog to sign-in
 */
class GoogleAuthUiClient(
    private val context: Context,
    private val oneTapClient: SignInClient,
) {

    // Initialize Firebase Auth
    private val auth = Firebase.auth

    //region SIGN-IN
    suspend fun signIn(): IntentSender? {
        val result = try {
            oneTapClient.beginSignIn(
                buildSignInRequest()
            ).await()

        } catch (exception: Exception) {
            exception.printStackTrace()
            if (exception is CancellationException) throw exception
            null
        }
        return result?.pendingIntent?.intentSender
    }

    suspend fun signInWthIntent(intent: Intent): SignInResult {
        val credential = oneTapClient.getSignInCredentialFromIntent(intent)
        val googleCredentials = GoogleAuthProvider.getCredential(credential.googleIdToken, null)
        return try {
            val user = auth.signInWithCredential(googleCredentials).await().user
            SignInResult(
                userDetails = user?.run {
                    UserDetails(
                        userId = uid,
                        userName = displayName,
                        profilePictureUrl = photoUrl?.toString()
                    )
                }
            )
        } catch (exception: Exception) {
            exception.printStackTrace()
            if (exception is CancellationException) throw exception
            SignInResult(
                userDetails = null,
                error = exception.message
            )
        }
    }

    private fun buildSignInRequest(): BeginSignInRequest {
        return BeginSignInRequest.builder()
            .setGoogleIdTokenRequestOptions(
                // Inform that the method of using google tokens for authentication is supported
                // and show all possible accounts for logging in
                GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    .setFilterByAuthorizedAccounts(false)
                    .setServerClientId(context.getString(R.string.web_client_id))
                    .build()
            ).build()
    }
    //endregion

    // region SIGN-OUT
    suspend fun signOut() {
        try {
            oneTapClient.signOut()
            auth.signOut()
        } catch (exception: Exception) {
            exception.printStackTrace()
            if (exception is CancellationException) throw exception
        }
    }
    // endregion

    //region User Information
    fun getSignedInUserDetails(): UserDetails? = auth.currentUser?.run {
        UserDetails(
            uid,
            displayName,
            photoUrl?.toString(),
        )
    }
    //endregion
}