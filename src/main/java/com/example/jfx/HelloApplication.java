package com.example.jfx;

import javafx.application.Application;
import javafx.stage.Stage;
import org.apache.logging.log4j.*;

public class HelloApplication extends Application {
    private static final Logger logger = LogManager.getLogger(HelloApplication.class);

    @Override
    public void start(Stage stage) {
        logger.info("Starting application");
        DataService dataService = new DataService();
        HelloController helloController = new HelloController(dataService);

        logger.info("Showing UI");
        helloController.show(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
