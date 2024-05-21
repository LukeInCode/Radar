/* RADAR */
 
 #include <Servo.h>
 // Includes the Servo library
// Defines Tirg and Echo pins of the Ultrasonic Sensor
// Variables for the duration and the distance
uint16_t distance;
uint16_t range;
bool start = false;

Servo myServo; // Creates a servo object for controlling the servo motor

void setup() {
  Serial.begin(9600);
}

uint16_t function(uint16_t value){
  if(value < 10){
    value = 10;
  } 
  return ((67870.0 / (value - 3.0)) - 40.0);
}

void loop() {
  // rotates the servo motor from 15 to 165 degrees
  distance = analogRead(A2);
  range = function(distance);
  Serial.print(range);
  Serial.println(" mm");
  if(start) {
    Serial.write(range);
    Serial.println("Sended");
  }
   // Sends the distance value into the Serial Port
  delay(1000);
  
}
