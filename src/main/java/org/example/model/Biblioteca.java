package org.example.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Modelo de la aplicación: guarda los libros y los autores en memoria
 * y tiene los métodos para añadirlos, eliminarlos y buscarlos.
 *
 * @author Eva Gallardo Romero
 * @version 1.0
 */
public class Biblioteca {

    /** Lista de libros. */
    private List<Libro> libros = new ArrayList<>();
    /** Lista de autores. */
    private List<Autor> autores = new ArrayList<>();
    /** Identificador que se dará al próximo libro. */
    private int siguienteIdLibro = 1;
    /** Identificador que se dará al próximo autor. */
    private int siguienteIdAutor = 1;

    /**
     * Crea una biblioteca vacía.
     */
    public Biblioteca() {
    }

    // LIBROS

    /**
     * Devuelve todos los libros.
     *
     * @return la lista de libros
     */
    public List<Libro> getLibros() {
        return libros;
    }

    /**
     * Añade un libro y le asigna un identificador.
     *
     * @param libro libro que se añade
     */
    public void anadirLibro(Libro libro) {
        libro.setId(siguienteIdLibro);
        siguienteIdLibro++;
        libros.add(libro);
    }

    /**
     * Elimina un libro.
     *
     * @param libro libro que se elimina
     */
    public void eliminarLibro(Libro libro) {
        libros.remove(libro);
    }

    /**
     * Busca los libros cuyo título o autores contienen un texto.
     * No distingue mayúsculas de minúsculas.
     *
     * @param texto texto que se busca
     * @return los libros que coinciden
     */
    public List<Libro> buscarLibros(String texto) {
        List<Libro> resultado = new ArrayList<>();
        String t = texto.toLowerCase();
        for (Libro libro : libros) {
            if (libro.getTitulo().toLowerCase().contains(t)
                    || libro.getAutoresTexto().toLowerCase().contains(t)) {
                resultado.add(libro);
            }
        }
        return resultado;
    }

    /**
     * Busca libros por texto y además los filtra por tipo e idioma.
     * Si un filtro está vacío o vale "Todos", no se filtra por él.
     *
     * @param texto  texto que se busca en el título o los autores
     * @param tipo   tipo de libro, "Todos" o {@code null}
     * @param idioma idioma, "Todos" o {@code null}
     * @return los libros que cumplen las tres condiciones
     */
    public List<Libro> filtrarLibros(String texto, String tipo, String idioma) {
        List<Libro> resultado = new ArrayList<>();
        for (Libro libro : buscarLibros(texto)) {
            boolean tipoOk = tipo == null || tipo.equals("Todos") || libro.getTipo().toString().equals(tipo);
            boolean idiomaOk = idioma == null || idioma.equals("Todos") || libro.getIdioma().equals(idioma);
            if (tipoOk && idiomaOk) {
                resultado.add(libro);
            }
        }
        return resultado;
    }

    // AUTORES

    /**
     * Devuelve todos los autores.
     *
     * @return la lista de autores
     */
    public List<Autor> getAutores() {
        return autores;
    }

    /**
     * Añade un autor y le asigna un identificador.
     *
     * @param autor autor que se añade
     */
    public void anadirAutor(Autor autor) {
        autor.setId(siguienteIdAutor);
        siguienteIdAutor++;
        autores.add(autor);
    }

    /**
     * Elimina un autor y lo quita también de los libros en los que aparece.
     *
     * @param autor autor que se elimina
     */
    public void eliminarAutor(Autor autor) {
        autores.remove(autor);
        for (Libro libro : libros) {
            libro.getAutores().remove(autor);
        }
    }

    /**
     * Busca los autores cuyo nombre o nacionalidad contienen un texto.
     * No distingue mayúsculas de minúsculas.
     *
     * @param texto texto que se busca
     * @return los autores que coinciden
     */
    public List<Autor> buscarAutores(String texto) {
        List<Autor> resultado = new ArrayList<>();
        String t = texto.toLowerCase();
        for (Autor autor : autores) {
            if (autor.getNombreApell().toLowerCase().contains(t)
                    || autor.getNacionalidad().toLowerCase().contains(t)) {
                resultado.add(autor);
            }
        }
        return resultado;
    }

    /**
     * Devuelve los libros en los que aparece un autor.
     *
     * @param autor autor del que se buscan los libros
     * @return los libros de ese autor
     */
    public List<Libro> getLibrosDeAutor(Autor autor) {
        List<Libro> resultado = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getAutores().contains(autor)) {
                resultado.add(libro);
            }
        }
        return resultado;
    }

    /**
     * Crea una lista con un solo autor. Se usa en los datos de prueba.
     *
     * @param autor autor que va en la lista
     * @return una lista con ese autor
     */
    private List<Autor> unAutor(Autor autor) {
        List<Autor> lista = new ArrayList<>();
        lista.add(autor);
        return lista;
    }

    /**
     * Añade unos libros y autores de prueba para que la aplicación no empiece vacía.
     */
    public void cargarDatosEjemplo() {
        Autor cervantes = new Autor("Miguel de Cervantes", "Española", LocalDate.of(1547, 9, 29), LocalDate.of(1616, 4, 22));
        Autor garcia = new Autor("Gabriel García Márquez", "Colombiana", LocalDate.of(1927, 3, 6), LocalDate.of(2014, 4, 17));
        Autor austen = new Autor("Jane Austen", "Británica", LocalDate.of(1775, 12, 16), LocalDate.of(1817, 7, 18));
        Autor gaiman = new Autor("Neil Gaiman", "Británica", LocalDate.of(1960, 11, 10), null);
        Autor pratchett = new Autor("Terry Pratchett", "Británica", LocalDate.of(1948, 4, 28), LocalDate.of(2015, 3, 12));
        anadirAutor(cervantes);
        anadirAutor(garcia);
        anadirAutor(austen);
        anadirAutor(gaiman);
        anadirAutor(pratchett);

        anadirLibro(new Libro("Don Quijote de la Mancha", unAutor(cervantes), "Salón, estante 1", "IV Centenario",
                1376, "Un hidalgo sale a recorrer La Mancha.", TipoLibro.TAPA_DURA, 1605, "Español"));
        anadirLibro(new Libro("Cien años de soledad", unAutor(garcia), "Salón, estante 2", "Conmemorativa",
                496, "La familia Buendía en Macondo.", TipoLibro.TAPA_BLANDA, 1967, "Español"));
        anadirLibro(new Libro("Pride and Prejudice", unAutor(austen), "Dormitorio", "Penguin Classics",
                432, "Elizabeth Bennet y el señor Darcy.", TipoLibro.BOLSILLO, 1813, "Inglés"));
        anadirLibro(new Libro("Buenos presagios", unAutor(pratchett), "Despacho", "1ª edición",
                416, "Un ángel y un demonio intentan evitar el fin del mundo.", TipoLibro.TAPA_BLANDA, 1990, "Español"));
        anadirLibro(new Libro("Coraline", unAutor(gaiman), "Cuarto de los niños", "Ilustrada",
                192, "Una niña descubre una puerta a otro mundo.", TipoLibro.BOLSILLO, 2002, "Inglés"));
    }
}
