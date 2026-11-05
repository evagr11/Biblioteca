package org.example.model;

/**
 * Tipos de encuadernación que puede tener un libro.
 *
 * @author Eva Gallardo Romero
 * @version 1.0
 */
public enum TipoLibro {
    /** Libro de bolsillo. */
    BOLSILLO("bolsillo"),
    /** Libro de tapa blanda. */
    TAPA_BLANDA("tapa blanda"),
    /** Libro de tapa dura. */
    TAPA_DURA("tapa dura");

    /** Texto que se muestra en la aplicación. */
    private String texto;

    /**
     * Crea un tipo de libro.
     *
     * @param texto texto que se muestra en la aplicación
     */
    TipoLibro(String texto) {
        this.texto = texto;
    }

    /**
     * Devuelve el texto del tipo, por ejemplo "tapa blanda".
     *
     * @return el texto del tipo
     */
    @Override
    public String toString() {
        return texto;
    }
}
