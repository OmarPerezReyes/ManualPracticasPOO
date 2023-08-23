package edu.upvictoria.fpoo;

public class Compra {
    private MetodoPago metodoPago;

    public Compra(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void realizarCompra(double monto) {
        metodoPago.procesarPago(monto);
    }
}
