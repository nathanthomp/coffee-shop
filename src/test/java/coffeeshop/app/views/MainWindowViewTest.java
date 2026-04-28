package coffeeshop.app.views;

import coffeeshop.app.controllers.MainWindowController;
import javafx.scene.Scene;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import static javafx.application.Platform.runLater;
import static javafx.application.Platform.startup;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainWindowViewTest {
    @BeforeAll
    static void initializeToolkit() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);

        try {
            startup(latch::countDown);
        } catch (IllegalStateException alreadyStarted) {
            latch.countDown();
        }

        assertTrue(latch.await(5, TimeUnit.SECONDS));
    }

    @Test
    void viewBuildsSceneUsingControllerContent() throws InterruptedException {
        MainWindowController controller = new MainWindowController();
        MainWindowView view = new MainWindowView(controller);
        AtomicReference<Scene> sceneReference = new AtomicReference<>();
        CountDownLatch latch = new CountDownLatch(1);

        runLater(() -> {
            sceneReference.set(view.buildScene());
            latch.countDown();
        });

        assertTrue(latch.await(5, TimeUnit.SECONDS));

        Scene scene = sceneReference.get();
        assertNotNull(scene);
        assertEquals(640, scene.getWidth());
        assertEquals(360, scene.getHeight());
    }
}
