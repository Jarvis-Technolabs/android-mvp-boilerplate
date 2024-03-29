package com.jainamj.myapplication.services


import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.tumblr.remember.Remember
import timber.log.Timber

class MyFirebaseInstanceIDService : FirebaseMessagingService() {

    private val KEY_FCM_ID: String = "KEY_FCM_ID"

    /**
     * Called if InstanceID token is updated. This may occur if the security of
     * the previous token had been compromised. Note that this is called when the InstanceID token
     * is initially generated so this is where you would retrieve the token.
     */
    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Timber.i("Refreshed token :: $token")
        Remember.putString(KEY_FCM_ID, token)
        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        sendRegistrationToServer(token)
    }

    private fun sendRegistrationToServer(token: String) {
        // TODO : send token to tour server
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        Timber.i("Message :: $message")
    }

}