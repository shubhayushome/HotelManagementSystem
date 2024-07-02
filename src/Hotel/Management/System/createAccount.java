package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.Arrays;

public class createAccount {
    JFrame jFrame;
    createAccount(){
        jFrame = new JFrame();


        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/login_new.gif"));
        Image i1 = imageIcon.getImage().getScaledInstance(255,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(330,100,255,300);
        jFrame.add(label);
        //Header
        JLabel jLabel = new JLabel("Create User Account");
        jLabel.setBounds(0,0,675,50);
        jLabel.setBackground(new Color(1,150,10));
        jLabel.setForeground(Color.BLACK);
        jLabel.setFont(new Font("Serif",Font.LAYOUT_LEFT_TO_RIGHT,30));
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel.setOpaque(true);

        //name
        JLabel name = new JLabel("UserID");
        name.setBounds(50,110,100,20);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));

        //name TextBox
        JTextField jTextField = new JTextField();
        jTextField.setBounds(50,140,200,30);
        jTextField.setFont(new Font("Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));


        //phoneNo



        // Create Password
        JLabel createPassword = new JLabel("Create Password");
        createPassword.setBounds(50,180,200,20);
        createPassword.setForeground(Color.WHITE);
        createPassword.setFont(new Font("Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));

        JPasswordField createPaaword2 = new JPasswordField();
        createPaaword2.setBounds(50,210,200,30);
        createPaaword2.setFont(new Font("Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));

        // Confirm Password
        JLabel confirmPassword = new JLabel("Confirm Password");
        confirmPassword.setBounds(50,250,200,20);
        confirmPassword.setForeground(Color.WHITE);
        confirmPassword.setFont(new Font("Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));

        JPasswordField confirmPassword2 = new JPasswordField();
        confirmPassword2.setBounds(50,280,200,30);
        confirmPassword2.setFont(new Font("Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));




        //submit button
        JButton jButton = new JButton("Submit");
        jButton.setBounds(250,450,100,30);
        jButton.setBackground(new Color(1,150,10));



        jFrame.add(jLabel);
        jFrame.add(name);
        jFrame.add(jTextField);

        jFrame.add(createPassword);
        jFrame.add(createPaaword2);
        jFrame.add(confirmPassword);
        jFrame.add(confirmPassword2);

        jFrame.add(jButton);

        //submit button actionlistner
        jButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jTextField.getText().length() > 0  && createPaaword2.getPassword().length >= 8 && Arrays.equals(createPaaword2.getPassword(), confirmPassword2.getPassword())) {
                    con c= new con();
                    //System.out.println(createPaaword2.getPassword());
                    String pass = new String(createPaaword2.getPassword());
                    String q = "insert into login values ('"+jTextField.getText()+"','"+pass+"')";
                    try {
                        c.statement.executeUpdate(q);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    JOptionPane.showMessageDialog(null, "Your Account Created Successfully now login");
                    jFrame.setVisible(false);
                    jFrame.dispose();
                    //new login4();
                } else if (createPaaword2.getPassword().length < 8) {
                    JOptionPane.showMessageDialog(null, "Create a password with more then 8 character");

                } else if (!Arrays.equals(createPaaword2.getPassword(), confirmPassword2.getPassword())) {
                    JOptionPane.showMessageDialog(null, "Enter Confirm Password Correctly");
                }  else {
                    JOptionPane.showMessageDialog(null, "Enter All the Fields");
                }
            }


        });

        jFrame.setLayout(null);
        jFrame.getContentPane().setBackground(new Color(3,45,48));
        jFrame.setBounds(500,100,675,550);
        jFrame.setVisible(true);

        //jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String args[]){
        new createAccount();
    }


}