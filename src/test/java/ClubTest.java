/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import FFSSM.*;
import java.time.LocalDate;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

/**
 *
 * @author phili
 */
public class ClubTest {
    Plongee plongee;
    Moniteur president, presidentNouveau, chefDePalanquee;
    Site s1;
    GroupeSanguin APLUS, BMOINS, AMOINS;
    LocalDate dateNaiss, dateSortie, dateNaissPlongeur;
    Club club;
    Plongeur pl1, pl2;
    
    @BeforeEach
    public void SetUp(){
        s1 = new Site("Barrière de Corail", "Australie");
        dateNaiss = LocalDate.of(1972, 3, 2);
        dateSortie = LocalDate.of(2021, 12, 4);
        dateNaissPlongeur = LocalDate.of(1994, 8, 24);
        club = new Club(president,"poisson","16 rue de l'océan","0618224794");
        chefDePalanquee = new Moniteur(APLUS,"1245","Dupont","Jean","8 avenue de Castres","0658473321",dateNaiss,3,2635,club);
        president = new Moniteur(BMOINS,"052142","Billon","Roger","952 boulevard d'Albi","0649202034",dateNaiss,5,2783,club);
        presidentNouveau = new Moniteur(APLUS,"053942","Jansen","Eric","9 rue de la ville","0671244155",dateNaiss,4,2319,club);
        pl1 = new Plongeur(AMOINS,"58554","Darroque","Zoé","17 rue des plongeurs", "0655471220",dateNaissPlongeur,2,club);
        pl2 = new Plongeur(APLUS,"95812","Coussot","Inès","26 impasse de la mer", "0685192835",dateNaissPlongeur,1,club);
        plongee = new Plongee(s1, chefDePalanquee, dateSortie, 8, 2);
    }

    @Test
    public void TestPlongeeConformeNulle(){
    assertTrue(club.listPlongee.isEmpty(),
                "La liste de plongée est vide");
       }

    @Test
    public void TestPlongeeConforme(){
        pl1.ajouteLicence("34", LocalDate.of(2021, 7, 15), club);
        plongee.ajouteParticipant(pl1);
        Set<Plongee> plongeeConforme = new HashSet<>();
        assertEquals(plongeeConforme, club.plongeesNonConformes(),
                "la plongée est conforme");

        pl1.ajouteLicence("31", LocalDate.of(2019, 1, 24), club);
        club.organisePlongee(plongee);
        plongee.ajouteParticipant(pl1);
        plongeeConforme.add(plongee); 
        assertEquals(plongeeConforme, club.plongeesNonConformes(),
                "La plongée n'est pas conforme");
    }
    

    @Test
    public void TestOrganisePlongee(){
        club.organisePlongee(plongee);
        assertTrue(club.listPlongee.contains(plongee),
                "La plongée est bien organisée");
    }

    
    @Test
    public void TestSetPresident(){
        club.setPresident(presidentNouveau);
        assertNotEquals(president, presidentNouveau,
                    "Le président est bien initialisé");
    }
    
    @Test
    public void TestGetNom(){
        assertEquals(club.getNom(), "poisson",
                    "Le président est bien initialisé");
    }
    
    @Test
    public void TestSetNom(){
        club.setNom("baleine");
        assertNotEquals(club.getNom(), "poisson",
                    "Le président est bien initialisé");
    }
    
    @Test
    public void TestGetAdresse(){
        assertEquals(club.getAdresse(), "16 rue de l'océan",
                    "Le président est bien initialisé");
    }
    @Test
    public void TestSetAdresse(){
        club.setAdresse("16 rue de la mer");
        assertNotEquals(club.getAdresse(), "16 rue de l'océan",
                    "Le président est bien initialisé");
    }
    
    @Test
    public void TestGetTelephone(){
        assertEquals(club.getTelephone(), "0618224794",
                    "Le président est bien initialisé");
    }
    
    @Test
    public void TestSetTelephone(){
        club.setTelephone("0628941142");
        assertNotEquals(club.getTelephone(), "0618224794",
                    "Le président est bien initialisé");
    }
}
