package models;

import java.sql.Date;

public class vente {
    private int idv_vendeur;
    private int qte;
    private int prix;
    private int idp;
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
   
    public int getIdv(){
       return idv_vendeur;
    }
    public int getPrix(){
       return prix;
    }

    public int getIdm(){
        return id_med;
    }
    
    public int getIdp(){
        return idp;
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
   
   public void setIdp(int l){
        idp = l;
   }


   
    public vente(int a, int b, int c, int e, int f, Date d, int s){
   
        id_vente = a;
        id_med = b;
        idv_vendeur = c;
        idp = e;
        qte = f;
        date = d;
        prix = s;
   
   
    }
}
