package Hotel.Management.System;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import java.util.Date;

public class BookTable extends JFrame {
    static class NumericDocumentFilter extends DocumentFilter {
        @Override
        public void insertString(DocumentFilter.FilterBypass fb, int offset, String text,
                                 AttributeSet attr) throws BadLocationException {
            if (text.matches("\\d+")) {
                super.insertString(fb, offset, text, attr);
            }
        }

        @Override
        public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text,
                            AttributeSet attrs) throws BadLocationException {
            if (text.matches("\\d+")) {
                super.replace(fb, offset, length, text, attrs);
            }
        }
    }
    BookTable(){


        JPanel panel = new JPanel();
        panel.setBounds(5,5,940,550);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/booking_menu.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500,60,300,300);
        panel.add(label);



        JLabel label1  = new JLabel("Book Table");
        label1.setBounds(124,11,222,25);
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        JLabel label2  = new JLabel("Customer ID :");
        label2.setBounds(25,88,150,14);
        label2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        Choice c = new Choice();
        c.setBounds(248,85,140,20);
        panel.add(c);

        try {
            con C = new con();
            ResultSet resultSet = C.statement.executeQuery("select * from customer");
            while (resultSet.next()){
                c.add(resultSet.getString("number"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label3  = new JLabel("Table Number :");
        label3.setBounds(25,129,107,14);
        label3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        Choice c2 = new Choice();
        c2.setBounds(248,129,140,20);
        panel.add(c2);

        try {
            con C = new con();
            ResultSet resultSet = C.statement.executeQuery("select * from table_s where avail = 'Available'");
            while (resultSet.next()){
                c2.add(resultSet.getString("number"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label4  = new JLabel("Veg Meal(Quantity):");
        label4.setBounds(25,174,150,14);
        label4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JTextField textField4 = new JTextField();
        textField4.setBounds(248,174,140,20);
        panel.add(textField4);

        ((AbstractDocument) textField4.getDocument()).setDocumentFilter(new NumericDocumentFilter());

        JLabel label5  = new JLabel("Egg Meal(Quantity):");
        label5.setBounds(25,219,150,14);
        label5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        JTextField textField5 = new JTextField();
        textField5.setBounds(248,219,140,20);
        panel.add(textField5);

        ((AbstractDocument) textField5.getDocument()).setDocumentFilter(new NumericDocumentFilter());

        JLabel label6  = new JLabel("Fish Meal(Quantity):");
        label6.setBounds(25,264,150,14);
        label6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label6.setForeground(Color.WHITE);
        panel.add(label6);

        JTextField textField6 = new JTextField();
        textField6.setBounds(248,264,140,20);
        panel.add(textField6);

        ((AbstractDocument) textField6.getDocument()).setDocumentFilter(new NumericDocumentFilter());

        JLabel label7  = new JLabel("Chicken Meal(Quantity):");
        label7.setBounds(25,309,150,14);
        label7.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label7.setForeground(Color.WHITE);
        panel.add(label7);

        JTextField textField7 = new JTextField();
        textField7.setBounds(248,309,140,20);
        panel.add(textField7);

        ((AbstractDocument) textField7.getDocument()).setDocumentFilter(new NumericDocumentFilter());

        JLabel label8  = new JLabel("Mutton Meal(Quantity):");
        label8.setBounds(25,354,150,14);
        label8.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label8.setForeground(Color.WHITE);
        panel.add(label8);

        JTextField textField8 = new JTextField();
        textField8.setBounds(248,354,140,20);
        panel.add(textField8);

        ((AbstractDocument) textField8.getDocument()).setDocumentFilter(new NumericDocumentFilter());

        JLabel label9  = new JLabel("A-la Carte Meal(Quantity):");
        label9.setBounds(25,399,150,14);
        label9.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label9.setForeground(Color.WHITE);
        panel.add(label9);

        JTextField textField9 = new JTextField();
        textField9.setBounds(248,399,140,20);
        panel.add(textField9);

        ((AbstractDocument) textField9.getDocument()).setDocumentFilter(new NumericDocumentFilter());


        JButton schedule = new JButton("Book");
        schedule.setBounds(112,450,89,23);
        schedule.setBackground(Color.BLACK);
        schedule.setForeground(Color.WHITE);
        panel.add(schedule);
        schedule.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    con C  = new con();
                    String q = "update table_s set avail= 'Occupied' where number = '"+c2.getSelectedItem()+"'";
                    C.statement.executeUpdate(q);
                    String customer=c.getSelectedItem();
                    String table=c2.getSelectedItem();
                    String id=customer+"-"+table;
                    int veg,egg,fish,chicken,mutton,ala;
                     veg=Integer.parseInt(textField4.getText());
                     egg=Integer.parseInt(textField5.getText());
                     fish=Integer.parseInt(textField6.getText());
                     chicken=Integer.parseInt(textField7.getText());
                     mutton=Integer.parseInt(textField8.getText());
                     ala=Integer.parseInt(textField9.getText());
                    q="insert into booking values ('"+id+"','"+customer+"','"+table+"',"+veg+","+egg+","+fish+","+chicken+","+mutton+","+ala+")";
                    C.statement.executeUpdate(q);
                    JOptionPane.showMessageDialog(null, "Booked Successfully");
                    setVisible(false);
                    dispose();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });



        JButton back = new JButton("Back");
        back.setBounds(218,450,89,23);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
            }
        });



        setLayout(null);
        setSize(950,550);
        setLocation(400,200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new BookTable();
    }
}
