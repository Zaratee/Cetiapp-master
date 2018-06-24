package com.example.zarate.proyecto;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class eliminarAlumnAct extends AppCompatActivity {

    TextView modDatos;
    Typeface quan;
    Button elim;
    EditText reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_alumn);

        Toast.makeText(eliminarAlumnAct.this,"RELLENAR TODOS LOS CAMPOS",Toast.LENGTH_LONG).show();

        String fuente = "fuentes/quantify.ttf";
        this.quan = Typeface.createFromAsset(getAssets(),fuente);
        modDatos = (TextView) findViewById(R.id.txtV_EliminarAlumno);
        modDatos.setTypeface(quan);

        elim = (Button) findViewById(R.id.btn_EliminaAlumnAction);
        reg = (EditText) findViewById(R.id.etxt_registroEliminarA);
        elim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://192.168.1.66:8081/chat/deletealumno.php?usu="+ reg.getText().toString();
                final Intent iniciarDocente = new Intent(eliminarAlumnAct.this,Admin1Act.class);
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
                                                    Toast.makeText(eliminarAlumnAct.this,"Alumno Eliminado",Toast.LENGTH_SHORT).show();
                                                    break;
                                                case "NO":
                                                    Toast.makeText(eliminarAlumnAct.this,"Alumno no existe",Toast.LENGTH_SHORT).show();
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
                                Toast.makeText(eliminarAlumnAct.this,"Error php",Toast.LENGTH_SHORT).show();
                            }
                        });
                RequestQueue x = Volley.newRequestQueue(eliminarAlumnAct.this);
                x.add(peticion);
            }
        });

    }
}
