import java.util.*;

class Info {
    int num;
    int f;

    public Info(int num, int f) {
        this.num = num;
        this.f = f;
    }
}

class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Info> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(new Info(entry.getKey(), entry.getValue()));
        }

        Collections.sort(list, (info0, info1) -> {
            if (info0.f == info1.f) {
                return info1.num - info0.num;  // Sort by num in descending order if frequencies are equal
            } else {
                return info0.f - info1.f;  // Sort by frequency in ascending order
            }
        });

        int t = 0;
        for (int i = 0; i < list.size(); i++) {
            int n = list.get(i).num;
            int freq = list.get(i).f;
            while (freq > 0) {
                nums[t++] = n;
                freq--;
            }
        }

        return nums;
    }
}