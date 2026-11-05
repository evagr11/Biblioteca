package org.example.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Libro de la biblioteca.
 *
 * @author Eva Gallardo Romero
 * @version 1.0
 */
public class Libro {

    /** Identificador del libro. Lo asigna la biblioteca al añadirlo. */
    private int id;
    /** Título. */
    private String titulo;
    /** Autores del libro. */
    private List<Autor> autores = new ArrayList<>();
    /** Sitio de la casa donde está el libro. */
    private String ubicacion;
    /** Edición. */
    private String edicion;
    /** Número de páginas. */
    private int numPag;
    /** Sinopsis. */
    private String sinopsis;
    /** Tipo de encuadernación. */
    private TipoLibro tipo;
    /** Año de publicación. */
    private int anio;
    /** Idioma. */
    private String idioma;

    /**
     * Crea un libro.
     *
     * @param titulo    título
     * @param autores   autores del libro
     * @param ubicacion sitio de la casa donde está
     * @param edicion   edición
     * @param numPag    número de páginas
     * @param sinopsis  sinopsis
     * @param tipo      tipo de encuadernación
     * @param anio      año de publicación
     * @param idioma    idioma
     */
    public Libro(String titulo, List<Autor> autores, String ubicacion, String edicion,
                 int numPag, String sinopsis, TipoLibro tipo, int anio, String idioma) {
        this.titulo = titulo;
        this.autores = new ArrayList<>(autores);
        this.ubicacion = ubicacion;
        this.edicion = edicion;
        this.numPag = numPag;
        this.sinopsis = sinopsis;
        this.tipo = tipo;
        this.anio = anio;
        this.idioma = idioma;
    }

    /**
     * Devuelve los nombres de todos los autores separados por comas.
     *
     * @return los autores en un solo texto, por ejemplo "Autor 1, Autor 2"
     */
    public String getAutoresTexto() {
        String texto = "";
        for (int i = 0; i < autores.size(); i++) {
            if (i > 0) {
                texto = texto + ", ";
            }
            texto = texto + autores.get(i).getNombreApell();
        }
        return texto;
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
     * Devuelve el título.
     *
     * @return el título
     */
    public String getTitulo() { return titulo; }

    /**
     * Cambia el título.
     *
     * @param titulo el nuevo título
     */
    public void setTitulo(String titulo) { this.titulo = titulo; }

    /**
     * Devuelve los autores.
     *
     * @return la lista de autores
     */
    public List<Autor> getAutores() { return autores; }

    /**
     * Cambia los autores.
     *
     * @param autores la nueva lista de autores
     */
    public void setAutores(List<Autor> autores) { this.autores = new ArrayList<>(autores); }

    /**
     * Devuelve la ubicación.
     *
     * @return la ubicación
     */
    public String getUbicacion() { return ubicacion; }

    /**
     * Cambia la ubicación.
     *
     * @param ubicacion la nueva ubicación
     */
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    /**
     * Devuelve la edición.
     *
     * @return la edición
     */
    public String getEdicion() { return edicion; }

    /**
     * Cambia la edición.
     *
     * @param edicion la nueva edición
     */
    public void setEdicion(String edicion) { this.edicion = edicion; }

    /**
     * Devuelve el número de páginas.
     *
     * @return el número de páginas
     */
    public int getNumPag() { return numPag; }

    /**
     * Cambia el número de páginas.
     *
     * @param numPag el nuevo número de páginas
     */
    public void setNumPag(int numPag) { this.numPag = numPag; }

    /**
     * Devuelve la sinopsis.
     *
     * @return la sinopsis
     */
    public String getSinopsis() { return sinopsis; }

    /**
     * Cambia la sinopsis.
     *
     * @param sinopsis la nueva sinopsis
     */
    public void setSinopsis(String sinopsis) { this.sinopsis = sinopsis; }

    /**
     * Devuelve el tipo de encuadernación.
     *
     * @return el tipo
     */
    public TipoLibro getTipo() { return tipo; }

    /**
     * Cambia el tipo de encuadernación.
     *
     * @param tipo el nuevo tipo
     */
    public void setTipo(TipoLibro tipo) { this.tipo = tipo; }

    /**
     * Devuelve el año de publicación.
     *
     * @return el año
     */
    public int getAnio() { return anio; }

    /**
     * Cambia el año de publicación.
     *
     * @param anio el nuevo año
     */
    public void setAnio(int anio) { this.anio = anio; }

    /**
     * Devuelve el idioma.
     *
     * @return el idioma
     */
    public String getIdioma() { return idioma; }

    /**
     * Cambia el idioma.
     *
     * @param idioma el nuevo idioma
     */
    public void setIdioma(String idioma) { this.idioma = idioma; }

    /**
     * Devuelve el título y los autores. Es lo que se ve en las listas.
     *
     * @return el texto "título - autores"
     */
    @Override
    public String toString() {
        return titulo + " - " + getAutoresTexto();
    }
}
