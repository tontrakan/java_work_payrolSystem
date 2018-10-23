
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Connections {
    public static void main(String[] args) { 
        
        Connections cons = new Connections();
        Connection con = null;
        con=cons.get_Connections();
        if(con!=null){
            JOptionPane.showMessageDialog(null, "Conntected");
        }
        else{JOptionPane.showMessageDialog(null, "Conntect failed");}
        
        
    }
    
    public Connection get_Connections(){
       Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/employees_info","root","k41i");
            
        } catch (Exception e) {
            System.out.println(e);
        }
       return con;
    }
    
}
