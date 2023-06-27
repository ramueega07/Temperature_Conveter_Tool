package com.internshala.javafxapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {

	public static void main(String args[])
	{
		launch(args);
	}

	@Override
	public void init() throws Exception {
		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();

		MenuBar menuBar = createMenu();
		rootNode.getChildren().add(0,menuBar);

		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter Tool");
		primaryStage.getIcons().add(new Image("com/internshala/javafxapp/thermometer-icon-png-9.jpg"));
		primaryStage.show();
	}

	private MenuBar createMenu(){
		Menu fileMenu  = new Menu("File");
		MenuItem newMenuItem = new MenuItem("New");

		newMenuItem.setOnAction(event -> System.out.println("New Menu Item Clicked"));

		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		MenuItem quitMenuItem = new MenuItem("Quit");

		quitMenuItem.setOnAction(event -> {
			Platform.exit();
			System.exit(0);
		});

		fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);

		Menu helpMenu  = new Menu("Help");
		MenuItem aboutApp = new MenuItem("About");

		aboutApp.setOnAction(event -> aboutApp());

		helpMenu.getItems().addAll(aboutApp);

		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu,helpMenu);
		return menuBar;
	}

	private void aboutApp(){

		Alert alertDialog  = new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("Temperature Converter Application");
		alertDialog.setHeaderText("About the developer");

		VBox vBox = new VBox();
		Hyperlink linkedinLink = new Hyperlink("LinkedIn");
		linkedinLink.setOnAction(e->{
			getHostServices().showDocument("https://www.linkedin.com/in/ramueega07/");

		});
		Hyperlink github = new Hyperlink("GitHub");
		github.setOnAction(e->{
			getHostServices().showDocument("https://github.com/ramueega07/");

		});
		vBox.getChildren().addAll(
				new javafx.scene.control.Label("My name is EEGA RAMA KRISHNA. " +
						"I'm a Data Science Aspirant in VJIT "),
				new javafx.scene.control.Label("My field of interest includes building new Web Technologies and Products, Machine Learning, and " +
						"areas related to artificial intelligence and data science."),
				new javafx.scene.control.Label("I live in Hyderabad."),
				new javafx.scene.control.Label("Connect Me Through..!"),
				linkedinLink,
				github
		);

		alertDialog.getDialogPane().setContent(vBox);
		ButtonType okBtn = new ButtonType("OK");


		alertDialog.getButtonTypes().setAll(okBtn);

		Optional<ButtonType> clickedBtn = alertDialog.showAndWait();

	}

	@Override
	public void stop() throws Exception {
		super.stop();
	}
}
