package com.example.regpersonal;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.firestore.FirebaseFirestore;

public class ConsultarActivity extends AppCompatActivity {
    FirebaseFirestore db;
    Button btnConsultar, btnGuardar;
    EditText txtDni, txtNombres, txtCelular, txtCorreo, txtSexo, txtPropiedades, txtDistrito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_consultar);
        //db=FirebaseFirestore.getInstance();
        txtNombres=findViewById(R.id.txtConsNombre);
        txtCorreo=findViewById(R.id.txtConsCorreo);
        txtCelular=findViewById(R.id.txtConsCelular);
        txtDni=findViewById(R.id.txtDocIdentidad);


    }
}