/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.buttons;
import model.loginButtons;
import static proj.ViewManager.mainScene;
import static proj.ViewManager.mainStage;

/**
 *
 * @author DELL
 */
public class signInScene extends Scene {
    private AnchorPane anchor;
    private StackPane stack;
    
    private final static String font_path = "F:\\Dell\\Documents\\Programming\\Projects\\Project\\resources\\fonts\\static\\Montserrat-Medium.ttf";
    private final String icon_path = "F:\\Dell\\Documents\\Programming\\Projects\\Project\\resources\\images\\home.png";
    
    public signInScene() throws FileNotFoundException {
        super(new StackPane(), 1024, 500);
        stack = new StackPane();
        anchor = new AnchorPane();
        setBackground();
        addrectangle();
        addSignInText();
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
    private void addSignInText() throws FileNotFoundException
    {
        Text loginText = new Text("Create A New Account");
        Font font = Font.loadFont(new FileInputStream(font_path), 35);
        loginText.setFont(font);
        anchor.getChildren().add(loginText);
        loginText.setLayoutY(125);
        loginText.setLayoutX(320);
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
        GridPane grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(10);
        
        Font font = Font.loadFont(new FileInputStream(font_path), 20);

        Text fname = new Text("First Name ");
        fname.setFont(font);
        Text lname = new Text("  Last Name ");
        lname.setFont(font);
        Text Age = new Text("             Age");
        Age.setFont(font);
        Text username = new Text("Username");
        username.setFont(font);
        Text password = new Text("Password");
        password.setFont(font);
        
        TextField firstname = new TextField();
        firstname.setPromptText("Ahmed");
        firstname.setStyle("-fx-background-color: -fx-control-inner-background; -fx-background-insets: 0;");
        firstname.setPrefSize(150, 10);
        grid.add(fname, 0, 0);
        grid.add(firstname,1,0);
        
        TextField lastname = new TextField();
        lastname.setPromptText("Mohsen");
        lastname.setStyle("-fx-background-color: -fx-control-inner-background; -fx-background-insets: 0;");
        lastname.setPrefSize(150, 10);
        grid.add(lname, 2, 0);
        grid.add(lastname, 3, 0);
        
        TextField age = new TextField();
        age.setPromptText("20");
        age.setStyle("-fx-background-color: -fx-control-inner-background; -fx-background-insets: 0;");
        age.setPrefSize(150, 10);
        grid.add(Age, 0, 1);
        grid.add(age, 1, 1);
        
        TextField user = new TextField();
        user.setPromptText("Ahmed123");
        user.setStyle("-fx-background-color: -fx-control-inner-background; -fx-background-insets: 0;");
        user.setPrefSize(300, 10);
        anchor.getChildren().add(username);
        username.setLayoutX(231);
        username.setLayoutY(300);
        anchor.getChildren().add(user);
        user.setLayoutX(350);
        user.setLayoutY(280);

        PasswordField pass = new PasswordField();
        pass.setPromptText("********");
        pass.setStyle("-fx-background-color: -fx-control-inner-background; -fx-background-insets: 0;");
        pass.setPrefSize(300, 10);
        anchor.getChildren().add(password);
        password.setLayoutX(235);
        password.setLayoutY(335);
        anchor.getChildren().add(pass);
        pass.setLayoutX(350);
        pass.setLayoutY(315);
        
        buttons signinButton = new buttons("CREATE ACCOUNT");
        signinButton.setPrefWidth(425);
        anchor.getChildren().add(signinButton);
        signinButton.setLayoutX(310);
        signinButton.setLayoutY(350);
        
        grid.setLayoutX(225);
        grid.setLayoutY(200);
        
        anchor.getChildren().add(grid);
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
