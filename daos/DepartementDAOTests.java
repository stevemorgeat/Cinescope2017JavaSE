/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import connexion.Connexion;
import entities.Departement;
import java.sql.*;
import java.util.List;

/**
 *
 * @author allth
 */
public class DepartementDAOTests {

    public static void main(String[] args) {
        Connection lcnx = Connexion.getConnexionMySQL("127.0.0.1", "cinescope2017", "3306", "root", "");
        
//====================================INSERT==========================================
        System.out.println("====================================INSERT==========================================");
        Departement d = new Departement("93", "SD");
        DepartementDAO daoI = new DepartementDAO(lcnx);
        int r = daoI.insert(d);
        System.out.println(r);
        
//====================================DELETE==========================================
        System.out.println("====================================DELETE==========================================");
//        Departement d = new Departement(9,"99", "Neuf");
//        DepartementDAO daoD = new DepartementDAO(lcnx);
//        int r = daoD.delete(d);
//        System.out.println(r);
        
//====================================UPDATE==========================================
        System.out.println("====================================UPDATE==========================================");
//        Departement d = new Departement(11,"9", "Neuf");
//        DepartementDAO daoU = new DepartementDAO(lcnx);
//        int r = daoU.update(d); 
//        System.out.println(r);
        
//====================================SELECTONE==========================================
        System.out.println("====================================SELECTONE==========================================");
        DepartementDAO daoO = new DepartementDAO(lcnx);
        Departement dSelectOne = daoO.selectOne(11);
        System.out.println(dSelectOne);

//====================================SELECT==========================================
        System.out.println("====================================SELECT==========================================");
        DepartementDAO daoS = new DepartementDAO(lcnx);
        List<Departement> liste = daoS.select();
        Departement dep;
        for (int i = 0; i < liste.size(); i++) {
            dep = liste.get(i);
            System.out.println(dep);
        }

    }

}
