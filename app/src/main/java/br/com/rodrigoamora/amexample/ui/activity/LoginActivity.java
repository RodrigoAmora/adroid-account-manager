package br.com.rodrigoamora.amexample.ui.activity;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import br.com.rodrigoamora.amexample.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btOk;
    private EditText inputLogin, inputSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btOk = findViewById(R.id.bt_ok);
        btOk.setOnClickListener(this);

        inputLogin = findViewById(R.id.input_login);
        inputSenha = findViewById(R.id.input_senha);
    }

    @Override
    public void onClick(View view) {
        String login = inputLogin.getText().toString();
        String senha = inputSenha.getText().toString();
        String authToken = "br.com.rodrigoamora.amexample";
        createAccount(login, senha, authToken);
    }

    private void createAccount(String email, String password, String authToken) {
        Account account = new Account(email, "account_type");

        AccountManager am = AccountManager.get(this);
        am.addAccountExplicitly(account, password, null);
        am.setAuthToken(account, "full_access", authToken);
    }
}
