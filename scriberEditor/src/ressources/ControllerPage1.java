package ressources;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import sample.GenerateurExercice;
import sample.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerPage1 extends SuperController implements Initializable {

    @FXML
    private TextField titre;

    @FXML
    private TextArea consigne;


    @FXML
    protected AnchorPane ProgressAnchorPane;



    @FXML
    void onRetourClick(ActionEvent event){
        pageLoader.loadIndex();
    }

    @FXML
    void onNextPageClick(ActionEvent event){
        generateurExercice.setTitreExercice(titre.getText());
        generateurExercice.setConsigneExercice(consigne.getText());

        pageLoader.loadSubPage(PageLoader.PAG2PATH);
    }




}