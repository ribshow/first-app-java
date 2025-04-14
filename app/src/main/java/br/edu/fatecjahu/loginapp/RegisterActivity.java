package br.edu.fatecjahu.loginapp;

import static java.security.AccessController.getContext;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class RegisterActivity extends DebugActivity {

    TextView tName, tEmail, tPassword;
    Button btRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // chamando o button da tela de register
        btRegister = (Button) findViewById(R.id.btnRegister);

        // criando a função que registra o user
        btRegister.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    tName = (TextView) findViewById(R.id.edtName);
                    tEmail = (TextView) findViewById(R.id.edtEmail);
                    tPassword = (TextView) findViewById(R.id.edtPassword);

                    String name = tName.getText().toString();
                    String email = tEmail.getText().toString();
                    String password = tPassword.getText().toString();

                    // passando os dados que foram digitados em registerAcitivy para a MainActivity
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    intent.putExtra("name", name);
                    intent.putExtra("email", email);
                    intent.putExtra("password", password);
                    startActivity(intent);
                }
        });
    }
}