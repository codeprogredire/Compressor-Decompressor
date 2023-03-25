package GUI;

import comp_decomp.compressor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class AppFrame extends JFrame implements ActionListener {
    JButton compressButton;
    JButton decompressButton;

    AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        compressButton=new JButton("Select file to compress");
        compressButton.addActionListener(this);
        compressButton.setBounds(20,100,200,30);

        decompressButton=new JButton("Select file to decompress");
        decompressButton.addActionListener(this);
        decompressButton.setBounds(250,100,200,30);

        this.add(compressButton);
        this.add(decompressButton);
        this.setSize(500,200);
        this.getContentPane().setBackground(Color.gray);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==compressButton){
            JFileChooser filechooser=new JFileChooser();
            int response=filechooser.showSaveDialog(null);

            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    comp_decomp.compressor.method(file);

                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null, ee.toString());

                }
            }
        }
        if(e.getSource()==decompressButton){
            JFileChooser filechooser=new JFileChooser();
            int response=filechooser.showSaveDialog(null);

            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    comp_decomp.decompressor.method(file);

                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null, ee.toString());

                }
            }

        }
    }
}
