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
			// Seta o titulo da aplicação
			primaryStage.setTitle("Primeira aplicação JavaFX");
			
			// Instancia um novo label
			Label label = new Label("Primeira aplicação");
						
			// Instancia uma nova border pane
			// BorderPane root = new BorderPane();
			
			// Instancia um novo botão
			Button button = new Button("First button");
			
			// Instancia um novo campo de texto
			TextField text = new TextField();
			
			// Instancia um array de dados do tipo string
			String[] arrayItens = new String[] {
					"Ponta Grossa",
					"Castro",
					"Curitiba",
					"Sengés",
					"Piraí do Sul"
				};
			
			// Instancia um novo input do tipo selecct
			ChoiceBox<String> choiceBox = new ChoiceBox<>(FXCollections.observableArrayList(arrayItens));
			
			// Seta um valor de tooltip para o checkbox 
			choiceBox.setTooltip(new Tooltip("Selecione uma cidade"));
			
			// Instancia um novo campo do tipo checkbox			
			CheckBox checkBox = new CheckBox("Receber notificações");
			
			// Instancia um novo gridPane
			GridPane gridPane = new GridPane();
			gridPane.setPadding(new Insets(5));
			gridPane.setHgap(15);
			gridPane.setVgap(15);
			gridPane.autosize();
			
			// Instancia um novo borderPane
			BorderPane borderPane = new BorderPane();
			
			// Seta o gridPane embaixo
			borderPane.setBottom(gridPane);
			
			// Instancia um novo menubar
			MenuBar menuBar = new MenuBar();
			
			// Instancia um novo menu que recebera os itens do menu
			Menu menu = new Menu("Cadastros");
			menu.getItems().add(new MenuItem("Clientes"));
			menu.getItems().add(new MenuItem("Produtos"));
			menu.getItems().add(new MenuItem("Categorias"));
			
			// Adiciona o menu criado ao menubar
			menuBar.getMenus().add(menu);
			menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
			
			// Seta o menubar no topo da aplicação
			borderPane.setTop(menuBar);			
			
			// Instancia um novo grupo
			Group group	= new Group();
			Scene scene	= new Scene(group,1024,768);
			
			// Adiciona os elementos nas suas posições basedos em COLUMN E ROW
			gridPane.add(label, 0, 0);
			gridPane.add(button, 0, 1);
			gridPane.add(text, 0, 2);
			gridPane.add(choiceBox, 0, 3);
			gridPane.add(checkBox, 0, 4);			
			
			// Adiciona o borderPane
			group.getChildren().add(borderPane);
			
			// Recupera o stylo da aplicação
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());				
			
			// Seta o stane para dentro da cena e depois mostra
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
