import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Juan Carlos Alpala
 */
public class Conjuntos {
    
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        // Crear los conjuntos
        Set<Integer> conjuntoA = new HashSet<>();
        Set<Integer> conjuntoB = new HashSet<>();

        // Solicitar tamaño del primer conjunto
       
        int tamA = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la contidad de elementos del conjunto A"));

        // Ingresar elementos del conjunto A
       
        JOptionPane.showMessageDialog(null, "Por favor ingresa los elementos del conjunto A :");
        for (int i = 0; i < tamA; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            int elemento = entrada.nextInt();
            conjuntoA.add(elemento);
        }

        // Solicitar tamaño del segundo conjunto
        int tamB = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la contidad de elementos del conjunto B"));

        // Ingresar elementos del conjunto B19
        JOptionPane.showMessageDialog(null, "Por favor ingresa los elementos del conjunto B:");
        for (int i = 0; i < tamB; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            int elemento = entrada.nextInt();
            conjuntoB.add(elemento);
        }

        // Mostrar los conjuntos ingresados
        System.out.println("\nConjunto A: " + conjuntoA);
        System.out.println("Conjunto B: " + conjuntoB);

        // Verificar si B está contenido en A
        if (esSubconjunto(conjuntoB, conjuntoA)) {
            System.out.println("El conjunto B esta contenido en el conjunto A.");
        } else {
            System.out.println("El conjunto B no esta contenido en el conjunto A.");
        }

        entrada.close();
    }

    // Método que determina si un conjunto está contenido en otro
    public static boolean esSubconjunto(Set<Integer> subconjunto, Set<Integer> conjunto) {
        return conjunto.containsAll(subconjunto);
    }
    }