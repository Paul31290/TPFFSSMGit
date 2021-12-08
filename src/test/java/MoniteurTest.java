/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import FFSSM.*;
import java.util.*;
import java.time.LocalDate;

/**
 *
 * @author phili
 */
public class MoniteurTest {
    
    Plongee plongee;
    Moniteur president, chefDePalanquee, moniteur;
    GroupeSanguin APLUS, AMOINS, BMOINS;
    LocalDate dateNaiss, dateNaissPresident;
    Club club;
    
    @BeforeEach
    public void SetUp() {
        dateNaiss = LocalDate.of(1961, 2, 18);
        dateNaissPresident = LocalDate.of(1972, 3, 2);
        president = new Moniteur(BMOINS,"052142","Billon","Roger","952 boulevard d'Albi","0649202034",dateNaissPresident,5,2783,club);
        club = new Club(president,"poisson","16 rue de l'océan","0618224794");
        moniteur = new Moniteur(AMOINS,"24332","Lavet","Philippe","61 rue de Mazamet","0627473958",dateNaiss,3,3524,club);
        chefDePalanquee = new Moniteur(APLUS,"1245","Dupont","Jean","8 avenue de Castres","0658473321",dateNaiss,3,2635,club);
    }
    @Test
    public void TestEmployeurActuel(){
        assertEquals(moniteur.employeurActuel(), Optional.empty(),
                "Le moniteur ne doit pas avoir d'employeur");
        moniteur.nouvelleEmbauche(club, LocalDate.of(2020, 7, 13));
        assertEquals(moniteur.employeurActuel(), Optional.ofNullable(club),
                "Le moniteur est employé dans le club");
    }
    
    @Test
    public void TestNouvelleEmbauche(){
      chefDePalanquee.nouvelleEmbauche(club, LocalDate.of(2020, 7, 13));
      
      assertEquals(LocalDate.of(2020, 7, 13), chefDePalanquee.listEmbauche.get(chefDePalanquee.listEmbauche.size()-1).getDebut(),
                "Le moniteur a bien été embauché a cette date");
      assertEquals(chefDePalanquee, chefDePalanquee.listEmbauche.get(chefDePalanquee.listEmbauche.size()-1).getEmploye(),
                "Le bon moniteur a été embauché");
      assertEquals(club, chefDePalanquee.listEmbauche.get(chefDePalanquee.listEmbauche.size()-1).getEmployeur(),
                "Le moniteur a bien été embauché dans le bon club");
    }

    @Test
    public void TestEmplois(){
      List<Embauche> listEmbauche = new LinkedList<>();
      Embauche embChef = new Embauche(LocalDate.of(2020, 7, 13), chefDePalanquee, club);
      listEmbauche.add(embChef);
      chefDePalanquee.nouvelleEmbauche(club, LocalDate.of(2020, 7, 13));

      assertEquals(chefDePalanquee.listEmbauche, chefDePalanquee.emplois(),
                "L'emploi est bien ajouté");


    }
    
    @Test
    public void TestTerminer(){
        chefDePalanquee.nouvelleEmbauche(club, LocalDate.of(2020, 7, 13));
        chefDePalanquee.terminerEmbauche(LocalDate.of(2021, 2, 18));
        
        assertEquals(LocalDate.of(2021, 2, 18), chefDePalanquee.listEmbauche.get(chefDePalanquee.listEmbauche.size()-1).getFin(),
                "Le moniteur a bien fini l'emploi a cette date");
                
    }
    
}
