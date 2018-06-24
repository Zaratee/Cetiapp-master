package com.example.zarate.proyecto;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class crearAlumnoAct extends AppCompatActivity {

    Spinner spincarrera;
    ArrayAdapter<CharSequence> adaptcarrera;
    TextView modDatos;
    Typeface quan;
    EditText nom,apep,apem,reg,contra;
    Button btn_crear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_alumno);

        spincarrera = (Spinner) findViewById(R.id.spin_Carrera);
        adaptcarrera = ArrayAdapter.createFromResource(this,R.array.carreras,android.R.layout.simple_spinner_item);
        adaptcarrera.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spincarrera.setAdapter(adaptcarrera);



        String fuente = "fuentes/quantify.ttf";
        this.quan = Typeface.createFromAsset(getAssets(),fuente);
        modDatos = (TextView) findViewById(R.id.txtV_CrearAlumno);
        modDatos.setTypeface(quan);

        nom = (EditText) findViewById(R.id.etxt_nombreCrearAlumno);
        apep = (EditText) findViewById(R.id.etxt_apellidoPCrearAlumno);
        apem = (EditText) findViewById(R.id.etxt_apellidoMCrearAlumno);
        reg = (EditText) findViewById(R.id.etxt_registroCrearAlumno);
        contra = (EditText) findViewById(R.id.etxt_contraseñaCrearAlumno);
        btn_crear = (Button) findViewById(R.id.btn_adminCrearAlumno);

        Toast.makeText(crearAlumnoAct.this,"RELLENAR TODOS LOS CAMPOS",Toast.LENGTH_LONG).show();

        btn_crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://192.168.1.66:8081/chat/crearalumno.php?reg="+ reg.getText().toString()+"&cont="+ contra.getText().toString()+"&nom="+ nom.getText().toString()+"&apell_p="+ apep.getText().toString()+"&apell_m="+ apem.getText().toString()+"&link=12&carr=127";
                final Intent iniciarDocente = new Intent(crearAlumnoAct.this,Admin1Act.class);
                JsonObjectRequest peticion = new JsonObjectRequest
                        (
                                Request.Method.GET,
                                url,
                                null,
                                new Response.Listener<JSONObject>() {
                                    @Override
                                    public void onResponse(JSONObject response) {
                                        try {
                                            String valor = response.getString("Estado");
                                            switch(valor) {

                                                case "true":
                                                    startActivity(iniciarDocente);
                                                    Toast.makeText(crearAlumnoAct.this,"Alumno Creado",Toast.LENGTH_SHORT).show();
                                                    break;
                                            }


                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                                , new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error)
                            {
                                Toast.makeText(crearAlumnoAct.this,"Error docente no creado",Toast.LENGTH_SHORT).show();
                            }
                        });
                RequestQueue x = Volley.newRequestQueue(crearAlumnoAct.this);
                x.add(peticion);
            }
        });
    }
}
