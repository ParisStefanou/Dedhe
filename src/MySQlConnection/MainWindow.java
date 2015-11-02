/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MySQlConnection;

import Gui.AnalyticsGui;
import Gui.PowerLineData;
import com.mysql.jdbc.PreparedStatement;
import dedheproject.ExcelSheetOpener;
import dedheproject.Fileopener;
import dedheproject.exceptions.BadDateInputException;
import dedheproject.exceptions.BadTimeInputException;
import dedheproject.exceptions.CouldntConnectException;
import dedheproject.exceptions.NoSuchSheetException;
import dedheproject.exceptions.badfileexception;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Paris
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form MainWindows
     */
    Connection conn = null;
    public static boolean debug = false;

    public MainWindow() {
        initComponents();
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
        QueryButton = new javax.swing.JButton();
        ErrorArea = new java.awt.TextArea();
        AdressBox = new javax.swing.JTextField();
        DBNameBox = new javax.swing.JTextField();
        UsernameBox = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        PasswordBox = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        QueryButton.setText("Queries");
        QueryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QueryButtonActionPerformed(evt);
            }
        });
        getContentPane().add(QueryButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 52, 125, -1));
        getContentPane().add(ErrorArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 114, 243, 182));

        AdressBox.setText("localhost");
        getContentPane().add(AdressBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 114, 130, -1));

        DBNameBox.setText("mydb");
        getContentPane().add(DBNameBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 166, 130, -1));

        UsernameBox.setText("root");
        getContentPane().add(UsernameBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 192, 130, -1));

        jLabel1.setText("Adress");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 117, 60, -1));

        jLabel3.setText("DB Name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 169, 70, -1));

        jLabel4.setText("Username");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 195, 60, -1));

        jLabel5.setText("Password");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 221, 60, -1));
        getContentPane().add(PasswordBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 218, 130, -1));

        jLabel6.setText("Error Window");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 86, -1, -1));

        jButton1.setText("Excel to DB");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 120, -1));

        jButton2.setText("connect to db");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, -1, -1));

        jButton3.setText("PowerLine Data");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 140, -1));

        jButton4.setText("analytics");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 130, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void QueryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QueryButtonActionPerformed
        new Thread() {

            @Override
            public void run() {
                QueryFrame a = new QueryFrame(conn);
                a.setVisible(true);

            }

        }.start();
    }//GEN-LAST:event_QueryButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            File f = Fileopener.openfile();
            try {
                int rows_to_read = 2024;
                int colums_to_read = 2;
                int start_y = 1;
                int start_x = 1;
                ExcelSheetOpener sheet1 = new ExcelSheetOpener(1, start_x, start_y, colums_to_read, rows_to_read, f);
                int errors = 0;
                try {
                    MyConnection.disablekeys("powerlinedata", conn);
                    PreparedStatement pstmt = null;
                    for (int i = 0; i < rows_to_read; i++) {
                        try {
                            String query = " INSERT IGNORE INTO powerlinedata VALUES (" + "'" + FixValues.reversedate(sheet1.data[i][0], '/', ':') + "'" + "," + 1 + "," + 1 + "," + 1 + "," + sheet1.data[i][1].replace(',', '.') + ");\n";

                            if (debug) {
                                System.out.println(query);
                            }

                            pstmt = (PreparedStatement) conn.prepareStatement(query);
                            pstmt.execute();

                        } catch (BadDateInputException ex) {
                            System.out.println("Bad date format in Excel at row : " + i);
                        } catch (BadTimeInputException ex) {
                            System.out.println("Bad time format in Excel at row : " + i);
                        }

                    }

                    MyConnection.enablekeys("powerlinedata", conn);
                    System.out.println("query finished errors: " + errors);
                } catch (SQLException ex) {
                    try {
                        MyConnection.enablekeys("powerlinedata", conn);
                    } catch (SQLException ex1) {
                        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                    System.out.println("bad query");
                    System.out.println(ex.getMessage());
                }
            } catch (FileNotFoundException ex) {
                System.out.println("file was not found");
            } catch (NoSuchSheetException ex) {
                System.out.println("no such sheet");
            }

        } catch (badfileexception ex) {
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            conn = MyConnection.connect();
            System.out.println("success");
        } catch (CouldntConnectException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("failure");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new Thread() {

            @Override
            public void run() {

                PowerLineData a = new PowerLineData(conn);
                a.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                a.setVisible(true);

            }

        }.start();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new Thread() {

            @Override
            public void run() {

                AnalyticsGui a = new AnalyticsGui(conn);
                a.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                a.setVisible(true);

            }

        }.start();
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField AdressBox;
    public static javax.swing.JTextField DBNameBox;
    public static java.awt.TextArea ErrorArea;
    public static javax.swing.JPasswordField PasswordBox;
    private javax.swing.JButton QueryButton;
    public static javax.swing.JTextField UsernameBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField jPasswordField1;
    // End of variables declaration//GEN-END:variables
}
