package com.example.zarate.proyecto;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Admin1Act extends AppCompatActivity {

    Button crearAlum, crearDoc, elimAlum, elimDoc, actAlum, actDoc,salir;
    TextView modDatos;
    Typeface quan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin1);
        crearAlum = (Button) findViewById(R.id.btn_crearAlumno);
        crearDoc = (Button) findViewById(R.id.btn_crearDoce);
        elimAlum = (Button) findViewById(R.id.btn_elimAlumno);
        elimDoc =  (Button) findViewById(R.id.btn_elimDoce);
        actAlum =  (Button) findViewById(R.id.btn_actuaAlumno);
        actDoc = (Button) findViewById(R.id.btn_actuaDoc);
        salir = (Button) findViewById(R.id.btn_salirAdmin);

        crearAlum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent crearalumno = new Intent(Admin1Act.this,crearAlumnoAct.class);
                startActivity(crearalumno);
            }
        });

        crearDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent creardocente = new Intent(Admin1Act.this,crearDocenteAct.class);
                startActivity(creardocente);
            }
        });

        elimAlum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent eliminarAlumno = new Intent(Admin1Act.this, eliminarAlumnAct.class);
                startActivity(eliminarAlumno);
            }
        });

        elimDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent eliminarDocente = new Intent(Admin1Act.this, eliminarDocenteAct.class);
                startActivity(eliminarDocente);
            }
        });

        actAlum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actualizarAlumno = new Intent(Admin1Act.this, actualizarAlumnoAct.class);
                startActivity(actualizarAlumno);
            }
        });

        actDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actualizarDocente = new Intent(Admin1Act.this, actualizarDocenteAct.class);
                startActivity(actualizarDocente);
            }
        });
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent salir = new Intent(Admin1Act.this, MainActivity.class);
                startActivity(salir);
            }
        });

        String fuente = "fuentes/quantify.ttf";
        this.quan = Typeface.createFromAsset(getAssets(),fuente);

        modDatos = (TextView) findViewById(R.id.txtV_modificarDatos);
        modDatos.setTypeface(quan);

    }
}
