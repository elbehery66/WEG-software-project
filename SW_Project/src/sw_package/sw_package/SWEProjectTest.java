package sw_package.sw_package;

import java.util.Vector;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import sw_package.Question;
import sw_package.SWEProject;
import sw_package.Student;
import sw_package.TFQuestion;
import sw_package.Teacher;
import sw_package.User;







public class SWEProjectTest {	
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////	
	@DataProvider(name="addGame")
	private Object[][] add()
	{  Teacher t1=new Teacher("ali", "ali", "ali", "1234", 22);
	boolean loggedT = true;
	boolean loggedF = false;
	Student s=new Student("walid","walid" , "walid", "1234", 22, "alex");
	Vector<Question> Ques = new Vector<>();
	
	Question q2=new Question("6-2=4","t");
	Question q3=new Question("2+3=5","t");
	Question q4=new Question("2+7=4","f");
	
	
	Ques.add(q2);
	Ques.add(q3);
	Ques.add(q4);
	
		return new Object[][]{
			{true,loggedT,t1,"mido",Ques},
			{false,loggedF,t1,"mido",Ques},
			{false,loggedT,s,"mido",Ques}};
	}
	
	
  @Test(enabled = true, dataProvider="addGame")
  public void adddgame(boolean t,boolean loged,User u, String c ,Vector<Question> v1)
  {
	  SWEProject object  = new SWEProject();
	     
	     Assert.assertEquals(t, object.addgame1(loged,u,c,v1));
	     object.save();
  }
	
 
 ////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
//	@DataProvider(name="addGame")
//	private Object[][] add()
//	{  Teacher t1=new Teacher("ali", "ali", "ali", "1234", 22);
//	boolean loggedT = true;
//	boolean loggedF = false;
//	Student s=new Student("walid","walid" , "walid", "1234", 22, "alex");
//	TFQuestion q1=new TFQuestion("2+2=4","t");
//	
//	TFQuestion q2=new TFQuestion("6-2=4","t");;
//	TFQuestion q3=new TFQuestion("2+3=5","t");;
//	TFQuestion q4=new TFQuestion("2+7=4","f");;
//	Vector<TFQuestion> Ques = new Vector<TFQuestion>();
//	Ques.add(q1);
//	Ques.add(q2);
//	Ques.add(q3);
//	Ques.add(q4);
//	
//		return new Object[][]{{true,true,t1,"mido",Ques},{false,false,t1,"mido",Ques},{false,true,s,"mido",Ques}};
//	}
//  
//	@Test(enabled = false, dataProvider="addGame")
//  public void addTFgame(boolean t,boolean b,User u, String c ,Vector<TFQuestion> v1)
//  {
//	  SWEProject object  = new SWEProject();
//	     
//	     Assert.assertEquals(t, object.addTFgame(b, u, c, v1));
//	     object.save();
//  }
//  
//  
//  
//  
  
  
  
  /******************************************************/
  @DataProvider(name="signIn")
  private Object[][] SignIn()
	{
		return new Object[][]{{true,"mido","5313030"},{false,"ram","1353"},{true,"",""},{false,"mido","1254"}};
	}
  @Test(enabled = false ,  dataProvider="signIn")
  public void SignIn(boolean t,String US , String PW)
  {
	  SWEProject object  = new SWEProject();
	  object.load();
	  Assert.assertEquals(t, object.SignIn(US, PW));
	  
	  
  }
//*******************************************************************
   @DataProvider(name="signUp")
	private Object[][] sigup()
	{
		return new Object[][]{{true,"ahmed","fffff","mido","5313030",22, "cairo"},{true,"afdd","ffffxf","gfdd","we",22, "wert"},{false,"","","","",55,""},{false,"ahmed","fffff","mido","5313030",22, "cairo"}};
	}
  @Test(enabled = false, dataProvider="signUp")
  public void SignUpS(boolean t,String a,String b, String c ,String g,int d,String l)
  {
	  SWEProject object  = new SWEProject();
	     object.load();
	     Assert.assertEquals(t, object.SignUpS(a,b,c,g,d, l));
	     object.save();
  }
}
