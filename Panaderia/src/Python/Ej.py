import os
import matplotlib.pyplot as plt

# Datos de ejemplo
barras = ['Barra 1', 'Barra 2', 'Barra 3', 'Barra 4', 'Barra 5']
altura = [10, 15, 7, 10, 5]

# Crear el gráfico de barras
plt.bar(barras, altura)

# Obtener la ruta del directorio actual
dir_path = os.path.dirname(os.path.realpath(__file__))

# Unir la ruta del directorio con el nombre del archivo
file_path = os.path.join(dir_path, 'grafico.png')

# Guardar el gráfico en la ruta especificada
plt.savefig(file_path)
