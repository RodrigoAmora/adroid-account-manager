package br.com.rodrigoamora.amexample.ui.activity;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import br.com.rodrigoamora.amexample.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override public void run() {
                verificarAccountManager();
            }
        }, 2000);
    }

    private void verificarAccountManager() {
        AccountManager am = AccountManager.get(this);
        Account[] accounts = am.getAccounts();
        for (Account account : accounts) {
            if (account.type.toString().equals(getString(R.string.account_type))) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return;
            }
        }
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
