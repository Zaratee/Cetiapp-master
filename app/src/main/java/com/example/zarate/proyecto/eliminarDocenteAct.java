package com.example.zarate.proyecto;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class eliminarDocenteAct extends AppCompatActivity {

    TextView modDatos;
    Typeface quan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_docente);

        String fuente = "fuentes/quantify.ttf";
        this.quan = Typeface.createFromAsset(getAssets(),fuente);
        modDatos = (TextView) findViewById(R.id.txtV_EliminarDocente);
        modDatos.setTypeface(quan);
    }
}
