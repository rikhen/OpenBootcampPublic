unos = {
    0: 'cero', 1: 'uno', 2: 'dos', 3: 'tres', 4: 'cuatro', 5: 'cinco', 6: 'seis',
    7: 'siete', 8: 'ocho', 9: 'nueve', 10: 'diez', 11: 'once', 12: 'doce',
    13: 'trece', 14: 'catorce', 15: 'quince',
    16: 'dicicéis', 17: 'dicisiete', 18: 'diciocho', 19: 'dicinueve'}
decenas = {
    2: 'veinte', 3: 'trenta', 4: 'cuarenta', 5: 'cincuenta', 6: 'sesenta',
    7: 'setenta', 8: 'ochenta', 9: 'noventa'}
cientos = {
    0: 'cien', 1: 'ciento', 2: 'doscientos', 3: 'trescientos', 4: 'cuatrocientos', 5: 'quinientos',
    6: 'seiscientos', 7: 'setescientos', 8: 'ochocientos', 9: 'novecientos'}
miles = {
    0: 'mil'}


strings = {
    'cero': 0,
    'uno': 1,
    'dos': 2,
    'tres': 3,
    'cuatro': 4,
    'cinco': 5,
    'seis': 6,
    'siete': 7,
    'ocho': 8,
    'nueve': 9
}


def look_up(value, directory):
    if value in directory:
        return directory.get(value)
    else:
       print(value + " no está en la lista!")