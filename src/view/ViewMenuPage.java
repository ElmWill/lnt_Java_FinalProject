package view;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Menu;

import java.util.List;

import controller.MenuController;

public class ViewMenuPage {

    private MenuController menuController = new MenuController();

    public void display(Stage primaryStage) {
        primaryStage.setTitle("View Menu");

        VBox vbox = new VBox(10);
        List<Menu> menus = menuController.getAllMenus();
        for (Menu menu : menus) {
            Label label = new Label(menu.getNama() + " - " + menu.getHarga() + " - " + menu.getStock());
            vbox.getChildren().add(label);
        }

        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

