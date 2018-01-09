/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knjiznicafsre.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import knjiznicafsre.model.Baza;
import knjiznicafsre.model.Korisnik;

/**
 *
 * @author Daniel
 */
public class LoginViewController implements Initializable {
    
    
    @FXML
    TextField email;
    
    @FXML 
    PasswordField lozinka;
    
    @FXML
    Button prijava;
    
    @FXML
    Label greska;
    
    
    @FXML
    public void prijavise (ActionEvent e) {
        String emailString = this.email.getText();
        String lozinkaString = this.lozinka.getText();
        
        if (emailString.equals("") && lozinkaString.equals("")) {
            this.greska.setText("Greška Niste unjeli email i lozinku");
        } else if (emailString.equals("")) {
            this.greska.setText("Greška Niste unijeli email");
        } else if (lozinkaString.equals("")) {
            this.greska.setText("Greska Niste unijeli lozinku");
        } else {
            try {
                // Ovdje provjeravamo korisnika u bazi
                PreparedStatement iskaz = Baza.DB.prepare("SELECT * FROM korisnik WHERE email=? AND lozinka=?");
                iskaz.setString(1, emailString);
                iskaz.setString(2, lozinkaString);
                ResultSet rs = iskaz.executeQuery();
                if (!rs.isBeforeFirst()) {
                    this.greska.setText("Pogrešni korisnički podaci.");
                } else {
                    Stage stage = (Stage) this.prijava.getScene().getWindow();
                    
                    rs.first();
                    Korisnik logiraniKorisnik = new Korisnik(
                            rs.getInt("id"),
                            rs.getString("ime"),
                            rs.getString("prezime"),
                            rs.getString("email"),
                            rs.getString("lozinka")
                    );
                    
                    AdministracijaController.logiraniKorisnik = logiraniKorisnik;
                    
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/knjiznicafsre/view/Administracija.fxml"));
                    loader.load();
                    
                    Parent root = loader.getRoot();
                    
                    Scene scene = new Scene (root);
                    stage.setScene(scene);
                    stage.show();
                    
                }
            } catch (SQLException ex) {
                System.out.println("Greška prilikom provjere korisnika, neispravan upit.");
            
            } catch (IOException ex) {
                Logger.getLogger(LoginViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
