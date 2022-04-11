package co.edu.upb.petdarapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.UUID;
import co.edu.upb.petdarapp.model.Mascota;
import co.edu.upb.petdarapp.model.Vacuna;

public class Vacuna_nueva extends AppCompatActivity {

    EditText txbmasc, txbesp, txbf, txbproxf, txbvac, txbvacunador;
    Button btn_av = findViewById(R.id.btn_agregarV);
    FirebaseDatabase db;
    DatabaseReference db_reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vacuna_nueva);

        txbmasc = findViewById(R.id.txb_nombre_mascota);
        txbesp = findViewById(R.id.txb_especie);
        txbf = findViewById(R.id.txb_fecha_vacuna);
        txbvac = findViewById(R.id.txb_vacuna);
        txbvacunador = findViewById(R.id.txb_vacunador);
        txbproxf = findViewById(R.id.txb_prox_fecha);

        String nombre = txbmasc.getText().toString();
        String especie = txbesp.getText().toString();
        String fecha = txbf.getText().toString();
        String vacuna = txbvac.getText().toString();
        String vacunador = txbvacunador.getText().toString();
        String prox = txbproxf.getText().toString();
        initFirebase();

        btn_av.setOnClickListener(v -> {
            if (nombre.equals("") || especie.equals("") || fecha.equals("") || vacuna.equals("")
                    || vacunador.equals("") || prox.equals("")){
                validation(nombre, especie, fecha, vacuna, vacunador, prox);
            }
            else{
                Mascota m = new Mascota(nombre, especie);
                Vacuna vacuna_nueva = new Vacuna(UUID.randomUUID(),m, fecha,vacuna, vacunador, prox );
                db_reference.child("Vacuna").child(vacuna_nueva.getUid().toString()).setValue(vacuna_nueva);
                Toast.makeText(getApplicationContext(), "Agregado", Toast.LENGTH_SHORT).show();
                limpiar();
            }

        });
    }

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

}