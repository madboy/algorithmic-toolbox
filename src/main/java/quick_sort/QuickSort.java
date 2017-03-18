package quick_sort;

import java.util.Arrays;

public class QuickSort {

  public void sort(int[] ls, int left, int right) {
    if (left != right || left + 1 == right) {
      int pivot = ls[right - 1];
      int pos = right - 1;
      for (int i = 0; i < right - 1; i++) {
        if (ls[i] > pivot) {
          ls[right - 1] = ls[i];
          ls[i] = pivot;
          pos = i;
        }
      }
      sort(ls, 0, pos);
      sort(ls, pos, right);
    }
  }
}
