package org.example.model;

import java.time.LocalDate;

/**
 * Autor de uno o varios libros de la biblioteca.
 *
 * @author Eva Gallardo Romero
 * @version 1.0
 */
public class Autor {

    /** Identificador del autor. Lo asigna la biblioteca al añadirlo. */
    private int id;
    /** Nombre y apellidos. */
    private String nombreApell;
    /** Nacionalidad. */
    private String nacionalidad;
    /** Fecha de nacimiento. */
    private LocalDate fechaNac;
    /** Fecha de fallecimiento, o {@code null} si vive. */
    private LocalDate fechaFall;

    /**
     * Crea un autor.
     *
     * @param nombreApell  nombre y apellidos
     * @param nacionalidad nacionalidad
     * @param fechaNac     fecha de nacimiento
     * @param fechaFall    fecha de fallecimiento, o {@code null} si vive
     */
    public Autor(String nombreApell, String nacionalidad, LocalDate fechaNac, LocalDate fechaFall) {
        this.nombreApell = nombreApell;
        this.nacionalidad = nacionalidad;
        this.fechaNac = fechaNac;
        this.fechaFall = fechaFall;
    }

    /**
     * Devuelve el identificador.
     *
     * @return el identificador
     */
    public int getId() { return id; }

    /**
     * Cambia el identificador.
     *
     * @param id el nuevo identificador
     */
    public void setId(int id) { this.id = id; }

    /**
     * Devuelve el nombre y apellidos.
     *
     * @return el nombre y apellidos
     */
    public String getNombreApell() { return nombreApell; }

    /**
     * Cambia el nombre y apellidos.
     *
     * @param nombreApell el nuevo nombre y apellidos
     */
    public void setNombreApell(String nombreApell) { this.nombreApell = nombreApell; }

    /**
     * Devuelve la nacionalidad.
     *
     * @return la nacionalidad
     */
    public String getNacionalidad() { return nacionalidad; }

    /**
     * Cambia la nacionalidad.
     *
     * @param nacionalidad la nueva nacionalidad
     */
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }

    /**
     * Devuelve la fecha de nacimiento.
     *
     * @return la fecha de nacimiento
     */
    public LocalDate getFechaNac() { return fechaNac; }

    /**
     * Cambia la fecha de nacimiento.
     *
     * @param fechaNac la nueva fecha de nacimiento
     */
    public void setFechaNac(LocalDate fechaNac) { this.fechaNac = fechaNac; }

    /**
     * Devuelve la fecha de fallecimiento.
     *
     * @return la fecha de fallecimiento, o {@code null} si vive
     */
    public LocalDate getFechaFall() { return fechaFall; }

    /**
     * Cambia la fecha de fallecimiento.
     *
     * @param fechaFall la nueva fecha de fallecimiento
     */
    public void setFechaFall(LocalDate fechaFall) { this.fechaFall = fechaFall; }

    /**
     * Devuelve el nombre del autor. Es lo que se ve en los desplegables.
     *
     * @return el nombre y apellidos
     */
    @Override
    public String toString() {
        return nombreApell;
    }
}
