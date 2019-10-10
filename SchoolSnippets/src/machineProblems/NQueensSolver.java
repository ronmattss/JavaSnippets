/*Author: Rivera, Ron Matthew R.
 * NQueen Solver With stacks
 * 
 * */
package machineProblems;
    import java.util.Stack;

    public class NQueensSolver {
        private char[][] currentBoard;						// store the current board solution
        private Stack<char[][]> prevBoards = new Stack<>();	// store the previous board solutions
        private Stack<Integer> yStack = new Stack<>();	    // store the y position of the Q
        private int x = 0;
        private int y = 0;
        private int solutionCount = 0;			// Possible solutions
        private boolean success = false;		    // check if all possible solutions are met
        public NQueensSolver(int boardSize){
            currentBoard = new char[boardSize][boardSize];	
            for(int i = 0; i < boardSize; ++i){
                for(int j = 0; j < boardSize; ++j){
                    currentBoard[i][j] = ' ';			// initialize an empty board
                }
            }
        }
        // main algo
        public void printSolutions(){
            boolean isEmpty;			// check if empty
            while(!success){	
                isEmpty = currentBoard[y][x] == ' ';  // if row col is empty
                if(isEmpty){
                    if(x == currentBoard.length - 1){

                        placeQueen();				// function to place the Q in the board
                        ++solutionCount;			// add it to the solution
                        printBoard();		       // print the current board
                        returnToPrevBoard();				   // goback to the previous board
                    }else{
                        prevBoards.push(copy(currentBoard));	// push the current board to the stack
                        yStack.push(y);		// push the current yposition to the stack
                      //  System.out.println("Trying to place Queen in Row: " + x +" Column: "+ y);
                        placeQueen();				    // place the Q
                        ++x;					// increment Xposition
                        y = -1;				   // decrement Y
                    }
                }else{
                    returnToPrevBoard();
                    
                }
                ++y;
            }
        	System.out.println();
            System.out.println("Found "+ solutionCount + " solutions!");
        }
        //  if the solution is not valid set currentBoard to prevBoards.pop()
        // backtracks to the last solution that is valid
        private void returnToPrevBoard(){
        
            while(y == currentBoard.length - 1){
                if(prevBoards.size() == 0){
                    success = true;
                    System.out.println("Invalid Solution");
                    return;
                }
                --x;
                y = yStack.pop();
                currentBoard = prevBoards.pop(); // if the solution is invalid pop the prev board then set it as the currentBoard
                System.out.println("\nInvalid Board Solution, BackTracking\n");
            }
        }
        
        // Copy the current board
        private char[][] copy(char[][] arrayToCopy){
            char[][] arrayCopy = new char[arrayToCopy.length][];
            for(int i = 0; i < arrayToCopy.length; ++i)
            {
                char[] newArray = arrayToCopy[i];
                int arrayLength = newArray.length;
                arrayCopy[i] = new char[arrayLength];
                System.arraycopy(newArray, 0, arrayCopy[i], 0, arrayLength);
            }
            return arrayCopy;
        }
        // printing of boards
        public void printBoard(){
        	System.out.println();
            for(int i = 0; i < currentBoard.length; ++i){
                for (int j = 0; j < currentBoard.length; ++j){
                    System.out.print(currentBoard[i][j]);
                }
                System.out.println();
            }
        	System.out.println();
            System.out.println("Solution number " + solutionCount);	// solution count 
            System.out.println();
        }
        private void placeQueen(){
            placeStraightX();
            placeDiagonalX();
            currentBoard[y][x] = 'Q';
            System.out.println("Trying to Place Q in Row: "+ x + " Column: " + y );
        }
        // place X to the board meaning the position is invalid
        private void placeStraightX(){
            for(int i = 0; i < currentBoard.length; ++i){
                currentBoard[i][x] = 'X'; //Vertical	
                currentBoard[y][i] = 'X'; //Horizontal
            }
        }
        
        //diagonally place X
        // while the current position is not Q
        private void placeDiagonalX(){
            int nextX = x + 1;
            int nextY = y + 1;
            while(nextX < currentBoard.length && nextY < currentBoard.length){
                if(currentBoard[nextY][nextX] != 'Q'){
                    currentBoard[nextY][nextX] = 'X';
                }
                ++nextY;
                ++nextX;
            }
            nextX = x + 1;
            nextY = y - 1;
            while(nextX < currentBoard.length && nextY >= 0){
                if(currentBoard[nextY][nextX] != 'Q'){
                    currentBoard[nextY][nextX] = 'X';
                }
                --nextY;
                ++nextX;
            }
        }
    }