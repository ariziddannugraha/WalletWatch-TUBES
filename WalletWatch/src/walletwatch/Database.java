/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package walletwatch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author arizi
 */
public class Database {
    static final String DB_URL = "jdbc:mysql://localhost:3306/walletwatch";
    static final String DB_USER = "root";
    static final String DB_PASS = "";
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;

    public Database() throws SQLException{
        try{
            conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
            stmt = conn.createStatement();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,""+e.getMessage(),"Connection Error",JOptionPane.WARNING_MESSAGE);
        }
    }
    public ResultSet getData(String SQLString){
        try{
            rs = stmt.executeQuery(SQLString);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error :"+e.getMessage(),"Communication Error", JOptionPane.WARNING_MESSAGE);
        }
        return rs; 
   }
   public void insertData(String nim, String nama, String prodi){
       try{
           String sql = "INSERT INTO mahasiswa (nim, nama, prodi) VALUES (?, ?, ?)";
           PreparedStatement preparedStatement = conn.prepareStatement(sql);
           preparedStatement.setString(1, nim);
           preparedStatement.setString(2, nama);
           preparedStatement.setString(3, prodi);
           preparedStatement.executeUpdate();
           System.out.println("Data berhasil dimasukan ke dalam tabel");
       } catch (Exception e){
           System.out.println("Terdapat kesalahan saat proses memasukan data ke dalam table.");
       }
   }
     
    public ResultSet executeQuery(String SQLString){
        try{
            rs = stmt.executeQuery(SQLString);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error : " + e.getMessage(), "Communication Error", JOptionPane.WARNING_MESSAGE);
        }
        return rs;
    }
    
    public int executeUpdate(String sql) throws SQLException {
        int result = 0;
        try (Connection connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
            Statement statement = connection.createStatement()) {
            result = statement.executeUpdate(sql);
        }
        return result;
    }
}
