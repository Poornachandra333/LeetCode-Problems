class Solution {
    public int addDigits(int num) {
        //int sum = 0;
        while(num>9){
            int res = num;
            int sum = 0;
            while(res!=0){
                sum+=res%10;
                res/=10;
            }
            num = sum;
        }
        return num;
    }
}