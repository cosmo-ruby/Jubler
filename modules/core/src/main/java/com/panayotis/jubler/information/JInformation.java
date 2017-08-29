/*
 * JInformation.java
 *
 * Created on 26 Αύγουστος 2005, 5:42 μμ
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
package com.panayotis.jubler.information;

import static com.panayotis.jubler.i18n.I18N.__;
import static com.panayotis.jubler.options.Options.*;

import com.panayotis.jubler.JubFrame;
import com.panayotis.jubler.media.MediaFile;
import com.panayotis.jubler.options.Options;
import com.panayotis.jubler.os.SystemDependent;
import com.panayotis.jubler.subs.SubAttribs;
import com.panayotis.jubler.subs.SubEntry;
import com.panayotis.jubler.subs.Subtitles;
import com.panayotis.jubler.subs.TotalSubMetrics;
import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author teras
 */
public class JInformation extends JDialog {

    private final Subtitles subs;
    private final MediaFile media;
    private static final String[] CTTypesData = {__("per line"), __("per second")};

    /**
     * Creates new form JProperties
     *
     * @param parent
     */
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public JInformation(JubFrame parent) {
        super(parent, true);

        subs = parent.getSubtitles();
        media = parent.getMediaFile();

        initComponents();
        ErrorColC.removeItemAt(0);

        SubAttribs attr = parent.getSubtitles().getAttribs();
        TitleT.setText(attr.title);
        AuthorT.setText(attr.author);
        SourceT.setText(attr.source);
        CommentsT.setText(attr.comments);
        FilePathT.setText(parent.getSubtitles().getSubFile().getStrippedFile().getPath());

        NumberT.setText(Integer.toString(parent.getSubtitles().size()));
        TotalSubMetrics m = parent.getSubtitles().getTotalMetrics();
        TotalSubSizeT.setText(Integer.toString(m.totallength));
        TotalLinesT.setText(Integer.toString(m.totallines));
        MaxSubSizeT.setText(Integer.toString(m.maxlength));
        MaxLinesT.setText(Integer.toString(m.maxlines));
        MaxLengthLineT.setText(Integer.toString(m.maxlinelength));
        MaxCPST.setText(Float.toString(m.maxcps));
        MinCPST.setText(Float.toString(m.mincps));

        VSelectorP.add(parent.getMediaFile().videoselector, BorderLayout.CENTER);

        ErrorColC.setSelectedIndex(getErrorColor() - 1);
        MaxLineS.setValue(getMaxLines());
        MaxLengthS.setValue(getMaxSubLength());
        MaxLengthLineS.setValue(getMaxLineLength());
        MaxCPSS.setValue(getMaxCPS());
        MaxDurS.setValue(getMaxDuration());
        MinDurS.setValue(getMinDuration());
        spaceCharsC.setSelected(isSpaceChars());

        MaxLineS.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                Options.setMaxLines(MaxLineS.getValue());
            }
        });
        FillPercentS.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                Options.setFillPercent(FillPercentS.getValue());
            }
        });
        MaxLengthS.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                Options.setMaxSubLength(MaxLengthS.getValue());
            }
        });
        MaxLengthLineS.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                Options.setMaxLineLength(MaxLengthLineS.getValue());
            }
        });
        MaxCPSS.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                Options.setMaxCPS(MaxCPSS.getValue());
            }
        });
        MaxDurS.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                Options.setMaxDuration(MaxDurS.getValue());
            }
        });
        MinDurS.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                Options.setMinDuration(MinDurS.getValue());
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    public SubAttribs getAttribs() {
        return new SubAttribs(TitleT.getText(), AuthorT.getText(), SourceT.getText(), CommentsT.getText());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PTabs = new javax.swing.JTabbedPane();
        InfoP = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CommentsT = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        TitleL = new javax.swing.JLabel();
        AuthorL = new javax.swing.JLabel();
        SourceL = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        TitleT = new javax.swing.JTextField();
        AuthorT = new javax.swing.JTextField();
        SourceT = new javax.swing.JTextField();
        MediaP = new javax.swing.JPanel();
        VSelectorP = new javax.swing.JPanel();
        SubFileInfoP = new javax.swing.JPanel();
        FilePathL = new javax.swing.JLabel();
        FilePathT = new javax.swing.JTextField();
        QualityP = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        ErrorColL = new javax.swing.JLabel();
        ErrorColC = new javax.swing.JComboBox();
        jPanel13 = new javax.swing.JPanel();
        spaceCharsC = new javax.swing.JCheckBox();
        compactC = new javax.swing.JCheckBox();
        jPanel12 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        MaxCharsL = new javax.swing.JLabel();
        MaxLineS = new javax.swing.JSlider();
        jPanel21 = new javax.swing.JPanel();
        FillPercentL = new javax.swing.JLabel();
        FillPercentS = new javax.swing.JSlider();
        jPanel16 = new javax.swing.JPanel();
        MaxCharsL1 = new javax.swing.JLabel();
        MaxLengthLineS = new javax.swing.JSlider();
        jPanel19 = new javax.swing.JPanel();
        MaxCharsL4 = new javax.swing.JLabel();
        MaxLengthS = new javax.swing.JSlider();
        jPanel17 = new javax.swing.JPanel();
        MaxCharsL2 = new javax.swing.JLabel();
        MaxCPSS = new javax.swing.JSlider();
        jPanel18 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        MinCharsL = new javax.swing.JLabel();
        MinDurS = new javax.swing.JSlider();
        jPanel7 = new javax.swing.JPanel();
        MaxCharsL3 = new javax.swing.JLabel();
        MaxDurS = new javax.swing.JSlider();
        StatsP = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        NumberL = new javax.swing.JLabel();
        NumberT = new javax.swing.JLabel();
        TotalSubSizeL = new javax.swing.JLabel();
        TotalSubSizeT = new javax.swing.JLabel();
        TotalLinesL = new javax.swing.JLabel();
        TotalLinesT = new javax.swing.JLabel();
        MaxSubSizeL = new javax.swing.JLabel();
        MaxSubSizeT = new javax.swing.JLabel();
        MaxLinesL = new javax.swing.JLabel();
        MaxLinesT = new javax.swing.JLabel();
        MaxLengthLineL = new javax.swing.JLabel();
        MaxLengthLineT = new javax.swing.JLabel();
        MaxCPSL = new javax.swing.JLabel();
        MaxCPST = new javax.swing.JLabel();
        MinCPSL = new javax.swing.JLabel();
        MinCPST = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        OKB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(__("Project Properties"));
        setResizable(false);

        PTabs.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                PTabsStateChanged(evt);
            }
        });

        InfoP.setName("info"); // NOI18N
        InfoP.setOpaque(false);
        InfoP.setLayout(new java.awt.BorderLayout());

        jPanel2.setBorder(SystemDependent.getBorder(__("Comments")));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(350, 150));
        jPanel2.setLayout(new java.awt.BorderLayout());

        CommentsT.setToolTipText(__("Comments about these subtitles"));
        jScrollPane1.setViewportView(CommentsT);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        InfoP.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10));
        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.GridLayout(0, 1));

        TitleL.setText(__("Title"));
        jPanel4.add(TitleL);

        AuthorL.setText(__("Author"));
        jPanel4.add(AuthorL);

        SourceL.setText(__("Source"));
        jPanel4.add(SourceL);

        jPanel1.add(jPanel4, java.awt.BorderLayout.WEST);

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.GridLayout(0, 1));

        TitleT.setToolTipText(__("Title for this subtitle file"));
        jPanel3.add(TitleT);

        AuthorT.setToolTipText(__("Author of this subtitle file"));
        jPanel3.add(AuthorT);

        SourceT.setToolTipText(__("Original source of this subtitle file"));
        jPanel3.add(SourceT);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        InfoP.add(jPanel1, java.awt.BorderLayout.NORTH);

        PTabs.addTab(__("Information"), InfoP);

        MediaP.setName("media"); // NOI18N
        MediaP.setOpaque(false);
        MediaP.setLayout(new java.awt.BorderLayout());

        VSelectorP.setOpaque(false);
        VSelectorP.setLayout(new java.awt.BorderLayout());

        SubFileInfoP.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        SubFileInfoP.setOpaque(false);
        SubFileInfoP.setLayout(new java.awt.BorderLayout());

        FilePathL.setText(__("Subtitle File"));
        SubFileInfoP.add(FilePathL, java.awt.BorderLayout.WEST);

        FilePathT.setEditable(false);
        FilePathT.setToolTipText(__("The file of this subtitle"));
        SubFileInfoP.add(FilePathT, java.awt.BorderLayout.SOUTH);

        VSelectorP.add(SubFileInfoP, java.awt.BorderLayout.NORTH);

        MediaP.add(VSelectorP, java.awt.BorderLayout.NORTH);

        PTabs.addTab(__("Media"), MediaP);

        QualityP.setName("stats"); // NOI18N
        QualityP.setOpaque(false);
        QualityP.setLayout(new java.awt.BorderLayout());

        jPanel10.setLayout(new java.awt.BorderLayout());

        jPanel11.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        jPanel11.setLayout(new java.awt.BorderLayout());

        ErrorColL.setText(__("Color to use"));
        ErrorColL.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 12));
        jPanel11.add(ErrorColL, java.awt.BorderLayout.WEST);

        ErrorColC.setModel(new javax.swing.DefaultComboBoxModel(SubEntry.MarkNames));
        ErrorColC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ErrorColCActionPerformed(evt);
            }
        });
        jPanel11.add(ErrorColC, java.awt.BorderLayout.CENTER);

        jPanel13.setLayout(new java.awt.GridLayout());

        spaceCharsC.setText(__("Treat spaces as characters"));
        spaceCharsC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spaceCharsCActionPerformed(evt);
            }
        });
        jPanel13.add(spaceCharsC);

        compactC.setSelected(true);
        compactC.setText(__("Prefer compact subtitles"));
        compactC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compactCActionPerformed(evt);
            }
        });
        jPanel13.add(compactC);

        jPanel11.add(jPanel13, java.awt.BorderLayout.SOUTH);

        jPanel10.add(jPanel11, java.awt.BorderLayout.CENTER);

        jPanel12.setOpaque(false);
        jPanel12.setLayout(new java.awt.GridLayout(0, 1));

        jPanel15.setLayout(new java.awt.GridLayout());

        jPanel14.setLayout(new java.awt.BorderLayout());

        MaxCharsL.setText(__("Maximum number of lines per subtitle"));
        jPanel14.add(MaxCharsL, java.awt.BorderLayout.NORTH);

        MaxLineS.setMajorTickSpacing(2);
        MaxLineS.setMaximum(7);
        MaxLineS.setMinimum(1);
        MaxLineS.setMinorTickSpacing(1);
        MaxLineS.setPaintLabels(true);
        MaxLineS.setPaintTicks(true);
        MaxLineS.setSnapToTicks(true);
        MaxLineS.setValue(2);
        jPanel14.add(MaxLineS, java.awt.BorderLayout.SOUTH);

        jPanel15.add(jPanel14);

        jPanel21.setLayout(new java.awt.BorderLayout());

        FillPercentL.setText(__("Line fill percentage"));
        jPanel21.add(FillPercentL, java.awt.BorderLayout.NORTH);

        FillPercentS.setMajorTickSpacing(10);
        FillPercentS.setMinorTickSpacing(1);
        FillPercentS.setPaintLabels(true);
        FillPercentS.setPaintTicks(true);
        FillPercentS.setSnapToTicks(true);
        FillPercentS.setValue(50);
        jPanel21.add(FillPercentS, java.awt.BorderLayout.SOUTH);

        jPanel15.add(jPanel21);

        jPanel12.add(jPanel15);

        jPanel16.setLayout(new java.awt.BorderLayout());

        MaxCharsL1.setText(__("Maximum number of characters per line"));
        jPanel16.add(MaxCharsL1, java.awt.BorderLayout.NORTH);

        MaxLengthLineS.setMajorTickSpacing(10);
        MaxLengthLineS.setMinimum(10);
        MaxLengthLineS.setMinorTickSpacing(1);
        MaxLengthLineS.setPaintLabels(true);
        MaxLengthLineS.setPaintTicks(true);
        MaxLengthLineS.setSnapToTicks(true);
        MaxLengthLineS.setValue(40);
        jPanel16.add(MaxLengthLineS, java.awt.BorderLayout.SOUTH);

        jPanel12.add(jPanel16);

        jPanel19.setLayout(new java.awt.BorderLayout());

        MaxCharsL4.setText(__("Maximum number of characters per subtitle"));
        jPanel19.add(MaxCharsL4, java.awt.BorderLayout.NORTH);

        MaxLengthS.setMajorTickSpacing(10);
        MaxLengthS.setMaximum(150);
        MaxLengthS.setMinimum(10);
        MaxLengthS.setMinorTickSpacing(1);
        MaxLengthS.setPaintLabels(true);
        MaxLengthS.setPaintTicks(true);
        MaxLengthS.setSnapToTicks(true);
        MaxLengthS.setValue(40);
        jPanel19.add(MaxLengthS, java.awt.BorderLayout.SOUTH);

        jPanel12.add(jPanel19);

        jPanel17.setLayout(new java.awt.BorderLayout());

        MaxCharsL2.setText(__("Maximum number of characters per second"));
        jPanel17.add(MaxCharsL2, java.awt.BorderLayout.NORTH);

        MaxCPSS.setMajorTickSpacing(5);
        MaxCPSS.setMaximum(50);
        MaxCPSS.setMinorTickSpacing(1);
        MaxCPSS.setPaintLabels(true);
        MaxCPSS.setPaintTicks(true);
        MaxCPSS.setSnapToTicks(true);
        MaxCPSS.setValue(5);
        jPanel17.add(MaxCPSS, java.awt.BorderLayout.SOUTH);

        jPanel12.add(jPanel17);

        jPanel18.setLayout(new java.awt.GridLayout());

        jPanel20.setLayout(new java.awt.BorderLayout());

        MinCharsL.setText(__("Minimum duration in seconds"));
        jPanel20.add(MinCharsL, java.awt.BorderLayout.NORTH);

        MinDurS.setMajorTickSpacing(10);
        MinDurS.setMaximum(60);
        MinDurS.setMinorTickSpacing(1);
        MinDurS.setPaintLabels(true);
        MinDurS.setPaintTicks(true);
        MinDurS.setSnapToTicks(true);
        MinDurS.setValue(40);
        jPanel20.add(MinDurS, java.awt.BorderLayout.SOUTH);

        jPanel18.add(jPanel20);

        jPanel7.setLayout(new java.awt.BorderLayout());

        MaxCharsL3.setText(__("Maximum duration in seconds"));
        jPanel7.add(MaxCharsL3, java.awt.BorderLayout.NORTH);

        MaxDurS.setMajorTickSpacing(10);
        MaxDurS.setMaximum(60);
        MaxDurS.setMinorTickSpacing(1);
        MaxDurS.setPaintLabels(true);
        MaxDurS.setPaintTicks(true);
        MaxDurS.setSnapToTicks(true);
        MaxDurS.setValue(40);
        jPanel7.add(MaxDurS, java.awt.BorderLayout.SOUTH);

        jPanel18.add(jPanel7);

        jPanel12.add(jPanel18);

        jPanel10.add(jPanel12, java.awt.BorderLayout.SOUTH);

        QualityP.add(jPanel10, java.awt.BorderLayout.NORTH);

        PTabs.addTab(__("Quality"), QualityP);

        StatsP.setName("stats"); // NOI18N
        StatsP.setOpaque(false);
        StatsP.setLayout(new java.awt.BorderLayout());

        jPanel9.setOpaque(false);
        jPanel9.setLayout(new java.awt.BorderLayout());

        jPanel8.setOpaque(false);
        jPanel8.setLayout(new java.awt.GridLayout(0, 2, 0, 4));

        NumberL.setText(__("Number of subtitles"));
        jPanel8.add(NumberL);
        jPanel8.add(NumberT);

        TotalSubSizeL.setText(__("Total subtitle characters"));
        jPanel8.add(TotalSubSizeL);
        jPanel8.add(TotalSubSizeT);

        TotalLinesL.setText(__("Total subtitle lines"));
        jPanel8.add(TotalLinesL);
        jPanel8.add(TotalLinesT);

        MaxSubSizeL.setText(__("Maximum subtitle length"));
        jPanel8.add(MaxSubSizeL);
        jPanel8.add(MaxSubSizeT);

        MaxLinesL.setText(__("Maximum subtitle lines"));
        jPanel8.add(MaxLinesL);
        jPanel8.add(MaxLinesT);

        MaxLengthLineL.setText(__("Maximum characters per line"));
        jPanel8.add(MaxLengthLineL);
        jPanel8.add(MaxLengthLineT);

        MaxCPSL.setText(__("Maximum subtitle characters per second"));
        jPanel8.add(MaxCPSL);
        jPanel8.add(MaxCPST);

        MinCPSL.setText(__("Minimum subtitle characters per second"));
        jPanel8.add(MinCPSL);
        jPanel8.add(MinCPST);

        jPanel9.add(jPanel8, java.awt.BorderLayout.NORTH);

        StatsP.add(jPanel9, java.awt.BorderLayout.NORTH);

        PTabs.addTab(__("Statistics"), StatsP);

        getContentPane().add(PTabs, java.awt.BorderLayout.CENTER);

        jPanel5.setOpaque(false);
        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 6, 16));
        jPanel6.setOpaque(false);
        jPanel6.setLayout(new java.awt.GridLayout(1, 2));

        OKB.setText(__("OK"));
        OKB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKBActionPerformed(evt);
            }
        });
        jPanel6.add(OKB);

        jPanel5.add(jPanel6, java.awt.BorderLayout.EAST);

        getContentPane().add(jPanel5, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PTabsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_PTabsStateChanged
        if (PTabs.getSelectedComponent().getName().equals("media"))
            media.guessMediaFiles(subs);
    }//GEN-LAST:event_PTabsStateChanged

    private void OKBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKBActionPerformed
        setVisible(false);
    }//GEN-LAST:event_OKBActionPerformed

    private void ErrorColCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ErrorColCActionPerformed
        Options.setErrorColor(ErrorColC.getSelectedIndex() + 1);
    }//GEN-LAST:event_ErrorColCActionPerformed

    private void spaceCharsCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spaceCharsCActionPerformed
        Options.setSpaceChars(spaceCharsC.isSelected());
    }//GEN-LAST:event_spaceCharsCActionPerformed

    private void compactCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compactCActionPerformed
        Options.setCompactSubs(compactC.isSelected());
    }//GEN-LAST:event_compactCActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AuthorL;
    private javax.swing.JTextField AuthorT;
    private javax.swing.JTextArea CommentsT;
    private javax.swing.JComboBox ErrorColC;
    private javax.swing.JLabel ErrorColL;
    private javax.swing.JLabel FilePathL;
    private javax.swing.JTextField FilePathT;
    private javax.swing.JLabel FillPercentL;
    private javax.swing.JSlider FillPercentS;
    private javax.swing.JPanel InfoP;
    private javax.swing.JLabel MaxCPSL;
    private javax.swing.JSlider MaxCPSS;
    private javax.swing.JLabel MaxCPST;
    private javax.swing.JLabel MaxCharsL;
    private javax.swing.JLabel MaxCharsL1;
    private javax.swing.JLabel MaxCharsL2;
    private javax.swing.JLabel MaxCharsL3;
    private javax.swing.JLabel MaxCharsL4;
    private javax.swing.JSlider MaxDurS;
    private javax.swing.JLabel MaxLengthLineL;
    private javax.swing.JSlider MaxLengthLineS;
    private javax.swing.JLabel MaxLengthLineT;
    private javax.swing.JSlider MaxLengthS;
    private javax.swing.JSlider MaxLineS;
    private javax.swing.JLabel MaxLinesL;
    private javax.swing.JLabel MaxLinesT;
    private javax.swing.JLabel MaxSubSizeL;
    private javax.swing.JLabel MaxSubSizeT;
    private javax.swing.JPanel MediaP;
    private javax.swing.JLabel MinCPSL;
    private javax.swing.JLabel MinCPST;
    private javax.swing.JLabel MinCharsL;
    private javax.swing.JSlider MinDurS;
    private javax.swing.JLabel NumberL;
    private javax.swing.JLabel NumberT;
    private javax.swing.JButton OKB;
    private javax.swing.JTabbedPane PTabs;
    private javax.swing.JPanel QualityP;
    private javax.swing.JLabel SourceL;
    private javax.swing.JTextField SourceT;
    private javax.swing.JPanel StatsP;
    private javax.swing.JPanel SubFileInfoP;
    private javax.swing.JLabel TitleL;
    private javax.swing.JTextField TitleT;
    private javax.swing.JLabel TotalLinesL;
    private javax.swing.JLabel TotalLinesT;
    private javax.swing.JLabel TotalSubSizeL;
    private javax.swing.JLabel TotalSubSizeT;
    private javax.swing.JPanel VSelectorP;
    private javax.swing.JCheckBox compactC;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox spaceCharsC;
    // End of variables declaration//GEN-END:variables
}
