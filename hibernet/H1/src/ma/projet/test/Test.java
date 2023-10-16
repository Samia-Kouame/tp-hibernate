/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.util.Date;
import java.util.List;
import ma.projet.entity.Produit;
import ma.projet.service.ProduitService;

/**
 *
 * @author samia
 */
public class Test {
    public static void main(String[] args) {
        ProduitService ps = new ProduitService();
       ps.create(new Produit("ZARA", "aaaa", new Date() , 400 ,"chemise"));
       ps.create(new Produit("BERSHKA", "bbb", new Date() , 600 ,"sac"));
       ps.create(new Produit("MACDO", "mc", new Date() , 80 ,"fastfood"));
       ps.create(new Produit("CISCO", "ccc", new Date() , 2000 ,"switch"));
       ps.create(new Produit("NESCAFE", "nnn", new Date() , 25 ,"cafe"));
        
      List<Produit> listeProduits = ps.findAll();
for (Produit p1 : listeProduits) {
    System.out.println(p1);
    }

Produit p2 = ps.findById(2);

        //ps.create(new Produit ("marque0" ,"reference0", new Date(),"designation 0",100));
        //ps.create(new Produit ("marque1" ,"reference1", new Date(),"designation 1",200));
        //ps.create(new Produit ("marque2" ,"reference2", new Date(),"designation 2",300));
        //ps.create(new Produit ("marque3" ,"reference3", new Date(),"designation 3",400));
        //ps.create(new Produit ("marque4" ,"reference4", new Date(),"designation 4",500));
          //for(Produit p : ps.findAll())
            //System.out.println(p);
          //Produit p = ps.findById(2); 
          //System.out.println(p);
        //Produit p = ps.findById(3); 
       // ps.delete(p);
       //Produit p = ps.findById(1);
         //   p.setMarque("M");
           // p.setReference("R");
            //p.setDateAchat(new Date());
            //p.setDesignation("M");
            //p.setPrix(50);
            //ps.update(p);
       // for(Produit p : ps.findAll()){
         //   if (p.getPrix() > 100) {
          //      System.out.println(p);
                
        
            }
        }
        
    
