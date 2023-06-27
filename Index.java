import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public static int[][] findTwoSumCombinations(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    List<int[]> pairs = new ArrayList<>();

    for (int num : nums) {
        if (map.containsKey(num)) {
            pairs.add(new int[]{num, target - num});
            map.remove(num);
        } else {
            map.put(target - num, num);
        }
    }

    // Convert pairs to 2D array
    int[][] result = new int[pairs.size()][2];
    for (int i = 0; i < pairs.size(); i++) {
        result[i] = pairs.get(i);
    }

    return result;
}


    public static int[][] findDoubleTargetCombinations(int[] nums, int target) {
List<List<Integer>> combinations = new ArrayList<>();
List<Integer> currentCombination = new ArrayList<>();
int doubleTarget = target * 2;
findCombinations(nums, 0, doubleTarget, currentCombination, combinations);

        // Convert combinations to 2D array
        int[][] result = new int[combinations.size()][];
        for (int i = 0; i < combinations.size(); i++) {
            List<Integer> combination = combinations.get(i);
            result[i] = new int[combination.size()];
            for (int j = 0; j < combination.size(); j++) {
                result[i][j] = combination.get(j);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, -4, -6, -2, 8};
        int target = 4;

        int[][] twoSumCombinations = findTwoSumCombinations(nums, target);
        System.out.println("First Combination for \"" + target + "\": ");
        for (int[] pair : twoSumCombinations) {
            System.out.println(Arrays.toString(pair));
        }

        Arrays.sort(nums);
        System.out.println("Merge Into a Single Array: " + Arrays.toString(nums));

        int[][] doubleTargetCombinations = findDoubleTargetCombinations(nums, target);
        System.out.println("Second Combination for \"" + (target * 2) + "\": ");
        for (int[] combination : doubleTargetCombinations) {
            System.out.println(Arrays.toString(combination));
        }
    }
}
