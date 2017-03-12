package sw_package;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SWEProject 
{
	 public static DataBase db = new DataBase();
	    public static boolean logged = false;
	    public static User loggedIn = new User();
	    public static Question Q = new Question();
	    public static Vector<Question> Ques = new Vector<>();
	    public static Game  playing = new Game();
	    
	    
	   
	 
	    public static boolean SignUpS( String fn , String ln , String un , String pw  , int a , String sc   ){
	        Student s = new Student(fn , ln , un , pw , a , sc);
	        
	        boolean check = true;
	        for(int i=0;i<db.users.size();i++){
	            if(db.users.get(i).username.equals(un)){
	                check = false;
	                break;
	            }
	        }
	        if(check){
	            db.users.add(s);
	            loggedIn = s;
	            logged = true;
	            System.out.println("added successfully , welcome");
	            return true ;
	        }
	        else {
	            System.out.println("username already exists . please try another time using diffrent one");
	            return false ; 
	        }
	        
	    }
	    
	    public static void SignUpT( String fn , String ln , String un , String pw  , int a){
	        Teacher t = new Teacher(fn, ln, un, pw, a);
	        boolean check = true;
	        for(int i=0;i<db.users.size();i++){
	            if(db.users.get(i).username.equals(un)){
	                check = false;
	                break;
	            }
	        }
	        if(check){
	            db.users.add(t);
	            loggedIn = t;
	            logged = true;
	            System.out.println("added successfully , welcome");
	        }
	        else {
	            System.out.println("username already exists . please try another time using diffrent one");
	        }
	    }
	    
	    public static boolean SignIn(String un , String pw){
	        boolean found =  false;
	        for(int i=0;i<db.users.size();i++){
	            if(db.users.get(i).username.equals(un)){
	                if(db.users.get(i).password.equals(pw)){
	                    loggedIn = db.users.get(i);
	                    logged = true;
	                    found = true;
	                    break;     
	                }
	            }
	        }
	        if(found){
	            System.out.println("logged in successfully");
	            return true;
	        }
	        else {
	            System.out.println("Wrong username or password . please enter thecorrect ones");
	            return false;
	        }
	    }
	    
	    public static void logOut(){
	        loggedIn = new User();
	        logged = false;
	        System.out.println("logged out successfully");
	                
	    }
	    
	    public static void Addgame(String s1 ,Vector<Question> vec)
	    {
	        Game game = new Game(s1 , vec);
	        db.games.add(game);
	        
	    }
	    
	  
	    public static boolean addgame1(boolean log,User u, String name ,Vector<Question> v1)
	    {
			
	    if(log==true    )
	    {if( u instanceof Teacher)
	    	{
	    	load();
	    	Addgame(name, v1);
	    	System.out.println("add game succesful");
	    	save();
	    	return true;
	    	}
	    else
	    	
		    System.out.println("fail to add game  may be u not  teacher");
	        return false;	    	
	    }
	    System.out.println("fail to add game  may be u not loged in ");
	      return false;	
	    	
	    }
	    //////////////////////////////////////////////////////////////////////////////
//	    public static boolean addTFgame(boolean logged,User loggedIn,String name,Vector<TFQuestion> qes){
//	    	  if(logged == true){
//                if(loggedIn instanceof Teacher){
//              	  Addgame(name,Ques);
//              	  return true;
//                }
//                else {
//                    System.out.println("Teachers only can Add games .");
//                    return false;
//                }
//            }
//            else {
//                System.out.println("please log in first .");
//                return false;
//            }
//	    	 
//	    	
//	    }
	    ///////////////////////////////////////////////////
	    public static void ShowGames(){
	        System.out.println("*********** Games List **********");
	        for(int i=0;i<db.games.size();i++){
	            System.out.println(i + ")" + db.games.get(i).name);
	        }
	    }
	    public static void save(){
	        PrintWriter out=null;
	        try {
	            out=new PrintWriter(new File("data.txt"));
	        } catch (FileNotFoundException ex) {
	            Logger.getLogger(SWEProject.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        User user;
	        out.println(db.users.size());
	        for(int i=0;i<db.users.size();i++){
	            user=db.users.elementAt(i);
	            out.println(user.type);
	            if(user.type.equals("T")){
	                out.println(user.Fname);
	                out.println(user.Lname);
	                out.println(user.username);
	                out.println(user.age);
	                out.println(user.password);
	                
	            }else{
	                out.println(user.Fname);
	                out.println(user.Lname);
	                out.println(user.username);
	                out.println(user.age);
	                out.println(user.password);
	                out.println(user.school);
	                out.println(user.score);
	                
	            }
	        }
	        Game game;int numOfquestion;String type;
	        out.println(db.games.size());
	        for(int i=0;i<db.games.size();i++){
	            game=db.games.elementAt(i);
	            out.println(game.name);
	            numOfquestion=game.questions.size();
	            type=game.questions.elementAt(0).type;
	            out.println(numOfquestion);
	            out.println(type);
	            for(int j=0;j<numOfquestion;j++){
	                out.println(game.questions.elementAt(j).question);
	                out.println(game.questions.elementAt(j).CorrectAnswer);
	                out.println(game.questions.elementAt(j).answers.length);
	                for (String answer : game.questions.elementAt(j).answers) {
	                    out.println(answer);
	                }
	            }
	        }
	        out.close();
	       
	    }    
	    
	   public static void load(){
	       Scanner scan=null; 
	       try {
	            scan=new Scanner(new File("data.txt"));
	        } catch (FileNotFoundException ex) {
	            Logger.getLogger(SWEProject.class.getName()).log(Level.SEVERE, null, ex);
	        }
	       if(scan.hasNext()){
	       int Size=Integer.parseInt(scan.nextLine()),age,score;
	       String Type,Fname,Lname,userName,password,school;
	       for(int i=0;i<Size;i++){
	           Type=scan.nextLine();
	           if(Type.equals("T")){
	               Fname=scan.nextLine();
	               Lname=scan.nextLine();
	               userName=scan.nextLine();
	               age=Integer.parseInt(scan.nextLine());
	               password=scan.nextLine();
	               db.users.add(new Teacher(Fname,Lname,userName, password, age));
	           }else{
	               Fname=scan.nextLine();
	               Lname=scan.nextLine();
	               userName=scan.nextLine();
	               age=Integer.parseInt(scan.nextLine());
	               password=scan.nextLine();
	               school=scan.nextLine();
	               score=Integer.parseInt(scan.nextLine());
	               db.users.add(new Student(Fname,Lname,userName,password,age,school));
	           }
	       }
	       Size=Integer.parseInt(scan.nextLine());
	       int len;
	       String [] answer;
	       Vector<Question> vec;
	       for(int i=0;i<Size;i++){
	         Fname=scan.nextLine();
	         age=Integer.parseInt(scan.nextLine());
	         Type=scan.nextLine();
	         vec=new Vector<Question>();
	         for(int j=0;j<age;j++){
	             Lname=scan.nextLine();
	             userName=scan.nextLine();
	             len=Integer.parseInt(scan.nextLine());
	             answer=new String[len];
	             for(int k=0;k<len;k++){
	                 answer[k]=scan.nextLine();
	             }
	            if(Type.equals("TF")){
	                vec.add(new TFQuestion(Lname, userName));
	            }else{
	                vec.add(new MCQQuestion(Lname,userName,answer[0],answer[1],answer[2],answer[3]));
	            }
	         }
	             db.games.add(new Game(Fname, vec));
	       }
	       
	       }
	   } 
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	public static void main(String[] args) 
	{
		 Scanner cin = new Scanner(System.in);
	        load();
	        
	        int choice;
	        while(true){
	        System.out.println("Welcome to FIZO.com");
	        System.out.println("*************Main page*************");
	        System.out.println("1) Sign up as a Student");
	        System.out.println("2) Sign up as a Teacher");
	        System.out.println("3) Sign in");
	        System.out.println("4) Add a game");
	        System.out.println("5) Play a game");
	        System.out.println("6) Log out");
	        System.out.println("7) Exit");
	        System.out.println("Select your choice");
	        
	            choice = Integer.parseInt(cin.nextLine());
	            if(choice==7) break;
	        switch(choice){
	            case 1:
	                if(logged == false){
	                    String s1 , s2 , s3 , s4 , s5,s6;
	                   
	                    System.out.println("Enter your First name , last name , username . password , age & school");
	                    s1 = cin.nextLine();
	                    s2 = cin.nextLine();
	                    s3 = cin.nextLine();
	                    s4 = cin.nextLine();
	                    s6=cin.nextLine();
	                    s5 = cin.nextLine();
	                    SignUpS(s1 , s2 , s3 , s4 , Integer.parseInt(s6) , s5);
	                }
	                else {
	                    System.out.println("an account is already logged in . please log out first .");
	                }
	                break;
	            case 2:
	                if(logged == false){
	                    String s1 , s2 , s3 , s4 ;
	                    int i1;
	                    System.out.println("Please enter your First name , last name , username . password & age ");
	                    s1 = cin.nextLine();
	                    s2 = cin.nextLine();
	                    s3 = cin.nextLine();
	                    s4 = cin.nextLine();
	                    i1 = Integer.parseInt(cin.nextLine());
	                    SignUpT(s1, s2, s3, s4, i1);
	                }
	                else {
	                    System.out.println("an account is already logged in . please log out first .");
	                }
	                break;
	            case 3:
	                if(logged == false){
	                    String s1 , s2;
	                    System.out.println("Enter your username & password");
	                    s1 = cin.nextLine();
	                    s2 = cin.nextLine();
	                    SignIn(s1, s2);
	                }
	                else{
	                    System.out.println("an account is already logged in . please log out first .");
	                }
	                break;
	            case 4:
	               //////////////////////////////////////////////
	                if(logged == true){
	                    if(loggedIn instanceof Teacher){
	                        int w;
	                        String d;
	                        System.out.println("ENter a name for your game");
	                        d = cin.nextLine();
	                        System.out.println("1 for TF game , 2 for MCQ game ");
	                        w = Integer.parseInt(cin.nextLine());
	                        if(w == 1)
	                        {
	                            boolean cont = true;
	                            String s1 , s2 , check;
	                            while (cont){
	                                System.out.println("Enter the Question and the correct answer");
	                                s1 = cin.nextLine();
	                                System.out.println("T or F?");
	                                s2 = cin.nextLine();
	                                if(s2.equalsIgnoreCase("T")){
	                                   s2="T";
	                                }else{
	                                    s2="F";
	                                }
	                                Q = new TFQuestion(s1, s2);
	                                Ques.add(Q);
	                                System.out.println("another Question ? Y OR N");
	                                check = cin.nextLine();
	                                if(check.equalsIgnoreCase("N")){
	                                   break;
	                                }
	                            }
	                            Addgame(d, Ques);
	                        }
	                        else {
	                            Q = new MCQQuestion();
	                            boolean cont = true;
	                            String s1 , s2 , s3 , s4  , s5 , s6 , check;
	                            while (cont){
	                                System.out.println("Enter the Question , correct answer & the 4 choices");
	                                s1 = cin.nextLine();
	                                s2 = cin.nextLine();
	                                s3 = cin.nextLine();
	                                s4 = cin.nextLine();
	                                s5 = cin.nextLine();
	                                s6 = cin.nextLine();
	                                Q = new MCQQuestion(s1, s2, s3, s4, s5, s6);
	                                Ques.add(Q);
	                                System.out.println("another Question ? Y OR N");
	                                check = cin.nextLine();
	                                if(check.equalsIgnoreCase("N")){
	                                   break;
	                                }
	                            }
	                            Addgame(d, Ques);
	                        }
	                    }
	                    else {
	                        System.out.println("Teachers only can Add games .");
	                    }
	                }
	                else {
	                    System.out.println("please log in first .");
	                }
	            break;
	            case 5:
	                ShowGames();
	                int g ; 
	                System.out.println("Enter the number of the game you want to play");
	                g = Integer.parseInt(cin.nextLine());
	                playing = db.games.get(g);
	                int size=playing.questions.size();
	                int Score=0;
	                Question q;
	                for (int i = 0; i < size; i++) {
	                    q=playing.questions.get(i);
	                    System.out.println(q.question);
	                    for (int j = 0; j < q.answers.length; j++) {
	                        System.out.println(j+")"+ q.answers[j]);
	                    }
	                    System.out.println("Enter the answer number:");
	                    q.chossenAnswer=q.answers[Integer.parseInt( cin.nextLine())];
	                    if(q.chossenAnswer.equals(q.CorrectAnswer)){
	                        System.out.println("Correct Answer");
	                        Score++;
	                    }else{
	                        System.out.println("False Answer");
	                    }
	                    System.out.println("Your Score is:"+Score);
	                }
	                
	              break;  
	            case 6:
	                if(logged == true){
	                    System.out.println("logged out successfully");
	                    logOut();
	                 
	                }
	                else {
	                    System.out.println("logged out already");
	                }
	                break;
	        }
	          save();      
	    }
	      
	    }

	}


