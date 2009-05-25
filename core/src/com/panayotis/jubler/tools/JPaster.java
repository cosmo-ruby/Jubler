/*
 * JPaster.java
 *
 * Created on 6 Ιούλιος 2005, 4:05 μμ
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

package com.panayotis.jubler.tools;
import com.panayotis.jubler.subs.SubEntry;
import com.panayotis.jubler.time.Time;
import com.panayotis.jubler.time.gui.JTimeSpinner;
import java.awt.BorderLayout;

import static com.panayotis.jubler.i18n.I18N._;

/**
 *
 * @author  teras
 */
public class JPaster extends javax.swing.JPanel {
    private JTimeSpinner pastepos;
    
    
    /** Creates new form JPaster */
    public JPaster(Time t) {
        
        initComponents();
        for ( int i = 0 ; i < SubEntry.MarkNames.length ; i++ ) {
            ColSel.addItem(SubEntry.MarkNames[i]);
        }

        pastepos = new JTimeSpinner();
        pastepos.setValue(t);
        SpinP.add(pastepos, BorderLayout.CENTER);
    }
    
    public int getMark () {
        if ( !ChColor.isSelected()) return -1;
        return ColSel.getSelectedIndex();
    }
    
    public Time getStartTime() {
        return (Time)pastepos.getValue();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        SpinP = new javax.swing.JPanel();
        ChColor = new javax.swing.JCheckBox();
        ColSel = new javax.swing.JComboBox();

        setLayout(new java.awt.GridLayout(0, 1));

        jLabel1.setText(_("Where to start pasting subtitles"));
        add(jLabel1);

        add(SpinP);

        ChColor.setText(_("Change Color"));
        ChColor.setToolTipText(_("Enable this option if you want to change the default color of the pasted subtitles"));
        ChColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChColorActionPerformed(evt);
            }
        });

        add(ChColor);

        ColSel.setToolTipText(_("The color to use for the pasted subtitles"));
        ColSel.setEnabled(false);
        add(ColSel);

    }
    // </editor-fold>//GEN-END:initComponents

    private void ChColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChColorActionPerformed
        ColSel.setEnabled(ChColor.isSelected());
    }//GEN-LAST:event_ChColorActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ChColor;
    private javax.swing.JComboBox ColSel;
    private javax.swing.JPanel SpinP;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
    
}
