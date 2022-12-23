/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javafx.scene.control.Button;

/**
 *
 * @author DELL
 */
public class loginButtons extends Button{
    private final String stylecss = "src/proj/test.css";
    public loginButtons(String text)
    {
        setText(text);

        setPrefWidth(300);
        setPrefHeight(29);
    }
}
