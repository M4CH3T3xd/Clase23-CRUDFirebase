package com.example.crudfirenase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Agregar extends AppCompatActivity {

    EditText nombre, apellido, email, imgUrl;
    Button btnAdd, btnAtras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        nombre = findViewById(R.id.nombreText);
        apellido = findViewById(R.id.apellidoText);
        email = findViewById(R.id.emailText);
        imgUrl = findViewById(R.id.img1);

        btnAdd = findViewById(R.id.btn_agregar);
        btnAtras = findViewById(R.id.btn_atras);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (camposValidos()) {
                    insertarDatos();
                } else {
                    Toast.makeText(Agregar.this, "Completa todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    // Hay un error que al agregar datos vacios a la base de datos y despues darle a borrar se borran los demas
    // asi que este metodo evita eso
    private boolean camposValidos() {
        return !TextUtils.isEmpty(nombre.getText().toString())
                && !TextUtils.isEmpty(apellido.getText().toString())
                && !TextUtils.isEmpty(email.getText().toString())
                && !TextUtils.isEmpty(imgUrl.getText().toString());
    }

    private void insertarDatos() {
        Map<String, Object> map = new HashMap<>();
        map.put("Nombre", nombre.getText().toString());
        map.put("Apellido", apellido.getText().toString());
        map.put("email", email.getText().toString());
        map.put("imgUrl", imgUrl.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("Programación Android").push()
                .setValue(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(Agregar.this, "Insertado Correctamente", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Agregar.this, "Error al Insertar", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}