package controlador;

import com.github.javafaker.Faker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Controlador {

    public static void main(String[] args) {

        float resto = 0;
        int registros = 0, opcion, hilos = 0;

        boolean mismatch = false;
        boolean repetir = false;
        Scanner teclado = new Scanner(System.in);

        do {

            try {
                //Preguntamos al usuario los datos necesarios: Hilos y Registros a introducir en la base de datos
                System.out.print("Introduce el numero de registros a introducir: ");
                registros = teclado.nextInt();
                teclado.nextLine();

                System.out.print("Introduce el numero de hilos a usar: ");
                hilos = teclado.nextInt();
                teclado.nextLine();

                //Control de excepciones con limite de hilos registros y carácteres
                if (hilos > registros) {
                    System.out.println("No puedes crear mas hilos que registros. Vuelve a introducir correctamente los datos\n");
                } else if (hilos <= 0 || registros <= 0) {
                    System.out.println("Introduce valores mayores a 0\n");
                } else if (hilos > 20) {
                    System.out.println("No puedes utilizar mas de 20 hilos. Vuelve a introducir correctamente los datos\n");
                } else if (registros > 1000) {
                    System.out.println("No puedes operar mas de 1000 registros. Vuelve a introducir correctamente los datos\n");
                } else if (registros % hilos != 0) {
                    System.out.println("Todos los hilos tienen que dividir la tarea equitativamente introduce un número el cual registros/hilos == 0\n");
                } else {

                    //Llamamos a la clase hilo tantas veces como hilos hemos pedido y dividimos los hilos entre los registros
                    for (int x = 0; x < hilos; x++) {
                        System.out.println("Hilo: " + (x + 1) + " Realizara " + registros / hilos + " registros");
                        new Hilo(registros / hilos).start();
                    }

                    //Preguntamos al usuario si quiere repetir la operación
                    System.out.print("\n¿Quieres añadir mas empleados? \n1.Si\n2.No");
                    opcion = teclado.nextInt();
                    teclado.nextLine();

                    if (opcion == 1) {
                        repetir = true;
                    } else {
                        repetir = false;
                    }

                    System.out.println("\nOperacion realizada");

                }


            } catch (InputMismatchException ex) {
                teclado.nextLine();
                System.out.println("Introduce valores correctos");
                mismatch = true;
            }

        } while (hilos > registros || hilos > 20 || registros > 1000 || hilos <= 0 || registros <= 0 || registros % hilos != 0 || repetir == true || mismatch == true);
    }

}
