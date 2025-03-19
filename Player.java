

public class Player {


    public static void playerTurn(String playerTurn,char[][] trackingGrid,char[][] playerGrid) {

            if(Coordinate.isValidCoordinate(playerTurn)){
                if(playerGrid[Character.toUpperCase(playerTurn.charAt(0))-'A'][playerTurn.charAt(1)-'0']=='O'){
                    System.out.println("hit");
                    playerGrid[Character.toUpperCase(playerTurn.charAt(0))-'A'][playerTurn.charAt(1)-'0']='~';
                    trackingGrid[Character.toUpperCase(playerTurn.charAt(0))-'A'][playerTurn.charAt(1)-'0']='O';
                }else {
                    System.out.println("miss");
                    if(!(trackingGrid[Character.toUpperCase(playerTurn.charAt(0))-'A'][playerTurn.charAt(1)-'0']=='O')){
                        trackingGrid[Character.toUpperCase(playerTurn.charAt(0))-'A'][playerTurn.charAt(1)-'0']='X';
                    }

                }
            }




    }
}
