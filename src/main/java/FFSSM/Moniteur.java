/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.*;

public class Moniteur extends Plongeur {

    public int numeroDiplome;
    public Set<Plongee> listPlongeeMoniteur;
    public Club employeur;
    public List<Embauche> listEmbauche = new LinkedList<>();

    public Moniteur(GroupeSanguin groupeS,String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance,int niveau, int numeroDiplome, Club club) {
        super(groupeS, numeroINSEE, nom, prenom, adresse, telephone, naissance, numeroDiplome, club);
        this.numeroDiplome = numeroDiplome;
    }

    /**
     * Si ce moniteur n'a pas d'embauche, ou si sa dernière embauche est terminée,
     * ce moniteur n'a pas d'employeur.
     * @return l'employeur actuel de ce moniteur sous la forme d'un Optional
     */
    public Optional<Club> employeurActuel(){
        Optional<Club> optional = Optional.empty();
        if (listEmbauche.size()== 0){
        } else {
            optional = Optional.of(listEmbauche.get(listEmbauche.size()-1).getEmployeur());
        }
        return optional;
    }
    
    /**
     * Enregistrer une nouvelle embauche pour cet employeur
     * @param employeur le club employeur
     * @param debutNouvelle la date de début de l'embauche
     */
    public void nouvelleEmbauche(Club employeur, LocalDate debutNouvelle) {   
        Embauche emb = new Embauche(debutNouvelle, this, employeur);
        listEmbauche.add(emb);
    }

    public List<Embauche> emplois() {
        return listEmbauche;
    }
    
    public void terminerEmbauche(LocalDate fin){
        Embauche emb = listEmbauche.get(listEmbauche.size()-1);
        emb.terminer(fin);
    }

}
