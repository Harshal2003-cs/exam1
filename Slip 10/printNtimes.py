#1
name = input("Enter your name: ")
n = int(input("Enter how many times to print: "))

for i in range(n):
    print(name)
#Using while loop
name = input("Enter your name: ")
n = int(input("Enter how many times to print: "))

count = 0
while count < n:
    print(name)
    count += 1

#2
try:
    a = float(input("Enter numerator: "))
    b = float(input("Enter denominator: "))
    result = a / b
    print("Result =", result)

except ZeroDivisionError:
    print("Error: Cannot divide by zero!")

#3
import time
from datetime import datetime

for i in range(10):
    print("Current time:", datetime.now().strftime("%H:%M:%S"))
    time.sleep(10)   # wait 10 seconds

#4
filename = input("Enter filename: ")

try:
    with open(filename, 'r') as file:
        line_number = 1
        for line in file:
            words = line.split()
            print(f"Line {line_number}: {len(words)} words")
            line_number += 1

except FileNotFoundError:
    print("File not found!")
