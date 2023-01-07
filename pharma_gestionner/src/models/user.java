package models;

public class user {
    Integer idu;
    String name;
    String lname;

    public String getName(){
        return name;
    }


    public String getLname(){
        return lname;
    }

    public Integer getIdu(){
        return idu;
    }
    

    public user(int a, String b, String c){
        idu = a;
        name = b;
        lname = c;
    }
}
