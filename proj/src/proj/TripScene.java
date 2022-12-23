/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *
 * @author DELL
 */
public class TripScene extends Scene {
    AnchorPane anchor;
    AnchorPane anchor2;
    
    tripsubscene trips;
    
    private final String background_path = "F:\\Dell\\Documents\\Programming\\Projects\\Project\\resources\\images\\marsaalam.jpg";
    private final static String font_path = "F:\\Dell\\Documents\\Programming\\Projects\\Project\\resources\\fonts\\static\\Montserrat-Medium.ttf";
    private final String box_style = "-fx-border-width: 1px; -fx-border-color: -fx-darkest-grey-color; -fx-background-color: white; -fx-background-image: null; -fx-border-radius: 15px; -fx-padding: 3px;";
    
    public TripScene() throws FileNotFoundException {
        super(new AnchorPane(), 1024, 500);
        anchor = new AnchorPane();
        anchor2 = new AnchorPane();
        trips = new tripsubscene();
        
        setBackground();        
        getStylesheets().add(getClass().getResource("hoverbutton.css").toExternalForm());
        addrectangle();
        System.out.println(getClass().getResource("//resources//marsaalam.jpg"));
        addText();
        addTripFields();
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
    private void addrectangle() throws FileNotFoundException
    {
        Rectangle rectangle = new Rectangle(650,500);
        rectangle.setLayoutX(374);
        rectangle.setStyle("-fx-background-color: CadetBlue; -fx-opacity: 0.4;");
        anchor2.getChildren().add(rectangle);
    }
    private void addText() throws FileNotFoundException
    {
        Text loginText = new Text("Choose Your\nTrip");
        Font font = Font.loadFont(new FileInputStream(font_path), 45);
        loginText.setFont(font);
        loginText.setFill(Paint.valueOf("White"));
        anchor2.getChildren().add(loginText);
        loginText.setLayoutY(100);
        loginText.setLayoutX(35);
    }
    private void addTripFields() throws FileNotFoundException
    {
        ToggleGroup group = new ToggleGroup();
        
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
            trips.setTransition();
        } else {
            trips.setTransition2();
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
            trips.setTransition();
        } else {
            trips.setTransition2();
        }
    }
});
        
        
        ctour.setStyle("-fx-text-fill: white;");
        ctour.setFont(font);
        ctour.setLayoutX(850);
        ctour.setLayoutY(100);
        ctour.selectedProperty().addListener(new ChangeListener<Boolean>() {
    @Override
    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
        if (isNowSelected) { 
            trips.setTransition();
        } else {
            trips.setTransition2();
        }
    }
});
        ctour.setToggleGroup(group);
    }
}
