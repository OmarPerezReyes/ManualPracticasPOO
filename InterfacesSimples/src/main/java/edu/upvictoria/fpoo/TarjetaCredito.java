package edu.upvictoria.fpoo;

public class TarjetaCredito implements MetodoPago{
    @Override
    public void procesarPago(double monto) {
        System.out.println("Pago de $" + monto + " realizado con tarjeta de crédito.");
    }
}
