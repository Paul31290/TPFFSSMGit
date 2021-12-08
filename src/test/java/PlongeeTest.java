/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import FFSSM.*;
import java.time.LocalDate;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author phili
 */
public class PlongeeTest {
    Plongee plongee;
    Moniteur president, chefDePalanquee;
    Site s1;
    GroupeSanguin APLUS, AMOINS;
    LocalDate dateNaiss, dateSortie, dateNaissPlongeur;
    Club club;
    Plongeur pl1, pl2;
    
    @BeforeEach
    public void SetUp() {
        s1 = new Site("Barrière de Corail", "Australie");
        dateNaiss = LocalDate.of(1972, 3, 2);
        dateSortie = LocalDate.of(2021, 12, 4);
        dateNaissPlongeur = LocalDate.of(1994, 8, 24);
        club = new Club(president,"poisson","16 rue de l'océan","0618224794");
        chefDePalanquee = new Moniteur(APLUS,"1245","Dupont","Jean","8 avenue de Castres","0658473321",dateNaiss,3,2635,club);
        pl1 = new Plongeur(AMOINS,"58554","Darroque","Zoé","17 rue des plongeurs", "0655471220",dateNaissPlongeur,2,club);
        pl2 = new Plongeur(APLUS,"95812","Coussot","Inès","26 impasse de la mer", "0685192835",dateNaissPlongeur,1,club);
        plongee = new Plongee(s1, chefDePalanquee, dateSortie, 8, 2);

    }
    @Test
    public void TestGetDate(){
        assertEquals(plongee.getDate(), LocalDate.of(2021, 12, 4),
                    "La date de sortie de plongée est bien initialisé");
    }
    
    @Test
    public void TestPlongeeSansParticipant(){
        assertTrue(plongee.listPlongeur.isEmpty(),
                    "La plongée ne contient aucun plongeur");
        
    }
    
    @Test
    public void TestAjoutParticipant(){
        plongee.ajouteParticipant(pl1);
        assertTrue(plongee.listPlongeur.contains(pl1),
                    "La plongée contient bien le plongeur");
    }
    
    @Test
    public void TestPlongeeNonValide(){
        pl1.ajouteLicence("34", LocalDate.of(2021, 7, 15), club);
        plongee.ajouteParticipant(pl1);
        pl2.ajouteLicence("31", LocalDate.of(2019, 1, 24), club);
        plongee.ajouteParticipant(pl2);
        assertFalse(plongee.estConforme(),
                   "La plongee ne sera pas conforme");
       
    }
    @Test
    public void TestPlongeeValide(){
        pl1.ajouteLicence("34", LocalDate.of(2021, 7, 14), club);
        plongee.ajouteParticipant(pl1);
        assertTrue(plongee.estConforme(),
                   "La plongee sera conforme");
    }
    
}
