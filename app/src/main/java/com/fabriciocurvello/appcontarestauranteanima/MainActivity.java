package com.fabriciocurvello.appcontarestauranteanima;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText etConta;
    Button btCalcular;
    TextView tvResultado;

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

        //vínculo entre JAVA e XML
        etConta = findViewById(R.id.et_conta);
        btCalcular = findViewById(R.id.bt_calcular);
        tvResultado = findViewById(R.id.tv_resultado);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double conta = Double.parseDouble(etConta.getText().toString());
                conta = conta * 1.10;
                tvResultado.setText(String.format( "R$ %.2f",conta ));
            }
        });
    } // fim do onCreate()
}
