// The chip is an example of an object found inside the Gameboard Array
// It has important instance variables which explains who he is,
// it explains what it is currently doing (important for the camera class icons) 
// In the event that this chip becomes moveable by itself, it will require a
// java Thread program.

public class Chip{
    MyGame game;
    String desc;

    Chip(MyGame g, String d){
      game = g;
      desc = d;      
    }
}
