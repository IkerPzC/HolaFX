package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
    public void start(Stage escenario) {
    	//Instanciar texto
        Text msg = new Text("HolaFX Application ");
        //Crear un nodo y aniadirle un hijo
        VBox root = new VBox();
        root.getChildren().add(msg);
        //Instanciar escena
        Scene scene = new Scene(root, 300, 50);
        //Establecer escena
        escenario.setScene(scene);
        //Establecer titulo
        escenario.setTitle("HolaFX Application con Scene");        
        //Mostrar Escenario
        escenario.show();
    }
	
    public static void main(String[] args) {
        launch(args);
    }
}