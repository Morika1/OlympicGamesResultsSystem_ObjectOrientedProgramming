package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Model;
import view.View;

public class Controller {

	private Model model;
	private View view;

	public Controller(Model theModel, View theView) {
		this.model = theModel;
		this.view = theView;

		EventHandler<ActionEvent> showAllStadiumsPressed = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				view.clearview();
				view.showAllStadiums(model);
			}
		};
		view.addEventToshowAllStadiums(showAllStadiumsPressed);

		EventHandler<ActionEvent> showAllParticipantsPressed = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				view.clearview();
				view.showAllParticipants(model);
				
			}
		};
		
		view.addEventToshowAllParticipants(showAllParticipantsPressed);

		EventHandler<ActionEvent> showAllCompatitionsPressed = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				view.clearview();
				view.showAllCompatitions(model);
			}
		};
		view.addEventToshowAllCompatitions(showAllCompatitionsPressed);

		EventHandler<ActionEvent> showAllCountriesChartByMedalsPressed = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				view.clearview();
				view.showAllCountriesChartByMedals(model);
			}
		};
		view.addEventToshowAllCountriesChartByMedals(showAllCountriesChartByMedalsPressed);

		
		EventHandler<ActionEvent>allParticipantsPressed = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				view.clearview();
				view.allParticipants(model);
			}
		};
		view.addEventToallParticipants(allParticipantsPressed);
		
		EventHandler<ActionEvent>runnersPressed = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				view.clearview();
				view.runners(model);
			}
		};
		view.addEventTorunners(runnersPressed);

		EventHandler<ActionEvent>jumpersPressed = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				view.clearview();
				view.jumpers(model);
			}
		};
		view.addEventTojumpers(jumpersPressed);
		
		EventHandler<ActionEvent>runnersAndJumpersPressed = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				view.clearview();
				view.runnersAndJumpers(model);
			}
		};
		view.addEventTorunnersAndJumpers(runnersAndJumpersPressed);
		
		
		EventHandler<ActionEvent>allCompatitionsPressed = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				view.clearview();
				view.allCompatitions(model);
			}
		};
		view.addEventToallCompatitions(allCompatitionsPressed);
		
		EventHandler<ActionEvent>teamCompatitionsPressed = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				view.clearview();
				view.teamCompatitions(model);
			}
		};
		view.addEventToteamCompatitions(teamCompatitionsPressed);
		
		EventHandler<ActionEvent>individualCompatitionsPressed = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				view.clearview();
				view.individualCompatitions(model);
			}
		};
		view.addEventToindividualCompatitions(individualCompatitionsPressed);
		
		
		
		EventHandler<ActionEvent> exitPressed = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("yes19");
				view.clearview();
				System.exit(0);
			}
		};
		view.addEventToExit(exitPressed);
		
		EventHandler<ActionEvent>runningPressed = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				view.clearview();
				view.running(model);
			}
		};
		view.addEventTorunning(runningPressed);
		
		EventHandler<ActionEvent>jumpingPressed = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				view.clearview();
				view.jumping(model);
			}
		};
		view.addEventTojumping(jumpingPressed);
		
		EventHandler<ActionEvent>datePressed = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				view.clearview();
				view.date(model);
			}
		};
		view.addEventTodate(datePressed);
	}
}
