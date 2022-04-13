package co.edu.upb.petdarapp.model;

import java.util.Date;
import java.util.UUID;

public class Vacuna {
    private UUID uid;
    private Mascota mascota;
    private String fecha;
    private String nombre;
    private String vacunador;
    private String proxima_fecha;

    public Vacuna(UUID uid, Mascota mascota, String fecha, String nombre, String vacunador, String proxima_fecha) {
        this.uid = uid;
        this.mascota = mascota;
        this.fecha = fecha;
        this.nombre = nombre;
        this.vacunador = vacunador;
        this.proxima_fecha = proxima_fecha;
    }

    public Vacuna() {
    }

    public UUID getUid() {
        return uid;
    }

    public void setUid(UUID uid) {
        this.uid = uid;
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

