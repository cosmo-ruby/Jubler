/*
 * SubEntry.java
 *
 * Created on 22 Ιούνιος 2005, 1:51 πμ
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

package com.panayotis.jubler.subs;

import com.panayotis.jubler.DEBUG;
import com.panayotis.jubler.time.Time;
import java.awt.Color;

import static com.panayotis.jubler.i18n.I18N._;
import static com.panayotis.jubler.subs.style.SubStyle.Style.*;

import com.panayotis.jubler.subs.style.SubStyle;
import com.panayotis.jubler.subs.style.event.AbstractStyleover;
import com.panayotis.jubler.subs.style.event.StyleoverParagraph;
import com.panayotis.jubler.subs.style.event.StyleoverCharacter;
import com.panayotis.jubler.subs.style.event.StyleoverFull;
import javax.swing.JTextPane;
import javax.swing.text.StyleConstants;


/**
 *
 * @author teras
 */
public class SubEntry implements Comparable<SubEntry> {
    
    private static final AbstractStyleover[] styleover_template;
    
    static {
        
        /* this is a template of the handler of the AbstractStyleover Event
         * If such a handler is not valid, then it won't be possible to properly add an event */
        styleover_template = new AbstractStyleover[SubStyle.Style.values().length];
        styleover_template[FONTNAME.ordinal()] = new StyleoverCharacter(StyleConstants.FontFamily);
        styleover_template[FONTSIZE.ordinal()] = new StyleoverCharacter(StyleConstants.FontSize);
        styleover_template[BOLD.ordinal()] = new StyleoverCharacter(StyleConstants.Bold);
        styleover_template[ITALIC.ordinal()] = new StyleoverCharacter(StyleConstants.Italic);
        styleover_template[UNDERLINE.ordinal()] = new StyleoverCharacter(StyleConstants.Underline);
        styleover_template[STRIKETHROUGH.ordinal()] = new StyleoverCharacter(StyleConstants.StrikeThrough);
        
        styleover_template[PRIMARY.ordinal()] = new StyleoverCharacter(StyleConstants.Foreground);
        styleover_template[SECONDARY.ordinal()] = new StyleoverCharacter("secondary");
        styleover_template[OUTLINE.ordinal()] = new StyleoverCharacter("outline");
        styleover_template[SHADOW.ordinal()] = new StyleoverCharacter(StyleConstants.Background);
        
        styleover_template[BORDERSTYLE.ordinal()] = new StyleoverFull("borderstyle");
        styleover_template[BORDERSIZE.ordinal()] = new StyleoverFull("bordersize");
        styleover_template[SHADOWSIZE.ordinal()] = new StyleoverFull("shadowsize");
        
        styleover_template[LEFTMARGIN.ordinal()] = new StyleoverFull("leftmargin");
        styleover_template[RIGHTMARGIN.ordinal()] = new StyleoverFull("rightmargin");
        styleover_template[VERTICAL.ordinal()] = new StyleoverFull("vertical");
        styleover_template[ANGLE.ordinal()] = new StyleoverFull("angle");
        
        styleover_template[SPACING.ordinal()] = new StyleoverFull("spacing");
        styleover_template[XSCALE.ordinal()] = new StyleoverFull("xscale");
        styleover_template[YSCALE.ordinal()] = new StyleoverFull("yscale");
        styleover_template[DIRECTION.ordinal()] = new StyleoverFull(StyleConstants.Alignment);
        styleover_template[UNKNOWN.ordinal()] = new StyleoverCharacter("unknown");
    }
    
    /* Markings */
    public static final String [] MarkNames = {_("None"), _("Pink"), _("Yellow"), _("Cyan")};
    public static final Color [] MarkColors = {Color.WHITE, new Color(255, 200, 220), new Color(255, 255, 200), new Color(200, 255, 255)};
    
    
    
    private Time start, finish;
    private String subtext;
    private int mark;
    private SubStyle style;
    
    /** The following parameter is lazily used. It is initialized only when data
     * are needed to be added.
     */
    public AbstractStyleover[] overstyle;
    
    
    public SubEntry( double start, double finish, String line) {
        this.start = new Time(start);
        this.finish = new Time(finish);
        this.subtext = subtext;
        mark = 0;
        style = null;
    }
    
    public SubEntry(Time start, Time finish, String line) {
        this.start = new Time(start);
        this.finish = new Time(finish);
        this.subtext = line;
        mark = 0;
    }
    
    public SubEntry(SubEntry old) {
        this(old.getStartTime(), old.getFinishTime(), old.getText());
        mark = old.mark;
        style = old.style;
        if (old.overstyle!=null) {
            overstyle=new AbstractStyleover[old.overstyle.length];
            for (int i = 0 ; i < overstyle.length ; i++) {
                if ( old.overstyle[i] != null) {
                    overstyle[i] = (AbstractStyleover)styleover_template[i].clone();
                    overstyle[i].updateClone(old.overstyle[i]);
                }
            }
        }
    }
    
    public SubEntry() {
        this(0, 0, "");
    }
    
    
    public int compareTo(SubEntry other) {
        return start.compareTo(other.start);
    }
    
    public void setMark(int i) { mark = i; }
    public int getMark() { return mark; }
    
    public void setStyle(SubStyle th) { style = th; }
    public SubStyle getStyle() { return style; }
    public AbstractStyleover[] getStyleovers() { return overstyle; }
    
    public void setText(String text) {
        subtext= text;
    }
    public void setStartTime(Time t) {
        start.setTime(t);
    }
    public void setFinishTime(Time t) {
        finish.setTime(t);
    }
    
    String getData(int col) {
        switch (col) {
            case 0:
                return start.toString();
            case 1:
                return finish.toString();
            case 2:
                return "0";
            case 3:
                if (style==null) return "?Default";
                return style.toString();
            case 4:
                return subtext.replace('\n','|');
        }
        return null;
    }
    
    public Time getStartTime() { return start; }
    public Time getFinishTime() { return finish; }
    public String getText() { return subtext; }
    
    
    void setData(int col, Object data) {
        DEBUG.error("BUG IN PROGRAM: SET DATA WAS SELECTED\nPlease contact author");
        if ( col==3) subtext = data.toString();
    }
    
    public boolean isInTime(double t) {
        if ( t >= start.toSeconds() && t <= finish.toSeconds() ) return true;
        return false;
    }
    
    
    public void cleanupEvents() {
        if (overstyle==null) return;
        for (int i = 0 ; i < overstyle.length-1 ; i++) {    // Ignore last "unknown" event
            if (overstyle[i]!=null) {
                overstyle[i].cleanupEvents(style.get(i), subtext);
            }
        }
    }
    
    public void addOverStyle(SubStyle.Style type, Object value, int start) {
        getStyleover(type).add(value, start);
    }
    
    public void setOverStyle(SubStyle.Style type, Object value, int start, int end) {
        getStyleover(type).addEvent(value,  start, end, style.get(type.ordinal()), subtext);
    }
    
    private AbstractStyleover getStyleover(SubStyle.Style type) {
        // Create style array, if it doesn't exist
        if (overstyle==null) overstyle = new AbstractStyleover[styleover_template.length];
        
        // Create style array, if it doesn't exist
        int idx = type.ordinal();
        if (overstyle[idx] == null) {
            overstyle[idx] = (AbstractStyleover)styleover_template[idx].clone();
            overstyle[idx].setStyleType(styleover_template[idx].getStyleType());
        }
        return overstyle[idx];
    }
    
    public void applyAttributesToDocument(JTextPane pane) {
        pane.setBackground((Color)style.get(SubStyle.Style.SHADOW));
        pane.setCaretColor((Color)style.get(SubStyle.Style.SECONDARY));
        for (int i = 0 ; i < styleover_template.length ; i++ ) {
            if (overstyle==null || overstyle[i] == null)
                StyleoverCharacter.applyAttributesToDocument(pane.getStyledDocument(), style.get(i), styleover_template[i], subtext.length());
            else
                overstyle[i].applyAttributesToDocument(pane.getStyledDocument(), style.get(i), subtext.length());
        }
    }
    
    public void insertText(int start, int length) {
        for (int i = 0 ; i < styleover_template.length ; i++ ) {
            if (overstyle!=null && overstyle[i] != null) {
                overstyle[i].insertText(start, length);
            }
        }
    }
    
    public void removeText(int start, int length) {
        for (int i = 0 ; i < styleover_template.length ; i++ ) {
            if (overstyle!=null && overstyle[i] != null) {
                overstyle[i].removeText(start, length, subtext.length(), style.get(i), subtext);
            }
        }
    }
    
    public void resetOverStyle() {
        overstyle = null;
    }
}