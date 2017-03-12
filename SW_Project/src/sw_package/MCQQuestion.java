package sw_package;

public class MCQQuestion extends Question
{

	  public MCQQuestion(){
	        type = "MCQ";
	        answers = new String[4];
	    }
	    
	    public MCQQuestion(String s1 , String s2 , String a1 , String a2 , String a3 , String a4 ){
	        super(s1 , s2);
	         type = "MCQ";
	        answers = new String[4];
	        answers[0] = a1;
	        answers[1] = a2;
	        answers[2] = a3;
	        answers[3] = a4;
	        
	    }
}
