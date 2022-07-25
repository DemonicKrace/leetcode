class Solution {
    public List<List<Integer>> generate(int numRows) {
        // method 1, loop to iterate, time = O(N^2), space = O(N^2)
        List<List<Integer>> result = new ArrayList();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> row = new ArrayList();
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) row.add(1);
                else row.add(result.get(i - 2).get(j - 1) + result.get(i - 2).get(j - 2));
            }
            result.add(row);
        }
        return result;
    }
}