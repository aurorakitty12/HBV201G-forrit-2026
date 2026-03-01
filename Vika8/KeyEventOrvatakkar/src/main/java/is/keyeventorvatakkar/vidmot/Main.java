/**
 * Sýnidæmi fyrir KeyEvents - Aðalklasinn
 *
 * @author Ebba Þóra Hvannberg ebba@hi.is
 */
package is.keyeventorvatakkar.vidmot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        Controller sc = loader.getController();
        primaryStage.setTitle("Örvatakkar");
        Scene s = new Scene(root, 300, 275);
        orvatakkar(sc, s);          // tengir atburð frá örvatökkum við fall í controller
        primaryStage.setScene(s);
        primaryStage.show();
    }

    /**
     * Tengir örvatakka við fall sem á að keyra í controller
     *
     * @param sc controllerinn
     * @param s  senan sem tekur við (consume) atburðinn
     */
    private void orvatakkar(Controller sc, Scene s) {
        s.addEventFilter(KeyEvent.ANY,      //KeyEvents eru sendar á Scene
                event -> {      // lambda fall - event er parameter
                    KeyCode code = event.getCode();
                    if (fraKeyCode(code) != null) {
                        sc.setStefna(fraKeyCode(code).getGradur());
                    }
                });
    }

    public static Stefna fraKeyCode(KeyCode code) {
        return switch (code) {
            case UP -> Stefna.UPP;
            case DOWN -> Stefna.NIDUR;
            case LEFT -> Stefna.VINSTRI;
            case RIGHT -> Stefna.HAEGRI;
            default -> null;
        };
    }

    public static void main(String[] args) {
        launch(args);
    }
}



