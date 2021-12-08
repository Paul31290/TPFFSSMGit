/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import FFSSM.*;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


/**
 *
 * @author phili
 */
public class LicenceTest {
    Club club;
    LocalDate dateNaissPlongeur, dateNaissPresident, dateLicence;
    Plongeur pl1;
    GroupeSanguin BMOINS, AMOINS;
    Moniteur president;
    Licence licence;
    
    @BeforeEach
    public void SetUp() {
        dateNaissPresident = LocalDate.of(1972, 3, 2);
        dateNaissPlongeur = LocalDate.of(1994, 8, 24);
        dateLicence = LocalDate.of(2021, 12, 6);
        club = new Club(president,"poisson","16 rue de l'océan","0618224794");
        president = new Moniteur(BMOINS,"052142","Billon","Roger","952 boulevard d'Albi","0649202034",dateNaissPresident,5,2783,club);
        pl1 = new Plongeur(AMOINS,"58554","Darroque","Zoé","17 rue des plongeurs", "0655471220",dateNaissPlongeur,2,club);
        licence = new Licence(pl1,"142114512",dateLicence,club);        
    }
    
    @Test
    public void TestGetPossesseur(){
        assertEquals(licence.getPossesseur(), pl1,
                    "Le plongeur est bien initialisé");
    }
        
    @Test
    public void TestGetNumero(){
        assertEquals(licence.getNumero(), "142114512",
                    "Le numéro est bien initialisé"); 
    }
    @Test
    public void TestGetDelivrance(){
        assertEquals(licence.getDelivrance(), LocalDate.of(2021, 12, 6),
                    "La délivrance est bien initialisé");
    }
    @Test
    public void TestGetClub(){
        assertEquals(licence.getClub(), club,
                    "Le club est bien initialisé");
    }
    @Test
    public void TestEstValide(){
        LocalDate dateLicenceLimite = LocalDate.of(2022, 12, 7);
        LocalDate dateLicenceValide = LocalDate.of(2020, 12, 5);
        assertFalse(licence.estValide(dateLicenceLimite),
                    "La date insérée n'est pas valide");
        
        assertTrue(licence.estValide(dateLicenceValide),
                    "La date insérée est valide");
    }
    
}
