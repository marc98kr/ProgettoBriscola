package progettobriscola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Marco
 */
public class ProgettoBriscola {

    public static void main(String[] args) throws IOException {
        /*Mazzo mazzo = new Mazzo();
        mazzo.stampaMazzo();*/
        Giocatore g1 = new Giocatore("Marco"/*, creaMazzo(mazzo)*/);
        Giocatore g2 = new Giocatore("Domenico"/*, creaMazzo(mazzo)*/);
        /*System.out.println("\n\n\nMazzo dopo aver dato le carte:");
        mazzo.stampaMazzo();
        System.out.println("\n\n\nMazzo g1:");
        g1.stampaMazzo();
        System.out.println("\n\n\nMazzo g2:");
        g2.stampaMazzo();
        Carta briscola = mazzo.getCarta(mazzo.carteRimanenti()-1);
        System.out.println("Briscola: ");
        briscola.stampaPalo(); briscola.stampaValore();*/
        Briscola gioco = new Briscola(g1, g2);
        System.out.println("Mazzo:");
        gioco.getMazzo().stampaMazzo();
        System.out.println("____________________________________________________________________________");
        System.out.println("Carte distribuite");
        gioco.distribuisciCarte();
        gioco.stampaMazziGiocatori();
        System.out.println("Briscola:");
        gioco.getBriscola().stampaCarta();
        System.out.println("\n\n\n\n\n");
        gioca(g1, g2, gioco);
    }
    
    public static ArrayList<Carta> creaMazzo(Mazzo mazzo) {
        ArrayList<Carta> carte = new ArrayList<Carta>();
        for(int i=0; i<3; i++) {
            carte.add(mazzo.getCarta(mazzo.carteRimanenti() - 1));
            mazzo.rimuoviCarta(mazzo.carteRimanenti() - 1);
        }
        return carte;
    }
    
    public static void gioca(Giocatore g1, Giocatore g2, Briscola gioco) throws IOException {
        BufferedReader lettore = new BufferedReader(new InputStreamReader(System.in));
        int scelta;
        int g = 1;
        while(!gioco.fine()) {
            Carta carta, carta1;
            if(g==1) {
                System.out.println("Tocca a " + g1.getNickname());
                System.out.println("Il tuo mazzo: ");
                g1.stampaMazzo();
                System.out.println("Scegli una carta");
                scelta = Integer.parseInt(lettore.readLine());
                carta = g1.calaCarta(scelta); 
                System.out.println("Tocca a " + g2.getNickname());
                System.out.println("Il tuo mazzo");
                g2.stampaMazzo();
                scelta = Integer.parseInt(lettore.readLine());
                carta1 = g2.calaCarta(scelta);
            }
            
            else {
                System.out.println("Tocca a " + g2.getNickname());
                System.out.println("Il tuo mazzo");
                g2.stampaMazzo();
                scelta = Integer.parseInt(lettore.readLine());
                carta = g2.calaCarta(scelta);
                System.out.println("Tocca a " + g1.getNickname());
                System.out.println("Il tuo mazzo: ");
                g1.stampaMazzo();
                System.out.println("Scegli una carta");
                scelta = Integer.parseInt(lettore.readLine());
                carta1 = g1.calaCarta(scelta); 
            }
            
            if(gioco.isBriscola(carta) && !gioco.isBriscola(carta1)) {
                System.out.println("Ha preso " + g1.getNickname());
                g1.aumentaPunti(carta.getPunti() + carta1.getPunti());
                g = 1;
            }
            if(!gioco.isBriscola(carta) && gioco.isBriscola(carta1)) {
                System.out.println("Ha preso " + g2.getNickname());
                g2.aumentaPunti(carta.getPunti() + carta1.getPunti());
                g = 2;
            }
            else {
                if(carta.getValore() > carta1.getValore()) {
                    System.out.println("Ha preso " + g1.getNickname());
                    g1.aumentaPunti(carta.getPunti() + carta1.getPunti());
                    g = 1;
                }
                else {
                    System.out.println("Ha preso " + g2.getNickname());
                    g2.aumentaPunti(carta.getPunti() + carta1.getPunti());
                    g = 2;
                }      
            }
            if(g==1) {
                g1.aggiungiCarta(gioco.getMazzo().pescaCarta());
                g2.aggiungiCarta(gioco.getMazzo().pescaCarta());
            }
            else {
                g2.aggiungiCarta(gioco.getMazzo().pescaCarta());
                g1.aggiungiCarta(gioco.getMazzo().pescaCarta());
            }
        }
        System.out.println("Gioco finito!");
        
        if(g1.getPunti() > g2.getPunti()) 
            System.out.println("Ha vinto" + g1.getNickname() + " con " + g1.getPunti());
        else if(g1.getPunti() < g2.getPunti())
            System.out.println("Ha vinto" + g1.getNickname() + " con " + g1.getPunti());
        else
            System.out.println("Pareggio");
    }
}
