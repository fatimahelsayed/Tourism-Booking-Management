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
import javafx.scene.control.Toggle;
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
import static proj.ViewManager.mainScene;
import static proj.ViewManager.mainStage;
import static proj.ViewManager.pack;
import static proj.ViewManager.seat;

/**
 *
 * @author DELL
 */
public class TripScene extends Scene {
    AnchorPane anchor;
    AnchorPane anchor2;
    
    ToggleGroup group = new ToggleGroup();

    tripsubscene famtour;
    tripsubscene gentour;
    tripsubscene couptour;
    tripsubscene trips;
    
    private final String background_path = "F:\\Dell\\Documents\\Programming\\Projects\\Project\\resources\\images\\marsaalam.jpg";
    private final static String font_path = "F:\\Dell\\Documents\\Programming\\Projects\\Project\\resources\\fonts\\static\\Montserrat-Medium.ttf";
    private final static String font_path2 = "F:\\Dell\\Documents\\Programming\\Projects\\Project\\resources\\fonts\\Masvis Italic.ttf";
    private final static String icon_path = "F:\\Dell\\Documents\\Programming\\Projects\\Project\\resources\\images\\arrow.png";
    
    public static String selectedtour;
    
    public TripScene() throws FileNotFoundException {
        super(new AnchorPane(), 1024, 500);
        anchor = new AnchorPane();
        anchor2 = new AnchorPane();
        
        createSubScenes();       
        setBackground();    
        getStylesheets().add(getClass().getResource("hoverbutton.css").toExternalForm());
        addrectangle();
//        System.out.println(getClass().getResource("marsaalam.jpg"));
        addText();
        addTripFields();
        addarrowIcon();        
        anchor.getChildren().add(trips);
        anchor.getChildren().add(anchor2);
        setRoot(anchor);
    }
    private void createSubScenes() throws FileNotFoundException
    {
        famtour = new tripsubscene();
        famtour.setFamilyToursDes();
        gentour = new tripsubscene();
        gentour.setGenToursDes();
        couptour = new tripsubscene();
        couptour.setCouplesToursDes();
        trips = new tripsubscene();
        anchor.getChildren().addAll(famtour, gentour, couptour);
    }
    private void setBackground()
    {
        Image image = new Image(background_path, 1024,500,false,true);
        BackgroundImage background = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        anchor.setBackground(new Background(background));
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

        
        loginText.setLayoutX(40);
        loginText.setLayoutY(100);
    }
     private void addTripFields() throws FileNotFoundException
    {
        Text tourtype = new Text("Step 1: Choose your type of Tour");
        Font font1 = Font.loadFont(new FileInputStream(font_path), 30);
        tourtype.setFont(font1);
        tourtype.setFill(Paint.valueOf("White"));
        tourtype.setLayoutX(450);
        tourtype.setLayoutY(70);
        anchor2.getChildren().add(tourtype);
        
        famtour.setFamilyToursDes();
        gentour.setGenToursDes();
        couptour.setCouplesToursDes();
        
       // ToggleGroup group = new ToggleGroup();
        
        RadioButton ftour = new RadioButton("Family Tour");
        RadioButton gtour = new RadioButton("General Tour");
        RadioButton ctour = new RadioButton("Couple Tour");
                
        anchor2.getChildren().addAll(ftour, gtour,ctour);
        
        Font font = Font.loadFont(new FileInputStream(font_path), 15);
        ftour.setStyle("-fx-text-fill: white;");
        ftour.setFont(font);
        ftour.setLayoutX(450);
        ftour.setLayoutY(100);
        ftour.setToggleGroup(group);
        ftour.selectedProperty().addListener(new ChangeListener<Boolean>() {
        @Override
        public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
            if (isNowSelected) { 
                setTour("Family");
                showSubScene(famtour);
            }
        }
        });
        
        gtour.setToggleGroup(group);
        gtour.setStyle("-fx-text-fill: white;");
        gtour.setFont(font);
        gtour.setLayoutX(650);
        gtour.setLayoutY(100);
        gtour.selectedProperty().addListener(new ChangeListener<Boolean>() {
        @Override
        public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
            if (isNowSelected) { 
                setTour("General");
                showSubScene(gentour);
            }
        }
        });
        
        ctour.setToggleGroup(group);
        ctour.setStyle("-fx-text-fill: white;");
        ctour.setFont(font);
        ctour.setLayoutX(850);
        ctour.setLayoutY(100);
        ctour.selectedProperty().addListener(new ChangeListener<Boolean>() {
        @Override
        public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
            if (isNowSelected) { 
                setTour("Couples");
                showSubScene(couptour);
            }
        }
        });
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
                    mainStage.setScene(pack);
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
    public void setTour(String tour)
    {
        selectedtour = tour;
    }
}
