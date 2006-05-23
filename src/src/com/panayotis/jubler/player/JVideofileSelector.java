/*
 * JVideofileSelector.java
 *
 * Created on 26 Ιούνιος 2005, 10:20 μμ
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

package com.panayotis.jubler.player;

import com.panayotis.jubler.DEBUG;
import com.panayotis.jubler.subs.FileCommunicator;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;

import static com.panayotis.jubler.i18n.I18N._;
import com.panayotis.jubler.preview.decoders.AudioCache;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author  teras
 */
public class JVideofileSelector extends javax.swing.JPanel {
    private File vfile;
    private File afile;
    private File cfile;
    private JFileChooser fdialog;
    
    private AudioFileFilter afilter;
    private VideoFileFilter vfilter;
    
    /** Creates new form PlayerOptions */
    public JVideofileSelector() {
        initComponents();
        vfilter = new VideoFileFilter();
        afilter = new AudioFileFilter();
        
        fdialog = new JFileChooser();
        fdialog.addChoosableFileFilter(vfilter);
        fdialog.addChoosableFileFilter(afilter);
        fdialog.setFileSelectionMode(JFileChooser.FILES_ONLY);
    }
    
    public void setVideoFile(String videofile, String audiofile, String cachefile, File guess) {
        
        /* Set vfile */
        if ( videofile!=null) vfile = new File(videofile);
        else vfile = FileCommunicator.guessFile(guess, new VideoFileFilter());
        
        /* Create a special filter for the selected video file */
        AudioFileFilter filter = new AudioFileFilter();
        filter.setCheckForValidCache(vfile);
        
        /* Find the basic name of the selected "audio" file */
        String gcache = vfile.getPath();
        if (audiofile != null) gcache = audiofile;
        int point = gcache.lastIndexOf('.');
        if (point < 0 ) point = gcache.length();
        
        /* Set cfile */
        if (cachefile!=null) cfile = new File(cachefile);
        else cfile = FileCommunicator.guessFile(new File( gcache.substring(0,point)), filter);
        
        if (audiofile!=null) afile = new File(audiofile);
        else {
            String cachename = AudioCache.getNameFromCache(cfile);
            if (cachename!=null && (!cachename.trim().equals(""))){
                afile = new File(cfile.getParent(), cachename);
                if (!afile.exists()) afile = null;
            }
        }
        
        
        if (afile == null) {
            boolean canwrite = false;
            try {
                canwrite = cfile.createNewFile();
            } catch (IOException ex) {
                //ex.printStackTrace();
            }
            if (canwrite) cfile.delete();
            else {
                gcache = vfile.getName();
                point = gcache.lastIndexOf('.');
                if (point < 0 ) point = gcache.length();
                cfile = new File(System.getProperties().getProperty("java.io.tmpdir")+
                        System.getProperties().getProperty("file.separator")+
                        gcache.substring(0,point)+AudioCache.getExtension());
            }
        }
        
        if (afile==null || (vfile!= null && afile.getName().equals(vfile.getName())) ) {
            ExternalAudioB.setSelected(false);
            AudioBrowse.setEnabled(false);
            afile = null;
        }
        else {
            ExternalAudioB.setSelected(true);
            AudioBrowse.setEnabled(true);
        }
        
        if (vfile!=null) VFName.setText(vfile.getPath());
        else VFName.setText("");
        
        if (afile!=null) AFName.setText(afile.getPath());
        else AFName.setText("");
        
        if (cfile!=null) CFName.setText(cfile.getPath());
        else AFName.setText("");
    }
    
    
    public File getVideoFile() { return vfile; }
    public File getCacheFile() { return cfile; }
    public File getAudioFile() { 
        if (ExternalAudioB.isSelected()) return afile;
        return null;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        AudioGroup = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        VFName = new javax.swing.JTextField();
        VideoBrowse = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        AFName = new javax.swing.JTextField();
        AudioBrowse = new javax.swing.JButton();
        ExternalAudioB = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        CFName = new javax.swing.JTextField();
        CacheBrowse = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel2.setText(_("Use the following video file"));
        jPanel2.add(jLabel2, java.awt.BorderLayout.NORTH);

        jPanel1.setLayout(new java.awt.BorderLayout());

        VFName.setColumns(40);
        VFName.setEditable(false);
        VFName.setToolTipText(_("Filename of the video file. Use the \"Browse\" button to change it."));
        jPanel1.add(VFName, java.awt.BorderLayout.CENTER);

        VideoBrowse.setText(_("Browse"));
        VideoBrowse.setToolTipText(_("Change the video filename"));
        VideoBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VideoBrowseActionPerformed(evt);
            }
        });

        jPanel1.add(VideoBrowse, java.awt.BorderLayout.EAST);

        jPanel2.add(jPanel1, java.awt.BorderLayout.CENTER);

        add(jPanel2);

        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel4.setBorder(new javax.swing.border.EmptyBorder(new java.awt.Insets(6, 0, 0, 0)));
        AFName.setColumns(40);
        AFName.setEditable(false);
        AFName.setToolTipText(_("Filename of the external audio file (could be also an audio cache). Use the \"Browse\" button to change it."));
        jPanel4.add(AFName, java.awt.BorderLayout.CENTER);

        AudioBrowse.setText(_("Browse"));
        AudioBrowse.setToolTipText(_("Change the external audio filename"));
        AudioBrowse.setEnabled(false);
        AudioBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AudioBrowseActionPerformed(evt);
            }
        });

        jPanel4.add(AudioBrowse, java.awt.BorderLayout.EAST);

        ExternalAudioB.setText(_("Use a different audio stream"));
        ExternalAudioB.setToolTipText(_("Use an audio stream outside from this video file.\n(E.g. a WAV file or a previously cached audio stream)"));
        ExternalAudioB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExternalAudioBActionPerformed(evt);
            }
        });

        jPanel4.add(ExternalAudioB, java.awt.BorderLayout.NORTH);

        add(jPanel4);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel5.setBorder(new javax.swing.border.EmptyBorder(new java.awt.Insets(8, 0, 0, 0)));
        CFName.setColumns(40);
        CFName.setEditable(false);
        CFName.setToolTipText(_("Filename of the previous audio cache. Use the \"Browse\" button to change it."));
        jPanel5.add(CFName, java.awt.BorderLayout.CENTER);

        CacheBrowse.setText(_("Browse"));
        CacheBrowse.setToolTipText(_("Change the audio cache filename"));
        CacheBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CacheBrowseActionPerformed(evt);
            }
        });

        jPanel5.add(CacheBrowse, java.awt.BorderLayout.EAST);

        jLabel1.setText(_("Filename of the cached audio stream"));
        jPanel5.add(jLabel1, java.awt.BorderLayout.NORTH);

        add(jPanel5);

    }
    // </editor-fold>//GEN-END:initComponents
    
    private void CacheBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CacheBrowseActionPerformed
        fdialog.setSelectedFile(cfile);
        afilter.setCheckForValidCache(vfile);
        fdialog.setFileFilter(afilter);
        if ( fdialog.showOpenDialog(this) != JFileChooser.APPROVE_OPTION) return;
        if (cfile.isFile() && cfile.length()==0) cfile.delete();
        cfile = fdialog.getSelectedFile();
        setVideoFile(vfile.getPath(), null, cfile.getPath(), null);
    }//GEN-LAST:event_CacheBrowseActionPerformed
    
    private void AudioBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AudioBrowseActionPerformed
        fdialog.setSelectedFile(afile);
        afilter.setCheckForValidCache(null);
        fdialog.setFileFilter(afilter);
        if ( fdialog.showOpenDialog(this) != JFileChooser.APPROVE_OPTION) return;
        File sel = fdialog.getSelectedFile();
        
        if (AudioCache.isAudioCache(sel)) {
            setVideoFile(vfile.getPath(), null, sel.getPath(), null);
            return;
        }
        setVideoFile(vfile.getPath(), sel.getPath(), null, null);
    }//GEN-LAST:event_AudioBrowseActionPerformed
    
    private void ExternalAudioBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExternalAudioBActionPerformed
        if (ExternalAudioB.isSelected()) {
            if (afile==null) AudioBrowseActionPerformed(evt);
            if (afile==null) {
                ExternalAudioB.setSelected(false);
                return;
            }
            AFName.setText(afile.getPath());
        } else{
            AFName.setText("");
        }
        AudioBrowse.setEnabled(ExternalAudioB.isSelected());
    }//GEN-LAST:event_ExternalAudioBActionPerformed
    
    private void VideoBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VideoBrowseActionPerformed
        fdialog.setSelectedFile(vfile);
        fdialog.setFileFilter(vfilter);
        if ( fdialog.showOpenDialog(this) != JFileChooser.APPROVE_OPTION) return;
        setVideoFile(fdialog.getSelectedFile().getPath(), null, null, null);
    }//GEN-LAST:event_VideoBrowseActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AFName;
    private javax.swing.JButton AudioBrowse;
    private javax.swing.ButtonGroup AudioGroup;
    private javax.swing.JTextField CFName;
    private javax.swing.JButton CacheBrowse;
    private javax.swing.JCheckBox ExternalAudioB;
    private javax.swing.JTextField VFName;
    private javax.swing.JButton VideoBrowse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
    
}