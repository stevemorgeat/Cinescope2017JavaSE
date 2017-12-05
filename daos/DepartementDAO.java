/*
 * 
 */
package daos;

import entities.Departement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author allth
 */
public class DepartementDAO {

    private Connection icnx;

    public DepartementDAO(Connection icnx) {
        this.icnx = icnx;
    }

    public int insert(Departement d) {
        int liAffecte = 0;

        try {
            String lsSQL = "CALL departementInsert(?,?)";
            PreparedStatement lpst = icnx.prepareStatement(lsSQL);
            lpst.setString(1, d.getCodeDepartement());
            lpst.setString(2, d.getNomDepartement());
            liAffecte = lpst.executeUpdate();
            icnx.commit();
            lpst.close();

        } catch (SQLException e) {
            liAffecte = -1;
        }

        return liAffecte;
    }/// insert

    public int delete(Departement d) {

        int liAffecte;

        try {
            String lsSQL = "CALL departementDelete(?)";
            PreparedStatement lpst = icnx.prepareStatement(lsSQL);
            lpst.setInt(1, d.getIdDepartement());
            liAffecte = lpst.executeUpdate();
            icnx.commit();
            lpst.close();

        } catch (SQLException e) {
            liAffecte = -1;
            System.out.println(e.getMessage());
        }
        return liAffecte;
    }/// delete

    public int update(Departement d) {

        int liAffecte;

        try {
            String lsSQL = "CALL departementUpdate(?,?,?)";
            PreparedStatement lpst = icnx.prepareStatement(lsSQL);
            lpst.setString(1, d.getCodeDepartement());
            lpst.setString(2, d.getNomDepartement());
            lpst.setInt(3, d.getIdDepartement());
            liAffecte = lpst.executeUpdate();
            icnx.commit();
            lpst.close();

        } catch (SQLException e) {
            liAffecte = -1;
            System.out.println(e.getMessage());
        }
        return liAffecte;
    }/// update

    public Departement selectOne(int id) {

        Departement d = new Departement();

        try {
            String lsSQL = "CALL departementSelectById(?)";
            PreparedStatement lpst = icnx.prepareStatement(lsSQL);
            lpst.setInt(1, id);
            ResultSet lrs = lpst.executeQuery();
            icnx.commit();
            if (lrs.next()) {
                d.setIdDepartement(id);
                d.setCodeDepartement(lrs.getString("code_departement"));
                d.setNomDepartement(lrs.getString("nom_departement"));
            } else {
                d.setIdDepartement(id);
                d.setCodeDepartement("introuvable");
                d.setNomDepartement("introuvable");
            }
            lrs.close();
            lpst.close();

        } catch (SQLException e) {
            d.setIdDepartement(-1);
            d.setCodeDepartement(e.getMessage());
            d.setNomDepartement(e.getMessage());
            System.out.println(e.getMessage());
        }
        return d;
    }/// selectOne

    public List<Departement> select() {

        List<Departement> liste = new ArrayList();
        Departement d;

        try {
            String lsSQL = "CALL departementSelectAll()";
            PreparedStatement lpst = icnx.prepareStatement(lsSQL);
            ResultSet lrs = lpst.executeQuery();
            icnx.commit();
            while (lrs.next()) {
                d = new Departement();
                d.setIdDepartement(lrs.getInt("id_departement"));
                d.setCodeDepartement(lrs.getString("code_departement"));
                d.setNomDepartement(lrs.getString("nom_departement"));
                liste.add(d);
            }

            lrs.close();
            lpst.close();

        } catch (SQLException e) {
            d = new Departement();
            d.setIdDepartement(-1);
            d.setCodeDepartement(e.getMessage());
            d.setNomDepartement(e.getMessage());
            System.out.println(e.getMessage());
        }
        return liste;
    }/// update

} ///class
