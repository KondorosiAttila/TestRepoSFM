/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.view;

import hu.unideb.inf.model.Model;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author hallgato
 */
public class FXMLStudentsSceneController implements Initializable {

    private Model model;

    public void setModel(Model model) {
        this.model = model;
    }
    
    @FXML
    private Label colorLabel;


    @FXML
    void handleButtonPushed() {
        System.out.println("Gomb!!!");
        if (colorLabel.getText().equals("Fekete")) {
            colorLabel.setText("Fehér");
        } else {
            colorLabel.setText("Fekete");
        }
    }
    
    @FXML
    private Label nameLabel;

    @FXML
    private Label creditsLabel;

    @FXML
    private Label bdLabel;
    
    @FXML
    private TextField newNametf;

    @FXML
    void handleLoadButtonPushed() {
        
        nameLabel.textProperty().bind(model.getStudent().nameProperty());
        
        //nameLabel.setText(model.getStudent().getName());
        creditsLabel.setText("" + model.getStudent().getCredits());
        bdLabel.setText(model.getStudent().getBirthDate().toString());
    }

    
    @FXML
    void handleChangeButton() {
        model.getStudent().setName(newNametf.getText());
        //nameLabel.setText(model.getStudent().getName());
        //creditsLabel.setText("" + model.getStudent().getCredits());
        //bdLabel.setText(model.getStudent().getBirthDate().toString());
        
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Button pushed");
        alert.setHeaderText("You have pushed the Change Name button");
        alert.setContentText("This shows that you have pushed a button...");
        alert.showAndWait();    
    }
    
    
    @FXML
    void handleSaveButtonPushed() throws IOException {
        try (
            FileOutputStream fos = new FileOutputStream("student.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);) 
        {
            oos.writeObject(model.getStudent());
        }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
