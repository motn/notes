/**
 * @author Santhosh Kumar Tekuri
 */
public class KthSmallestV1 {
    static int kthSmallest(int a[], int k) {
        return kthSmallest(a, 0, a.length-1, k);
    }

    static int kthSmallest(int a[], int lo, int hi, int k) {
        if(lo==hi)
            return a[lo];
        int p = partition(a, lo, hi);
        int pos = p-lo+1;
        if(k==pos)
            return a[p];
        else if(k<pos)
            return kthSmallest(a, lo, p-1, k);
        else
            return kthSmallest(a, p+1, hi, k-pos);
    }

    public static void main(String[] args) {
        System.out.println(kthSmallest(new int[]{7, 10, 4, 3, 20, 15}, 3));
        System.out.println(kthSmallest(new int[]{7, 10, 4, 3, 20, 15}, 4));
        System.out.println(kthSmallest(new int[]{12, 3, 5, 7, 19}, 2));

        // Output:
        // 7
        // 10
        // 5
    }

    static int partition(int a[], int lo, int hi) {
        int p = a[hi]; // last element is pivot
        int i = lo-1;
        for(int j=lo; j<hi; j++){
            // a[lo..i] is left partition. a[i+1..j-1] is right partition
            if(a[j]<p){
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i+1, hi);
        return i+1; // index of pivot
    }

    static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
