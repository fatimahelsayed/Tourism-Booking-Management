/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author DELL
 */
public class buttons extends Button{
    private final String BUTTON_PRESSED = "-fx-background-color:#000000B2; -fx-font-family:Montserrat; -fx-text-fill:white; -fx-font-size:16;";
    private final String BUTTON_FREE = "-fx-background-color:Black; -fx-font-family:Montserrat; -fx-text-fill:white; -fx-font-size:16;";
    public buttons(String text)
    {
        setText(text);
        setPrefWidth(300);
        setPrefHeight(29);
        setPadding(new Insets(5,10,5,10));
        setStyle("-fx-background-color:Black; -fx-font-family:Montserrat; -fx-text-fill:white; -fx-font-size:16;");
        buttonlis();
    }
    public void setfreebutton()
    {
        setStyle(BUTTON_FREE);
        setPrefHeight(29);
        setLayoutY(getLayoutY());
    }
    public void setpressedbutton()
    {
        setStyle(BUTTON_PRESSED);
        setPrefHeight(29);
        setLayoutY(getLayoutY());
    }
    public void buttonlis()
    {
        setOnMousePressed(new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent event) {

                    if(event.getButton().equals(MouseButton.PRIMARY))
                    {
                        setpressedbutton();
                    }
                }
            }
                    
        );
        setOnMouseReleased(new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent event) {

                    if(event.getButton().equals(MouseButton.PRIMARY))
                    {
                        setfreebutton();
                    }
                }
            }
        );
        setOnMouseEntered(new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent event) {

                    setpressedbutton();
                }
            }
        );
        setOnMouseExited(new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent event) {

                    setfreebutton();
                }
            }
        );
    }
}
