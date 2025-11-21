int ldrPin = A0;      // LDR connected to analog pin A0
int ledPin = 9;       // LED connected to PWM pin 9

void setup() {
    pinMode(ledPin, OUTPUT);
    Serial.begin(9600);
}

void loop() {
    int ldrValue = analogRead(ldrPin);    // Read LDR value (0–1023)

    // Convert LDR reading to LED brightness (0–255)
    int brightness = map(ldrValue, 0, 1023, 255, 0);

    analogWrite(ledPin, brightness);      // Adjust LED brightness

    Serial.print("LDR Value: ");
    Serial.print(ldrValue);
    Serial.print("  | LED Brightness: ");
    Serial.println(brightness);

    delay(200);
}
