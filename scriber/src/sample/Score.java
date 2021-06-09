package sample;

public class Score {

    private String nom;
    private int points;
    private int nbWords;
    private long startTime;


    public void startExercice(){
        startTime = System.currentTimeMillis();

    }

    public String getNom() {
        return nom;
    }

    public long getTimePassed(){
        return System.currentTimeMillis() - startTime;
    }

    public int getPoints() {
        return points;
    }

    public int getNbWords() {
        return nbWords;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setNbWords(int nbWords) {
        this.nbWords = nbWords;
    }
}
