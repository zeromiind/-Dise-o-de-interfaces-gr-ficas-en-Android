package com.example.utilidades2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Switchs extends AppCompatActivity {

    SwitchCompat swtTerminos;
    Button btnContinuar;

    private void loadUI(){
        swtTerminos = findViewById(R.id.swtTerminos);
        btnContinuar = findViewById(R.id.btnContinuar);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_switchs);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        this.loadUI();
        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarTerminos();
            }
        });
    }

    private void validarTerminos() {
        if (swtTerminos.isChecked()){
            Toast.makeText(getApplicationContext(),"Gracias por confirmar",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(),"No aceptó los términos",Toast.LENGTH_SHORT).show();
        }
    }
}