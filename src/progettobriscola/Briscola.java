/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettobriscola;

/**
 *
 * @author Marco
 */
public class Briscola {
    private Mazzo mazzo;
    private Carta briscola;
    private Giocatore g1, g2;
    
    public Briscola(Mazzo mazzo, Carta briscola, Giocatore g1, Giocatore g2) {
        this.mazzo = mazzo;
        this.briscola = briscola;
        this.g1 = g1;
        this.g2 = g2;
    }
    
    public Briscola(Giocatore g1, Giocatore g2) {
        this.g1 = g1;
        this.g2 = g2;
        mazzo = new Mazzo();
    }
    
    public Mazzo getMazzo() {
        return mazzo;
    }

    public void setMazzo(Mazzo mazzo) {
        this.mazzo = mazzo;
    }

    public Carta getBriscola() {
        return briscola;
    }

    public void setBriscola(Carta briscola) {
        this.briscola = briscola;
    }

    public Giocatore getG1() {
        return g1;
    }

    public void setG1(Giocatore g1) {
        this.g1 = g1;
    }

    public Giocatore getG2() {
        return g2;
    }

    public void setG2(Giocatore g2) {
        this.g2 = g2;
    } 
    /**Metodo che distruibisce le carte ai giocatori, una ciascuno, e pesca la briscola*/
    public void distribuisciCarte() {
        for(int i=0; i<3; i++) {
            Carta c = mazzo.pescaCarta();
            g1.aggiungiCarta(c);
            c = mazzo.pescaCarta();
            g2.aggiungiCarta(c);
        }
        briscola = mazzo.pescaCarta();
    }
    
    public void stampaMazziGiocatori() {
        g1.stampaMazzo();
        g2.stampaMazzo();
    }
    
    public boolean fine() {
        return g1.getPunti() + g2.getPunti() == 120;
    }
    
    public boolean isBriscola(Carta carta) {
        return carta.getPalo() == briscola.getPalo();
    }
}
