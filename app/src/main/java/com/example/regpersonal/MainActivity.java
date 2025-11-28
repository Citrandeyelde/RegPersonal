package com.example.regpersonal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnConsultar, btnGuardar;
    EditText txtDni,txtNombre,txtCorreo,txtCelular;
    CheckBox chkCasa,chkDepa,chkAuto;
    RadioButton rbMujer,rbHombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btnConsultar=findViewById(R.id.btnConsultar);
        btnGuardar=findViewById(R.id.btnGuardar);
        txtDni=findViewById(R.id.txtDni);
        txtNombre=findViewById(R.id.txtNombre);
        txtCorreo=findViewById(R.id.txtCorreo);
        txtCelular=findViewById(R.id.txtCelular);
        chkCasa=findViewById(R.id.chkCasaPropia);
        chkDepa=findViewById(R.id.chkDepa);
        chkAuto=findViewById(R.id.chkAuto);
        rbMujer=findViewById(R.id.rbMujer);
        rbHombre=findViewById(R.id.rbHombre);

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}