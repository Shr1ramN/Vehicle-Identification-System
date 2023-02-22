package vehicleidentificationsystem.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateVehicle extends JFrame implements ActionListener{
    
    JTextField tfownername,tfcustomerid, tfchallan, tfmodel, tfaddress, tfphone, tfaadhar, tfemail, tfmakeyear, tfdesignation,tfregno;
    JButton add, back;
    String regno;
    
    UpdateVehicle(String regno) {
        this.regno = regno;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Update Vehicle Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        JLabel labelownername = new JLabel("Owner Name");
        labelownername.setBounds(50, 150, 150, 30);
        labelownername.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelownername);
        
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
        
        JLabel labelcustomerid = new JLabel("Customer ID");
        labelcustomerid.setBounds(50, 200, 150, 30);
        labelcustomerid.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelcustomerid);
        
        tfcustomerid = new JTextField();
        tfcustomerid.setBounds(210, 200, 150, 30);
        add(tfcustomerid);
        
        JLabel labelmakeyear = new JLabel("Make year");
        labelmakeyear.setBounds(400, 200, 150, 30);
        labelmakeyear.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelmakeyear);
        
        tfmakeyear = new JTextField();
        tfmakeyear.setBounds(600, 200, 150, 30);
        add(tfmakeyear);
        
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(210, 250, 150, 30);
        add(tfaddress);
        
        JLabel labelphone = new JLabel("Phone");
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
        
        JLabel labelnoofchallan = new JLabel("No of Challans");
        labelnoofchallan.setBounds(400, 300, 150, 30);
        labelnoofchallan.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelnoofchallan);
        
        tfchallan = new JTextField();
        tfchallan.setBounds(600, 300, 150, 30);
        add(tfchallan);
        
        JLabel labeldesignation = new JLabel("Occupation");
        labeldesignation.setBounds(50, 350, 150, 30);
        labeldesignation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldesignation);
        
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
        
        JLabel labelrego = new JLabel("Reg No");
        labelrego.setBounds(50, 400, 150, 30);
        labelrego.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelrego);
        
        tfregno = new JTextField();
        tfregno.setBounds(210, 400, 150, 30);
        add(tfregno);
        
        try {
            Conn c = new Conn();
            String query = "select * from vehicle where regno = '"+regno+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                tfownername.setText(rs.getString("Owner Name"));
                tfmodel.setText(rs.getString("Model"));
                tfcustomerid.setText(rs.getString("Customer ID"));
                tfaddress.setText(rs.getString("Address"));
                tfmakeyear.setText(rs.getString("Make year"));
                tfphone.setText(rs.getString("Phone"));
                tfemail.setText(rs.getString("Email"));
                tfchallan.setText(rs.getString("No of Challan"));
                tfaadhar.setText(rs.getString("Aadhar"));
                tfregno.setText(rs.getString("Reg No"));
                tfdesignation.setText(rs.getString("Occupation"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        add = new JButton("Update Details");
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
            String model = tfmodel.getText();
            String makeyear = tfmakeyear.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String challan = tfchallan.getText();
            String designation = tfdesignation.getText();
            
            try {
                Conn conn = new Conn();
                String query = "update vehicle set fname = '"+model+"', salary = '"+makeyear+"', address = '"+address+"', phone = '"+phone+"', email =  '"+email+"', no of challan = '"+challan+"', occupation = '"+designation+"' where regno = '"+regno+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
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
        new UpdateVehicle("");
    }
}
