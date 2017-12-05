/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;


/**
 *
 * @author allth
 */
public class DepartementTests {
    public static void main (String[] args){
    Departement d75 = new Departement (1,"75","Scène");
        System.out.println(d75);
        
        d75.setNomDepartement("Seine");
        System.out.println(d75.getNomDepartement());
    
    }
}
