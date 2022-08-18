
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Bruno
 */
public class Player 
{
    // Declare the parameters to store the data for this class
    String userName, password, country;
    double gamesPlayed, gamesWon;
    
    // These Booleans are meant to store wether or not the player has unlocked the levels
    Boolean e2,e3,e4,e5,e6,e7,e8,h2,h3,h4,h5,h6,h7,h8;
    
    // Create variable to store the database object that we will use to registert and log in
    Database db = new Database();

    //Constructor
    public Player(String uN, String p)
    {
        userName = uN;
        password = p;
        gamesPlayed=0;
        gamesWon=0;
    }
    
    public void gamePlayed()
    {
        gamesPlayed++;
        db.played(this);
    }
    
    public void gameWon()
    {
        gamesWon++;
        db.won(this);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public double getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    public Boolean getE2() {
        return e2;
    }

    public void setE2(Boolean e2) {
        this.e2 = e2;
    }

    public Boolean getE3() {
        return e3;
    }

    public void setE3(Boolean e3) {
        this.e3 = e3;
    }

    public Boolean getE4() {
        return e4;
    }

    public void setE4(Boolean e4) {
        this.e4 = e4;
    }

    public Boolean getE5() {
        return e5;
    }

    public void setE5(Boolean e5) {
        this.e5 = e5;
    }

    public Boolean getE6() {
        return e6;
    }

    public void setE6(Boolean e6) {
        this.e6 = e6;
    }

    public Boolean getE7() {
        return e7;
    }

    public void setE7(Boolean e7) {
        this.e7 = e7;
    }

    public Boolean getE8() {
        return e8;
    }

    public void setE8(Boolean e8) {
        this.e8 = e8;
    }

    public Boolean getH2() {
        return h2;
    }

    public void setH2(Boolean h2) {
        this.h2 = h2;
    }

    public Boolean getH3() {
        return h3;
    }

    public void setH3(Boolean h3) {
        this.h3 = h3;
    }

    public Boolean getH4() {
        return h4;
    }

    public void setH4(Boolean h4) {
        this.h4 = h4;
    }

    public Boolean getH5() {
        return h5;
    }

    public void setH5(Boolean h5) {
        this.h5 = h5;
    }

    public Boolean getH6() {
        return h6;
    }

    public void setH6(Boolean h6) {
        this.h6 = h6;
    }

    public Boolean getH7() {
        return h7;
    }

    public void setH7(Boolean h7) {
        this.h7 = h7;
    }

    public Boolean getH8() {
        return h8;
    }

    public void setH8(Boolean h8) {
        this.h8 = h8;
    }
    
    // Method to create new account
    public void createAccount()
    {
        // Declare boolean to store wether or not we can proceed to the next check
        // First step is to check the availability of the username
        // To check if the username is available we're going to try to pull it from the database
        // If it succeds then we have that username on the database already
        System.out.println("Check Username");
        if(db.checkUsername(userName))
        {
            
            // After the username is available then we can procceed and check the password
            // There are a few restrictions on the password
            // It has to be longer than 4 characters long
            // It can only contain uppercase, lowercase, special character, and number
            // First we check for the length
            System.out.println(password);
            System.out.println(password.length());
            if(password.length()>=4)
            {
                System.out.println("Check Password");
                // If the password has the correct size we can check if it has lowercase, uppercase, and numbers
                // Declare the variables needed to check the password
                char ch;
                boolean hasUppercase = false;
                boolean hasLowercase = false;
                boolean hasNumber = false;
                boolean hasOther = false;

                // Create a for loop to check all of the characters of the password
                // The loop is gonna have a variable that is gonna increase every time one character is checked
                // When the variable equals the number of characters it means the program has checked every character
                for(int cIndex = 0; cIndex < password.length(); cIndex++)
                {
                    // First we have to get the specific character
                    ch = password.charAt(cIndex);

                    // Check for lowercase
                    if(Character.isLowerCase(ch))
                    {
                        // If the character is lowercase then set the lowercase variable true
                        hasLowercase = true;
                        System.out.println("has lower case");
                    }

                    // Check for uppercase
                    else if(Character.isUpperCase(ch))
                    {
                        // If the character is uppercase then set the uppercase variable to true
                        hasUppercase = true;
                        System.out.println("has upper case");
                    }

                    // Check for numbers
                    else if(Character.isDigit(ch))
                    {
                        // If the character is a number then set the number variable to true
                        hasNumber = true;
                        System.out.println("has diggit");
                    }

                    // If the character isn't any of the ones above then we set the other variable to true so it invalidates the password
                    else
                    {
                        hasOther = true;
                        System.out.println("hasOther");
                    }
                }

                // After we finish checking  all of the characters let's check if we can procceed or not
                if(hasLowercase && hasUppercase && hasNumber && hasOther)
                {
                    // If the password passed through every check then it can procceed to the next stage
                    
                    // The next step on the account creation is to get the country in which the player is
                    // To prevent the program to crash in case the Web-API service used to retrieve the country is down, then we're gonna use a try catch to get that information
                    try
                    {
                        // The web API used to retrieve the country will be the following
                        // https://ip-api.com/
                        
                        // This code was written based of code found on stack overflow on the link bellow
                        // https://stackoverflow.com/questions/309424/how-do-i-read-convert-an-inputstream-into-a-string-in-java
                        // First we need to get the IP address
                        URL ipAPI = new URL("https://api64.ipify.org/?format=json");
                        InputStream inputStream = ipAPI.openStream();
                        
                        // Now that we have that we're going to convert that input string into a string
                        String IP = new BufferedReader(new InputStreamReader(inputStream)).lines().collect(Collectors.joining("\n"));
                        IP = IP.replace("{", " ");
                        IP = IP.replace("\"", " ");
                        IP = IP.replace("ip", " ");
                        IP = IP.replace(":", " ");
                        IP = IP.replace("}", " ");
                        IP = IP.trim();
                        System.out.println("The IP is: " + IP);
                        
                        // The first step is to get an input stream with the our API 
                        System.out.println("IP: " + IP);
                        System.out.println("http://ip-api.com/line/" + IP + "?fields=country");
                        URL ipApi = new URL("http://ip-api.com/line/" + IP + "?fields=country");
                        InputStream inputStream2 = ipApi.openStream();
                        
                        // Now that we have that we're going to convert that input string into a string
                        String result = new BufferedReader(new InputStreamReader(inputStream2)).lines().collect(Collectors.joining("\n"));
                        System.out.println("The Country is: " + result);
                        
                        country = result;
                    }
                    catch(Exception e)
                    {
                        // In case the program fails, then the user is gonna have the code "NoCountry"
                        this.setCountry("NoCountry");
                    }
                    
                    // After we get the country then we just reset the game progression state and the player status
                    setE2(false);
                    setE3(false);
                    setE4(false);
                    setE5(false);
                    setE6(false);
                    setE7(false);
                    setE8(false);
                    
                    setH2(false);
                    setH3(false);
                    setH4(false);
                    setH5(false);
                    setH6(false);
                    setH7(false);
                    setH8(false);
                    
                    gamesPlayed = 0;
                    gamesWon = 0;
                    
                    // Now that we have the player object created we can save it to the database
                    if(db.register(this))
                    {
                        // After we register the new player then we need to log In
                        db.logIn(this);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "The program was unable to register you.");
                    }
                    
                }
                
                else
                {
                    JOptionPane.showMessageDialog(null, "The password is invalid.");
                }
            }
        }
        
        else
        {
            // If the username wasn't available then we throw an exception to stop the proceess and allow the player to change the details
            JOptionPane.showMessageDialog(null, "The Program wasn't able to register you.");
        }
    }
}
