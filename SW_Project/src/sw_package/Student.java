package sw_package;

public class Student extends User

{
   
    
	 public Student(String fn , String ln  , String un , String pw , int a ,String s1 )
	 {
	        super( fn , ln , un , pw , a);
	        school = s1;
	        score = 0;        
	        type="S";
	    }

}
