/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import MySQlConnection.FixValues;
import MySQlConnection.DBConnection;
import MySQlConnection.MainWindow;
import com.mysql.jdbc.PreparedStatement;
import dedheproject.ExcelSheetOpener;
import dedheproject.Fileopener;
import dedheproject.exceptions.BadDateInputException;
import dedheproject.exceptions.BadTimeInputException;
import dedheproject.exceptions.NoSuchSheetException;
import dedheproject.exceptions.ErrorPopup;
import dedheproject.exceptions.badfileexception;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Paris
 */
public class LoadExcelDataGui extends javax.swing.JFrame {

    /**
     * Creates new form LoadExcelDataGui
     */
    
    DBConnection dbconn;
    public LoadExcelDataGui(DBConnection dbconn) {
        this.dbconn = dbconn;
        initComponents();
        try {
            db_names_combobox.removeAllItems();
            rs = dbconn.execute_simple_query( "SELECT name,id FROM breaker; ");

            while (rs.next()) {
                db_names_combobox.addItem(rs.getObject(1));
            }
        } catch (SQLException ex) {
            ErrorPopup.popup(ex);
        }
        itemcount = (int) to_line_spinner.getValue() - (int) from_line_spinner.getValue();
    }
    File excelfile;
    ExcelSheetOpener sheet;
    ResultSet rs;
    int itemcount = 0;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        data_type_combobox = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sample_data_table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        load_temporary_data_button = new javax.swing.JButton();
        sheet_number_spinner = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        pass_data_to_DB_button = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        db_names_combobox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        from_line_spinner = new javax.swing.JSpinner();
        to_line_spinner = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        data_type_combobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Breaker", "Transformer" }));
        data_type_combobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                data_type_comboboxActionPerformed(evt);
            }
        });

        jPanel1.setLayout(new java.awt.BorderLayout());

        sample_data_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(sample_data_table);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jLabel1.setText("Sample Data");

        load_temporary_data_button.setText("Open File");
        load_temporary_data_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                load_temporary_data_buttonActionPerformed(evt);
            }
        });

        sheet_number_spinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sheet_number_spinnerStateChanged(evt);
            }
        });

        jLabel2.setText("Sheet Number");

        pass_data_to_DB_button.setText("Pass to DB");
        pass_data_to_DB_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pass_data_to_DB_buttonActionPerformed(evt);
            }
        });

        jLabel3.setText("Data Type");

        db_names_combobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                db_names_comboboxActionPerformed(evt);
            }
        });

        jLabel5.setText("In DB names");

        from_line_spinner.setValue(1);
        from_line_spinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                from_line_spinnerStateChanged(evt);
            }
        });

        to_line_spinner.setValue(11);
        to_line_spinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                to_line_spinnerStateChanged(evt);
            }
        });

        jLabel6.setText("from line");

        jLabel7.setText("to");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(data_type_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(load_temporary_data_button))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(db_names_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(sheet_number_spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pass_data_to_DB_button))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(from_line_spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(to_line_spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(load_temporary_data_button)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sheet_number_spinner, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(data_type_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(db_names_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(from_line_spinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(to_line_spinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pass_data_to_DB_button, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void load_temporary_data_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_load_temporary_data_buttonActionPerformed
        try {
            excelfile = Fileopener.openfile();

            if (excelfile == null) {
                return;
            }
            //int sheet_number, int start_x, int start_y, int columns_to_read, int rows_to_read, File excelfile
            int columncount = 3;
            sheet = new ExcelSheetOpener((int) sheet_number_spinner.getValue(), 0, (int) from_line_spinner.getValue(), columncount, 10, excelfile);
            String columnnames[] = new String[columncount];
            for (int i = 0; i < columncount; i++) {
                columnnames[i] = "";
            }
            DefaultTableModel dtb = new DefaultTableModel(sheet.data, columnnames);
            sample_data_table.setModel(dtb);
            revalidate();
        } catch (FileNotFoundException | NoSuchSheetException | badfileexception ex) {
            excelfile = null;
            ErrorPopup.popup(ex);
        }
    }//GEN-LAST:event_load_temporary_data_buttonActionPerformed

    private void pass_data_to_DB_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pass_data_to_DB_buttonActionPerformed

        if (data_type_combobox.getSelectedItem().toString().equals("Breaker")) {
            pass_data_to_breaker();
        }
        if (data_type_combobox.getSelectedItem().toString().equals("Transformer")) {
            pass_data_to_transformer();
        }

    }//GEN-LAST:event_pass_data_to_DB_buttonActionPerformed

    private void sheet_number_spinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sheet_number_spinnerStateChanged
        if ((int) sheet_number_spinner.getValue() < 0 || excelfile == null) {
            sheet_number_spinner.setValue(0);
        } else {
            try {
                int columncount = 3;
                sheet = new ExcelSheetOpener((int) sheet_number_spinner.getValue(), 0, (int) from_line_spinner.getValue(), columncount, 10, excelfile);

                if (sheet.data != null) {
                    String columnnames[] = new String[columncount];
                    for (int i = 0; i < columncount; i++) {
                        columnnames[i] = "";
                    }
                    DefaultTableModel dtb = new DefaultTableModel(sheet.data, columnnames);
                    sample_data_table.setModel(dtb);
                    revalidate();
                } else {
                    sheet_number_spinner.setValue((int) sheet_number_spinner.getValue() - 1);
                }
            } catch (FileNotFoundException | NoSuchSheetException ex) {
                excelfile = null;
                ErrorPopup.popup(ex);
            }
        }
    }//GEN-LAST:event_sheet_number_spinnerStateChanged

    private void data_type_comboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_data_type_comboboxActionPerformed
        if (data_type_combobox.getSelectedItem().toString().equals("Breaker")) {
            try {
                db_names_combobox.removeAllItems();
                rs = dbconn.execute_simple_query( "SELECT name,id FROM breaker; ");

                while (rs.next()) {
                    db_names_combobox.addItem(rs.getObject(1));
                }
            } catch (SQLException ex) {
                ErrorPopup.popup(ex);
            }
        }
        if (data_type_combobox.getSelectedItem().toString().equals("Transformer")) {
            try {
                db_names_combobox.removeAllItems();
                rs = dbconn.execute_simple_query( "SELECT name,id FROM transformer; ");

                while (rs.next()) {
                    db_names_combobox.addItem(rs.getObject(1));
                }
            } catch (SQLException ex) {
                ErrorPopup.popup(ex);
            }
        }

    }//GEN-LAST:event_data_type_comboboxActionPerformed

    private void from_line_spinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_from_line_spinnerStateChanged
        if ((int) from_line_spinner.getValue() > (int) to_line_spinner.getValue()) {
            from_line_spinner.setValue(to_line_spinner.getValue());
        }
        if ((int) from_line_spinner.getValue() < 1) {
            from_line_spinner.setValue(1);
        }

        itemcount = (int) to_line_spinner.getValue() - (int) from_line_spinner.getValue();
    }//GEN-LAST:event_from_line_spinnerStateChanged

    private void to_line_spinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_to_line_spinnerStateChanged
        if ((int) from_line_spinner.getValue() > (int) to_line_spinner.getValue()) {
            to_line_spinner.setValue(from_line_spinner.getValue());
        }

        itemcount = (int) to_line_spinner.getValue() - (int) from_line_spinner.getValue();        // TODO add your handling code here:
    }//GEN-LAST:event_to_line_spinnerStateChanged

    private void db_names_comboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_names_comboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_db_names_comboboxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox data_type_combobox;
    private javax.swing.JComboBox db_names_combobox;
    private javax.swing.JSpinner from_line_spinner;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton load_temporary_data_button;
    private javax.swing.JButton pass_data_to_DB_button;
    private javax.swing.JTable sample_data_table;
    private javax.swing.JSpinner sheet_number_spinner;
    private javax.swing.JSpinner to_line_spinner;
    // End of variables declaration//GEN-END:variables

    private void pass_data_to_breaker() {
        try {
            // to 1 sto x einai giati ta onomata einai axrista
            // to 1 sto y giati exoun balei kati columnname
            sheet = new ExcelSheetOpener((int) sheet_number_spinner.getValue(), 1, (int) from_line_spinner.getValue(), 2,
                    itemcount, excelfile);
        } catch (FileNotFoundException | NoSuchSheetException ex) {
            excelfile = null;
            ErrorPopup.popup(ex);
        }

        int errors = 0;
        try {
            dbconn.disablekeys("breaker_data");
            PreparedStatement pstmt = null;
            int selection = db_names_combobox.getSelectedIndex();
            rs.first();
            for (int k = 0; k < selection; k++) {
                rs.next();
            }
            int breakerid = rs.getInt(2);
            for (int i = 0; i < itemcount - 1; i++) {
                try {

                    String query = " INSERT IGNORE INTO breaker_data VALUES (" + "'" + FixValues.reversedate(sheet.data[i][0], '/', ':')
                            + "'" + "," + sheet.data[i][1].replace(',', '.')
                            + "," + breakerid + ");\n";

                    pstmt = (PreparedStatement) dbconn.conn.prepareStatement(query);
                    pstmt.execute();

                } catch (BadDateInputException ex) {
                    System.out.println("Bad date format in Excel at row : " + i);
                } catch (BadTimeInputException ex) {
                    System.out.println("Bad time format in Excel at row : " + i);
                }

            }

            dbconn.enablekeys("breaker_data");
            System.out.println("query finished errors: " + errors);
        } catch (SQLException ex) {
            try {
                dbconn.enablekeys("breaker_data");
            } catch (SQLException ex1) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex1);
            }
            System.out.println("bad query");
            System.out.println(ex.getMessage());
        }
    }

    private void pass_data_to_transformer() {

        try {
            // to 1 sto x einai giati ta onomata einai axrista
            // to 1 sto y giati exoun balei kati columnname
            sheet = new ExcelSheetOpener((int) sheet_number_spinner.getValue(), 1, (int) from_line_spinner.getValue(), 2,
                    itemcount, excelfile);
        } catch (FileNotFoundException | NoSuchSheetException ex) {
            excelfile = null;
            ErrorPopup.popup(ex);
        }

        int errors = 0;
        try {
            dbconn.disablekeys("transformer_data");
            PreparedStatement pstmt = null;
            int selection = db_names_combobox.getSelectedIndex();
            rs.first();
            for (int k = 0; k < selection; k++) {
                rs.next();
            }
            int breakerid = rs.getInt(2);
            for (int i = 0; i < itemcount; i++) {
                try {

                    String query = " INSERT IGNORE INTO transformer_data VALUES (" + "'" + FixValues.reversedate(sheet.data[i][0], '/', ':')
                            + "'" + "," + sheet.data[i][1].replace(',', '.')
                            + "," + breakerid + ");\n";

                    pstmt = (PreparedStatement) dbconn.conn.prepareStatement(query);
                    pstmt.execute();

                } catch (BadDateInputException ex) {
                    System.out.println("Bad date format in Excel at row : " + i);
                } catch (BadTimeInputException ex) {
                    System.out.println("Bad time format in Excel at row : " + i);
                }

            }

            dbconn.enablekeys("transformer_data");
            System.out.println("query finished errors: " + errors);
        } catch (SQLException ex) {
            try {
                dbconn.enablekeys("transformer_data");
            } catch (SQLException ex1) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex1);
            }
            System.out.println("bad query");
            System.out.println(ex.getMessage());
        }
    }
}
