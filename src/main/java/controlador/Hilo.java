package controlador;

import com.github.javafaker.Faker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Hilo extends Thread{

    private int registros;

    public Hilo(int registros) {
        this.registros = registros;
    }

    public void run(){

        for (int x = 1; x <= registros; x++) {

            try {

                Faker faker = new Faker();
                String email = faker.internet().emailAddress();
                int ingresos = (int) Math.floor(Math.random() * 990 + 10);

                String agregar = "INSERT INTO EMPLEADOS (EMAIL, INGRESOS) VALUES('"
                        + email + "', '" + ingresos + "')";
                Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbdd_psp_1",
                        "DAM2020_PSP", "DAM2020_PSP");
                Statement consulta = conexion.createStatement();

                consulta.executeUpdate(agregar);

                conexion.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }finally {
                System.out.println("Empleado agregado");
            }
    }

    }
}
