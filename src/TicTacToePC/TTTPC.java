package TicTacToePC;

import java.util.Random;

public class TTTPC {
    static int[] pcTurn(char[][] field){
        int count=0;//Empty cells counter
        //Get all empty cells cords
        int[][] emptyCells = new int[9][2];//EmptyCell[number of cell(not in field)][cell cords(x, y)]
        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++){
                if(field[i][j]==' ') {
                    emptyCells[count][0]=i;
                    emptyCells[count][1]=j;
                    ++count;
                }
            }
        //--------------------
        //Choose random cell
        Random random = new Random();
        int cell=random.nextInt(count);
        return emptyCells[cell]; //Return cell cords
    }
}
