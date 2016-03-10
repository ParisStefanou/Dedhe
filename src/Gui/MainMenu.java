/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import DB_connection.DBConnection;
import DB_data_loader.StoreDatatoDB;
import panels.ErrorPopup;

/**
 *
 * @author Paris
 */
public class MainMenu extends javax.swing.JFrame {

    /**
     * Creates new form MainWindows
     */
    DBConnection dbconn;
    public static boolean debug = false;

    public MainMenu(DBConnection dbconn) {
        this.dbconn=dbconn;
        initComponents();
        setVisible(true);
        setSize(320, 350);
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        QueryButton = new javax.swing.JButton();
        ErrorArea = new java.awt.TextArea();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jPasswordField1.setText("jPasswordField1");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        QueryButton.setText("SQL Queries");
        QueryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QueryButtonActionPerformed(evt);
            }
        });
        getContentPane().add(QueryButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 130, -1));
        getContentPane().add(ErrorArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 114, 243, 182));

        jLabel6.setText("Error Window");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 86, -1, -1));

        jButton3.setText("Load data from Excel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 180, 30));

        jButton4.setText("analytics");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 130, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        if(StoreDatatoDB.readonly==false){
        new Thread() {

            @Override
            public void run() {

                LoadExcelDataGui a = new LoadExcelDataGui(dbconn);
                a.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                a.setVisible(true);

            }

        }.start();}
        else
            ErrorPopup.popup("Database is opened in read only mode for speed.\n For writing open the read and write mode");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new Thread() {

            @Override
            public void run() {

                AnalyticsGui a = new AnalyticsGui(dbconn);
                a.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                a.setVisible(true);

            }

        }.start();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void QueryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QueryButtonActionPerformed
        new Thread() {

            @Override
            public void run() {
                QueryFrame a = new QueryFrame(dbconn);
                a.setVisible(true);

            }

        }.start();
    }//GEN-LAST:event_QueryButtonActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static java.awt.TextArea ErrorArea;
    private javax.swing.JButton QueryButton;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
