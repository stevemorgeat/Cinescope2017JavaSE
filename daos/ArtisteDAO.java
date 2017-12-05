/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package daos;

import entities.Artiste;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author allth
 */
public class ArtisteDAO implements IDAO<Artiste> {

    
    private Connection cnx;

    public ArtisteDAO(Connection cnx) {
        this.cnx = cnx;
    }
    
    @Override
    public int insert(Artiste objet) {
         // Déclaration des attributs
        int liAffecte = 0;

        try {
            // Préparation de la procédure stockée
            PreparedStatement lpst = cnx.prepareStatement("CALL artisteInsert(?)");

            // Valorisation des paramètres
            lpst.setString(1, objet.getNomArtiste());

            // Exécution de l'ordre SQL
            liAffecte = lpst.executeUpdate();

            // Fermeture des curseurs
            lpst.close();

        } catch (SQLException e) { // Si une exception est levée
            System.out.println(e.getMessage());
            liAffecte = -1;
        }

        return liAffecte;
    }

    @Override
    public List<Artiste> selectAll() {
        List<Artiste> listeArtiste = new ArrayList();

        try {
            // Préparation de la procédure stockée
            PreparedStatement lpst = cnx.prepareStatement("CALL artisteSelectAll()");
            // Exécution de l'ordre SQL
            ResultSet lrs = lpst.executeQuery();

            // Boucle sur la table 
            while (lrs.next()) {
                Artiste a = new Artiste();
                a.setIdArtiste(lrs.getInt(1));
                a.setNomArtiste(lrs.getString(2));
                // Enregistrement et ajout des datas dans la liste
                listeArtiste.add(a);
            }
            // Fermeture des curseurs
            lrs.close();
            lpst.close();

        } catch (SQLException e) { // Si une exception est levée
            System.out.println(e.getMessage());
        }

        return listeArtiste;
    }

    @Override
    public Artiste selectOne(int id) {
         // Déclaration des attributs
        Artiste a = new Artiste();

        try {
            // Préparation de la procédure stockée
            PreparedStatement lpst = cnx.prepareStatement("CALL artisteSelectOne(?)");

            // Valorisation des paramètres
            lpst.setInt(1, id);

            // Exécution de l'ordre SQL
            ResultSet lrs = lpst.executeQuery();

            // Boucle pour la récupération des informations d'un département
            // Si le département est bon
            if (lrs.next()) {
                a.setIdArtiste(id);
                a.setNomArtiste(lrs.getString("nom_artiste"));
                // Si le département n'existe pas
            } else {
                a.setIdArtiste(0);
                a.setNomArtiste("INTROUVABLE");
            }

            // Fermeture des curseurs
            lrs.close();
            lpst.close();

        } catch (SQLException e) { // Si une exception est levée
            a.setIdArtiste(-1);
            a.setNomArtiste(e.getMessage());
        }

        return a;
    }

    @Override
    public int delete(Artiste objet) {
        int liAffecte;

        try {
            // Préparation de la procédure stockée
            PreparedStatement lpst = cnx.prepareStatement("CALL artisteDelete(?)");

            // Valorisation des paramètres
            lpst.setInt(1, objet.getIdArtiste());

            // Exécution de l'ordre SQL
            liAffecte = lpst.executeUpdate();

            // Fermeture des curseurs
            lpst.close();

        } catch (SQLException e) { // Si une exception est levée
            liAffecte = -1;
            System.out.println(e.getMessage());
        }

        return liAffecte;
    }

    @Override
    public int update(Artiste objet) {
        // Déclaration des attributs
        int liAffecte;

        try {
            // Préparation de la procédure stockée
            PreparedStatement lpst = cnx.prepareStatement("CALL artisteUpdate(?,?)");

            // Valorisation des paramètres
            lpst.setString(1, objet.getNomArtiste());
            lpst.setInt(2, objet.getIdArtiste());

            // Exécution de l'ordre SQL
            liAffecte = lpst.executeUpdate();

            // Fermeture des curseurs
            lpst.close();

        } catch (SQLException e) { // Si une exception est levée
            liAffecte = -1;
        }

        return liAffecte;
    }
    
}
