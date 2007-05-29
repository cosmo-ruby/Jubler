/*
 * JMaestroOptions.java
 *
 * Created on February 1, 2007, 1:06 PM
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

package com.panayotis.jubler.subs.loader.binary;

import static com.panayotis.jubler.i18n.I18N._;

import com.panayotis.jubler.media.MediaFile;
import com.panayotis.jubler.subs.Subtitles;
import java.awt.Dimension;

/**
 *
 * @author  teras
 */
public class JMaestroOptions extends javax.swing.JPanel {
    
    /** Creates new form JMaestroOptions */
    public JMaestroOptions() {
        initComponents();
    }
    
    public void updateValues(Subtitles subs, MediaFile media) {
        media.validateMediaFile(subs,false);
        Dimension vsize = media.getDimension();
        if (vsize==null) {
            vsize = new Dimension(700,500);
        }
        
        XSize.setValue(vsize.width);
        YSize.setValue(vsize.height);
    }
    
    public String getVideoFormat() {
        return Format.getSelectedItem().toString();
    }
    public int getVideoWidth() {
        return (Integer)XSize.getValue();
    }
    public int getVideoHeight() {
        return (Integer)YSize.getValue();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel2 = new javax.swing.JPanel();
        XSize = new javax.swing.JSpinner();
        YSize = new javax.swing.JSpinner();
        Format = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.GridLayout(3, 0, 0, 10));

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 5));
        jPanel2.add(XSize);

        jPanel2.add(YSize);

        Format.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PAL", "NTSC" }));
        jPanel2.add(Format);

        add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.GridLayout(3, 0));

        jLabel1.setText(_("Video width"));
        jPanel1.add(jLabel1);

        jLabel2.setText(_("Video height"));
        jPanel1.add(jLabel2);

        jLabel3.setText(_("Video standard"));
        jPanel1.add(jLabel3);

        add(jPanel1, java.awt.BorderLayout.WEST);

    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Format;
    private javax.swing.JSpinner XSize;
    private javax.swing.JSpinner YSize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
    
}
