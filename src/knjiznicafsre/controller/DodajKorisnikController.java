/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knjiznicafsre.controller;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import knjiznicafsre.model.Clan;

/**
 * FXML Controller class
 *
 * @author Daniel
 */
public class DodajKorisnikController implements Initializable {

    
    
    @FXML 
    TextField ime;
    @FXML 
    TextField prezime;
    @FXML 
    TextField sifra;
    @FXML 
    DatePicker datum;
    
    Stage stage;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*
        Prilikom inicijalizacije napraviti pozornicu radi lakseg upravljanj
        */
        this.stage = (Stage) this.datum.getScene().getWindow();
    }  
    
    
    @FXML
    public void spasi (ActionEvent e) {
        /**
         * 
         * Potrebno je pretvoriti datum od DatePicker-a (LocalDate) 
         * u string uz pomoc DateTimeFormatter klase
         */
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String datum_str = dtf.format(this.datum.getValue());
        System.out.println(datum_str);
        SimpleStringProperty ime = new SimpleStringProperty(this.ime.getText());
        SimpleStringProperty prezime = new SimpleStringProperty(this.prezime.getText());
        SimpleStringProperty sifra = new SimpleStringProperty(this.sifra.getText());
        SimpleStringProperty datum = new SimpleStringProperty(datum_str);
        Clan c = new Clan (null, ime, prezime, sifra,datum);
        c.spasi();
        
        /**
         * Zatvori pozornicu.
         */
        
         
         this.stage.close();

    }
    
}
