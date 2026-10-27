import java.util.Arrays;

public class AlgoritmosEstudio {

    // 1. ALGORITMO POR BURBUJA (Bubble Sort)
    public static void ordenamientoBurbuja(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Intercambio de valores
                    int aux = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = aux;
                }
            }
        }
    }

    // 2. ALGORITMO POR INSERCIÓN (Insertion Sort)
    public static void ordenamientoInsercion(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int clave = arr[i];
            int j = i - 1;

            // Desplaza elementos mayores a la clave hacia la derecha
            while (j >= 0 && arr[j] > clave) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = clave;
        }
    }

    // 3. ALGORITMO QUICKSORT
    public static void quickSort(int[] arr, int inicio, int fin) {
        if (inicio < fin) {
            int pivoteIndice = particion(arr, inicio, fin);
            quickSort(arr, inicio, pivoteIndice - 1);
            quickSort(arr, pivoteIndice + 1, fin);
        }
    }

    private static int particion(int[] arr, int inicio, int fin) {
        int pivote = arr[fin];
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (arr[j] <= pivote) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[fin];
        arr[fin] = temp;

        return i + 1;
    }

    // 4. BÚSQUEDA SECUENCIAL / LINEAL
    public static int busquedaLineal(int[] arr, int valor) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == valor) {
                return i; // Retorna la posición donde lo encontró
            }
        }
        return -1; // No encontrado
    }

    // 5. BÚSQUEDA BINARIA (Requiere que el arreglo esté ordenado)
    public static int busquedaBinaria(int[] arr, int valor) {
        int inicio = 0;
        int fin = arr.length - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;

            if (arr[medio] == valor) {
                return medio;
            }
            if (arr[medio] < valor) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return -1;
    }

    // MÉTODO PRINCIPAL DE PRUEBA
    public static void main(String[] args) {
        int[] datosPrueba = {5, 3, 4, 1, 2};

        System.out.println("=== ESTUDIO DE CASOS: ALGORITMOS DE ORDENAMIENTO Y BÚSQUEDA ===");
        System.out.println("Arreglo original: " + Arrays.toString(datosPrueba));

        // 1. Prueba Burbuja
        int[] arrBurbuja = datosPrueba.clone();
        ordenamientoBurbuja(arrBurbuja);
        System.out.println("\n1. Ordenado con Burbuja: " + Arrays.toString(arrBurbuja));

        // 2. Prueba Inserción
        int[] arrInsercion = datosPrueba.clone();
        ordenamientoInsercion(arrInsercion);
        System.out.println("2. Ordenado con Inserción: " + Arrays.toString(arrInsercion));

        // 3. Prueba QuickSort
        int[] arrQuick = datosPrueba.clone();
        quickSort(arrQuick, 0, arrQuick.length - 1);
        System.out.println("3. Ordenado con QuickSort: " + Arrays.toString(arrQuick));

        // 4. Prueba Búsqueda Lineal
        int buscarValor = 3;
        int posLineal = busquedaLineal(datosPrueba, buscarValor);
        System.out.println("\n4. Búsqueda Lineal del valor " + buscarValor + ": " + 
            (posLineal != -1 ? "Encontrado en índice " + posLineal : "No encontrado"));

        // 5. Prueba Búsqueda Binaria
        int posBinaria = busquedaBinaria(arrQuick, buscarValor);
        System.out.println("5. Búsqueda Binaria del valor " + buscarValor + " (en arreglo ordenado): " + 
            (posBinaria != -1 ? "Encontrado en índice " + posBinaria : "No encontrado"));
    }
}