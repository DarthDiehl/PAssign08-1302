package keypad;

import java.util.ArrayList;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

/**
 * File: PAssign08.java
 * Class: CSCI 1302
 * Author: Bailey Diehl
 * Created on: Nov 12, 2024
 * Last Modified: Nov 13, 2024
 * Description: Smart Lock that Rotates a Circle 180 Degrees.
 * GitHub Link: https://github.com/DarthDiehl/hello-world
 */
public class PAssign08 extends KeyPadPane{
	// Protected Data Members from this Class.
	protected TextField tfInput = new TextField();
	protected Button btEnter = new Button();
	protected VBox inputPane = new VBox(5);
	protected Pane imagePane = new Pane();
	protected Circle lockIcon = new Circle();
	
	// regular ordered keypadPane Buttons
	public PAssign08() {
		
	}
	
	// changed the order of KeyPadPane Buttons, Used Prof. William's Structure
	public PAssign08(boolean buttonOrder) {
		// default to default layout for someone choosing false
		this();

		if (buttonOrder) {
			// get rid of default layout
			this.getChildren().clear();

			// counter for ArrayList elements
			int counter = 0;

			// place all buttons in 1-9, blank, 0, blank order, 3 per row
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 5; j++) {
					this.add(listButtons.get(counter++), j, i);
				}
			}
			btnBlank1.setText("0");
		}
	}
	// Hiding all the extra button formating in a method
	public VBox addStyle() {
		tfInput.setPromptText("Enter Passkey");
		btEnter.setText("Enter");
		
		inputPane.getChildren().addAll(tfInput, btEnter);
		return inputPane;
	}
	
	// Method to add a Image - need to make useful
	public Pane addImage() {
		// image folder in Bin to get Photos to work. - us flag is a test
		ImageView imageView = new ImageView(new Image(getClass().getResource("/images/us.gif").toExternalForm()));
		imageView.setFitWidth(50);
		imageView.setFitHeight(100);
		imageView.setPreserveRatio(true);
		imagePane.getChildren().add(imageView);
		return imagePane;		
	}
	
	// Method to add a Circle that rotates 180 degree if 4 digit is entered i hope.
	public Circle addLock() {
		return lockIcon;
	}
}
