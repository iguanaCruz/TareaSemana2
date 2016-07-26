package com.mcruz.tareasemana2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.EventLogTags;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Datos_contacto extends AppCompatActivity {

    Button boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_contacto);

        Bundle parametros = getIntent().getExtras();
        final String nombre = parametros.getString(getResources().getString(R.string.intent_nombre));
        final String telefono = parametros.getString(getResources().getString(R.string.intent_tel));
        final String email = parametros.getString(getResources().getString(R.string.intent_email));
        final String descripcion = parametros.getString(getResources().getString(R.string.intent_descripcion));
        final String dia = parametros.getString(getResources().getString(R.string.intent_dia));
        final String mes = parametros.getString(getResources().getString(R.string.intent_mes));
        final String anio = parametros.getString(getResources().getString(R.string.intent_anio));

        ((TextView) findViewById(R.id.tvnombre)).setText(nombre);
        ((TextView) findViewById(R.id.tvfecha)).setText("Fecha Nacimiento: "+dia+"/"+mes+"/"+anio);
        ((TextView) findViewById(R.id.tvtelefono)).setText("Tel. " + telefono);
        ((TextView) findViewById(R.id.tvemail)).setText("Email: " + email);
        ((TextView) findViewById(R.id.tvdescripcion)).setText("Descripcion: "+ descripcion);

        boton = (Button)findViewById(R.id.btnBack);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Datos_contacto.this, MainActivity.class);
                intent.putExtra(getResources().getString(R.string.intent_nombre), nombre);
                intent.putExtra(getResources().getString(R.string.intent_email),email);
                intent.putExtra(getResources().getString(R.string.intent_tel), telefono);
                intent.putExtra(getResources().getString(R.string.intent_descripcion), descripcion);
                intent.putExtra(getResources().getString(R.string.intent_dia), dia);
                intent.putExtra(getResources().getString(R.string.intent_mes), mes);
                intent.putExtra(getResources().getString(R.string.intent_anio), anio);
                startActivity(intent);
                finish();

            }
        });


        //Toast.makeText(getBaseContext(), nombre +" "+ telefono +" "+ email +" "+ descripcion, Toast.LENGTH_SHORT).show();


    }
}
