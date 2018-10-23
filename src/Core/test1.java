/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Ch4L1sT
 */
public class test1 {
    
   static Database.Connections connect = new Database.Connections();
   static Connection con = connect.get_Connections();
   static ResultSet res = null;
   static PreparedStatement pre = null;
    public static void main(String[] args) {
        //fill
        try {
            String sql = "INSERT INTO 'users' "
                        + "('Eid')"
                        + " VALUES('E001') ";
            pre=con.prepareStatement(sql);
            pre.executeQuery();
            

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
                try {
                    //res.close();
                    pre.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }   
     }
    
}
