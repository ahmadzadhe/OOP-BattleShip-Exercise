public class Board {
    private char[][] grid;
    private int size;
    private char[][] TrackingGrid;

    public Board(int size) {
        this.size = size;
        this.grid = new char[size][size];
        this.TrackingGrid = new char[size][size];
        initializeGrid(grid);
        initializeGrid(TrackingGrid);
    }
    private void initializeGrid(char[][] grid) {
        for(int i=0 ; i< 10; i++){
            for (int j = 0; j < 10; j++) {
                grid[i][j]='~';
            }
        }
    }

    public int getSize() {
        return size;
    }
    public void printGrid() {
        System.out.print("@");
        for(int i=0 ; i<size; i++){
            System.out.print("|");
            System.out.print(i);
        }System.out.print("|@");
        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print((char)(65+i));
            for (int j = 0; j < size; j++) {
                System.out.print("|");
                System.out.print(TrackingGrid[i][j]);
            }System.out.print("|");
            System.out.print((char)(65+i));
            System.out.println();
        }
        System.out.print("@");
        for(int i=0 ; i<size; i++){
            System.out.print("|");
            System.out.print(i);
        }System.out.print("|@");
        System.out.println();
    }
    public void rand() {
        Ship.placeShips(grid);

    }
    public void player(){
        printGrid();
        Ship.placeShipsplayer(grid);
    }

    public char[][] gitGird(){
        return grid;
    }
    public char[][] getTrackingGrid() {
        return TrackingGrid;
    }

}
