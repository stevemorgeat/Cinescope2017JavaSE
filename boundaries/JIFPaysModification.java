/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundaries;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author allth
 */
public class JIFPaysModification extends javax.swing.JInternalFrame {
    
    private Connection icn;
    private DefaultComboBoxModel idcbm;
    private Map<String, String> mapPays;

    /**
     * Creates new form JIFPaysAjout
     */
    public JIFPaysModification() {
        initComponents();
        setVisible(true);
        
        try {
            // --- Connexion
            //Class.forName("org.gjt.mm.mysql.Driver");
            String lsDSN = "jdbc:mysql://127.0.0.1:3306/cinescope2017";
            icn = DriverManager.getConnection(lsDSN, "root", "");
            
            Statement lstSQL = icn.createStatement();
            ResultSet lrs = lstSQL.executeQuery("SELECT id_pays, NOM_pays FROM pays ORDER BY 2");
            
            mapPays = new HashMap();
            
            idcbm = new DefaultComboBoxModel();
            while (lrs.next()) {
                //jComboBoxPays.addItem(lrs.getString(1));
                idcbm.addElement(lrs.getString("NOM_pays"));
                mapPays.put(lrs.getString("NOM_pays"), lrs.getString("id_pays"));
            }
            jComboBoxModifPays.setModel(idcbm);
            
            lrs.close();
            lstSQL.close();
            
            jLabelMessage.setText("Okay !!!");
            
        } catch (SQLException ex) {
            jLabelMessage.setText(ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelComboBox = new javax.swing.JLabel();
        jComboBoxModifPays = new javax.swing.JComboBox();
        jLabelId = new javax.swing.JLabel();
        jTextFieldModifId = new javax.swing.JTextField();
        jTextFieldModifNomPays = new javax.swing.JTextField();
        jTextFieldModifMasculinPays = new javax.swing.JTextField();
        jTextFieldModifFemininPays = new javax.swing.JTextField();
        jTextFieldModifNeutrePays = new javax.swing.JTextField();
        jLabelNomPays = new javax.swing.JLabel();
        jLabelMasculin = new javax.swing.JLabel();
        jLabelFeminin = new javax.swing.JLabel();
        jLabelNeutre = new javax.swing.JLabel();
        jLabelMessage = new javax.swing.JLabel();
        jButtonPaysModifier = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Modification Pays");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jLabelComboBox.setText("Pays à modifier :");

        jComboBoxModifPays.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxModifPaysItemStateChanged(evt);
            }
        });

        jLabelId.setText("Id :");

        jTextFieldModifId.setEditable(false);
        jTextFieldModifId.setText("id");

        jTextFieldModifNomPays.setText("NomPays");

        jTextFieldModifMasculinPays.setText("MasculinPays");

        jTextFieldModifFemininPays.setText("FemininPays");

        jTextFieldModifNeutrePays.setText("NeutrePays");

        jLabelNomPays.setText("Nom du pays :");

        jLabelMasculin.setText("Masculin :");

        jLabelFeminin.setText("Féminin :");

        jLabelNeutre.setText("Neutre :");

        jLabelMessage.setText("Message");

        jButtonPaysModifier.setText("Modifier");
        jButtonPaysModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPaysModifierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonPaysModifier))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelId)
                            .addComponent(jLabelComboBox))
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxModifPays, 0, 116, Short.MAX_VALUE)
                            .addComponent(jTextFieldModifId)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelNeutre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldModifNeutrePays, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelFeminin)
                            .addComponent(jLabelMasculin))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldModifMasculinPays, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldModifFemininPays, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabelNomPays)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldModifNomPays, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(93, 93, 93))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelComboBox)
                    .addComponent(jComboBoxModifPays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelId)
                    .addComponent(jTextFieldModifId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldModifNomPays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNomPays))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldModifMasculinPays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMasculin))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldModifFemininPays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFeminin))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldModifNeutrePays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNeutre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelMessage, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonPaysModifier, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxModifPaysItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxModifPaysItemStateChanged
        // TODO add your handling code here:

        System.out.println("Bonjour");
        try {
            // --- Connexion
//            String lsDSN = "jdbc:mysql://127.0.0.1:3306/cinescope2017";
//            Connection icn = DriverManager.getConnection(lsDSN, "root", "");

            // --- SELECT
            String lsSQL = "SELECT * FROM pays WHERE NOM_pays = ?";

            // --- Creation de l'objet "commande SQL"
            PreparedStatement lpst = icn.prepareStatement(lsSQL);

            // --- Valorisation du ou des parametre(s)
            // --- Les valeurs pourraient etre saisies au clavier
            lpst.setString(1, jComboBoxModifPays.getSelectedItem().toString());

            // --- Execution de la requete
            ResultSet lrs = lpst.executeQuery();
            if (lrs.next()) {
                System.out.println("ok");
                jTextFieldModifId.setText(lrs.getString(1));
                jTextFieldModifNomPays.setText(lrs.getString(2));
                jTextFieldModifMasculinPays.setText(lrs.getString(3));
                jTextFieldModifFemininPays.setText(lrs.getString(4));
                jTextFieldModifNeutrePays.setText(lrs.getString(5));
            } else {
                System.out.println("Aucun résultat!!!");
            }
            
            lrs.close();
            lpst.close();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        

    }//GEN-LAST:event_jComboBoxModifPaysItemStateChanged

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // TODO add your handling code here:
        try {
            icn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_formInternalFrameClosing

    private void jButtonPaysModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPaysModifierActionPerformed
        // TODO add your handling code here:
        
        PreparedStatement lpst;
        String lsUpdate = "UPDATE pays SET nom_pays = ?, masculin = ?, feminin = ?, neutre = ? WHERE id_pays = ?";
        String lsNomPays = jTextFieldModifNomPays.getText().toString();
        String lsMasculin = jTextFieldModifMasculinPays.getText().toString();
        String lsFeminin = jTextFieldModifFemininPays.getText().toString();
        String lsNeutre = jTextFieldModifNeutrePays.getText().toString();
        String lsId = jTextFieldModifId.getText().toString();
        
        try {
            lpst = icn.prepareStatement(lsUpdate);
            
            lpst.setString(1, lsNomPays);
            lpst.setString(2, lsMasculin);
            lpst.setString(3, lsFeminin);
            lpst.setString(4, lsNeutre);
            lpst.setString(5, lsId);
            
            lpst.executeUpdate();
            jLabelMessage.setText("Le pays " + jTextFieldModifNomPays + " a bien été modifié.");
            
        } catch (SQLException ex) {
            jLabelMessage.setText(ex.getMessage());
        }
        
    }//GEN-LAST:event_jButtonPaysModifierActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonPaysModifier;
    private javax.swing.JComboBox jComboBoxModifPays;
    private javax.swing.JLabel jLabelComboBox;
    private javax.swing.JLabel jLabelFeminin;
    private javax.swing.JLabel jLabelId;
    private javax.swing.JLabel jLabelMasculin;
    private javax.swing.JLabel jLabelMessage;
    private javax.swing.JLabel jLabelNeutre;
    private javax.swing.JLabel jLabelNomPays;
    private javax.swing.JTextField jTextFieldModifFemininPays;
    private javax.swing.JTextField jTextFieldModifId;
    private javax.swing.JTextField jTextFieldModifMasculinPays;
    private javax.swing.JTextField jTextFieldModifNeutrePays;
    private javax.swing.JTextField jTextFieldModifNomPays;
    // End of variables declaration//GEN-END:variables
}
