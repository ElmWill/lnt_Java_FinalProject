package view;

import controller.MenuController;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DeleteMenuPage {

    private MenuController menuController = new MenuController();
    private Stage primaryStage;

    public DeleteMenuPage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void display() {
        primaryStage.setTitle("Delete Menu");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);

        Label idLabel = new Label("Menu ID:");
        GridPane.setConstraints(idLabel, 0, 0);
        TextField idField = new TextField();
        GridPane.setConstraints(idField, 1, 0);

        Button deleteButton = new Button("Delete");
        GridPane.setConstraints(deleteButton, 1, 1);
        deleteButton.setOnAction(event -> {
            int id = Integer.parseInt(idField.getText());

            // Call the method from MenuController to delete the menu from the database
            boolean success = menuController.deleteMenu(id);
            if (success) {
                System.out.println("Menu deleted successfully!");
                // Optionally, you can close this window or perform other actions after deleting the menu
            } else {
                System.out.println("Failed to delete menu.");
            }
        });

        grid.getChildren().addAll(idLabel, idField, deleteButton);

        Scene scene = new Scene(grid, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

