// Ultrasonic Sensor Pins
const int trigPin = 9;
const int echoPin = 10;

// LED Pin
const int ledPin = 13;

long duration;
int distance;

void setup() {
  pinMode(trigPin, OUTPUT);
  pinMode(echoPin, INPUT);
  pinMode(ledPin, OUTPUT);
  Serial.begin(9600);
}

void loop() {
  // Clear trig pin
  digitalWrite(trigPin, LOW);
  delayMicroseconds(2);

  // Trigger the sensor
  digitalWrite(trigPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigPin, LOW);

  // Read the echo time
  duration = pulseIn(echoPin, HIGH);

  // Convert time to distance (in cm)
  distance = duration * 0.034 / 2;

  // Print distance
  Serial.print("Distance: ");
  Serial.print(distance);
  Serial.println(" cm");

  // LED blink if object is close (less than 20 cm)
  if (distance < 20) {
    digitalWrite(ledPin, HIGH);
    delay(200);
    digitalWrite(ledPin, LOW);
    delay(200);
  } else {
    digitalWrite(ledPin, LOW);
  }

  delay(300);
}
