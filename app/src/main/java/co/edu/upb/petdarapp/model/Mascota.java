package co.edu.upb.petdarapp.model;

public class Mascota {
    private String nombre;
    private String especie;

    public Mascota(String nombre, String especie) {
        this.nombre = nombre;
        this.especie = especie;
    }

    public Mascota(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
}
