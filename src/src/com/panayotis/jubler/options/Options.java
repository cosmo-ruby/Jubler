/*
 * PrefsIO.java
 *
 * Created on 23 Ιούνιος 2005, 4:43 μμ
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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
/**
 *
 * @author teras
 */
public class Options {
    
    private final static Properties props;
    private final static String preffile;
    
    static {
        preffile = System.getProperty("user.home") + System.getProperty("file.separator") + ".jublerrc";
        
        props = new Properties();
        try {
            props.loadFromXML(new FileInputStream(preffile));
        } catch ( IOException e ) {
        }
    }
    
    
    synchronized public static void setOption(String key, String value) {
        props.setProperty(key, value);
    }
    
    public static String getOption(String key, String deflt) {
        return props.getProperty(key, deflt);
    }
    
    synchronized public static void saveOptions() {
        try {
            props.storeToXML(new FileOutputStream(preffile), "Jubler file");
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }
    
    
    
    public static void loadSystemPreferences(JPreferences prefs) {
        prefs.jload.loadPreferences(props);
        prefs.jsave.loadPreferences(props);
        prefs.smodel.loadPreferences(props);
        prefs.loadPreferences(props);
    }
    
    
    public static void saveSystemPreferences(JPreferences prefs) {
        prefs.jload.savePreferences(props);
        prefs.jsave.savePreferences(props);
        prefs.smodel.savePreferences(props);
        prefs.savePreferences(props);
        saveOptions();
    }
    
    public static void saveFileList(File[]  list) {
        String fname;
        String key;
        for (int i = 0 ; i < 10 ; i++) {
            key = "System.Lastfile"+(i+1);
            if (!(list[i]==null) && list[i].exists() && list[i].isFile()) {
                props.setProperty(key, list[i].getPath());
            } else {
                props.remove(key);
            }
        }
        saveOptions();
    }
    
    public static File[] loadFileList() {
        File[] ret = new File[10];
        String fname;
        int pointer = 0;
        File f;
        for (int i = 1 ; i < 11 ; i++) {
            fname = props.getProperty("System.Lastfile"+i,"");
            if (!fname.trim().equals("")) {
                f = new File(fname);
                if (f.exists() && f.canRead() && f.isFile())
                    ret[pointer++] = f;
            }
        }
        return ret;
    }
}