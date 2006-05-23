/*
 * JLoadPrefs.java
 *
 * Created on 23 Ιούνιος 2005, 2:27 μμ
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

package com.panayotis.jubler.options;
import java.awt.BorderLayout;
import java.util.Properties;

import static com.panayotis.jubler.i18n.I18N._;

/**
 *
 * @author  teras
 */
public class JLoadOptions extends JOptionsGUI {
    
    private String enc1_state, enc2_state, enc3_state, fps_state;
    private JRateChooser CFPS;
    
    /** Creates new form JLoadPrefs */
    public JLoadOptions() {
        initComponents();

        CFPS = new JRateChooser();
        FPSPanel.add(CFPS, BorderLayout.CENTER);
        fillComponents();
    }
    
    
    private void fillComponents() {
        int i;
        for ( i = 0 ; i < JPreferences.AvailEncodings.length ; i++) {
            CEnc1.addItem(JPreferences.AvailEncodings[i]);
            CEnc2.addItem(JPreferences.AvailEncodings[i]);
            CEnc3.addItem(JPreferences.AvailEncodings[i]);
        }
    }
    
    
    public float getFPS() {
        return CFPS.getFPSValue();
    }
    
    public String[] getEncodings() {
        String [] encs  = new String[3];
        encs[0] = getItemName(CEnc1);
        encs[1] = getItemName(CEnc2);
        encs[2] = getItemName(CEnc3);
        return encs;
    }
    
    public void loadPreferences(Properties props) {
        String e1, e2, e3;
        String fps;
        
        e1 = props.getProperty("Load.Encoding1", JPreferences.DefaultEncodings[0]);
        e2 = props.getProperty("Load.Encoding2", JPreferences.DefaultEncodings[1]);
        e3 = props.getProperty("Load.Encoding3", JPreferences.DefaultEncodings[2]);
        fps = props.getProperty("Load.FPS", JRateChooser.DefaultFPSEntry);
        
        setCombo(CEnc1, e1, "US-ASCII");
        setCombo(CEnc2, e2, "US-ASCII");
        setCombo(CEnc3, e3, "US-ASCII");
        CFPS.setFPS(fps);
    }
    
    public void savePreferences(Properties props) {
        props.setProperty("Load.Encoding1", getItemName(CEnc1));
        props.setProperty("Load.Encoding2", getItemName(CEnc2));
        props.setProperty("Load.Encoding3", getItemName(CEnc3));
        props.setProperty("Load.FPS", CFPS.getFPS());
    }
    
    public void saveState() {
        enc1_state = getItemName(CEnc1);
        enc2_state = getItemName(CEnc2);
        enc3_state = getItemName(CEnc3);
        fps_state = CFPS.getFPS();
    }
    
    public void restoreState() {
        setCombo(CEnc1, enc1_state, "US-ASCII");
        setCombo(CEnc2, enc2_state, "US-ASCII");
        setCombo(CEnc3, enc3_state, "US-ASCII");
        CFPS.setFPS(fps_state);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        CEnc1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        CEnc2 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        CEnc3 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        FPSPanel = new javax.swing.JPanel();

        setLayout(new java.awt.GridLayout(4, 2));

        jLabel1.setText(_("First Encoding"));
        add(jLabel1);

        CEnc1.setToolTipText(_("Select the encoding to be searched first"));
        add(CEnc1);

        jLabel2.setText(_("Second Encoding"));
        add(jLabel2);

        CEnc2.setToolTipText(_("Select the encoding to be searched second"));
        add(CEnc2);

        jLabel3.setText(_("Third Encoding"));
        add(jLabel3);

        CEnc3.setToolTipText(_("Select the encoding to be searched last"));
        add(CEnc3);

        jLabel6.setText(_("FPS"));
        add(jLabel6);

        FPSPanel.setLayout(new java.awt.BorderLayout());

        add(FPSPanel);

    }
    // </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox CEnc1;
    private javax.swing.JComboBox CEnc2;
    private javax.swing.JComboBox CEnc3;
    private javax.swing.JPanel FPSPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
    
}