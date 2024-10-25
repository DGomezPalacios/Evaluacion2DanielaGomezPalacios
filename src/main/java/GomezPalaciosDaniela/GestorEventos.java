package GomezPalaciosDaniela;
import java.util.*;

class GestorEventos {
    private List<EventoBase> eventos;
    private int ultimoCodigo;

    public GestorEventos() {
        this.eventos = new ArrayList<>();
        this.ultimoCodigo = 1; // Inicia desde 1 para el primer evento
    }

    // Método único para agregar eventos de cualquier tipo
    public void agregarEvento(EventoBase evento) {
        evento.setCodigo(ultimoCodigo++); // Asigna el código único y lo incrementa para el siguiente
        eventos.add(evento);
    }

    // Método para listar eventos por fecha
    public List<EventoBase> listarEventosPorFecha() {
        List<EventoBase> eventosOrdenados = new ArrayList<>(eventos);
        eventosOrdenados.sort(Comparator.comparing(EventoBase::getFecha));
        return eventosOrdenados;
    }

    // Método para calcular total de ventas por tipo
    public Map<String, Double> calcularVentasPorTipo() {
        Map<String, Double> ventasPorTipo = new HashMap<>();

        for (EventoBase evento : eventos) {
            String tipo = evento.obtenerTipoEvento();
            double precio = evento.calcularPrecioTotal();
            ventasPorTipo.merge(tipo, precio, Double::sum);
        }

        return ventasPorTipo;
    }

    // Método para obtener el tipo de evento más solicitado
    public String obtenerTipoMasSolicitado() {
        Map<String, Integer> conteoTipos = new HashMap<>();

        for (EventoBase evento : eventos) {
            String tipo = evento.obtenerTipoEvento();
            conteoTipos.merge(tipo, 1, Integer::sum);
        }

        return conteoTipos.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No hay eventos");
    }
}

