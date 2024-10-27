package GomezPalaciosDaniela;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    public static void main(String[] args) {
        GestorEventos gestor = new GestorEventos();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            mostrarMenu();
            opcion = validarOpcionMenu(scanner);

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
                    mostrarEventosPorFecha(gestor);
                    break;
                case 6:
                    mostrarVentasPorTipo(gestor);
                    break;
                case 7:
                    mostrarTipoMasSolicitado(gestor);
                    break;
                case 8:
                    System.out.println("Chaito que le vaya bien");
                    break;
                default:
                    System.out.println("Elija una opción entre 1 y 8");
            }
        } while (opcion != 8);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Menú de Gestión de Eventos ---");
        System.out.println("1. Agregar Evento de Cumpleaños");
        System.out.println("2. Agregar Evento de Matrimonio");
        System.out.println("3. Agregar Evento de Cena");
        System.out.println("4. Agregar Evento de Fiesta");
        System.out.println("5. Listar Eventos por Fecha");
        System.out.println("6. Ventas por Tipo de Evento");
        System.out.println("7. Mostrar Tipo de Evento Más Solicitado");
        System.out.println("8. Salir");
    }

    private static int validarOpcionMenu(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Seleccione una opción: ");
                String input = scanner.nextLine().trim();
                int opcion = Integer.parseInt(input);
                if (opcion >= 1 && opcion <= 8) {
                    return opcion;
                }
                System.out.println("Elija una opción entre 1 y 8");
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número por fsvor");
            }
        }
    }

    private static EventoCumpleanos crearEventoCumpleanos(Scanner scanner) {
        System.out.println("\nIngrese los datos para el evento de cumpleaños:");
        String fecha = validarFecha(scanner);
        String horaInicio = validarHora("Hora de inicio (HH:mm): ", scanner);
        String horaFin = validarHoraFin(horaInicio, scanner);
        String ubicacion = validarUbicacion(scanner);
        int cantidadPersonas = validarCantidadPersonas(scanner);
        double precio = validarPrecio(scanner);
        boolean incluyeEntretenimiento = validarBoolean("¿Incluye entretenimiento? (si/no): ", scanner);
        int edadCumpleanero = validarEdad(scanner);

        return new EventoCumpleanos(fecha, horaInicio, horaFin, ubicacion, precio,
                cantidadPersonas, incluyeEntretenimiento, edadCumpleanero);
    }

    private static EventoMatrimonio crearEventoMatrimonio(Scanner scanner) {
        System.out.println("\nIngrese los datos para el evento de matrimonio:");
        String fecha = validarFecha(scanner);
        String horaInicio = validarHora("Hora de inicio (HH:mm): ", scanner);
        String horaFin = validarHoraFin(horaInicio, scanner);
        String ubicacion = validarUbicacion(scanner);
        int cantidadPersonas = validarCantidadPersonas(scanner);
        double precio = validarPrecio(scanner);
        boolean incluyeEntretenimiento = validarBoolean("¿Incluye entretenimiento? (si/no): ", scanner);
        boolean incluyeCeremonia = validarBoolean("¿Incluye ceremonia? (si/no): ", scanner);

        return new EventoMatrimonio(fecha, horaInicio, horaFin, ubicacion, precio,
                cantidadPersonas, incluyeEntretenimiento, incluyeCeremonia);
    }

    private static EventoCena crearEventoCena(Scanner scanner) {
        System.out.println("\nIngrese los datos para el evento de Cena:");
        String fecha = validarFecha(scanner);
        String horaInicio = validarHora("Hora de inicio (HH:mm): ", scanner);
        String horaFin = validarHoraFin(horaInicio, scanner);
        String ubicacion = validarUbicacion(scanner);
        int cantidadPersonas = validarCantidadPersonas(scanner);
        double precio = validarPrecio(scanner);
        boolean incluyeEntretenimiento = validarBoolean("¿Incluye entretenimiento? (si/no): ", scanner);
        boolean incluyeVinos = validarBoolean("¿Incluye Vinos? (si/no): ", scanner);

        return new EventoCena(fecha, horaInicio, horaFin, ubicacion, precio,
                cantidadPersonas, incluyeEntretenimiento, incluyeVinos);
    }

    private static EventoFiesta crearEventoFiesta(Scanner scanner) {
        System.out.println("\nIngrese los datos para el evento de fiesta:");
        String fecha = validarFecha(scanner);
        String horaInicio = validarHora("Hora de inicio (HH:mm): ", scanner);
        String horaFin = validarHoraFin(horaInicio, scanner);
        String ubicacion = validarUbicacion(scanner);
        int cantidadPersonas = validarCantidadPersonas(scanner);
        double precio = validarPrecio(scanner);
        boolean incluyeEntretenimiento = validarBoolean("¿Incluye entretenimiento? (si/no): ", scanner);
        boolean barman = validarBoolean("¿Incluye Barman? (si/no): ", scanner);

        return new EventoFiesta(fecha, horaInicio, horaFin, ubicacion, precio,
                cantidadPersonas, incluyeEntretenimiento, barman);
    }

    private static void mostrarEventosPorFecha(GestorEventos gestor) {
        System.out.println("\nEventos ordenados por fecha:");
        for (EventoBase evento : gestor.listarEventos()) {
            System.out.printf("Código: %d - Tipo: %s - Fecha: %s%n",
                    evento.getCodigo(), evento.obtenerTipoEvento(), evento.getFecha());
        }
    }

    private static void mostrarVentasPorTipo(GestorEventos gestor) {
        System.out.println("\nVentas por tipo de evento:");
        gestor.ventasPorTipo().forEach((tipo, total) ->
                System.out.printf("%s: $%.2f%n", tipo, total));
    }

    private static void mostrarTipoMasSolicitado(GestorEventos gestor) {
        System.out.println("\nTipo de evento más solicitado: " + gestor.masSolicitado());
    }

    // Métodos de validación
    private static String validarFecha(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Fecha (yyyy-MM-dd): ");
                return scanner.nextLine().trim();
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha inválido. Use yyyy-MM-dd");
            }
        }
    }

    private static String validarHora(String mensaje, Scanner scanner) {
        while (true) {
            try {
                System.out.print(mensaje);
                String hora = scanner.nextLine().trim();
                LocalTime.parse(hora, TIME_FORMATTER);
                return hora;
            } catch (DateTimeParseException e) {
                System.out.println("Formato de hora inválido. Use HH:mm (24 horas)");
            }
        }
    }

    private static String validarHoraFin(String horaInicio, Scanner scanner) {
        while (true) {
            String horaFin = validarHora("Hora de fin (HH:mm): ", scanner);
            LocalTime inicio = LocalTime.parse(horaInicio, TIME_FORMATTER);
            LocalTime fin = LocalTime.parse(horaFin, TIME_FORMATTER);

            if (fin.isAfter(inicio) || fin.isBefore(inicio)) {
                // Si la hora de fin es antes que la de inicio se asume que es del otro día
                if (fin.isBefore(inicio)) {
                    System.out.println("El evento termina al día siguiente");
                }
                return horaFin;
            }
            if (fin.equals(inicio)) {
                System.out.println("La hora de fin no puede ser igual a la hora de inicio");
            }}}

    private static String validarUbicacion(Scanner scanner) {
        while (true) {
            System.out.print("Ubicación: ");
            String ubicacion = scanner.nextLine().trim();
            if (ubicacion.length() >= 3 && ubicacion.length() <= 100) {
                return ubicacion;
            }
            System.out.println("La ubicación debe tener entre 3 y 100 caracteres");
        }
    }

    private static int validarCantidadPersonas(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Cantidad de personas: ");
                String input = scanner.nextLine();
                int cantidad = Integer.parseInt(input);
                if (cantidad > 0 && cantidad <= 1000) {
                    return cantidad;
                }
                System.out.println("La cantidad debe estar entre 1 y 1000 personas");
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número por favor");
            }
        }
    }

    private static double validarPrecio(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Precio: ");
                String input = scanner.nextLine();
                double precio = Double.parseDouble(input);
                if (precio >= 0) {
                    return precio;
                }
                System.out.println("El precio no puede ser negativo");
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número por favor");
            }
        }
    }

    private static boolean validarBoolean(String mensaje, Scanner scanner) {
        while (true) {
            System.out.print(mensaje);
            String input = scanner.nextLine().toLowerCase().trim();
            if (input.equals("si") || input.equals("s")) {
                return true;
            } else if (input.equals("no") || input.equals("n")) {
                return false;
            }
            System.out.println("Responda 'si' o 'no'");
        }
    }

    private static int validarEdad(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Edad del cumpleañero: ");
                String input = scanner.nextLine();
                int edad = Integer.parseInt(input);
                if (edad >= 0 && edad <= 150) {
                    return edad;
                }
                System.out.println("La edad debe estar entre 0 y 150 años");
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número por favr");
            }
        }
    }
}