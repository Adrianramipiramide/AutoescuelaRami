package org.example;

import java.time.LocalDate;


public class Alumno extends Persona {
    LocalDate fechaNacimiento;

    public Alumno(int id, String nombre, String apellido, String telefono, LocalDate fechaNacimiento) {
        super(id, nombre, apellido, telefono);
        this.fechaNacimiento = fechaNacimiento;
    }

    public Alumno(int id, String nombre, String apellido, String telefono ) {
        super(id, nombre, apellido, telefono);

    }


}
