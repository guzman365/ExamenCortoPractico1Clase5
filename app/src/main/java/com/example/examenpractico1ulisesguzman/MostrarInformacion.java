package com.example.examenpractico1ulisesguzman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MostrarInformacion extends AppCompatActivity {
    Button btnRegresar, btnSalir;
    TextView nombre2, apellido2, direccion2, telefono2, sueldo2;
    String nombreSend=null, apellidoSend=null, direccionSend=null, telefonoSend=null, sueldoSend=null;
    double sueldoNeto=0, sueldoBase=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_informacion);

        btnRegresar = findViewById(R.id.btnRegresar);
        btnSalir = findViewById(R.id.btnSalir);

        nombre2 = findViewById(R.id.txtRecibirNombre);
        apellido2 = findViewById(R.id.txtRecibirApellido);
        direccion2 = findViewById(R.id.txtRecibirDireccion);
        telefono2 = findViewById(R.id.txtRecibirTelefono);
        sueldo2 = findViewById(R.id.txtMostrarSueldo);

        Bundle bundle = getIntent().getExtras();

        nombreSend = bundle.getString("nombre");
        apellidoSend = bundle.getString("apellido");
        direccionSend = bundle.getString("direccion");
        telefonoSend = bundle.getString("telefono");
        sueldoSend = bundle.getString("sueldo");

        nombre2.setText(nombreSend);
        apellido2.setText(apellidoSend);
        direccion2.setText(direccionSend);
        telefono2.setText(telefonoSend);

        sueldoNeto=Double.parseDouble(sueldoSend);
        sueldoBase=sueldoNeto;
        sueldoNeto=sueldoNeto - sueldoNeto*0.1 - sueldoNeto*0.0625 - sueldoNeto*0.03;
        if(sueldoBase<500){
            sueldoNeto=sueldoNeto+100;
        }

        sueldo2.setText(String.valueOf(sueldoNeto));

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent act2 = new Intent(MostrarInformacion.this, MainActivity.class);
                startActivity(act2);
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}