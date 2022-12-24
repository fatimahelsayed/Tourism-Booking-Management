/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import static proj.ViewManager.mainStage;
import static proj.ViewManager.pack;
import static proj.ViewManager.seat;
import proj.tripsubscene;

/**
 *
 * @author DELL
 */
public class PackScene extends Scene {
    
    AnchorPane anchor;
    AnchorPane anchor2;
    
    ToggleGroup group = new ToggleGroup();
    
    public static String selectedpack;

    tripsubscene platpack;
    tripsubscene goldpack;
    tripsubscene silpack;
    tripsubscene trips;
    
    private final String background_path = "F:\\Dell\\Documents\\Programming\\Projects\\Project\\resources\\images\\slay.jpg";
    private final static String font_path = "F:\\Dell\\Documents\\Programming\\Projects\\Project\\resources\\fonts\\static\\Montserrat-Medium.ttf";
    private final static String font_path2 = "F:\\Dell\\Documents\\Programming\\Projects\\Project\\resources\\fonts\\Masvis Italic.ttf";
    private final static String icon_path = "F:\\Dell\\Documents\\Programming\\Projects\\Project\\resources\\images\\arrow.png";
    
    public PackScene() throws FileNotFoundException {
        super(new AnchorPane(), 1024, 500);
        anchor = new AnchorPane();
        anchor2 = new AnchorPane();

        //        System.out.println(getClass().getResource("marsaalam.jpg"));
        createSubScenes();
        setBackground();    
        getStylesheets().add(getClass().getResource("hoverbutton.css").toExternalForm());  
        addrectangle();
        addText();
        addPackageFields();
        addarrowIcon();
        
        anchor.getChildren().add(trips);
        anchor.getChildren().add(anchor2);
        setRoot(anchor);
    }
    private void setBackground()
    {
        Image image = new Image(background_path, 1024,500,false,true);
        BackgroundImage background = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        anchor.setBackground(new Background(background));
    }
    private void createSubScenes() throws FileNotFoundException
    {
        platpack = new tripsubscene();
        platpack.setPlatPack();
        goldpack = new tripsubscene();
        goldpack.setGoldPack();
        silpack = new tripsubscene();
        silpack.setSilPack();
        trips = new tripsubscene();
        anchor.getChildren().addAll(platpack, goldpack, silpack);
    }
    private void showSubScene(tripsubscene subScene)
    {
        if (trips != null)
        {
            trips.setTransition2();
        }
        subScene.setTransition();
        trips = subScene;
    }
    private void addrectangle() throws FileNotFoundException
    {
        Rectangle rectangle = new Rectangle(650,500);
        rectangle.setLayoutX(374);
        rectangle.setStyle("-fx-background-color: CadetBlue; -fx-opacity: 0.4;");
        anchor2.getChildren().add(rectangle);
    }
    private void addText() throws FileNotFoundException
    {
        Text loginText = new Text("Book Your\nTrip");
        Font font = Font.loadFont(new FileInputStream(font_path2), 55);
        loginText.setFont(font);
        loginText.setFill(Paint.valueOf("White"));
        anchor2.getChildren().add(loginText);
        loginText.setLayoutY(100);
        loginText.setLayoutX(40);
    }
     private void addPackageFields() throws FileNotFoundException
    {
        Text packtype = new Text("Step 2: Choose your Package");
        Font font1 = Font.loadFont(new FileInputStream(font_path), 30);
        packtype.setFont(font1);
        packtype.setFill(Paint.valueOf("White"));
        packtype.setLayoutX(450);
        packtype.setLayoutY(70);
        anchor2.getChildren().add(packtype);
        
        RadioButton platinumpack = new RadioButton("Platinum");
        RadioButton gpack = new RadioButton("Gold");
        RadioButton silverpack = new RadioButton("Silver");
                
        anchor2.getChildren().addAll(platinumpack, gpack,silverpack);
        
        Font font = Font.loadFont(new FileInputStream(font_path), 15);
        platinumpack.setStyle("-fx-text-fill: white;");
        platinumpack.setFont(font);
        platinumpack.setLayoutX(450);
        platinumpack.setLayoutY(100);
        platinumpack.setToggleGroup(group);
        platinumpack.selectedProperty().addListener(new ChangeListener<Boolean>() {
    @Override
    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
        if (isNowSelected) 
        {
            setPackage("Platinum");
            showSubScene(platpack);
        }
    }});
        
        gpack.setToggleGroup(group);
        gpack.setStyle("-fx-text-fill: white;");
        gpack.setFont(font);
        gpack.setLayoutX(650);
        gpack.setLayoutY(100);
        gpack.selectedProperty().addListener(new ChangeListener<Boolean>() {
    @Override
    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) 
    {
        if (isNowSelected) 
        { 
            setPackage("Gold");
            showSubScene(goldpack);
        }
    }});
        
        silverpack.setStyle("-fx-text-fill: white;");
        silverpack.setFont(font);
        silverpack.setLayoutX(850);
        silverpack.setLayoutY(100);
        silverpack.selectedProperty().addListener(new ChangeListener<Boolean>() {
    @Override
    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) 
    {
        if (isNowSelected) 
        { 
            setPackage("Silver");
            showSubScene(silpack);
            System.out.println(selectedpack+" has been selected");
        }
    }});
        
    silverpack.setToggleGroup(group);
    }
     
    private void addarrowIcon() throws FileNotFoundException
    {
        Image img = new Image(new FileInputStream(icon_path) , 50, 50, false, true);
        ImageView imgview = new ImageView(img);
        
        anchor2.getChildren().add(imgview);
        
        imgview.setLayoutX(20);
        imgview.setLayoutY(450);
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
            Text error = new Text("Please choose one of these fields");
            @Override
            public void handle(MouseEvent event) {
                if (group.getSelectedToggle() != null)
                {
                    error.setText("");
                    mainStage.setScene(seat);
                }
                else 
                {
                    Font font = null;
                    try {
                        font = Font.loadFont(new FileInputStream(font_path), 15);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(TripScene.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    error.setFont(font);
                    error.setFill(Paint.valueOf("Red"));
                    anchor2.getChildren().add(error);
                    error.setLayoutX(20);
                    error.setLayoutY(420);
                }
            }
            
        });
    }
    public void setPackage(String pack)
    {
        selectedpack = pack;
    }
}