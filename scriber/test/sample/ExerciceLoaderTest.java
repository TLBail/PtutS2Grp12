package sample;

import exercice.Exercice;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import static org.junit.jupiter.api.Assertions.*;

class ExerciceLoaderTest {


    private static final String PATHTOEXERFILE = "C:/Users/theol/.scriberEditor/superEntrainement.exer";


    @org.junit.jupiter.api.Test
    void chargerUnExercice() {

        ExerciceLoader exerciceLoader = new ExerciceLoader();

        exerciceLoader.chargerUnExercice(PATHTOEXERFILE);


    }

    @org.junit.jupiter.api.Test
    void chargerMediaDepuisExercice() {


        ExerciceLoader exerciceLoader = new ExerciceLoader();

        File mediaFile = exerciceLoader.chargerMediaDepuisExercice(PATHTOEXERFILE);

        try {
            Desktop.getDesktop().open(mediaFile);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Test
    void chargerLesMetaData(){
        ExerciceLoader exerciceLoader = new ExerciceLoader();

        //exerciceLoader.getMediaData(exerciceLoader.chargerMediaDepuisExercice(PATHTOEXERFILE));


        System.out.println("title " + exerciceLoader.getTitle());
        System.out.println("album " + exerciceLoader.getAlbum());
        System.out.println("Artist " + exerciceLoader.getArtist());
        System.out.println("genre " + exerciceLoader.getGenre());
        System.out.println("Year " + exerciceLoader.getYear());

    }

    @Test
    void testSerialisation(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("../exerciceInfo.exera"));

            // désérialization de l'objet
            Exercice exercice = (Exercice) ois.readObject();
            System.out.println(exercice) ;

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



}