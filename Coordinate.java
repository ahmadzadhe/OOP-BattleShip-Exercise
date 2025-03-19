public class Coordinate {
        public static boolean isValidCoordinate(String input) {
            if (input.length() != 2) return false;
            char col = input.charAt(0);
            char row = input.charAt(1);
            return (  (col >= 'A' && col <= 'J') || (col>='a' && col<='j') ) && (row >= '0' && row <= '9');
        }

        public static boolean Coordinaterand(char [][] grid, int row, int col, boolean horizontal,int size, int GRID_SIZE ) {
            for (int i = 0; i < size; i++) {
                if (horizontal) {
                    if(row+i>=GRID_SIZE){
                        return false;
                    }else
                    {
                        if (grid[row + i][col] != '~') {
                            return false;
                        }
                    }
                }else {
                    if(col+i>=GRID_SIZE){
                        return false;
                    }else {
                        if(grid[row ][col+i] !='~'){
                            return false;}
                    }
                }
            }
         return true;
        }

    }

