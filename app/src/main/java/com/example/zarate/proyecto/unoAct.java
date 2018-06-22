package com.example.zarate.proyecto;

import android.content.Intent;
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

public class unoAct extends AppCompatActivity {


    Button ingresarbtn;
    EditText reg,contt;
    TextView prueba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uno);
        ingresarbtn = (Button) findViewById(R.id.btn_ingresarAlumno);
        reg = (EditText) findViewById(R.id.etxt_liUsuarioAlumn);
        contt = (EditText) findViewById(R.id.etxt_liContraseñaAlumn);

        ingresarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://192.168.1.66:8081/appceti/LoginAlumno.php?usu="+ reg.getText().toString()+"&cont="+contt.getText().toString();
                final Intent iniciarAlumno = new Intent(unoAct.this,alumno1stAct.class);
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
                                            prueba.setText(valor);
                                            switch(valor) {
                                                case "OK":
                                                    startActivity(iniciarAlumno);
                                                    break;
                                                case "NO":
                                                    Toast.makeText(unoAct.this,"Alumno no existe",Toast.LENGTH_SHORT).show();
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
                                Toast.makeText(unoAct.this,"Error php",Toast.LENGTH_SHORT).show();
                            }
                        });
                RequestQueue x = Volley.newRequestQueue(unoAct.this);
                x.add(peticion);
            }
        });
    }


}


