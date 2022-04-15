package co.edu.upb.petdarapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;


public class VistaVacuna extends AppCompatActivity {

    private TextView lbnombre;
    private FirebaseDatabase db;
    private DatabaseReference db_reference;

    private void initFirebase(){
        FirebaseApp.initializeApp(this);
        db = FirebaseDatabase.getInstance();
        db_reference = db.getReference();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vacunas);
        lbnombre = findViewById(R.id.LB_nombre);

        initFirebase();

        Query qe = db_reference.child("Vacuna").orderByKey().limitToFirst(10);

        Button btn_Nav = findViewById(R.id.btn_nav);
        //Button btn_home = findViewById(R.id.btn_home);

        btn_Nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(VistaVacuna.this, VacunaNueva.class);
                startActivity(i);
            }
        });

        final FloatingActionButton actionhome = (FloatingActionButton) findViewById(R.id.btn_home);
        actionhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(VistaVacuna.this, MainActivity.class);
                startActivity(in);
            }
        });
    }

}