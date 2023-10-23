public class ArrayNumerosAleatorios {
    public static void main(String[] args) {
        int[] numerosAleatoriosBubble = {
            587, 254, 503, 818, 237, 215, 122, 653, 774, 202, 890, 657, 109, 859, 305, 789, 141, 788, 147, 598,
            227, 133, 423, 947, 969, 27, 792, 572, 908, 339, 746, 243, 181, 279, 428, 96, 647, 545, 872, 174,
            479, 934, 25, 931, 922, 678, 110, 292, 617, 104, 741, 726, 823, 503, 736, 581, 63, 852, 470, 121,
            419, 866, 283, 328, 336, 454, 196, 461, 473, 77, 764, 612, 468, 855, 962, 798, 287, 25, 394, 204,
            989, 293, 305, 361, 307, 154, 319, 803, 108, 538, 396, 227, 262, 949, 69, 123, 18, 255, 979, 493,
            657, 581, 71
        };

        int[] numerosAleatoriosQuick = numerosAleatoriosBubble.clone();
        int[] numerosAleatoriosMerge = numerosAleatoriosBubble.clone();

        System.out.println("Números aleatorios sin ordenar:");
        for (int i = 0; i < numerosAleatoriosBubble.length; i++) {
            System.out.print(numerosAleatoriosBubble[i] + " ");
        }
        System.out.println("\n");

        // Bubble Sort
        bubbleSort(numerosAleatoriosBubble);

        System.out.println("Números aleatorios ordenados con Bubble Sort:");
        for (int i = 0; i < numerosAleatoriosBubble.length; i++) {
            System.out.print(numerosAleatoriosBubble[i] + " ");
           
        }
        System.out.println("\n");

        // Quick Sort
        quickSort(numerosAleatoriosQuick, 0, numerosAleatoriosQuick.length - 1);

        System.out.println("Números aleatorios ordenados con Quick Sort:");
        for (int i = 0; i < numerosAleatoriosQuick.length; i++) {
            System.out.print(numerosAleatoriosQuick[i]+ " ");
        }
        System.out.println("\n");

        // Merge Sort
        mergeSort(numerosAleatoriosMerge, 0, numerosAleatoriosMerge.length - 1);

        System.out.println("Números aleatorios ordenados con Merge Sort:");
        for (int i = 0; i < numerosAleatoriosMerge.length; i++) {
            System.out.print(numerosAleatoriosMerge[i]+ " ");
            
        }
        System.out.println("\n");
        // Medir el tiempo de Bubble Sort
        long startTimeBubble = System.currentTimeMillis();
        bubbleSort(numerosAleatoriosBubble);
        long endTimeBubble = System.currentTimeMillis();
        System.out.println("Tiempo de Bubble Sort: " + (endTimeBubble - startTimeBubble) + " ms");

        // Medir el tiempo de Quick Sort
        long startTimeQuick = System.currentTimeMillis();
        quickSort(numerosAleatoriosQuick, 0, numerosAleatoriosQuick.length - 1);
        long endTimeQuick = System.currentTimeMillis();
        System.out.println("Tiempo de Quick Sort: " + (endTimeQuick - startTimeQuick) + " ms");

        // Medir el tiempo de Merge Sort
        long startTimeMerge = System.currentTimeMillis();
        mergeSort(numerosAleatoriosMerge, 0, numerosAleatoriosMerge.length - 1);
        long endTimeMerge = System.currentTimeMillis();
        System.out.println("Tiempo de Merge Sort: " + (endTimeMerge - startTimeMerge) + " ms");
    
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[m + 1 + j];
        }

        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
