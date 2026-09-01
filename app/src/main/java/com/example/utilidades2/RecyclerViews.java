package com.example.utilidades2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViews extends AppCompatActivity {

    ArrayList<String> listaPersonas = new ArrayList<>();
    RecyclerView recyclerPersonas;

    private void loadUI(){
        recyclerPersonas = findViewById(R.id.reciclerPersonas);
    }

    //carga de datos en la base de datos
    private void cargaDatos(){
        listaPersonas.add("Jorge");
        listaPersonas.add("Maria");
        listaPersonas.add("Teresa");
        listaPersonas.add("Raul");
        listaPersonas.add("Juan");
        listaPersonas.add("Luis");
        listaPersonas.add("Fabricio");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler_views);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        this.loadUI();
        this.cargaDatos();
        recyclerPersonas.setLayoutManager(new LinearLayoutManager(this));
        AdapterDatos adaptador = new AdapterDatos(listaPersonas);
        recyclerPersonas.setAdapter(adaptador);
    }
}