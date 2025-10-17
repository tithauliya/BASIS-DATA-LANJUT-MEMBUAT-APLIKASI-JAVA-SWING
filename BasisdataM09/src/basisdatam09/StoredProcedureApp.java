/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package basisdatam09;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class StoredProcedureApp extends javax.swing.JFrame {

    private JTextField txtAkunId;
    private JTextField txtJumlah;
    private JTextField txtPengirimId;
    private JTextField txtPenerimaId;
    private JButton btnTambahSaldo;
    private JButton btnKurangiSaldo;
    private JButton btnTransferSaldo;
    private JTextField txtJumlahTransfer;
    private JTextArea txtResult;

    public StoredProcedureApp() {
        setTitle("Aplikasi Manajemen Transaksi");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel lblAkunId = new JLabel("ID Akun:");
        lblAkunId.setBounds(20, 20, 100, 25);
        panel.add(lblAkunId);
        txtAkunId = new JTextField();
        txtAkunId.setBounds(150, 20, 200, 25);
        panel.add(txtAkunId);
        JLabel lblJumlah = new JLabel("Jumlah:");
        lblJumlah.setBounds(20, 60, 100, 25);
        panel.add(lblJumlah);
        txtJumlah = new JTextField();
        txtJumlah.setBounds(150, 60, 200, 25);
        panel.add(txtJumlah);
        btnTambahSaldo = new JButton("Tambah Saldo");
        btnTambahSaldo.setBounds(50, 100, 150, 30);
        panel.add(btnTambahSaldo);
        btnKurangiSaldo = new JButton("Kurangi Saldo");
        btnKurangiSaldo.setBounds(210, 100, 150, 30);
        panel.add(btnKurangiSaldo);
        JLabel lblPengirimId = new JLabel("ID Pengirim:");
        lblPengirimId.setBounds(20, 150, 100, 25);
        panel.add(lblPengirimId);
        txtPengirimId = new JTextField();
        txtPengirimId.setBounds(150, 150, 200, 25);
        panel.add(txtPengirimId);
        JLabel lblPenerimaId = new JLabel("ID Penerima:");
        lblPenerimaId.setBounds(20, 190, 100, 25);
        panel.add(lblPenerimaId);
        txtPenerimaId = new JTextField();
        txtPenerimaId.setBounds(150, 190, 200, 25);
        JLabel lblJumlahTransfer = new JLabel ("Jumlah");
        lblJumlahTransfer.setBounds (20, 230, 100, 25);
        panel.add (lblJumlahTransfer);
        panel.add (txtPenerimaId);
        txtJumlahTransfer = new JTextField();
        txtJumlahTransfer.setBounds (150, 230, 200, 25);
        panel.add(txtJumlahTransfer);
        panel.add(txtPenerimaId);
        btnTransferSaldo = new JButton("Transfer Saldo");
        btnTransferSaldo.setBounds(130, 270, 150, 30);
        panel.add(btnTransferSaldo);
        txtResult = new JTextArea();
        txtResult.setBounds(20, 310, 350, 70);
        txtResult.setEditable(false);
        panel.add(txtResult);

        // Action Listener untuk Tambah Saldo
        btnTambahSaldo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int akunId = Integer.parseInt(txtAkunId.getText());
                double jumlah = Double.parseDouble(txtJumlah.getText());
                try {
                    tambahSaldo(akunId, jumlah);
                    txtResult.setText("Saldo berhasil ditambahkan.");
                } catch (SQLException ex) {

                    txtResult.setText("Error: " + ex.getMessage());
                }
            }
        });

        // Action Listener untuk Kurangi Saldo
        btnKurangiSaldo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int akunId = Integer.parseInt(txtAkunId.getText());
                double jumlah = Double.parseDouble(txtJumlah.getText());
                try {
                    kurangiSaldo(akunId, jumlah);
                    txtResult.setText("Saldo berhasil dikurangi.");
                } catch (SQLException ex) {
                    txtResult.setText("Error: " + ex.getMessage());
                }
            }
        });

        btnTransferSaldo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int pengirimId = Integer.parseInt(txtPengirimId.getText());
                int penerimaId = Integer.parseInt(txtPenerimaId.getText());
                double jumlah = Double.parseDouble(txtJumlahTransfer.getText());
                try {
                    transferSaldo(pengirimId, penerimaId, jumlah);
                    txtResult.setText("Transfer saldo berhasil.");
                } catch (SQLException ex) {
                    txtResult.setText("Error: " + ex.getMessage());
                }
            }
        });
        add(panel);
   }

    public void tambahSaldo(int id, double jumlah) throws SQLException {
        Connection conn = DBConection.getConnection();
        CallableStatement stmt = conn.prepareCall("call tambah_saldo(?, ?)");
        stmt.setInt(1, id);
        stmt.setDouble(2, jumlah);
        stmt.execute();
        conn.close();
    }
// Metode untuk memanggil prosedur kurangi saldo

    public void kurangiSaldo(int id, double jumlah) throws SQLException {
        Connection conn = DBConection.getConnection();
        CallableStatement stmt = conn.prepareCall("call kurangi_saldo(?, ?)");
        stmt.setInt(1, id);
        stmt.setDouble(2, jumlah);
        stmt.execute();
        conn.close();
    }
// Metode untuk memanggil prosedur transfer saldo

    public void transferSaldo(int pengirimId, int penerimaId, double jumlah) throws SQLException {
        Connection conn = DBConection.getConnection();
        CallableStatement stmt = conn.prepareCall("call transfer_saldo(?, ?, ?)");

        stmt.setInt(1, pengirimId);
        stmt.setInt(2, penerimaId);
        stmt.setDouble(3, jumlah);
        stmt.execute();
        conn.close();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(StoredProcedureApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StoredProcedureApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StoredProcedureApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StoredProcedureApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StoredProcedureApp().setVisible(true);
            }
        });
        /* Create and display the form */
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
