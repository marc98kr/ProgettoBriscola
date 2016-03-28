/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettobriscola;

import java.util.ArrayList;

/**
 *
 * @author Marco
 */
public class ProgettoBriscola {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Mazzo mazzo = new Mazzo();
        mazzo.stampaMazzo();
        Giocatore g1 = new Giocatore("Marco", creaMazzo(mazzo));
        Giocatore g2 = new Giocatore("Domenico", creaMazzo(mazzo));
        System.out.println("\n\n\nMazzo dopo aver dato le carte:");
        mazzo.stampaMazzo();
        System.out.println("\n\n\nMazzo g1:");
        g1.stampaMazzo();
        System.out.println("\n\n\nMazzo g2:");
        g2.stampaMazzo();
    }
    
    public static ArrayList<Carta> creaMazzo(Mazzo mazzo) {
        ArrayList<Carta> carte = new ArrayList<Carta>();
        for(int i=0; i<3; i++) {
            carte.add(mazzo.getCarta(mazzo.carteRimanenti() - 1));
            mazzo.rimuoviCarta(mazzo.carteRimanenti() - 1);
        }
        return carte;
    }
}
