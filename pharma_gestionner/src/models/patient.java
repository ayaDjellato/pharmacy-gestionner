package models;

import java.sql.Date;

public class patient{
    
 private int id;
 private String name;
 private String prename;
 private Date date;
 private String phone;


 public int getId(){
    return id;
 }
 public String getName(){
    return name;
 }

 public String getPrename(){
    return prename;
 }
 public String getPhone(){
    return phone;
 }
 public Date getDate(){
    return date;
 }
   
public void setId(Integer i){
    id = i;
}
public void setName(String n){
    name = n;
}
public void setPrename(String m){
    prename = m;
}
public void setPhone(String p){
    phone = p;
}
public void setName(Date d){
    date = d;
}

 public patient(int i, String n, String m, String phone, Date d){
    id = i;
    name = n;
    prename = m;
    this.phone = phone;
    date = d;


 }


}
