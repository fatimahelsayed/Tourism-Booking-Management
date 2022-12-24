/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author DELL
 */
public class button extends ToggleButton{
    
    private int WIDTH = 150;
    private int HEIGHT = 20;
    
    private final String BUTTON_PRESSED = "-fx-background-color: white; -fx-border-color:white; -fx-opacity: 0.6; -fx-text-fill: black; -fx-font-family:Montserrat; -fx-font-size:16; ";
    private final String BUTTON_FREE = "-fx-background-color:null; -fx-text-fill: white; -fx-font-family:Montserrat; -fx-font-size:16; -fx-border-color:white; ";
    
    public button(String text)
    {
        setPrefWidth(WIDTH);
        setPrefHeight(HEIGHT);
        setPadding(new Insets(5,10,5,10));
        setText(text);
        setStyle(BUTTON_FREE);
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

