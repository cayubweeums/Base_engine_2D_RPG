package States;

import Main.GUI;
import Main.helper;
import Main.mainGame;
import javafx.animation.Animation;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class menuController {
    public mainGame mainG;
    public helper helper = new helper(mainG = new mainGame("some game", 700,500));


//    TODO worked
//    public mainGame mainG = new mainGame("some game", 700,500);


    @FXML
    private Button play;

    @FXML
    public void initialize() {
    }

    @FXML
    private void play(){
        Stage stage = (Stage) play.getScene().getWindow();
        stage.close();
        helper.getMainG().start();
        stateGame game = new stateGame(helper);
        stateMethods.setState(game);



//        helper.setMainG(mainG);

//        TODO worked
//        mainG.start();
//        stateGame game = new stateGame(helper);
//        stateMethods.setState(game);
    }
}
