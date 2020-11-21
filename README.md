# Aplicación PSP 1, 2ºDAM
Aplicación que permite agregar empleados a una base de datos mediante Xampp MySQL utilizando hilos dinámicos


### Pre-requisitos 📋

* Java 8


### Instalación 🔧

Puedes descargar el proyecto mediante el botón CODE o clonando el repositorio con git bash
--> $ git clone https://github.com/PinguExtremo/PraticaT1_PSP_1


## Ejecución del programa ⚙️

Para ejecutar la aplicación utiliza la linea de comandos, encuentra donde guardaste el proyecto:
-->cd C://RutaEjemplo/Practica_T1_PSP_1

Una vez dentro de la carpeta del proyecto ejecuta el archivo jar con:
java -jar Practica_T1_PSP_1.jar


### Instrucciones de uso ⌨️

Al inicializar la aplicación nos pediran 2 datos los cuales tendremos que rellenar cumpiendo estas reglas:

* No se puede agregar mas de 1000 registros a la vez
* No se puede crear mas de 20 hilos para la tarea
* No se puede introducir caracteres todos los datos pedidos son de tipo numerico
* No se puede introducir valores negativos
* Todos los hilos tienen que tener la misma carga de tarea Hilos/Registros = 0

---Ejemplo de ejecución---

```
Introduce el numero de registros a introducir: 10
```

```
Introduce el numero de hilos a usar: 2
```

```
Hilo: 1 Realizara 5 registros
Hilo: 2 Realizara 5 registros

¿Quieres añadir mas empleados? 
1.Si
2.No
```

-Si queremos que nos pregunten de nuevo los datos introduciremos un 1 en caso opuesto un 2.

## Resultados 📦

Podremos observar los cambios producidos por el programa en nuestra base de datos local:

Base de datos: BBDD_PSP_1
Tabla: EMPLEADOS
Usuario: DAM2020_PSP
Contraseña: DAM2020_PSP


## Construido con 🛠️

* [IntelliJ IDEA](https://www.jetbrains.com/es-es/idea/) - Entorno de desarrollo
* [Maven](https://maven.apache.org/) - Manejador de dependencias
* Manos - Mi madre


## Creado por ✒️

* **Pedro Vicente Navas** - *Desarrollador* - [PinguExtremo](https://github.com/PinguExtremo)
