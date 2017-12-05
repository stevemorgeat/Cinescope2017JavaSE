/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package essaie;

import java.io.*;
import java.sql.*;

/**
 *
 * @author Steve
 */
public class CsvToBdVille {

    
        public static void main(String[] args) {
        try {
            // --- Ouverture du fichier
            FileReader lfrFichier = new FileReader("c:/tempo/communes.csv");
            // --- Bufferisation
            BufferedReader lbrBuffer = new BufferedReader(lfrFichier);

            // --- Lecture des lignes-enregistrements
            String lsLigne;
            //première ligne sautée
            lsLigne = lbrBuffer.readLine();
            
            // Chronomètrage : départ!
            java.util.Date dd = new java.util.Date();
            long llDD = dd.getTime();
            
            //connexion à la BDDDDD
            Connection lcn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cours", "root", "");
            // ordre insert
            String lsSQL = "INSERT INTO communes (nom_commune, cp_commune,departement_commune,insee_commune) VALUES (?,?,?,?)";
            // auto commit false pour un gain de temps
            lcn.setAutoCommit(false);
            //on prépare notre ordre SQL
            PreparedStatement lpst = lcn.prepareStatement(lsSQL);
            // boucle sur le fichier sur chaque ligne non null
            while ((lsLigne = lbrBuffer.readLine()) != null) {
                // vérification si la ligne est pas avec simplement des espace
                if (!lsLigne.trim().equals("")) {
                    // split de la ligne pour dispatcher les VALUES
                    String[] t = lsLigne.split(";");
                    // vérification que la ligne comprend bien 4 valeurs
                    if (t.length == 4) {
                        lpst.setString(1, t[0]);
                        lpst.setString(2, t[1]);
                        lpst.setString(3, t[2]);
                        lpst.setString(4, t[3]);
                        // on execute l'ordre insert pour chaque ligne valide
                        lpst.executeUpdate();
                    }
                }
            }
            
            // commit de nos enregistrement
            lcn.commit();
            //close close close
            lpst.close();
            lcn.close();

            lbrBuffer.close();
            lfrFichier.close();
            System.out.println("OK !!!");
            
            // Chronomètrage : Fin!
            java.util.Date df = new java.util.Date();
            long llDF = df.getTime();
            
            // affichage du temps
            System.out.println("Temps : " + (llDF-llDD));

        } catch (IOException | SQLException e) {
            System.err.println("Erreur de fichier : " + e.getMessage());
        }
    }
}
