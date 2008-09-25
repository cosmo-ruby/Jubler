/*
 * UpdaterFrame.java
 *
 * Created on September 25, 2008, 3:54 AM
 */
package com.panayotis.updater.gui;

import com.panayotis.updater.html.UpdaterAppElements;
import java.awt.BorderLayout;
import static com.panayotis.jubler.i18n.I18N._;

import java.awt.Frame;
import javax.swing.JDialog;
import javax.swing.border.Border;

/**
 *
 * @author  teras
 */
public class UpdaterFrame extends JDialog {

    /** Creates new form UpdaterFrame */
    public UpdaterFrame() {
        super((Frame) null, false);
        initComponents();
        ProgressP.setVisible(false);
        MainPanel.add(CommandP, BorderLayout.SOUTH);
    }

    public void setAppElements(UpdaterAppElements el) {
        NewVerL.setText(_("A new version of {0} is available!", el.getAppName()));
        VersInfoL.setText(_("{0} version {1} is now available - you have {2}.", el.getAppName(), el.getNewVersion(), el.getCurVersion()));
        setTitle(_("New version of {0} found!", el.getAppName()));

        InfoPane.setContentType("text/html");
        InfoPane.setText(el.getHTML());

        IconL.setIcon(new javax.swing.ImageIcon(getClass().getResource(el.getIconpath())));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        InfoPane = new javax.swing.JEditorPane();
        jPanel5 = new javax.swing.JPanel();
        NewVerL = new javax.swing.JLabel();
        VersInfoL = new javax.swing.JLabel();
        NotesL = new javax.swing.JLabel();
        IconL = new javax.swing.JLabel();
        CommandP = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        SkipB = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        LaterB = new javax.swing.JButton();
        UpdateB = new javax.swing.JButton();
        ProgressP = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel9 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        MainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        MainPanel.setMinimumSize(new java.awt.Dimension(550, 400));
        MainPanel.setPreferredSize(new java.awt.Dimension(550, 400));
        MainPanel.setLayout(new java.awt.BorderLayout());

        jPanel6.setLayout(new java.awt.BorderLayout());

        InfoPane.setEditable(false);
        jScrollPane1.setViewportView(InfoPane);

        jPanel6.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel5.setLayout(new java.awt.BorderLayout());

        NewVerL.setFont(NewVerL.getFont().deriveFont(NewVerL.getFont().getStyle() | java.awt.Font.BOLD, NewVerL.getFont().getSize()+1));
        NewVerL.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        jPanel5.add(NewVerL, java.awt.BorderLayout.NORTH);
        jPanel5.add(VersInfoL, java.awt.BorderLayout.CENTER);

        NotesL.setFont(NotesL.getFont().deriveFont(NotesL.getFont().getStyle() | java.awt.Font.BOLD));
        NotesL.setText(_("Release Notes"));
        NotesL.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 0, 4, 0));
        jPanel5.add(NotesL, java.awt.BorderLayout.SOUTH);

        jPanel6.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        MainPanel.add(jPanel6, java.awt.BorderLayout.CENTER);

        IconL.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        IconL.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 0, 0, 0));
        MainPanel.add(IconL, java.awt.BorderLayout.LINE_START);

        CommandP.setLayout(new java.awt.BorderLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 12, 8, 8));
        jPanel3.setLayout(new java.awt.BorderLayout());

        SkipB.setText(_("Skip this version"));
        jPanel3.add(SkipB, java.awt.BorderLayout.CENTER);

        CommandP.add(jPanel3, java.awt.BorderLayout.WEST);

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 12));
        jPanel4.setLayout(new java.awt.GridLayout(1, 2, 4, 0));

        LaterB.setText(_("Remind me later"));
        jPanel4.add(LaterB);

        UpdateB.setText(_("Install Update"));
        UpdateB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBActionPerformed(evt);
            }
        });
        jPanel4.add(UpdateB);

        CommandP.add(jPanel4, java.awt.BorderLayout.EAST);

        MainPanel.add(CommandP, java.awt.BorderLayout.SOUTH);

        ProgressP.setLayout(new java.awt.BorderLayout());

        jPanel8.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 0));
        jPanel8.setLayout(new java.awt.BorderLayout());
        jPanel8.add(jProgressBar1, java.awt.BorderLayout.CENTER);

        ProgressP.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel9.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 24, 8, 8));
        jPanel9.setLayout(new java.awt.BorderLayout());

        jButton4.setText(_("Cancel"));
        jPanel9.add(jButton4, java.awt.BorderLayout.CENTER);

        ProgressP.add(jPanel9, java.awt.BorderLayout.EAST);

        jLabel1.setText(_("Downloading..."));
        ProgressP.add(jLabel1, java.awt.BorderLayout.LINE_START);

        MainPanel.add(ProgressP, java.awt.BorderLayout.SOUTH);

        getContentPane().add(MainPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void UpdateBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBActionPerformed
    CommandP.setVisible(false);
    ProgressP.setVisible(true);
    MainPanel.add(ProgressP, BorderLayout.SOUTH);
}//GEN-LAST:event_UpdateBActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CommandP;
    private javax.swing.JLabel IconL;
    private javax.swing.JEditorPane InfoPane;
    private javax.swing.JButton LaterB;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JLabel NewVerL;
    private javax.swing.JLabel NotesL;
    private javax.swing.JPanel ProgressP;
    private javax.swing.JButton SkipB;
    private javax.swing.JButton UpdateB;
    private javax.swing.JLabel VersInfoL;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}