package mvc;


import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
	
	// model
	
	private IntegerProperty valor = new SimpleIntegerProperty(50);
	
	// controllers
	
	private VerController verController;
	private ModificarController modificarController;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
	
		// ver
		
		verController = new VerController();
		
		verController.getModel().valorProperty().bind(valor);
		
		Scene verScene = new Scene(verController.getView(), 320, 200);
		
		Stage verStage = new Stage();
		verStage.setTitle("Ver");
		verStage.setScene(verScene);
		verStage.show();
		
		// modificar
		
		modificarController = new ModificarController();
		
		modificarController.getModel().valorProperty().bindBidirectional(valor);
		
		Scene modificarScene = new Scene(modificarController.getView(), 320, 200);
		
		Stage modificarStage = new Stage();
		modificarStage.setTitle("Modificar");
		modificarStage.setScene(modificarScene);
		modificarStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}

