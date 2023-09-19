package pruebaBoton;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PruebaBoton extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage escenario) {
    	//Instanciar texto
        Text mensaje = new Text("No te saludo");
        
        //Instanciar botones
        Button botonHola = new Button("Hola");
        Button botonAdios = new Button("Adios");
        
        //Eventos de los botones
        botonHola.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				mensaje.setText(botonHola.getText());
			}
		});
        
        botonAdios.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				mensaje.setText(botonAdios.getText());
			}
		});
        
        //Contenedor simple
        VBox raiz = new VBox();
        
        //Aniadiendo componentes al contendero
        raiz.getChildren().addAll(mensaje, botonHola, botonAdios);
        
        //Escena de trabajo ppal
        Scene escena = new Scene(raiz, 400,400);
        
        escenario.setScene(escena);
        escenario.setTitle("HolaFX, prueba de botones");
        escenario.show();
        

    }
}