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

public class eliminarDocenteAct extends AppCompatActivity {

    TextView modDatos;
    Typeface quan;
    Button elim;
    EditText reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_docente);

        Toast.makeText(eliminarDocenteAct.this,"RELLENAR TODOS LOS CAMPOS",Toast.LENGTH_LONG).show();
        String fuente = "fuentes/quantify.ttf";
        this.quan = Typeface.createFromAsset(getAssets(),fuente);
        modDatos = (TextView) findViewById(R.id.txtV_EliminarDocente);
        modDatos.setTypeface(quan);

        elim = (Button) findViewById(R.id.btn_EliminaDocAction);
        reg = (EditText) findViewById(R.id.etxt_registroEliminarD);
        elim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://192.168.1.66:8081/chat/deletedocente.php?usu="+ reg.getText().toString();
                final Intent iniciarDocente = new Intent(eliminarDocenteAct.this,Admin1Act.class);
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
                                                    Toast.makeText(eliminarDocenteAct.this,"Docente Eliminado",Toast.LENGTH_SHORT).show();
                                                    break;
                                                case "NO":
                                                    Toast.makeText(eliminarDocenteAct.this,"Docente no existe",Toast.LENGTH_SHORT).show();
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
                                Toast.makeText(eliminarDocenteAct.this,"Error php",Toast.LENGTH_SHORT).show();
                            }
                        });
                RequestQueue x = Volley.newRequestQueue(eliminarDocenteAct.this);
                x.add(peticion);
            }
        });

    }
}
