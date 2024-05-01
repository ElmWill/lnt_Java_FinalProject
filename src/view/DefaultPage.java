package view;

import controller.MenuController;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DefaultPage  {

	private Stage primaryStage;
    public DefaultPage(Stage primaryStage) {
        this.primaryStage = primaryStage;
        new MenuController();
    }

    public void display() {
        

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20, 20, 20, 20));

        Button insertButton = new Button("Insert New Menu");
        insertButton.setOnAction(event -> {
            InsertMenuPage insertMenuPage = new InsertMenuPage(primaryStage);
            insertMenuPage.display();
        });

        Button viewButton = new Button("View Menu");
        viewButton.setOnAction(event -> {
            ViewMenuPage viewMenuPage = new ViewMenuPage();
            viewMenuPage.display(primaryStage);
        });

        Button updateButton = new Button("Update Menu");
        updateButton.setOnAction(event -> {
        	UpdateMenuPage updateMenuPage = new UpdateMenuPage(primaryStage);
            updateMenuPage.display();
        });

        Button deleteButton = new Button("Delete Menu");
        deleteButton.setOnAction(event -> {
        	DeleteMenuPage deleteMenuPage = new DeleteMenuPage(primaryStage);
            deleteMenuPage.display();
        });

        Button closeButton = new Button("Close");
        closeButton.setOnAction(event -> {
            primaryStage.close();
        });

        vbox.getChildren().addAll(insertButton, viewButton, updateButton, deleteButton, closeButton);

        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
