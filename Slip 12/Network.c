#include <WiFi.h>     // Use WiFi library (ESP32/ESP8266/Arduino WiFi boards)

void setup() {
    Serial.begin(9600);
    delay(2000);

    Serial.println("Scanning for Wi-Fi networks...");
}

void loop() {
    int n = WiFi.scanNetworks();   // Scan for networks

    if (n == 0) {
        Serial.println("No networks found.");
    } else {
        Serial.print("Number of networks found: ");
        Serial.println(n);

        for (int i = 0; i < n; i++) {
            Serial.print(i + 1);
            Serial.print(") SSID: ");
            Serial.print(WiFi.SSID(i));     // Network name
            Serial.print(" | Signal (RSSI): ");
            Serial.print(WiFi.RSSI(i));     // Signal strength
            Serial.print(" dBm | Encryption: ");
            Serial.println(WiFi.encryptionType(i));
        }
    }

    Serial.println("\nScanning again in 5 seconds...\n");
    delay(5000);
}
