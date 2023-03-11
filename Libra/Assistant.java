package Libra;

public class Assistant {

    public Assistant() {

    }

    public void printSeparator(String title) {
        System.out.println("================================== [ " + title + " ] ==================================");
    }

    // array printing metods for 1D
    // ==============================================================
    public void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            String separator = (i == (array.length - 1)) ? "]\n" : ", ";
            System.out.print(array[i] + separator);
        }
    }

    public void printArray(char[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            String separator = (i == (array.length - 1)) ? "]\n" : ", ";
            System.out.print(array[i] + separator);
        }
    }

    public void printArray(double[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            String separator = (i == (array.length - 1)) ? "]\n" : ", ";
            System.out.print(array[i] + separator);
        }
    }

    public void printArray(float[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            String separator = (i == (array.length - 1)) ? "]\n" : ", ";
            System.out.print(array[i] + separator);
        }
    }

    // array printing metods for 2D
    // ==============================================================
    public void printArray2D(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            printArray(array[i]);
        }
    }

    public void printArray2D(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            printArray(array[i]);
        }
    }

    public void printArray2D(double[][] array) {
        for (int i = 0; i < array.length; i++) {
            printArray(array[i]);
        }
    }

    public void printArray2D(float[][] array) {
        for (int i = 0; i < array.length; i++) {
            printArray(array[i]);
        }
    }

    // Swap variables ==============================================================
    public int[] swapVariables(int n, int p) {
        int temp = p;
        p = n;
        n = temp;
        int[] swapped = { n, p };
        return swapped;

    }

    public double[] swapVariables(double n, double p) {
        double temp = p;
        p = n;
        n = temp;
        double[] swapped = { n, p };
        return swapped;

    }

    public char[] swapVariables(char n, char p) {
        char temp = p;
        p = n;
        n = temp;
        char[] swapped = { n, p };
        return swapped;

    }

    public String[] swapVariables(String n, String p) {
        String temp = p;
        p = n;
        n = temp;
        String[] swapped = { n, p };
        return swapped;

    }

    // return random values ===================================================

    public int getRandomInt(int range) {

        int randomInt = ((int) (Math.random() * (range + 1)));
        return randomInt;

    }

    public double getRandomDouble(int range) {

        double randomDouble = ((double) (Math.random() * (range)));
        return randomDouble;

    }

    public double getRandomDouble(double range) {

        double randomDouble = ((double) (Math.random() * (range)));
        return randomDouble;

    }

    public float getRandomFloat(int range) {
        float randomFloat = ((float) (Math.random() * (range)));
        return randomFloat;
    }

    // varoius numerical methods
    // ==============================================================
    public boolean isPrime(int number) {
        int limit = (int) Math.sqrt(number);
        boolean isPrime = true;
        if (number <= 3)
            isPrime = (number > 1);

        if (number % 2 == 0 || number % 3 == 0) {
            isPrime = false;
        }
        ;

        for (int i = 5; i < limit + 1; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0)
                isPrime = false;
        }

        return isPrime;
    }

    // =================================================
    public int countDigits(int number) {
        return ((int) Math.log10(number) + 1);
    }

    public int countDigits(long number) {
        return ((int) Math.log10(number) + 1);
    }
    // =================================================

    public int[] splitToDigits(int number) {
        int arrayLength = countDigits(number);
        double power = (double) (arrayLength - 1);

        int[] result = new int[arrayLength];

        for (int i = 0; i < result.length; i++) {
            int divisor = (int) Math.pow(10.0, power);
            result[i] = number / divisor;
            number = number - (divisor * result[i]);
            power--;
        }
        return result;
    }

    // ==================================================

    public boolean isLeapYear(int year) {

        boolean con1 = year % 4 == 0;
        boolean con2 = year % 100 > 0;
        boolean con3 = year % 400 == 0;
        return ((con1 && con2) || con3);
    }

    // ================================
    public int[] addItemTotheArray(int[] originalArr, int item) {
        int[] combinedArray = new int[originalArr.length + 1];
        for (int i = 0; i < originalArr.length; i++) {
            combinedArray[i] = originalArr[i];
        }
        combinedArray[combinedArray.length - 1] = item;
        return combinedArray;
    }

    public int findMinElement(int[] array) {
        int min = array[0];

        for (int i = 1; i < array.length; i++) {
            min = array[i] < min ? array[i] : min;
        }
        return min;
    }

    public int findMaxElement(int[] array) {
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            max = array[i] > max ? array[i] : max;
        }
        return max;
    }

    public int[] GetSuperRandomArray(int sizeRange, int argRange) {
        Assistant assistant = new Assistant();
        int arrSize = 1 + assistant.getRandomInt(sizeRange);
        int[] randArray = new int[arrSize];
        for (int i = 0; i < randArray.length; i++) {
            randArray[i] = assistant.getRandomInt(argRange);
        }
        return randArray;
    }

    public int[] GetRandomFixedSizeArray(int arrSize, int argRange) {
        Assistant assistant = new Assistant();
        int[] randArray = new int[arrSize];
        for (int i = 0; i < randArray.length; i++) {
            randArray[i] = assistant.getRandomInt(argRange);
        }
        return randArray;
    }

    public float[] GetRandomFloatArray(int sizeRange) {
        Assistant assistant = new Assistant();
        int arrSize = 1 + assistant.getRandomInt(sizeRange);
        float[] randArray = new float[arrSize];
        for (int i = 0; i < randArray.length; i++) {
            randArray[i] = assistant.getRandomFloat(1);
        }
        return randArray;
    }

    private int findMaxInternal(int x, int y) {
        return (x + y + Math.abs(x - y)) / 2;
    }

    public int findMax(int x, int y, int z) {
        int midResult = this.findMaxInternal(x, y);
        return this.findMaxInternal(midResult, z);
    }

    // sorting
    
    public void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);
    
            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    private int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);
    
        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
    
                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }
    
        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;
    
        return i+1;
    }














}