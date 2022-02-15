package main;

import controller.Controller;
import view.View;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Model;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Model theModel = new Model();
		View theView = new View(primaryStage);
		Controller theController = new Controller(theModel, theView);
	}
}
