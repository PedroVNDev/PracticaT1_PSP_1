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
        int registros = 0, hilos = 0, contador;
        boolean mismatch = false;
        Scanner teclado = new Scanner(System.in);

        do {

            try {

                System.out.print("Introduce el numero de registros a introducir: ");
                registros = teclado.nextInt();
                teclado.nextLine();

                System.out.print("Introduce el numero de hilos a usar: ");
                hilos = teclado.nextInt();
                teclado.nextLine();

                if (hilos > registros) {
                    System.out.println("No puedes crear mas hilos que registros. Vuelve a introducir correctamente los datos\n");
                } else if (hilos <= 0 || registros <= 0) {
                    System.out.println("Introduce valores mayores a 0\n");
                } else if (hilos > 20) {
                    System.out.println("No puedes utilizar mas de 20 hilos. Vuelve a introducir correctamente los datos\n");
                } else if (registros > 1000) {
                    System.out.println("No puedes operar mas de 1000 registros. Vuelve a introducir correctamente los datos\n");
                } else {

                    for (int x = 0; x < hilos; x++) {
                        System.out.println("Hilo: " + (x + 1) + " Realizara " + registros / hilos + " registros");
                        new Hilo(registros / hilos).start();
                    }

                    resto = registros / hilos;
                    resto = Math.round(resto);

                    for (int i = 0; i == resto; i++) {
                        System.out.println("Hilo: " + (i + 1) + " Realizara " + registros / hilos + " registros");
                        new Hilo(Math.round(resto)).start();
                    }

                }

            } catch (InputMismatchException ex) {
                teclado.nextLine();
                System.out.println("Introduce valores correctos");
                mismatch = true;
            }

        } while (hilos > registros || hilos > 20 || registros > 1000 || hilos <= 0 || registros <= 0 || mismatch == true);
    }

}
