from directories import strings as dict
import directories as dicts


def number_to_string(num):
    # Get the function from switcher dictionary
    str = dict.get(num, "La cadena no es válida")
    # Execute the function
    return str


def convert_to_integer(str):
    # Get the function from switcher dictionary
    num = dict.get(str, "El número no es válido")
    # Execute the function
    return num


# Convierte numeros en cadenas
def convert_to_string(num):
    if num < 20:
        return dicts.unos[num]
    if num == 20:
        return 'veinte'
    if 20 <= num <= 30:
        decena, resto = divmod(num, 10)
        return 'venti' + dicts.unos[resto]
    if 30 <= num <= 99:
        decena, resto = divmod(num, 10)
        if resto != 0:
            return dicts.decenas[decena] + ' y ' + dicts.unos[resto]
        else:
            return dicts.decenas[decena]
    if num == 100:
        return 'cien'
    if num > 100:
        ciento, resto = divmod(num, 10)
        return dicts.cientos[ciento // 10] + dicts.unos[resto % 10]
    if num == 1000:
        return 'mil'
    if num > 1000:
        ciento, resto = divmod(num, 10)
        return dicts.miles[0] + dicts.decenas[ciento] + ' y ' + dicts.unos[resto]