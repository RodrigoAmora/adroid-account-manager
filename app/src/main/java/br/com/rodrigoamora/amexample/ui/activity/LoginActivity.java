package br.com.rodrigoamora.amexample.ui.activity;

import android.accounts.Account;
import android.accounts.AccountAuthenticatorActivity;
import android.accounts.AccountManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

import br.com.rodrigoamora.amexample.R;
import br.com.rodrigoamora.amexample.validator.EmailValidator;

public class LoginActivity extends AccountAuthenticatorActivity implements View.OnClickListener {

    private Button btOk;
    private EditText inputLogin, inputPassword;

    private String accountType;

    private final int REQ_SIGNUP = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btOk = findViewById(R.id.bt_ok);
        btOk.setOnClickListener(this);

        inputLogin = findViewById(R.id.input_login);
        inputPassword = findViewById(R.id.input_password);

        accountType = getString(R.string.account_type);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // The sign up activity returned that the user has successfully created an account
        if (requestCode == REQ_SIGNUP && resultCode == RESULT_OK) {

        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onClick(View view) {
        login();
    }

    private void login() {
        String login = inputLogin.getText().toString();
        String password = inputPassword.getText().toString();
        String authToken = "xhjcvsjhdvcvjdhcgvsgchk";

        if (password.isEmpty()) {
            Snackbar.make(btOk, getString(R.string.error_password_is_empty), Snackbar.LENGTH_LONG).show();
            return;
        }

        if (EmailValidator.validate(login)) {
            createAccount(login, password, authToken);
        } else {
            Snackbar.make(btOk, getString(R.string.error_invalid_email), Snackbar.LENGTH_LONG).show();
        }
    }

    private void createAccount(String email, String password, String authToken) {
        Account account = new Account(email, accountType);

        Bundle data = new Bundle();
        data.putString(AccountManager.KEY_ACCOUNT_NAME, email);
        data.putString(AccountManager.KEY_ACCOUNT_TYPE, accountType);
        data.putString(AccountManager.KEY_AUTHTOKEN, authToken);


        AccountManager am = AccountManager.get(this);
        am.addAccountExplicitly(account, password, data);
        am.setAuthToken(account, "full_access", authToken);

        final Intent intent = new Intent();
        intent.putExtras(data);
        setAccountAuthenticatorResult(intent.getExtras());
        setResult(RESULT_OK, intent);
    }
}
