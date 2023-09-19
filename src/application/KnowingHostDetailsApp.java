package application;

import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class KnowingHostDetailsApp extends Application {
 public static void main(String[] args) {
     Application.launch(args);
 }

 @Override
 public void start(Stage stage) {
	 //Se indica la ruta a mostrar
     String googleURL = "http://www.google.com";
     
     //Se crea un boton, el cual muestra dicha ruta
     Button botonAbrirURL = new Button("Buscar en google");
     botonAbrirURL.setOnAction(e -> getHostServices().showDocument(googleURL));
     
     //Se cra un boton, el cual muestra una ventana de alerta
     Button mostrarAlerta = new Button("Show Alert");
     mostrarAlerta.setOnAction(e -> mostrarAlerta());
     
     //Se crea un contenedor
     VBox root = new VBox();
     
     // Se añaden al contendor los botones y los host
     root.getChildren().addAll(botonAbrirURL, mostrarAlerta);
     Map<String, String> detallesDelHost = dameDetallesDelHost();
     for (Map.Entry<String, String> entry : detallesDelHost.entrySet()) {
         String desc = entry.getKey() + ": " + entry.getValue();
         root.getChildren().add(new Label(desc));
     }
     
     //Se crea una escena, a la cual se le asigna la escena principal y un titulo
     Scene scene = new Scene(root);
     stage.setScene(scene);
     stage.setTitle("Host...");
     
     //Se muestra la escena
     stage.show();
 }

 protected Map<String, String> dameDetallesDelHost() {
	 
	 //Se crea un mapa
     Map<String, String> mapa = new HashMap<>();
     
     //Se crea un servicio de host
     HostServices host = this.getHostServices();
     
     //Se obtiene la url y se añade al mapa
     String codeBase = host.getCodeBase();
     mapa.put("CodeBase", codeBase);
     
     //Se obtiene el documento y se añade al mapa
     String documentBase = host.getDocumentBase();
     mapa.put("DocumentBase", documentBase);
     
     //Se obtiene una imagen y se añade al mapa
     String splashImageURI = host.resolveURI(documentBase, "splash.jpg");
     mapa.put("Splash Image URI", splashImageURI);
     
     return mapa;
 }

 protected void mostrarAlerta() {
	 
	 //Se crea un stage y se hace modal
     Stage stage = new Stage(StageStyle.UTILITY);
     stage.initModality(Modality.APPLICATION_MODAL);
     
     //Se crea una etiqueta
     Label etiqueta = new Label("Esto es una alerta!!");
     
     //Se crea un grupo al que se añade la etiqueta
     Group root = new Group(etiqueta);
     
     //Se crea una escena, la cual se asigna como escena principal y se le da un titulo
     Scene scene = new Scene(root);
     stage.setScene(scene);
     stage.setTitle("FX Alert");
     
     //Se muestra la escena
     stage.show();
 }
}