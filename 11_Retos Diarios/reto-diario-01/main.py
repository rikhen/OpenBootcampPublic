# Author: Henrik Liebel
#
# Date: 08.11.21
#
# Version: 1.0
#
# Requires:
#       - Python module(s): pandas
# Inputs:
#       - usuarios.xlsx file
# Outputs:
#       - print emails


import pandas as pd

# Establece la ruta del archivo
file_path = "usuarios.xlsx"
# Lee fichero
df = pd.read_excel(file_path)
# Guarda emails únicos
emails = df.email.unique()
# Imprime emails
print(emails)