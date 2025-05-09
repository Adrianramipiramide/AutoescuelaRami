package org.example;

public class Profesor extends Persona {
    private int yearsExperience;

    public Profesor(int id, String nombre, String apellido, String telefono, int yearsExperience) {
        super(id, nombre, apellido, telefono);
        this.yearsExperience = yearsExperience;
    }
}
