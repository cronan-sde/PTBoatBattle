package com.vfw.game;

import com.vfw.users.HumanPlayer;
import com.vfw.users.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SayHello extends JFrame {

   // private JButton comeInButton = new JButton("OK");
    private JLabel nameLabel = new JLabel("Human Opponent Name:");
    private JTextField nameField = new JTextField(15);
    private JButton ok = new JButton("OK");
    private JLabel messageLabel = new JLabel();
    private Player player;

    public SayHello(){
        super("Hello New Player");
        //new SayHello().setVisable(true);
        setVisible(true);
        buildUI();
        setFrameOptions();
        ok.addActionListener(new InnerListener());

    }
    private void buildUI(){
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(2,2));
        pane.add(nameLabel);
        pane.add(nameField);
        pane.add(ok);
        pane.add(messageLabel);
    }
    private void setFrameOptions(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
    }
    private class InnerListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(nameField != null){
                // TODO uncomment out after merging with package that has below attribute in it
                player = new HumanPlayer(nameField.getText());
                player.setName(nameField.getText());
                messageLabel.setText("Welcome  " + nameField.getText());
            } else {
                messageLabel.setText("Sorry I didn't get that, you will just be HumanPlayer");
            }
            nameField.setText("");

        }
    }



}
