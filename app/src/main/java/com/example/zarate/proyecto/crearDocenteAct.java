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

public class crearDocenteAct extends AppCompatActivity {

    TextView modDatos;
    Typeface quan;
    Button crear;
    EditText nomina,contra,nombre,apellidoP,apellidoM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_docente);


        String fuente = "fuentes/quantify.ttf";
        this.quan = Typeface.createFromAsset(getAssets(),fuente);

        modDatos = (TextView) findViewById(R.id.txtV_CrearDocente);
        modDatos.setTypeface(quan);

        nomina = (EditText) findViewById(R.id.etxt_nominaCrearDocente);
        contra = (EditText) findViewById(R.id.etxt_contraseñaCrearDocente);
        nombre = (EditText) findViewById(R.id.etxt_nombreCrearDocente);
        apellidoP = (EditText) findViewById(R.id.etxt_apellidoPCrearDocente);
        apellidoM = (EditText) findViewById(R.id.etxt_apellidoMCrearDocente);

        Toast.makeText(crearDocenteAct.this,"RELLENAR TODOS LOS CAMPOS",Toast.LENGTH_LONG).show();

        crear = (Button) findViewById(R.id.btn_adminCrearDocente);
        crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = "http://192.168.1.66:8081/chat/creardocente.php?nomi="+ nomina.getText().toString()+"&cont="+ contra.getText().toString()+"&nom="+ nombre.getText().toString()+"&apell_p="+ apellidoP.getText().toString()+"&apell_m="+ apellidoM.getText().toString();
                final Intent iniciarDocente = new Intent(crearDocenteAct.this,Admin1Act.class);
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

                                                case "OK":
                                                    startActivity(iniciarDocente);
                                                    Toast.makeText(crearDocenteAct.this,"Docente Creado",Toast.LENGTH_SHORT).show();
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
                                Toast.makeText(crearDocenteAct.this,"Error docente no creado",Toast.LENGTH_SHORT).show();
                            }
                        });
                RequestQueue x = Volley.newRequestQueue(crearDocenteAct.this);
                x.add(peticion);
            }
        });

    }
}
