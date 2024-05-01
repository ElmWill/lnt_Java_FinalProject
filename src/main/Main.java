package main;

import controller.MenuController;
import database.DatabaseConnection;
import javafx.application.Application;
import javafx.stage.Stage;
import view.DefaultPage;

public class Main extends Application{
	DatabaseConnection db = new DatabaseConnection();
	MenuController mc = new MenuController();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
		launch(args);
	}
	public Main() {
		db.migrateTable();
		mc.insertDefaultMenu();
	}
	@Override
	public void start(Stage primaryStage) {
        primaryStage.setTitle("Menu Management");
        DefaultPage defaultPage = new DefaultPage(primaryStage);
        defaultPage.display();
    }
}
