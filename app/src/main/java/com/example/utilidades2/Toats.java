package com.example.utilidades2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Toats extends AppCompatActivity {

    Button btn1, btn2;

    private void loadUI(){
        btn1 = findViewById(R.id.btnAvisoLento);
        btn2 = findViewById(R.id.btnAvisoRapido);
    }

    private void notificar(String mensaje, boolean tiempo){
        //sentencia IF en una sola linea :p
        int duracion = (tiempo) ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT;
        Toast.makeText(getApplicationContext(),mensaje,duracion).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_toats);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        this.loadUI();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notificar("Hola amigos",true);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notificar("Adios amigos",false);
            }
        });
    }
}