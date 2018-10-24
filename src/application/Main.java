package application;
	

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Primeira aplicação JavaFX");
			Label label = new Label("Primeira aplicação");
			
			BorderPane root   = new BorderPane();
			Button button 	  = new Button("First button");
			
			TextField text = new TextField();
			
			String[] arrayItens = new String[] {"Ponta Grossa","Castro","Curitiba","Sengés","Piraí do Sul"};
			ChoiceBox<String> choiceBox = new ChoiceBox<>(FXCollections.observableArrayList(arrayItens));
			choiceBox.setTooltip(new Tooltip("Selecione uma cidade"));
			
			CheckBox checkBox = new CheckBox("Receber notificações");
			
			GridPane gridPane = new GridPane();
			gridPane.setPadding(new Insets(5));
			gridPane.setHgap(15);
			gridPane.setVgap(15);
			gridPane.autosize();
			
			BorderPane borderPane = new BorderPane();
			
			borderPane.setBottom(gridPane);
			
			MenuBar menuBar = new MenuBar();
			Menu menu = new Menu("Cadastros");
			menu.getItems().add(new MenuItem("Clientes"));
			menu.getItems().add(new MenuItem("Produtos"));
			menu.getItems().add(new MenuItem("Categorias"));
			
			menuBar.getMenus().add(menu);
			menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
			borderPane.setTop(menuBar);			
			
			Group group		  = new Group();
			Scene scene		  = new Scene(group,1024,768);
			
			gridPane.add(label, 0, 0);
			gridPane.add(button, 0, 1);
			gridPane.add(text, 0, 2);
			gridPane.add(choiceBox, 0, 3);
			gridPane.add(checkBox, 0, 4);			
			
			group.getChildren().add(borderPane);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());				
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
