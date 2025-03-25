package TicTacToePC;

public class TicTacToe {
    private char[][] field = {{' ',' ',' '}, {' ',' ',' '}, {' ',' ',' '}};
    private int turn=1;
    private boolean tie = false;

    void fieldShow(){
        for(char[] x : field){
            int count=0;
            for(char y : x){
                System.out.print(y);
                if(count==0 | count==1) System.out.print(" | "); //Print '|' only after the 1st and 2nd cells
                count++;
            }
            System.out.print("\n");
        }
    }

    void userTurn(int x, int y){
        --x; --y; //Input coordinates are larger by 1 for user convenience => Decrease the coordinates by 1
        if(validation(x, y)){
            field[y][x]=(turn%2!=0) ? 'O' : 'X'; //For PvP; odd turns are always 'O', even - 'X' <= 'O' is always first turn
            ++turn;
        }
    }

    void PCTurn(){
        if(turn!=10) {
            int[] PCturn = TTTPC.pcTurn(field); //Get PC cell cords
            int x = PCturn[1];
            int y = PCturn[0];
            if(validation(x, y)) {
                field[y][x] = 'X';
                ++turn;
            }
        }
    }

    private boolean validation(int x, int y){
        boolean rez;
        if((x < 0 || x > 2) | (y < 0 || y > 2)){
            System.out.println("You have gone beyond the boundaries of the field!");
            rez = false;
        } else {
            if(field[y][x]!=' '){
                System.out.println("This cell is occupied!");
                rez = false;
            } else rez = true;
        }
        return rez;
    }

    boolean gameOver(){
        for(int i=0; i<3; i++){ //For all 3 rows and columns
            if(checkLine(field[i][0], field[i][1], field[i][2])) return true; //Check row
            if(checkLine(field[0][i], field[1][i], field[2][i])) return true; //Check column
        }
        if(checkLine(field[0][0], field[1][1], field[2][2])) return true; //Check main diagonal
        if(checkLine(field[2][0], field[1][1], field[0][2])) return true;//Check second diagonal
        //Check for tie
        if(turn==10) tie=true;
        return false; //Game is not over
    }

    private boolean checkLine(char a, char b, char c) {
        return a == b && b == c && a != ' '; //Winning condition: all symbols are identical and not empty
    }

    void checkWinner(){
        if(turn%2==0 && !tie) System.out.println("Winner: O");
        else if(turn%2!=0 && !tie) System.out.println("Winner: X");
        else System.out.println("Tie");
    }
}
