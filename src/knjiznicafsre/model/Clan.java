/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knjiznicafsre.model;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
/**
 *
 * @author Daniel
 */
public class Clan {
    SimpleIntegerProperty id;
    SimpleStringProperty ime;
    SimpleStringProperty prezime;
    SimpleStringProperty sifra;
    SimpleStringProperty datum;

    public Clan(SimpleIntegerProperty id, SimpleStringProperty ime, SimpleStringProperty prezime, SimpleStringProperty sifra, SimpleStringProperty datum) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.sifra = sifra;
        this.datum = datum;
    }

    public SimpleIntegerProperty getId() {
        return id;
    }

    public void setId(SimpleIntegerProperty id) {
        this.id = id;
    }

    public SimpleStringProperty getIme() {
        return ime;
    }

    public void setIme(SimpleStringProperty ime) {
        this.ime = ime;
    }

    public SimpleStringProperty getPrezime() {
        return prezime;
    }

    public void setPrezime(SimpleStringProperty prezime) {
        this.prezime = prezime;
    }

    public SimpleStringProperty getSifra() {
        return sifra;
    }

    public void setSifra(SimpleStringProperty sifra) {
        this.sifra = sifra;
    }

    public SimpleStringProperty getDatum() {
        return datum;
    }

    public void setDatum(SimpleStringProperty datum) {
        this.datum = datum;
    }
    
    
    public void spasi () {
        try {
            
            String sql = "INSERT INTO clan VALUES (null, ?, ?, ?, ?)";
           
            PreparedStatement upit = Baza.DB.prepare (sql);
            upit.setString(1, this.ime.getValue());
            upit.setString(2, this.prezime.getValue());
            upit.setString(3, this.sifra.getValue());
            
            /**
             * Pretvori String u java.util.Date, a nakon toga u java.sql.Date
             * da bi se podatak mogao spasiti u bazu podataka
             */
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsiran = format.parse(this.datum.getValue());
            
            upit.setDate(4, new Date (parsiran.getTime()));
            upit.executeUpdate();
            
            
        } catch (SQLException ex) {
            System.out.print(ex);
        } catch (ParseException ex) {
            System.out.print(ex);
        }
    }
    
    
    
}
