#define sensorPin A0    // LM35 output pin
#define ledPin 13       // LED or buzzer

void setup() {
    Serial.begin(9600);
    pinMode(ledPin, OUTPUT);
}

void loop() {
    int sensorValue = analogRead(sensorPin);  

    // Convert ADC value to temperature
    float voltage = sensorValue * (5.0 / 1023.0);  
    float tempC = voltage * 100.0;  // LM35 gives 10mV per °C

    Serial.print("Temperature: ");
    Serial.print(tempC);
    Serial.println(" °C");

    // Temperature alert threshold
    if (tempC > 40) {        // If temperature crosses 40°C
        digitalWrite(ledPin, HIGH);
        Serial.println("!! TEMPERATURE HIGH - ALERT !!");
    } else {
        digitalWrite(ledPin, LOW);
    }

    delay(1000);
}
