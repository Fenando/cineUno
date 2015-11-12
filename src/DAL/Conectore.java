/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fernando
 */
public class Conectore{
    Connection conn;

    public Conectore() {
    this.getConection();
    }
    
    
    public void getConection(){
        String bd = "cine";
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/"+bd,"root","");
            System.out.println("work");
        } catch (SQLException ex) {
            Logger.getLogger(Conectore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Statement getStatement(){
        
        try {
            return conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Conectore.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
   
    }
     public static void main(String[] args) {
        new Conectore();
    }
}
