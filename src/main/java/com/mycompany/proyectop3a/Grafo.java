/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectop3a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 *
 * @author USUARIO
 */
class Grafo {
    private Map<String, Vertice> vertices;

    // Constructor de la clase Grafo
    public Grafo() {
        vertices = new HashMap<>(); // Inicializa el mapa de vértices
    }

    // Agrega un vértice al grafo
    public void agregarVertice(String nombre) {
        vertices.put(nombre, new Vertice(nombre)); // Crea un nuevo vértice y lo agrega al mapa de vértices
    }

    // Agrega una arista entre dos vértices con un peso determinado
    public void agregarArista(String origen, String destino, int peso) {
        Vertice verticeOrigen = vertices.get(origen); // Obtiene el vértice de origen desde el mapa de vértices
        Vertice verticeDestino = vertices.get(destino); // Obtiene el vértice de destino desde el mapa de vértices
        verticeOrigen.agregarVecino(verticeDestino, peso); // Agrega el vértice de destino como vecino del vértice de origen con el peso indicado
        verticeDestino.agregarVecino(verticeOrigen, peso); // Agrega el vértice de origen como vecino del vértice de destino con el peso indicado
    }

    // Obtiene un vértice por su nombre desde el grafo
    public Vertice getVertice(String nombre) {
        return vertices.get(nombre); // Retorna el vértice con el nombre indicado desde el mapa de vértices
    }

    // Obtiene la distancia de una arista entre dos vértices
    public int getDistanciaArista(Vertice origen, Vertice destino) {
        return origen.getPesoArista(destino); // Retorna el peso de la arista entre los vértices de origen y destino
    }

    // Calcula las distancias mínimas desde un vértice de origen a todos los demás vértices
    public Map<Vertice, Integer> calcularDistancias(String origen) {
        Vertice verticeOrigen = vertices.get(origen); // Obtiene el vértice de origen desde el mapa de vértices

        // Inicializa el mapa de distancias con todos los vértices con un valor máximo (infinito) excepto el vértice de origen con distancia 0
        Map<Vertice, Integer> distancias = new HashMap<>();
        for (Vertice vertice : vertices.values()) {
            distancias.put(vertice, Integer.MAX_VALUE);
        }
        distancias.put(verticeOrigen, 0);

        // Conjuntos de vértices visitados y no visitados
        Set<Vertice> visitados = new HashSet<>();
        Set<Vertice> noVisitados = new HashSet<>();
        noVisitados.add(verticeOrigen);

        // Algoritmo de Dijkstra para encontrar las distancias mínimas
        while (!noVisitados.isEmpty()) {
            // Obtiene el vértice con la menor distancia en el conjunto de no visitados
            Vertice actual = obtenerVerticeMenorDistancia(noVisitados, distancias);
            visitados.add(actual);
            noVisitados.remove(actual);

            // Recorre los vecinos del vértice actual y actualiza las distancias mínimas si es necesario
            for (Vertice vecino : actual.getVecinos()) {
                if (!visitados.contains(vecino)) {
                    int distancia = distancias.get(actual) + actual.getPesoArista(vecino);
                    if (distancia < distancias.get(vecino)) {
                        distancias.put(vecino, distancia);
                        vecino.setVerticeAnterior(actual);
                        noVisitados.add(vecino);
                    }
                }
            }
        }

        return distancias; // Retorna el mapa de distancias mínimas
    }

    // Obtiene el vértice con la menor distancia en un conjunto de vértices
    private Vertice obtenerVerticeMenorDistancia(Set<Vertice> vertices, Map<Vertice, Integer> distancias) {
        Vertice minVertice = null;
        for (Vertice vertice : vertices) {
            if (minVertice == null || distancias.get(vertice) < distancias.get(minVertice)) {
                minVertice = vertice;
            }
        }
        return minVertice; // Retorna el vértice con la menor distancia
    }

    // Obtiene la ruta desde el vértice de destino hasta el vértice de origen
    public List<Vertice> obtenerRuta(String destino) {
        Vertice verticeDestino = vertices.get(destino); // Obtiene el vértice de destino desde el mapa de vértices
        List<Vertice> ruta = new ArrayList<>();

        // Construye la ruta agregando los vértices desde el destino hasta el origen
        while (verticeDestino != null) {
            ruta.add(0, verticeDestino);
            verticeDestino = verticeDestino.getVerticeAnterior();
        }

        return ruta; // Retorna la ruta desde el destino hasta el origen
    }
}

class Vertice {
    private String nombre;
    private Map<Vertice, Integer> vecinos;
    private Vertice verticeAnterior;

    // Constructor de la clase Vertice
    public Vertice(String nombre) {
        this.nombre = nombre;
        vecinos = new HashMap<>(); // Inicializa el mapa de vecinos del vértice
        verticeAnterior = null; // Inicializa el vértice anterior como null
    }

    // Retorna el nombre del vértice
    public String getNombre() {
        return nombre;
    }

    // Agrega un vértice vecino con un peso determinado
    public void agregarVecino(Vertice vecino, int peso) {
        vecinos.put(vecino, peso); // Agrega el vértice vecino al mapa de vecinos con el peso indicado
    }

    // Retorna una colección de los vértices vecinos
    public Collection<Vertice> getVecinos() {
        return vecinos.keySet(); // Retorna los vértices vecinos como una colección
    }

    // Retorna el peso de la arista entre este vértice y un vértice vecino
    public int getPesoArista(Vertice vecino) {
        return vecinos.get(vecino); // Retorna el peso de la arista entre este vértice y el vértice vecino
    }

    // Retorna el vértice anterior en la ruta más corta hacia este vértice
    public Vertice getVerticeAnterior() {
        return verticeAnterior; // Retorna el vértice anterior
    }

    // Establece el vértice anterior en la ruta más corta hacia este vértice
    public void setVerticeAnterior(Vertice verticeAnterior) {
        this.verticeAnterior = verticeAnterior; // Establece el vértice anterior
    }
}
