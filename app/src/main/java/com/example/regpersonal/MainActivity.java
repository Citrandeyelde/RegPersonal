package com.example.regpersonal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
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
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button btnConsultar, btnGuardar;
    FirebaseFirestore db;
    EditText txtDni, txtNombre, txtCorreo, txtCelular, txtSexo, txtPropiedades, txtDistrito;
    CheckBox chkCasa, chkDepa, chkAuto;
    RadioButton rbMujer, rbHombre;
    Spinner spinner;
    private static String editSexo = "";
    private static String editPropiedades = "";

    private static final String urlServidor = "192.168.56.1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        FirebaseApp.initializeApp(this);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);

        // CARGAR DATOS DEL SPINNER (AQUÍ SÍ FUNCIONA)
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.srtDistritos,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);



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

        btnConsultar.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, ConsultarActivity.class);
            startActivity(i);
        });
    }


    public void Enviar(View view) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        String sexo = rbHombre.isChecked() ? "Masculino" : "Femenino";

        String propiedades = "";
        if (chkAuto.isChecked()) propiedades += "Auto ";
        if (chkCasa.isChecked()) propiedades += "Casa Propia ";
        if (chkDepa.isChecked()) propiedades += "Departamento";

        // Mapa de datos
        Map<String, Object> cliente = new HashMap<>();
        cliente.put("documento", txtDni.getText().toString().trim());
        cliente.put("nombres", txtNombre.getText().toString().trim());
        cliente.put("correo", txtCorreo.getText().toString().trim());
        cliente.put("celular", txtCelular.getText().toString().trim());
        cliente.put("distrito", spinner.getSelectedItem().toString());
        cliente.put("sexo", sexo);
        cliente.put("propiedades", propiedades.trim());

        // Guardar en Firestore
        db.collection("clientes")
                .document(txtDni.getText().toString().trim())
                .set(cliente)
                .addOnSuccessListener(aVoid -> {
                    Toast.makeText(MainActivity.this,
                            "Cliente Guardado en Firestore",
                            Toast.LENGTH_SHORT).show();
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(MainActivity.this,
                            "Error: " + e.getMessage(),
                            Toast.LENGTH_LONG).show();
                });
    }



}