import operator
import sys


def add(num1, num2):
    return num1 + num2


def subtract(num1, num2):
    return num1 - num2


def multiply(num1, num2):
    return num1 * num2


def divide(num1, num2):
    return num1 // num2


OPERATIONS = {
    'suma': add,
    'resta': subtract,
    'multiplica': multiply,
    'divide': divide
}


def calculate(string, num1, num2):
    op = OPERATIONS.get(string, None)
    if op is not None:
        return op(num1, num2)
    else:
        #return None  # How to handle this?
        sys.exit("El operador no es válido!")

# Hacer la operación
def operation(operador, x, y):
    if operador == "suma":
        restultado = add(x, y)
    elif operador == "multiplica":
        restultado = multiply(x, y)
    elif operador == "resta":
        restultado = rest(x, y)
    elif operador == "divide":
        restultado = divide(x, y)
    else:
        sys.exit("El operador no es válido!")