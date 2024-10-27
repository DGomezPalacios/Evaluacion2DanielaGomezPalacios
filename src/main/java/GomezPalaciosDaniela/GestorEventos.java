package GomezPalaciosDaniela;
import java.util.*;

class GestorEventos {
    private List<EventoBase> eventos;
    private int ultimoCodigo;

    public GestorEventos() {
        this.eventos = new ArrayList<>();
        this.ultimoCodigo = 1; // Inicia desde 1 para el primer evento
    }

    //  agregar eventos de cualquier tipo
    public void agregarEvento(EventoBase evento) {
        evento.setCodigo(ultimoCodigo++); // Asigna el código único y lo incrementa para el siguiente
        eventos.add(evento);
    }

    //  listar eventos por fecha
    public List<EventoBase> listarEventos() {
        List<EventoBase> eventosOrdenados = new ArrayList<>(eventos);
        eventosOrdenados.sort(Comparator.comparing(EventoBase::getFecha));
        return eventosOrdenados;
    }

    //  calcular total de ventas por tipo
    public Map<String, Double> ventasPorTipo() {
        Map<String, Double> ventasPorTipo = new HashMap<>();

        for (EventoBase evento : eventos) {
            String tipo = evento.obtenerTipoEvento();
            double precio = evento.calcularPrecioTotal();
            ventasPorTipo.merge(tipo, precio, Double::sum);
        }

        return ventasPorTipo;
    }

    //  tipo de evento más solicitado
    public String masSolicitado() {
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

