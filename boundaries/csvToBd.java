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
public class csvToBd {

    
        public static void main(String[] args) {
        try {
            // --- Ouverture du fichier
            FileReader lfrFichier = new FileReader("c:/tempo/metro_paris.txt");
            // --- Bufferisation
            BufferedReader lbrBuffer = new BufferedReader(lfrFichier);

            // --- Lecture des lignes-enregistrements
            String lsLigne;

            lsLigne = lbrBuffer.readLine();

            // INSERT INTO station_metro(NOM_station_metro,lat,lng) VALUES(?,?,?);
            // NOM_station_metro;lat;lng
            String[] t = lsLigne.split(";");
            int n = t.length;
            String lsParams = "";
            for (int i = 0; i < n; i++) {
                lsParams += "?,";
            }
            lsParams = lsParams.substring(0, lsParams.length() - 1);
            Connection lcn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinescope2017", "root", "");
            String lsSQL = "INSERT INTO station_metro(" + lsLigne.replace(";", ",") + ") VALUES(" + lsParams + ")";
            PreparedStatement lpst = lcn.prepareStatement(lsSQL);

            while ((lsLigne = lbrBuffer.readLine()) != null) {
                if (!lsLigne.trim().equals("")) {
                    t = lsLigne.split(";");
                    if (t.length == 3) {
                        lpst.setString(1, t[0]);
                        lpst.setString(2, t[1]);
                        lpst.setString(3, t[2]);
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
