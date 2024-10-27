package GomezPalaciosDaniela;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorEventos gestor = new GestorEventos();
        Scanner scanner = new Scanner(System.in);


        int opcion;
        do {
            System.out.println("\n--- Menú de Gestión de Eventos ---");
            System.out.println("1. Agregar Evento de Cumpleaños");
            System.out.println("2. Agregar Evento de Matrimonio");
            System.out.println("3. Agregar Evento de Cena");
            System.out.println("4. Agregar Evento de Fiesta");
            System.out.println("5. Listar Eventos por Fecha");
            System.out.println("6. Calcular Ventas por Tipo de Evento");
            System.out.println("7. Mostrar Tipo de Evento Más Solicitado");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar el buffer

            switch (opcion) {
                case 1:
                    gestor.agregarEvento(crearEventoCumpleanos(scanner));
                    break;
                case 2:
                    gestor.agregarEvento(crearEventoMatrimonio(scanner));
                    break;
                case 3:
                    gestor.agregarEvento(crearEventoCena(scanner));
                    break;
                case 4:
                    gestor.agregarEvento(crearEventoFiesta(scanner));
                    break;
                case 5:
                    System.out.println("\nEventos ordenados por fecha:");
                    for (EventoBase evento : gestor.listarEventosPorFecha()) {
                        System.out.printf("Código: %d - Tipo: %s - Fecha: %s%n",
                                evento.getCodigo(), evento.obtenerTipoEvento(), evento.getFecha());
                    }
                    break;
                case 6:
                    System.out.println("\nVentas por tipo de evento:");
                    gestor.calcularVentasPorTipo().forEach((tipo, total) ->
                            System.out.printf("%s: $%.2f%n", tipo, total));
                    break;
                case 7:
                    System.out.println("\nTipo de evento más solicitado: " +
                            gestor.obtenerTipoMasSolicitado());
                    break;
                case 8:
                    System.out.println("Chaito que le vaya bien!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 8);

        scanner.close();
    }

    private static EventoCumpleanos crearEventoCumpleanos(Scanner scanner) {
        System.out.println("Ingrese los datos para el evento de cumpleaños:");
        String fecha = solicitarCadena("Fecha (yyyy-mm-dd): ", scanner);
        String horaInicio = solicitarCadena("Hora de inicio (hh:mm): ", scanner);
        String horaFin = solicitarCadena("Hora de fin (hh:mm): ", scanner);
        String ubicacion = solicitarCadena("Ubicación: ", scanner);
        double precio = solicitarDouble("Precio: ", scanner);
        int cantidadPersonas = solicitarEntero("Cantidad de personas: ", scanner);
        boolean incluyeEntretenimiento = solicitarBoolean("¿Incluye entretenimiento? (true/false): ", scanner);
        int edadCumpleanero = solicitarEntero("Edad del cumpleañero: ", scanner);

        return new EventoCumpleanos(fecha, horaInicio, horaFin, ubicacion, precio, cantidadPersonas, incluyeEntretenimiento, edadCumpleanero);
    }

    private static EventoMatrimonio crearEventoMatrimonio(Scanner scanner) {
        System.out.println("Ingrese los datos para el evento de matrimonio:");
        String fecha = solicitarCadena("Fecha (yyyy-mm-dd): ", scanner);
        String horaInicio = solicitarCadena("Hora de inicio (hh:mm): ", scanner);
        String horaFin = solicitarCadena("Hora de fin (hh:mm): ", scanner);
        String ubicacion = solicitarCadena("Ubicación: ", scanner);
        double precio = solicitarDouble("Precio: ", scanner);
        int cantidadPersonas = solicitarEntero("Cantidad de personas: ", scanner);
        boolean incluyeEntretenimiento = solicitarBoolean("¿Incluye entretenimiento? (true/false): ", scanner);
        boolean incluyeCeremonia = solicitarBoolean("¿Incluye ceremonia? (true/false): ", scanner);
        return new EventoMatrimonio(fecha, horaInicio,horaFin,ubicacion,precio,cantidadPersonas,incluyeEntretenimiento,incluyeCeremonia);
    }

    private static EventoCena crearEventoCena(Scanner scanner){
        System.out.println("Ingrese los datos para el evento de Cena:");
        String fecha = solicitarCadena("Fecha (yyyy-mm-dd): ", scanner);
        String horaInicio = solicitarCadena("Hora de inicio (hh:mm): ", scanner);
        String horaFin = solicitarCadena("Hora de fin (hh:mm): ", scanner);
        String ubicacion = solicitarCadena("Ubicación: ", scanner);
        double precio = solicitarDouble("Precio: ", scanner);
        int cantidadPersonas = solicitarEntero("Cantidad de personas: ", scanner);
        boolean incluyeEntretenimiento = solicitarBoolean("¿Incluye entretenimiento? (true/false): ", scanner);
        boolean incluyeVinos = solicitarBoolean("¿Incluye Vinos? (true/false)", scanner);
        return new EventoCena(fecha, horaInicio, horaFin, ubicacion, precio, cantidadPersonas, incluyeEntretenimiento, incluyeVinos);
    }
    private static EventoFiesta crearEventoFiesta(Scanner scanner) {
        System.out.println("Ingrese los datos para el evento de fiesta:");
        String fecha = solicitarCadena("Fecha (yyyy-mm-dd): ", scanner);
        String horaInicio = solicitarCadena("Hora de inicio (hh:mm): ", scanner);
        String horaFin = solicitarCadena("Hora de fin (hh:mm): ", scanner);
        String ubicacion = solicitarCadena("Ubicación: ", scanner);
        double precio = solicitarDouble("Precio: ", scanner);
        int cantidadPersonas = solicitarEntero("Cantidad de personas: ", scanner);
        boolean incluyeEntretenimiento = solicitarBoolean("¿Incluye entretenimiento? (true/false): ", scanner);
        String tematica = solicitarCadena("Tematica: ", scanner);
        boolean barman = solicitarBoolean("¿Incluye Barman? (true/false)", scanner);
        return new EventoFiesta(fecha, horaInicio, horaFin, ubicacion, precio, cantidadPersonas, incluyeEntretenimiento, barman);
    }

    private static int solicitarEntero(String mensaje, Scanner scanner) {
        System.out.print(mensaje);
        return scanner.nextInt();
    }

    private static double solicitarDouble(String mensaje, Scanner scanner) {
        System.out.print(mensaje);
        return scanner.nextDouble();
    }

    private static String solicitarCadena(String mensaje, Scanner scanner) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    private static boolean solicitarBoolean(String mensaje, Scanner scanner) {
        System.out.print(mensaje);
        return scanner.nextBoolean();
    }
}
