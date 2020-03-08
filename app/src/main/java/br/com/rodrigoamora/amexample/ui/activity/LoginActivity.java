package br.com.rodrigoamora.amexample.ui.activity;

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

    }
}
