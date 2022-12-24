/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.buttons;
/**
 *
 * @author DELL
 */
public class ViewManager {
    private AnchorPane  mainPane;
    private GridPane grid;
    
    static Scene mainScene;
    static Stage mainStage;
    public LogInScene login;
    public signInScene signin;
    static PackScene pack;
    static Seats seat;
    static TripScene trip;

    private final static int WIDTH = 1024;
    private final static int HEIGHT = 500;
    
    List<buttons> menuButtons;
    public ViewManager() throws FileNotFoundException
    {
        mainStage = new Stage();
        grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setAlignment(Pos.CENTER);
        grid.setLayoutX(362);
        grid.setLayoutY(170);
        menuButtons = new ArrayList<>();
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane,WIDTH, HEIGHT);
        mainStage.setScene(mainScene);
        addwelcomeText();
        setBackground();
        createButtons();
        createScenes();
        mainPane.getChildren().add(grid);
        mainStage.setTitle("Egypt Tours");
    }
    
    public void createScenes() throws FileNotFoundException
    {
        signin = new signInScene();
        login = new LogInScene();
        trip = new TripScene();
        pack = new PackScene();
        seat = new Seats();
    }
    private void addButtons(buttons button)
    {
        menuButtons.add(button);
        grid.add(button, 0, 1 + menuButtons.size());
    }
    private void createButtons()
    {
        createLogInButton();
        createSignInButton();
    }
    private void createLogInButton()
    {
        buttons loginButton = new buttons("LOG IN");
        addButtons(loginButton);
        
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainStage.setScene(login);
            }
        });
    }
    private void createSignInButton()
    {
        buttons signinButton = new buttons("SIGN UP");
        addButtons(signinButton);
        signinButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainStage.setScene(signin);
            }
        });
    }
    private void setBackground()
    {
        Image image = new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\proj\\camelimage.jpg", 1024,500,false,true);
        BackgroundImage background = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        mainPane.setBackground(new Background(background));
    }
    private void addwelcomeText() throws FileNotFoundException
    {
        String font_path = "F:\\Dell\\Documents\\Programming\\Projects\\Project\\resources\\fonts\\Afterglow-Regular.ttf";
        Text welcometxt = new Text("WELCOME");
        Font font = Font.loadFont(new FileInputStream(font_path), 60);
        welcometxt.setFont(font);
        grid.add(welcometxt, 0, 0);

    }      
}
