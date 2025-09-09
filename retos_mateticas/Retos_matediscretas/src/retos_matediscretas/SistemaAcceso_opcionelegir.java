/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package retos_matediscretas;
import java.util.*;
/**
 *
 * @author SERGIO ORTIZ
 */
public class SistemaAcceso_opcionelegir {
    
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
        

        System.out.print("Ingrese el número de variables: ");
        int n = sc.nextInt();

        String[] nombres = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Nombre de la variable " + (i + 1) + ": ");
            nombres[i] = sc.next();
        }

        // Menú de expresiones predefinidas
        System.out.println("\nElija una expresión lógica:");
        System.out.println("1. (A AND B) OR C");
        System.out.println("2. (A OR B) AND C");
        System.out.println("3. NOT A OR B");
        int opcion = sc.nextInt();

        int totalComb = (int) Math.pow(2, n);

        // Encabezado
        for (String nombre : nombres) {
            System.out.print(nombre + "\t");
        }
        System.out.println("Resultado");

        for (int i = 0; i < totalComb; i++) {
            boolean[] valores = new boolean[n];

            for (int j = 0; j < n; j++) {
                valores[j] = ((i >> (n - j - 1)) & 1) == 1;
                System.out.print(valores[j] + "\t");
            }

            // Evaluación según la opción elegida
            boolean resultado = false;
            if (n >= 3) {
                switch (opcion) {
                    case 1:
                        resultado = (valores[0] && valores[1]) || valores[2];
                        break;
                    case 2:
                        resultado = (valores[0] || valores[1]) && valores[2];
                        break;
                    case 3:
                        resultado = (!valores[0]) || valores[1];
                        break;
                }
            } else if (n == 2) {
                resultado = valores[0] && valores[1]; // por defecto
            } else {
                resultado = valores[0]; // por defecto
            }

            System.out.println(resultado);
        }

        sc.close();
    }
}
