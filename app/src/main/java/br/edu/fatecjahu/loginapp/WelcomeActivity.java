package br.edu.fatecjahu.loginapp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.content.Context;
import android.content.Intent;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class WelcomeActivity extends DebugActivity {

    // 17. Declaração de objetos Java de texto.
    TextView text1;

    Button btnCalcSquare;
    Button btnCalcArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_welcome);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        text1 = findViewById(R.id.textView1);
        btnCalcSquare = findViewById(R.id.btnSquare);
        btnCalcArea = findViewById(R.id.btnArea);

        // RELACIONANDO BUTTON COM O ELEMENTO BUTTON DA TELA
        btnCalcSquare.setOnClickListener(v -> {

                Intent intent = new Intent(getContext(), SquareActivity.class);

                startActivity(intent);
        });

        btnCalcArea.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), AreaActivity.class);

            startActivity(intent);
        });

        // 18. Recebe o pacote vindo da intent de MainActivity.
        Bundle args = getIntent().getExtras();

        if(args != null){
            String name = args.getString("name", ""); // Valor padrão vazio se não existir
            String login = args.getString("access", "");

            // Atualiza o título da activity
            setTitle("Bem-vindo" + login); // Usando recursos de string

            // Atualiza o texto de boas-vindas
            text1.setLines(2);
            text1.setText("Bem vindo "+ name); // Usando recursos de string (correção do terceiro e quarto avisos)
        }
    }

    private Context getContext() {return this;}
}