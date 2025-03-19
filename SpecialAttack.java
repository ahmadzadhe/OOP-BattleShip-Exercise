import java.util.Random;
import java.util.Scanner;

public class SpecialAttack {

    public static void radarScan(Board enemyBoard) {
        System.out.println("Radar scan activated!");
        Random rand = new Random();
        int randd = rand.nextInt(10);
           char[][] gird= enemyBoard.gitGird();
        System.out.print((char)(randd+'A'));
        System.out.print('|');
           for( int i = 0; i < enemyBoard.getSize(); i++ ) {
               System.out.print(gird[randd][i]);
               System.out.print("|");
           }
        System.out.print((char)(randd+'A'));
        System.out.println();
    }

    public static void multiStrike(char[][] grid,char[][] TrackingGrid) {
        Scanner scanner = new Scanner(System.in);
        String vorodi = scanner.nextLine();
        if (Coordinate.isValidCoordinate(vorodi)){
            int row = Character.toUpperCase(vorodi.charAt(0))-'A';
        int col= vorodi.charAt(1)-'0';
        System.out.println("Multi-Strike attack!");
            if (grid[row][col] == 'O') {
                System.out.print("1.hit ");
                TrackingGrid[row][col] = 'O';
                grid[row][col] = '~';
            } else {
                System.out.print("1.miss ");
                if (!(TrackingGrid[row][col] == 'O')) {
                    TrackingGrid[row][col] = 'X';
                }
            }
            if (row + 1 <= 9) {
                if (grid[row + 1][col] == 'O') {
                    System.out.print("2.hit ");
                    TrackingGrid[row + 1][col] = 'O';
                    grid[row + 1][col] = '~';
                } else {
                    System.out.print("2.miss ");
                    if (!(TrackingGrid[row + 1][col] == 'O')) {
                        TrackingGrid[row + 1][col] = 'X';
                    }
                }
            }
            if (row + 1 <= 9 && col + 1 <= 9) {
                if (grid[row + 1][col + 1] == 'O') {
                    System.out.print("3.hit ");
                    TrackingGrid[row + 1][col + 1] = 'O';
                    grid[row + 1][col + 1] = '~';
                } else {
                    System.out.print("3.miss ");
                    if (!(TrackingGrid[row + 1][col + 1] == 'O')) {
                        TrackingGrid[row + 1][col + 1] = 'X';
                    }
                }
                if (col + 1 <= 9) {
                    if (grid[row][col + 1] == 'O') {
                        System.out.print("4.hit ");
                        TrackingGrid[row][col + 1] = 'O';
                        grid[row][col + 1] = '~';
                    } else {
                        System.out.print("4.miss ");
                        if (!(TrackingGrid[row][col + 1] == 'O')) {
                            TrackingGrid[row][col + 1] = 'X';
                        }
                    }
                }
            }



    }
        System.out.println();
    }
}
