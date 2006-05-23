/*
 * JTimeRegionPanel.java
 *
 * Created on 25 Ιούνιος 2005, 2:28 πμ
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

import com.panayotis.jubler.JIDialog;
import com.panayotis.jubler.Jubler;
import com.panayotis.jubler.subs.SubEntry;
import com.panayotis.jubler.subs.Subtitles;
import com.panayotis.jubler.time.gui.JTimeArea;
import com.panayotis.jubler.time.gui.JTimeFullSelection;
import com.panayotis.jubler.time.gui.JTimeRegion;
import com.panayotis.jubler.undo.UndoEntry;
import java.awt.BorderLayout;
import java.util.Vector;
import javax.swing.JPanel;


/**
 *
 * @author teras
 */
public abstract class JTool extends JPanel {
    protected JTimeArea pos;
    protected Subtitles subs;
    protected int[] selected;
    
    protected Vector<SubEntry> affected_list;
    protected Jubler jparent;
    
    
    public JTool(Subtitles subs, int[] selected, boolean freeform) {
        super();
        this.subs = subs;
        this.selected = selected;
        if ( freeform ) {
            pos = new JTimeFullSelection(subs, selected);
        } else {
            pos = new JTimeRegion(subs, selected);
        }
        initialize();
        add(pos, BorderLayout.CENTER);
    }
    
    
    
    
    public void execute(Jubler jub) {
        jparent = jub;
        int res;
        UndoEntry undo;
        
        res = JIDialog.question(jparent, this, getToolTitle());
        if ( res != JIDialog.OK_OPTION) return;
        
        jparent.getUndoList().addUndo( new UndoEntry(subs, getToolTitle()));
        SubEntry [] selected = jparent.getSelectedSubs();
        
        affected_list = pos.getAffectedSubs();
        if ( affected_list.size() == 0 ) return;
        
        storeSelections();
        
        for (int i = 0 ; i < affected_list.size() ; i++ ) {
            affect(i);
        }
        jparent.tableHasChanged(selected);
    }
    
    
    protected abstract void initialize();
    protected abstract void storeSelections();
    protected abstract void affect(int index);
    protected abstract String getToolTitle();
}