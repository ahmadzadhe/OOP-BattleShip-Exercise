import java.sql.SQLOutput;
import java.util.Scanner;

public class  Game  {

    public void start() {
        boolean playAgain;
        do {
            playGame();
            playAgain = askReplay();
        } while (playAgain);
    }
    private boolean askReplay() {
        System.out.println("Play again? (yes/no)");
        Scanner scanner = new Scanner(System.in);
        return scanner.next().equalsIgnoreCase("yes");
    }
    public boolean isGameOver(char[][] P1,char[][] P2){
        if(allShipsSunk(P1)){
            return true;
        }
        if(allShipsSunk(P2)){
            return true;
        }
        return false;
    }
    static boolean allShipsSunk(char[][] grid) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(grid[i][j]=='O' ){
                    return false;
                }
            }
        }
        return true;

    }
    private void playGame() {
        System.out.println("Game logic here...");
        Scanner scanner = new Scanner(System.in);
        String vorodi;
        Board Player1=new Board(10);
        Board Player2=new Board(10);
        System.out.println("Player (P) or random coordinate (R):");
        vorodi=scanner.nextLine();
        if(vorodi.charAt(0)=='R'||vorodi.charAt(0)=='r'){
        Player1.rand();
        Player2.rand();
        }else {
            System.out.println("Player1 turn:");
            Player1.player();
            System.out.println("Player2 turn:");
            Player2.player();
        }
        boolean playerTurn=false;
        while (!isGameOver(Player1.gitGird(),Player2.gitGird())) {
            if(!playerTurn) {
                System.out.println("Player 1's turn:");
                System.out.println("SpecialAttack? (y/n)");
                vorodi=scanner.nextLine();
                Player1.printGrid();
                if(vorodi.charAt(0)=='Y'||vorodi.charAt(0)=='y'){
                    System.out.println("A.radarScan:yek satr ra be sorat random nshan medahd");
                    System.out.println("B.multiStrike:4 khanh ra be intkhab shoma mord hamlah ghrar medahd");
                    vorodi=scanner.nextLine();
                    if(vorodi.charAt(0)=='A'||vorodi.charAt(0)=='a'){
                        SpecialAttack.radarScan(Player2);
                    } else{
                        System.out.println("Enter Mokhtasad:c5,a4,i0,...");
                        SpecialAttack.multiStrike(Player2.gitGird(),Player1.getTrackingGrid());
                    }
                }
                if(!(vorodi.charAt(0)=='B'||vorodi.charAt(0)=='b')) {
                    Player.playerTurn(vorodi = scanner.nextLine(), Player1.getTrackingGrid(), Player2.gitGird());
                }
            }else {
                System.out.println("Player 2's turn:");
                System.out.println("SpecialAttack? (y/n)");
                vorodi=scanner.nextLine();
                Player2.printGrid();
                if(vorodi.charAt(0)=='Y'||vorodi.charAt(0)=='y'){
                    System.out.println("A.radarScan:yek satr ra be sorat random nshan medahd");
                    System.out.println("B.multiStrike:4 khanh ra be intkhab shoma mord hamlah ghrar medahd");
                    vorodi=scanner.nextLine();
                    if(vorodi.charAt(0)=='A'||vorodi.charAt(0)=='a'){
                        SpecialAttack.radarScan(Player1);
                    } else{
                        System.out.println("Enter Mokhtasad:c5,a4,i0,...");
                        SpecialAttack.multiStrike(Player1.gitGird(),Player2.getTrackingGrid());
                    }
                }
                if(!(vorodi.charAt(0)=='B'||vorodi.charAt(0)=='b')) {
                    Player.playerTurn(vorodi = scanner.nextLine(), Player2.getTrackingGrid(), Player1.gitGird());
                }
            }
            playerTurn=!playerTurn;
        }
        System.out.println("!!!!!!!!!!!!!!!gameover!!!!!!!!!!!!!");
    }
}