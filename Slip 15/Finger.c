#define touchPin 7
#define ledPin 13

void setup() {
    pinMode(touchPin, INPUT);
    pinMode(ledPin, OUTPUT);
    Serial.begin(9600);
}

void loop() {
    int touchState = digitalRead(touchPin);

    if (touchState == HIGH) {  // Finger touched
        Serial.println("Finger Detected!");
        digitalWrite(ledPin, HIGH);
    } else {                   // No touch
        Serial.println("No Finger");
        digitalWrite(ledPin, LOW);
    }

    delay(200);
}
