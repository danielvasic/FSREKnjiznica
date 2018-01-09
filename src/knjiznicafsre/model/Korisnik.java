/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knjiznicafsre.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class Korisnik {
    private Integer id;
    private String ime;
    private String prezime;
    private String email;
    private String lozinka;

    public Korisnik(Integer id, String ime, String prezime, String email, String lozinka) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.lozinka = lozinka;
    }
    
    public static List<Korisnik> getAll () {
        try {
            List<Korisnik> korisnici = new ArrayList <>();
           
            
            ResultSet rs = Baza.DB.select("SELECT * FROM korisnik");
            while (rs.next()) {
                korisnici.add (new Korisnik (
                        rs.getInt("id"),
                        rs.getString("ime"),
                        rs.getString("prezime"),
                        rs.getString("email"),
                        rs.getString("lozinka")
                ));
            }
            return korisnici;
        } catch (SQLException ex) {
            return new ArrayList<>();
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    @Override
    public String toString() {
        return "Korisnik{" + "id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", email=" + email + ", lozinka=" + lozinka + '}';
    }
    
    
    
}
