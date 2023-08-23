package edu.upvictoria.fpoo;

public class Efectivo implements MetodoPago{
    @Override
    public void procesarPago(double monto) {
        System.out.println("Pago de $" + monto + " realizado en efectivo.");
    }
}
