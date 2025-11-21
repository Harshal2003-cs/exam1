#define sensorPin 7   // Vibration sensor output pin
#define ledPin 13     // LED indicator

void setup() {
    pinMode(sensorPin, INPUT);
    pinMode(ledPin, OUTPUT);
    Serial.begin(9600);
}

void loop() {
    int sensorValue = digitalRead(sensorPin);

    if (sensorValue == HIGH) {  // Vibration detected
        Serial.println("Vibration Detected!");
        digitalWrite(ledPin, HIGH);
        delay(300);
    } else {
        Serial.println("No Vibration");
        digitalWrite(ledPin, LOW);
    }

    delay(200);
}
