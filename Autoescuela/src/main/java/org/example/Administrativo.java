package org.example;

public class Administrativo extends Persona{

    private double salario;

    public Administrativo(int id, String nombre, String apellido, String telefono, double salario) {
        super(id, nombre, apellido, telefono);
        this.salario = salario;
    }
}
