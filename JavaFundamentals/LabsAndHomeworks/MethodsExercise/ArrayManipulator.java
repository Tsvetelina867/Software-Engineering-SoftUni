package MethodsExercise;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] commandTokens = command.split(" ");
            String action = commandTokens[0];

            switch (action) {
                case "exchange":
                    int index = Integer.parseInt(commandTokens[1]);
                    if (isValidIndex(index, arr.length)) {
                        arr = exchangeElements(index, arr);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;

                case "max":
                case "min":
                    String type = commandTokens[1];
                    int elementIndex = findElementIndex(arr, type, action.equals("max"));
                    if (elementIndex == -1) {
                        System.out.println("No matches");
                    } else {
                        System.out.println(elementIndex);
                    }
                    break;

                case "first":
                case "last":
                    int count = Integer.parseInt(commandTokens[1]);
                    String evenOrOdd = commandTokens[2];
                    printElements(arr, action.equals("first"), count, evenOrOdd);
                    break;
            }

            command = scanner.nextLine();
        }

        printArray(arr);
    }

    public static int[] exchangeElements(int index, int[] arr) {
        if (!isValidIndex(index, arr.length)) {
            System.out.println("Invalid index");
            return arr;
        }

        int[] firstSubArray = Arrays.copyOfRange(arr, 0, index + 1);
        int[] secondSubArray = Arrays.copyOfRange(arr, index + 1, arr.length);
        int firstArrLength = firstSubArray.length;
        int secondArrLength = secondSubArray.length;
        int[] resultArr = new int[firstArrLength + secondArrLength];
        System.arraycopy(secondSubArray, 0, resultArr, 0, secondArrLength);
        System.arraycopy(firstSubArray, 0, resultArr, secondArrLength, firstArrLength);
        return resultArr;
    }

    public static int findElementIndex(int[] arr, String type, boolean findMax) {
        int resultIndex = -1;
        int compareValue = findMax ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int currentNum = arr[i];
            boolean isMatch = (type.equals("even") && currentNum % 2 == 0) ||
                    (type.equals("odd") && currentNum % 2 != 0);

            if (isMatch && ((findMax && currentNum >= compareValue) ||
                    (!findMax && currentNum <= compareValue))) {
                compareValue = currentNum;
                resultIndex = i;
            }
        }

        return resultIndex;
    }

    public static void printElements(int[] arr, boolean isFirst, int count, String evenOrOdd) {
        if (count > arr.length) {
            System.out.println("Invalid count");
            return;
        }

        int currentCount = 0;
        int index = 0;
        int[] resultArr = new int[count];

        if (isFirst) {
            for (int i = 0; i < arr.length; i++) {
                if (currentCount == count) {
                    break;
                }

                boolean isMatch = (evenOrOdd.equals("even") && arr[i] % 2 == 0) ||
                        (evenOrOdd.equals("odd") && arr[i] % 2 != 0);

                if (isMatch) {
                    resultArr[index++] = arr[i];
                    currentCount++;
                }
            }
        } else {
            int resultIndex = count - 1;
            for (int i = arr.length - 1; i >= 0; i--) {
                if (currentCount == count) {
                    break;
                }

                boolean isMatch = (evenOrOdd.equals("even") && arr[i] % 2 == 0) ||
                        (evenOrOdd.equals("odd") && arr[i] % 2 != 0);

                if (isMatch) {
                    resultArr[resultIndex--] = arr[i];
                    currentCount++;
                }
            }
        }

        if (currentCount == 0) {
            System.out.println("[]");
        } else {
            if (currentCount < count && !isFirst) {
                int[] reversed = new int[resultArr.length];
                for (int i = 0; i < reversed.length; i++) {
                    reversed[i] = resultArr[resultArr.length - 1 - i];

                }
                resultArr = reversed;
            }
            int[] smallerArray = Arrays.copyOf(resultArr, currentCount);
            System.out.println(Arrays.toString(smallerArray));
        }
    }


    public static boolean isValidIndex(int index, int arrLength) {
        return index >= 0 && index < arrLength;
    }

    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}