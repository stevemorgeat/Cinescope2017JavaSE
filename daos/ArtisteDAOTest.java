/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import connexion.Connexion;
import entities.Artiste;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author allth
 */
public class ArtisteDAOTest {

    public static void main(String[] args) throws SQLException {
        Connection lcnx = Connexion.getConnexionMySQL("127.0.0.1", "cinescope2017", "3306", "root", "");

//====================================INSERT==========================================
        System.out.println("====================================INSERT==========================================");
        Artiste aI = new Artiste("Ellen Page");
        ArtisteDAO daoI = new ArtisteDAO(lcnx);
        int rI = daoI.insert(aI);
        if (rI == 1) {
            lcnx.commit();
            System.out.println("update de " + rI + " enregistrement");
        }

//====================================UPDATE==========================================
        System.out.println("====================================UPDATE==========================================");
        Artiste dU = new Artiste(5, "Ellen PageEEE");
        ArtisteDAO daoU = new ArtisteDAO(lcnx);
        int rU = daoU.update(dU);
        System.out.println("update de " + rU + " enregistrement");

//====================================DELETE==========================================
        System.out.println("====================================DELETE==========================================");
        Artiste aD = new Artiste(5, "Ellen Page");
        ArtisteDAO daoD = new ArtisteDAO(lcnx);
        int rD = daoD.delete(aD);
        if (rD == 1) {
            lcnx.commit();
            System.out.println("delete de " + rD + " enregistrement");
        }

//====================================SELECTONE==========================================
        System.out.println("====================================SELECTONE==========================================");
        ArtisteDAO daoO = new ArtisteDAO(lcnx);
        Artiste dSelectOne = daoO.selectOne(3);
        System.out.println(dSelectOne);

//====================================SELECT==========================================
        System.out.println("====================================SELECT==========================================");
        ArtisteDAO daoS = new ArtisteDAO(lcnx);
        List<Artiste> liste = daoS.selectAll();
        Artiste dep;
        for (int i = 0; i < liste.size(); i++) {
            dep = liste.get(i);
            System.out.println(dep);
        }

    }
}
