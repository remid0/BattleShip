/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utclo23.ihmmain.controller;
import com.utclo23.data.module.DataException;
import com.utclo23.data.structure.Game;
import com.utclo23.data.structure.GameType;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javax.swing.JOptionPane;

/**
 * @author Audrick
 */
public class CreateGameController extends AbstractController{
    ToggleGroup mode;
    ToggleGroup enemy;
    
    @FXML
    RadioButton radioButtonClassical;
    
    @FXML
    RadioButton  radioButtonBelge;
    
    @FXML
    RadioButton  radioButtonComputer;
    
    @FXML
    RadioButton  radioButtonPlayer;
    
    @FXML 
    CheckBox radioButtonAudience;
    
    @FXML 
    CheckBox radioButtonChat;
    
    @FXML
    TextField gameNameField;
    
    @FXML
    public void initialize(){
        // Toggle Group
        mode = new ToggleGroup();
        enemy = new ToggleGroup();
        
        radioButtonClassical.setToggleGroup(mode);
        radioButtonBelge.setToggleGroup(mode);
        radioButtonComputer.setToggleGroup(enemy);
        radioButtonPlayer.setToggleGroup(enemy);
        
        // Default values
        radioButtonClassical.setSelected(true);
        radioButtonComputer.setSelected(true);
        
        //avatar
                
    }
    
    @FXML
    private void back(ActionEvent event) throws IOException{
        getIhmmain().toGameList();
    }
    
    @FXML
    private void validateCreateGame(ActionEvent event){
        String names = gameNameField.getText();
        gameNameField.setStyle("");
        JOptionPane msg = new JOptionPane();
        if (!names.isEmpty()){
            GameType modes = (((RadioButton) mode.getSelectedToggle()).getText()).equals("CLASSIC") ? GameType.CLASSIC : GameType.BELGIAN;
            boolean enemys = (((RadioButton) enemy.getSelectedToggle()).getText()).equals("Computer");
            boolean chats = radioButtonChat.isSelected();
            boolean audiences = radioButtonAudience.isSelected();
            try{
                Game newGame = facade.iDataIHMMain.createGame(names, enemys, audiences, chats, modes);
                msg.showMessageDialog(null, "Game created", "Information", JOptionPane.INFORMATION_MESSAGE);
                facade.iIHMTableToIHMMain.createInGameGUI();
            }catch (DataException e){
                showErrorPopup("Error","Game not created",
                    "Try again !");
            }
        }
        else
            gameNameField.setStyle("-fx-border-color: #ef8d00;");
    }
}