package silver.boj1654;

public class MainStudy {

    // 중복 값이 없을 경우 사용한다.
    public static int binarySearch(int[] arr, int key) {

        int lo = 0; // 탐색 범위의 왼쪽 끝 인덱스
        int hi = arr.length - 1; // 탐색 범위의 오른쪽 끝 인덱스

        // lo가 hi보다 커지기 전까지 반복한다.
        while (lo <= hi) {

            int mid = (lo + hi) / 2;

            // key 값이 중간 위치의 값보다 작을 경우, hi를 내려서 mid를 줄여야 한다.
            if (key < arr[mid]) {
                hi = mid - 1;
            }

            // key 값이 중간 위치의 값보다 클 경우, lo를 올려서 mid를 키워야 한다.
            if (key > arr[mid]) {
                lo = mid + 1;
            }

            // 일치할 경우, mid를 반환한다.
            return mid;
        }

        // 찾고자 하는 값이 존재하지 않는다면 while문 내에서 return이 되지 않을 것이다. 따라서 -1을 반환한다.
        return -1;
    }

    // 중복 값이 있을 경우, 동일 값중 가장 작은 인덱스를 추출한다.
    public static int lowerBound(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length; // arr.length - 1이 아님에 유의한다.

        // lo가 Hi랑 값이 같아질 때까지 반복
        while (lo < hi) {

            int mid = (lo + hi) / 2;

            /*
             * key 값이 중간 위치의 값보다 작거나 같을 경우,
             * (중복 원소에 대해 왼쪽으로 탐색하도록 상계를 내린다.)
             */
            if(key <= arr[mid]) {
                hi = mid;
            }

            else
                lo = mid + 1;

        }
        return lo;
    }

    // key보다 하나 더 높은 인덱스를 반환한다.
    public static int upperBound(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length;

        // lo와 hi가 같아질 때까지 반복
        while (lo < hi) {

            int mid = (lo + hi) / 2;

            /*
             * key가 arr보다 클 경우에는 당연히 lo를 올린다.
             * key가 arr과 같을 경우에도 lo를 올린다.
             */
            if (key >= arr[mid]) {
                lo = mid + 1;
            } else
                hi = mid;
        }
        return lo;
    }
}
