
package proj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import model.buttons;
import static proj.ViewManager.mainScene;
import static proj.ViewManager.mainStage;
import static proj.ViewManager.trip;

//        stack.setBackground(new Background(new BackgroundFill(Color.BEIGE,null,null)));

/**
 *
 * @author DELL
 */
public class LogInScene extends Scene{        
    private AnchorPane anchor;
    private StackPane stack;


//    private final static String background = "F:\\Dell\\Documents\\Programming\\Projects\\Project\\resources\\images\\marsaalam.jpg";
    private final static String font_path = "F:\\Dell\\Documents\\Programming\\Projects\\Project\\resources\\fonts\\static\\Montserrat-Medium.ttf";
    private final static String icon_path = "F:\\Dell\\Documents\\Programming\\Projects\\Project\\resources\\images\\home.png";
    
    public LogInScene() throws FileNotFoundException {
        super(new StackPane(), 1024, 500);
        anchor = new AnchorPane();
        stack = new StackPane();
        getStylesheets().add(getClass().getResource("hoverbutton.css").toExternalForm());
        addrectangle();
        addLogInText();
        setBackground();
        addTextFields();
        addHomeIcon();
        stack.getChildren().add(anchor);
        setRoot(stack);
    }
    private void setBackground()
    {
        Image image = new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\proj\\camelimage.jpg", 1024,500,false,true);
        BackgroundImage background = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        stack.setBackground(new Background(background));
    }
    private void addLogInText() throws FileNotFoundException
    {
        Text loginText = new Text("User Log In");
        Font font = Font.loadFont(new FileInputStream(font_path), 40);
        loginText.setFont(font);
        anchor.getChildren().add(loginText);
        loginText.setLayoutY(125);
        loginText.setLayoutX(400);
    }
    private void addrectangle() throws FileNotFoundException
    {
        Rectangle rectangle = new Rectangle(650,500);
        rectangle.setLayoutX(250);
        rectangle.setStyle("-fx-background-color:Black; -fx-opacity: 0.4;");
        stack.getChildren().add(rectangle);
    }

    private void addTextFields() throws FileNotFoundException
    {
        Font font = Font.loadFont(new FileInputStream(font_path), 20);

        TextField username = new TextField();
        username.setPromptText("Ahmed123");
        username.setStyle("-fx-background-color: -fx-control-inner-background; -fx-background-insets: 0;");
        username.setPrefSize(300, 10);
        Text t1 = new Text("Username");
        t1.setFont(font);
        t1.setLayoutX(300);
        t1.setLayoutY(250);
        username.setLayoutX(420);
        username.setLayoutY(230);
        
        PasswordField password = new PasswordField();
        password.setPromptText("*********");
        password.setStyle("-fx-background-color: -fx-control-inner-background; -fx-background-insets: 0;");
        password.setPrefSize(300, 10);
        Text t2 = new Text("Password");
        t2.setFont(font);
        t2.setLayoutX(300);
        t2.setLayoutY(285);
        password.setLayoutX(420);
        password.setLayoutY(265);
                
        buttons loginButton = new buttons("LOG IN");
        loginButton.setPrefWidth(425);
        loginButton.setLayoutX(300);
        loginButton.setLayoutY(320);
        
        anchor.getChildren().addAll(t1, username, t2, password, loginButton);
        
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainStage.setScene(trip);
            }
        });
    }

    private void addHomeIcon() throws FileNotFoundException
    {
        Image img = new Image(new FileInputStream(icon_path) , 50, 50, false, true);
        ImageView imgview = new ImageView(img);
        
        anchor.getChildren().add(imgview);
        
        imgview.setOnMouseEntered((MouseEvent event) -> {
            imgview.setEffect(new DropShadow());
        });
        imgview.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imgview.setEffect(null);
            }
        });
        imgview.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event) {
                mainStage.setScene(mainScene);
            }
            
        });
    }

}
