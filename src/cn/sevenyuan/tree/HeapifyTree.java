package cn.sevenyuan.tree;

/**
 * 树的堆化、排序
 * @author JingQ at 8/25/20
 */
public class HeapifyTree {

    /**
     * 当堆顶元素移除之后，把下标为 n 的元素放到堆顶，
     * 然后再通过堆化的方法，将剩下的 n−1 个元素重新构建成堆
     *
     * @param arr   数组
     */
    public static void sort(int[] arr) {
        int n = arr.length;
        buildHeap(arr, n);
        int k = n;
        while (k >= 1) {
            swap(arr, 1, k);
            --k;
            heapify(arr, k, 1);
        }
    }

    /**
     * 对下标从 n/2 开始到 1 的数据进行堆化，下标是 n/2+1 到 n 的节点是叶子节点
     * @param arr
     * @param n
     */
    public static void buildHeap(int[] arr, int n) {
        for (int i = n / 2; i >= 1; --i) {
            heapify(arr, n, i);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        while(true) {
            int maxPos = i;
            // 判断数组有没有越界可能
            if (i*2 < n &&  arr[i] < arr[i*2]) {
                maxPos = i*2;
            }
            if (i*2+1 < n && arr[maxPos] < arr[i*2+1]) {
                maxPos = i*2+1;
            }
            if (maxPos == 1) {
                break;
            }
            swap(arr, i, maxPos);
            i = maxPos;
        }
    }

    private static void swap(int[] a, int i, int j) {
        a[i] = a[i] + a[j];
        a[j] = a[i] - a[j];
        a[i] = a[i] - a[j];
    }
}
