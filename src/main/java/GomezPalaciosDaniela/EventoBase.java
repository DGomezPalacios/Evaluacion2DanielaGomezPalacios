package GomezPalaciosDaniela;

abstract class EventoBase implements Cotizable {
    protected int codigo; // Se asignará automáticamente en GestorEventos
    protected String fecha;
    protected String horaInicio;
    protected String horaFin;
    protected String ubicacion;
    protected double precioBase;
    protected int cantidadPersonas;
    protected boolean incluyeEntretencion;

    // Constructor sin parámetro para el código
    public EventoBase(String fecha, String horaInicio, String horaFin,
                      String ubicacion, double precioBase, int cantidadPersonas,
                      boolean incluyeEntretencion) {
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.ubicacion = ubicacion;
        this.precioBase = precioBase;
        this.cantidadPersonas = cantidadPersonas;
        this.incluyeEntretencion = incluyeEntretencion;
    }

    // Método abstracto que cada tipo de evento debe implementar
    abstract String obtenerTipoEvento();

    // Método para aplicar descuento
    public void aplicarDescuento(double porcentaje) {
        this.precioBase -= (precioBase * porcentaje / 100);
    }

    public void aplicarDescuento(double porcentaje, String razon) {
        aplicarDescuento(porcentaje);
        System.out.println("Descuento aplicado por: " + razon);
    }

    // Getters y Setters necesarios
    public String getFecha() {
        return fecha;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    // Método abstracto que cada subclase implementará para calcular el precio total
    public abstract double calcularPrecioTotal();
}
