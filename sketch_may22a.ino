#include <Servo.h>

Servo myServo; // Crea un oggetto servo per controllare il servo motore

int pos = 0;    // Variabile per memorizzare la posizione del servo
int increment = 1; // Variabile per controllare la direzione del movimento
const int minutes = 600000;
uint16_t range;
int previousMillis;

void setup() {
  Serial.begin(9600);
  myServo.attach(11); // Collega il servo al pin 9 (puoi cambiare il pin secondo il tuo setup)
  previousMillis = millis();
}

void loop() {
    // Ruota il servo motore da 0 a 180 gradi
  for (int i = 0; i <= 180; i++) {
    myServo.write(i);
    uint16_t distance = analogRead(A2);
    range = toMillimetres(distance);
    Serial.print("Range: ");
    Serial.print(range);
    Serial.println(" mm");
    //delay(50);
  }

  // Ruota il servo motore da 180 a 0 gradi
  for (int i = 180; i >= 0; i--) {
    myServo.write(i);
    uint16_t distance = analogRead(A2);
    range = toMillimetres(distance);
    Serial.print("Range: ");
    Serial.print(range);
    Serial.println(" mm");
    //controllo minuti.
    //delay(50);
  }
   if(millis() - previousMillis > minutes) {
    Serial.write(range);
    previousMillis = millis();    
  }
  delay(50); // Attendi 15 millisecondi per permettere al servo di raggiungere la posizione



}

uint16_t toMillimetres(uint16_t value){
  if(value < 10){
    value = 10;
  }
  return ((67870.0 / (value - 3.0)) - 40.0);
}
