class Solution {
    public int maxProduct(int n) {
        String s = String.valueOf(n);
        char arr[]=s.toCharArray();
        Arrays.sort(arr);
        int len = arr.length;
        int val1= (int)(arr[len-1])-'0';
        int val2 = (int)(arr[len-2])-'0';
        //System.out.println(val1+" "+val2);
        return val1*val2;
    }
}