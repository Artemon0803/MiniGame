package TicTacToePC;

import java.util.Random;

public class TTTPC {
    static int[] pcTurn(char[][] field){
        int[] turnCords = new int[2];
        int count=0;
        //Get all empty slots cords
        int[][] tmp = new int[9][2];
        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++){
                if(field[i][j]==' ') {
                    tmp[count][0]=i;
                    tmp[count][1]=j;
                    ++count;
                }
            }
        //--------------------
        //Choose random slot
        Random random = new Random();
        int slot=random.nextInt(count);
        //Set slot cords
        turnCords[0]=tmp[slot][0];
        turnCords[1]=tmp[slot][1];
        return turnCords; //Return slot cords
    }
}
