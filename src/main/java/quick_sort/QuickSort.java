package quick_sort;

import java.util.Random;

public class QuickSort {
  public void sort(int[] A, int p, int r) {
    quickSort(A, p, r - 1);
  }

  private void quickSort(int[] A, int p, int r) {
    if (p < r) {
      int q = randomizedPartition(A, p, r);
      quickSort(A, p, q - 1);
      quickSort(A, q + 1, r);
    }
  }

  private void quickSortTR(int[] A, int p, int r) {
    while (p < r) {
      int q = partition(A, p, r);
      quickSortTR(A, p, q-1);
      p = q +1;
    }
  }

  private int threeWayPartition(int[] A, int p, int r) {
    swap(A, randomInt(p, r), r);
    int i = 0;
    int k = 0;
    int q = r;
    while (i < q) {
      if (A[i] < A[r]) {
        swap(A, i++, k++);
      } else if (A[i] == A[r]) {
        swap(A, i, --q);
      } else {
        i++;
      }
    }
    int m = Math.min(q-k, r-q+1);
//    swapRange(A,k,k+m-1,r-m+1,r);
    return k;//,r-q+k;
  }

  private int randomizedPartition(int[] A, int p, int r) {
    int i = randomInt(p, r);
    swap(A, i, r);
    return partition(A, p, r);
  }

  private int partition(int[] A, int p, int r) {
    int x = A[r];
    int i = p - 1;
    for (int j = p; j < r; j++) {
      if (A[j] <= x) {
        i += 1;
        swap(A, i, j);
      }
    }
    swap(A, i + 1, r);
    return i + 1;
  }

  private int randomInt(int min, int max) {
    Random r = new Random();
    return r.nextInt((max - min) + 1) + min;
  }

  private void swap(int[] A, int f, int t) {
    int tmp = A[f];
    A[f] = A[t];
    A[t] = tmp;
  }
}
