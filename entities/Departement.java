/*
 * DTO Departement
 *
 *
 *
 */

package entities;

/**
 *
 * @author allth
 */
public class Departement {
    
    
    /**
     * Attributs
     */
    private int idDepartement;
    private String codeDepartement;
    private String nomDepartement;

    
    /**
     * les methodes contructor et getters and setters
     */
    public Departement() {
    }

    public Departement(String codeDepartement, String nomDepartement) {
        this.codeDepartement = codeDepartement;
        this.nomDepartement = nomDepartement;
    }
    
    

    public Departement(int idDepartement, String codeDepartement, String nomDepartement) {
        this.idDepartement = idDepartement;
        this.codeDepartement = codeDepartement;
        this.nomDepartement = nomDepartement;
    }

    public int getIdDepartement() {
        return idDepartement;
    }

    public void setIdDepartement(int idDepartement) {
        this.idDepartement = idDepartement;
    }

    public String getCodeDepartement() {
        return codeDepartement;
    }

    public void setCodeDepartement(String codeDepartement) {
        this.codeDepartement = codeDepartement;
    }

    public String getNomDepartement() {
        return nomDepartement;
    }

    public void setNomDepartement(String nomDepartement) {
        this.nomDepartement = nomDepartement;
    }

    @Override
    public String toString() {
        return "Departement{" + "idDepartement=" + idDepartement + ", codeDepartement=" + codeDepartement + ", nomDepartement=" + nomDepartement + '}';
    }
    
    
    
    
    
}
