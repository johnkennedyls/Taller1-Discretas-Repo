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
public class SistemaAcceso_EscribaExpresion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ---------------- PARTE 1: SISTEMA DE ACCESO ----------------
        System.out.println("=== SISTEMA DE ACCESO ===");
        
        System.out.print("¿Es administrador? (true/false): ");
        boolean esAdmin = sc.nextBoolean();

        System.out.print("¿Clave correcta? (true/false): ");
        boolean claveCorrecta = sc.nextBoolean();

        System.out.print("¿Acceso especial? (true/false): ");
        boolean accesoEspecial = sc.nextBoolean();

        boolean acceso = (esAdmin && claveCorrecta) || accesoEspecial;

        if (acceso) {
            System.out.println("✅ Acceso concedido.");
        } else {
            System.out.println("❌ Acceso denegado.");
        }

        // ---------------- PARTE 2: TABLA DE VERDAD ----------------
        System.out.println("\n=== TABLA DE VERDAD ===");
        System.out.print("Ingrese el número de variables lógicas: ");
        int n = sc.nextInt();
        sc.nextLine(); // limpiar ENTER pendiente

        String[] nombres = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Nombre de la variable " + (i + 1) + ": ");
            nombres[i] = sc.nextLine();
        }

        // ---------------- PARTE 3: EXPRESIÓN ESCRITA POR EL USUARIO ----------------
        System.out.println("\nEscriba la expresión lógica usando las variables:");
        System.out.println("Ejemplo: (a && b) || c");
        System.out.println("Operadores disponibles: && (AND), || (OR), ! (NOT), ^ (XOR)");
        String expresion = sc.nextLine();

        int totalComb = (int) Math.pow(2, n);

        // Encabezado de la tabla
        for (String nombre : nombres) {
            System.out.print(nombre + "\t");
        }
        System.out.println("Resultado");

        // Generamos todas las combinaciones
        for (int i = 0; i < totalComb; i++) {
            Map<String, Boolean> valores = new HashMap<>();

            for (int j = 0; j < n; j++) {
                boolean valor = ((i >> (n - j - 1)) & 1) == 1;
                valores.put(nombres[j], valor);
                System.out.print((valor ? 1 : 0) + "\t");
            }

            // Evaluamos la expresión lógica en Java
            boolean res = evaluarExpresion(expresion, valores);
            System.out.println(res ? 1 : 0);
        }

        sc.close();
    }

    // ---------------- FUNCIÓN PARA EVALUAR LA EXPRESIÓN ----------------
    public static boolean evaluarExpresion(String expr, Map<String, Boolean> valores) {
        // Reemplazamos las variables por sus valores true/false
        for (Map.Entry<String, Boolean> entry : valores.entrySet()) {
            expr = expr.replaceAll("\\b" + entry.getKey() + "\\b", entry.getValue().toString());
        }

        // Evaluamos paso a paso con un parser muy simple
        return evaluar(expr);
    }

    // Parser recursivo básico (maneja !, &&, ||, ^ y paréntesis)
    private static boolean evaluar(String expr) {
        expr = expr.replaceAll("\\s+", ""); // quitar espacios

        // Manejo de paréntesis
        while (expr.contains("(")) {
            int cierre = expr.indexOf(")");
            int apertura = expr.lastIndexOf("(", cierre);
            boolean val = evaluar(expr.substring(apertura + 1, cierre));
            expr = expr.substring(0, apertura) + val + expr.substring(cierre + 1);
        }

        // Negación
        expr = expr.replaceAll("true", "1").replaceAll("false", "0");
        while (expr.contains("!")) {
            expr = expr.replaceAll("!1", "0").replaceAll("!0", "1");
        }

        // XOR
        while (expr.contains("^")) {
            expr = expr.replaceAll("1\\^1", "0")
                       .replaceAll("1\\^0", "1")
                       .replaceAll("0\\^1", "1")
                       .replaceAll("0\\^0", "0");
        }

        // AND
        while (expr.contains("&&")) {
            expr = expr.replaceAll("1&&1", "1")
                       .replaceAll("1&&0", "0")
                       .replaceAll("0&&1", "0")
                       .replaceAll("0&&0", "0");
        }

        // OR
        while (expr.contains("||")) {
            expr = expr.replaceAll("1\\|\\|1", "1")
                       .replaceAll("1\\|\\|0", "1")
                       .replaceAll("0\\|\\|1", "1")
                       .replaceAll("0\\|\\|0", "0");
        }

        // Resultado final
        return expr.equals("1");
    }
}
