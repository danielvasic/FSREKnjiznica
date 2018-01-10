/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knjiznicafsre.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import knjiznicafsre.model.Korisnik;

/**
 * FXML Controller class
 *
 * @author Daniel
 */
public class AdministracijaController implements Initializable {

    static Korisnik logiraniKorisnik;
    
    @FXML 
    Label imeprezime;
    
    
    @FXML
    Button dodaj_clana;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.imeprezime.setText(logiraniKorisnik.getIme()+ " " + logiraniKorisnik.getPrezime());
    }
    
    @FXML
    public void otvori_dodaj_korisnika (ActionEvent e) {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/knjiznicafsre/view/DodajKorisnik.fxml"));
            loader.load();
            
            Parent root = loader.getRoot();
            
            Scene scene = new Scene (root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AdministracijaController.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
    }
    
}
