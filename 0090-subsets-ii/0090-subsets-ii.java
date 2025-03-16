class Solution {

    public List<List<Integer>> subsetsWithDup(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        solve(0, arr, new ArrayList<>(), res);
        return res;
    }

    public void solve(int index, int arr[], List<Integer> list, List<List<Integer>> res) {
        res.add(new ArrayList<>(list));

        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1])
                continue;

            list.add(arr[i]);
            solve(i + 1, arr, list, res);
            list.remove(list.size() - 1);
        }
    }
}