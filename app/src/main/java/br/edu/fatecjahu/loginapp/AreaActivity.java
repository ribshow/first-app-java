package br.edu.fatecjahu.loginapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AreaActivity extends AppCompatActivity {

    private EditText editSideOne, editSideTwo;
    private Button btnCalculate;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_area);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializar componentes
        editSideOne = findViewById(R.id.editNumberOne);
        editSideTwo = findViewById(R.id.editNumber2);
        btnCalculate = findViewById(R.id.button);
        textResult = findViewById(R.id.titleArea);

        btnCalculate.setOnClickListener(v -> calculateArea());
    }

    private void calculateArea() {
        try {
            String sideOneStr = editSideOne.getText().toString();
            String sideTwoStr = editSideTwo.getText().toString();

            // Verificar se os campos estão vazios
            if (sideOneStr.isEmpty() || sideTwoStr.isEmpty()) {
                Toast.makeText(this, R.string.fill_all_fields, Toast.LENGTH_SHORT).show();
                return;
            }

            double side1 = Double.parseDouble(sideOneStr);
            double side2 = Double.parseDouble(sideTwoStr);

            // Verificar se os valores são positivos
            if (side1 <= 0 || side2 <= 0) {
                Toast.makeText(this, R.string.positive_values_required, Toast.LENGTH_SHORT).show();
                return;
            }

            double area = side1 * side2;

            // Verificar se é um quadrado (lados iguais)
            if (side1 == side2) {
                textResult.setText(getString(R.string.square_area_result, area));
            } else {
                textResult.setText(getString(R.string.rectangle_area_result, area));
            }

        } catch (NumberFormatException e) {
            Toast.makeText(this, R.string.invalid_number_format, Toast.LENGTH_SHORT).show();
        }
    }
}