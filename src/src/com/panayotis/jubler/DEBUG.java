/*
 * DEBUG.java
 *
 * Created on 14 Δεκέμβριος 2004, 4:30 μμ
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

package com.panayotis.jubler;

import com.panayotis.jubler.JIDialog;
import static com.panayotis.jubler.i18n.I18N._;



/**
 *
 * @author  teras
 */
public class DEBUG {
    
    /** Creates a new instance of DEBUG */
    public static void error(String err) {
        beep();
        JIDialog.message(null, err,  _("Error"), JIDialog.ERROR_MESSAGE);
    }
    
    public static void warning(String warn) {
        beep();
        JIDialog.message(null, warn, _("Warning!"), JIDialog.WARNING_MESSAGE);
    }
    
    public static void info(String warn) {
        System.out.println(warn);
    }
    
    public static void beep() {
        java.awt.Toolkit.getDefaultToolkit().beep();
    }
}