/**
 * 
 * RootStageController
 * 
 * provides functionality to the RootStage and connects the view to the code
 * 
 * @author johnfu
 * 
 */
package jf.dailytodo.address.view;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import jf.dailytodo.address.model.ToDoDatabase;
import jf.dailytodo.address.util.EventEntry;
import jf.dailytodo.address.MainApp;


public class RootStageController {
	
	//@FXML
	//private Label dateHeader;
	
	@FXML
	private VBox listVBox;
	
	
	
	
	private MainApp mainApp;
	private String todayDate;
	
	
	@FXML
	private void initialize() {
		//code for when the rootStage initializes 
		
		//sets the header for today
		todayDate = ToDoDatabase.getTodayDate();
		todayDate += " To-Do List";
		Text dateHeader = new Text();
		dateHeader.setStyle("-fx-font-weight:bold;" + "-fx-font-size: 30;" + "-fx-text-fill: #2196f3;");
		dateHeader.setText(todayDate);
		
		listVBox.getChildren().add(dateHeader);
		
		//testVbox();

		
		
	}
	
	//vbox testing code
	//it works!
	private void testVbox() {
		//test code
		//this is how I will dynamically add text to the vBox 
		Text test1 = new Text();
		test1.setText("• this is a test on dynamically adding values to the vbox");
		test1.setId("Text");
		
//		listVBox.getChildren().add(new Text("this is a test!"));
//		listVBox.getChildren().add(new Text("this is another test!"));
		
		//this code below actually works, lets me add buttons and text 
		HBox testHbox = new HBox();
		//testing to see if icon works 
		Button testButton = new Button("");
		
		//this is how we will assign an action to the button
		//testButton.setOnAction(value);
		
		FontAwesomeIcon testIcon = new FontAwesomeIcon();
		testIcon.setIconName("CHECK");
		testButton.setGraphic(testIcon);
		
		listVBox.getChildren().add(testHbox);
		testHbox.getChildren().add(test1);
		testHbox.getChildren().add(testButton);
		testHbox.setAlignment(Pos.CENTER_LEFT);
		
	}
	
	/**
	 * Dynamically adds new Hbox to view 
	 * Hbox will contain the new event information
	 */
	private void setNewEvent(EventEntry newEvent) {
		
		//new Hbox for title
		HBox newHbox = new HBox();
		newHbox.setStyle("-fx-font-weight:bold;" + "-fx-font-size: 20;");
		//text object for title text
		Text newTitle = new Text();
		newTitle.setText("• " + newEvent.getTitle());
		
		
		//delete button 
		Button deleteButton = new Button("");
		
		FontAwesomeIcon trashIcon = new FontAwesomeIcon();
		trashIcon.setIconName("TRASH");
		deleteButton.setGraphic(trashIcon);
		
		//new Hbox for start time and end time
		HBox timeHbox = new HBox();
		Text newStartTime = new Text();
		Text newEndTime = new Text();
		
		newStartTime.setText("\tStart Time: " + newEvent.getStartTime() + "     ");
		newEndTime.setText("End Time: " + newEvent.getEndTime());
		
		//Hbox for location
		HBox locationHbox = new HBox();
		Text locationText = new Text();
		locationText.setText("\tLocation: "+ newEvent.getLocation());
		
		//Hbox for description
		HBox descriptionHbox = new HBox();
		descriptionHbox.setStyle("-fx-border-style: dashed;"+ "-fx-border-width: 0 0 2 0;" +" -fx-border-color: white white #2196f3 white;");
		Text descriptionText = new Text();
		descriptionText.setText("\tDescription: " + newEvent.getDescription());
		


		
		
		
		//adding new HBox to the existing VBox
		listVBox.getChildren().add(newHbox);
		listVBox.getChildren().add(timeHbox);
		listVBox.getChildren().add(locationHbox);
		listVBox.getChildren().add(descriptionHbox);

		
		//setting the children of the new Hboxes
		
		//sets title hbox
		newHbox.getChildren().add(newTitle);
		newHbox.getChildren().add(deleteButton);
		newHbox.setAlignment(Pos.CENTER_LEFT);
		
		//sets time hbox
		timeHbox.getChildren().add(newStartTime);
		timeHbox.getChildren().add(newEndTime);
		timeHbox.setAlignment(Pos.CENTER_LEFT);
		
		//sets location hbox
		locationHbox.getChildren().add(locationText);
		timeHbox.setAlignment(Pos.CENTER_LEFT);
		
		//sets description in hbox
		descriptionHbox.getChildren().add(descriptionText);
		timeHbox.setAlignment(Pos.CENTER_LEFT);
		
		
		
	}
	
	
	@FXML
	private void addNewEvent() {
		EventEntry returnedEvent = mainApp.showAddNewEventView();
		if(returnedEvent.getTitle().equals("")) {
			System.out.println("the object is empty");
		}
		else {
			System.out.println("the object is filled!");
			setNewEvent(returnedEvent);
		}
		
		
	}
	
	@FXML
	private void handleAbout() {
		
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Daily To-Do List Application");
        alert.setHeaderText("About Application");
        alert.setContentText("Daily To-Do List Application v1.0\nAuthor: John-f2");

        alert.showAndWait();
		
		
	}
	
	
	@FXML
	private void handleExit() {
		
		Platform.exit();
		
		
		
	}
	
	
    /**
     * sets the mainApp of the controller to the mainApp of the project
     * allows references to be given back 
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;


    }

}
