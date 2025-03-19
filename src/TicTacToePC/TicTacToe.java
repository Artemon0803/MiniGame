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
                if(count==0 | count==1) System.out.print(" | ");
                count++;
            }
            System.out.print("\n");
        }
    }

    void userTurn(int x, int y){
        --x; --y;
        if(validation(x, y)){
            field[y][x]=(turn%2!=0) ? 'O' : 'X';
            ++turn;
        }
    }

    void PCTurn(){
        if(turn!=10) {
            int[] PCturn = TTTPC.pcTurn(field); //Get PC slot cords
            int x = PCturn[1];
            int y = PCturn[0];
            if (validation(x, y)) {
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
                System.out.println("The field is occupied!");
                rez = false;
            } else rez = true;
        }
        return rez;
    }

    boolean gameOver(){
        int x=0, y=0;
        for(int i=0; i<3; i++){
            if(field[y+i][x]==field[y+i][x+1] & field[y+i][x]==field[y+i][x+2] & field[y+i][x]!=' ') return true;
            if(field[y][x+i]==field[y+1][x+i] & field[y][x+i]==field[y+2][x+i] & field[y][x+i]!=' ') return true;
        }
        if(field[y][x]==field[y+1][x+1] & field[y][x]==field[y+2][x+2] & field[y][x]!=' ') return true;
        if(field[y+2][x]==field[y+1][x+1] & field[y+2][x]==field[y][x+2] & field[y+2][x]!=' ') return true;
        if(turn==10) tie=true;
        return false;
    }

    String checkWinner(){
        if(turn%2==0 & !tie) return "Winner: O";
        else if(turn%2!=0 & !tie) return "Winner: X";
        else return "Tie";
    }
}
