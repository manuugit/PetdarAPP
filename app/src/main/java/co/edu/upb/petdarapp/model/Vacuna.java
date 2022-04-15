package co.edu.upb.petdarapp.model;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;

import androidx.annotation.RequiresApi;

import java.util.Date;
import java.util.UUID;

public class Vacuna {
    public String id;
    public Mascota mascota;
    public String fecha;
    public String nombre;
    public String vacunador;
    public String proxima_fecha;

    public Vacuna() {

    }

    public Vacuna(String id, Mascota mascota, String fecha, String nombre, String vacunador, String proxima_fecha) {
        this.id = id;
        this.mascota = mascota;
        this.fecha = fecha;
        this.nombre = nombre;
        this.vacunador = vacunador;
        this.proxima_fecha = proxima_fecha;
    }

    public String getId() {
        return id;
    }

    public void setId() {
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVacunador() {
        return vacunador;
    }

    public void setVacunador(String vacunador) {
        this.vacunador = vacunador;
    }

    public String getProxima_fecha() {
        return proxima_fecha;
    }

    public void setProxima_fecha(String proxima_fecha) {
        this.proxima_fecha = proxima_fecha;
    }

    @Override
    public String toString() {
        return "Vacuna{" + ", fecha='" + fecha + '\'' +
                ", nombre='" + nombre + '\'' +
                ", vacunador='" + vacunador + '\'' +
                ", proxima_fecha='" + proxima_fecha + '\'' +
                '}';
    }
}

