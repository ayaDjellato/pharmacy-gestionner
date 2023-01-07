package models;

import java.sql.Date;

public class bill {

    private int idbill;
    private int qte;
    private int prix;
    private int id_vente;
    private int id_med;
    private Date date;


    
    public Date getDate(){
        return date;
     }
    
   
    public int getQte(){
       return qte;
    }
    public int getIdvente(){
       return id_vente;
    }
   
    
    public int getPrix(){
       return prix;
    }

    public int getIdm(){
        return id_med;
    }
    public int getIb(){
        return idbill;
    }
    

    public void setdate(Date d){
        date = d;
    }
   public void setQte(Integer i){
       qte = i;
   }
   public void setIdvente(Integer n){
        id_vente = n;
   }
   public void setPrix(int m){
       prix = m;
   }
   public void setIdm(int p){
       id_med = p;
   }
   
   public void setIdb(int l){
        idbill = l;
   }


   
    public bill(int j, int a, int b, int e,  Date d, int f){
        
        idbill = j;
        id_vente = a;
        id_med = b;
        qte = e;
        date = d;
        prix = qte*f;
   
   
    }
}
