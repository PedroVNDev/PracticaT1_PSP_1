package controlador;

import com.github.javafaker.Faker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Controlador {

    public static void main(String[] args) {

        int registros, hilos, contador;
        Faker faker = new Faker();

        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce el numero de registros a introducir: ");
        registros = teclado.nextInt();
        teclado.nextLine();

        System.out.print("Introduce el numero de hilos a usar: ");
        hilos = teclado.nextInt();
        teclado.nextLine();

        for(int x = 1; x <= registros; x++){

        try {

            String email = faker.internet().emailAddress();
            int ingresos = (int) Math.floor(Math.random()*990+10);

            String agregar = "INSERT INTO EMPLEADOS (EMAIL, INGRESOS) VALUES('"
                    + email + "', '" + ingresos + "')";
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbdd_psp_1",
                    "DAM2020_PSP", "DAM2020_PSP");
            Statement consulta = conexion.createStatement();

            consulta.executeUpdate(agregar);

            System.out.println("Empleado agregado correctamente");

            conexion.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        }

    }

}
