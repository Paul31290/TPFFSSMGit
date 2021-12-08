package FFSSM;

import java.time.LocalDate;
import java.util.*;

public class Plongeur extends Personne{
    
    public int niveau;
    public GroupeSanguin groupeS;
    public Licence licence;
    private final List<Licence> listLicencesPlongeur = new ArrayList<>();
    public Club c;
    

    public Plongeur(GroupeSanguin groupeS, String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau, Club c) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.niveau = niveau;
        this.groupeS = groupeS;
        this.c = c;
    }

    public int getNiveau() {
        return niveau;
    }

    public GroupeSanguin getGroupeSanguin() {
        return groupeS;
    }

    public Licence getLicence() {
        return licence;
    }
    
    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
      
    public void ajouteLicence(String numero, LocalDate delivrance, Club c){
        listLicencesPlongeur.add(new Licence(this,numero,delivrance,c));
    }
   
    public Licence derniereLicence(){
       return licence = listLicencesPlongeur.get(listLicencesPlongeur.size()-1);
    }
}
