// Touch Sensor (OUT) connected to D7
const int touchPin = 2;

// LED connected to D13
const int ledPin = 13;

void setup() {
  pinMode(touchPin, INPUT);     // Sensor output
  pinMode(ledPin, OUTPUT);      // LED output
  Serial.begin(9600);
}

void loop() {
  int touchValue = digitalRead(touchPin);  // Read sensor

  if (touchValue == HIGH) {      // Finger touched
    digitalWrite(ledPin, HIGH);  // LED ON
    Serial.println("Finger Detected");
  } else {
    digitalWrite(ledPin, LOW);   // LED OFF
    Serial.println("No Touch");
  }

  delay(100);
}
