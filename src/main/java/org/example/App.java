package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.model.Biblioteca;
import org.example.model.Libro;

import java.io.IOException;

/**
 * Clase principal de la aplicación Mi biblioteca.
 * <p>
 * Arranca la aplicación, guarda el modelo que comparten todas las ventanas
 * y se encarga de cambiar de ventana y de abrir la ventana de confirmación.
 *
 * @author Eva Gallardo Romero
 * @version 1.0
 */
public class App extends Application {

    /** Escena de la ventana principal, donde se van cargando las vistas. */
    private static Scene scene;

    /** Modelo de la aplicación: una sola biblioteca para todas las ventanas. */
    public static Biblioteca biblioteca = new Biblioteca();

    /** Libro elegido en la ventana principal para editarlo en la administración de libros. */
    public static Libro libroAEditar = null;

    /** Ventana de confirmación que está abierta. */
    public static Stage ventanaConfirmar;

    /** Título que muestra la ventana de confirmación. */
    public static String tituloConfirmar;

    /** Mensaje que muestra la ventana de confirmación. */
    public static String mensajeConfirmar;

    /** Texto del botón que confirma la acción. */
    public static String botonConfirmar;

    /** Respuesta de la ventana de confirmación: {@code true} si se ha confirmado. */
    public static boolean confirmado;

    /**
     * Crea la aplicación. Lo usa JavaFX al arrancar.
     */
    public App() {
    }

    /**
     * Arranca la aplicación: carga los datos de ejemplo y muestra la ventana principal.
     *
     * @param stage ventana principal que crea JavaFX
     * @throws IOException si no se puede cargar el FXML de la ventana principal
     */
    @Override
    public void start(Stage stage) throws IOException {
        biblioteca.cargarDatosEjemplo();
        scene = new Scene(loadFXML("PrincipalView"), 1180, 760);
        stage.setTitle("Mi biblioteca");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Cambia la vista que se muestra en la ventana principal.
     *
     * @param fxml nombre del archivo FXML sin la extensión (por ejemplo, "LibrosAdminView")
     * @throws IOException si no se puede cargar el FXML
     */
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * Abre la ventana de confirmación y espera a que se pulse uno de sus botones.
     * <p>
     * Mientras está abierta no se puede usar la ventana de atrás.
     *
     * @param titulo  pregunta que se muestra arriba
     * @param mensaje explicación que se muestra debajo de la pregunta
     * @param boton   texto del botón que confirma la acción
     * @return {@code true} si se ha pulsado el botón de confirmar y {@code false} si se ha pulsado "Cancelar"
     * @throws IOException si no se puede cargar el FXML de la ventana de confirmación
     */
    static boolean confirmar(String titulo, String mensaje, String boton) throws IOException {
        tituloConfirmar = titulo;
        mensajeConfirmar = mensaje;
        botonConfirmar = boton;
        confirmado = false;

        ventanaConfirmar = new Stage();
        ventanaConfirmar.setTitle("Confirmar");
        ventanaConfirmar.setScene(new Scene(loadFXML("ConfirmarView")));
        ventanaConfirmar.initModality(Modality.APPLICATION_MODAL);
        ventanaConfirmar.setResizable(false);
        ventanaConfirmar.showAndWait();

        return confirmado;
    }

    /**
     * Carga un archivo FXML de la carpeta de recursos.
     *
     * @param fxml nombre del archivo FXML sin la extensión
     * @return la vista cargada
     * @throws IOException si no se encuentra o no se puede leer el FXML
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    /**
     * Punto de entrada del programa.
     *
     * @param args argumentos de la línea de comandos (no se usan)
     */
    public static void main(String[] args) {
        launch();
    }
}
