package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class EventHandlerProperties extends Application {

    @Override
    public void start(Stage stage) {
    	
    	//Instanciar los circulos
        Circle circuloConEvento = new Circle(100, 100, 50);
        Circle circuloSinEvento = new Circle(200,100,50);
        
        //Dar color a los circulos
        circuloConEvento.setFill(Color.CORAL);
        circuloSinEvento.setFill(Color.RED);
        
        //Contenedor de tipo Horizontal
        HBox root = new HBox();
        root.getChildren().add(circuloConEvento);
        root.getChildren().add(circuloSinEvento);
        
        //Escena
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Evento de ratón");
        stage.sizeToScene();
        stage.setResizable(false);
        stage.show();
        
        //Evento del raton
        EventHandler<MouseEvent> eventHandler = e -> System.out.println("Tengo el ratón encima, me está tocando");

        //Utilizar el evento creado sobre el circuloConEvento
        circuloConEvento.setOnMouseClicked(eventHandler);
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}