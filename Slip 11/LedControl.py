#sudo apt-get install python3-rpi.gpio

import RPi.GPIO as GPIO
import time

GPIO.setmode(GPIO.BCM)
LED = 18

GPIO.setup(LED, GPIO.OUT)

print("LED ON")
GPIO.output(LED, True)
time.sleep(3)

print("LED OFF")
GPIO.output(LED, False)

GPIO.cleanup()

#2
import RPi.GPIO as GPIO
import time

GPIO.setmode(GPIO.BCM)

SW1 = 17
SW2 = 27
LED1 = 22
LED2 = 23

GPIO.setup(SW1, GPIO.IN, pull_up_down=GPIO.PUD_UP)
GPIO.setup(SW2, GPIO.IN, pull_up_down=GPIO.PUD_UP)
GPIO.setup(LED1, GPIO.OUT)
GPIO.setup(LED2, GPIO.OUT)

print("Press switches...")

try:
    while True:
        if GPIO.input(SW1) == GPIO.LOW:    # Switch pressed
            GPIO.output(LED1, True)
        else:
            GPIO.output(LED1, False)

        if GPIO.input(SW2) == GPIO.LOW:
            GPIO.output(LED2, True)
        else:
            GPIO.output(LED2, False)

        time.sleep(0.1)

except KeyboardInterrupt:
    GPIO.cleanup()

#3
import RPi.GPIO as GPIO
import time

# Read ON and OFF times from file
on_time = 1
off_time = 1

with open("times.txt", "r") as file:
    for line in file:
        if "ON" in line:
            on_time = float(line.split("=")[1])
        elif "OFF" in line:
            off_time = float(line.split("=")[1])

print("ON Time:", on_time, "seconds")
print("OFF Time:", off_time, "seconds")

GPIO.setmode(GPIO.BCM)
LED = 18
GPIO.setup(LED, GPIO.OUT)

try:
    while True:
        GPIO.output(LED, True)
        time.sleep(on_time)

        GPIO.output(LED, False)
        time.sleep(off_time)

except KeyboardInterrupt:
    GPIO.cleanup()
