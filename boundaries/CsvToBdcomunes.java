/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundaries;

import java.io.*;
import java.sql.*;

/**
 *
 * @author allth
 */
public class CsvToBdcomunes {

    
        public static void main(String[] args) {
        try {
            // --- Ouverture du fichier
            FileReader lfrFichier = new FileReader("c:/tempo/commune.csv");
            // --- Bufferisation
            BufferedReader lbrBuffer = new BufferedReader(lfrFichier);

            // --- Lecture des lignes-enregistrements
            String lsLigne;
            lsLigne = lbrBuffer.readLine();
            // INSERT INTO departement(code_departement,nom_departement) VALUES(?,?);
                        
            Connection lcn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinescope2017", "root", "");
            String lsSQL = "INSERT INTO ville (id_departement,CP,nom_ville) VALUES (?,?,?)";
            PreparedStatement lpst = lcn.prepareStatement(lsSQL);
            PreparedStatement lpst2 = lcn.prepareStatement("select id_departement from departement where code_departement = ?");
            while ((lsLigne = lbrBuffer.readLine()) != null) {
                if (!lsLigne.trim().equals("")) {
                    String[] t = lsLigne.split(";");
                    if (t.length == 6) {
                        lpst.setString(1, t[1]);
                        lpst.setString(2, t[2]);
                        lpst.executeUpdate();
                    }
                }
            }

            lpst.close();
            lcn.close();

            lbrBuffer.close();
            lfrFichier.close();
            System.out.println("OK !!!");

        } catch (IOException | SQLException e) {
            System.err.println("Erreur de fichier : " + e.getMessage());
        }
    }
}
