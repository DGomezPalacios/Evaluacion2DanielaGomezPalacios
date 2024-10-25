package GomezPalaciosDaniela;

abstract class EventoBase implements Cotizable {
    protected int codigo;
    protected String fecha;
    protected String horaInicio;
    protected String horaFin;
    protected String ubicacion;
    protected double precioBase;
    protected int cantidadPersonas;
    protected boolean incluyeEntretencion;

    // Constructor
    public EventoBase(int codigo, String fecha, String horaInicio, String horaFin,
                      String ubicacion, double precioBase, int cantidadPersonas,
                      boolean incluyeEntretencion) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.ubicacion = ubicacion;
        this.precioBase = precioBase;
        this.cantidadPersonas = cantidadPersonas;
        this.incluyeEntretencion = incluyeEntretencion;
    }

    //Método abstracto que cada tipo de evento debe implementar
    abstract String obtenerTipoEvento();

    // Sobrecarga del método aplicarDescuento
    public void aplicarDescuento(double porcentaje) {
        this.precioBase = precioBase - (precioBase * porcentaje / 100);
    }

    public void aplicarDescuento(double porcentaje, String razon) {
        aplicarDescuento(porcentaje);
        System.out.println("Descuento aplicado por: " + razon);
    }

    // Getters
    public String getFecha() { return fecha; }
    public int getCodigo() { return codigo; }

    public abstract double calcularPrecioTotal();
}

