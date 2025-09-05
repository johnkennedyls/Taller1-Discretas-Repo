
package Paquete_1;

import java.util.Scanner;

public class TablaVerdad {
    
    public static void main(String[] args) {
        
        
        try {
            
        Scanner sc = new Scanner(System.in);

        
        // 1. Pedir número de variables
        System.out.print("Ingrese el numero de variables: ");
        int n = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        // 2. Pedir los nombres de las variables
        String[] variables = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Nombre de la variable " + (i+1) + ": ");
            variables[i] = sc.nextLine();
        }

        // Ejemplo de expresión lógica predefinida
        // Aquí usaremos (A AND B) OR (NOT C) como ejemplo.
        // Puedes cambiar esta expresión dentro del método evaluarExpresion.
        System.out.println("\nTabla de verdad para la expresion: (( p&&q )&&r) || (( p&&q )|| !r) ");

        // 3. Imprimir encabezado de la tabla
        for (String var : variables) {
            System.out.print(var + "\t");
        }
        System.out.println("| Resultado");

        // 4. Generar todas las combinaciones posibles
        int filas = (int) Math.pow(2, n); // 2^n combinaciones
        for (int i = 0; i < filas; i++) {
            boolean[] valores = new boolean[n];

            // Convertir el número i a binario y asignar valores True/False
            for (int j = 0; j < n; j++) {
                // El bit correspondiente nos dice si es true o false
                valores[j] = ((i >> (n - j - 1)) & 1) == 1;
                System.out.print(valores[j] + "\t");
            }

            // 5. Evaluar la expresión lógica predefinida
            boolean resultado = evaluarExpresion(valores, variables);

            System.out.println("| " + resultado);
        }

        sc.close();
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al ingresar los datos!!!!");
        }
    } 

    /**
     * Método que evalúa una expresión lógica predefinida.
     * Puedes modificar este método para probar distintas expresiones.
     *
     * Ejemplo: (p AND q) OR (NOT r)
     */
    public static boolean evaluarExpresion(boolean[] valores, String[] variables) {
        // Asumimos que hay al menos 3 variables: p, q, r
        // valores[0] -> p
        // valores[1] -> q 
        // valores[2] -> r
        if (variables.length >= 3) {
            boolean p = valores[0];  
            boolean q = valores[1 ];
            boolean r = valores[2];
            return ((p&&q)&&r)||((p&&q)||!r);
        }
        // Si no hay suficientes variables, devolvemos false por defecto
        return false;
    }
}

