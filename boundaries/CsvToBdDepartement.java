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
public class CsvToBdDepartement {

    
        public static void main(String[] args) {
        try {
            // --- Ouverture du fichier
            FileReader lfrFichier = new FileReader("c:/tempo/departement2.csv");
            // --- Bufferisation
            BufferedReader lbrBuffer = new BufferedReader(lfrFichier);

            // --- Lecture des lignes-enregistrements
            String lsLigne;
            // INSERT INTO departement(code_departement,nom_departement) VALUES(?,?);
                        
            Connection lcn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinescope2017", "root", "");
            String lsSQL = "INSERT INTO departement(code_departement,nom_departement) VALUES (?,?)";
            PreparedStatement lpst = lcn.prepareStatement(lsSQL);

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
