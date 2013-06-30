/*
 * JReplaceList.java
 *
 * Created on 18 Ιούλιος 2005, 5:00 πμ
 *
 * This file is part of Jubler.
 *
 * Jubler is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 *
 * Jubler is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Jubler; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 *
 */

package com.panayotis.jubler.tools.replace;

import javax.swing.ListSelectionModel;

import static com.panayotis.jubler.i18n.I18N._;

/**
 *
 * @author teras
 */
public class JReplaceList extends javax.swing.JPanel {

    ReplaceModel model;

    /**
     * Creates new form JReplaceList
     */
    public JReplaceList() {
        initComponents();
        model = new ReplaceModel();
        TTable.setModel(model);
        TTable.getColumnModel().getColumn(0).setMaxWidth(30);
        TTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        MarkAll = new javax.swing.JButton();
        ClearAll = new javax.swing.JButton();
        Inverse = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        DeleteMarked = new javax.swing.JButton();
        ResetValues = new javax.swing.JButton();
        LoadValues = new javax.swing.JButton();
        SaveValues = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(500, 200));
        jScrollPane1.setViewportView(TTable);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        MarkAll.setText(_("Select All"));
        MarkAll.setToolTipText(_("Use all above replacing scenarios"));
        MarkAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MarkAllActionPerformed(evt);
            }
        });
        jPanel1.add(MarkAll);

        ClearAll.setText(_("Clear All"));
        ClearAll.setToolTipText(_("Use none of the above replacing scenarios"));
        ClearAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearAllActionPerformed(evt);
            }
        });
        jPanel1.add(ClearAll);

        Inverse.setText(_("Inverse"));
        Inverse.setToolTipText(_("Inverse the selection of the scenarios above"));
        Inverse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InverseActionPerformed(evt);
            }
        });
        jPanel1.add(Inverse);
        jPanel1.add(jSeparator1);

        DeleteMarked.setText(_("Delete"));
        DeleteMarked.setToolTipText(_("Delete the selected scenario"));
        DeleteMarked.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteMarkedActionPerformed(evt);
            }
        });
        jPanel1.add(DeleteMarked);

        ResetValues.setText(_("Delete"));
        ResetValues.setToolTipText(_("Delete the selected scenario"));
        ResetValues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetValuesActionPerformed(evt);
            }
        });
        jPanel1.add(ResetValues);

        LoadValues.setText(_("Delete"));
        LoadValues.setToolTipText(_("Delete the selected scenario"));
        LoadValues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadValuesActionPerformed(evt);
            }
        });
        jPanel1.add(LoadValues);

        SaveValues.setText(_("Delete"));
        SaveValues.setToolTipText(_("Delete the selected scenario"));
        SaveValues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveValuesActionPerformed(evt);
            }
        });
        jPanel1.add(SaveValues);

        add(jPanel1, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents

    private void DeleteMarkedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteMarkedActionPerformed
        model.remove(TTable.getSelectedRow());
    }//GEN-LAST:event_DeleteMarkedActionPerformed

    private void InverseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InverseActionPerformed
        for (int i = 0; i < (model.size() - 1); i++)
            model.elementAt(i).usable = !model.elementAt(i).usable;
        model.fireTableDataChanged();
    }//GEN-LAST:event_InverseActionPerformed

    private void ClearAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearAllActionPerformed
        for (int i = 0; i < (model.size() - 1); i++)
            model.elementAt(i).usable = false;
        model.fireTableDataChanged();
    }//GEN-LAST:event_ClearAllActionPerformed

    private void MarkAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MarkAllActionPerformed
        for (int i = 0; i < (model.size() - 1); i++)
            model.elementAt(i).usable = true;
        model.fireTableDataChanged();
    }//GEN-LAST:event_MarkAllActionPerformed

    private void ResetValuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetValuesActionPerformed
        model.reset();
    }//GEN-LAST:event_ResetValuesActionPerformed

    private void LoadValuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadValuesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoadValuesActionPerformed

    private void SaveValuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveValuesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SaveValuesActionPerformed

    public ReplaceModel getModel() {
        return model;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ClearAll;
    private javax.swing.JButton DeleteMarked;
    private javax.swing.JButton Inverse;
    private javax.swing.JButton LoadValues;
    private javax.swing.JButton MarkAll;
    private javax.swing.JButton ResetValues;
    private javax.swing.JButton SaveValues;
    private javax.swing.JTable TTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
