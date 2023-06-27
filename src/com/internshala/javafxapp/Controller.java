package com.internshala.javafxapp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

	@FXML
	public Label welcomeLabel;

	@FXML
	public ChoiceBox<String> choiceBox;

	@FXML
	public TextField userInputField;

	@FXML
	public Button convertButton;

	private static final String C_TO_F_TEXT = "Celsius to Fahrenheit";
	private static final String F_TO_C_TEXT = "Fahrenheit to Celsius";

	private boolean isC_TO_F = true;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		choiceBox.getItems().add(C_TO_F_TEXT);
		choiceBox.getItems().add(F_TO_C_TEXT);

		choiceBox.setValue(C_TO_F_TEXT);

		choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue.equals(C_TO_F_TEXT))
					isC_TO_F=true;  // if user has selected Celsius to Fahrenheit
			else
				isC_TO_F=false;     // if user has selected Fahrenheit to Celsius
		});

		convertButton.setOnAction(event -> {
			convert();
		});

	}

	private void convert() {

		String input = userInputField.getText();

		float enteredTemp=0.0f;

		try {
			enteredTemp = Float.parseFloat(input);
		}
		catch(Exception e)
		{
			warnUser();
			return;
		}
		float newTemp = 0.0f;

		if(isC_TO_F) //if user has selected Celsius to Fahrenheit
			newTemp = (enteredTemp*9/5)+32;
		else        // if user has selected Fahrenheit to Celsius
			newTemp = (enteredTemp-32)*5/9;

		display(newTemp);
	}

	private void warnUser() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error Occured");
		alert.setHeaderText("Invalid Temperature Entered");
		alert.setContentText("Please enter a valid temperature");
		alert.show();
	}

	private void display(float newTemp) {

		String unit = isC_TO_F?"F":"C";

		System.out.println("The new temperature is: "+newTemp+unit);

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Result");
		alert.setContentText("The new temperature is: "+newTemp+unit);
		alert.show();
	}
}
