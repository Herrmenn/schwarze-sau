package schwarzeSau;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Pair;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.geometry.Insets;
import javafx.print.PrinterJob;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.imageio.ImageIO;

public class schwarzeSauStart extends Application {

	private Stage window;
	private TableView<Person> table = new TableView<Person>();
	private final ObservableList<Person> data = FXCollections.observableArrayList();
	final HBox hb = new HBox();
	final HBox hb1 = new HBox();
	VBox vbox1 = new VBox();
	private Label label1 = new Label();
	private ArrayList<Person> lList = new ArrayList<Person>();
	Text spieler1Text = new Text("0");
	Text spieler2Text = new Text("0");
	Text spieler3Text = new Text("0");
	Text spieler4Text = new Text("0");
	Text spieler5Text = new Text("0");
	Text spieler6Text = new Text("0");
	Text spieler7Text = new Text("0");
	private int counter = 0;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		List<Integer> choices = new ArrayList<>();
		for (int i = 3; i < 8; i++) {
			choices.add(i);
		}

		ChoiceDialog<Integer> dialog = new ChoiceDialog<>(3, choices);
		Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("http://www.edition-elf.de/forum-pics/pik-dame1.jpg"));
		dialog.setTitle("Wahl");
		dialog.setHeaderText("Wieviele Spieler spielen mit ?");
		dialog.setContentText("Anzahl der Spieler:");
		dialog.getDialogPane().getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		Optional<Integer> result = dialog.showAndWait();

		// The Java 8 way to get the response value (with lambda expression).
		result.ifPresent(number -> starteNamenFenster(number));
	}

	private void starteNamenFenster(int number) {
		final TextField name1 = new TextField();
		name1.setPromptText("Name hier eintragen");
		final TextField name2 = new TextField();
		name2.setPromptText("Name hier eintragen");
		final TextField name3 = new TextField();
		name3.setPromptText("Name hier eintragen");
		final TextField name4 = new TextField();
		name4.setPromptText("Name hier eintragen");
		final TextField name5 = new TextField();
		name5.setPromptText("Name hier eintragen");
		final TextField name6 = new TextField();
		name6.setPromptText("Name hier eintragen");
		final TextField name7 = new TextField();
		name7.setPromptText("Name hier eintragen");
		final TextField maxPoints = new TextField();
		maxPoints.setPromptText("Bis wieviel möchten Sie spielen?");
		// Create the custom dialog.
		Dialog<ButtonType> dialog = new Dialog<>();
		dialog.setTitle("Namen");
		dialog.setHeaderText("Bitte Namen hier eintragen:");

		// Set the button types.
		ButtonType loginButtonType = new ButtonType("Hinzuf�gen", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

		// Create the username and password labels and fields.
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		switch (number) {
		case 3:
			grid.add(new Label("Name:"), 0, 0);
			grid.add(name1, 1, 0);

			grid.add(new Label("Name:"), 0, 1);
			grid.add(name2, 1, 1);

			grid.add(new Label("Name:"), 0, 2);
			grid.add(name3, 1, 2);
			
			grid.add(new Label("Punkte: "), 0, 3);
			grid.add(maxPoints,1,3);
			break;
		case 4:
			grid.add(new Label("Name:"), 0, 0);
			grid.add(name1, 1, 0);

			grid.add(new Label("Name:"), 0, 1);
			grid.add(name2, 1, 1);

			grid.add(new Label("Name:"), 0, 2);
			grid.add(name3, 1, 2);

			grid.add(new Label("Name:"), 0, 3);
			grid.add(name4, 1, 3);
			
			grid.add(new Label("Punkte: "), 0, 4);
			grid.add(maxPoints,1,4);
			break;
		case 5:
			grid.add(new Label("Name:"), 0, 0);
			grid.add(name1, 1, 0);

			grid.add(new Label("Name:"), 0, 1);
			grid.add(name2, 1, 1);

			grid.add(new Label("Name:"), 0, 2);
			grid.add(name3, 1, 2);

			grid.add(new Label("Name:"), 0, 3);
			grid.add(name4, 1, 3);

			grid.add(new Label("Name:"), 0, 4);
			grid.add(name5, 1, 4);
			
			grid.add(new Label("Punkte: "), 0, 5);
			grid.add(maxPoints,1,5);
			break;
		case 6:
			grid.add(new Label("Name:"), 0, 0);
			grid.add(name1, 1, 0);

			grid.add(new Label("Name:"), 0, 1);
			grid.add(name2, 1, 1);

			grid.add(new Label("Name:"), 0, 2);
			grid.add(name3, 1, 2);

			grid.add(new Label("Name:"), 0, 3);
			grid.add(name4, 1, 3);

			grid.add(new Label("Name:"), 0, 4);
			grid.add(name5, 1, 4);

			grid.add(new Label("Name:"), 0, 5);
			grid.add(name6, 1, 5);
			
			grid.add(new Label("Punkte: "), 1, 0);
			grid.add(maxPoints,1,6);
			break;
			
		case 7: 
			grid.add(new Label("Name:"), 0, 0);
			grid.add(name1, 1, 0);

			grid.add(new Label("Name:"), 0, 1);
			grid.add(name2, 1, 1);

			grid.add(new Label("Name:"), 0, 2);
			grid.add(name3, 1, 2);

			grid.add(new Label("Name:"), 0, 3);
			grid.add(name4, 1, 3);

			grid.add(new Label("Name:"), 0, 4);
			grid.add(name5, 1, 4);

			grid.add(new Label("Name:"), 0, 5);
			grid.add(name6, 1, 5);
			
			grid.add(new Label("Name:"), 0, 6);
			grid.add(name7, 1, 6);
			
			grid.add(new Label("Punkte: "), 0, 7);
			grid.add(maxPoints,1,7);
			break;
		default:
			break;
		}
		Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("http://www.edition-elf.de/forum-pics/pik-dame1.jpg"));
		dialog.getDialogPane().setContent(grid);
		dialog.getDialogPane().getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		Optional<ButtonType> result = dialog.showAndWait();
		if (result.get() == loginButtonType){
			starteMainWindow(name1.getText(), name2.getText(), name3.getText(), name4.getText(), name5.getText(),
					name6.getText(), name7.getText(), maxPoints.getText(), window, number);
		}
	}

	@SuppressWarnings("unchecked")
	private void starteMainWindow(String text, String text2, String text3, String text4, String text5, String text6,
			String text7, String maxPoints, Stage stage, int number) {

		Scene scene = new Scene(new Group());
		stage.setTitle("Schwarze Sau");
		switch (number) {
		case 3:
			stage.setWidth(770);
			break;
		case 4:
			stage.setWidth(870);
			break;
		case 5:
			stage.setWidth(970);
			break;
		case 6:
			stage.setWidth(1070);
			break;
		case 7:
			stage.setWidth(1170);
		}
		stage.setHeight(550);

		final Label label = new Label("Schwarze Sau");
		label.setFont(new Font("Arial", 20));

		table.setEditable(true);

		TableColumn firstNameCol = new TableColumn(text);
		firstNameCol.setPrefWidth(100);
		firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
		firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
		firstNameCol.setOnEditCommit(new EventHandler<CellEditEvent<Person, String>>() {
			@Override
			public void handle(CellEditEvent<Person, String> t) {
				((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFirstName(t.getNewValue());
				getSummeDerRunden();
				checkRestwert(((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())));
			}
		});
		firstNameCol.getStyleClass().add("active");
		counter++;

		TableColumn lastNameCol = new TableColumn(text2);
		lastNameCol.setPrefWidth(100);
		lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
		lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
		lastNameCol.setOnEditCommit(new EventHandler<CellEditEvent<Person, String>>() {
			@Override
			public void handle(CellEditEvent<Person, String> t) {
				((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setLastName(t.getNewValue());
				getSummeDerRunden();
				checkRestwert(((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())));
			}
		});

		TableColumn emailCol = new TableColumn(text3);
		emailCol.setPrefWidth(100);
		emailCol.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
		emailCol.setCellFactory(TextFieldTableCell.forTableColumn());
		emailCol.setOnEditCommit(new EventHandler<CellEditEvent<Person, String>>() {
			@Override
			public void handle(CellEditEvent<Person, String> t) {
				((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setEmail(t.getNewValue());
				getSummeDerRunden();
				checkRestwert(((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())));
			}

		});

		TableColumn restwert = new TableColumn("Restwert");
		restwert.setPrefWidth(100);
		restwert.setCellValueFactory(new PropertyValueFactory<Person, String>("summe"));

		TableColumn fourthPlayer = new TableColumn(text4);
		fourthPlayer.setPrefWidth(100);
		fourthPlayer.setCellValueFactory(new PropertyValueFactory<Person, String>("punkte3"));
		fourthPlayer.setCellFactory(TextFieldTableCell.forTableColumn());
		fourthPlayer.setOnEditCommit(new EventHandler<CellEditEvent<Person, String>>() {
			@Override
			public void handle(CellEditEvent<Person, String> t) {
				((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPunkte3(t.getNewValue());
				getSummeDerRunden();
				checkRestwert(((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())));
			}
		});

		TableColumn fifthPlayer = new TableColumn(text5);
		fifthPlayer.setPrefWidth(100);
		fifthPlayer.setCellValueFactory(new PropertyValueFactory<Person, String>("punkte4"));
		fifthPlayer.setCellFactory(TextFieldTableCell.forTableColumn());
		fifthPlayer.setOnEditCommit(new EventHandler<CellEditEvent<Person, String>>() {
			@Override
			public void handle(CellEditEvent<Person, String> t) {
				((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPunkte4(t.getNewValue());
				getSummeDerRunden();
				checkRestwert(((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())));
			}
		});

		TableColumn sixthPlayer = new TableColumn(text6);
		sixthPlayer.setPrefWidth(100);
		sixthPlayer.setCellValueFactory(new PropertyValueFactory<Person, String>("punkte5"));
		sixthPlayer.setCellFactory(TextFieldTableCell.forTableColumn());
		sixthPlayer.setOnEditCommit(new EventHandler<CellEditEvent<Person, String>>() {
			@Override
			public void handle(CellEditEvent<Person, String> t) {
				((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPunkte5(t.getNewValue());
				getSummeDerRunden();
				checkRestwert(((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())));
			}
		});
		
		TableColumn seventhPlayer = new TableColumn(text7);
		seventhPlayer.setPrefWidth(100);
		seventhPlayer.setCellValueFactory(new PropertyValueFactory<Person, String>("punkte6"));
		seventhPlayer.setCellFactory(TextFieldTableCell.forTableColumn());
		seventhPlayer.setOnEditCommit(new EventHandler<CellEditEvent<Person, String>>() {
			@Override
			public void handle(CellEditEvent<Person, String> t) {
				((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPunkte6(t.getNewValue());
				getSummeDerRunden();
				checkRestwert(((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())));
			}
		});

		table.setItems(data);

		final TextField addPoints1 = new TextField();
		addPoints1.setPromptText("Punkte " + text);
		addPoints1.setMaxWidth(firstNameCol.getPrefWidth());
		final TextField addPoints2 = new TextField();
		addPoints2.setMaxWidth(lastNameCol.getPrefWidth());
		addPoints2.setPromptText("Punkte " + text2);
		final TextField addPoints3 = new TextField();
		addPoints3.setMaxWidth(emailCol.getPrefWidth());
		addPoints3.setPromptText("Punkte " + text3);
		final TextField addPoints4 = new TextField();
		addPoints4.setMaxWidth(fourthPlayer.getPrefWidth());
		addPoints4.setPromptText("Punkte " + text4);
		final TextField addPoints5 = new TextField();
		addPoints5.setMaxWidth(fifthPlayer.getPrefWidth());
		addPoints5.setPromptText("Punkte " + text5);
		final TextField addPoints6 = new TextField();
		addPoints6.setMaxWidth(sixthPlayer.getPrefWidth());
		addPoints6.setPromptText("Punkte " + text6);
		final TextField addPoints7 = new TextField();
		addPoints7.setMaxWidth(sixthPlayer.getPrefWidth());
		addPoints7.setPromptText("Punkte " + text7);
		final TextField quotes = new TextField();
		quotes.setPrefWidth(200);
		quotes.setPromptText("Spruch hier eintippen");

		final Button addButton = new Button("Add");
		addButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Person person = null;
				switch (number) {
				case 3:
					person = new Person(addPoints1.getText(), addPoints2.getText(), addPoints3.getText(), "0");
					break;
				case 4:
					person = new Person(addPoints1.getText(), addPoints2.getText(), addPoints3.getText(),
							addPoints4.getText(), "0");
					break;
				case 5:
					person = new Person(addPoints1.getText(), addPoints2.getText(), addPoints3.getText(),
							addPoints4.getText(), addPoints5.getText(), "0");
					break;
				case 6:
					person = new Person(addPoints1.getText(), addPoints2.getText(), addPoints3.getText(),
							addPoints4.getText(), addPoints5.getText(), addPoints6.getText(), "0");
					break;
				case 7:
					person = new Person(addPoints1.getText(), addPoints2.getText(), addPoints3.getText(),
							addPoints4.getText(), addPoints5.getText(), addPoints6.getText(), addPoints7.getText(), "0");
					break;
				default:
					System.out.println("FEHLER!! Keine number!");
				}
				changeGeber();
				checkRestwert(person);
				data.add(person);
				lList.add(person);
				getSummeDerRunden();

				addPoints1.clear();
				addPoints2.clear();
				addPoints3.clear();
				addPoints4.clear();
				addPoints5.clear();
				addPoints6.clear();
				addPoints7.clear();
			}

			private void changeGeber() {
				if (counter == number) {
					counter = 0;
				}
				switch(counter) {
				case 0: firstNameCol.getStyleClass().add("active");
				lastNameCol.getStyleClass().remove("active");
				emailCol.getStyleClass().remove("active");
				fourthPlayer.getStyleClass().remove("active");
				fifthPlayer.getStyleClass().remove("active");
				sixthPlayer.getStyleClass().remove("active");
				seventhPlayer.getStyleClass().remove("active");
					break;
				case 1: firstNameCol.getStyleClass().remove("active");
				lastNameCol.getStyleClass().add("active");
				emailCol.getStyleClass().remove("active");
				fourthPlayer.getStyleClass().remove("active");
				fifthPlayer.getStyleClass().remove("active");
				sixthPlayer.getStyleClass().remove("active");
				seventhPlayer.getStyleClass().remove("active");
					break;
				case 2: firstNameCol.getStyleClass().remove("active");
				lastNameCol.getStyleClass().remove("active");
				emailCol.getStyleClass().add("active");
				fourthPlayer.getStyleClass().remove("active");
				fifthPlayer.getStyleClass().remove("active");
				sixthPlayer.getStyleClass().remove("active");
				seventhPlayer.getStyleClass().remove("active");
					break;
				case 3: firstNameCol.getStyleClass().remove("active");
				lastNameCol.getStyleClass().remove("active");
				emailCol.getStyleClass().remove("active");
				fourthPlayer.getStyleClass().add("active");
				fifthPlayer.getStyleClass().remove("active");
				sixthPlayer.getStyleClass().remove("active");
				seventhPlayer.getStyleClass().remove("active");
					break;
				case 4: firstNameCol.getStyleClass().remove("active");
				lastNameCol.getStyleClass().remove("active");
				emailCol.getStyleClass().remove("active");
				fourthPlayer.getStyleClass().remove("active");
				fifthPlayer.getStyleClass().add("active");
				sixthPlayer.getStyleClass().remove("active");
				seventhPlayer.getStyleClass().remove("active");
					break;
				case 5: firstNameCol.getStyleClass().remove("active");
				lastNameCol.getStyleClass().remove("active");
				emailCol.getStyleClass().remove("active");
				fourthPlayer.getStyleClass().remove("active");
				fifthPlayer.getStyleClass().remove("active");
				sixthPlayer.getStyleClass().add("active");
				seventhPlayer.getStyleClass().remove("active");
					break;
				case 6: firstNameCol.getStyleClass().remove("active");
				lastNameCol.getStyleClass().remove("active");
				emailCol.getStyleClass().remove("active");
				fourthPlayer.getStyleClass().remove("active");
				fifthPlayer.getStyleClass().remove("active");
				sixthPlayer.getStyleClass().remove("active");
				seventhPlayer.getStyleClass().add("active");
					break;
				}
				counter++;
				
				// TODO Auto-generated method stub
				
			}

		});

		final Button addButton2 = new Button("Add");
		addButton2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				String newStr = label1.getText() + "\n" + quotes.getText();
			label1.setText(newStr);
			quotes.clear();
			}
		});
		
		final Button clearButton = new Button("Clear");
		clearButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				label1.setText("");
			}
		});

		spieler1Text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
		spieler1Text.setFill(javafx.scene.paint.Color.rgb(101, 177, 252));
		spieler2Text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
		spieler2Text.setFill(javafx.scene.paint.Color.rgb(101, 177, 252));
		spieler3Text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
		spieler3Text.setFill(javafx.scene.paint.Color.rgb(101, 177, 252));
		spieler4Text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
		spieler4Text.setFill(javafx.scene.paint.Color.rgb(101, 177, 252));
		spieler5Text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
		spieler5Text.setFill(javafx.scene.paint.Color.rgb(101, 177, 252));
		spieler6Text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
		spieler6Text.setFill(javafx.scene.paint.Color.rgb(101, 177, 252));
		spieler7Text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
		spieler7Text.setFill(javafx.scene.paint.Color.rgb(101, 177, 252));
		
		label1.getStyleClass().add("label1");
		label1.setWrapText(true);
		label1.setTextAlignment(TextAlignment.CENTER);
		switch (number) {
		case 3:
			table.getColumns().addAll(firstNameCol, lastNameCol, emailCol, restwert);
			spieler1Text.setLayoutX(40);
			spieler1Text.setLayoutY(500);
			spieler2Text.setLayoutX(140);
			spieler2Text.setLayoutY(500);
			spieler3Text.setLayoutX(240);
			spieler3Text.setLayoutY(500);
			label1.setPrefSize(290, 395);
			label1.setLayoutX(450);
			label1.setLayoutY(40);
			quotes.setLayoutX(450);
			quotes.setLayoutY(445);
			addButton2.setLayoutX(650);
			addButton2.setLayoutY(445);
			clearButton.setLayoutX(690);
			clearButton.setLayoutY(445);
			hb.getChildren().addAll(addPoints1, addPoints2, addPoints3, addButton, clearButton);
			break;
		case 4:
			table.getColumns().addAll(firstNameCol, lastNameCol, emailCol, fourthPlayer, restwert);
			spieler1Text.setLayoutX(40);
			spieler1Text.setLayoutY(500);
			spieler2Text.setLayoutX(140);
			spieler2Text.setLayoutY(500);
			spieler3Text.setLayoutX(240);
			spieler3Text.setLayoutY(500);
			spieler4Text.setLayoutX(340);
			spieler4Text.setLayoutY(500);
			label1.setPrefSize(290, 395);
			label1.setLayoutX(550);
			label1.setLayoutY(40);
			quotes.setLayoutX(550);
			quotes.setLayoutY(445);
			addButton2.setLayoutX(750);
			addButton2.setLayoutY(445);
			clearButton.setLayoutX(790);
			clearButton.setLayoutY(445);
			hb.getChildren().addAll(addPoints1, addPoints2, addPoints3, addPoints4, addButton,clearButton);
			break;
		case 5:
			table.getColumns().addAll(firstNameCol, lastNameCol, emailCol, fourthPlayer, fifthPlayer, restwert);
			spieler1Text.setLayoutX(40);
			spieler1Text.setLayoutY(500);
			spieler2Text.setLayoutX(140);
			spieler2Text.setLayoutY(500);
			spieler3Text.setLayoutX(240);
			spieler3Text.setLayoutY(500);
			spieler4Text.setLayoutX(340);
			spieler4Text.setLayoutY(500);
			spieler5Text.setLayoutX(440);
			spieler5Text.setLayoutY(500);
			label1.setPrefSize(290, 395);
			label1.setLayoutX(650);
			label1.setLayoutY(40);
			quotes.setLayoutX(650);
			quotes.setLayoutY(445);
			addButton2.setLayoutX(850);
			addButton2.setLayoutY(445);
			clearButton.setLayoutX(890);
			clearButton.setLayoutY(445);
			hb.getChildren().addAll(addPoints1, addPoints2, addPoints3, addPoints4, addPoints5, addButton);
			break;
		case 6:
			table.getColumns().addAll(firstNameCol, lastNameCol, emailCol, fourthPlayer, fifthPlayer, sixthPlayer,
					restwert);
			spieler1Text.setLayoutX(40);
			spieler1Text.setLayoutY(500);
			spieler2Text.setLayoutX(140);
			spieler2Text.setLayoutY(500);
			spieler3Text.setLayoutX(240);
			spieler3Text.setLayoutY(500);
			spieler4Text.setLayoutX(340);
			spieler4Text.setLayoutY(500);
			spieler5Text.setLayoutX(440);
			spieler5Text.setLayoutY(500);
			spieler6Text.setLayoutX(540);
			spieler6Text.setLayoutY(500);
			label1.setPrefSize(290, 395);
			label1.setLayoutX(750);
			label1.setLayoutY(40);
			quotes.setLayoutX(750);
			quotes.setLayoutY(445);
			addButton2.setLayoutX(950);
			addButton2.setLayoutY(445);
			clearButton.setLayoutX(990);
			clearButton.setLayoutY(445);
			hb.getChildren().addAll(addPoints1, addPoints2, addPoints3, addPoints4, addPoints5, addPoints6, addButton);
			break;
		case 7:
			table.getColumns().addAll(firstNameCol, lastNameCol, emailCol, fourthPlayer, fifthPlayer, sixthPlayer, seventhPlayer,
					restwert);
			spieler1Text.setLayoutX(40);
			spieler1Text.setLayoutY(500);
			spieler2Text.setLayoutX(140);
			spieler2Text.setLayoutY(500);
			spieler3Text.setLayoutX(240);
			spieler3Text.setLayoutY(500);
			spieler4Text.setLayoutX(340);
			spieler4Text.setLayoutY(500);
			spieler5Text.setLayoutX(440);
			spieler5Text.setLayoutY(500);
			spieler6Text.setLayoutX(540);
			spieler6Text.setLayoutY(500);
			spieler7Text.setLayoutX(640);
			spieler7Text.setLayoutY(500);
			label1.setPrefSize(290, 395);
			label1.setLayoutX(850);
			label1.setLayoutY(40);
			quotes.setLayoutX(850);
			quotes.setLayoutY(445);
			addButton2.setLayoutX(1050);
			addButton2.setLayoutY(445);
			clearButton.setLayoutX(1090);
			clearButton.setLayoutY(445);
			hb.getChildren().addAll(addPoints1, addPoints2, addPoints3, addPoints4, addPoints5, addPoints6, addPoints7, addButton);
			break;
		default:
			System.out.println("FEHLER!! Keine number!");
		}

		hb.setSpacing(0);

		hb1.getChildren().addAll(table, vbox1, label1);
		hb1.setSpacing(10);

		final VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(label, hb1, hb, label1);

		Button printSceneButton = new Button("Save as PNG");
		printSceneButton.setLayoutX(200);
		printSceneButton.setLayoutY(10);
		
		printSceneButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				WritableImage snapshot = scene.snapshot(null);
				File file = new File(new SimpleDateFormat("yyyyMMdd_HHmm").format(Calendar.getInstance().getTime())+".png");
				try {
				    ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", file);
				    
				} catch (IOException e) {
				    e.printStackTrace();
				}
			}
		});

		switch (number) {
		case 3:
			((Group) scene.getRoot()).getChildren().addAll(vbox, spieler1Text, spieler2Text, spieler3Text, quotes,
					addButton2, vbox1, printSceneButton, label1, clearButton);
			break;
		case 4:
			((Group) scene.getRoot()).getChildren().addAll(vbox, spieler1Text, spieler2Text, spieler3Text, spieler4Text,
					quotes, addButton2, vbox1, printSceneButton, label1,clearButton);
			break;
		case 5:
			((Group) scene.getRoot()).getChildren().addAll(vbox, spieler1Text, spieler2Text, spieler3Text, spieler4Text,
					spieler5Text, quotes, addButton2, vbox1, printSceneButton,label1,clearButton);
			break;
		case 6:
			((Group) scene.getRoot()).getChildren().addAll(vbox, spieler1Text, spieler2Text, spieler3Text, spieler4Text,
					spieler5Text, spieler6Text, quotes, addButton2, vbox1, printSceneButton,label1,clearButton);
			break;
		case 7:
			((Group) scene.getRoot()).getChildren().addAll(vbox, spieler1Text, spieler2Text, spieler3Text, spieler4Text,
					spieler5Text, spieler6Text,spieler7Text, quotes, addButton2, vbox1, printSceneButton,label1,clearButton);
			break;
		}
		int fifty = 50;
		scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		scene.setFill(javafx.scene.paint.Color.rgb(fifty, fifty, fifty));
		stage.setScene(scene);
		stage.show();
		stage.getIcons().add(new Image("http://www.edition-elf.de/forum-pics/pik-dame1.jpg"));
		
	}

	private void getSummeDerRunden() {
		int summe1 = 0;
		int summe2 = 0;
		int summe3 = 0;
		int summe4 = 0;
		int summe5 = 0;
		int summe6 = 0;
		int summe7 = 0;

		for (Person person : lList) {
			if (person.getFirstName().trim().isEmpty()) {
				summe1 += 0;
			} else {
				summe1 += Integer.parseInt(person.getFirstName());
			}
			if (person.getLastName().trim().isEmpty()) {
				summe2 += 0;
			} else {
				summe2 += Integer.parseInt(person.getLastName());
			}
			if (person.getEmail().trim().isEmpty()) {
				summe3 += 0;
			} else {
				summe3 += Integer.parseInt(person.getEmail());
			}
			if (person.getPunkte3().trim().isEmpty()) {
				summe4 += 0;
			} else {
				summe4 += Integer.parseInt(person.getPunkte3());
			}
			if (person.getPunkte4().trim().isEmpty()) {
				summe5 += 0;
			} else {
				summe5 += Integer.parseInt(person.getPunkte4());
			}
			if (person.getPunkte5().trim().isEmpty()) {
				summe6 += 0;
			}else {
				summe6 += Integer.parseInt(person.getPunkte5());
			}
			if (person.getPunkte6().trim().isEmpty()){
				summe7 += 0;
			}else{
				summe7 += Integer.parseInt(person.getPunkte6());
			}
		
		}
		if(summe1 >= 900) {
			spieler1Text.setFill(javafx.scene.paint.Color.rgb(234, 234, 70));
		}
		else if(summe2 >= 900) {
			spieler2Text.setFill(javafx.scene.paint.Color.rgb(234, 234, 70));
		}
		else if(summe3 >= 900) {
			spieler3Text.setFill(javafx.scene.paint.Color.rgb(234, 234, 70));
		}
		else if(summe4 >= 900) {
			spieler4Text.setFill(javafx.scene.paint.Color.rgb(234, 234, 70));
		}
		else if(summe5 >= 900) {
			spieler5Text.setFill(javafx.scene.paint.Color.rgb(234, 234, 70));
		}
		else if(summe6 >= 900) {
			spieler6Text.setFill(javafx.scene.paint.Color.rgb(234, 234, 70));
		}
		else if(summe7 >= 900) {
			spieler7Text.setFill(javafx.scene.paint.Color.rgb(234, 234, 70));
		}
		else if(summe1 >= 1000) {
			spieler1Text.setFill(javafx.scene.paint.Color.rgb(214, 54, 42));
		}
		else if(summe2 >= 1000) {
			spieler2Text.setFill(javafx.scene.paint.Color.rgb(214, 54, 42));
		}
		else if(summe3 >= 1000) {
			spieler3Text.setFill(javafx.scene.paint.Color.rgb(214, 54, 42));
		}
		else if(summe4 >= 1000) {
			spieler4Text.setFill(javafx.scene.paint.Color.rgb(214, 54, 42));
		}
		else if(summe5 >= 1000) {
			spieler5Text.setFill(javafx.scene.paint.Color.rgb(214, 54, 42));
		}
		else if(summe6 >= 1000) {
			spieler6Text.setFill(javafx.scene.paint.Color.rgb(214, 54, 42));
		}
		else if(summe7 >= 1000) {
			spieler7Text.setFill(javafx.scene.paint.Color.rgb(214, 54, 42));
		}
		else {
			
		}
		spieler1Text.setText(Integer.toString(summe1));
		spieler2Text.setText(Integer.toString(summe2));
		spieler3Text.setText(Integer.toString(summe3));
		spieler4Text.setText(Integer.toString(summe4));
		spieler5Text.setText(Integer.toString(summe5));
		spieler6Text.setText(Integer.toString(summe6));
		spieler7Text.setText(Integer.toString(summe7));

	}

	private void checkRestwert(Person person) {
		int punkte0 = 0;
		int punkte1 = 0;
		int punkte2 = 0;
		int punkte3 = 0;
		int punkte4 = 0;
		int punkte5 = 0;
		int punkte6 = 0;
		if (person.getEmail().trim().isEmpty() || person.getEmail() == null) {
			punkte0 = 0;
		} else {
			punkte0 = Integer.parseInt(person.getEmail());
		}
		if (person.getFirstName().trim().isEmpty() || person.getFirstName() == null) {
			punkte1 = 0;
		} else {
			punkte1 = Integer.parseInt(person.getFirstName());
		}
		if (person.getLastName().trim().isEmpty() || person.getLastName() == null) {
			punkte2 = 0;
		} else {
			punkte2 = Integer.parseInt(person.getLastName());
		}
		if (person.getPunkte3().trim().isEmpty() || person.getPunkte3() == null) {
			punkte3 = 0;
		} else {
			punkte3 = Integer.parseInt(person.getPunkte3());
		}
		if (person.getPunkte4().trim().isEmpty() || person.getPunkte4() == null) {
			punkte4 = 0;
		} else {
			punkte4 = Integer.parseInt(person.getPunkte4());
		}
		if (person.getPunkte5().trim().isEmpty() || person.getPunkte5() == null) {
			punkte5 = 0;
		} else {
			punkte5 = Integer.parseInt(person.getPunkte5());
		}
		if (person.getPunkte6().trim().isEmpty() || person.getPunkte6() == null) {
			punkte5 = 0;
		} else {
			punkte5 = Integer.parseInt(person.getPunkte6());
		}

		int summeInt = - punkte0 - punkte1 - punkte2 - punkte3 - punkte4 - punkte5 - punkte6 + 220;
		String summe = String.valueOf(summeInt);
		person.setSumme(summe);
	}

	public static class Person {

		private final SimpleStringProperty firstName;
		private final SimpleStringProperty lastName;
		private final SimpleStringProperty email;
		private final SimpleStringProperty punkte3;
		private final SimpleStringProperty punkte4;
		private final SimpleStringProperty punkte5;
		private final SimpleStringProperty punkte6;

		private final SimpleStringProperty summe;

		private Person(String fName, String lName, String email, String punkte3, String punkte4, String punkte5, String punkte6,
				String summe1) {
			this.firstName = new SimpleStringProperty(fName);
			this.lastName = new SimpleStringProperty(lName);
			this.email = new SimpleStringProperty(email);
			this.punkte3 = new SimpleStringProperty(punkte3);
			this.punkte4 = new SimpleStringProperty(punkte4);
			this.punkte5 = new SimpleStringProperty(punkte5);
			this.punkte6 = new SimpleStringProperty(punkte6);
			this.summe = new SimpleStringProperty(summe1);
		}
		
		private Person(String fName, String lName, String email, String punkte3, String punkte4, String punkte5,
				String summe1) {
			this.firstName = new SimpleStringProperty(fName);
			this.lastName = new SimpleStringProperty(lName);
			this.email = new SimpleStringProperty(email);
			this.punkte3 = new SimpleStringProperty(punkte3);
			this.punkte4 = new SimpleStringProperty(punkte4);
			this.punkte5 = new SimpleStringProperty(punkte5);
			this.punkte6 = new SimpleStringProperty("");
			this.summe = new SimpleStringProperty(summe1);
		}

		private Person(String fName, String lName, String email, String summe1) {
			this.firstName = new SimpleStringProperty(fName);
			this.lastName = new SimpleStringProperty(lName);
			this.email = new SimpleStringProperty(email);
			this.punkte3 = new SimpleStringProperty("");
			this.punkte4 = new SimpleStringProperty("");
			this.punkte5 = new SimpleStringProperty("");
			this.punkte6 = new SimpleStringProperty("");
			this.summe = new SimpleStringProperty(summe1);
		}

		private Person(String text, String text2, String text3, String text4, String string) {
			this.firstName = new SimpleStringProperty(text);
			this.lastName = new SimpleStringProperty(text2);
			this.email = new SimpleStringProperty(text3);
			this.punkte3 = new SimpleStringProperty(text4);
			this.punkte4 = new SimpleStringProperty("");
			this.punkte5 = new SimpleStringProperty("");
			this.punkte6 = new SimpleStringProperty("");
			this.summe = new SimpleStringProperty(string);
		}

		private Person(String text, String text2, String text3, String text4, String text5, String string) {
			this.firstName = new SimpleStringProperty(text);
			this.lastName = new SimpleStringProperty(text2);
			this.email = new SimpleStringProperty(text3);
			this.punkte3 = new SimpleStringProperty(text4);
			this.punkte4 = new SimpleStringProperty(text5);
			this.punkte5 = new SimpleStringProperty("");
			this.punkte6 = new SimpleStringProperty("");
			this.summe = new SimpleStringProperty(string);
		}

		public String getFirstName() {
			return firstName.get();
		}

		public void setFirstName(String fName) {
			firstName.set(fName);
		}

		public String getPunkte3() {
			return punkte3.get();
		}

		public void setPunkte3(String fName) {
			punkte3.set(fName);
		}

		public String getPunkte4() {
			return punkte4.get();
		}

		public void setPunkte4(String fName) {
			punkte4.set(fName);
		}

		public String getPunkte5() {
			return punkte5.get();
		}

		public void setPunkte5(String fName) {
			punkte5.set(fName);
		}
		
		public String getPunkte6() {
			return punkte6.get();
		}

		public void setPunkte6(String fName) {
			punkte6.set(fName);
		}

		public String getLastName() {
			return lastName.get();
		}

		public void setLastName(String fName) {
			lastName.set(fName);
		}

		public String getEmail() {
			return email.get();
		}

		public void setEmail(String fName) {
			email.set(fName);
		}

		public String getSumme() {
			return summe.get();
		}

		public void setSumme(String fSumme) {
			summe.set(fSumme);
		}
	}
}