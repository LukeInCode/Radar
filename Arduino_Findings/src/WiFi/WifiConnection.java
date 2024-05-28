package WiFi;

import processing.core.PApplet;

/**
 * Classe per la comunicazione tramite WiFi
 */
public class WifiConnection {
    private PApplet a;

    /**
     * @param a Oggetto PApplet
     * Costruttore
     */
    public WifiConnection(PApplet a) {
        this.a = a;
    }

    /**
     * @param msg messaggio dal client
     * Metodo per la ricezione
     */
    public void webSocketServerEvent(String msg){
        System.out.println(Integer.parseInt(msg));
    }
}