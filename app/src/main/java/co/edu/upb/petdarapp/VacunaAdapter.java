package co.edu.upb.petdarapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import co.edu.upb.petdarapp.model.Vacuna;

public class VacunaAdapter extends RecyclerView.Adapter<VacunaAdapter.MyViewHolder> {

    Context context;
    ArrayList<Vacuna> list;

    public VacunaAdapter(Context context, ArrayList<Vacuna> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.cita,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Vacuna vac = list.get(position);
        holder.nombre.setText(vac.getNombre());
        holder.vacunador.setText(vac.getVacunador());
        holder.fecha.setText(vac.getFecha());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nombre, vacunador, fecha;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            nombre = itemView.findViewById(R.id.vacNombre);
            vacunador = itemView.findViewById(R.id.vacVacunador);
            fecha = itemView.findViewById(R.id.vacFecha);
        }
    }

}
