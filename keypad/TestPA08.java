package keypad;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * File: PAssign08.java
 * Class: CSCI 1302
 * Author: Bailey Diehl
 * Created on: Nov 12, 2024
 * Last Modified: Nov 13, 2024
 * Description:  "Prints Out" a Smart Lock
 * GitHub Link: https://github.com/DarthDiehl/hello-world
 */
public class TestPA08 extends Application {

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		GridPane mainPane = new GridPane();
		
		// a wrapper class to keep stuff off of each other
		FlowPane dressPane = new FlowPane();
		
		// create a KeyPadPane
		//PAssign08 keyPane = new PAssign08(); // default keypad layout
		PAssign08 keyPane = new PAssign08(true); // custom keypad layout
		
		// add parts to GridPane
		mainPane.add(keyPane.addStyle(), 1, 0);
		mainPane.add(keyPane, 1, 1);
		mainPane.add(keyPane.addImage(), 0, 1);
		dressPane.getChildren().add(mainPane);
		

		
		// create your scene (400 x 400 to clearly show KeyPadPane)
		Scene scene = new Scene(dressPane, 200, 300);
		
		primaryStage.setTitle("Test PA08"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	public static void main(String[] args) { 
		launch(args);
	}
}