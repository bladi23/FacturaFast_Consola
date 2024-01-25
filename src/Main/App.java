package Main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import Clases.Clientes;
import Clases.Productos;

public class App {
    static Scanner leer = new Scanner(System.in);
    static ArrayList<Clientes> aClient = new ArrayList<Clientes>();
    static ArrayList<Productos> aProducto = new ArrayList<Productos>();

    public static void main(String[] args) {

        menuPrincipal();

    }

    public static void menuPrincipal() {
        boolean salir = false;
        String opcion = "";

        while (salir == false) {
            System.out.println("-----------MENU PRINCIPAL FACTURAFAST --------");
            System.out.println("│Seleccione una sub-menu:                     │");
            System.out.println("│1.Cliente                                    │");
            System.out.println("│2.Producto                                   │");
            System.out.println("│3.Facturador                                 │");
            System.out.println("│4.Reportes                                   │");
            System.out.println("│5.Salir                                      │");
            opcion = leer.nextLine();

            switch (opcion) {

                case "1":
                    menuCliente();
                    break;

                case "2":
                    menuProducto();
                    break;

                case "3":

                    break;

                case "4":
                    menuReportes();
                    break;

                case "5":
                    salir = true;
                    break;

            }

        }
    }

    public static void menuCliente() {

        boolean salir = false;
        String opcion = "";

        while (salir == false) {
            System.out.println("-------- MENU CLIENTE --------");
            System.out.println("1.Adicionar");
            System.out.println("2.Modificar");
            System.out.println("3.Eliminar");
            System.out.println("4.Buscar");
            System.out.println("5.Regresar menu");
            opcion = leer.nextLine();

            switch (opcion) {

                case "1":
                    adicionarCliente();
                    break;

                case "2":
                    // modificarCliente();
                    break;

                case "3":
                    // eliminarCliente();
                    break;

                case "4":
                    // buscarCliente();
                    break;

                case "5":
                    menuPrincipal();
                    break;

            }
        }
    }

    public static void menuProducto() {

        boolean salir = false;
        String opcion = "";

        do {
            System.out.println("-------- MENU PRODUCTO --------");
            System.out.println("1.Adicionar");
            System.out.println("2.Modificar");
            System.out.println("3.Eliminar");
            System.out.println("4.Buscar");
            System.out.println("5.Regresar menu");
            opcion = leer.nextLine();

            switch (opcion) {

                case "1":
                    adicionarProducto();
                    break;

                case "2":
                    modificarProducto();
                    break;

                case "3":
                    eliminarProducto();
                    break;

                case "4":
                    System.out.println("Ingrese código de producto");
                    String codigo = leer.nextLine();
                    buscarProducto(codigo);
                    break;

                case "5":
                    menuPrincipal();
                    break;

            }
        } while (salir == false);
    }

    public static void adicionarProducto() {
        Productos producto = new Productos();
        System.out.println("Ingrese código de producto");
        producto.setCodigo(leer.nextLine());
        System.out.println("Ingrese detalle de producto");
        producto.setDetalle(leer.nextLine());
        System.out.println("Ingrese precio de venta");
        producto.setPvp(Double.parseDouble(leer.nextLine()));
        System.out.println("Ingrese stock");
        producto.setStock(Double.parseDouble(leer.nextLine()));

        aProducto.add(producto);
    }

    public static void modificarProducto() {
        System.out.println("Ingrese código de producto que desea modificar");
        String codigoIngresado = leer.nextLine();
        boolean productoEncontrado = false;
        Iterator<Productos> modificarProducto = aProducto.iterator();
        while (modificarProducto.hasNext()) {
            Productos producto = modificarProducto.next();
            if (producto.getCodigo().equals(codigoIngresado)) {
                System.out.println("Ingrese nuevo código de producto");
                producto.setCodigo(leer.nextLine());
                System.out.println("Ingrese nuevo detalle de producto");
                producto.setDetalle(leer.nextLine());
                System.out.println("Ingrese nuevo precio de venta");
                producto.setPvp(Double.parseDouble(leer.nextLine()));
                System.out.println("Ingrese nuevo stock");
                producto.setStock(Double.parseDouble(leer.nextLine()));
                productoEncontrado = true;
                break;
            }
        }
        if (!productoEncontrado) {
            System.out.println("No existe producto");
        }
    }

    public static void eliminarProducto() {
        System.out.println("Ingrese código de producto");
        String codigo = leer.nextLine();
        Iterator<Productos> eliminarProducto = aProducto.iterator();
        while (eliminarProducto.hasNext()) {
            Productos producto = eliminarProducto.next();
            if (producto.getCodigo().equals(codigo)) {
                eliminarProducto.remove();
            }
        }
    }

    public static void buscarProducto(String codigo) {
        boolean encontrado = false;
        Iterator<Productos> datos_producto = aProducto.iterator();
        while (datos_producto.hasNext()) {
            Productos producto = datos_producto.next();
            if (producto.getCodigo().equals(codigo)) {
                System.out.println("Código: " + producto.getCodigo());
                System.out.println("Detalle: " + producto.getDetalle());
                System.out.println("Precio de venta: " + producto.getPvp());
                System.out.println("Stock: " + producto.getStock());
                encontrado = true;
            }
            if (!encontrado) {
                System.out.println("No existe producto");
            }
        }

    }

    public static void menuReportes() {

        boolean salir = false;
        String opcion = "";

        while (salir == false) {
            System.out.println("-------- REPORTES --------");
            System.out.println("1.Ventas por día");
            System.out.println("2.Ventas por cliente");
            System.out.println("3.Regresar menu");
            opcion = leer.nextLine();

            switch (opcion) {

                case "1":
                    // reporteVentaDia();
                    break;

                case "2":
                    // reporteVentaCliente();
                    break;

                case "3":
                    menuPrincipal();
                    break;

            }
        }
    }

    public static void adicionarCliente() {
        Clientes client = new Clientes();

        String op = "";

        System.out.println("Elija tipo de identificación");
        System.out.println("1.Ruc");
        System.out.println("2.Cedula");

        op = leer.nextLine();

        switch (op) {
            case "1":

                System.out.println("Ingrese número de Ruc");
                String ruc = leer.nextLine();
                client.setRuc(ruc);
                limiteRuc(ruc);
                break;

            case "2":

                System.out.println("Ingrese número de cédula");
                String cedula = leer.nextLine();
                client.setCedula(cedula);
                limiteCedula(cedula);
                break;
        }

        System.out.println("Ingrese razón social de cliente:");
        client.setNombreCliente(leer.nextLine());
        System.out.println("Ingrese email:");
        client.setEmail(leer.nextLine());
        System.out.println("Ingrese dirección");
        client.setDirección(leer.nextLine());

        aClient.add(client);
    }

    public static void limiteCedula(String cedula) {
        boolean salir = false;
        while (salir == false) {
            if (cedula.length() != 10) {
                System.out.println("Cédula incorrecta");
                System.out.println("Ingrese número de cédula");
                cedula = leer.nextLine();
            } else {
                salir = true;
            }
        }
    }

    public static void limiteRuc(String ruc) {
        boolean salir = false;
        while (salir == false) {
            if (ruc.length() != 13) {
                System.out.println("Ruc incorrecto");
                System.out.println("Ingrese número de Ruc");
                ruc = leer.nextLine();
            } else {
                salir = true;
            }
        }
    }
}
