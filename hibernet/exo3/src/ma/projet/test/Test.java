/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.util.Date;
import ma.projet.classes.Employe;
import ma.projet.classes.EmployeTache;
import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import ma.projet.service.EmployeService;
import ma.projet.service.EmployeTacheService;
import ma.projet.service.ProjetService;
import ma.projet.service.TacheService;

/**
 *
 * @author samia
 */
public class Test {
    public static void main(String[] args) {
        
        EmployeService es = new EmployeService();
        ProjetService ps = new ProjetService();
        TacheService ts = new TacheService();
        EmployeTacheService ets = new EmployeTacheService();
        
       
      // es.create(new Employe("Kouame","Samia","0615113697"));
      //  es.create(new Employe("Rami","Salma","0685961235"));
       // es.create(new Employe("Salami","Hind","0614700350"));
       // es.create(new Employe("alaoui","ahmad","0678903496"));
        
        
      //  ps.create(new Projet("Projet1", new Date(2013,4,24), new Date(2000,5,20), es.getById(1)));
     //   ps.create(new Projet("Projet1", new Date(2013,3,31), new Date(2000,8,17), es.getById(1)));
     // ps.create(new Projet("Projet1", new Date(2013,3,93), new Date(2000,8,17), es.getById(1)));
      //  ps.create(new Projet("Projet1", new Date(1987,3,13), new Date(2000,8,17), es.getById(1)));
      
       // ts.create(new Tache("Tache1", new Date(122,3,20), new Date(122,6,20),5000 ));
       // ts.create(new Tache("Tache2", new Date(122,4,12), new Date(122,5,21),2000 ));
       //ts.create(new Tache("Tache4", new Date(122,4,16), new Date(122,5,22),850 ));
        
       ets.create(new EmployeTache(new Date(2020,3,12), new Date(2023,6,19), es.getById(1), ts.getById(1)));
       ets.create(new EmployeTache(new Date(2023,7,23), new Date(2024,5,29), es.getById(2), ts.getById(2)));
       ets.create(new EmployeTache(new Date(2016,6,26), new Date(2019,5,24), es.getById(2), ts.getById(3)));
       ets.create(new EmployeTache(new Date(2014,5,19), new Date(2023,5,20), es.getById(1), ts.getById(4)));
       
       
         for(Tache tache : es.EmployeTaches(es.getById(1))){
           System.out.println(tache.getNom());
       }
        
        
      
        for(Projet projet : es.EmployeProjets(es.getById(3))){
          System.out.println(projet);
        }
        
     
       for(Tache tache : ps.ProjetTachesPlanifier(ps.getById(1))){
           System.out.println(tache.getId() + "  " + tache.getNom());
        }
        
        
      ps.ProjetTacheRealisee(ps.getById(2));
        
        
        for(Tache tache : ts.getTacheSupAPrix(1000)){
           System.out.println(tache.getNom() + " : " + tache.getPrix() + " DH");
       }
        
       
    }}
     
    

