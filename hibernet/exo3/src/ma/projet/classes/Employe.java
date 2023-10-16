/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author samia
 */
@Entity
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nom")
    private String nom;
    
    private String prenom;
  
    private String telephone;
      @OneToMany(mappedBy = "employe", fetch = FetchType.EAGER)
    private List<Projet> projet;

   @OneToMany(mappedBy = "employe", fetch = FetchType.EAGER)
    private List<EmployeTache> employeTache;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Projet> getProjet() {
        return projet;
    }

    public void setProjets(List<Projet> projet) {
        this.projet = projet;
    }

  

    public Employe() {
    }

    

    public Employe(String nom, String prenom, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Employe{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", telephone=" + telephone + '}';
    }


    public List<EmployeTache> EmployeTache() {
        return employeTache;
    }

    public void EmployeTache(List<EmployeTache> employeTache) {
        this.employeTache = employeTache;
    }
}
