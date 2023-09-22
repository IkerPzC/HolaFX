package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FlowPaneAlignment extends Application {

	@Override
	public void start(Stage stage) {
		
		//Paneles
		FlowPane fp1 = crearFlowPane(Pos.BOTTOM_RIGHT);
		FlowPane fp2 = crearFlowPane(Pos.BOTTOM_LEFT);
		FlowPane fp3 = crearFlowPane(Pos.BOTTOM_CENTER);
		FlowPane fp4 = crearFlowPane(Pos.CENTER);
		FlowPane fp5 = crearFlowPane(Pos.TOP_RIGHT);
		FlowPane fp6 = crearFlowPane(Pos.TOP_LEFT);
		FlowPane fp7 = crearFlowPane(Pos.TOP_CENTER);
		
		//Crear contenedor de tipo horizontal
		HBox root = new HBox(fp1, fp2, fp3, fp4, fp5, fp6, fp7);
		
		//Crear escena
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Alineacion FlowPane");
		stage.show();
	}

	private FlowPane crearFlowPane(Pos alignment) {
		
		//Crear FlowPane
		FlowPane fp = new FlowPane(5, 5);
		fp.setPrefSize(200, 100);
		fp.setAlignment(alignment);
		fp.getChildren().addAll(new Text(alignment.toString()), new Button("Boton 1"), new Button("Boton 2"),
				new Button("Boton 3"));
		fp.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
		return fp;
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}