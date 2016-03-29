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
    private int palo; /*1 = Bastoni, 2 = Coppe, 3 = Denari, 4 = Spade*/
    private int valore; /*1 = Asso,2,3,4,5,6,7, 8 = Fante, 9 = Cavallo, 10 = Re*/
    private int punti; /*Punti associati alla carta*/
    public void stampaCarta() {
        stampaValore();
        System.out.println(" di ");
        stampaPalo();
    }
    
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
    
    public int getPunti() {
        return punti;
    }
    
    public Carta(int palo, int valore) {
        this.palo = palo;
        this.valore = valore;
        if(valore == 1)
            punti = 11;
        else if(valore == 3)
            punti = 10;
        else if(valore == 8)
            punti = 2;
        else if(valore == 9)
            punti = 3;
        else if(valore == 10)
            punti = 4;
        else
            punti = 0;
    }
    
    public void stampaPalo() {
        switch(palo) {
            case 1:
                System.out.println("Bastoni");
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
    
    public String paloToString() {
        switch(palo) {
            case 1:
                return "bastoni";
            case 2:
                return "coppe";
            case 3:
                return "denari";
            case 4:
                return "spade";
        }
        return null;
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
    
    public String valoreToString() {
        switch(valore) {
            case 1:
                return "asso";
            case 2:
                return "due";
            case 3:
                return "tre";
            case 4:
                return "quattro";
            case 5:
                return "cinque";
            case 6:
                return "sei";
            case 7:
                return "sette";
            case 8:
                return "fante";
            case 9:
                return "cavallo";
            case 10:
                return "re";
        }
        return null;
    }
}
