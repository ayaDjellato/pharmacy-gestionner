package models;

import java.sql.Date;

public class patient{
    
    private int id;
    private String fname;
    private String lname;
    private String phone;
    private Date date;

    public patient(){
        super();
    }

    public int getid(){
        return id;
    }
    public Date getdate(){
        return date;
    }

    public String getname(){
        return fname;
    }

    public String getf_name(){
        return lname;
    }
    public String getphone(){
        return phone;
    }

    public void setname(String name){
        fname = name;
    }
    public void setfname(String fi_name){
        lname = fi_name;
    }

    public void setphone(String fphone){
       phone = fphone;
    }
    public void setdate(Date ndate){
        date = ndate;
     }

    public patient(int id, String fname, String lname, String phone, Date date){
        this.date = date;
        this.id = id;
        this.fname =  fname;
        this.lname = lname;
        this.phone = phone;
        
    }
}
