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

public class loginActDocent extends AppCompatActivity {

    Button login;
    EditText nom,contr;
    String res;
    String res2;
    TextView prueba;
    public static String Nombre = "Caros";
    public static String ApelliM = "Caro";
    public static String ApelliP = "Cargos";
    public static String Regis = "Caroffs";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_act_docent);

        login = (Button) findViewById(R.id.btn_ingresarDocente);
        nom = (EditText) findViewById(R.id.etxt_liUsuarioDoc);
        contr = (EditText) findViewById(R.id.etxt_liContraseñaDoc);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://192.168.1.66:8081/chat/logindocente.php?usu="+ nom.getText().toString()+"&cont="+contr.getText().toString();
                final Intent iniciarDocente = new Intent(loginActDocent.this,docente1stAct.class);
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
                                            String act = "DOS";

                                            switch(valor) {

                                                case "OK":
                                                    Nombre= response.getString("nom");
                                                    ApelliM = response.getString("apellim");
                                                    ApelliP = response.getString("apellip");
                                                    Regis = response.getString("reg");
                                                    MainActivity.ACT = act;
                                                    startActivity(iniciarDocente);
                                                    break;
                                                case "NO":
                                                    Toast.makeText(loginActDocent.this,"Docente no existe",Toast.LENGTH_SHORT).show();
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
                                Toast.makeText(loginActDocent.this,"Error php",Toast.LENGTH_SHORT).show();
                            }
                        });
                RequestQueue x = Volley.newRequestQueue(loginActDocent.this);
                x.add(peticion);
            }
        });
    }
}
