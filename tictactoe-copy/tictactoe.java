
import java.util.Scanner;
public class tictactoe
{
    static String turn = "X";
    static int Roundnumber = 1;
    static String[][] grid = new String[3][3];
    static Scanner scan = new Scanner(System.in);
    static int winner = -1;

    public static void main(String[]args){
        PlayGame();
    }

    public static void PrintGameBoard(String[][] grid){
        System.out.println("Round "+Roundnumber+ ":");
        for(int row = 0; row<grid.length; row++){
            for(int col = 0; col<grid[0].length; col++){
                if(Roundnumber == 1){
                    grid[row][col] = "[ ]";
                }
                System.out.print(grid[row][col]);
            }
            System.out.println();
        }

    }

    public static void MakeMove(){
        System.out.print(turn+" make your move(row,col):");
        String move = scan.nextLine();
        String r = move.substring(0,1);
        String c = move.substring(2);
        int row = Integer.parseInt(r);
        int col = Integer.parseInt(c);
        //System.out.println(row);
        //System.out.println(col);
        if(row > 3 || row < 0 || col > 3 || col < 0){
            System.out.println("Try Again.");
            MakeMove();
        }
        else if(turn.equals("X") && grid[row][col] == "[ ]"){
            grid[row][col] = "[X]";
            turn = "O";
        }
        else if(turn.equals("O") && grid[row][col] == "[ ]"){
            grid[row][col] = "[O]";
            turn = "X";
        }
        
        else {
            System.out.println("Try Again.");
           MakeMove(); 
        }
        
        Roundnumber +=1;

    }

    public static void CheckWinner(){
        //check rows
        for(int row = 0; row<grid.length; row++){
            for(int col = 0; col<grid[0].length-2; col++){
                if(grid[row][col] == "[X]" && grid[row][col+1] == "[X]" && grid[row][col+2] == "[X]"){
                    winner = 1;
                    AfterGameOver();
                }
                else if(grid[row][col] == "[O]" && grid[row][col+1] == "[O]" && grid[row][col+2] == "[O]"){
                    winner = 2;
                    AfterGameOver();
                }
            }
        }
        //check columns
        for(int col = 0; col<grid[0].length; col++){
            for(int row = 0; row<grid.length-2; row++){
                if(grid[row][col] == "[X]" && grid[row+1][col] == "[X]" && grid[row+2][col] == "[X]"){
                    winner = 1;
                    AfterGameOver();
                }
                else if(grid[row][col] == "[O]" && grid[row+1][col] == "[O]" && grid[row+2][col] == "[O]"){
                    winner = 2;
                    AfterGameOver();
                }
            }
        }
        CheckDiagonals();
        if(isTie()){
            winner = 0;
            AfterGameOver();
        }
    }

    public static void CheckDiagonals(){
        if(grid[0][0] == "[X]" && grid[1][1] == "[X]" && grid[2][2] == "[X]"){
            winner = 1;
            AfterGameOver();
        }
        if(grid[0][0] == "[O]" && grid[1][1] == "[O]" && grid[2][2] == "[O]"){
            winner = 2;
            AfterGameOver();
        }
        if(grid[2][0] == "[X]" && grid[1][1] == "[X]" && grid[0][2] == "[X]"){
            winner = 1;
            AfterGameOver();
        }
        if(grid[2][0] == "[O]" && grid[1][1] == "[O]" && grid[0][2] == "[O]"){
            winner = 2;
            AfterGameOver();
        }
    }
    public static boolean isTie(){
          for(int row = 0; row<grid.length; row++){
            for(int col = 0; col<grid[0].length; col++){
                if(grid[row][col] != "[X]" || grid[row][col] != "[O]") return false;
            }
        }
            return true;  
    }

    public static void AfterGameOver(){
        if(winner == 1){
            System.out.println("X WON THE GAME!");
        }
        else if(winner == 2){
            System.out.println("O WON THE GAME!");
        }
        else if(winner == 0){
            System.out.println("IT'S A TIE!");
        }
        PrintGameBoard(grid);
        System.out.print("PLAY AGAIN? Y/N:");
        String choice = scan.nextLine();
        if(choice.equals("Y")){
            winner = -1;
            Roundnumber = 1;
            turn = "X";
            PlayGame();
        }
        else System. exit(0);
    }

    public static void PlayGame(){
        while(winner < 0){
            PrintGameBoard(grid);
            CheckWinner();
            MakeMove();
            
        }
    }
}
