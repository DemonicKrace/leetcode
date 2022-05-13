class Solution {
    public String largestNumber(int[] nums) {
        // String[] numsStrs = new String[nums.length];
        // for (int i = 0; i < nums.length; i++) numsStrs[i] = String.valueOf(nums[i]);
        // // syntax 1
        // Arrays.sort(numsStrs, new Comparator<String>() {
        //     @Override
        //     public int compare(String a, String b) {
        //         String order1 = a + b;
        //         String order2 = b + a;
        //         return order2.compareTo(order1);
        //     }
        // });
        // // syntax 2
        // Arrays.sort(numsStrs, (a, b) -> String.format("%s%s",b ,a).compareTo(String.format("%s%s",a ,b)));
        // if (numsStrs[0].equals("0")) return "0";
        // StringBuilder sb = new StringBuilder();
        // for (String n: numsStrs) sb.append(n);
        // return sb.toString();
        
        // // syntax 3
        // StringBuilder sb = new StringBuilder();
        // Arrays.stream(nums).boxed().sorted((a, b) -> (b + "" + a).compareTo(a + "" + b)).forEach(sb::append);
        // return sb.toString().charAt(0) == '0' ? "0" : sb.toString();
    }
}