package sample;

import exercice.Exercice;

import java.util.*;

public class TextAfficheur {
    private char occultationChar;
    private List<Word> words;
    private String score;
    private int points;
    private String script;
    private String occultedString;
    private Exercice exercice;

    public TextAfficheur(Exercice exercice, char occultationChar){
        words = new ArrayList<>();
        this.exercice = exercice;
        this.script = exercice.getScript();
        initialize();
        this.occultationChar = occultationChar;
        occultedString = script.replaceAll("[A-Za-z0-9]", String.valueOf(this.occultationChar));
        updateScore();
        score = getScore();
    }

    public List<Word> getWords() {
        return words;
    }

    private void initialize() {
        String script2 = format(script);
        int index = 0;

        for (String str : script2.split("\\s+")) {
            index = script2.indexOf(str, index);
            if(!exercice.isCaseSensitive()){
                str = str.toLowerCase();
            }
            words.add(new Word(str, index));
        }

        for (Word word : words) {
            System.out.println(word.getValue());
        }
    }

    public void discoverWord(String str, int numLett){
        for(Word w : words){
            if(str.length() == w.getLength()){
                discoverWord(str);
            }
            if(w.getValue().startsWith(str) && w.getLength() >= 4 && str.length() > numLett){
                    w.setPartialLength(str.length());
                    w.setPartiallyDiscovered();
            }
        }

        updateScore();
    }

    public void discoverWord(String str) {
        for(Word w : words){
            if(w.getValue().equals(str)){
                w.setDiscovered();
            }
        }
        updateScore();
    }


    private String format(String str) {
        str = str.replaceAll("\n", " ");
        str = str.replaceAll("\\.", " ");
        str = str.replaceAll(",", " ");
        str = str.replaceAll("\\?", " ");
        str = str.replaceAll("'", " ");
        str = str.replaceAll("!", " ");
        str = str.replaceAll("\\[", " ");
        str = str.replaceAll("]", " ");
        str = str.replaceAll(":", " ");
        str = str.replaceAll(" - ", " ");
        str = str.replaceAll("’", " ");

        return str;
    }


    private void updateScore() {
        int count = 0;
        for(Word w : words){
            if(w.isDiscovered()){
                count++;
            }
        }
        points = count;
        setScore(String.format("Score : %d / %d", count, words.size()));
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getScore(){
        return score;
    }

    public String getOccultedString() {
        return occultedString;
    }

    public String buildOccultedScript(){
        StringBuffer discoveredWord = new StringBuffer(occultedString);

        for(Word w : words){
            if(w.isDiscovered()){
                for(int i = 0; i < w.getLength(); i++){
                    discoveredWord.setCharAt(w.getIndex() + i, w.getValue().charAt(i));
                }
            } else if(w.isPartiallyDiscovered()){
                    for(int i = 0; i < w.getPartialLength(); i++){
                        discoveredWord.setCharAt(w.getIndex() + i, w.getValue().charAt(i));
                    }
                }
            }

        return discoveredWord.toString();
    }

    public int getPoints() {
        return points;
    }
}
