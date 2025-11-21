#include <WiFi.h>     // For ESP32 or Arduino WiFi boards
// #include <ESP8266WiFi.h>  // Use this for ESP8266

const char* ssid     = "YOUR_WIFI_NAME";      // Change this
const char* password = "YOUR_WIFI_PASSWORD";  // Change this

void setup() {
    Serial.begin(9600);
    delay(2000);

    Serial.println("Scanning for available Wi-Fi networks...");
    
    int n = WiFi.scanNetworks();     // Scan networks

    if (n == 0) {
        Serial.println("No WiFi networks found.");
    } else {
        Serial.print("Networks found: ");
        Serial.println(n);

        for (int i = 0; i < n; i++) {
            Serial.print(i + 1);
            Serial.print(") SSID: ");
            Serial.println(WiFi.SSID(i));
        }
    }

    Serial.println("\nTrying to connect to Wi-Fi...");
    WiFi.begin(ssid, password);

    while (WiFi.status() != WL_CONNECTED) {
        delay(500);
        Serial.print(".");
    }

    Serial.println("\nConnected to Wi-Fi!");
    Serial.print("IP Address: ");
    Serial.println(WiFi.localIP());
}

void loop() {
    // Nothing needed here
}
