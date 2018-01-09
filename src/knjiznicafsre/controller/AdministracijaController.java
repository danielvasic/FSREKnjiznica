/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knjiznicafsre.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.imeprezime.setText(logiraniKorisnik.getIme()+ " " + logiraniKorisnik.getPrezime());
    }    
    
}
