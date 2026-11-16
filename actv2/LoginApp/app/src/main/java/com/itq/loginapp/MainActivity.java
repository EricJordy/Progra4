package com.itq.loginapp;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private EditText edtUsuario;
    private EditText edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Buscar las vistas del XML por su id
        edtUsuario = findViewById(R.id.edtUsuario);
        edtPassword = findViewById(R.id.edtPassword);
        Button btnIngresar = findViewById(R.id.btnIngresar);

        // 2. Evento del botón
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarLogin();
            }
        });
    }

    // 3. Validaciones sencillas (sin servidor, todo local)
    private void validarLogin() {
        String correo = edtUsuario.getText().toString().trim();
        String password = edtPassword.getText().toString();

        if (correo.isEmpty()) {
            edtUsuario.setError("Ingresa tu correo");
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            edtUsuario.setError("El correo no es válido");
            return;
        }
        if (password.isEmpty()) {
            edtPassword.setError("Ingresa tu contraseña");
            return;
        }
        if (password.length() < 6) {
            edtPassword.setError("Mínimo 6 caracteres");
            return;
        }

        // Si todo está bien, se muestra un mensaje de bienvenida
        Toast.makeText(this, "¡Bienvenido, " + correo + "!", Toast.LENGTH_LONG).show();
    }
}