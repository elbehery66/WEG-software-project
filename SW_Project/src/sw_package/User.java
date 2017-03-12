package sw_package;

import java.util.Vector;

public class User 
{

	public String Fname;
    public String Lname;
    public String username;
    public String password;
    public int age;
    public String type;
    public String school;
    public int score;
    public Vector<User> friends = new Vector<User>();
    public User(){
        
    }
    
    public User(String fn , String ln  , String un , String pw , int a ){
        Fname = fn;
        Lname = ln;
        username = un;
        password = pw;
        age = a;
    }
}
