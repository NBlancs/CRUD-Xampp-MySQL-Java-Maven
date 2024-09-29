package com.dentalform;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
             public static String driver = "com.mysql.cj.jdbc.Driver";
            public static String url = "jdbc:mysql://localhost:3306/dentalclinicdb";

            public static String username = "root";
            public static String password = "";
    
    // method to read all user
    public static void readAllUser(){
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
            
            String sql = "SELECT * FROM patient";
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                
                int id = rs.getInt("patientId");
                String fname = rs.getString("fname");
                String lname = rs.getString ("lname");
                String minitial = rs.getString ("minitial");
              
                System.out.println(id +" "+ fname +" "+ lname +" "+ minitial);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // method to insert user
    public static void insertUser(){
        try {
            Class.forName(driver);
            // step 2
            Connection con = DriverManager.getConnection(url, username, password);
            String sql = "INSERT INTO patient (fname, lname, minitial, age, gender, streetAddress, municipality, city, province, zipCode, medicalComplications, patientClassification, typeOfService) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "JanJan");
            ps.setString(2, "Blanco");
            ps.setString(3, "G.");
            ps.setInt(4, 21);
            ps.setString(5, "Male");
            ps.setString(6, "Islamic Village");
            ps.setString(7, "City of Malaybalay");
            ps.setString(8, "Malaybalay City");
            ps.setString(9, "Bukidnon");
            ps.setInt(10, 8700);
            ps.setString(11, "N/A");
            ps.setString(12, "Walk-in Patient");
            ps.setString(13, "Dental Cleaning");
            
            ps.executeUpdate();

            con.close();
            System.out.println("Patient Added");
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
    
    // method to delete user
    public static void deleteUser(){
        try {
            Class.forName(driver);
            // step 2
            Connection con = DriverManager.getConnection(url, username, password);
            String sql = "DELETE FROM patient WHERE patientId=?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, 7); // the value of id == 2

            ps.executeUpdate();
            con.close();
            System.out.println("Deleted Successfully");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // method to update user
    public static void updateUser(){
        try {
            Class.forName(driver);
            // step 2
            Connection con = DriverManager.getConnection(url, username, password);
            
            String sql = "UPDATE patient SET fname=?, lname=?, minitial=? WHERE patientId=7";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1,"Jhumel");
            ps.setString(2,"Gomez");
            ps.setString(3,"C.");
            
            ps.executeUpdate();
            con.close();
            
            System.out.println("Updated Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        readAllUser(); // --> reads all users
        //insertUser(); // --> insert user
        //updateUser(); // --> update user
        //deleteUser(); // --> delete user
    }

}