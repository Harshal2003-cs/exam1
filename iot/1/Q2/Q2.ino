#include <WiFi.h>

void setup() {
    Serial.begin(9600);
    WiFi.mode(WIFI_STA);
    WiFi.disconnect();
    delay(100);
}

void loop() {
    Serial.println("Scanning WiFi networks...");

    int n = WiFi.scanNetworks();
    if (n == 0) {
        Serial.println("No networks found");
    } else {
        Serial.print(n);
        Serial.println(" networks found:");

        for (int i = 0; i < n; i++) {
            Serial.print(i + 1);
            Serial.print(": ");
            Serial.print(WiFi.SSID(i));
            Serial.print(" (");
            Serial.print(WiFi.RSSI(i));
            Serial.println(" dBm)");
        }
    }

    delay(5000);
}
