/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectop3a;
import java.util.*;
import java.util.*;

public class Main {
 public static void main(String[] args) {
        Grafo grafo = new Grafo();
        
        //agregamos los vertices
      grafo.agregarVertice("Ayutla");
    grafo.agregarVertice("Catarina");
    grafo.agregarVertice("Comitancillo");
    grafo.agregarVertice("Concepción Tutuapa");
    grafo.agregarVertice("El Quetzal");
    grafo.agregarVertice("El Tumbador");
    grafo.agregarVertice("Esquipulas Palo Gordo");
    grafo.agregarVertice("Ixchiguán");
    grafo.agregarVertice("La Blanca");
    grafo.agregarVertice("La Reforma");
    grafo.agregarVertice("Malacatán");
    grafo.agregarVertice("Nuevo Progreso");
    grafo.agregarVertice("Ocós");
    grafo.agregarVertice("Pajapita");
    grafo.agregarVertice("Río Blanco");
    grafo.agregarVertice("San Antonio Sacatepéquez");
    grafo.agregarVertice("San Cristóbal Cucho");
    grafo.agregarVertice("San José El Rodeo");
    grafo.agregarVertice("San José Ojetenam");
    grafo.agregarVertice("San Lorenzo");
    grafo.agregarVertice("San Marcos");
    grafo.agregarVertice("San Miguel Ixtahuacán");
    grafo.agregarVertice("San Pablo");
    grafo.agregarVertice("San Pedro Sacatepéquez");
    grafo.agregarVertice("San Rafael Pie de la Cuesta");
    grafo.agregarVertice("Sibinal");
    grafo.agregarVertice("Sipacapa");
    grafo.agregarVertice("Tacaná");
    grafo.agregarVertice("Tajumulco");
    grafo.agregarVertice("Tejutla");
    
    
// EN ESTA PARTE AGREGAS LAS CONEXIONES DEL ALGORITMO
        grafo.agregarArista("San Marcos", "Comitancillo", 28);
        grafo.agregarArista("Comitancillo", "Sipacapa", 37);
        grafo.agregarArista("Sipacapa", "San Miguel Ixtahuacán", 26);
        grafo.agregarArista("Comitancillo", "Tejutla", 23);
        grafo.agregarArista("San Marcos", "Tejutla", 30);
        grafo.agregarArista("Tejutla", "Concepción Tutuapa", 50);
        grafo.agregarArista("Tejutla", "Ixchiguán", 20);
        grafo.agregarArista("Tejutla", "San José Ojetenam", 33);
        grafo.agregarArista("San Marcos", "Ixchiguán", 44);
        grafo.agregarArista("Ixchiguán", "San José Ojetenam", 30);
        grafo.agregarArista("San José Ojetenam", "Concepción Tutuapa", 45);
        grafo.agregarArista("San Marcos", "Tajumulco", 32);
        grafo.agregarArista("Tajumulco", "Sibinal", 42);
        grafo.agregarArista("Sibinal", "Tacaná", 39);
        grafo.agregarArista("San Marcos", "San Pablo", 38);
        grafo.agregarArista("San Pablo", "Malacatán", 10);
        grafo.agregarArista("San Marcos", "San Rafael Pie de la Cuesta", 24);
        grafo.agregarArista("San Rafael Pie de la Cuesta", "San José El Rodeo", 10);
        grafo.agregarArista("San José El Rodeo", "Catarina", 18);
        grafo.agregarArista("San José El Rodeo", "El Tumbador", 13);
        grafo.agregarArista("El Tumbador", "Pajapita",23);
        grafo.agregarArista("Catarina", "Pajapita", 24);
        grafo.agregarArista("Catarina", "Ayutla", 22);
        grafo.agregarArista("Ayutla", "Ocós", 22);
        grafo.agregarArista("Pajapita", "Ocós", 36);
        grafo.agregarArista("Ocós", "La Blanca", 63);
        grafo.agregarArista("San Marcos", "Esquipulas Palo Gordo", 7);
        grafo.agregarArista("Esquipulas Palo Gordo", "El Tumbador", 43);
        grafo.agregarArista("San Marcos", "Nuevo Progreso", 69);
        grafo.agregarArista("San Marcos", "San Cristóbal Cucho", 13);
        grafo.agregarArista("San Cristóbal Cucho", "La Reforma", 24);
        grafo.agregarArista("San Cristóbal Cucho", "El Quetzal", 25);
        grafo.agregarArista("La Reforma", "El Quetzal", 14);
        grafo.agregarArista("San Marcos", "San Pedro Sacatepéquez", 4);
        grafo.agregarArista("San Pedro Sacatepéquez", "San Lorenzo", 11);
        grafo.agregarArista("San Lorenzo", "Río Blanco", 9);
        grafo.agregarArista("Río Blanco", "San Antonio Sacatepéquez", 101);
        grafo.agregarArista("Comitancillo", "Río Blanco", 23);
        grafo.agregarArista("Sipacapa", "Río Blanco", 60);
        grafo.agregarArista("San Rafael Pie de la Cuesta", "El Tumbador", 24);
        grafo.agregarArista("El Tumbador", "Pajapita", 23);
        grafo.agregarArista("Pajapita", "Ocós", 35);
        grafo.agregarArista("Pajapita", "La Blanca", 63);
        grafo.agregarArista("La Blanca", "Nuevo Progreso", 50);
        grafo.agregarArista("Nuevo Progreso", "La Reforma", 29);
        grafo.agregarArista("Nuevo Progreso", "El Quetzal", 24);
        grafo.agregarArista("El Quetzal", "San Antonio Sacatepéquez", 40);
                                                                                  
                                                                               
                                                                       
     // Crear un objeto Scanner para recibir la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("--------------------------------------------------------------------------------------------------------");
            System.out.println("!!!BIENVENIDO  AL PROGRAMA QUE TE MOSTRARA LA RUTA MAS CORTA DESDE LA CABECERA CENTRAL A TU DESTINO!!!");
            System.out.println("INGRESA EL MUNICIPIO DE DESTINO (presiona 0 para salir)");
            System.out.println("--------------------------------------------------------------------------------------------------------");

            // Leer el destino ingresado por el usuario
            String destino = scanner.nextLine();

            if (destino.equals("0")) {
                System.out.println("Saliendo del programa...");
                break;
            }

            // Calcular las distancias mínimas desde "San Marcos" hasta todos los demás vértices
            Map<Vertice, Integer> distancias = grafo.calcularDistancias("San Marcos");
            // Obtener la ruta más corta desde "San Marcos" hasta el destino especificado
            List<Vertice> ruta = grafo.obtenerRuta(destino);

            System.out.println("RUTA MAS CORTA DESDE SAN MARCOS HASTA:" + destino + ":");
            // Imprimir la ruta paso a paso con las distancias
            for (int i = 0; i < ruta.size() - 1; i++) {
                Vertice origen = ruta.get(i);
                Vertice siguiente = ruta.get(i + 1);
                int distancia = grafo.getDistanciaArista(origen, siguiente);
                System.out.println(origen.getNombre() + " -> " + siguiente.getNombre() + " (" + distancia + " km)");
            }

            // Obtener la distancia total recorrida
            int distanciaTotal = distancias.get(grafo.getVertice(destino));
            System.out.println("DISTANCIA TOTAL RECORRIDA: " + distanciaTotal + " KM");
        }
}
}