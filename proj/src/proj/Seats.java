package proj;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import proj.tripsubscene;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class Seats extends Scene{
     AnchorPane anchor;
    AnchorPane anchor2;
    
    tripsubscene trips;
    
    private final String background_path = "F:\\Dell\\Documents\\Programming\\Projects\\Project\\resources\\images\\slay.jpg";
    private final static String font_path = "F:\\Dell\\Documents\\Programming\\Projects\\Project\\resources\\fonts\\static\\Montserrat-Medium.ttf";
    private final static String font_path2 = "F:\\Dell\\Documents\\Programming\\Projects\\Project\\resources\\fonts\\Masvis Italic.ttf";

    public Seats() throws FileNotFoundException {
       super(new AnchorPane(), 1024, 500);
        anchor = new AnchorPane();
        anchor2 = new AnchorPane();
        trips = new tripsubscene();
        
        setBackground();    
        getStylesheets().add(getClass().getResource("hoverbutton.css").toExternalForm());
        addrectangle();
//        System.out.println(getClass().getResource("marsaalam.jpg"));
        addText();
        addPackageFields();
       // addPackageFields();
        
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
        Text packtype = new Text("Step 3: Choose your desired Place");
        Font font1 = Font.loadFont(new FileInputStream(font_path), 30);
        packtype.setFont(font1);
        packtype.setFill(Paint.valueOf("White"));
        packtype.setLayoutX(450);
        packtype.setLayoutY(70);
        anchor2.getChildren().add(packtype);
        
    }
     
     
}
