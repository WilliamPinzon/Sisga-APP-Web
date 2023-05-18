package com.registro.usuarios.modelo;

public enum Facultad {
    INGENIERIA("Facultad de Ingenierias"),
    CIENCIAS("Facultad de Ciencias Economicas, Administrativas y Contables"),
    DERECHO("Facultad de Derecho"),
    EDUCACION("Facultad de Educación"),
    ENFERMERIA("Facultad de Enfermeria"),
    MEDICINA("Facultad de Medicina y Zootecnia"),
    PSICOLOGIA("Facultad de Psicologia");

    private String nombre;

    Facultad(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}





