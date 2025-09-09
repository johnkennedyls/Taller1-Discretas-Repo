/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package retos_matediscretas;

/**
 *
 * @author SERGIO ORTIZ
 */
import java.util.*; 

public class SistemaAcceso {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ---------------- PARTE 1: ACCESO AL SISTEMA ----------------
        System.out.println("=== Sistema de Acceso ===");
        
        // Pedir datos al usuario
        System.out.print("¿Es administrador? (true/false): ");
        boolean esAdmin = sc.nextBoolean();

        System.out.print("¿Clave correcta? (true/false): ");
        boolean claveCorrecta = sc.nextBoolean();

        System.out.print("¿Acceso especial? (true/false): ");
        boolean accesoEspecial = sc.nextBoolean();

        // Condición de acceso: (esAdmin AND claveCorrecta) OR accesoEspecial
        boolean acceso = (esAdmin && claveCorrecta) || accesoEspecial;

        // Mostrar resultado
        if (acceso) {
            System.out.println("✅ Acceso concedido.");
        } else {
            System.out.println("❌ Acceso denegado.");
        }

        // ---------------- PARTE 2: TABLA DE VERDAD ----------------
        System.out.println("\n=== Generación de Tabla de Verdad ===");
        System.out.print("Ingrese el número de variables lógicas: ");
        int n = sc.nextInt();

        // Guardamos los nombres de las variables
        String[] nombres = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Nombre de la variable " + (i + 1) + ": ");
            nombres[i] = sc.next();
        }

        // Número total de combinaciones = 2^n
        int totalComb = (int) Math.pow(2, n);

        // Encabezado de la tabla
        for (String nombre : nombres) {
            System.out.print(nombre + "\t");
        }
        System.out.println("Resultado");

        // ---------------- PARTE 3: EVALUACIÓN DE EXPRESIÓN ----------------
        // Expresión lógica predefinida de ejemplo: 
        // (A AND B) OR C, si hay al menos 3 variables
        // Si no hay 3, se hace con lo que haya.
        for (int i = 0; i < totalComb; i++) {
            boolean[] valores = new boolean[n];
            
            // Generar combinación binaria
            for (int j = 0; j < n; j++) {
                valores[j] = ((i >> (n - j - 1)) & 1) == 1;
            }

            // Imprimir valores
            for (boolean v : valores) {
                System.out.print(v + "\t");
            }

            // Evaluar expresión lógica (ejemplo)
            boolean resultado;
            if (n >= 3) {
                // Expresión: (Var0 AND Var1) OR Var2
                resultado = (valores[0] && valores[1]) || valores[2];
            } else if (n == 2) {
                // Expresión: (Var0 AND Var1)
                resultado = (valores[0] && valores[1]);
            } else {
                // Solo una variable → resultado = esa variable
                resultado = valores[0];
            }

            // Mostrar resultado
            System.out.println(resultado);
        }

        sc.close();
    }
}