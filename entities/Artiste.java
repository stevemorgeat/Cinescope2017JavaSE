/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

/**
 *
 * @author allth
 */
public class Artiste {
    private int idArtiste;
    private String nomArtiste;

    public Artiste() {
    }

    public Artiste(int idArtiste, String nomArtiste) {
        this.idArtiste = idArtiste;
        this.nomArtiste = nomArtiste;
    }

    public Artiste(String nomArtiste) {
        this.nomArtiste = nomArtiste;
    }

    public int getIdArtiste() {
        return idArtiste;
    }

    public void setIdArtiste(int idArtiste) {
        this.idArtiste = idArtiste;
    }

    public String getNomArtiste() {
        return nomArtiste;
    }

    public void setNomArtiste(String nomArtiste) {
        this.nomArtiste = nomArtiste;
    }

    @Override
    public String toString() {
        return "Artiste{" + "idArtiste=" + idArtiste + ", nomArtiste=" + nomArtiste + '}';
    }
    
    
}
