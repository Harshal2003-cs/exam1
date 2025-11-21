#1
name = input("Enter your name: ")
print("Hello", name + "!")

#2
a = float(input("Enter first number: "))
b = float(input("Enter second number: "))

print("Sum =", a + b)
print("Difference =", a - b)
print("Product =", a * b)

if b != 0:
    print("Division =", a / b)
else:
    print("Division not possible (cannot divide by zero)")

#3
text = input("Enter a string: ")

words = text.split()
word_count = len(words)
char_count = len(text)

print("Number of words =", word_count)
print("Number of characters =", char_count)

#4
shape = input("Enter shape (rectangle/triangle/circle): ").lower()

if shape == "rectangle":
    length = float(input("Enter length: "))
    width = float(input("Enter width: "))
    area = length * width
    print("Area of rectangle =", area)

elif shape == "triangle":
    base = float(input("Enter base: "))
    height = float(input("Enter height: "))
    area = 0.5 * base * height
    print("Area of triangle =", area)

elif shape == "circle":
    radius = float(input("Enter radius: "))
    area = 3.14159 * radius * radius
    print("Area of circle =", area)

else:
    print("Invalid shape entered")
