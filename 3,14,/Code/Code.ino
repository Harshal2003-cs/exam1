// include the library code: 
#include <LiquidCrystal.h> //library for LCD 

// initialize the library with the numbers of the interface pins 
LiquidCrystal lcd(13, 12, 11, 10, 9, 8); 

// defines pins numbers
const int SensorPin = 2;
const int LEDPin = 7;

void setup() 
{
  pinMode(SensorPin, INPUT); // Sets the Pin as an Input
  pinMode(LEDPin, OUTPUT); // Sets the Pin as an OUTPUT
  
  lcd.begin(20, 4); // set up the LCD's number of columns and rows:
  lcd.setCursor(0,0); // set the cursor position:
  lcd.print("  THE BRIGHT LIGHT    ");
  lcd.setCursor(0,1);
  lcd.print("  VIBRATION SENSOR");
}
void loop() 
{
  if(digitalRead(SensorPin) == HIGH)
  {
    digitalWrite(LEDPin,HIGH);
    // Prints Message on the LCD
    lcd.setCursor(0,3); 
    lcd.print(" Viration Detected    "); 
    delay(70);
    lcd.setCursor(0,3); 
    lcd.print(" Viration Detected.    "); 
    delay(70);
    lcd.setCursor(0,3); 
    lcd.print(" Viration Detected..   "); 
    delay(70);
    lcd.setCursor(0,3); 
    lcd.print(" Viration Detected...   "); 
    delay(70);
  }
  else
  {
    digitalWrite(LEDPin,LOW);
    // Prints Message on the LCD
    lcd.setCursor(0,3); 
    lcd.print("    No Viration       "); 
  }
  
}


