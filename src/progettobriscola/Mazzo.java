/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettobriscola;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
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
    
    private void mischiaMazzo() {
        Collections.shuffle(mazzo, new java.util.Random(System.nanoTime()));
    }
    
    public void stampaMazzo() {
        for(int i = 0; i<40; i++) {
            Carta carta = mazzo.get(i);
            carta.stampaValore();
            System.out.print(" di ");
            carta.stampaPalo();
        }
    }
}
