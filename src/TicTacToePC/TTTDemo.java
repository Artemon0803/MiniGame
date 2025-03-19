package TicTacToePC;

import java.util.Scanner;

public class TTTDemo {
    static void PvP(){
        TicTacToe game = new TicTacToe();
        Scanner scanner = new Scanner(System.in);
        int x, y;
        System.out.println("Welcome to TicTacToe game!\nFirst turn as: O");
        game.fieldShow();
        do{
            System.out.print("Enter x position: ");
            x=scanner.nextInt();
            System.out.print("Enter y position: ");
            y=scanner.nextInt();
            game.userTurn(x, y);
            game.fieldShow();
        } while(!game.gameOver());
        System.out.println("Game Over!");
        System.out.println(game.checkWinner());
    }

    static void PvPC(){
        TicTacToe game = new TicTacToe();
        Scanner scanner = new Scanner(System.in);
        int x, y;
        System.out.println("Welcome to TicTacToe game!\nYou play as O\nFirst turn as: O");
        game.fieldShow();
        do{
            System.out.print("Enter x position: ");
            x=scanner.nextInt();
            System.out.print("Enter y position: ");
            y=scanner.nextInt();
            System.out.println("Your turn:");
            game.userTurn(x, y);
            game.fieldShow();
            System.out.println("PC's turn:");
            game.PCTurn();
            game.fieldShow();
        } while(!game.gameOver());
        System.out.println("Game Over!");
        System.out.println(game.checkWinner());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mode;

        System.out.println("Choose game mode\n1-PvP\n2-PvPC: ");
        mode=scanner.nextInt();

        if(mode==1) PvP();
        else if(mode==2) PvPC();
        else System.out.println("Please enter existing option!");
    }
}
