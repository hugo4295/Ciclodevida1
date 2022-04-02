package com.example.ciclodevida1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ciclodevida1.Modelo.ModeloSuma;

public class MainActivity extends AppCompatActivity {

    Button boton;
    TextView lblincremento,persistente;
    int incremento=0;

    ModeloSuma modeloSuma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        modeloSuma = new ViewModelProvider(this).get(ModeloSuma.class);

        persistente = findViewById(R.id.lblpersistente);
        lblincremento = findViewById(R.id.lblincremento);
        boton = findViewById(R.id.btnincrementa);

        persistente.setText( String.valueOf(modeloSuma.getNumero()));

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incremento = ClaseSuma.incrementar(incremento);
                lblincremento.setText( String.valueOf(incremento));
                modeloSuma.setNumero(ClaseSuma.incrementar(modeloSuma.getNumero()));
                persistente.setText(String.valueOf(modeloSuma.getNumero()));

            }
        });
    }
}