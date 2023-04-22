package java_homework1;
import java.util.Arrays;
import java.time.LocalDateTime;
import java.util.Scanner;

public class MainHomework1 {


//Написать метод, принимающий на вход два аргумента:
//len и initialValue, и возвращающий одномерный массив типа int длиной len,
//каждая ячейка которого равна initialValue

//    public static int[] createArray(int len, int initialValue) {
//        int[] arr = new int[len];
//        Arrays.fill(arr, initialValue);
//        return arr;
//    }
//    public static void main(String[] args) {
//        int[] arr = createArray(5, 10);
//        System.out.println(Arrays.toString(arr));
//    }
//______________________________________________________________________________________________________________

//Задать одномерный массив и найти в нем минимальный и максимальный элементы

//    public static void main(String[] args) {
//        int[] arr = {100, 50, 25, 31, 15};
//        int min = arr[0];
//        int max = arr[0];
//
//        for(int i=1; i<arr.length; i++) {
//            if(arr[i] < min) {
//                min = arr[i];
//            }
//            if(arr[i] > max) {
//                max = arr[i];
//            }
//        }
//
//        System.out.println("Minimum element in the array is: " + min);
//        System.out.println("Maximum element in the array is: " + max);
//    }
//_____________________________________________________________________________________________________________

//Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов)
//заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
//Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны,
//то есть [0][0], [1][1], [2][2], …, [n][n]

//    public static void main(String[] args) {
//        int n = 5;
//        int[][] arr = new int[n][n];
//
//        for(int i=0; i<n; i++) {
//            arr[i][i] = 1;
//            arr[i][n-i-1] = 1;
//        }
//
//        for(int i=0; i<n; i++) {
//            for(int j=0; j<n; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
//_____________________________________________________________________________________________________________

//В консоли запросить имя пользователя. В зависимости от текущего времени, вывести приветствие вида:
//"Доброе утро, <Имя>!", если время от 05:00 до 11:59
//"Добрый день, <Имя>!", если время от 12:00 до 17:59;
//"Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
//"Доброй ночи, <Имя>!", если время от 23:00 до 4:59

//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Введите ваше имя: ");
//        String name = scanner.nextLine();
//
//        LocalDateTime currentTime = LocalDateTime.now();
//
//        int hour = currentTime.getHour();
//        String greeting;
//        if(hour >= 5 && hour <= 11) {
//            greeting = "Доброе утро";
//        } else if(hour >= 12 && hour <= 17) {
//            greeting = "Добрый день";
//        } else if(hour >= 18 && hour <= 22) {
//            greeting = "Добрый вечер";
//        } else {
//            greeting = "Доброй ночи";
//        }
//        System.out.printf("%s, %s!", greeting, name);
//    }
//_____________________________________________________________________________________________________________

//** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
//при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично.
//Для усложнения задачи нельзя пользоваться вспомогательными массивами.
//Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1]
//при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
//При каком n в какую сторону сдвиг можете выбирать сами.

    public static void shiftArray(int[] arr, int n) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int len = arr.length;
        n %= len;
        if (n < 0) {
            n += len;
        }
        for (int i = 0; i < gcd(len, n); i++) {
            int temp = arr[i];
            int j = i;
            while (true) {
                int k = j + n;
                if (k >= len) {
                    k -= len;
                }
                if (k == i) {
                    break;
                }
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = 1;
        shiftArray(arr, n);
    }
//_____________________________________________________________________________________________________________
}

