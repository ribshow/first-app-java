package br.edu.fatecjahu.loginapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends DebugActivity {

    // 0. Criar os objetos Java.
    TextView tLogin, tPassword;
    Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 1. Cria o objeto btLogin do tipo Button e
        // vincular ao botão btnLogin da Activity (tela).
        btLogin = (Button) findViewById(R.id.btnLogin);

        // 2. Metodo do botão "Login"
        // setOnClickListener => View.OnClickListener() => onClick(View v)
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 3. Associar os objetos da View com os objetos Java.
                tLogin = (TextView) findViewById(R.id.edtUser);
                tPassword = (TextView) findViewById(R.id.edtPassword);

                // 4. Criação do Usuário e Senha Padrão.
                //final String LOGIN = "Heryson Andrade";  // Constante LOGIN é o nome do usuário.
                //final String PASSWORD = "12345"; // Constante SENHA é a senha do usuário.

                Intent intentData = getIntent();
                final String NAME = intentData.getStringExtra("name");
                final String LOGIN = intentData.getStringExtra("email");
                final String PASSWORD = intentData.getStringExtra("password");

                // 5. Capturar usuário e senha.
                String login = tLogin.getText().toString();
                String password = tPassword.getText().toString();

                // 6. Validação de usuário e senha.
                if (LOGIN.equals(login) && PASSWORD.equals(password)) {
                    // 7. Cria uma intenção (objeto intent) de navegar para a próxima tela.
                    Intent intent = new Intent(getContext(), BemVindoActivity.class);

                    // 9. Criar um pacote de dados (Bundle)
                    Bundle params = new Bundle();

                    // 10. Adicionando chaves e valores.         //    key       value
                    params.putString("name", login);     //    nome = "Alex Batista";
                    params.putFloat("value1", 9.00f);            //  valor1 = 9.00;
                    params.putDouble("value2", 5.50);            //  valor2 = 5.50;
                    params.putInt("value3", 20);                 //  valor3 = 20;
                    params.putChar("value4", 'A');               //  valor4 = 'A';
                    params.putString("access", login);           //  acesso = login;

                    // remove um párâmetro especifico
                    params.remove("value4");

                    Log.i(TAG2, getClassName() + " => Removendo o dado value4 do pacote");

                    // chamando a função show log para exibir os dados dentro do parametro
                    showLog(params);

                    // 11. Colocar o pacote de dados (params) no objeto intent.
                    intent.putExtras(params);

                    // 12. Navega para a próxima tela.
                    startActivity(intent);

                    params.clear();
                    Log.i(TAG2, getClassName() +" => Removendo todos os dados do pacote !!!");

                    showLog(params);

                    // 13. Mensagem de login efetuado com sucesso.
                    alert("Bem-vindo, login realizado com sucesso!!!");
                } else {
                    // 16. Mensagem de falha no login.
                    alert("Login ou senha incorretos!!!");
                }
            }
        });
    }

    private void showLog(Bundle bundle) {
        // Imprimir o conteúdo das variáveis via logCat
        Log.d(TAG2, getClassName() + " => Mostrando dados da MainActivity:");
        Log.d(TAG2, getClassName() + " => Nome: " + bundle.getString("name"));
        Log.d(TAG2, getClassName() + " => valor 1: " + bundle.getFloat("value1"));
        Log.d(TAG2, getClassName() + " => valor 2: " + bundle.getDouble("value2"));
        Log.d(TAG2, getClassName() + " => valor 3: " + bundle.getInt("value3"));
        Log.d(TAG2, getClassName() + " => valor 4: " + bundle.getChar("value4"));


    }

    //17. Metodo Limpar Dados: Login e Senha.
    private void limparDados() {
        Log.i(TAG, getClassName() + " => Limpando dados...");
        // Associação das caixas de textos aos objetos do Java.
        tLogin = (TextView) findViewById(R.id.edtUser);
        tPassword = (TextView) findViewById(R.id.edtPassword);

        // Limpar as caixas de texto: usuário e senha.
        tLogin.setText("");
        tPassword.setText("");
    }

    // 18. Chamada ao metodo onRestart para limpar os dados
    // quando retornar da tela BemvindoActivity para a tela MainActivity.
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, getClassName() + " => Realizar a limpeza dos dados do Login...");
        limparDados();
        Log.i(TAG, getClassName() + " => Dados do Login Removidos...");
    }

    // 19. Posicionar o cursor de entrada (ponteiro) no campo login.
    @Override
    protected void onResume() {
        super.onResume();
        tLogin = (TextView) findViewById(R.id.edtUser);
        tLogin.requestFocus(); // Posiciona o cursor de entrada de dados no objeto tLogin.
        Log.i(TAG, getClassName() + " => Foco direcionado para o campo nome do usuário.");
    }

    // 14. Metodo alert para mostrar mensagens de notificação do aplicativo.
    private void alert(String msg) {
        // 15. A classe Toast mostra um alerta temporário muito comum no Android.
        Toast toast = Toast.makeText(getContext(), msg, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.show();

        // Toast.LENGTH_LONG tem a duração de 3 a 5 segundos da mensagem de TOAST.
        // Toast.LENGTH_SHORT tem a duração de 1 a 3 segundos da mensagem de TOAST.
    }

    // 8. Criação do Metodo de Contexto.
    // private MainActivity getContext() {
    private Context getContext() {
        return this;
    }

    // 20. Metodo onBackPressed para sair do aplicativo.
    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        // Instaciação de um objeto alertDialogBuilder (Caixa de Diálogo Personalizada)
        // da classe do tipo AlertDialog.Builder.
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        Log.i(TAG, getClassName() + " => Objeto Criado: alertDialogBuilder.");

        // Configuração de uma Caixa de Diálogo Personalizada.
        alertDialogBuilder.setTitle("Confirmar Saída");
        alertDialogBuilder.setIcon(R.drawable.ic_exit); // (R.drawable.ic_exit);
        alertDialogBuilder.setMessage("Você tem certeza que deseja sair ?");
        alertDialogBuilder.setCancelable(false);

        Log.i(TAG, getClassName() + " => Objeto Configurado: alertDialogBuilder.");

        // Configuração do botão Sim da Caixa de Diálogo Personalizada...
        // ...e aciamento do metodo onClick permitindo a saída do Aplicativo,
        //                                                   através do encerramento da Activity.

        // Metodo do botão Sim
        //  setPositiveButton() => DialogInterface.OnClickListener() => onClick()
        alertDialogBuilder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish(); // Encerra a Activity.
                // Metodo finish faz chamada de forma programática ao
                // metodo OnDestroy() do ciclo de vida da Activity.
                Log.i(TAG, getClassName() + ".onBackPressed() chamado. Botão Sim pressionado.");
            }
        });

        // Configuração do botão Não da Caixa de Diálogo Personalizada...
        // ...e mostra mensagem de cancelamento de saída do Aplicativo.

        // Metodo do botão Não
        //  setNegativeButton() => DialogInterface.OnClickListener() => onClick()
        alertDialogBuilder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Você clicou em cancelar", Toast.LENGTH_LONG).show();
                Log.i(TAG, getClassName() + ".onBackPressed() chamado. Botão Não pressionado.");
            }
        });

        // Construção de uma Caixa de Diálogo Personalizada e mostra a Caixa de Diálogo criada para o usuário.
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        Log.i(TAG, getClassName() + " => Objeto Criado e Visualizado: alertDialog.");
    }
}