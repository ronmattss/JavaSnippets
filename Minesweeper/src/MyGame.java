// The purpose of this java program is to instantiate the 
// java objects to be used in the game
// There should be no other program lines executing and being
// part of the overall logic of the game

public class MyGame{
    Chip gameBoard[],white;
    Arbiter arbiter;
    UserIO userIO;
  

    MyGame(){
       gameBoard  = new Chip[64];
      
       white = new Chip(this,"Private");
       gameBoard[0]=white;
       arbiter = new Arbiter(this);
       userIO = new UserIO(this);
       userIO.populateGrid();
       System.out.println("blackCellLoation:"+userIO.blackCells.size());
       
    }

    public static void main(String arg[]){
    	
         new MyGame();
    }

}
