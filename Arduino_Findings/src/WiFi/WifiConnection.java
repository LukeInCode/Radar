package WiFi;
import processing.core.PApplet;
import websockets.*;

/**
 * Class to provide wi-fi connection
 */
public class WifiConnection {
    private WebsocketServer ws;
    private int now;
    private PApplet a;

    /**
     * @param a PApplet obj
     * Constructor
     */
    public WifiConnection(PApplet a) {
        this.a = a;
        ws = new WebsocketServer(a, 8025, "");
        now = a.millis();
    }


    /**
     * Method to send messages
     */
    public void write(Object c){
        if(a.millis()>now+5000){
            ws.sendMessage(c.toString());
            now=a.millis();
        }
    }

    /**
     * @param msg message from client
     * Method to get it
     */
    public void webSocketServerEvent(String msg){
        System.out.println(msg);
    }
}