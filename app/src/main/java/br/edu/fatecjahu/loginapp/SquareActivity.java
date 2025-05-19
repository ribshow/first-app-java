package br.edu.fatecjahu.loginapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SquareActivity extends AppCompatActivity {

    private EditText editNumberOne, editNumberTwo;
    Button btnCalculate;
    private TextView titleSquare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_square);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializar os componentes da view
        editNumberOne = findViewById(R.id.editNumberOne);
        editNumberTwo = findViewById(R.id.editNumber2);
        btnCalculate = findViewById(R.id.button);
        titleSquare = findViewById(R.id.titleArea);

        // Configurar o clique do botão
        btnCalculate.setOnClickListener(v -> calculateMultiplication());
    }

    private void calculateMultiplication() {
        try {
            // Obter os valores dos EditTexts
            String strNum1 = editNumberOne.getText().toString();
            String strNum2 = editNumberTwo.getText().toString();

            // Verificar se os campos estão vazios
            if (strNum1.isEmpty() || strNum2.isEmpty()) {
                Toast.makeText(this, R.string.enter_both_numbers, Toast.LENGTH_SHORT).show();
                return;
            }

            // Converter para números
            double num1 = Double.parseDouble(strNum1);
            double num2 = Double.parseDouble(strNum2);

            // Calcular a multiplicação
            double result = num1 * num2;

            // Exibir o resultado no TextView
            titleSquare.setText(getString(R.string.result_format, result));

        } catch (NumberFormatException e) {
            Toast.makeText(this, R.string.invalid_number_format, Toast.LENGTH_SHORT).show();
        }
    }
}