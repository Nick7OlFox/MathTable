/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Bruno
 */
public class Level 
{
    // Declare parameters that store the information about the level
    private String levelID, difficulty, sign;
    private Integer n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, n13, n14, n15;
    
    // Class constructor
    public Level(String id, String dif, String s, int nn1, int nn2, int nn3, int nn4, int nn5, int nn6, int nn7, int nn8, int nn9, int nn10, int nn11, int nn12, int nn13, int nn14, int nn15)
    {
        levelID = id;
        difficulty = dif;
        sign = s;
        n1 = nn1;
        n2 = nn2;
        n3 = nn3;
        n4 = nn4;
        n5 = nn5;
        n6 = nn6;
        n7 = nn7;
        n8 = nn8;
        n9 = nn9;
        n10 = nn10;
        n11 = nn11;
        n12 = nn12;
        n13 = nn13;
        n14 = nn14;
        n15 = nn15;
    }
    
    public void PrepareWindow(OpeningForm game)
    {
        // Write level information on the label
        // First we need to trim the level ID so we only get the level number
        char number = levelID.charAt(0);
        
        // Then we can set the label
        game.levelLabel.setText("<html>Level " + difficulty + " | " + number + "</html>");
        
        // Now we put the sign on it's square and set it as non editable
        game.signSquare.setText(sign);
        game.signSquare.setEditable(false);
        
        // Restart Check Answer Button
        game.checkBtn.setText("Check Answers");
        
        // Make sure there's no level information to be displayed
        game.levelInformationLabel.setText("");
        
        // Depending on the difficulty of the game we'll set the game window as necessary
        if(difficulty.equals("Easy"))
        {
            // If the level is on the easy difficulty, then the player will have to calculate the number of the outside colums
            // For this reason, the squares 1, 2, 3, 4, 8, and 12 will not be able to be edited by the player
            game.number1Square.setEditable(false);
            game.number2Square.setEditable(false);
            game.number3Square.setEditable(false);
            game.number4Square.setEditable(false);
            game.number8Square.setEditable(false);
            game.number12Square.setEditable(false);
            
            // Now we place the numbers on their respective places
            game.number1Square.setText(n1.toString());
            game.number2Square.setText(n2.toString());
            game.number3Square.setText(n3.toString());
            game.number4Square.setText(n4.toString());
            game.number8Square.setText(n8.toString());
            game.number12Square.setText(n12.toString());
            
            // Next we make sure the squares the player is suposed to edit, 5, 6, 7, 9, 10, 11, 13, 14, and 15 are empty and editable
            game.number5Square.setText("");
            game.number5Square.setEditable(true);
            game.number6Square.setText("");
            game.number6Square.setEditable(true);
            game.number7Square.setText("");
            game.number7Square.setEditable(true);
            game.number9Square.setText("");
            game.number9Square.setEditable(true);
            game.number10Square.setText("");
            game.number10Square.setEditable(true);
            game.number11Square.setText("");
            game.number11Square.setEditable(true);
            game.number13Square.setText("");
            game.number13Square.setEditable(true);
            game.number14Square.setText("");
            game.number14Square.setEditable(true);
            game.number15Square.setText("");
            game.number15Square.setEditable(true);
            
            // The final step before the window is ready to be presented, we have to change the colours of the components to the correct ones
            // Since the game is on the "Easy" difficulty, then we set the colour of the level to red
            game.goBackBtn.setBackground(new java.awt.Color(204, 0, 0));
            game.signSquare.setBackground(new java.awt.Color(204, 0, 0));
            game.number1Square.setBackground(new java.awt.Color(204, 0, 0));
            game.number1Square.setForeground(new java.awt.Color(255, 255, 255));
            game.number2Square.setBackground(new java.awt.Color(204, 0, 0));
            game.number2Square.setForeground(new java.awt.Color(255, 255, 255));
            game.number3Square.setBackground(new java.awt.Color(204, 0, 0));
            game.number3Square.setForeground(new java.awt.Color(255, 255, 255));
            game.number4Square.setBackground(new java.awt.Color(204, 0, 0));
            game.number4Square.setForeground(new java.awt.Color(255, 255, 255));
            game.number5Square.setForeground(new java.awt.Color(0, 0, 0));
            game.number5Square.setBackground(new java.awt.Color(255, 255, 255));
            game.number6Square.setBackground(new java.awt.Color(255, 255, 255));
            game.number6Square.setForeground(new java.awt.Color(0, 0, 0));
            game.number7Square.setBackground(new java.awt.Color(255, 255, 255));
            game.number7Square.setForeground(new java.awt.Color(0, 0, 0));
            game.number8Square.setBackground(new java.awt.Color(204, 0, 0));
            game.number8Square.setForeground(new java.awt.Color(255, 255, 255));
            game.number9Square.setBackground(new java.awt.Color(255, 255, 255));
            game.number9Square.setForeground(new java.awt.Color(0, 0, 0));
            game.number10Square.setBackground(new java.awt.Color(255, 255, 255));
            game.number10Square.setForeground(new java.awt.Color(0, 0, 0));
            game.number11Square.setBackground(new java.awt.Color(255, 255, 255));
            game.number11Square.setForeground(new java.awt.Color(0, 0, 0));
            game.number12Square.setBackground(new java.awt.Color(204, 0, 0));
            game.number12Square.setForeground(new java.awt.Color(255, 255, 255));
            game.number13Square.setBackground(new java.awt.Color(255, 255, 255));
            game.number13Square.setForeground(new java.awt.Color(0, 0, 0));
            game.number14Square.setBackground(new java.awt.Color(255, 255, 255));
            game.number14Square.setForeground(new java.awt.Color(0, 0, 0));
            game.number15Square.setBackground(new java.awt.Color(255, 255, 255));
            game.number15Square.setForeground(new java.awt.Color(0, 0, 0));
            game.checkBtn.setBackground(new java.awt.Color(204, 0, 0));
        }
        
        else
        {
            // If the level is on the hard difficulty, then the player will have to calculate the number of the inside
            // For this reason, the squares 5, 6, 7, 9, 10, 11, 13, 14, and 15 will not be able to be edited by the player
            game.number5Square.setEditable(false);
            game.number6Square.setEditable(false);
            game.number7Square.setEditable(false);
            game.number9Square.setEditable(false);
            game.number10Square.setEditable(false);
            game.number11Square.setEditable(false);
            game.number13Square.setEditable(false);
            game.number14Square.setEditable(false);
            game.number15Square.setEditable(false);
            
            
            // Now we place the numbers on their respective places
            game.number5Square.setText(n5.toString());
            game.number6Square.setText(n6.toString());
            game.number7Square.setText(n7.toString());
            game.number9Square.setText(n9.toString());
            game.number10Square.setText(n10.toString());
            game.number11Square.setText(n11.toString());
            game.number13Square.setText(n13.toString());
            game.number14Square.setText(n14.toString());
            game.number15Square.setText(n15.toString());
            
            // Next we make sure the squares the player is suposed to edit, 1, 2, 3, 4, 8, and 12 are empty and editable
            game.number1Square.setText("");
            game.number1Square.setEditable(true);
            game.number2Square.setText("");
            game.number2Square.setEditable(true);
            game.number3Square.setText("");
            game.number3Square.setEditable(true);
            game.number4Square.setText("");
            game.number4Square.setEditable(true);
            game.number8Square.setText("");
            game.number8Square.setEditable(true);
            game.number12Square.setText("");
            game.number12Square.setEditable(true);
            
            // The final step before the window is ready to be presented, we have to change the colours of the components to the correct ones
            // Since the game is on the "Hard" difficulty, then we set the colour of the level to blue
            game.goBackBtn.setBackground(new java.awt.Color(0, 0, 204));
            game.signSquare.setBackground(new java.awt.Color(0, 0, 204));
            game.number1Square.setBackground(new java.awt.Color(255, 255, 255));
            game.number1Square.setForeground(new java.awt.Color(0, 0, 0));
            game.number2Square.setBackground(new java.awt.Color(255, 255, 255));
            game.number2Square.setForeground(new java.awt.Color(0, 0, 0));
            game.number3Square.setBackground(new java.awt.Color(255, 255, 255));
            game.number3Square.setForeground(new java.awt.Color(0, 0, 0));
            game.number4Square.setBackground(new java.awt.Color(255, 255, 255));
            game.number4Square.setForeground(new java.awt.Color(0, 0, 0));
            game.number5Square.setBackground(new java.awt.Color(0, 0, 204));
            game.number5Square.setForeground(new java.awt.Color(255, 255, 255));
            game.number6Square.setBackground(new java.awt.Color(0, 0, 204));
            game.number6Square.setForeground(new java.awt.Color(255, 255, 255));
            game.number7Square.setBackground(new java.awt.Color(0, 0, 204));
            game.number7Square.setForeground(new java.awt.Color(255, 255, 255));
            game.number8Square.setBackground(new java.awt.Color(255, 255, 255));
            game.number8Square.setForeground(new java.awt.Color(0, 0, 0));
            game.number9Square.setBackground(new java.awt.Color(0, 0, 204));
            game.number9Square.setForeground(new java.awt.Color(255, 255, 255));
            game.number10Square.setBackground(new java.awt.Color(0, 0, 204));
            game.number10Square.setForeground(new java.awt.Color(255, 255, 255));
            game.number11Square.setBackground(new java.awt.Color(0, 0, 204));
            game.number11Square.setForeground(new java.awt.Color(255, 255, 255));
            game.number12Square.setBackground(new java.awt.Color(255, 255, 255));
            game.number12Square.setForeground(new java.awt.Color(0, 0, 0));
            game.number13Square.setBackground(new java.awt.Color(0, 0, 204));
            game.number13Square.setForeground(new java.awt.Color(255, 255, 255));
            game.number14Square.setBackground(new java.awt.Color(0, 0, 204));
            game.number14Square.setForeground(new java.awt.Color(255, 255, 255));
            game.number15Square.setBackground(new java.awt.Color(0, 0, 204));
            game.number15Square.setForeground(new java.awt.Color(255, 255, 255));
            game.checkBtn.setBackground(new java.awt.Color(0, 0, 204));
        }
    }

    // Getters and Setters for all of the parametres
    public String getLevelID() {
        return levelID;
    }

    public void setLevelID(String levelID) {
        this.levelID = levelID;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }

    public int getN3() {
        return n3;
    }

    public void setN3(int n3) {
        this.n3 = n3;
    }

    public int getN4() {
        return n4;
    }

    public void setN4(int n4) {
        this.n4 = n4;
    }

    public int getN5() {
        return n5;
    }

    public void setN5(int n5) {
        this.n5 = n5;
    }

    public int getN6() {
        return n6;
    }

    public void setN6(int n6) {
        this.n6 = n6;
    }

    public int getN7() {
        return n7;
    }

    public void setN7(int n7) {
        this.n7 = n7;
    }

    public int getN8() {
        return n8;
    }

    public void setN8(int n8) {
        this.n8 = n8;
    }

    public int getN9() {
        return n9;
    }

    public void setN9(int n9) {
        this.n9 = n9;
    }

    public int getN10() {
        return n10;
    }

    public void setN10(int n10) {
        this.n10 = n10;
    }

    public int getN11() {
        return n11;
    }

    public void setN11(int n11) {
        this.n11 = n11;
    }

    public int getN12() {
        return n12;
    }

    public void setN12(int n12) {
        this.n12 = n12;
    }

    public int getN13() {
        return n13;
    }

    public void setN13(int n13) {
        this.n13 = n13;
    }

    public int getN14() {
        return n14;
    }

    public void setN14(int n14) {
        this.n14 = n14;
    }

    public int getN15() {
        return n15;
    }

    public void setN15(int n15) {
        this.n15 = n15;
    }
    
    // Method to compare the answers
    public Boolean checkAnswers(Level player, OpeningForm game)
    {
        // To check if the answers are correct we're gonna compare the answers the player introduced with the correct answers
        // Before that let's declare a variable to store whether or not there was any wrong answer
        // We'll set the parameter as true and change it in case there is a wrong answer
        Boolean allCorrect = true;
        
        // First we need to check the difficulty to see what values we have to check
        if(difficulty.equals("Easy"))
        {         
            // If the level is on the "Easy" difficulty, then we have to check numbers 5, 6, 7, 9, 10, 11, 13, 14, and 15
            // Before we start the proccess we have to make the answers final by making the boxes non editable
            game.number5Square.setEditable(false);
            game.number6Square.setEditable(false);
            game.number7Square.setEditable(false);
            game.number9Square.setEditable(false);
            game.number10Square.setEditable(false);
            game.number11Square.setEditable(false);
            game.number13Square.setEditable(false);
            game.number14Square.setEditable(false);
            game.number15Square.setEditable(false);
            
            // Check number 5
            if(n5 == player.getN5())
            {
                // If the answer in the number 5 is correct then turn number to green, and play sound to indicate it's correct
                game.number5Square.setForeground(new java.awt.Color(0, 204, 0));
            }
            else
            {
                // If the answer in the number 5 is incorrect then we turn the number to red, and play the sound to indicate the wrong answer
                game.number5Square.setForeground(new java.awt.Color(204, 0, 0));
                
                // Since the asnwer was wrong then we have to change the Boolean allCorrect to false
                allCorrect =false;
            }
            
            // Check number 6
            if(n6 == player.getN6())
            {
                // If the answer in the number 6 is correct then turn number to green, and play sound to indicate it's correct
                game.number6Square.setForeground(new java.awt.Color(0, 204, 0)); 
            }
            else
            {
                // If the answer in the number 6 is incorrect then we turn the number to red, and play the sound to indicate the wrong answer
                game.number6Square.setForeground(new java.awt.Color(204, 0, 0));
                
                // Since the asnwer was wrong then we have to change the Boolean allCorrect to false
                allCorrect =false;
            }
            
            // Check number 7
            if(n7 == player.getN7())
            {
                // If the answer in the number 7 is correct then turn number to green, and play sound to indicate it's correct
                game.number7Square.setForeground(new java.awt.Color(0, 204, 0)); 
            }
            else
            {
                // If the answer in the number 7 is incorrect then we turn the number to red, and play the sound to indicate the wrong answer
                game.number7Square.setForeground(new java.awt.Color(204, 0, 0));
                
                // Since the asnwer was wrong then we have to change the Boolean allCorrect to false
                allCorrect =false;
            }
            
            // Check number 9
            if(n9 == player.getN9())
            {
                // If the answer in the number 9 is correct then turn number to green, and play sound to indicate it's correct
                game.number9Square.setForeground(new java.awt.Color(0, 204, 0)); 
            }
            else
            {
                // If the answer in the number 9 is incorrect then we turn the number to red, and play the sound to indicate the wrong answer
                game.number9Square.setForeground(new java.awt.Color(204, 0, 0));
                
                // Since the asnwer was wrong then we have to change the Boolean allCorrect to false
                allCorrect =false;
            }
            
            // Check number 10
            if(n10 == player.getN10())
            {
                // If the answer in the number 10 is correct then turn number to green, and play sound to indicate it's correct
                game.number10Square.setForeground(new java.awt.Color(0, 204, 0)); 
            }
            else
            {
                // If the answer in the number 10 is incorrect then we turn the number to red, and play the sound to indicate the wrong answer
                game.number10Square.setForeground(new java.awt.Color(204, 0, 0));
                
                // Since the asnwer was wrong then we have to change the Boolean allCorrect to false
                allCorrect =false;
            }
            
            // Check number 11
            if(n11 == player.getN11())
            {
                // If the answer in the number 11 is correct then turn number to green, and play sound to indicate it's correct
                game.number11Square.setForeground(new java.awt.Color(0, 204, 0)); 
            }
            else
            {
                // If the answer in the number 11 is incorrect then we turn the number to red, and play the sound to indicate the wrong answer
                game.number11Square.setForeground(new java.awt.Color(204, 0, 0));
                
                // Since the asnwer was wrong then we have to change the Boolean allCorrect to false
                allCorrect =false;
            }
            
            // Check number 13
            if(n13 == player.getN13())
            {
                // If the answer in the number 13 is correct then turn number to green, and play sound to indicate it's correct
                game.number13Square.setForeground(new java.awt.Color(0, 204, 0)); 
            }
            else
            {
                // If the answer in the number 13 is incorrect then we turn the number to red, and play the sound to indicate the wrong answer
                game.number13Square.setForeground(new java.awt.Color(204, 0, 0));
                
                // Since the asnwer was wrong then we have to change the Boolean allCorrect to false
                allCorrect =false;
            }
            
            // Check number 14
            if(n14 == player.getN14())
            {
                // If the answer in the number 14 is correct then turn number to green, and play sound to indicate it's correct
                game.number14Square.setForeground(new java.awt.Color(0, 204, 0)); 
            }
            else
            {
                // If the answer in the number 14 is incorrect then we turn the number to red, and play the sound to indicate the wrong answer
                game.number14Square.setForeground(new java.awt.Color(204, 0, 0));
                
                // Since the asnwer was wrong then we have to change the Boolean allCorrect to false
                allCorrect =false;
            }
            
            // Check number 15
            if(n15 == player.getN15())
            {
                // If the answer in the number 15 is correct then turn number to green, and play sound to indicate it's correct
                game.number15Square.setForeground(new java.awt.Color(0, 204, 0)); 
            }
            else
            {
                // If the answer in the number 15 is incorrect then we turn the number to red, and play the sound to indicate the wrong answer
                game.number15Square.setForeground(new java.awt.Color(204, 0, 0));
                
                // Since the asnwer was wrong then we have to change the Boolean allCorrect to false
                allCorrect =false;
            }
        }
        else
        {
            // If the level is on the "Hard" difficulty, then we have to check number 1, 2, 3, 4, 8, and 12
            // Before we start the proccess we have to make the answers final by making the boxes non editable
            game.number1Square.setEditable(false);
            game.number2Square.setEditable(false);
            game.number3Square.setEditable(false);
            game.number4Square.setEditable(false);
            game.number8Square.setEditable(false);
            game.number12Square.setEditable(false);
            
            // Check number 1
            if(n1 == player.getN1())
            {
                // If the answer in the number 1 is correct then turn number to green, and play sound to indicate it's correct
                game.number1Square.setForeground(new java.awt.Color(0, 204, 0)); 
            }
            else
            {
                // If the answer in the number 1 is incorrect then we turn the number to red, and play the sound to indicate the wrong answer
                game.number1Square.setForeground(new java.awt.Color(204, 0, 0));
                
                // Since the asnwer was wrong then we have to change the Boolean allCorrect to false
                allCorrect =false;
            }
            
            // Check number 2
            if(n2 == player.getN2())
            {
                // If the answer in the number 2 is correct then turn number to green, and play sound to indicate it's correct
                game.number2Square.setForeground(new java.awt.Color(0, 204, 0)); 
            }
            else
            {
                // If the answer in the number 2 is incorrect then we turn the number to red, and play the sound to indicate the wrong answer
                game.number2Square.setForeground(new java.awt.Color(204, 0, 0));
                
                // Since the asnwer was wrong then we have to change the Boolean allCorrect to false
                allCorrect =false;
            }
            
            // Check number 3
            if(n3 == player.getN3())
            {
                // If the answer in the number 3 is correct then turn number to green, and play sound to indicate it's correct
                game.number3Square.setForeground(new java.awt.Color(0, 204, 0)); 
            }
            else
            {
                // If the answer in the number 3 is incorrect then we turn the number to red, and play the sound to indicate the wrong answer
                game.number3Square.setForeground(new java.awt.Color(204, 0, 0));
                
                // Since the asnwer was wrong then we have to change the Boolean allCorrect to false
                allCorrect =false;
            }
            
            // Check number 4
            if(n4 == player.getN4())
            {
                // If the answer in the number 4 is correct then turn number to green, and play sound to indicate it's correct
                game.number4Square.setForeground(new java.awt.Color(0, 204, 0)); 
            }
            else
            {
                // If the answer in the number 4 is incorrect then we turn the number to red, and play the sound to indicate the wrong answer
                game.number4Square.setForeground(new java.awt.Color(204, 0, 0));
                
                // Since the asnwer was wrong then we have to change the Boolean allCorrect to false
                allCorrect =false;
            }
            
            // Check number 8
            if(n8 == player.getN8())
            {
                // If the answer in the number 8 is correct then turn number to green, and play sound to indicate it's correct
                game.number8Square.setForeground(new java.awt.Color(0, 204, 0)); 
            }
            else
            {
                // If the answer in the number 8 is incorrect then we turn the number to red, and play the sound to indicate the wrong answer
                game.number8Square.setForeground(new java.awt.Color(204, 0, 0));
                
                // Since the asnwer was wrong then we have to change the Boolean allCorrect to false
                allCorrect =false;
            }
            
            // Check number 12
            if(n12 == player.getN12())
            {
                // If the answer in the number 12 is correct then turn number to green, and play sound to indicate it's correct
                game.number12Square.setForeground(new java.awt.Color(0, 204, 0)); 
            }
            else
            {
                // If the answer in the number 12 is incorrect then we turn the number to red, and play the sound to indicate the wrong answer
                game.number12Square.setForeground(new java.awt.Color(204, 0, 0));
                
                // Since the asnwer was wrong then we have to change the Boolean allCorrect to false
                allCorrect =false;
            }
        }
        
        // After we checked all of the answers we have to return a value 
        // Since what matters is whether or not all of the answers are correct them we just return the paramenter "allCorrect"
        return allCorrect;
    }
}
