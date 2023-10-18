import psycopg2
import sys

con = None
con = psycopg2.connect(host='10.4.3.195',
                       database='panaderia',
                       user='panaderia',
                       password='im7stB6')

con.close()