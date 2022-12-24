
package proj;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import static proj.ViewManager.mainStage;


/**
 *
 * @author malak
 */
public class Proj extends Application {
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        ViewManager manager = new ViewManager();
        primaryStage.setScene(new Seats());
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) {
        launch(args);
    }
}
