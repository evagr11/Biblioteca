package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.model.Autor;
import org.example.model.Libro;

import java.io.IOException;

/**
 * Controlador de la ventana de administración de autores ({@code AutoresAdminView.fxml}).
 * <p>
 * Permite buscar, añadir, modificar y eliminar autores, y ver los libros de cada uno.
 *
 * @author Eva Gallardo Romero
 * @version 1.0
 */
public class AutoresAdminController {

    /** Campo para buscar por nombre o nacionalidad. */
    @FXML private TextField txtBuscar;
    /** Tabla con los autores encontrados. */
    @FXML private TableView<Autor> tblAutores;
    /** Columna con el nombre y apellidos. */
    @FXML private TableColumn<Autor, String> colNombre;
    /** Columna con la nacionalidad. */
    @FXML private TableColumn<Autor, String> colNacionalidad;
    /** Título del formulario ("Nuevo autor" o "Editar autor"). */
    @FXML private Label lblFormTitulo;
    /** Campo del nombre y apellidos. */
    @FXML private TextField txtNombre;
    /** Campo de la nacionalidad. */
    @FXML private TextField txtNacionalidad;
    /** Fecha de nacimiento. */
    @FXML private DatePicker dpNacimiento;
    /** Fecha de fallecimiento. */
    @FXML private DatePicker dpFallecimiento;
    /** Lista con los libros del autor. */
    @FXML private ListView<Libro> lstLibrosAutor;
    /** Mensaje de error del formulario. */
    @FXML private Label lblError;
    /** Barra de estado de la parte de abajo. */
    @FXML private Label lblEstado;

    /** Autor que se está editando, o {@code null} si se está creando uno nuevo. */
    private Autor autorActual = null;

    /**
     * Crea el controlador. Lo usa el FXMLLoader al cargar la vista.
     */
    public AutoresAdminController() {
    }

    /**
     * Se ejecuta al abrir la ventana: prepara las columnas y muestra los autores.
     */
    @FXML
    public void initialize() {
        // Cada columna muestra un dato del modelo: "nombreApell" sale de getNombreApell()
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombreApell"));
        colNacionalidad.setCellValueFactory(new PropertyValueFactory<>("nacionalidad"));
        buscar();
    }

    /**
     * Pide al modelo los autores que coinciden con el buscador y los pone en la tabla.
     */
    @FXML
    private void buscar() {
        tblAutores.getItems().clear();
        for (Autor autor : App.biblioteca.buscarAutores(txtBuscar.getText())) {
            tblAutores.getItems().add(autor);
        }
        lblEstado.setText(tblAutores.getItems().size() + " autores");
    }

    /**
     * Carga en el formulario el autor pulsado en la tabla y muestra sus libros.
     */
    @FXML
    private void seleccionarAutor() {
        Autor autor = tblAutores.getSelectionModel().getSelectedItem();
        if (autor == null) {
            return;
        }
        autorActual = autor;
        lblFormTitulo.setText("Editar autor");
        txtNombre.setText(autor.getNombreApell());
        txtNacionalidad.setText(autor.getNacionalidad());
        dpNacimiento.setValue(autor.getFechaNac());
        dpFallecimiento.setValue(autor.getFechaFall());
        lblError.setText("");

        lstLibrosAutor.getItems().clear();
        for (Libro libro : App.biblioteca.getLibrosDeAutor(autor)) {
            lstLibrosAutor.getItems().add(libro);
        }
    }

    /**
     * Deja el formulario vacío para crear un autor nuevo.
     */
    @FXML
    private void nuevo() {
        autorActual = null;
        lblFormTitulo.setText("Nuevo autor");
        txtNombre.setText("");
        txtNacionalidad.setText("");
        dpNacimiento.setValue(null);
        dpFallecimiento.setValue(null);
        lstLibrosAutor.getItems().clear();
        lblError.setText("");
    }

    /**
     * Guarda el autor del formulario.
     * <p>
     * Comprueba que el nombre no esté vacío. Si el autor es nuevo lo añade al modelo;
     * si no, modifica el que se está editando.
     */
    @FXML
    private void guardar() {
        // 1. Comprobar el campo obligatorio
        if (txtNombre.getText().isEmpty()) {
            lblError.setText("El nombre es obligatorio");
            return;
        }

        // 2. Llamar al modelo
        if (autorActual == null) {
            Autor autor = new Autor(txtNombre.getText(), txtNacionalidad.getText(),
                    dpNacimiento.getValue(), dpFallecimiento.getValue());
            App.biblioteca.anadirAutor(autor);
        } else {
            autorActual.setNombreApell(txtNombre.getText());
            autorActual.setNacionalidad(txtNacionalidad.getText());
            autorActual.setFechaNac(dpNacimiento.getValue());
            autorActual.setFechaFall(dpFallecimiento.getValue());
        }

        // 3. Actualizar la vista
        buscar();
        nuevo();
        lblEstado.setText("Autor guardado");
    }

    /**
     * Elimina el autor que se está editando, después de pedir confirmación.
     * <p>
     * El modelo también lo quita de los libros en los que aparece.
     *
     * @throws IOException si no se puede abrir la ventana de confirmación
     */
    @FXML
    private void eliminar() throws IOException {
        if (autorActual == null) {
            lblError.setText("Selecciona un autor");
            return;
        }

        // Antes de borrar, se abre la ventana de confirmación
        boolean seguro = App.confirmar("¿Seguro que quieres eliminar este autor?",
                "Se eliminará \"" + autorActual.getNombreApell() + "\". Esta acción no se puede deshacer.",
                "Eliminar autor");

        if (seguro) {
            App.biblioteca.eliminarAutor(autorActual);
            buscar();
            nuevo();
            lblEstado.setText("Autor eliminado");
        }
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
