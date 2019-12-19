// The Arbiter class is a java object which has influence over
// the state of ojects inside the whole game
// It can communicate to any objects such as game arrays,
// control screen or even disable keyboard or mouse if needed
// to execute a "loose a turn"
// or decide what happens to the board chips

public class Arbiter{
	MyGame game;

	Arbiter(MyGame g){
		game=g; 
	}

}
