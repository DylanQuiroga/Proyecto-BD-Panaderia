import os
import pandas as pd
import matplotlib.pyplot as plt

dir_path = os.path.dirname(os.path.realpath(__file__))

anio = pd.read_csv(dir_path + '/texto1.txt', header=None)
ventas = pd.read_csv(dir_path + '/texto2.txt', header=None)

df = pd.DataFrame({
    'Año': anio[0],
    'Ventas': ventas[0]
})

plt.figure(figsize=(10,6))
bars = plt.bar(df['Año'], df['Ventas'])
plt.ylabel('Ventas')
plt.title('Ventas por años')

# Unir la ruta del directorio con el nombre del archivo
file_path = os.path.join(dir_path, 'grafico.png')

# Añadir las etiquetas dentro de las barras
for i, bar in enumerate(bars):
    yval = bar.get_height()
    plt.text(bar.get_x() + bar.get_width()/2, yval/2, df['Año'][i], ha='center', va='bottom', fontsize=14, rotation=90)

# Eliminar las etiquetas del eje x
plt.xticks([])

# Guardar el gráfico en la ruta especificada
plt.savefig(file_path)