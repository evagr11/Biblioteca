package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.model.Autor;
import org.example.model.Libro;
import org.example.model.TipoLibro;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador de la ventana de administración de libros ({@code LibrosAdminView.fxml}).
 * <p>
 * Permite buscar, añadir, modificar y eliminar libros. El mismo formulario sirve
 * para crear un libro nuevo o para editar el que se ha elegido en la tabla.
 *
 * @author Eva Gallardo Romero
 * @version 1.0
 */
public class LibrosAdminController {

    /** Campo para buscar por título o autor. */
    @FXML private TextField txtBuscar;
    /** Tabla con los libros encontrados. */
    @FXML private TableView<Libro> tblLibros;
    /** Columna con el título. */
    @FXML private TableColumn<Libro, String> colTitulo;
    /** Columna con los autores. */
    @FXML private TableColumn<Libro, String> colAutor;
    /** Título del formulario ("Nuevo libro" o "Editar libro"). */
    @FXML private Label lblFormTitulo;
    /** Campo del título. */
    @FXML private TextField txtTitulo;
    /** Desplegable para elegir el autor. */
    @FXML private ComboBox<Autor> cmbAutor;
    /** Campo de la ubicación. */
    @FXML private TextField txtUbicacion;
    /** Campo de la edición. */
    @FXML private TextField txtEdicion;
    /** Campo del número de páginas. */
    @FXML private TextField txtNumPag;
    /** Campo del año. */
    @FXML private TextField txtAnio;
    /** Campo del idioma. */
    @FXML private TextField txtIdioma;
    /** Opción de tipo "bolsillo". */
    @FXML private RadioButton rbBolsillo;
    /** Opción de tipo "tapa blanda". */
    @FXML private RadioButton rbTapaBlanda;
    /** Opción de tipo "tapa dura". */
    @FXML private RadioButton rbTapaDura;
    /** Campo de la sinopsis. */
    @FXML private TextArea txtSinopsis;
    /** Mensaje de error del formulario. */
    @FXML private Label lblError;
    /** Barra de estado de la parte de abajo. */
    @FXML private Label lblEstado;

    /** Libro que se está editando, o {@code null} si se está creando uno nuevo. */
    private Libro libroActual = null;

    /**
     * Crea el controlador. Lo usa el FXMLLoader al cargar la vista.
     */
    public LibrosAdminController() {
    }

    /**
     * Se ejecuta al abrir la ventana: prepara las columnas, rellena el desplegable
     * de autores y muestra los libros. Si se viene de "Editar este libro",
     * carga ese libro en el formulario.
     */
    @FXML
    public void initialize() {
        // Cada columna muestra un dato del modelo: "titulo" sale de getTitulo()
        colTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colAutor.setCellValueFactory(new PropertyValueFactory<>("autoresTexto"));

        for (Autor autor : App.biblioteca.getAutores()) {
            cmbAutor.getItems().add(autor);
        }

        buscar();

        if (App.libroAEditar != null) {
            mostrarLibro(App.libroAEditar);
            App.libroAEditar = null;
        }
    }

    /**
     * Pide al modelo los libros que coinciden con el buscador y los pone en la tabla.
     */
    @FXML
    private void buscar() {
        tblLibros.getItems().clear();
        for (Libro libro : App.biblioteca.buscarLibros(txtBuscar.getText())) {
            tblLibros.getItems().add(libro);
        }
        lblEstado.setText(tblLibros.getItems().size() + " libros");
    }

    /**
     * Carga en el formulario el libro pulsado en la tabla.
     */
    @FXML
    private void seleccionarLibro() {
        Libro libro = tblLibros.getSelectionModel().getSelectedItem();
        if (libro != null) {
            mostrarLibro(libro);
        }
    }

    /**
     * Deja el formulario vacío para crear un libro nuevo.
     */
    @FXML
    private void nuevo() {
        libroActual = null;
        lblFormTitulo.setText("Nuevo libro");
        txtTitulo.setText("");
        cmbAutor.setValue(null);
        txtUbicacion.setText("");
        txtEdicion.setText("");
        txtNumPag.setText("");
        txtAnio.setText("");
        txtIdioma.setText("");
        rbBolsillo.setSelected(false);
        rbTapaBlanda.setSelected(false);
        rbTapaDura.setSelected(false);
        txtSinopsis.setText("");
        lblError.setText("");
    }

    /**
     * Guarda el libro del formulario.
     * <p>
     * Comprueba los campos obligatorios y que páginas y año sean números.
     * Si el libro es nuevo lo añade al modelo; si no, modifica el que se está editando.
     */
    @FXML
    private void guardar() {
        // 1. Coger los datos de la vista
        String titulo = txtTitulo.getText();
        Autor autor = cmbAutor.getValue();
        String ubicacion = txtUbicacion.getText();

        TipoLibro tipo = null;
        if (rbBolsillo.isSelected()) {
            tipo = TipoLibro.BOLSILLO;
        } else if (rbTapaBlanda.isSelected()) {
            tipo = TipoLibro.TAPA_BLANDA;
        } else if (rbTapaDura.isSelected()) {
            tipo = TipoLibro.TAPA_DURA;
        }

        // 2. Comprobar los campos obligatorios
        if (titulo.isEmpty() || autor == null || ubicacion.isEmpty() || tipo == null) {
            lblError.setText("Rellena título, autor, ubicación y tipo");
            return;
        }

        int numPag;
        int anio;
        try {
            numPag = Integer.parseInt(txtNumPag.getText());
            anio = Integer.parseInt(txtAnio.getText());
        } catch (NumberFormatException e) {
            lblError.setText("Escribe páginas y año con números");
            return;
        }

        // El modelo guarda los autores en una lista
        List<Autor> autores = new ArrayList<>();
        autores.add(autor);

        // 3. Llamar al modelo
        if (libroActual == null) {
            Libro libro = new Libro(titulo, autores, ubicacion, txtEdicion.getText(), numPag,
                    txtSinopsis.getText(), tipo, anio, txtIdioma.getText());
            App.biblioteca.anadirLibro(libro);
        } else {
            libroActual.setTitulo(titulo);
            libroActual.setAutores(autores);
            libroActual.setUbicacion(ubicacion);
            libroActual.setEdicion(txtEdicion.getText());
            libroActual.setNumPag(numPag);
            libroActual.setSinopsis(txtSinopsis.getText());
            libroActual.setTipo(tipo);
            libroActual.setAnio(anio);
            libroActual.setIdioma(txtIdioma.getText());
        }

        // 4. Actualizar la vista
        buscar();
        nuevo();
        lblEstado.setText("Libro guardado");
    }

    /**
     * Elimina el libro que se está editando, después de pedir confirmación.
     *
     * @throws IOException si no se puede abrir la ventana de confirmación
     */
    @FXML
    private void eliminar() throws IOException {
        if (libroActual == null) {
            lblError.setText("Selecciona un libro");
            return;
        }

        // Antes de borrar, se abre la ventana de confirmación
        boolean seguro = App.confirmar("¿Seguro que quieres eliminar este libro?",
                "Se eliminará \"" + libroActual.getTitulo() + "\". Esta acción no se puede deshacer.",
                "Eliminar libro");

        if (seguro) {
            App.biblioteca.eliminarLibro(libroActual);
            buscar();
            nuevo();
            lblEstado.setText("Libro eliminado");
        }
    }

    /**
     * Pone los datos de un libro en el formulario para editarlo.
     *
     * @param libro libro que se va a editar
     */
    private void mostrarLibro(Libro libro) {
        libroActual = libro;
        lblFormTitulo.setText("Editar libro");
        txtTitulo.setText(libro.getTitulo());
        txtUbicacion.setText(libro.getUbicacion());
        txtEdicion.setText(libro.getEdicion());
        txtNumPag.setText("" + libro.getNumPag());
        txtAnio.setText("" + libro.getAnio());
        txtIdioma.setText(libro.getIdioma());
        txtSinopsis.setText(libro.getSinopsis());
        lblError.setText("");

        if (libro.getAutores().size() > 0) {
            cmbAutor.setValue(libro.getAutores().get(0));
        } else {
            cmbAutor.setValue(null);
        }

        rbBolsillo.setSelected(libro.getTipo() == TipoLibro.BOLSILLO);
        rbTapaBlanda.setSelected(libro.getTipo() == TipoLibro.TAPA_BLANDA);
        rbTapaDura.setSelected(libro.getTipo() == TipoLibro.TAPA_DURA);
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
