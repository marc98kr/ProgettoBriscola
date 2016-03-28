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
public class Giocatore {
    private String nickname;
    private ArrayList<Carta> mazzo;
    
    public Giocatore(String nickname, ArrayList<Carta> mazzo) {
        this.nickname = nickname;
        this.mazzo = mazzo;
    }
    
    public void stampaMazzo() {
        for(int i=0; i< mazzo.size(); i++) {
            mazzo.get(i).stampaValore(); System.out.print(" di "); mazzo.get(i).stampaPalo();
        }
    }
    
    public void aggiungiCarta(Carta carta) {
        mazzo.add(carta);
    }
    
    public void rimuoviCarta(int i) {
        mazzo.remove(i);
    }
}
