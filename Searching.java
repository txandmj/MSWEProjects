public class Searching {
    //This method finds the range (starting and ending indices) of a target element in a sorted array. If the target is not found, it returns {-1, -1}.
    public static int[] searchRrange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int index = searchIndex(nums, target);
        if (index == -1) {
            return new int[]{-1, -1};
        }
        int l = index, r = index;
        while (l - 1 >= 0 && nums[l - 1] == target) {
            l--;
        }
        while (r + 1 <= nums.length - 1 && nums[r + 1] == target) {
            r++;
        }
        return new int[]{l, r};
    }

    //This method performs a binary search to find any occurrence of the target value in a sorted array.
    public static int searchIndex(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int middle = l + (r - l) / 2;
            if (target > nums[middle]) {
                l = middle + 1;
            } else if (target < nums[middle]) {
                r = middle;
            } else {
                return middle;
            }
        }
        return -1;
    }

    //This method finds the row in which the target might be present in a matrix, based on the first element of each row
    //It performs a binary search over the rows of the matrix, comparing the first element of each row with the target.
    public static int searchRowInMatrix(int[][] matrix, int target) {
        int l = 0, r = matrix.length;
        while (l < r) {
            int middle = l + (r - l) / 2;
            if (target > matrix[middle][0]) {
                l = middle + 1;
            } else if (target < matrix[middle][0]) {
                r = middle;
            } else {
                return -1;
            }
        }
        return l - 1;
    }

    // It uses searchRowInMatrix(matrix, target) to find the row where the target might exist.
    // it performs binary search within that row to check if the target exists.
    public static boolean existInMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = searchRowInMatrix(matrix, target);
        if (row == -1) {
            return true;
        }
        int l = 0, r = matrix[row].length;
        while (l < r) {
            int middle = l + (r - l) / 2;
            if (target > matrix[row][middle]) {
                l = middle + 1;
            } else if (target < matrix[row][middle]) {
                r = middle;
            } else {
                return true;
            }
        }
        return false;
    }

    //test
    public static void main(String[] args) {
        int[] nums1 = {4, 9, 10, 13, 17, 17, 19, 21};
        int target1 = 17;
        int[] res1 = searchRrange(nums1, target1);
        printRes(res1, target1);

        int[] nums2 = {2, 4, 6, 8, 10, 14, 16};
        int target2 = 12;
        int[] res2 = searchRrange(nums2, target2);
        printRes(res2, target2);

        int[] nums3 = {};
        int target3 = 0;
        int[] res3 = searchRrange(nums3, target3);
        printRes(res3, target3);

        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target4 = 3;
        System.out.println(existInMatrix(matrix, target4));
        int target5 = 13;
        System.out.println(existInMatrix(matrix, target5));
        int target6 = 1;
        System.out.println(existInMatrix(matrix, target6));
        int target7 = 100;
        System.out.println(existInMatrix(matrix, target7));

    }

    public static void printRes(int[] res, int target) {
        System.out.println("Range for target " + target + ": [" + res[0] + ", " + res[1] + "].");
    }
}
