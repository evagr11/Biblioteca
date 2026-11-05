package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.model.Libro;

import java.io.IOException;

/**
 * Controlador de la ventana principal ({@code PrincipalView.fxml}).
 * <p>
 * Muestra los libros en una tabla, permite buscarlos y filtrarlos por tipo e idioma,
 * enseña la ficha del libro elegido y lleva a las ventanas de administración.
 *
 * @author Eva Gallardo Romero
 * @version 1.0
 */
public class PrincipalController {

    /** Campo para buscar por título o autor. */
    @FXML private TextField txtBuscar;
    /** Filtro por tipo de libro. */
    @FXML private ComboBox<String> cmbTipo;
    /** Filtro por idioma. */
    @FXML private ComboBox<String> cmbIdioma;
    /** Tabla con los libros encontrados. */
    @FXML private TableView<Libro> tblLibros;
    /** Columna con el título. */
    @FXML private TableColumn<Libro, String> colTitulo;
    /** Columna con los autores. */
    @FXML private TableColumn<Libro, String> colAutor;
    /** Columna con el año. */
    @FXML private TableColumn<Libro, Integer> colAnio;
    /** Columna con la ubicación. */
    @FXML private TableColumn<Libro, String> colUbicacion;
    /** Título del libro en la ficha. */
    @FXML private Label lblTitulo;
    /** Autores del libro en la ficha. */
    @FXML private Label lblAutor;
    /** Sinopsis del libro en la ficha. */
    @FXML private Label lblSinopsis;
    /** Edición, páginas, tipo, idioma y año en la ficha. */
    @FXML private Label lblDatos;
    /** Ubicación del libro en la ficha. */
    @FXML private Label lblUbicacion;
    /** Barra de estado de la parte de abajo. */
    @FXML private Label lblEstado;

    /**
     * Crea el controlador. Lo usa el FXMLLoader al cargar la vista.
     */
    public PrincipalController() {
    }

    /**
     * Se ejecuta al abrir la ventana: prepara las columnas de la tabla,
     * rellena el filtro de idiomas y muestra todos los libros.
     */
    @FXML
    public void initialize() {
        // Cada columna muestra un dato del modelo: "titulo" sale de getTitulo()
        colTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colAutor.setCellValueFactory(new PropertyValueFactory<>("autoresTexto"));
        colAnio.setCellValueFactory(new PropertyValueFactory<>("anio"));
        colUbicacion.setCellValueFactory(new PropertyValueFactory<>("ubicacion"));

        cmbIdioma.getItems().add("Todos");
        cmbIdioma.getItems().add("Español");
        cmbIdioma.getItems().add("Inglés");
        buscar();
    }

    /**
     * Pide al modelo los libros que coinciden con el buscador y los filtros,
     * y los pone en la tabla.
     */
    @FXML
    private void buscar() {
        tblLibros.getItems().clear();
        for (Libro libro : App.biblioteca.filtrarLibros(txtBuscar.getText(), cmbTipo.getValue(), cmbIdioma.getValue())) {
            tblLibros.getItems().add(libro);
        }
        lblEstado.setText(tblLibros.getItems().size() + " libros");
    }

    /**
     * Muestra en la ficha de la derecha los datos del libro pulsado en la tabla.
     */
    @FXML
    private void seleccionarLibro() {
        Libro libro = tblLibros.getSelectionModel().getSelectedItem();
        if (libro == null) {
            return;
        }
        lblTitulo.setText(libro.getTitulo());
        lblAutor.setText(libro.getAutoresTexto());
        lblSinopsis.setText(libro.getSinopsis());
        lblDatos.setText(libro.getEdicion() + " - " + libro.getNumPag() + " páginas - " + libro.getTipo()
                + " - " + libro.getIdioma() + " - " + libro.getAnio());
        lblUbicacion.setText("Ubicación: " + libro.getUbicacion());
    }

    /**
     * Abre la administración de libros con el libro elegido ya cargado en el formulario.
     *
     * @throws IOException si no se puede cargar la ventana de administración de libros
     */
    @FXML
    private void editarLibro() throws IOException {
        Libro libro = tblLibros.getSelectionModel().getSelectedItem();
        if (libro == null) {
            lblEstado.setText("Selecciona un libro");
            return;
        }
        App.libroAEditar = libro;
        App.setRoot("LibrosAdminView");
    }

    /**
     * Va a la ventana principal.
     *
     * @throws IOException si no se puede cargar la ventana
     */
    @FXML
    private void irPrincipal() throws IOException {
        App.setRoot("PrincipalView");
    }

    /**
     * Va a la administración de libros.
     *
     * @throws IOException si no se puede cargar la ventana
     */
    @FXML
    private void irLibros() throws IOException {
        App.setRoot("LibrosAdminView");
    }

    /**
     * Va a la administración de autores.
     *
     * @throws IOException si no se puede cargar la ventana
     */
    @FXML
    private void irAutores() throws IOException {
        App.setRoot("AutoresAdminView");
    }
}
