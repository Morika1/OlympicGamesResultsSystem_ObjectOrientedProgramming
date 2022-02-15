package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.Model;
import model.OlympicGames;

public class View {

	// buttons:
	private Button showAllStadiums;
	private Button showAllParticipants;
	private Button showAllCompatitions;
	private Button showAllCountriesChartByMedals;
	private Button allParticipants;
	private Button runners;
	private Button jumpers;
	private Button runnersAndJumpers;
	private Button allCompatitions;
	private Button teamCompatitions;
	private Button individualCompatition;
	private Button exit;
	private Button running;
	private Button jumping;
	private Button date;

	// layouts:
	private VBox leftMenu;
	private BorderPane bp;
	private ScrollPane sp;
	private HBox stadiums;
	private HBox participants;
	private HBox compatitions;
	private VBox all;
	private HBox sportTypes;
	private VBox compatitionsSportType;

	// outputs:
	private Label output;
	private Label welcome;

	private String function;

	public View(Stage primaryStage) {
		// buttons:
		showAllStadiums = new Button("Show all stadiums");
		showAllStadiums.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		showAllStadiums.setPrefSize(180, 30);
		showAllStadiums.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		showAllStadiums.setTextFill(Color.WHITE);

		showAllParticipants = new Button("Show all participants");
		showAllParticipants.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		showAllParticipants.setPrefSize(180, 30);
		showAllParticipants
				.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		showAllParticipants.setTextFill(Color.WHITE);

		showAllCompatitions = new Button("Show all compatitions");
		showAllCompatitions.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		showAllCompatitions.setPrefSize(180, 30);
		showAllCompatitions
				.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		showAllCompatitions.setTextFill(Color.WHITE);

		showAllCountriesChartByMedals = new Button("Show all countries chart by medals");
		showAllCountriesChartByMedals.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		showAllCountriesChartByMedals.setPrefSize(260, 30);
		showAllCountriesChartByMedals
				.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		showAllCountriesChartByMedals.setTextFill(Color.WHITE);

		allParticipants = new Button("All participants");
		allParticipants.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		allParticipants.setPrefSize(180, 30);
		allParticipants.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		allParticipants.setTextFill(Color.WHITE);

		runners = new Button("Runners");
		runners.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		runners.setPrefSize(180, 30);
		runners.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		runners.setTextFill(Color.WHITE);

		jumpers = new Button("Jumpers");
		jumpers.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		jumpers.setPrefSize(180, 30);
		jumpers.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		jumpers.setTextFill(Color.WHITE);

		runnersAndJumpers = new Button("Runners And Jumpers");
		runnersAndJumpers.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		runnersAndJumpers.setPrefSize(180, 30);
		runnersAndJumpers.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		runnersAndJumpers.setTextFill(Color.WHITE);

		allCompatitions = new Button("All compatitions");
		allCompatitions.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		allCompatitions.setPrefSize(180, 30);
		allCompatitions.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		allCompatitions.setTextFill(Color.WHITE);

		teamCompatitions = new Button("All compatitions");
		teamCompatitions.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		teamCompatitions.setPrefSize(180, 30);
		teamCompatitions.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		teamCompatitions.setTextFill(Color.WHITE);

		individualCompatition = new Button("All compatitions");
		individualCompatition.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		individualCompatition.setPrefSize(180, 30);
		individualCompatition
				.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		individualCompatition.setTextFill(Color.WHITE);

		exit = new Button("Exit");
		exit.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		exit.setPrefSize(140, 30);
		exit.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		exit.setTextFill(Color.WHITE);

		running = new Button("Running");
		running.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		running.setPrefSize(140, 30);
		running.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		running.setTextFill(Color.WHITE);

		jumping = new Button("Jumping");
		jumping.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		jumping.setPrefSize(140, 30);
		jumping.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		jumping.setTextFill(Color.WHITE);

		date = new Button("Date");
		date.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		date.setPrefSize(140, 30);
		date.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		date.setTextFill(Color.WHITE);

		// outputs:
		output = new Label();
		output.setText("");
		output.setLayoutX(500);
		output.setLayoutY(500);
		output.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		output.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		output.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		output.setTextFill(Color.WHITE);
		output.setWrapText(true);
		output.setMaxWidth(1000);
		output.wrapTextProperty();

		welcome = new Label();
		welcome.setText("");
		welcome.setLayoutX(500);
		welcome.setLayoutY(500);
		welcome.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
		welcome.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		welcome.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		welcome.setTextFill(Color.WHITE);
		welcome.setWrapText(true);
		welcome.setMaxWidth(500);
		welcome.wrapTextProperty();

		// layouts:
		leftMenu = new VBox();
		bp = new BorderPane();
		sp = new ScrollPane();
		stadiums = new HBox();
		participants = new HBox();
		compatitions = new HBox();
		all = new VBox();
		sportTypes = new HBox();
		compatitionsSportType = new VBox();

		// connection between all:
		participants.getChildren().addAll(allParticipants, runners, jumpers, runnersAndJumpers);
		compatitions.getChildren().addAll(allCompatitions, individualCompatition, teamCompatitions);

		sportTypes.getChildren().addAll(running, jumping);
		sportTypes.setSpacing(20);

		stadiums.setSpacing(40);
		participants.setSpacing(40);
		compatitions.setSpacing(40);

		all.getChildren().addAll(stadiums, participants, compatitions, sportTypes);
		all.setSpacing(20);

		bp.setCenter(all);

		leftMenu.getChildren().addAll(showAllStadiums, showAllParticipants, showAllCompatitions,
				showAllCountriesChartByMedals, date, exit);
		bp.setLeft(leftMenu);

		BorderPane.setMargin(leftMenu, new Insets(20, 40, 20, 20));
		leftMenu.setSpacing(10);

		bp.setRight(sp);
		sp.setFitToWidth(true);
		sp.setContent(output);

		bp.setTop(welcome);

		all.setVisible(false);
		allParticipants.setVisible(false);
		runners.setVisible(false);
		jumpers.setVisible(false);
		runnersAndJumpers.setVisible(false);
		allCompatitions.setDisable(false);
		output.setVisible(false);
		allCompatitions.setVisible(false);
		welcome.setVisible(true);
		welcome.setText("Welcome to Olympic Games");

		Rectangle2D screen = Screen.getPrimary().getBounds();
		Scene scene = new Scene(bp, screen.getMaxX() - 50, screen.getMaxY() - 130);

		primaryStage.setScene(scene);
		primaryStage.setFullScreen(false);
		primaryStage.show();
	}

	// show view+connection to the Model(management system)
	public void date(Model theModel) {
		function = "date";
		date.setVisible(true);
		output.setVisible(true);
		output.setText(theModel.showOlympicgamesDate());
		individualCompatition.setVisible(false);
		teamCompatitions.setVisible(false);
	}

	public void showAllStadiums(Model theModel) {
		function = "showAllStadiums";
		sp.setVisible(true);
		output.setVisible(true);
		output.setText(theModel.showAllStadiums());
	}

	public void showAllParticipants(Model theModel) {
		function = "showAllParticipants";
		all.setVisible(true);
		participants.setVisible(true);
		allParticipants.setVisible(true);
		allParticipants.setDisable(false);
		runners.setVisible(true);
		jumpers.setVisible(true);
		runnersAndJumpers.setVisible(true);
		sp.setVisible(true);
		allCompatitions.setVisible(false);
		teamCompatitions.setVisible(false);
		individualCompatition.setVisible(false);
		running.setVisible(false);
		jumping.setVisible(false);
	}

	public void showAllCompatitions(Model theModel) {
		function = "showAllCompatitions";
		all.setVisible(true);
		compatitions.setVisible(true);
		allCompatitions.setVisible(true);
		teamCompatitions.setVisible(true);
		teamCompatitions.setText("team compatitions");
		individualCompatition.setVisible(true);
		individualCompatition.setText("individual compatitions");
		running.setVisible(false);
		jumping.setVisible(false);
		sp.setVisible(true);
	}

	public void showAllCountriesChartByMedals(Model theModel) {
		function = "showAllCountriesChartByMedals";
		compatitions.setVisible(true);
		output.setVisible(true);
		output.setText(theModel.showAllCountriesChartByMedals());
		individualCompatition.setVisible(false);
		teamCompatitions.setVisible(false);
		running.setVisible(false);
		jumping.setVisible(false);
	}

	public void allParticipants(Model theModel) {
		function = "allParticipants";
		allParticipants.setVisible(true);
		output.setVisible(true);
		sp.setVisible(true);
		runners.setVisible(true);
		jumpers.setVisible(true);
		runnersAndJumpers.setVisible(true);
		output.setText(theModel.showAllParticipants());
	}

	public void runners(Model theModel) {
		function = "runners";
		runners.setVisible(true);
		output.setVisible(true);
		sp.setVisible(true);
		allParticipants.setVisible(true);
		jumpers.setVisible(true);
		runnersAndJumpers.setVisible(true);
		output.setText(theModel.showAthletsBySport("running"));
	}

	public void jumpers(Model theModel) {
		function = "jumpers";
		jumpers.setVisible(true);
		output.setVisible(true);
		sp.setVisible(true);
		allParticipants.setVisible(true);
		runners.setVisible(true);
		runnersAndJumpers.setVisible(true);
		output.setText(theModel.showAthletsBySport("jumping"));
	}

	public void runnersAndJumpers(Model theModel) {
		function = "runnersAndJumpers";
		jumpers.setVisible(true);
		output.setVisible(true);
		sp.setVisible(true);
		allParticipants.setVisible(true);
		jumpers.setVisible(true);
		runners.setVisible(true);
		runnersAndJumpers.setVisible(true);
		output.setText(theModel.showAthletsBySport("runningAndJumping"));
	}

	public void allCompatitions(Model theModel) {
		function = "allCompatitions";
		allCompatitions.setVisible(true);
		teamCompatitions.setVisible(true);
		individualCompatition.setVisible(true);
		running.setVisible(false);
		jumping.setVisible(false);
		output.setVisible(true);
		sp.setVisible(true);
		output.setText(theModel.allCompatitions());
	}

	public void runningCompatitions(Model theModel) {
		function = "runningCompatitions";
		allCompatitions.setVisible(true);
		teamCompatitions.setVisible(true);
		individualCompatition.setVisible(true);
		output.setVisible(true);
		sp.setVisible(true);
	}

	public void jumpingCompatitions(Model theModel) {
		function = "jumpingCompatitions";
		allCompatitions.setVisible(true);
		teamCompatitions.setVisible(true);
		individualCompatition.setVisible(true);
		output.setVisible(true);
		sp.setVisible(true);
	}

	public void teamCompatitions(Model theModel) {
		function = "runningCompatitions";
		allCompatitions.setVisible(true);
		teamCompatitions.setVisible(true);
		individualCompatition.setVisible(true);
		sportTypes.setVisible(true);
		compatitionsSportType.setVisible(true);
		sp.setVisible(true);
		output.setVisible(true);
		output.setText(theModel.showTeamCompatitions());
	}

	public void individualCompatitions(Model theModel) {
		function = "runningCompatitions";
		allCompatitions.setVisible(true);
		teamCompatitions.setVisible(true);
		individualCompatition.setVisible(true);
		sportTypes.setVisible(true);
		compatitionsSportType.setVisible(true);
		sp.setVisible(true);
		output.setVisible(true);
		output.setText(theModel.showIndividualCompatitions());
	}

	public void running(Model theModel) {
		function = "running";
		compatitions.setVisible(true);
		allCompatitions.setVisible(true);
		output.setVisible(true);

	}

	public void jumping(Model theModel) {
		function = "jumping";
		compatitions.setVisible(true);
		allCompatitions.setVisible(true);
		output.setVisible(true);
	}

	public void clearview() {
		output.setText("");
		output.setVisible(false);
		allParticipants.setVisible(false);
		runners.setVisible(false);
		jumpers.setVisible(false);
		runnersAndJumpers.setVisible(false);
		allCompatitions.setVisible(false);

	}

	// event handlers:
	public void addEventTorunning(EventHandler<ActionEvent> runningPressed) {
		running.setOnAction(runningPressed);
	}

	public void addEventTojumping(EventHandler<ActionEvent> jumpingPressed) {
		jumping.setOnAction(jumpingPressed);
	}

	public void addEventToshowAllStadiums(EventHandler<ActionEvent> showAllStadiumsPressed) {
		showAllStadiums.setOnAction(showAllStadiumsPressed);
	}

	public void addEventToshowAllParticipants(EventHandler<ActionEvent> showAllParticipantsPressed) {

		showAllParticipants.setOnAction(showAllParticipantsPressed);
	}

	public void addEventToshowAllCompatitions(EventHandler<ActionEvent> showAllCompatitionsPressed) {
		showAllCompatitions.setOnAction(showAllCompatitionsPressed);
	}

	public void addEventToshowAllCountriesChartByMedals(
			EventHandler<ActionEvent> showAllCountriesChartByMedalsPressed) {
		showAllCountriesChartByMedals.setOnAction(showAllCountriesChartByMedalsPressed);
	}

	public void addEventToallParticipants(EventHandler<ActionEvent> allParticipantsPressed) {
		allParticipants.setOnAction(allParticipantsPressed);
	}

	public void addEventTorunners(EventHandler<ActionEvent> runnersPressed) {
		runners.setOnAction(runnersPressed);
	}

	public void addEventTojumpers(EventHandler<ActionEvent> jumpersPressed) {
		jumpers.setOnAction(jumpersPressed);
	}

	public void addEventTorunnersAndJumpers(EventHandler<ActionEvent> runnersAndJumpersPressed) {
		runnersAndJumpers.setOnAction(runnersAndJumpersPressed);
	}

	public void addEventToallCompatitions(EventHandler<ActionEvent> allCompatitionsPressed) {
		allCompatitions.setOnAction(allCompatitionsPressed);
	}

	public void addEventToteamCompatitions(EventHandler<ActionEvent> teamCompatitionsPressed) {
		teamCompatitions.setOnAction(teamCompatitionsPressed);
	}

	public void addEventToindividualCompatitions(EventHandler<ActionEvent> individualCompatitionsPressed) {
		individualCompatition.setOnAction(individualCompatitionsPressed);
	}

	public void addEventToExit(EventHandler<ActionEvent> exitPressed) {
		exit.setOnAction(exitPressed);
	}

	public void addEventTodate(EventHandler<ActionEvent> datePressed) {
		date.setOnAction(datePressed);
	}
}
