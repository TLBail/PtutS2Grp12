package sample;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ressources.ControllerIndex;
import ressources.PageLoader;

public final class Main extends Application {

    private static Main instance;


    public static Main getInstance()
    {
        return instance;
    }

    public Parent parent;
    public  Scene scene;
    public ControllerIndex controller;
    public PageLoader pageLoader;
    public GenerateurExercice generateurExercice;

    @Override
    public void start(Stage primaryStage) throws Exception{
        instance = this;
        pageLoader = new PageLoader();
        generateurExercice = new GenerateurExercice();

        parent = pageLoader.loadIndex();
        primaryStage.setTitle("Scriber Editor");
        //primaryStage.setMaximized(true);
        //primaryStage.setFullScreen(true);
        scene = new Scene(parent, 700, 500);
        primaryStage.setScene(scene);
        primaryStage.show();

        controller = (ControllerIndex) pageLoader.getController();



    }


    public static void main(String[] args) {
        launch(args);
    }




}
