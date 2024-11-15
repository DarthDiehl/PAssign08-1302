package keypad;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

/**
 * File: PAssign08.java
 * Class: CSCI 1302
 * Author: Bailey Diehl
 * Created on: Nov 12, 2024
 * Last Modified: Nov 13, 2024
 * Description: Smart Lock that Rotates a Circle 180 Degrees. Real practice is with images & centering.
 * GitHub Link: https://github.com/DarthDiehl/hello-world
 */
public class PAssign08 extends KeyPadPane{
	// Protected Data Members from this Class.
	protected TextField tfInput = new TextField();
	protected Button btEnter = new Button();
	protected Button btClear = new Button();
	protected VBox inputPane = new VBox(5);
	protected HBox btnHolder = new HBox(5);
	protected Pane imagePane = new Pane();
	protected StackPane lockPane = new StackPane();
	protected Circle lockIcon = new Circle();
	
	// Regular ordered keypadPane Buttons
	public PAssign08() {
		applyEventHandler();
	}
	
	// Changed the order of KeyPadPane Buttons, Used Prof. William's Structure
	public PAssign08(boolean buttonOrder) {
		// returns a default layout for false input
		this();
		btnBlank1.setText("  ");
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
			// make a 0 in blank btn.
			btnBlank1.setText("0");
		}
		applyEventHandler();
	}
	
	// Hiding all the extra button formating in a method
	public VBox addStyle() {
		tfInput.setPromptText("Enter Passkey");
		tfInput.setPrefWidth(150);
		btEnter.setText("Enter");
		btClear.setText("Clear");
		
		btnHolder.getChildren().addAll(btEnter, btClear);
		btnHolder.setAlignment(Pos.CENTER);
		inputPane.getChildren().addAll(tfInput, btnHolder);
		inputPane.setAlignment(Pos.CENTER);
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
	public StackPane addLock() {
		lockIcon.setRadius(20);
		lockIcon.setStyle("-fx-fill: transparent; -fx-stroke: black;");
		ImageView imageView2 = new ImageView(new Image(getClass().getResource("/images/keyhole.png").toExternalForm()));
		
	    // Set image properties to fit inside the circle
	    imageView2.setFitWidth(30); // Adjust size to fit inside the circle
	    imageView2.setFitHeight(30);
	    imageView2.setPreserveRatio(true);

	    // Create a StackPane to hold both the circle and the image
	    lockPane.getChildren().addAll(lockIcon, imageView2);

	    // Center the image inside the circle
	    lockPane.setAlignment(imageView2, Pos.CENTER);
		
		return lockPane;
	}
	
	// Method for button logic
	public void applyEventHandler() {
		btEnter.setOnAction( e -> {
			String tfInputCopy = tfInput.getText();
			if (!tfInputCopy.isEmpty() && tfInputCopy.length() == 4) {
				tfInput.setText("Welcome Home!");
				
				// Check the current rotation and rotate 180 degrees accordingly
	            double currentAngle = lockPane.getRotate();
	            double newAngle = (currentAngle + 180) % 360; // Rotate to 180 or back to 0
	            lockPane.setRotate(newAngle);
	            
			} else {
				tfInput.setText("Invalid Passkey");
			}
		});
		btClear.setOnAction(e -> tfInput.clear());
	}
	
	// Method to add functionality to keypadPane
	@Override
	protected void registerEventHandlers() {
		ArrayList<Button> currList = (copyListButtons != null) ? copyListButtons : listButtons;
		// give blank btn a value.
		btnBlank1.setText("0");
		for (Button btn : currList) {
			// Only assign actions for numeric buttons (0-9)
			if (btn.getText().matches("\\d")) {  // Check if button text is a digit
				btn.setOnAction(e -> tfInput.appendText(btn.getText()));
			}
		}
	}
}
