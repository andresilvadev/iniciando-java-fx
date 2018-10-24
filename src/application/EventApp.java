package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class EventApp extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		
		stage.setTitle("Event handler");
		
		Label label = new Label("Input your name");
		Label labelGreeting = new Label();
		labelGreeting.setVisible(false);
		
		TextField textName = new TextField();
		textName.setTooltip(new Tooltip("Input you name here"));
		Button btnClick = new Button("Say hello");
		btnClick.setTooltip(new Tooltip("Click to greeting"));
		
		// Disparando evento
		btnClick.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				
				if(textName.getText().length() > 0 ) {
					labelGreeting.setText("Hello " + textName.getText() + " this is my event");
					labelGreeting.setVisible(true);
				} else {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setContentText("Opss! Something went wrong");
					alert.showAndWait();
				}
				
				// Alert alert = new Alert(AlertType.CONFIRMATION);
				// alert.setTitle("Alert Dialog");
				// alert.setHeaderText("Header text");
				// alert.setContentText("This is my Dialog modal from JavaFX");
				// alert.showAndWait();
			}
		});
		
		GridPane gridPane = new GridPane();
		gridPane.setHgap(15);
		gridPane.setVgap(20);
		gridPane.autosize();
		gridPane.setPadding(new Insets(5, 5, 5, 5));
		
		gridPane.add(label, 0, 0);
		gridPane.add(textName, 1, 0);
		gridPane.add(btnClick, 0, 1);
		gridPane.add(labelGreeting, 0, 2);
		
		Group groupItens = new Group();
		groupItens.getChildren().add(gridPane);
		
		Scene scene = new Scene(groupItens, 1024, 768);
		
		stage.setScene(scene);
		stage.show();
			
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
