package sw_package;

import java.util.Vector;

public class Game
{

	 public String name;
	    public Vector<Question> questions = new Vector<>();
	    public int finalScore;
	    
	    public Game(){
	        
	    }
	    
	    public Game(String s , Vector<Question> v1){
	        
	        name = s;
	        questions = v1;
	    }
}
