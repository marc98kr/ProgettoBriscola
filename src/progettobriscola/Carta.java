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
public class Carta {
    private int palo; /* 1 = Bastoni, 2 = Coppe, 3 = Denari, 4 = Spade*/
    private int valore; /*1 = Asso,2,3,4,5,6,7, 8 = Fante, 9 = Cavallo, 10 = Re*/

    public int getPalo() {
        return palo;
    }

    public void setPalo(int palo) {
        this.palo = palo;
    }

    public int getValore() {
        return valore;
    }

    public void setValore(int valore) {
        this.valore = valore;
    }
    public Carta(int palo, int valore) {
        this.palo = palo;
        this.valore = valore;
    }
    
    public void stampaPalo() {
        switch(palo) {
            case 1:
                System.out.println("bastoni");
                break;
            case 2:
                System.out.println("Coppe");
                break;
            case 3:
                System.out.println("Denari");
                break;
            case 4:
                System.out.println("Spade");
                break;
        }
    }
    
    public void stampaValore() {
        switch(valore) {
            case 1:
                System.out.print("Asso");
                break;
            case 2:
                System.out.print("Due");
                break;
            case 3:
                System.out.print("Tre");
                break;
            case 4:
                System.out.print("Quattro");
                break;
            case 5:
                System.out.print("Cinque");
                break;
            case 6:
                System.out.print("Sei");
                break;
            case 7:
                System.out.print("Sette");
                break;
            case 8:
                System.out.print("Fante");
                break;   
            case 9:
                System.out.print("Cavallo");
                break;
            case 10:
                System.out.print("Re");
                break;
        }
    }
    
    
}
