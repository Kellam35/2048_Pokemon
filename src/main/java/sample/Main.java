package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class Main extends Application {

	private Parent root;
	private Scene scene;

	@Override
	public void start(Stage primaryStage) throws Exception{

		root = FXMLLoader.load(getClass().getResource("/2048.fxml"));

		primaryStage.setTitle("2048");

		scene = new Scene(root, 600, 600);

		primaryStage.setScene(scene);

		scene.setOnKeyTyped(event -> {
			if (event.getCharacter().equals("q")) {
				Platform.exit();
			}
			;
		});
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}