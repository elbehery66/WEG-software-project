package sw_package;

public class TFQuestion extends Question{
   
    
    public TFQuestion(){
        type = "TF";
          answers = new String[2];
    }
    
    public TFQuestion(String s1 , String s2){
        super(s1 , s2);
        type = "TF";
        answers = new String[2];
        answers[0] = "T";
        answers[1] = "F";
    }
    
}

