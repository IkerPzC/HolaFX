package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MicroHelpApp extends Application {
	//Texto
    private Text textoAyuda = new Text();

    @Override
    public void start(Stage stage) {
    	
    	//Etiquetas
        TextField textFieldNombre = new TextField();
        TextField textFieldApellido = new TextField();
        TextField textFieldSalario = new TextField();
        
        //Boton cerrar
        Button botonCerrar = new Button("Cerrar");
        
        //Al pulsar el boton se cierra la ventana
        botonCerrar.setOnAction(e -> Platform.exit());
        
        //Textos descriptivos de las etiquetas
        textFieldNombre.getProperties().put("microHelpText", "Introduce tu nombre");
        textFieldApellido.getProperties().put("microHelpText", "Introduce tu apellido");
        textFieldSalario.getProperties().put("microHelpText", "Introduce un salario mayor a 2000€");
        
        //El nodo de ayuda es unmerged
        textoAyuda.setManaged(false);
        textoAyuda.setTextOrigin(VPos.TOP);
        textoAyuda.setFill(Color.RED);
        textoAyuda.setFont(Font.font(null, 9));
        textoAyuda.setMouseTransparent(true);
        
        //Añadir los nodos a un panel de tipo Grid
        GridPane root = new GridPane();
        root.add(new Label("Nombre:"), 1, 1);
        root.add(textFieldNombre, 2, 1);
        root.add(new Label("Apellido:"), 1, 2);
        root.add(textFieldApellido, 2, 2);
        root.add(new Label("Salario:"), 1, 3);
        root.add(textFieldSalario, 2, 3);
        root.add(botonCerrar, 3, 3);
        root.add(textoAyuda, 4, 3);
        
        //Se crea una escena
        Scene scene = new Scene(root, 300, 100);
        
        //Se añade un escuchador a la escen para saber cuando cambiar el foco
        scene.focusOwnerProperty().addListener((ObservableValue<? extends Node> value, Node oldNode, Node newNode) -> focoCambiado(value, oldNode, newNode));
        
        //Se añade la escena a la principal
        stage.setScene(scene);
        
        //Se establece el titulo
        stage.setTitle("Showing Micro Help");
        
        //Se muestra
        stage.show();
    }

    public void focoCambiado(ObservableValue<? extends Node> valor, Node nodoAntiguo, Node nodoNuevo) {
       
    	//El foco ha cambiado al nuevo nodo
        String microHelpText = (String) nodoNuevo.getProperties().get("microHelpText");
        
        //Comprobar si el texto no es nulo o la longitud no es 0
        if (microHelpText != null && microHelpText.trim().length() > 0) {
            textoAyuda.setText(microHelpText);
            textoAyuda.setVisible(true);
            
            //Posicion del nodo del texto de ayuda
            double x = nodoNuevo.getLayoutX() + nodoNuevo.getLayoutBounds().getMinX() - textoAyuda.getLayoutBounds().getMinX();
            double y = nodoNuevo.getLayoutY() + nodoNuevo.getLayoutBounds().getMinY() + nodoNuevo.getLayoutBounds().getHeight() - textoAyuda.getLayoutBounds().getMinX();
            textoAyuda.setLayoutX(x);
            textoAyuda.setLayoutY(y);
            textoAyuda.setWrappingWidth(nodoNuevo.getLayoutBounds().getWidth());
        } else {
            textoAyuda.setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}