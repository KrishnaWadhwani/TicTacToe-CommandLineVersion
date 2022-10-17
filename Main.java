import java.util.Scanner;

public class TicTacToe {
    public static String board =
            " 1 | 2 | 3 \n" +
            "---|---|---\n" +
            " 4 | 5 | 6 \n" +
            "---|---|---\n" +
            " 7 | 8 | 9 ";
    public static int[][] win = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {1, 4, 7}, {2, 5, 8}, {3, 6, 9}, {1, 5, 9}, {3, 5, 7}};
    public static String[] boardUsed = new String[10];
    public static boolean end = false;

    public static int checkWhoWon(){
        String sum = "";
        for (int i = 0 ; i < win.length ; i++){
            for (int j = 0 ; j < win[i].length ; j++){
                sum+=boardUsed[win[i][j]];
            }
            if (sum.matches("XXX")){
                return 1;
            }
            else if (sum.matches("OOO")){
                return 0;
            }
            sum = "";
        }
        return -1;
    }

    public static void printBoard(int index, String value){
        board = board.replace(String.valueOf(index), value);
        System.out.println(board);
    }
    public static void takeIndexIn(int turn, Scanner scin){
        System.out.print(">>> ");
        int index = scin.nextInt();

        if (turn == 1){
            printBoard(index, "X");
            boardUsed[index] = "X";
        }
        else{
            printBoard(index, "O");
            boardUsed[index] = "O";
        }
    }
    public static void main(String[] args){
        // X -> 1
        // O -> 0

        System.out.println("Welcome To TicTacToe");
        System.out.println(board);
        System.out.println("Just write the index where to place X or O");

        int turn = 1;
        int count = 0;

        Scanner scin = new Scanner(System.in);

        while (!end){
            count++;
            if (turn == 1){
                System.out.println("X's Turn");
                takeIndexIn(1, scin);
                turn = 0;
            }

            else{
                System.out.println("O's Turn");
                takeIndexIn(0, scin);
                turn = 1;
            }
            if (checkWhoWon() == 1){
                System.out.println("\n"+"---------");
                System.out.println("X won the match");
                end = true;
            }
            else if (checkWhoWon() == 0){
                System.out.println("\n"+"---------");
                System.out.println("O won the match");
                end = true;
            }
            else if (count==9&&checkWhoWon()==-1){
                System.out.println("\n"+"---------");
                System.out.println("It's a draw");
                end = true;
            }
        }
    }
}
