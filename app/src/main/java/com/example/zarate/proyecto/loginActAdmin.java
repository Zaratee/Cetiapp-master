package com.example.zarate.proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class loginActAdmin extends AppCompatActivity {
    Button login;
    EditText usu,contr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_act_admin);
        login = (Button) findViewById(R.id.btn_ingresarAdmin);
        usu = (EditText) findViewById(R.id.etxt_liUsuarioAdmin);
        contr = (EditText) findViewById(R.id.etxt_liContraseñaAdmin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://192.168.1.66:8081/appceti/loginadmin.php?usu="+ usu.getText().toString()+"&cont="+contr.getText().toString();
                final Intent iniciarAdmin = new Intent(loginActAdmin.this,Admin1Act.class);
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
                                                    startActivity(iniciarAdmin);
                                                    break;
                                                case "NO":
                                                    Toast.makeText(loginActAdmin.this,"Admin no existe",Toast.LENGTH_SHORT).show();
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
                                Toast.makeText(loginActAdmin.this,"Error php",Toast.LENGTH_SHORT).show();
                            }
                        });
                RequestQueue x = Volley.newRequestQueue(loginActAdmin.this);
                x.add(peticion);
            }

        });
    }
}
