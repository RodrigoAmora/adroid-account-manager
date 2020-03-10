package br.com.rodrigoamora.amexample.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

import br.com.rodrigoamora.amexample.Authenticator;

public class AuthenticatorService extends Service {

    private Authenticator mAuthenticator;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        mAuthenticator = new Authenticator(this);
        return mAuthenticator.getIBinder();
    }
}
