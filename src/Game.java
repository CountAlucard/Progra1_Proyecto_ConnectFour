import java.util.Scanner;
   
//This will be.. a huge code so we will have to make
//lots of methods for each aspect of the game
public class Game
{
  //We need to first create the basic visual pattern 
  public static String[][] createPattern()
  {

    String[][] f = new String[7][15];

    for (int i =0;i<f.length;i++)
    {
       for (int j =0;j<f[i].length;j++)
      {
        if (j% 2 == 0) f[i][j] ="|";
        else f[i][j] = " ";
         
        //Time to make our lowest row
        if (i==6) f[i][j]= "-";
      }
       
    }
    return f;
  }
   

  public static void printPattern(String[][] f)
  {
    for (int i =0;i<f.length;i++)
    {
      for (int j=0;j<f[i].length;j++)
      {
        System.out.print(f[i][j]);
      }
      System.out.println();
    }
  }
   

  public static void dropRedPattern(String[][] f)
  {
    System.out.println("Player1 coloque una ficha roja en la columna (0–6): ");
    Scanner scan = new Scanner (System.in);
     

    int c = 2*scan.nextInt()+1;
    
    for (int i =5;i>=0;i--)
    {
      if (f[i][c] == " ")
      {
        f[i][c] = "R";
        break;
      }
       
    }
  }
   
  public static void dropYellowPattern(String[][] f)
  {
    System.out.println("Player2 coloque una ficha amarilla en la columna (0–6): ");
    Scanner scan = new Scanner (System.in);
    int c = 2*scan.nextInt()+1;
    for (int i =5;i>=0;i--)
    {
      if (f[i][c] == " ")
      {
        f[i][c] = "Y";
        break;
      }
       
    }
  }

  public static String checkWinner(String[][] f)
  {

    for (int i =0;i<6;i++)
    {
      for (int j=0;j<7;j+=2)
      {
        if ((f[i][j+1] != " ")
        && (f[i][j+3] != " ")
        && (f[i][j+5] != " ")
        && (f[i][j+7] != " ")
        && ((f[i][j+1] == f[i][j+3])
        && (f[i][j+3] == f[i][j+5])
        && (f[i][j+5] == f[i][j+7])))
 
        //If we found a same-colored pattern, we'll return 
        //the color so that we will know who won
          return f[i][j+1];  
      }
    }
     
    //For a vertical line,
    //Note: make sure you understand the horizontal line's
    //codes first or else everything below this point will 
    //make no sense to you
    for (int i=1;i<15;i+=2)
    {
      for (int j =0;j<3;j++)
      {
            if((f[j][i] != " ")
            && (f[j+1][i] != " ")
            && (f[j+2][i] != " ")
            && (f[j+3][i] != " ")
            && ((f[j][i] == f[j+1][i])
            && (f[j+1][i] == f[j+2][i])
            && (f[j+2][i] == f[j+3][i])))
              return f[j][i];  
      }  
    }
     
    //For the left-up to right-down diagonal line
    //We'll have to loop over the 3 uppermost
    //rows and then go from left to right column-wise
    for (int i=0;i<3;i++)
    {
       
      //As expected, our uppermost box will start from 1
      //and increase by 2 until it becomes 7 (the 3rd box
      //on a row)
      //Note how we used 1 instead 0 for the count here
      //There's no real reason to use 1 instead of 0 or 
      //vice versa, since we're still using an odd index
      //for the columns and incrementing by 2
      for (int j=1;j<9;j+=2)
      {
            if((f[i][j] != " ")
            && (f[i+1][j+2] != " ")
            && (f[i+2][j+4] != " ")
            && (f[i+3][j+6] != " ")
            && ((f[i][j] == f[i+1][j+2])
            && (f[i+1][j+2] == f[i+2][j+4])
            && (f[i+2][j+4] == f[i+3][j+6])))
              return f[i][j];  
      }  
    }
     
    //Similar to the method above, but we're just reversing our
    //trajectory, i.e. we're starting from the rightmost column
    //instead of the leftmost like we did above
    for (int i=0;i<3;i++)
    {
      for (int j=7;j<15;j+=2)
      {
            if((f[i][j] != " ")
            && (f[i+1][j-2] != " ")
            && (f[i+2][j-4] != " ")
            && (f[i+3][j-6] != " ")
            && ((f[i][j] == f[i+1][j-2])
            && (f[i+1][j-2] == f[i+2][j-4])
            && (f[i+2][j-4] == f[i+3][j-6])))
              return f[i][j];  
      }  
    }
     
    //If after going over the table and we find no
    //same colored lines, then we have to return something
    //that says that we didn't find a winning color :P
    return null;
  }
   
  //The easy part: using these methods
  public static void main (String[] args)
  {
    //Time to make a pattern
    String[][] f = createPattern();
    //Time to make a condition for our game to keep on
    //playing
    boolean loop = true;
    //We need something to keep track of whose turn it is
    int count = 0;
    printPattern(f);
    while(loop)
    {
       //Let's say that Red gets the first turn and thus
       //every other turn 
       if (count % 2 == 0) dropRedPattern(f);
       else dropYellowPattern(f);
       count++;//We need to keep track of the turns
       printPattern(f);
       //Let's say we want to check for a winner during every
       //turn made and say who it is
       if (checkWinner(f) != null)
       {
          if (checkWinner(f) == "R")
             System.out.println("Payer1(rojo) ha ganado.");
          else if (checkWinner(f)== "Y")
            System.out.println("Player2(amarillo) ha ganado.");
         //Well, if someone one, then the game has to end
         loop = false;
        }
  }
}
}
