package br.com.rodrigoamora.amexample.ui.activity;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import br.com.rodrigoamora.amexample.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btOk;
    private EditText inputLogin, inputSenha;

    private String accountType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btOk = findViewById(R.id.bt_ok);
        btOk.setOnClickListener(this);

        inputLogin = findViewById(R.id.input_login);
        inputSenha = findViewById(R.id.input_senha);

        accountType = getIntent().getStringExtra(AccountManager.KEY_ACCOUNT_TYPE);
    }

    @Override
    public void onClick(View view) {
        String login = inputLogin.getText().toString();
        String senha = inputSenha.getText().toString();
        String authToken = " xhjcvsjhdvcvjdhcgvsgchk";

        createAccount(login, senha, authToken);
    }

    private void login() {

    }

    private void createAccount(String email, String password, String authToken) {
        String accountType = getString(R.string.account_type);
        Account account = new Account(email, accountType);

        Bundle data = new Bundle();
        data.putString(AccountManager.KEY_ACCOUNT_NAME, email);
        data.putString(AccountManager.KEY_ACCOUNT_TYPE, accountType);
        data.putString(AccountManager.KEY_AUTHTOKEN, authToken);

        final Intent result = new Intent();
        result.putExtras(data);

        setResult(RESULT_OK, result);

        AccountManager am = AccountManager.get(this);
        am.addAccountExplicitly(account, password, data);
        am.setAuthToken(account, "full_access", authToken);
    }
}
