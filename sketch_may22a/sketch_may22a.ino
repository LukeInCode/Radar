#include <Servo.h>
#include <ArduinoHttpClient.h>
#include <WiFiNINA.h>

Servo myServo; // Crea un oggetto servo per controllare il servo motore

int pos = 0;    // Variabile per memorizzare la posizione del servo
int increment = 1; // Variabile per controllare la direzione del movimento
const int minutes = 30000;
uint16_t range;
int previousMillis;
/////// WiFi Settings ///////
char ssid[] = "iPhone di Luke";
char pass[] = "BestHotspot";
char serverAddress[] = "172.20.10.14";  // server address
int port = 8025;

WiFiClient wifi;
WebSocketClient client = WebSocketClient(wifi, serverAddress, port);
int status = WL_IDLE_STATUS;

void setup() {
  Serial.begin(9600);
  myServo.attach(11); // Collega il servo al pin 9 (puoi cambiare il pin secondo il tuo setup)
  while ( status != WL_CONNECTED) {
    Serial.print("Attempting to connect to Network named: ");
    Serial.println(ssid);                   // print the network name (SSID);
    // Connect to WPA/WPA2 network:
    status = WiFi.begin(ssid, pass);
  }
  // print the SSID of the network you're attached to:
  Serial.print("SSID: ");
  Serial.println(WiFi.SSID());
  // print your WiFi shield's IP address:
  IPAddress ip = WiFi.localIP();
  Serial.print("IP Address: ");
  Serial.println(ip);
  previousMillis = millis();
}

void loop() {
  Serial.println("starting WebSocket client");
  client.begin();
  while(client.connected()) {
    uint16_t distance = analogRead(A2);
    uint16_t range = function(distance);
    if(millis() - previousMillis > minutes){
    client.beginMessage(TYPE_TEXT);
    client.print(range);
    client.endMessage();
    previousMillis = millis();
    Serial.println("è entrato");
  }
  
    // Ruota il servo motore da 0 a 180 gradi
  for (int i = 0; i <= 180; i++) {
    myServo.write(i);
    Serial.print("Range: ");
    Serial.print(range);
    Serial.println(" mm");
    

    delay(15);
  }

  // Ruota il servo motore da 180 a 0 gradi
  for (int i = 180; i >= 0; i--) {
    myServo.write(i);
   
    Serial.print("Range: ");
    Serial.print(range);
    Serial.println(" mm");
    

    delay(15);
  }
   delay(50); // Attendi 15 millisecondi per permettere al servo di raggiungere la posizione
  }
  Serial.print("disconnected");
}

uint16_t function(uint16_t value){
  if(value < 10){
    value = 10;
  }
  return ((67870.0 / (value - 3.0)) - 40.0);
}