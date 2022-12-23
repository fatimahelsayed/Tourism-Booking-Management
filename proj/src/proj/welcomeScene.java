/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proj;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.buttons;

/**
 *
 * @author DELL
 */
public class welcomeScene extends Scene{
    
    public welcomeScene(Parent parent, double d, double d1) throws FileNotFoundException {
        super(parent, d, d1);
        String font_path = "F:\\Dell\\Documents\\Programming\\Projects\\Project\\resources\\fonts\\Afterglow-Regular.ttf";
        StackPane stack = new StackPane();
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setAlignment(Pos.CENTER);
        FileInputStream in = new FileInputStream(new File("C:\\Users\\DELL\\Documents\\NetBeansProjects\\proj\\camelimage.jpg"));
        Image img = new Image(in);
        ImageView view = new ImageView();
        view.setImage(img);
        view.setFitWidth(1000);
        view.setPreserveRatio(true);
        view.setCache(true);
        view.setSmooth(true); // improve performance
        stack.getChildren().add(view);
        Text welcometxt = new Text("WELCOME");
        Font font = Font.loadFont(new FileInputStream(font_path), 60);
        welcometxt.setFont(font);
        grid.add(welcometxt, 0, 0);
        buttons btn = new buttons("LOG IN");
        grid.add(btn, 0, 1);
        buttons btn2 = new buttons("SIGN UP");
        grid.add(btn2, 0, 2);
        stack.getChildren().add(grid);
        setRoot(stack);
        btn.buttonlis();
        btn2.buttonlis();
    }
    
}
