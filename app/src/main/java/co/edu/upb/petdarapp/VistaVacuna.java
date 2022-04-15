package co.edu.upb.petdarapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import co.edu.upb.petdarapp.model.Vacuna;


public class VistaVacuna extends AppCompatActivity {

    private FirebaseDatabase db;
    private DatabaseReference db_reference;
    private RecyclerView recyclerView;
    private VacunaAdapter myAdapter;
    private ArrayList<Vacuna> list;

    private void initFirebase(){
        FirebaseApp.initializeApp(this);
        db = FirebaseDatabase.getInstance();
        db_reference = db.getReference();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vacunas);

        recyclerView = findViewById(R.id.lista_vacunas);
        //db_reference = FirebaseDatabase.getInstance().getReference("Vacuna");
        initFirebase();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        myAdapter = new VacunaAdapter(this,list);
        recyclerView.setAdapter(myAdapter);

        db_reference.addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    for(DataSnapshot ds : dataSnapshot.getChildren()){
                        Vacuna vac = ds.getValue(Vacuna.class);
                        list.add(vac);
                    }
                }
                myAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

        Button btn_Nav = findViewById(R.id.btn_nav);

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