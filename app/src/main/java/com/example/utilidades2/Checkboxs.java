package com.example.utilidades2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Checkboxs extends AppCompatActivity {

    EditText edtTotalPagar, edtNeto;
    CheckBox chkBolsa, chkDonacion, chkTinka;
    Button btnCalcularPago;

    private void loadUI(){
        edtTotalPagar = findViewById(R.id.edtTotalPagar);
        edtNeto = findViewById(R.id.edtNeto);
        chkBolsa = findViewById(R.id.chkBolsa);
        chkDonacion =findViewById(R.id.chkDonacion);
        chkTinka = findViewById(R.id.chkTinka);
        btnCalcularPago = findViewById(R.id.btnCalcularPago);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_checkboxs);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        this.loadUI();
        btnCalcularPago.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalcularNetoPagar();
            }
        });
    }

    private void CalcularNetoPagar() {
        double totalPagar = 0, bolsa = 0, donacion = 0, tinka = 0, neto = 0;

        //Leemos el total ingresado
        totalPagar = Double.parseDouble(edtTotalPagar.getText().toString());

        //Condicion
        //Solo si se selecciona la casilla, se agrega
        if (chkBolsa.isChecked()){
            bolsa = 2;
        }

        if (chkDonacion.isChecked()){
            donacion = 5;
        }

        if (chkTinka.isChecked()){
            tinka = 10;
        }

        //Calcula el neto
        neto = totalPagar + bolsa + donacion + tinka;

        edtNeto.setText(String.valueOf(neto));

    }
}