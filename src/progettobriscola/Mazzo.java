package progettobriscola;

import java.util.ArrayList;
import java.util.Collections;

/**
 * La classe mazzo rappresenta il mazzo di carte di Briscola, consiste in un ArrayList contenente 40 oggetti di classe
 * Carta e alcuni metodi per la gestione del mazzo.
 * @author Marco
 */
public class Mazzo {
    ArrayList<Carta> mazzo;
    public Mazzo() {
        mazzo = new ArrayList<Carta>();
        riempiMazzo();
        mischiaMazzo();
    }
    
    private void riempiMazzo() {
        for(int i=1; i<=4; i++) {
            for(int j=1; j<=10; j++)     
                mazzo.add(new Carta(i,j));
        }
    }
    /**Randomizza l'ordine degli oggetti Carta all'interno dell'ArrayList mazzo*/
    private void mischiaMazzo() {
        Collections.shuffle(mazzo, new java.util.Random(System.nanoTime()));
    }
    
    public void stampaMazzo() {
        for(int i = 0; i<mazzo.size(); i++) {
            Carta carta = mazzo.get(i);
            carta.stampaValore();
            System.out.print(" di ");
            carta.stampaPalo();
        }
    }
    
    public Carta getCarta(int indice) {
        return mazzo.get(indice);
    }
    /**Rimuove una carta dal mazzo*/
    public void rimuoviCarta(int indice) {
        mazzo.remove(indice);
    }
    /**Restituisce il numero di carte rimanenti*/
    public int carteRimanenti() {
        return mazzo.size();
    }
    /**Restituisci la carta di indice 0, ovvero la prima, e la rimuove dal mazzo*/
    public Carta pescaCarta() {
        Carta cartaPescata = mazzo.get(0);
        rimuoviCarta(0);
        return cartaPescata;
    }
    public boolean mazzoFinito() {
        return mazzo.isEmpty();
    }
}
