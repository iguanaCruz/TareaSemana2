package com.mcruz.tareasemana2;

import android.content.Intent;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatePicker datePicker;
    TextView txtNombre;
    TextView txtEmail;
    TextView txtTelefono;
    TextView txtDescripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMyBoton = (Button)findViewById(R.id.btnMiBoton);
        txtNombre = (TextView)findViewById(R.id.input_nombre);
        txtEmail = (TextView) findViewById(R.id.input_email);
        txtTelefono = (TextView) findViewById(R.id.input_telefono);
        txtDescripcion = (TextView)findViewById(R.id.input_descripcion);
        datePicker = (DatePicker)findViewById(R.id.datePicker);

        Bundle parametros = getIntent().getExtras();
        if (parametros != null) {
            String nombre = parametros.getString(getResources().getString(R.string.intent_nombre));
            String telefono = parametros.getString(getResources().getString(R.string.intent_tel));
            String email = parametros.getString(getResources().getString(R.string.intent_email));
            String descripcion = parametros.getString(getResources().getString(R.string.intent_descripcion));
            String dia = parametros.getString(getResources().getString(R.string.intent_dia));
            String mes = parametros.getString(getResources().getString(R.string.intent_mes));
            String anio = parametros.getString(getResources().getString(R.string.intent_anio));


            txtNombre.setText(nombre);
            txtTelefono.setText(telefono);
            txtEmail.setText(email);
            txtDescripcion.setText(descripcion);
            try {
                datePicker.updateDate(Integer.valueOf(anio), Integer.valueOf(mes), Integer.valueOf(dia));
            }
            catch (NumberFormatException n){
                System.out.println("Error: " + n.toString());
            }
        }



        btnMyBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int year = datePicker.getYear();
                int month = datePicker.getMonth();
                int day = datePicker.getDayOfMonth();

                Intent intent = new Intent(MainActivity.this, Datos_contacto.class);
                intent.putExtra(getResources().getString(R.string.intent_nombre), txtNombre.getText().toString());
                intent.putExtra(getResources().getString(R.string.intent_email), txtEmail.getText().toString());
                intent.putExtra(getResources().getString(R.string.intent_tel), txtTelefono.getText().toString());
                intent.putExtra(getResources().getString(R.string.intent_descripcion), txtDescripcion.getText().toString());
                intent.putExtra(getResources().getString(R.string.intent_dia), String.valueOf(day));
                intent.putExtra(getResources().getString(R.string.intent_mes), String.valueOf(month));
                intent.putExtra(getResources().getString(R.string.intent_anio), String.valueOf(year));

                if (validaCampos(txtNombre.getText().toString(), txtEmail.getText().toString(),
                        txtTelefono.getText().toString(), txtDescripcion.getText().toString())) {
                    startActivity(intent);
                    finish();
                } else
                    Toast.makeText(getBaseContext(), "Favor de llenar todos los campos", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private boolean validaCampos(String nom, String email, String tel, String desc){

        if(nom!=null && email!=null && tel!=null && desc!=null)
            if(!nom.equals("")&&!email.equals("")&&!tel.equals("")&&!desc.equals("")){
                return true;
            }
        return false;

    }
}
