/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI_UAS;

import com.toedter.calendar.JDateChooser;
import java.sql.PreparedStatement; 
import java.sql.ResultSet;  
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import javax.swing.table.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.sql.SQLException;



/**
 *
 * @author mmccom
 */
public class UAS_GUI extends javax.swing.JFrame {
    /**
     * Creates new form UAS_GUI
     */
    public UAS_GUI() {
        initComponents();
        this.setTitle("Daily Agenda");
        this.setLocationRelativeTo(this);
        
        Konektor koneksi = new Konektor();
        koneksi.konektor();
        this.StatusKoneksi.setText(koneksi.statusKoneksi);  
        table();
    }        
    
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    PreparedStatement pst; 
ResultSet rs;

public void table() {

  Konektor koneksi = new Konektor();
  koneksi.konektor();

  try {
    String sql = "select * from output_agenda";  
    pst = koneksi.con.prepareStatement(sql);

    rs = pst.executeQuery(); // execute pakai pst

    tabelAgenda.setModel(DbUtils.resultSetToTableModel(rs));  

  } catch (Exception e) {
    JOptionPane.showMessageDialog(null, e);  
  }
} 


    public void selectByNomor(int nomor) {
         Konektor koneksi = new Konektor();
         koneksi.konektor();

        try {

            String sql = "select * from output_agenda where Nomor like '%" + nomor + "%'";
            pst = koneksi.con.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            tabelAgenda.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void selectByNama(String namaAgenda) {
         Konektor koneksi = new Konektor();
           koneksi.konektor();

        try {

            String sql = "select * from output_Agenda where Nama_Agenda like '%" + namaAgenda + "%'";
            pst = koneksi.con.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            tabelAgenda.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void selectByLokasi(String lokasiAgenda) {
         Konektor koneksi = new Konektor();
            koneksi.konektor();

        try {

            String sql = "select * from output_agenda where Lokasi_Agenda like '%" + lokasiAgenda + "%'";
            pst = koneksi.con.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            tabelAgenda.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void selectByHari(String hari) {

  Konektor koneksi = new Konektor();

  koneksi.konektor();

  try {

    String sql = "SELECT * FROM output_agenda WHERE Hari = ?";

    pst = koneksi.con.prepareStatement(sql);

    pst.setString(1, hari);

    rs = pst.executeQuery();

    tabelAgenda.setModel(DbUtils.resultSetToTableModel(rs));

  } catch (Exception e) {

    JOptionPane.showMessageDialog(null, e);

  }

}
    
    public void selectByTanggal(Date tanggal) {
         Konektor koneksi = new Konektor();
            koneksi.konektor();

        try {

          String sql = "SELECT * FROM output_agenda WHERE Tanggal = '" + tanggal + "'";
            pst = koneksi.con.prepareStatement(sql);
            pst.setDate(1, new java.sql.Date(tanggal.getTime()));
            rs = pst.executeQuery(sql);
            tabelAgenda.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
      JOptionPane.showMessageDialog(null, e.getMessage());
}
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        inNomor = new javax.swing.JTextField();
        inNama = new javax.swing.JTextField();
        inLokasi = new javax.swing.JTextField();
        inInsert = new javax.swing.JButton();
        inDelete = new javax.swing.JButton();
        inUpdate = new javax.swing.JButton();
        inReset = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        StatusKoneksi = new javax.swing.JTextField();
        inCari = new javax.swing.JButton();
        pilihPencarian = new javax.swing.JComboBox<>();
        inHari = new javax.swing.JComboBox<>();
        inTanggal = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelAgenda = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTabbedPane1.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Castellar", 0, 48)); // NOI18N
        jLabel1.setText("DAILY AGENDA");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel1)
                .addContainerGap(149, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Input", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 0, 12))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jLabel2.setText("Nomor                   :");

        jLabel3.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jLabel3.setText("Nama Agenda     :");

        jLabel4.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jLabel4.setText("Lokasi Agenda     :");

        jLabel5.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jLabel5.setText("Hari                        :");

        jLabel6.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jLabel6.setText("Tanggal                 :");

        inNomor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inNomorActionPerformed(evt);
            }
        });

        inInsert.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        inInsert.setText("Insert");
        inInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inInsertActionPerformed(evt);
            }
        });

        inDelete.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        inDelete.setText("Delete");
        inDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inDeleteActionPerformed(evt);
            }
        });

        inUpdate.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        inUpdate.setText("Update");
        inUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inUpdateActionPerformed(evt);
            }
        });

        inReset.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        inReset.setText("Reset");
        inReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inResetActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jLabel7.setText("Status Koneksi      :");

        inCari.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        inCari.setText("CARI");
        inCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inCariActionPerformed(evt);
            }
        });

        pilihPencarian.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        pilihPencarian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih Pencarian -", "Nomor", "Nama_Agenda", "Lokasi_Agenda", "Hari", "Tanggal" }));
        pilihPencarian.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                pilihPencarianItemStateChanged(evt);
            }
        });
        pilihPencarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihPencarianActionPerformed(evt);
            }
        });

        inHari.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        inHari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Pilih Hari-", "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu", " " }));
        inHari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inHariActionPerformed(evt);
            }
        });

        inTanggal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                inTanggalPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inLokasi, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inHari, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inNomor, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inNama, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(StatusKoneksi, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(inCari)
                                        .addGap(61, 61, 61)
                                        .addComponent(pilihPencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(inInsert)
                                        .addGap(44, 44, 44)
                                        .addComponent(inDelete)
                                        .addGap(60, 60, 60)
                                        .addComponent(inUpdate)))
                                .addGap(59, 59, 59)
                                .addComponent(inReset)))))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(inNomor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(inNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inLokasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inHari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(inTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StatusKoneksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inCari)
                    .addComponent(pilihPencarian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inInsert)
                    .addComponent(inDelete)
                    .addComponent(inUpdate)
                    .addComponent(inReset))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Input Agenda", jPanel1);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tabel Output", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 0, 12))); // NOI18N

        tabelAgenda.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        tabelAgenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nomor", "Nama_|Agenda", "Lokasi_Agenda", "Hari", "Tanggal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabelAgenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelAgendaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelAgenda);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Output Agenda", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inNomorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inNomorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inNomorActionPerformed

    private void inUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inUpdateActionPerformed
        // TODO add your handling code here:
        
        Konektor koneksi = new Konektor();
        koneksi.konektor();
        Update up = new Update();
        int nomor = Integer.parseInt(inNomor.getText());
        String namaAgenda = inNama.getText();
        String lokasiAgenda = inLokasi.getText();
        String hari = "";
         if (inHari.getSelectedIndex() == 1) {
            hari = "Senin";
        } else if (inHari.getSelectedIndex() == 2) {
            hari = "Selasa";
        } else if (inHari.getSelectedIndex() == 3) {
            hari = "Rabu";
        } else if (inHari.getSelectedIndex() == 4) {
            hari = "Kamis";
        } else if (inHari.getSelectedIndex() == 5) {
            hari = "Jumat";
        } else if (inHari.getSelectedIndex() == 6) {
            hari = "Sabtu";
        } else if (inHari.getSelectedIndex() == 7) {
            hari = "Minggu";
        } else {
            return; 
        }
        Date selectedDate = inTanggal.getDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal = dateFormat.format(inTanggal.getDate());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = inTanggal.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();  
        String dateString = date.format(formatter);


        up.update(nomor, namaAgenda, lokasiAgenda, hari, tanggal);
        table();
        
    }//GEN-LAST:event_inUpdateActionPerformed

    private void inInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inInsertActionPerformed
        // TODO add your handling code here:
        insert in = new insert();
        
        int nomor = Integer.parseInt(inNomor.getText());
        String namaAgenda = inNama.getText();
        String lokasiAgenda = inLokasi.getText();
        String hari = "";
         if (inHari.getSelectedIndex() == 1) {
            hari = "Senin";
        } else if (inHari.getSelectedIndex() == 2) {
            hari = "Selasa";
        } else if (inHari.getSelectedIndex() == 3) {
            hari = "Rabu";
        } else if (inHari.getSelectedIndex() == 4) {
            hari = "Kamis";
        } else if (inHari.getSelectedIndex() == 5) {
            hari = "Jumat";
        } else if (inHari.getSelectedIndex() == 6) {
            hari = "Sabtu";
        } else if (inHari.getSelectedIndex() == 7) {
            hari = "Minggu";
        } else {
            return; 
        }
        Date selectedDate = inTanggal.getDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal = dateFormat.format(inTanggal.getDate());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = inTanggal.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();  
        String dateString = date.format(formatter);
        
        in.insert(nomor, namaAgenda, lokasiAgenda, hari, tanggal);
        
        table();
    }//GEN-LAST:event_inInsertActionPerformed

    private void tabelAgendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelAgendaMouseClicked
        // TODO add your handling code here:
        
         DefaultTableModel dtm = (DefaultTableModel) tabelAgenda.getModel(); //create a model
    int selectedRowIndex = tabelAgenda.getSelectedRow(); //get selected row
    int id = (int) dtm.getValueAt(selectedRowIndex, 0); //get the primary key to fetch data.
    
    Konektor koneksi = new Konektor();
        koneksi.konektor();
    
    try {
        
        String sql = "select * from output_agenda where Nomor like '%" + id + "%'";
            pst = koneksi.con.prepareStatement(sql);
            
        ResultSet rs = rs = pst.executeQuery(sql);
        while(rs.next()){    //u can use normal query
            
            inNomor.setText(rs.getString("Nomor"));
            inNama.setText(rs.getString("Nama_Agenda"));
            inLokasi.setText(rs.getString("Lokasi_Agenda"));
            inHari.setToolTipText(rs.getCursorName());
            inTanggal.setDate(rs.getDate("Tanggal"));
            
            
        }
    } catch (Exception ex) {
    }
        
    }//GEN-LAST:event_tabelAgendaMouseClicked

    private void inDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inDeleteActionPerformed
        // TODO add your handling code here:
        
         Konektor koneksi = new Konektor();
        koneksi.konektor();
        Delete del = new Delete();
        del.delete(Integer.parseInt(inNomor.getText()));
        
        table();
        
    }//GEN-LAST:event_inDeleteActionPerformed

    private void inResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inResetActionPerformed
        // TODO add your handling code here:
        
        inNama.setText("");
        inNomor.setText("");
        inLokasi.setText("");
        inHari.getSelectedItem().toString();
        inTanggal.setDate(null);
       
       
    }//GEN-LAST:event_inResetActionPerformed

    private void pilihPencarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihPencarianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pilihPencarianActionPerformed

    private void inCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inCariActionPerformed
        // TODO add your handling code here:B
        
         if (pilihPencarian.getSelectedIndex() == 1) {
            selectByNomor(Integer.parseInt(inNomor.getText()));
        } else if (pilihPencarian.getSelectedIndex() == 2) {
            selectByNama(inNama.getText());
        } else if (pilihPencarian.getSelectedIndex() == 3) {
            selectByLokasi(inLokasi.getText());
        } else if (pilihPencarian.getSelectedIndex() == 4) {
            selectByHari(inHari.getToolTipText());
        } else if (pilihPencarian.getSelectedIndex() == 5) {
            selectByTanggal(inTanggal.getDate());
        } else {
            table();
        }

        
    }//GEN-LAST:event_inCariActionPerformed

    private void pilihPencarianItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_pilihPencarianItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_pilihPencarianItemStateChanged

    private void inHariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inHariActionPerformed
        // TODO add your handling code here:
        String hari = ""; 
        if (inHari.getSelectedIndex() == 1) {
            hari = "Senin";
        } else if (inHari.getSelectedIndex() == 2) {
            hari = "Selasa";
        } else if (inHari.getSelectedIndex() == 3) {
            hari = "Rabu";
        } else if (inHari.getSelectedIndex() == 4) {
            hari = "Kamis";
        } else if (inHari.getSelectedIndex() == 5) {
            hari = "Jumat";
        } else if (inHari.getSelectedIndex() == 6) {
            hari = "Sabtu";
        } else if (inHari.getSelectedIndex() == 7) {
            hari = "Minggu";
        } else {
            return;
        }
    }//GEN-LAST:event_inHariActionPerformed

    private void inTanggalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_inTanggalPropertyChange
        // TODO add your handling code here;
        
    }//GEN-LAST:event_inTanggalPropertyChange

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
            java.util.logging.Logger.getLogger(UAS_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UAS_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UAS_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UAS_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UAS_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField StatusKoneksi;
    private javax.swing.JButton inCari;
    private javax.swing.JButton inDelete;
    private javax.swing.JComboBox<String> inHari;
    private javax.swing.JButton inInsert;
    private javax.swing.JTextField inLokasi;
    private javax.swing.JTextField inNama;
    private javax.swing.JTextField inNomor;
    private javax.swing.JButton inReset;
    private com.toedter.calendar.JDateChooser inTanggal;
    private javax.swing.JButton inUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> pilihPencarian;
    private javax.swing.JTable tabelAgenda;
    // End of variables declaration//GEN-END:variables
}
