package br.com.rodrigoamora.amexample.ui.activity;

import android.accounts.Account;
import android.accounts.AccountAuthenticatorActivity;
import android.accounts.AccountManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.rodrigoamora.amexample.R;

public class LoginActivity extends AccountAuthenticatorActivity implements View.OnClickListener {

    private Button btOk;
    private EditText inputLogin, inputSenha;

    private String accountType;

    private final int REQ_SIGNUP = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btOk = findViewById(R.id.bt_ok);
        btOk.setOnClickListener(this);

        inputLogin = findViewById(R.id.input_login);
        inputSenha = findViewById(R.id.input_senha);

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
        String login = inputLogin.getText().toString();
        String senha = inputSenha.getText().toString();
        String authToken = "xhjcvsjhdvcvjdhcgvsgchk";
        createAccount(login, senha, authToken);
        /*
        if (EmailValidator.validate(login) && !senha.isEmpty()) {
            createAccount(login, senha, authToken);
        }
         */
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
