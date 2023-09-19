package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ShowAndWaitApp extends Application {
	
	//Variable para contar la cantidad de veces que se pulsa el boton en la ventana padre
    protected static int counter = 0;
    
    //Variable para guardar el utltimo stage abierto
    protected Stage lastOpenStage;

    //MAIN
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
    	
    	//Instancia de contenedor VBox
        VBox root = new VBox();
        
        //Instancia de boton
        Button openButton = new Button("Open");
        
        //Al pulsar el boton, se llama al metodo open(), quien aumenta el contador
        openButton.setOnAction(e -> open(++counter));
        
        //Se agrega el boton como hijo de root
        root.getChildren().add(openButton);
        
        //Se instancia una escena
        Scene scene = new Scene(root, 400, 400);
        
        //Se establece como escena principal
        stage.setScene(scene);
        
        //Se establece el titulo de la escena
        stage.setTitle("The Primary Stage");
        
        //Se muestra la ventana principal
        stage.show();
        
        //Se asigna la escena a la variable correspondiente
        this.lastOpenStage = stage;
    }

    private void open(int stageNumber) {
    	
    	//Se instancia una escena
        Stage stage = new Stage();
        
        //Se establece el titulo de la escena
        stage.setTitle("#" + stageNumber);
        
        //Se instancia un boton
        Button sayHelloButton = new Button("Say Hello");
        
        //Al pulsar el boton se muestra en consola el mensaje correspondiente
        sayHelloButton.setOnAction(e -> System.out.println("Hello from #" + stageNumber));
        
        //Se instancia un boton
        Button openButton = new Button("Open");
        
        //Al pulsar el boton, se llama al metodo open, quien aumenta el contador
        openButton.setOnAction(e -> open(++counter));
        
        //Se crea un contendor VBox
        VBox root = new VBox();
        
        //Se añaden al contenedor ambos botones
        root.getChildren().addAll(sayHelloButton, openButton);
        
        //Se crea una escena
        Scene scene = new Scene(root, 200, 200);
        
        //Se añade la escena como escena principal
        stage.setScene(scene);
        
        //Se establecen las coordenadas donde deben instanciarse las ventanas
        stage.setX(this.lastOpenStage.getX() + 50);
        stage.setY(this.lastOpenStage.getY() + 50);
        
        //Se asigna la escena a la variable correspondiente
        this.lastOpenStage = stage;
        
        //Se muestra por consola el estado previo de la escena
        System.out.println("Before stage.showAndWait(): " + stageNumber);
        
        // Show the stage and wait for it to close
        stage.showAndWait();
        
        //Se muestra por consola el estado posterior de la escena
        System.out.println("After stage.showAndWait(): " + stageNumber);
    }
}

