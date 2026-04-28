package coffeeshop.app.views;

import coffeeshop.app.controllers.MainWindowController;
import coffeeshop.app.models.Message;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class MainWindowView {
    private final MainWindowController controller;

    public MainWindowView(MainWindowController controller) {
        this.controller = controller;
    }

    public Scene buildScene() {
        Message startupMessage = controller.startupMessage();

        Text heading = new Text(startupMessage.title());
        heading.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        Text status = new Text(startupMessage.body());
        status.setWrappingWidth(320);

        VBox content = new VBox(12, heading, status);
        BorderPane root = new BorderPane(content);
        root.setPadding(new Insets(24));

        return new Scene(root, 640, 360);
    }
}
