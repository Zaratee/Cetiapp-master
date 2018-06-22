package com.example.zarate.proyecto;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class eliminarAlumnAct extends AppCompatActivity {

    TextView modDatos;
    Typeface quan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_alumn);

        String fuente = "fuentes/quantify.ttf";
        this.quan = Typeface.createFromAsset(getAssets(),fuente);
        modDatos = (TextView) findViewById(R.id.txtV_EliminarAlumno);
        modDatos.setTypeface(quan);
    }
}
