package coffeeshop.app;

import coffeeshop.app.controllers.MainWindowController;
import coffeeshop.app.views.MainWindowView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CoffeeShopApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        MainWindowController controller = new MainWindowController();
        MainWindowView view = new MainWindowView(controller);
        Scene scene = view.buildScene();

        stage.setTitle(controller.windowTitle());
        stage.setScene(scene);
        stage.show();
    }
}
