package progettobriscola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ferraro Domenico
 */
public class Server extends Thread {
    
    private ServerSocket server;
    private Socket client;
    private Giocatore g1;
    private Giocatore g2;
    private String nomeGiocatore1;
    private BufferedReader in;
    private PrintStream out;
    
    public Server(String nomeGiocatore1) {
        this.nomeGiocatore1 = nomeGiocatore1;
        try {
            server = new ServerSocket(9999);
        } catch (IOException ex) {
            System.out.println("Impossibile avviare il Server.");
        }
    }
    
    public void run() {
        g1 = new Giocatore(nomeGiocatore1/*, creaMazzo(mazzo)*/);
        g2 = new Giocatore(""/*, creaMazzo(mazzo)*/);
        System.out.println("Il giocatore "+g1.getNickname()+" ha avviato il server.");
        
        try {
            System.out.println("Status del server: In attesa del secondo giocatore");
            client = server.accept(); //Attendo il secondo giocatore
        } catch(IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(client.getInetAddress()+" si è connesso al Server.");
        //Il client del secondo giocatore deve inviare come primo messaggio il suo nickname
        g2.setNickname(attendiMessaggio());
        System.out.println("Il nickname del giocatore appena entrato è: "+g2.getNickname());
        
        //Inizia il gioco
        Briscola gioco = new Briscola(g1, g2);
        System.out.println("Inizia il gioco tra "+g1.getNickname()+" e "+g2.getNickname());
        
        System.out.println("Mazzo:");
        gioco.getMazzo().stampaMazzo();
        System.out.println("____________________________________________________________________________");
        System.out.println("Carte distribuite");
        gioco.distribuisciCarte();
        gioco.stampaMazziGiocatori();
        System.out.println("Briscola:");
        gioco.getBriscola().stampaCarta();
        System.out.println("\n\n\n\n\n");
        try {
            gioca(g1, g2, gioco);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Ottengo la stringa inviata dal secondo giocatore
    private String attendiMessaggio() {
        String messaggio = "";
        try {
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            messaggio = in.readLine();
        } catch(IOException ex) {
            System.out.println("Problemi nella comunicazione con il secondo giocatore. Impossibile ricevere un messaggio.");
        }
        return messaggio;
    }
    
    //Invio una stringa al secondo giocatore
    public void inviaMessaggio(String messaggio) {
        try {
            out = new PrintStream(client.getOutputStream());
            out.println(messaggio);
        } catch (IOException ex) {
            System.out.println("Problemi nella comunicazione con il secondo giocatore. Impossibile inviare un messaggio.");
        }
    }
    
    public static void gioca(Giocatore g1, Giocatore g2, Briscola gioco) throws IOException {
       while(!gioco.fine()) {
           
       }
    }
    /**Metodo che determina il giocatore che vince la mano. Il metodo ritorna 1 se vince il giocatore 1 e 2 se vince il giocatore 2.*/
    public static int vincitoreMano(Carta carta1, Carta carta2, int paloBriscola, int primo) {
    //primo = quale giocatore ha calato per primo(1 se giocatore 1, 2 se giocatore 2).    
    //Se sono dello stesso palo
        if(carta1.getPalo() == carta2.getPalo()) {
            if(carta1.getValore() > carta2.getValore()) 
                return 1;
            else
                return 2;
        }
        //Se non sono dello stesso palo
        else {
            if(carta1.getPalo() == paloBriscola)
                return 1;
            else if(carta2.getPalo() == paloBriscola)
                return 2;
            return primo;
        }
    }
}
