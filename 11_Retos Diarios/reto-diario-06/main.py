# ----------------------------------------------------------------------------
# OpenBootcamp - Reto Diario 06
# Created By  : Rikhen
# version =' 1.0'
# ---------------------------------------------------------------------------

import sys
import calculator as calc
import converter as conv
import validations as valid

print("Introduzca el cálculo deseado (operadores válidos: suma, resta, multiplica, divide)")
str = input()
varstrs = str.split()

if len(varstrs) != 4:
    sys.exit("La entrada no es correcta!")

# Comprueba si las variables son de tipo 'string'
for s in varstrs:
    if valid.is_string(s):
        continue
    else:
        sys.exit(str(s) + " no es una cadena!")

# Asigna las variables
operador = varstrs[0]
conector = varstrs[2]
num1str = varstrs[1]
num2str = varstrs[3]

# Comprueba si conector es 'y'
if conector != 'y':
    sys.exit("El conector no es válido!")

# Comprueba si la variable está incluida en el directorio
if valid.is_exists(num1str):
    try:
        # Convierte la cadena en un número
        num1int = conv.convert_to_integer(num1str)
    except Exception as e:
        sys.exit("Ha ocurrido un error: " + e)
else:
    sys.exit("El valor " + num1str + " no es válido")

if valid.is_exists(num2str):
    try:
        num2int = conv.convert_to_integer(num2str)
    except Exception as e:
        sys.exit("Ha ocurrido un error: " + e)
else:
    sys.exit("El valor " + num2str + " no es válido")

# Calcula resultado en números
try:
    resint = calc.calculate(operador, num1int, num2int)
except Exception as e:
    sys.exit("Ha ocurrido un error: " + e)

# Convierte el resultado en una cadena
try:
     resstr = conv.convert_to_string(abs(resint))
     if resint < 0:
         resstr = "menos " + resstr
except Exception as e:
    sys.exit("Ha ocurrido un error: " + e)

# Imprime el resultado final
print("Resultado: ", resstr)




