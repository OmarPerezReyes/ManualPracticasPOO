# InterfacesSimple
Este manual proporciona una guía básica sobre cómo trabajar con interfaces en el lenguaje de programación Java. Las interfaces son una parte fundamental de la programación orientada a objetos en Java y permiten la definición de contratos que las clases deben seguir.

## ¿Qué es una interfaz?

En Java, una interfaz es un conjunto de reglas que le dice a los objetos cómo comportarse, pero no da detalles específicos. Digamos que tienes diferentes juguetes, como un coche de juguete y una muñeca. Ambos son diferentes, pero pueden hacer cosas similares, como moverse o hacer sonidos.

La interfaz en Java es como un conjunto de reglas generales que les dice a los juguetes qué acciones pueden realizar, como "puedes moverte" o "puedes hacer sonidos". Los juguetes (objetos) que siguen estas reglas pueden hacer esas cosas, pero cómo lo hacen depende de cada juguete específico (clase).
## Ventajas de las Interfaces

- Permite lograr la abstracción y el polimorfismo.
- Permite la implementación de múltiples interfaces en una misma clase.
- Ayuda a separar la declaración de la implementación.

---

## Uso Básico

### Declarar una Interfaz

```java
public interface MiInterfaz {
    void metodoAbstracto();
}
```

### Implementar una Interfaz

```java
public class MiClase implements MiInterfaz {
    @Override
    public void metodoAbstracto() {
        // Implementación del método
    }
}
```
Como logramos ver en este codigo, implementamos la interfaz creada utilizando la palabra **implements** y seguidamente el nombre de nuestra interfaz que declaramos antes despues del nombre donde declaramos nuestra clase. El **@Override** es solo para decir que sobreescribiremos el metodo que creamos en nuestra interfaz original.

### Utilizar la Interfaz

```java
public class Main {
    public static void main(String[] args) {
        MiInterfaz instancia = new MiClase();
        instancia.metodoAbstracto();
    }
}
```
En nuestra clase main, hacemos una instancia de la clase a la que le implementamos la interfaz y como logramos observar, el objeto que creamos de nuestra clase con interfaz implementada, puede usar los metodo que esta interfaz le declaramos en un inicio.

---

###### Realizaremos un ejemplo explicado, lo puedes encontrar en este repositorio de Github.

##### Como sabemos, al momento de pagar un producto en una tienda, tenemos varias opciones, como lo pueden ser **Efectivo y Tarjeta de Credito**, y sabemos que estas tiene algo en comun "procesar un pago".
## Declaramos nuestra Interfaz 
```java
public interface MetodoPago {
    void procesarPago(double monto);
}
```
Donde el unico metodo es procesarPaga que lo puede realizar una tarjeta de credito y el efectivo, de esta manera teniendo como parametro el monto de la compra

## Declaramos nuestras clases e implementamos la interfaz
```java
public class Compra {
    private MetodoPago metodoPago;

    public Compra(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void realizarCompra(double monto) {
        metodoPago.procesarPago(monto);
    }
}

public class TarjetaCredito implements MetodoPago{
    @Override
    public void procesarPago(double monto) {
        System.out.println("Pago de $" + monto + " realizado con tarjeta de crédito.");
    }
}

public class Efectivo implements MetodoPago{
    @Override
    public void procesarPago(double monto) {
        System.out.println("Pago de $" + monto + " realizado en efectivo.");
    }
}
```
La clase compra tiene como atributo **metodoPago**, que es una atributo de tipo interfaz MetodoPago, tiene su constructor y una funcion donde se procesara el tipo de pago que se hará.

Como vemos, implementamos en las clases **Tarjetas de Credito** y **Efectivo** nuestra interfaz MetodoPago y solo sobreescribimos la funcion **procesarPago** para cada clase

## Clase Main

```java
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
```
Finalmente, en nuestra clase main instanciamos **tarjeta** como un objeto de tipo **TarjetaCredito** y hacemos una **compraConTarjeta** instanciando la clase Compra y mandando el objeto **tarjeta** como parametro de **Compra** y por ultimo **compraConTarjeta** utilizamos el metodo **realizarCompra** en donde enviaremos el monto de la compra y como todo esto es de un objeto **Tarjeta de Credito** el resultado saldra que fue una "compra hecha con tarjeta de credito".
Usamos la misma logica para Efectivo.