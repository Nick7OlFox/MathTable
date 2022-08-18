/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Bruno
 * 
 * DISCLAIMER
 * The code of this class was written based of the code posted on stack overflow by the user "Rajapandian"
 * This code can be found in the link bellow
 * https://stackoverflow.com/questions/1525444/how-to-connect-sqlite-with-java (Accessed December 2021)
 */

// Import relevant libraries
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database 
{
    private String directory;
    
    // Constructor to the database class
    public Database()
    {
        
        // This code was written based of code found on stack overflow on the link bellow
        // https://stackoverflow.com/questions/14209085/how-to-define-a-relative-path-in-java
        // First we need to get the database directory
        String path = System.getProperty("user.dir");
        
        path = (path + "@database@Database.db");
        path = path.replace("\\", "\\\\");
        path = path.replace("@", "\\\\");
        directory = ("jdbc:sqlite:" + path);
        
    }
    
    public boolean register(Player p)
    {
        // This method is to register the player into the database
        // First we have to connect to the database
        Connection conn = null;
        // We also need to declare the variable to store the querry
        Statement statement = null;
        
        try
        {
            conn = DriverManager.getConnection(directory);
            
            System.out.println("INSERT INTO Players VALUES (\"" + p.getUserName() + "\", \"" + p.getPassword() + "\", \"" + p.getCountry() + "\", false, false, false, false, false, false, false, false, false, false, false, false, false, false, 0, 0);");
            // Now that the connection was established we need to prepare the querry
            statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO Players VALUES (\"" + p.getUserName() + "\", \"" + p.getPassword() + "\", \"" + p.getCountry() + "\", false, false, false, false, false, false, false, false, false, false, false, false, false, false, 0, 0);"); 
        
            // Once the method has been executed, whether it succeds or not, we need to close the connection
            try
            {
                conn.close();
                statement.close();
            }
            catch (Exception er)
            {
                er.printStackTrace();
            }
            
            System.out.println("true");
            return true;
        }
        
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            
            // Once the method has been executed, whether it succeds or not, we need to close the connection
            try
            {
                conn.close();
                statement.close();
            }
            catch (Exception er)
            {
                er.printStackTrace();
            }
            
            System.out.println("false");
            return false;
        }    
    }
    
    public boolean checkUsername(String uN)
    {
        // This method is used to check wether or not the username is already registered
        // First we have to establish a connection to the database
        Connection conn = null;
        // We also need to declare a variable to store the querry and the resultSet
        Statement statement = null;
        ResultSet resultSet = null;
        // Lastly we need to declare a local variable to store the value we're gonna return
        Boolean isAvailable = null;
        try
        {
            conn = DriverManager.getConnection(directory);
            
            // Now that the connection was established we need to prepare the querry
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT COUNT(UserName) FROM Players WHERE UserName=\""+uN+"\";");
            
            System.out.println("SELECT COUNT(UserName) FROM Players WHERE UserName=\""+uN+"\";");
            System.out.println(resultSet.getInt("COUNT(UserName)"));
            // Now that we've pulled the data we need to compare it
            if(resultSet.getInt("COUNT(UserName)") == 0)
            {
                // If there's no match, then it is safe to assume the username is available
                System.out.println("true");
                isAvailable = true;
            }
            else
            {
                // If the username already exists then we set the variable as false
                System.out.println("false");
                isAvailable = false;
            }
            
            // Once the method has been executed, whether it succeds or not, we need to close the connection
            try
            {
                conn.close();
                statement.close();
                resultSet.close();
            }
            catch (Exception er)
            {
                er.printStackTrace();
            }
            
        
            // Lastly, we return the value of the variable
            return isAvailable;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            
            // If the connection to the database fails then we set the boolean as false to prevent wrong data from going to the database
            System.out.println("trueerror");
            isAvailable = true;
            
            // Once the method has been executed, whether it succeds or not, we need to close the connection
            try
            {
                conn.close();
                statement.close();
                resultSet.close();
            }
            catch (Exception er)
            {
                er.printStackTrace();
            }
            
            // Lastly, we return the value of the variable
            return isAvailable;
        }
    }
    
    public boolean logIn(Player p)
    {
        System.out.println("LogIN");
        // This method is to get the account data
        // First we have to connect to the database
        Connection conn = null;
        // We also need to declare the variable to store the querry, and one to read the data
        Statement statement = null;
        ResultSet resultSet = null;
        try
        {
            System.out.println("SELECT Password FROM Players WHERE UserName=\"" + p.getUserName() + "\";");
            conn = DriverManager.getConnection(directory);
            
            // Now that the connection was established we need to prepare the querry
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT Password FROM Players WHERE UserName=\"" + p.getUserName() + "\";");
            
            // Now that we've pulled the database associated with that Username
            if(resultSet.getString("Password").equals(p.getPassword()))
            {
                System.out.println("SELECT * FROM Players WHERE UserName=\"" + p.getUserName() + "\";");
                // If the passwords match then we can pull the rest of the data
                resultSet = statement.executeQuery("SELECT * FROM Players WHERE UserName=\"" + p.getUserName() + "\";");
                
                // Now we need to set the parameters of the player object according to the database
                p.setCountry(resultSet.getString("Country"));
                p.setE2(resultSet.getBoolean("E2"));
                p.setE3(resultSet.getBoolean("E3"));
                p.setE4(resultSet.getBoolean("E4"));
                p.setE5(resultSet.getBoolean("E5"));
                p.setE6(resultSet.getBoolean("E6"));
                p.setE7(resultSet.getBoolean("E7"));
                p.setE8(resultSet.getBoolean("E8"));

                p.setH2(resultSet.getBoolean("H2"));
                p.setH3(resultSet.getBoolean("H3"));
                p.setH4(resultSet.getBoolean("H4"));
                p.setH5(resultSet.getBoolean("H5"));
                p.setH6(resultSet.getBoolean("H6"));
                p.setH7(resultSet.getBoolean("H7"));
                p.setH8(resultSet.getBoolean("H8"));
                
                p.setGamesPlayed(resultSet.getInt("Played"));
                p.setGamesWon(resultSet.getInt("Won"));
                
                // Now that we have all of the data we need from the database we can let the OppeningForm class prepare the window to display the player's personal profile
                resultSet.close();
                statement.close();
                conn.close();
                
                return true;
            }
            
            else
            {
                return false;
            }
        }
        
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    } 
    
    public void unlockLevel(String lID, String uN)
    {
        // This method is to unlock the levels
        // First we have to connect to the database
        Connection conn = null;
        // We also need to declare the variable to store the querry
        Statement statement = null;
        try
        {
            conn = DriverManager.getConnection(directory);
            
            // Now that the connection was established we need to prepare the querry
            statement = conn.createStatement();
            statement.executeQuery("UPDATE Players SET " + lID + "=true WHERE UserName=\""+ uN + "\";");
            
            statement.close();
            conn.close();
        }
        
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void played(Player p)
    {
        // This method is to unlock the levels
        // First we have to connect to the database
        Connection conn = null;
        // We also need to declare the variable to store the querry
        Statement statement = null;
        try
        {
            conn = DriverManager.getConnection(directory);
            
            // Now that the connection was established we need to prepare the querry
            statement = conn.createStatement();
            statement.executeQuery("UPDATE Players SET Played=\"" + p.getGamesPlayed() + "\" WHERE UserName=\""+ p.getUserName() + "\";");
            
            statement.close();
            conn.close();
        }
        
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void won(Player p)
    {
        // This method is to unlock the levels
        // First we have to connect to the database
        Connection conn = null;
        // We also need to declare the variable to store the querry
        Statement statement = null;
        try
        {
            conn = DriverManager.getConnection(directory);
            
            // Now that the connection was established we need to prepare the querry
            statement = conn.createStatement();
            statement.executeQuery("UPDATE Players SET Won=\"" + p.getGamesWon() + "\" WHERE UserName=\""+ p.getUserName() + "\";");
            
            statement.close();
            conn.close();
        }
        
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
