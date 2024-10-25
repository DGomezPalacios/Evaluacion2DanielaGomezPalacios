package GomezPalaciosDaniela;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
class GestorEventos {
    private List<EventoBase> eventos;
    private int ultimoCodigo;

    public GestorEventos() {
        this.eventos = new ArrayList<>();
        this.ultimoCodigo = 0;
    }

    // Métodos sobrecargados para agregar diferentes tipos de eventos
    public void agregarEvento(EventoCumpleanos evento) {
        eventos.add(evento);
        ultimoCodigo++;
    }

    public void agregarEvento(EventoMatrimonio evento) {
        eventos.add(evento);
        ultimoCodigo++;
    }

    public void agregarEvento(EventoCena evento) {
        eventos.add(evento);
        ultimoCodigo++;
    }

    public void agregarEvento(EventoFiesta evento) {
        eventos.add(evento);
        ultimoCodigo++;
    }

    // Método para listar eventos por fecha
    public List<EventoBase> listarEventosPorFecha() {
        List<EventoBase> eventosOrdenados = new ArrayList<>(eventos);
        Collections.sort(eventosOrdenados, (e1, e2) -> e1.getFecha().compareTo(e2.getFecha()));
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
