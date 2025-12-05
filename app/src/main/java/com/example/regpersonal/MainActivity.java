package com.example.regpersonal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    Button btnConsultar, btnGuardar;
    EditText txtDni, txtNombre, txtCorreo, txtCelular;
    CheckBox chkCasa, chkDepa, chkAuto;
    RadioButton rbMujer, rbHombre;
    private static String editSexo = "";
    private static String editPropiedades = "";
    Spinner spinner;
    RequestQueue requestQueue;
    private static final String urlServidor = "192.168.56.1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        requestQueue = Volley.newRequestQueue(this);


        btnConsultar = findViewById(R.id.btnConsultar);
        btnGuardar = findViewById(R.id.btnGuardar);
        txtDni = findViewById(R.id.txtDni);
        txtNombre = findViewById(R.id.txtNombre);
        txtCorreo = findViewById(R.id.txtCorreo);
        txtCelular = findViewById(R.id.txtCelular);
        chkCasa = findViewById(R.id.chkCasaPropia);
        chkDepa = findViewById(R.id.chkDepa);
        chkAuto = findViewById(R.id.chkAuto);
        rbMujer = findViewById(R.id.rbMujer);
        rbHombre = findViewById(R.id.rbHombre);

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ConsultarActivity.class);
                startActivity(i);
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



    }

    public void Enviar(View view) {
        if(chkCasa.isChecked()){
            editPropiedades="Casa";
        }
        if(chkAuto.isChecked()){
            editPropiedades="Auto";
        }
        if(chkDepa.isChecked()){
            editPropiedades="Depa";
        }
        if(rbMujer.isChecked()){
            editSexo="Femenino";
        }
        if(rbHombre.isChecked()){
            editSexo="Masculino";
        }
        StringRequest stringRequest
                = new StringRequest(
                Request.Method.POST, urlServidor,
                new Response.Listener() {
                    @Override
                    public void onResponse(String response)
                    {
                        Toast.makeText(MainActivity.this,"Clientes Ingresados Exitosamente",Toast.LENGTH_SHORT).show();
                        txtDni.setText("");
                        txtNombre.setText("");
                        txtCorreo.setText("");
                        txtCelular.setText("");
                        chkCasa.setChecked(false);
                        chkDepa.setChecked(false);
                        chkAuto.setChecked(false);
                        spinner.setSelection(0);
                        rbHombre.setChecked(false);
                        rbMujer.setChecked(false);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {

                    }
                });
        requestQueue.add(stringRequest);
    }


}