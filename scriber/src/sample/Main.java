package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ressources.Controller;
import ressources.EntrainementOuvertController;
import ressources.FXMLoader;
import ressources.OuvertureController;

import java.io.File;

public class Main extends Application {

    public static ExerciceLoader exerciceLoader;
    public static Parent parent;
    public static Scene scene;
    public static Controller controller;
    public static EntrainementOuvertController ouvertureController;

    @Override
    public void start(Stage primaryStage) throws Exception{

        exerciceLoader = new ExerciceLoader();
        FXMLoader fxmLoader = new FXMLoader();
        parent = fxmLoader.load("Ouverture_Mode_Entrainement.fxml");
        primaryStage.setTitle("Hello World");
        scene = new Scene(parent);
        primaryStage.setScene(scene);

        ouvertureController = (EntrainementOuvertController) fxmLoader.getController();


        if(path != null){

            File exerciceFile = new File(path);
            controller.displayFile(exerciceFile);
        }

        primaryStage.show();




    }

    private static String path;

    public static void main(String[] args) {

        //TODO faire une verif que le premier argument est bien un chemin vers un exercice genre il finit par .exer
        if (args.length > 0) {

            path = args[0];
            System.out.println(path);
        }

        launch(args);
    }
}
