package progettobriscola;

import java.util.ArrayList;

/**
 * La classe Giocatore rappresenta il giocatore di Briscola, contiene un nickname, un ArrayList contenente gli 
 * oggetti di tipo Carta e il punteggio totalizzato.
 * @author Marco
 */
public class Giocatore {
    private String nickname;
    private ArrayList<Carta> mazzo;
    private int punti;
    
    public Giocatore(String nickname, ArrayList<Carta> mazzo) {
        this.nickname = nickname;
        this.mazzo = mazzo;
    }
    
    public Giocatore(String nickname) {
        this.nickname = nickname;
        mazzo = new ArrayList<Carta>();
    }
    
    public void stampaMazzo() {
        System.out.println("Mazzo di " + nickname);
        for(int i=0; i< mazzo.size(); i++) {
            mazzo.get(i).stampaValore(); System.out.print(" di "); mazzo.get(i).stampaPalo();
        }
    }
    /**Aggiunge una carta al mazzo del giocatore*/
    public void aggiungiCarta(Carta carta) {
        mazzo.add(carta);
    }
    /**Rimuove la carta dal mazzo del giocatore*/
    public void rimuoviCarta(int i) {
        mazzo.remove(i);
    }
    /**Aumenta di un certo valore, passato come argomento, il punteggio*/
    public void aumentaPunti(int valore) {
        punti += valore;
    }
    
    public int getPunti() {
        return punti;
    }
}
