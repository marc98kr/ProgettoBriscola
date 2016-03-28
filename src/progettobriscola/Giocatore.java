package progettobriscola;

import java.util.ArrayList;

/**
 *
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
    
    public void aggiungiCarta(Carta carta) {
        mazzo.add(carta);
    }
    
    public void rimuoviCarta(int i) {
        mazzo.remove(i);
    }
    
    public void aumentaPunti(int valore) {
        punti += valore;
    }
    
    public int getPunti() {
        return punti;
    }
}
