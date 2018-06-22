package com.example.zarate.proyecto;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class crearAlumnoAct extends AppCompatActivity {

    Spinner spincarrera,spinsemestre,spingrupo;
    ArrayAdapter<CharSequence> adaptcarrera,adaptsemestre,adaptgrupo;
    TextView modDatos;
    Typeface quan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_alumno);

        spincarrera = (Spinner) findViewById(R.id.spin_Carrera);
        adaptcarrera = ArrayAdapter.createFromResource(this,R.array.carreras,android.R.layout.simple_spinner_item);
        adaptcarrera.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spincarrera.setAdapter(adaptcarrera);

        spinsemestre = (Spinner) findViewById(R.id.spin_Semestre);
        adaptsemestre = ArrayAdapter.createFromResource(this,R.array.semestre,android.R.layout.simple_spinner_item);
        adaptsemestre.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinsemestre.setAdapter(adaptsemestre);

        spingrupo = (Spinner) findViewById(R.id.spin_Grupo);
        adaptgrupo = ArrayAdapter.createFromResource(this,R.array.grupo,android.R.layout.simple_spinner_item);
        adaptgrupo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spingrupo.setAdapter(adaptgrupo);


        String fuente = "fuentes/quantify.ttf";
        this.quan = Typeface.createFromAsset(getAssets(),fuente);

        modDatos = (TextView) findViewById(R.id.txtV_CrearAlumno);
        modDatos.setTypeface(quan);
    }
}
