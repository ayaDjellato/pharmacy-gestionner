package models;

public class vendor {

    private static String log;
    private static String pwdl;

    public void setLog(String l){
        log = l;
    }

    public void setPwd(String l){
        pwdl = l;
    }

    public static String getLog(){
        return log;
    }
    public static String getPwd(){
        return pwdl;
    }
    
    public vendor(String a, String b){
       log= a;
       pwdl = b;
    
    
     }
    
    
}
