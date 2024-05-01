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

public class InsertMenuPage {

    private MenuController menuController = new MenuController();
    private Stage primaryStage;

    public InsertMenuPage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void display() {
        primaryStage.setTitle("Insert New Menu");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);

        Label nameLabel = new Label("Name:");
        GridPane.setConstraints(nameLabel, 0, 0);
        TextField nameField = new TextField();
        GridPane.setConstraints(nameField, 1, 0);

        Label priceLabel = new Label("Price:");
        GridPane.setConstraints(priceLabel, 0, 1);
        TextField priceField = new TextField();
        GridPane.setConstraints(priceField, 1, 1);

        Label stockLabel = new Label("Stock:");
        GridPane.setConstraints(stockLabel, 0, 2);
        TextField stockField = new TextField();
        GridPane.setConstraints(stockField, 1, 2);

        Button createButton = new Button("Create");
        GridPane.setConstraints(createButton, 1, 3);
        createButton.setOnAction(event -> {
            String name = nameField.getText();
            String price = priceField.getText();
            int stock = Integer.parseInt(stockField.getText());

            
            Menu newMenu = new Menu(name, price, stock);

          
            boolean success = menuController.insertMenu(newMenu);
            if (success) {
                System.out.println("Menu created successfully!");
            } else {
                System.out.println("Failed to create menu.");
            }
        });

        grid.getChildren().addAll(nameLabel, nameField, priceLabel, priceField, stockLabel, stockField, createButton);

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
