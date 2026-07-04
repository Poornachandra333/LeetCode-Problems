class Pair{
    int boxes ;
    int unitPerBox;
    Pair(int boxes,int unitPerBox){
        this.boxes = boxes;
        this.unitPerBox = unitPerBox;
    }
}
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int n = boxTypes.length;
        Pair pair[]=new Pair[n];
        for(int i=0;i<n;i++){
            pair[i]=new Pair(boxTypes[i][0],boxTypes[i][1]);
        }
        Arrays.sort(pair,(a,b)->b.unitPerBox-a.unitPerBox);
        int max = 0;
        for(int i=0;i<n;i++){
            System.out.println(pair[i].boxes +" "+pair[i].unitPerBox+" "+truckSize);
            if(truckSize-pair[i].boxes>=0){
                truckSize=truckSize-pair[i].boxes;
                max+=pair[i].boxes*pair[i].unitPerBox;
            }
            else{
                max+=truckSize*pair[i].unitPerBox;
                break;
            }
        }
        return max;
    }
}   