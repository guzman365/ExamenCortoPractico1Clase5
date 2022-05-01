package com.example.examenpractico1ulisesguzman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button enviar;
    TextView nombre, apellido, direccion, telefono, sueldo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enviar = findViewById(R.id.btnEnviar);
        nombre = findViewById(R.id.txtNombre);
        apellido = findViewById(R.id.txtApellido);
        direccion = findViewById(R.id.txtDireccion);
        telefono = findViewById(R.id.txtTelefono);
        sueldo = findViewById(R.id.txtSueldoBase);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent actRecibir = new Intent(MainActivity.this, MostrarInformacion.class );
                actRecibir.putExtra("nombre",nombre.getText().toString());
                actRecibir.putExtra("apellido",apellido.getText().toString());
                actRecibir.putExtra("direccion",direccion.getText().toString());
                actRecibir.putExtra("telefono",telefono.getText().toString());
                actRecibir.putExtra("sueldo",sueldo.getText().toString());

                startActivity(actRecibir);
            }
        });
    }
}