package co.edu.upb.petdarapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Locale;
import java.util.UUID;
import co.edu.upb.petdarapp.model.Mascota;
import co.edu.upb.petdarapp.model.Vacuna;

public class VacunaNueva extends AppCompatActivity {

    private EditText txbmasc, txbesp, txbf, txbproxf, txbvac, txbvacunador;
    private Button btn_av;
    private FirebaseDatabase db;
    private DatabaseReference db_reference;
    private int year, month, day;
    private int sw=0;

    private void initFirebase(){
        FirebaseApp.initializeApp(this);
        db = FirebaseDatabase.getInstance();
        db_reference = db.getReference();
    }

    private void validation(String n, String e, String f, String v, String vac, String p) {
        if (n.equals(""))
            txbmasc.setError("Required");
        else if (e.equals(""))
            txbesp.setError("Required");
        else if (f.equals(""))
            txbf.setError("Required");
        else if (v.equals(""))
            txbvac.setError("Required");
        else if(vac.equals(""))
            txbvacunador.setError("Required");
        else if (p.equals(""))
            txbproxf.setError("Required");
    }

    private void limpiar(){
        txbmasc.setText("");
        txbesp.setText("");
        txbf.setText("");
        txbvac.setText("");
        txbvacunador.setText("");
        txbproxf.setText("");

    }

    //creamos un listener del datepicker
    private DatePickerDialog.OnDateSetListener listenerDeDatePicker = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int a, int mes, int diaDelMes) {
            // Esto se llama cuando seleccionan una fecha. Nos pasa la vista, pero más importante, nos pasa:
            // El año, el mes y el día del mes.

            // Refrescamos las globales
            year = a;
            month = mes;
            day = diaDelMes;

            // Y refrescamos la fecha
            refrescarFechaEnEditText(sw);
            sw++;
        }
    };

    public void generarFechaActual(){
        final Calendar calendario = Calendar.getInstance();
        year = calendario.get(Calendar.YEAR);
        month = calendario.get(Calendar.MONTH);
        day = calendario.get(Calendar.DAY_OF_MONTH);
    }

    public void refrescarFechaEnEditText(int indicador) {
        // Formateamos la fecha
        String fecha = String.format(Locale.getDefault(), "%02d/%02d/%02d", day, month+1, year);

        // La ponemos en el editText
        if( sw ==0)
            txbf.setText(fecha);
        else txbproxf.setText(fecha);
    }

    public void mostrarDatePicker(EditText element){   // Mostrar el datepicker cuando toquen el EditText
        element.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {  // Aquí es cuando dan click así que mostramos el DatePicker
                // Le pasamos lo que haya en las globales
                DatePickerDialog dialogoFecha = new DatePickerDialog(VacunaNueva.this, listenerDeDatePicker, year, month, day);
                //Mostrar
                dialogoFecha.show();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vacuna_nueva);
        btn_av = findViewById(R.id.btn_agregarV);
        Toast.makeText(getApplicationContext(), ":)", Toast.LENGTH_SHORT).show();

        txbmasc = findViewById(R.id.txb_nombre_mascota);
        txbesp = findViewById(R.id.txb_especie);
        txbf = findViewById(R.id.txb_fecha_vacuna);
        txbvac = findViewById(R.id.txb_vacuna);
        txbvacunador = findViewById(R.id.txb_vacunador);
        txbproxf = findViewById(R.id.txb_prox_fecha);

        //para el ingreso de fechas con el datepicker
        generarFechaActual();
        mostrarDatePicker(txbf);
        mostrarDatePicker(txbproxf);

        initFirebase();

        //agregar datos a firebase
        btn_av.setOnClickListener(v -> {
            //Captura de datos ingresados
            String nombre = txbmasc.getText().toString();
            String especie = txbesp.getText().toString();
            String fecha = txbf.getText().toString();
            String vacuna = txbvac.getText().toString();
            String vacunador = txbvacunador.getText().toString();
            String prox = txbproxf.getText().toString();

            if (nombre.equals("") || especie.equals("") || fecha.equals("") || vacuna.equals("")
                    || vacunador.equals("") || prox.equals("")) {
                validation(nombre, especie, fecha, vacuna, vacunador, prox);
            }
            else{
                Mascota m = new Mascota(nombre, especie);
                Vacuna vacuna_nueva = new Vacuna(UUID.randomUUID(),m, fecha,vacuna, vacunador, prox );
                db_reference.child("Vacuna").child(vacuna_nueva.getUid().toString()).setValue(vacuna_nueva);
                Toast.makeText(getApplicationContext(), "Se agregó la vacuna", Toast.LENGTH_SHORT).show();
                limpiar();
            }

        });

        final FloatingActionButton actionhome = (FloatingActionButton) findViewById(R.id.btn_home2);
        actionhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(VacunaNueva.this, MainActivity.class);
                startActivity(in);
            }
        });
    }
}