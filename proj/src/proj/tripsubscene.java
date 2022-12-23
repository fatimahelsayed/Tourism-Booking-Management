/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *
 * @author DELL
 */
public class tripsubscene extends SubScene{
    
    AnchorPane anchor;
    
    String back_image = "F:\\Dell\\Documents\\Programming\\Projects\\Project\\resources\\images\\mo-gabrail-iuC3w8mLDcs-unsplash.jpg";
    private final static String font_path = "F:\\Dell\\Documents\\Programming\\Projects\\Project\\resources\\fonts\\static\\Montserrat-Medium.ttf";

    public tripsubscene() throws FileNotFoundException {
        super(new AnchorPane(), 550, 300);
        anchor = new AnchorPane();
        prefWidth(550);
        prefHeight(300);
        
        setLayoutX(1024);
        setLayoutY(175);
        
        setRoot(anchor);
    }
    public void setFamilyToursDes() throws FileNotFoundException
    {
        Image temp = new Image(new FileInputStream(back_image),550,300,false,true);
        int width = (int)temp.getWidth(); 
        int height = (int)temp.getHeight(); 

        WritableImage wImage = new WritableImage(width, height);   
        PixelReader pixelReader = temp.getPixelReader(); 
        WritableImage view = new WritableImage(width,height);
        PixelWriter writer = view.getPixelWriter();

       for(int y = 0; y < height; y++) { 
         for(int x = 0; x < width; x++) { 
            Color color = pixelReader.getColor(x, y); 
            writer.setColor(x, y, color.darker());              
         }
       }	
       ImageView viewing = new ImageView(view);
       BackgroundImage image = new BackgroundImage(viewing.getImage(), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
       anchor.setBackground(new Background(image));
        
//       Text familydes = new Text("Family trips are a great way for children to meet and interact with other kids"
//                    + " from around the world who are close to their own age and share common interests. It’s not uncommon"
//                    + " for families who meet on our trips to stay close after the trip ends; some even make the experience"
//                    + " an annual tradition.");
//        Font font = Font.loadFont(new FileInputStream(font_path), 20);
//        familydes.setFont(font);
//        familydes.setFill(Paint.valueOf("White"));
//        anchor.getChildren().add(familydes);
//        familydes.setLayoutY(100);
    }
    public void setGenToursDes()
    {
        
    }
    public void setCouplesToursDes()
    {
        
    }

    public void setTransition()
    {
        TranslateTransition trans = new TranslateTransition();
        trans.setDuration(Duration.seconds(0.9));
        trans.setNode(this);
        
        trans.setToX(-500);
        trans.play();
    }
    public void setTransition2()
    {
        TranslateTransition trans = new TranslateTransition();
        trans.setDuration(Duration.seconds(0.9));
        trans.setNode(this);
        
        trans.setToX(1024);
        trans.play();
    }
}
