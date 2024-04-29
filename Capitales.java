/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.capitales;

/**
 *
 * @author dany_
 */
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Capitales extends JFrame implements ActionListener{
    // el hashmap es importante
    HashMap<String, String> edocap;
    //String ArrEstado [] ={"Sonora","Ciudad de Mexico"};
    //String ArrCapital []={"Hermosillo","CDMX"};    
    JComboBox<String> estados;
    JLabel cap;
    JPanel panel;
   
    public Capitales(){
        setTitle("Estados y Capitales");
        setSize(300,100);
        setDefaultCloseOperation(3);
       
        edocap = new HashMap<>();
        edocap.put("Sonora","Hermosillo");
        edocap.put("Ciudad de Mexico","CDMX");
        edocap.put("Edo de Mexico", "Toluca");
        edocap.put("Guadalajara", "Jalisco");
        edocap.put("Monterrey", "Nuevo Leon");
       
       
        estados = new JComboBox<>();
        // al Jcomboboc podemos asignarle mas elementos
        for(String e : edocap.keySet()){
            estados.addItem(e);
        }
       
        //estados = new JComboBox<>();
        //for(String e : ArrEstado){
        //    estados.addItem(e);
        //}
        /*
        for(int i=0;i<ArrEstado.length;i++){
            estados.addItem(ArrEstado[i]);
        }
        */
       
        estados.addActionListener(this);
       
        cap = new JLabel();
       
        panel = new JPanel( new BorderLayout());
        panel.add(estados, BorderLayout.NORTH);
        panel.add(cap, BorderLayout.SOUTH);
        add(panel);
    }//fin constructor
   
    public static void main(String[] args) {
        Capitales c = new Capitales();
        c.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        String estadoSelec = (String)estados.getSelectedItem();
        System.out.println(estadoSelec);
        String capitalSelec = edocap.get(estadoSelec);
        System.out.println(capitalSelec);
        cap.setText(capitalSelec);        
       
        /*
        int estadoSelec = (int)estados.getSelectedIndex();
        System.out.println(estadoSelec);
        cap.setText(ArrCapital[estadoSelec]);
        */
    }
}