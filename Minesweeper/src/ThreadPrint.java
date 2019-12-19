import java.lang.Thread;

public class ThreadPrint implements Runnable{
	
	ThreadPrint(){

	}

	public void run(){
		try{
			while (true){
				System.out.println("Hello");
				Thread.sleep(1000);
			}
		}
		catch(Exception e){

		}
	}

}