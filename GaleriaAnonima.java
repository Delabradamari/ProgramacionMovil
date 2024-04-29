/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.galeriaanonima;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GaleriaAnonima extends JFrame {
    String[] arregloI = {"imagen01.jpg", "imagen02.jpg", "imagen03.jpg"};
    int actualI;
    JPanel pi, pb;
    JButton btnAtras, btnAdelante;

    public GaleriaAnonima() {
        setTitle("GaleriaAnonima");setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pi = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    BufferedImage i = ImageIO.read(getClass().getResource(arregloI[actualI]));
                     if (i != null) {
                g.drawImage(i, 0, 0, getWidth(), getHeight(), null);
            } else {
                System.out.println("Error: No se pudo cargar la imagen.");
            }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        btnAdelante = new JButton("Siguiente");
        btnAtras = new JButton("Anterior");

        btnAdelante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualI = (actualI + 1) % arregloI.length;
                pi.repaint();
            }
        });

        btnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualI = (actualI - 1 + arregloI.length) % arregloI.length;
                pi.repaint();
            }
        });

        add(pi, BorderLayout.CENTER);
        pb = new JPanel();
        pb.add(btnAtras);
        pb.add(btnAdelante);
        add(pb, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        GaleriaAnonima ga; 
        ga = new GaleriaAnonima();
        ga.setVisible(true);
    }
}