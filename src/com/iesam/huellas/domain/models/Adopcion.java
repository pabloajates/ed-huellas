package com.iesam.huellas.domain.models;

public class Adopcion {

    private String id;
    private String fechaAdopcion;
    private Animal animal;
    private Adoptante adoptante;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFechaAdopcion() {
        return fechaAdopcion;
    }

    public void setFechaAdopcion(String fechaAdopcion) {
        this.fechaAdopcion = fechaAdopcion;
    }

    public Animal getAnimal() {
        return animal;
    }

    public Adoptante getAdoptante() {
        return adoptante;
    }
}
