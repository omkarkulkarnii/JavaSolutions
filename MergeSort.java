import java.util.Arrays;

public class MergeSort {
    public static int[] Merge(int[] A, int m, int[] B, int n, int[] C) {
        int i = 0, j = 0, k = 0;
        while (k < m + n) {
            if (j == n || (i < m && A[i] <= B[j])) {
                C[k] = A[i];
                i++;
            } else {
                C[k] = B[j];
                j++;
            }
            k++;
        }
        return C;
    }

    public static int[] MergeSortMethod(int[] A, int l, int r, int[] B) {
        if (r - l <= 1) {
            if (r - l == 1) {
                B[0] = A[l];
            }
            return B;
        }

        int mid = (l + r) / 2;
        int[] L = new int[mid - l];
        int[] R = new int[r - mid];

        MergeSortMethod(A, l, mid, L);
        MergeSortMethod(A, mid, r, R);
        Merge(L, mid - l, R, r - mid, B);

        return B;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 2, 1, 5, 3};
        int l = 0;
        int r = arr.length;
        int[] SortedOne = new int[arr.length];
//        Arrays.sort();
        MergeSortMethod(arr, l, r, SortedOne);
        for (int i = 0; i < SortedOne.length; i++) {
            System.out.print(SortedOne[i] + " ");
        }
    }
}
