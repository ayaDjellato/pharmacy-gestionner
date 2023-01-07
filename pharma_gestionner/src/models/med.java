package models;

public class med {
    private int id;
    private String name;
    private int gram;
    private int qte;
    private int price;
    private String ctg;
    
    
    public int getId(){
    return id;
 }
 public String getName(){
    return name;
 }

 
 public int getGram(){
    return gram;
 }
    
 public int getPrice(){
    return price;
 }
 
 public int getQte(){
    return qte;
 }

 public String getCtg(){
    return ctg;
 }


 public void setcategorie(String c){
    ctg = c;
}

public void setid(int q){
    id = q;
}
public void setname(String c){
    name = c;
}

public void setqte(int q){
    qte = q;
}

public void setprice(int p){
    price = p;
}

public void setgram(int m){
    gram = m;

}

public med(int i, String n, int m,Integer d, String c, Integer p){
    id = i;
    name = n;
    gram = m;
    qte = d;
    ctg = c;
    price = p;


 }


}
