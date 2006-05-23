/*
 * AbstractPlayerOptions.java
 *
 * Created on 25 Σεπτέμβριος 2005, 2:07 πμ
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

import static com.panayotis.jubler.i18n.I18N._;
import com.panayotis.jubler.player.*;


import com.panayotis.jubler.options.OptionsIO;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
/**
 *
 * @author teras
 */
public class AbstractPlayerOptions extends ExtOptions {
    private JSpinner dx, dy;
    private JTextField args;
    private String args_value;
    private String args_default;
    private int x_value, y_value;
    
    /** Creates a new instance of AbstractPlayerOptions */
    public AbstractPlayerOptions(AbstractPlayer player) {
        super(player.getType(), player.getName());
        args_default = player.getDefaultArguments();
        
        if (args_value == null || args_value.equals("")) args_value = args_default;
        
        JPanel SpinP = new JPanel();
        SpinP.setLayout(new GridLayout(2,2));
        SpinnerModel sxmodel = new SpinnerNumberModel(0, -1000, 1000, 1);
        SpinnerModel symodel = new SpinnerNumberModel(0, -1000, 1000, 1);
        dx =  new JSpinner(sxmodel);
        dy =  new JSpinner(symodel);
        SpinP.add(new JLabel(_("X offset")));
        SpinP.add(new JLabel(_("Y offset")));
        SpinP.add(dx);
        SpinP.add(dy);
        
        JPanel HelpP = new JPanel();
        HelpP.setLayout(new GridLayout(4,1));
        HelpP.add(new JLabel());
        HelpP.add(new JLabel(_("Advanced argument list:")));
        HelpP.add(new JLabel("    %p=player %v=video_file %s=subtiles_file %t=start_time"));
        HelpP.add(new JLabel("    %x=x_offset %y=y_offset %f=font_name %z=font_size"));
        
        JPanel ArgsP = new JPanel();
        ArgsP.setLayout(new BorderLayout());
        args = new JTextField(40);
        JButton deflt = new JButton(_("Defaults"));
        ArgsP.add(HelpP, BorderLayout.NORTH);
        ArgsP.add(args, BorderLayout.CENTER);
        ArgsP.add(deflt, BorderLayout.EAST);
        
        deflt.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                args.setText(args_default);
            }
        });
        
        JPanel ExtrasP = new JPanel();
        ExtrasP.setLayout(new BorderLayout());
        ExtrasP.add(new JLabel(_("Player window offset in pixels")), BorderLayout.NORTH);
        ExtrasP.add(SpinP, BorderLayout.CENTER);
        ExtrasP.add(ArgsP, BorderLayout.SOUTH);
        
        resetOptions();
        add(ExtrasP, BorderLayout.NORTH);
    }
    
    protected void loadOptions() {
        super.loadOptions();
        Properties prefs = OptionsIO.getPrefFile();
        String values = prefs.getProperty("Player."+name+".WindowOffset", "(0,40)");
        int seperator = values.indexOf(',');
        x_value = Integer.parseInt(values.substring(1, seperator));
        y_value = Integer.parseInt(values.substring(seperator+1, values.length()-1));
        args_value = prefs.getProperty("Player."+name+".Arguments");
    }
    
    public void saveOptions() {
        super.saveOptions();
        Properties prefs = OptionsIO.getPrefFile();
        prefs.setProperty("Player."+name+".WindowOffset", "("+dx.getValue() + "," + dy.getValue()+")");
        prefs.setProperty("Player."+name+".Arguments", args.getText());
        OptionsIO.savePrefFile(prefs);
    }
    
    
    public void resetOptions() {
        super.resetOptions();
        dx.setValue(x_value);
        dy.setValue(y_value);
        args.setText(args_value);
    }
    
    
    public int getXOffset() { return (Integer)dx.getValue(); }
    public int getYOffset() { return (Integer)dy.getValue(); }
    public String getArguments() { return args.getText(); }
}