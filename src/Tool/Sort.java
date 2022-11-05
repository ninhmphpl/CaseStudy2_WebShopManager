package Tool;

public class Sort {

    static void swap(long[] arr, int a, int b) {
        long temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static long[] quickSort(long[] array, long[] byArray){
        sortArrayByArray(array,byArray,0, array.length-1);
        return array;
    }

    private static void sortArrayByArray(long[] array, long[] byArray, int first, int last){
        if (last - first >= 2){
            int i = first, j = last-1;
            long node = byArray[last];
            do {
                while (i < j && byArray[i] <= node) {
                    i++;
                }
                while (i < j && byArray[j] > node) {
                    j--;
                }
                swap(byArray, i, j);
                swap(array, i, j);
            } while (j - i > 1);
            if (byArray[j]>byArray[last]){
                swap(byArray,j,last);
                swap(array,j,last);
            }
            sortArrayByArray(array,byArray,first,i);
            sortArrayByArray(array,byArray,j+1, last);
        }else if(last-first >= 1){
            if(byArray[first]>byArray[last]){
                swap(byArray,first,last);
                swap(array,first,last);
            }
        }
    }

}

