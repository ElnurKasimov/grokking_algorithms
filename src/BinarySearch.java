import java.util.*;


public class BinarySearch {
    /* Данный алгоритм корректно работает, если
       1. Массив упорядочен по возрастанию.
           В противном случае будет всегда выдаваться что искомый элемент - это первый
       2. Если в значениях массива есть пропуск и я ввожу сило в этом диапазоне,
          будет выведено, что искомый элемент - ближайшее значение меньшее введеного.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число, которое Вы хотите найти в массиве: ");
        int number = sc.nextInt();
        int[] testArray = {23, 5, 47, 12, 1};
        int low = 0;
        int hight = testArray.length;
        int middle = (low + hight)/2;
        while (low <= hight) {
            if (number == testArray[middle]){
                break;
            } else if (number > testArray[middle]) {
                low = middle + 1;
            } else {
                hight = middle - 1;
            }
            middle = (low + hight)/2;
        }
        System.out.println("Массив состоит из " + testArray.length + " элементов. \n" +
                "Нумерация элементо начинается с 0.");
        System.out.println("В массиве " + Arrays.toString(testArray) + " число " + number +
                " находится на позиции " + middle);
    }
}

