package Hotel.Management.System;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;

public class login4 {
    login4(){
        JFrame jFrame = new JFrame();

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/login_new.gif"));
        Image i1 = imageIcon.getImage().getScaledInstance(255,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(525,150,255,300);
        jFrame.add(label);

        //Header
        JLabel jLabel = new JLabel("Login Page");
        jLabel.setBounds(0,0,800,100);
        jLabel.setBackground(new Color(1,150,10));
        jLabel.setForeground(Color.BLACK);
        jLabel.setFont(new Font("Serif",Font.LAYOUT_LEFT_TO_RIGHT,50));
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel.setOpaque(true);

        //User Id
        JLabel userid = new JLabel("User ID");
        userid.setForeground(Color.WHITE);
        userid.setBounds(100,150,100,20);
        userid.setFont(new Font("Serif",Font.BOLD,20));

        JTextField userid2 = new JTextField();

        userid2.setBounds(100,180,400,40);
        userid2.setFont(new Font("Serif",Font.BOLD,20));

        //Password
        JLabel password = new JLabel("Password");
        password.setForeground(Color.WHITE);
        password.setBounds(100,250,100,20);
        password.setFont(new Font("Serif",Font.BOLD,20));

        JPasswordField password2 = new JPasswordField();
        password2.setBounds(100,280,400,40);
        password2.setFont(new Font("Serif",Font.BOLD,20));


        //participants or organizer selection
        JLabel userType = new JLabel("Select User Type : ");
        userType.setForeground(Color.WHITE);
        userType.setBounds(100,330,300,40);
        userType.setFont(new Font("Serif",Font.BOLD,20));

        //combobox
        String userType1[] = {"User","Admin"};
        JComboBox jComboBox = new JComboBox(userType1);
        jComboBox.setBounds(280,340,220,30);
        jComboBox.setBackground(new Color(154,255,204));


        //submit button
        JButton jButton = new JButton("Submit");
        jButton.setBounds(250,440,100,30);
        jButton.setBackground(new Color(1,150,10));
        jButton.setFont(new Font("Serif",Font.BOLD,20));

        //dont hava account option
        JLabel account = new JLabel("Don't have an account ? ");
        account.setForeground(Color.WHITE);
        account.setBounds(100,500,200,30);
        account.setFont(new Font("Font",Font.PLAIN,15));

        JButton creatAccountButton = new JButton("Create account");
        creatAccountButton.setBounds(290,510,150,20);
        creatAccountButton.setBackground(new Color(154,255,204));



        jFrame.add(jLabel);
        jFrame.add(userid);
        jFrame.add(userid2);
        jFrame.add(password);
        jFrame.add(password2);
        jFrame.add(jButton);
        jFrame.add(account);
        jFrame.add(creatAccountButton);
        jFrame.add(userType);
        jFrame.add(jComboBox);

        //submit button actionlistner
        jButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jComboBox.getSelectedItem()=="User")
                {
                    try {
                        con c = new con();
                        String user = userid2.getText();
                        String pass = new String(password2.getPassword());
                        String q = "select * from login where username = '"+user+"' and password = '"+pass+"'";
                        ResultSet resultSet = c.statement.executeQuery(q);
                        if (resultSet.next()){
                            new userDashboard();
                            jFrame.setVisible(false);
                           jFrame.dispose();
                        }else {
                            JOptionPane.showMessageDialog(null,"Invalid");
                        }

                    }catch (Exception E){
                        E.printStackTrace();
                    }
                }
                else {

                    try {
                        con c = new con();
                        String user = userid2.getText();
                        String pass = password2.getText();

                        String q = "select * from login2 where user_name = '"+user+"' and password = '"+pass+"'";
                        ResultSet resultSet = c.statement.executeQuery(q);
                        if (resultSet.next()){
                            new Dashboard();
                            jFrame.setVisible(false);
                            jFrame.dispose();
                        }else {
                            JOptionPane.showMessageDialog(null,"Invalid");
                        }

                    }catch (Exception E){
                        E.printStackTrace();
                    }
                }
            }
        });


        //createAccountButton action listner
        creatAccountButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new createAccount();
            }
        });

        jFrame.setLayout(null);
        jFrame.getContentPane().setBackground(new Color(3,45,48));
        jFrame.setBounds(400,100,800,600);
        jFrame.setVisible(true);

        // jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String args[]){
        new login4();
    }
}