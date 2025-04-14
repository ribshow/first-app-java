package br.edu.fatecjahu.loginapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.MessageFormat;

public class BemVindoActivity extends DebugActivity {

    // 17. Declaração de objetos Java de texto.
    TextView text1, text2, text3, text4, text5, text6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bem_vindo);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 18. Recebe o pacote vindo da intent de MainActivity.
        Bundle args = getIntent().getExtras();

        // 19. Recebe o nome enviado por parâmetro.        // key (chave)   value (valor)
        String name = args.getString("name");          //      nome = "Alex Batista";

        Float     value1 = args.getFloat("value1");     //    valor1 = 9.00;
        Double    value2 = args.getDouble("value2");    //    valor2 = 5.50;
        Integer   value3 = args.getInt("value3");       //    valor3 = 20;
        Character value4 = args.getChar("value4");      //    valor4 = 'A';

        String login = args.getString("access");       //    acesso = login;
        // 20. Adiciona o nome do usuário na barra de título da tela bem-vindo.
        setTitle("Bem-vindo: " + login);

        // 21. Associar os componentes de tela (View)
        // aos objetos Java (Controller).
        text1 = (TextView) findViewById(R.id.textView1);
        text2 = (TextView) findViewById(R.id.textView2);
        text3 = (TextView) findViewById(R.id.textView3);
        text4 = (TextView) findViewById(R.id.textView4);
        text5 = (TextView) findViewById(R.id.textView5);
        text6 = (TextView) findViewById(R.id.textView6);

        // 22. Vamos atualizar o texto do TextView1
        // com uma mensagem de bem-vindo.
        text1.setLines(2);  // Define duas linhas dentro do objeto text1.
        text1.setText("Olá " + name + ",\n seja bem-vindo!!!"); // Quebra em duas linhas o conteúdo
                                                                // dessa mensagem com uso do \n.
        text2.setText(String.format("Valor1 : %s", value1));

        text3.setText(MessageFormat.format("Valor2 : {0}", String.valueOf(value2)));

        text4.setText(String.format("Valor3 : %s", value3));

        text5.setText(String.format("Valor4 : %s", value4));

        Double result = value1 - value2;

        text6.setText(String.format("Resultado: %s", result));
    }
}