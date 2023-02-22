package vehicleidentificationsystem.system;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class AddVehicle extends JFrame implements ActionListener{
    
    Random ran = new Random();
    int number = ran.nextInt(999999);
    
    JTextField tfownername, tfmodel, tfaddress, tfphone, tfaadhar, tfemail,tfcustomerid, tfmakeyear, tfdesignation, tfchallan, tfregno;
    JButton add, back;
    
    AddVehicle() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Vehicle Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        JLabel labelname = new JLabel("Owner Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        
        tfownername = new JTextField();
        tfownername.setBounds(210, 150, 150, 30);
        add(tfownername);
        
        JLabel labelmodel = new JLabel("Model");
        labelmodel.setBounds(400, 150, 150, 30);
        labelmodel.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelmodel);
        
        tfmodel = new JTextField();
        tfmodel.setBounds(600, 150, 150, 30);
        add(tfmodel);
        
        JLabel labelCID = new JLabel("CustomerID");
        labelCID.setBounds(50, 200, 150, 30);
        labelCID.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelCID);
        
        tfcustomerid = new JTextField();
        tfcustomerid.setBounds(210, 200, 150, 30);
        add(tfcustomerid);
        
        JLabel labelmakeyear = new JLabel("Make Year");
        labelmakeyear.setBounds(400, 200, 150, 30);
        labelmakeyear.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelmakeyear);
        
        tfmakeyear = new JTextField();
        tfmakeyear.setBounds(600, 200, 150, 30);
        add(tfmakeyear);
        
        JLabel labeladdress = new JLabel("Owner Address");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(210, 250, 150, 30);
        add(tfaddress);
        
        JLabel labelphone = new JLabel("Mobile Number");
        labelphone.setBounds(400, 250, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 300, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(210, 300, 150, 30);
        add(tfemail);
        
        JLabel labelchallan = new JLabel("No. of Challans");
        labelchallan.setBounds(400, 300, 150, 30);
        labelchallan.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelchallan);
        
        tfchallan = new JTextField();
        tfchallan.setBounds(600, 300, 150, 30);
        add(tfchallan);
        
        
        JLabel labeloccupation = new JLabel("Owner Occupation");
        labeloccupation.setBounds(50, 350, 150, 30);
        labeloccupation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeloccupation);
        
        tfdesignation = new JTextField();
        tfdesignation.setBounds(210, 350, 150, 30);
        add(tfdesignation);
        
        JLabel labelaadhar = new JLabel("Aadhar Number");
        labelaadhar.setBounds(400, 350, 150, 30);
        labelaadhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(600, 350, 150, 30);
        add(tfaadhar);
        
        JLabel labelRegno = new JLabel("Reg No");
        labelRegno.setBounds(50, 400, 150, 30);
        labelRegno.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelRegno);
        
        tfregno = new JTextField();
        tfregno.setBounds(210, 400, 150, 30);
        add(tfregno);
        
        add = new JButton("Add Details");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String ownername = tfownername.getText();
            String model  = tfmodel.getText();
            String customerid = tfcustomerid.getText();
            String makeyear = tfmakeyear.getText();
            String owneraddress = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String noofchallans = tfchallan.getText();
            String owneroccupation = tfdesignation.getText();
            String aadhar = tfaadhar.getText();
            String regno = tfregno.getText();
            
            try {
                Conn conn = new Conn();
                String query = "insert into vehicle values('"+ownername+"', '"+model+"', '"+customerid+"', '"+makeyear+"', '"+owneraddress+"', '"+phone+"', '"+email+"', '"+noofchallans+"','"+owneroccupation+"', '"+aadhar+"', '"+regno+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new AddVehicle();
    }
}
