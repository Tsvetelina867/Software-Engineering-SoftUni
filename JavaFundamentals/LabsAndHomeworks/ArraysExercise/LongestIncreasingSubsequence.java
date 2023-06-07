package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = nums.length;

        int[] len = new int[n];
        int[] prev = new int[n];

        Arrays.fill(len, 1);

        int maxLength = 1;
        int lastIndex = 0;


        for (int i = 1; i < n; i++) {
            prev[i] = -1;

            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && len[j] + 1 > len[i]) {
                    len[i] = len[j] + 1;
                    prev[i] = j;
                }
            }

            if (len[i] > maxLength) {
                maxLength = len[i];
                lastIndex = i;
            }
        }

        int[] lis = new int[maxLength];
        int lisIndex = maxLength - 1;
        while (lastIndex != -1 && lisIndex >= 0) {
            lis[lisIndex] = nums[lastIndex];
            lastIndex = prev[lastIndex];
            lisIndex--;
        }

        for (int element : lis) {
            System.out.print(element + " ");
        }
    }

}
