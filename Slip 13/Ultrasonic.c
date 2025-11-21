#define trigPin 9
#define echoPin 10
#define ledPin 13

void setup() {
    pinMode(trigPin, OUTPUT);
    pinMode(echoPin, INPUT);
    pinMode(ledPin, OUTPUT);

    Serial.begin(9600);
}

void loop() {
    long duration;
    int distance;

    // Clear trigger pin
    digitalWrite(trigPin, LOW);
    delayMicroseconds(2);

    // Send 10us pulse to trigger
    digitalWrite(trigPin, HIGH);
    delayMicroseconds(10);
    digitalWrite(trigPin, LOW);

    // Read echo time
    duration = pulseIn(echoPin, HIGH);

    // Convert to distance in cm
    distance = duration * 0.034 / 2;

    Serial.print("Distance: ");
    Serial.print(distance);
    Serial.println(" cm");

    // LED blink when object is close
    if (distance < 20) {    // If object < 20 cm
        digitalWrite(ledPin, HIGH);
        delay(200);
        digitalWrite(ledPin, LOW);
        delay(200);
    } 
    else {
        digitalWrite(ledPin, LOW);
    }

    delay(200);
}
