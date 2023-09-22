package application;

import javafx.application.Application;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import static javafx.stage.WindowEvent.WINDOW_CLOSE_REQUEST;

public class WindowEventApp extends Application {
    private CheckBox cbPermitirCerrar;

    @Override
    public void start(Stage stage) {
    	//Instanciar caja 
        cbPermitirCerrar = new CheckBox("Puede Cerrar la ventana");
        
        //Boton cerrar
        Button botonCerrar = new Button("Cerrar");
        botonCerrar.setOnAction(e -> stage.close());
        
        //Boton ocultar
        Button ocultarBoton = new Button("Ocultar");
        ocultarBoton.setOnAction(e -> {
            showDialog(stage);
            stage.hide();
        });
        
        //Contenedor de tipo horizontal
        HBox root = new HBox();
        root.setPadding(new Insets(20));
        root.setSpacing(20);
        root.getChildren().addAll(cbPermitirCerrar, botonCerrar, ocultarBoton);
        
        // Añadir al stage los eventos de ventana
        stage.setOnShowing(e -> handle(e));
        stage.setOnShown(e -> handle(e));
        stage.setOnHiding(e -> handle(e));
        stage.setOnHidden(e -> handle(e));
        stage.setOnCloseRequest(e -> handle(e));
        
        //Crear escena
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Eventos de ventana");
        stage.show();
    }

    public void handle(WindowEvent e) {
    	
    	//Consumir el evento si la caja no esta seleccionada
        EventType<WindowEvent> tipo = e.getEventType();
        if (tipo == WINDOW_CLOSE_REQUEST && !cbPermitirCerrar.isSelected()) {
            e.consume();
        }
        System.out.println(tipo + ": Consumido=" + e.isConsumed());
    }

    public void showDialog(Stage mainWindow) {
    	//Crear stage
        Stage popup = new Stage();
        
        //Crear boton de cierre
        Button botonCerrar = new Button("Pulsa para volver la ventana principal");
        botonCerrar.setOnAction(e -> {
            popup.close();
            mainWindow.show();
        });
        
        //Crear contenedor de tipo horizontal
        HBox root = new HBox();
        root.setPadding(new Insets(20));
        root.setSpacing(20);
        root.getChildren().addAll(botonCerrar);
        
        //Crear escena
        Scene scene = new Scene(root);
        popup.setScene(scene);
        popup.setTitle("Popup");
        popup.show();
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}