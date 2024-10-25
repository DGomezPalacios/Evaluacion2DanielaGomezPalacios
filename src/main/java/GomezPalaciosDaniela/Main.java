package GomezPalaciosDaniela;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GestorEventos gestor = new GestorEventos();

        // evento de mentiritas
        EventoCumpleanos cumple = new EventoCumpleanos(
                1, "2024-10-15", "18:00", "22:00",
                "Salón Festivo", 500000, 50, true, 8
        );

        EventoMatrimonio matrimonio = new EventoMatrimonio(
                2, "2024-11-20", "20:00", "02:00",
                "Hotel Marina", 1500000, 100, true, true
        );

        EventoCena cena = new EventoCena(
                3, "2024-10-10", "20:00", "23:00",
                "Restaurante Central", 800000, 40, false,
                "Gourmet", true
        );

        EventoFiesta fiesta = new EventoFiesta(
                4, "2024-12-31", "22:00", "05:00",
                "Club Nocturno", 2000000, 200, true,
                "Año Nuevo", true
        );

        // Agregar eventos
        gestor.agregarEvento(cumple);
        gestor.agregarEvento(matrimonio);
        gestor.agregarEvento(cena);
        gestor.agregarEvento(fiesta);

        // Mostrar eventos ordenados
        System.out.println("Eventos ordenados por fecha:");
        for (EventoBase evento : gestor.listarEventosPorFecha()) {
            System.out.printf("Código: %d - Tipo: %s - Fecha: %s%n",
                    evento.getCodigo(), evento.obtenerTipoEvento(), evento.getFecha());
        }

        // Mostrar ventas
        System.out.println("\nVentas por tipo de evento:");
        gestor.calcularVentasPorTipo().forEach((tipo, total) ->
                System.out.printf("%s: $%.2f%n", tipo, total));

        // Mostrar tipo más solicitado
        System.out.println("\nTipo de evento más solicitado: " +
                gestor.obtenerTipoMasSolicitado());
    }
}