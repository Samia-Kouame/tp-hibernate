/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import ma.projet.classes.EmployeTache;
import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author samia
 */
public class ProjetService implements IDao<Projet>{
    public boolean create(Projet o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit(); 
            return true;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return false;
        }finally{
            if(session != null)
                session.close();
        }
    }

    @Override
    public boolean delete(Projet o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(o);
            tx.commit();
            return true;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public boolean update(Projet o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(o);
            tx.commit();
            return true;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Projet> getAll() {
        List <Projet> projets = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            projets = session.createQuery("from Projet ").list();
            tx.commit();
            return projets;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return projets;
        } finally {
            if(session != null)
                session.close();
        }
    }

    @Override
    public Projet getById(int id) {
       Projet projet = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            projet = (Projet) session.get(Projet.class, id);
            tx.commit();
            return projet;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return projet;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    public List<Tache> ProjetTachesPlanifier(Projet o){
        List<Tache> taches = new ArrayList<Tache>();
        Date dateActuelle = new Date();
        for (Tache tache : o.getTache() ){
            if(tache.getDateDebut().after(dateActuelle)){
                taches.add(tache);
            }
        }
        return taches;
    }
    
    public void ProjetTacheRealisee(Projet o){
        System.out.println("\n");
        System.out.print("Projet : "+ o.getId() +"   Nom : "+ o.getNom() + "  Date de debut : "+ o.getDateDebut()+'\n');
        System.out.print("Liste des taches :\n");
        System.out.printf("%-10s %-10s %-10s %-10s\n", "Num", "Nom", "DateDebutReelle", "DateFinReelle");
        List<Tache> taches = new ArrayList<Tache>();
        Date dateActuelle = new Date();
        for (Tache tache : o.getTache() ){
            if(!tache.getDateFin().after(dateActuelle)){
                taches.add(tache);
            }
        }
        for(Tache tache: taches){
            for (EmployeTache et : tache.getEmployeTache()){
                
            System.out.printf("%-10s %-10s %-10tF      %-10tF\n", tache.getId(), tache.getNom(), et.getDateDebutReelle(), et.getDateFinReelle());
            
            }
        }
        System.out.println("\n");
    }
    
    
}
