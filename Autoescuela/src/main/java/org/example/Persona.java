package org.example;

import java.util.ArrayList;

public abstract class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private String telefono;

    public static ArrayList<Persona> listaUsuarios = new ArrayList<>();

    public Persona(int id, String nombre, String apellido, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre= '" + nombre + '\'' +
                ", apellido= '" + apellido + '\'' +
                ", telefono= '" + telefono + '\'' +
                '}';
    }
}
