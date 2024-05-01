package view;

import controller.MenuController;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Menu;

public class UpdateMenuPage {

    private MenuController menuController = new MenuController();
    private Stage primaryStage;

    public UpdateMenuPage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void display() {
        primaryStage.setTitle("Update Menu");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);

        Label idLabel = new Label("Menu ID:");
        GridPane.setConstraints(idLabel, 0, 0);
        TextField idField = new TextField();
        GridPane.setConstraints(idField, 1, 0);

        Label priceLabel = new Label("Price:");
        GridPane.setConstraints(priceLabel, 0, 1);
        TextField priceField = new TextField();
        GridPane.setConstraints(priceField, 1, 1);

        Label stockLabel = new Label("Stock:");
        GridPane.setConstraints(stockLabel, 0, 2);
        TextField stockField = new TextField();
        GridPane.setConstraints(stockField, 1, 2);

        Button updateButton = new Button("Update");
        GridPane.setConstraints(updateButton, 1, 3);
        updateButton.setOnAction(event -> {
            int id = Integer.parseInt(idField.getText());
            String price = priceField.getText();
            int stock = Integer.parseInt(stockField.getText());

            Menu updatedMenu = new Menu(null, price, stock);
            updatedMenu.setMenuid(id);

            boolean success = menuController.updateMenu(updatedMenu);
            if (success) {
                System.out.println("Menu updated successfully!");
            } else {
                System.out.println("Failed to update menu.");
            }
        });

        grid.getChildren().addAll(idLabel, idField, priceLabel, priceField, stockLabel, stockField, updateButton);

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

