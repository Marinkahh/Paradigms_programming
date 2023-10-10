/**
 * Написать программу для бинарного поиска
 */
public class Main {
    public static void main(String[] args) {
        int[] arr1 = new int[1_000_000_000];
        int[] arr2 = {0, 1, 2, 3, 4, 5, 2};
        fillArray(arr1);
        System.out.println("Индекс элемента отсортированного массива: " + binarySearch(arr1, 2)); // результат 28 итераций
        System.out.println("Индекс элемента НЕ отсортированного массива: " + binarySearch(arr2, 0));
    }

    /**
     * Бинарный поиск элемента в отсортированном массиве
     *
     * @param arr отсортированный массив для поиска
     * @param num значение для поиска
     * @return индекс значения в массиве или -1 при его отсутствии
     */
    public static int binarySearch(int[] arr, int num) {
        int count = 1;  // Счетчик итерации
        if (isSorted(arr)) { // Выполняем поиск только при условии, что массив отсортирован и имеет значения
            int firstElement = 0;
            int lastElement = arr.length - 1;
            int middle = arr.length / 2;
            while (firstElement <= lastElement) {
                if (arr[middle] == num) {
                    System.out.println("Количество итерации поиска: " + count);
                    return arr[middle];
                }
                if (arr[middle] > num) { // Двигаемся влево по массиву
                    lastElement = middle - 1;
                }
                if (arr[middle] < num) {  // Двигаемся вправо по массиву
                    firstElement = middle + 1;
                }
                middle = ((lastElement - firstElement) / 2) + firstElement; // Ищем середину необходимой части массива
                count++;
            }
        }
        System.out.println("Количество итерации поиска: " + count);
        return -1;
    }

    /**
     * Проверяет отсортирован ли массив
     *
     * @param arr массив с целочисленными значениями
     * @return true - массив отсортирован, false - массив не отсортирован или не имеет значений
     */
    public static boolean isSorted(int[] arr) {
        if (arr != null && arr.length > 0) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) return false;
            }
            return true;
        }
        return false;
    }

    /**
     * Заполнение массива данными, значение в ячейке массива равно индексу элемента
     *
     * @param arr массив для заполнения
     */
    public static void fillArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }
}