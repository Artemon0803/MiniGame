package TicTacToePC;

import java.util.Scanner;

public class TTTDemo {
    private static void PvP(){ //Player vs Player
        TicTacToe game = new TicTacToe();
        Scanner scanner = new Scanner(System.in);
        System.out.println("You play as O\nFirst turn: O");
        game.fieldShow();
        do{
            int tmp, x, y;
            System.out.print("Enter x and y like (11) position: ");
            tmp=scanner.nextInt();
            x=tmp/10;
            y=tmp%10;
            /*System.out.print("Enter x position: ");
            x=scanner.nextInt();
            System.out.print("Enter y position: ");
            y=scanner.nextInt();*/
            game.userTurn(x, y);
            game.fieldShow();
        } while(!game.gameOver());
        System.out.println("Game Over!");
        game.checkWinner();
    }

    private static void PvPC(){ //Player vs PC
        TicTacToe game = new TicTacToe();
        Scanner scanner = new Scanner(System.in);
        System.out.println("You play as O\nFirst turn: O");
        game.fieldShow();
        do{
            int tmp, x, y;
            System.out.print("Enter x and y like (11) position: ");
            tmp=scanner.nextInt();
            x=tmp/10;
            y=tmp%10;
            /*System.out.print("Enter x position: ");
            x=scanner.nextInt();
            System.out.print("Enter y position: ");
            y=scanner.nextInt();*/
            System.out.println("Your turn:");
            game.userTurn(x, y);
            game.fieldShow();
            if(game.gameOver()) break;
            System.out.println("PC's turn:");
            game.PCTurn();
            game.fieldShow();
        } while(!game.gameOver());
        System.out.println("Game Over!");
        game.checkWinner();
    }

    public static void main(String[] args) { //Start
        Scanner scanner = new Scanner(System.in);
        int mode;

        System.out.println("Welcome to TicTacToe game!\nChoose game mode:\n1-PvP\n2-PvPC ");
        mode=scanner.nextInt();

        if(mode==1) PvP();
        else if(mode==2) PvPC();
        else System.out.println("Please enter existing option!");
    }
}
