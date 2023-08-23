# Grafos
En esta práctica se realizará la implementación de un _grafo dirigido_ y un
_grafo no dirigido_ con la ayuda de una clase Padre **Grafo**.

Temas utilizados:
- Herencia
- Clases Abstractas
- Clases Anidadas
- Interfaces
- Polimorfismo
- Generacidad

# Primer paso: Configurar el pom
Dentro de nuestro pom, el siguiente código permitirá a maven 
compilar y ejecutar nuestro proyecto.
``` xml
 <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.8.1</version>
        <configuration>
          <source>17</source>
          <target>17</target>
        </configuration>
      </plugin>
      <plugin>
        <groupId>org.codehaus.mojo</groupId>
        <artifactId>exec-maven-plugin</artifactId>
        <version>3.0.0</version>
        <configuration>
          <mainClass>edu.upvictoria.fpoo.App</mainClass>
        </configuration>
      </plugin>
    </plugins>
  </build>
```

## Compilar el proyecto de maven
``` bash
mvn clean && mvn validate && mvn compile
```

## Ejecutar el proyecto
``` bash
mvn exec:java
```

# Paso 2: Clase Padre
Crearemos una clase Grafo como plantilla para representar a los grafos
dirigidos como los no dirigidos. Esta sería una estructura basica y ya que
los grafos comparten vbaaaCrearemos una clase Grafo como plantilla para representar
a los grafos dirigidos como los no dirigidos.

Podemos decir que los grafos comparten las siguientes características:
- Imprimir el grafo
- Añadir un vértice
- Añadir una arista

No importa si es dirigido o no dirigido, los dos grafos comparten esos comportamientos
así que es posible crear una interfaz a partir de esto.

``` java
public interface GraphUtils<T> {
    void printGraph();
    void addVertex(T vertex);
    void addEdge(T sourceVertex, T destinationVertex);
}
```

Una vez tenemos la interfaz podemos proceder con la creación de la clase padre **Grafo**:
```java
public abstract class Graph<T> implements GraphUtils<T> {
    protected Map<T, List<Nodo<T>>> vertices;

    public Graph() {
        this.vertices = new HashMap<>();
    }

    public static class Nodo<T> {
        private T data;

        public Nodo(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    public boolean hasVertex(T vertex) {
        return vertices.containsKey(vertex);
    }

    public void addVertex(T vertex) {
        if (!hasVertex(vertex)) {
            vertices.put(vertex, new ArrayList<>());
        }
    }

}
```

La clase Nodo nos brinda más flexibilidad para crear nuestros propios contenedores. Aunque 
también se podría utilizar un tipo de dato más simple como `List<T>`.

El método `addVertex()` permite añadir vértices al grafo sin repetición.

### Grafo no dirigido
A través de la herencia, podemos crear una clase que extienda la funcionalidad de 
nuestra clase Grafo:

```java
public class UndirectedGraph<T> extends Graph<T> {
    public UndirectedGraph() {
        super();
    }
}
```

_Como se puede notar, no hace falta volver a implementar la interfaz `GraphUtils` debido a que la clase padre ya la esta implementando._

Los grafos no dirigidos son bidireccionales así que para agregar una arista se tiene que 
agregar tanto al vértice de destino como al vecino:
```java
    @Override
    public void addEdge(T sourceVertex, T destinationVertex) {
        if (hasVertex(sourceVertex) && hasVertex(destinationVertex)) {
            List<Nodo<T>> sourceNeighbors = vertices.get(sourceVertex);
            List<Nodo<T>> destinationNeighbors = vertices.get(destinationVertex);

            sourceNeighbors.add(new Nodo<>(destinationVertex));
            destinationNeighbors.add(new Nodo<>(sourceVertex));
        }
   } 
```

Por último se añadirá el método para imprimir el grafo no dirigido:
```java
    @Override
    public void printGraph() {
        for (Map.Entry<T, List<Nodo<T>>> entry : vertices.entrySet()) {
            T vertex = entry.getKey();
            List<Nodo<T>> neighbors = entry.getValue();
            System.out.print(vertex + " -> ");
            for (Nodo<T> neighbor : neighbors) {
                System.out.print(neighbor.getData() + " ");
            }
            System.out.println();
        }
    }
```

 _Se recorre el grafo, se obtiene el nodo actual y se recorre la lista de sus vecinos._
 
### Grafo dirigido
Estructura básica para la clase:
```java
public class DirectedGraph<T> extends Graph<T> {

    public DirectedGraph() {
        super();
    }
}
```

Al contrario que el grafo no dirigido, aquí solo se agrega una vez el vértice cuando se
añade una nueva arista:
```java
    @Override
    public void addEdge(T sourceVertex, T destinationVertex) {
        if (vertices.containsKey(sourceVertex) && vertices.containsKey(destinationVertex)) {
            List<Nodo<T>> neighbors = vertices.get(sourceVertex);
            neighbors.add(new Nodo<>(destinationVertex));
        }
    }
```

A diferencia del `printGraph()` del grafo no dirigido, radica en como se están representando las
aristas así que para imprimirlo se mostrarán las conecciones de manera unidireccional:
```java
@Override
public void printGraph() {
    for (Map.Entry<T, List<Nodo<T>>> entry : vertices.entrySet()) {
        T vertex = entry.getKey();
        List<Nodo<T>> neighbors = entry.getValue();
        System.out.print(vertex + " -> ");
        for (Nodo<T> neighbor : neighbors) {
            System.out.print(neighbor.getData() + " ");
        }
        System.out.println();
    }
}
```

## Paso 3: Implementación de las clases
En esta clase simplemente tenemos un main donde se crean instancias de las clases de los grafos:
``` java
public class App
{
    public static void main( String[] args ) {
        DirectedGraph<Integer> directedGraph = new DirectedGraph<>();
        directedGraph.addVertex(1);
        directedGraph.addVertex(2);
        directedGraph.addVertex(3);
        directedGraph.addEdge(1, 2);
        directedGraph.addEdge(2, 3);
        System.out.println("Grafo Dirigido:");
        directedGraph.printGraph();

        Graph<String> undirectedGraph = new UndirectedGraph<>();
        undirectedGraph.addVertex("A");
        undirectedGraph.addVertex("B");
        undirectedGraph.addVertex("C");
        undirectedGraph.addEdge("A", "B");
        undirectedGraph.addEdge("B", "C");
        System.out.println("Grafo No Dirigido:");
        undirectedGraph.printGraph();
    }
}
``` 

Salida:
```bash
Grafo Dirigido:
1 -> 2 
2 -> 3 
3 -> 
Grafo No Dirigido:
A -> B 
B -> A C 
C -> B 
``` 
