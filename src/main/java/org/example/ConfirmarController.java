package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Controlador de la ventana de confirmación ({@code ConfirmarView.fxml}).
 * <p>
 * Pregunta si de verdad se quiere eliminar un libro o un autor y guarda
 * la respuesta en {@link App#confirmado}.
 *
 * @author Eva Gallardo Romero
 * @version 1.0
 */
public class ConfirmarController {

    /** Pregunta de la ventana. */
    @FXML private Label lblTitulo;
    /** Explicación de lo que se va a eliminar. */
    @FXML private Label lblMensaje;
    /** Botón que confirma la acción. */
    @FXML private Button btnEliminar;

    /**
     * Crea el controlador. Lo usa el FXMLLoader al cargar la vista.
     */
    public ConfirmarController() {
    }

    /**
     * Se ejecuta al abrir la ventana: pone los textos que ha preparado
     * la ventana que la abre.
     */
    @FXML
    public void initialize() {
        lblTitulo.setText(App.tituloConfirmar);
        lblMensaje.setText(App.mensajeConfirmar);
        btnEliminar.setText(App.botonConfirmar);
    }

    /**
     * Botón "Cancelar": cierra la ventana sin eliminar nada.
     */
    @FXML
    private void cancelar() {
        App.confirmado = false;
        App.ventanaConfirmar.close();
    }

    /**
     * Botón "Eliminar": confirma la acción y cierra la ventana.
     */
    @FXML
    private void eliminar() {
        App.confirmado = true;
        App.ventanaConfirmar.close();
    }
}
