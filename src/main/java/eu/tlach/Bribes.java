package eu.tlach;

import java.util.ArrayList;
import java.util.List;

public class Bribes {

    public static void main(String[] args) {
        var edek = List.of(2, 1, 5, 3, 4);
        var mietek = List.of(1, 2, 5, 3, 7, 8, 6, 4);
       // minimumBribes(mietek);
        int[]  mietek2 = {1, 2, 5, 3, 7, 8, 6, 4};
        minimumBribes2(mietek);

    }





    private static void minimumBribes2(List<Integer> q) {

        int[] arr = q.stream().mapToInt(Integer::intValue).toArray();
        int swapCount = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != i + 1) { // filter cases, when you do not bribe, be at the ith position wherever you are
                if (((i - 1) >= 0) && arr[i - 1] == (i + 1)) { // 1)Being at initial ith position, valid current
                    // position after given bribe can be (i-1)th position
                    swapCount++;
                    swap(arr, i, i - 1);
                } else if (((i - 2) >= 0) && arr[i - 2] == (i + 1)) { // 2)Being at initial ith position, valid current
                    // position after given bribes can be (i-2)th
                    // position
                    swapCount += 2;
                    swap(arr, i - 2, i - 1);
                    swap(arr, i - 1, i);
                } else { // 3)Too chaotic (trying to bribe more than 2 people which is ahead of you)
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }
        System.out.println(swapCount);
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
