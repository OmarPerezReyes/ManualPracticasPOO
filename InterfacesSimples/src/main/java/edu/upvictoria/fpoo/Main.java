package edu.upvictoria.fpoo;

public class Main {
    public static void main(String[] args) {

        MetodoPago tarjeta = new TarjetaCredito();
        Compra compraConTarjeta = new Compra(tarjeta);
        compraConTarjeta.realizarCompra(50.0);

        MetodoPago efectivo = new Efectivo();
        Compra compraEnEfectivo = new Compra(efectivo);
        compraEnEfectivo.realizarCompra(30.0);

    }
}