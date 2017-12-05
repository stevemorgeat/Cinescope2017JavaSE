/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package essaie;

import connexion.Connexion;
import java.sql.Connection;


/**
 *
 * @author allth
 */
public class ConnexionTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Connection cn = Connexion.getConnexionMySQL("127.0.0.1", "cinescope2017", "3306", "root", "");
        System.out.println(cn);

        Connexion.seDeconnecter(cn);
        System.out.println(cn);
    }

}
