import java.util.Random;
import java.util.Scanner;

public class Ship {

    static void placeShips(char[][] grid) {
        int NumberOfShips=0;
        int maxtolow=5;
        while(NumberOfShips<4) {
            Random rand = new Random();
            int satr = rand.nextInt(10);
            int soton = rand.nextInt(10);
            boolean ammodyaofoghi = rand.nextBoolean();
            if(Coordinate.Coordinaterand(grid,satr,soton,ammodyaofoghi,maxtolow,10)){
                if (ammodyaofoghi) {
                    for (int i = 0; i < maxtolow; i++) {
                        grid[satr+i][soton]='O';
                    }
                }else {
                    for (int i = 0; i < maxtolow; i++) {
                        grid[satr][soton+i]='O';
                    }
                }
            } else continue ;
            maxtolow--;
            NumberOfShips++;
        }

    }
    static void placeShipsplayer(char[][] grid) {
        Scanner scan = new Scanner(System.in);
        int NumberOfShips=0;
        int maxtolow=5;
        while(NumberOfShips<4) {
            System.out.println("Ship number: "+maxtolow);
            System.out.print("Enter of satr and soton: ");
            String Satrandsoton=scan.nextLine();
            System.out.println("Enter of amodyaofoghi:y/n ");
            String ammodyaofoghi=scan.nextLine();
            Boolean amodyaofoghi;
            if(ammodyaofoghi.charAt(0)=='y'||ammodyaofoghi.charAt(0)=='Y'){
                amodyaofoghi=false;
            }else amodyaofoghi=true;

            if(!(Coordinate.isValidCoordinate(Satrandsoton))){
                System.out.println("Vorodi bad dobarh tlash kon");
                continue;
            }
            int satr=Character.toUpperCase(Satrandsoton.charAt(0))-'A';
            int soton=Satrandsoton.charAt(1)-'0';
            if(Coordinate.Coordinaterand(grid,satr,soton,amodyaofoghi,maxtolow,10)){
                if (amodyaofoghi) {
                    for (int i = 0; i < maxtolow; i++) {
                        grid[satr+i][soton]='O';
                    }
                }else {
                    for (int i = 0; i < maxtolow; i++) {
                        grid[satr][soton+i]='O';
                    }
                }
            } else {
                System.out.println("Vorodi bad dobarh tlash kon");
                continue ;
            }
            maxtolow--;
            NumberOfShips++;
        }
    }
}