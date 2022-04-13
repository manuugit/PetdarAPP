package co.edu.upb.petdarapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class VistaVacuna extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vacunas);

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