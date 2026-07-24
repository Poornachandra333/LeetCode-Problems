class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer>previous= new Stack<>();
        Stack<Integer>next = new Stack<>();
        int n = heights.length;
        int nextSmaller[] = new int[n];
        int previousSmaller[]=new int[n];
        for(int i=0;i<heights.length;i++){
            int val = heights[i];
            while(!previous.isEmpty() && heights[previous.peek()]>=val){
                previous.pop();
            }
            if(previous.isEmpty()){
                previousSmaller[i]=-1;
            }
            else{
                previousSmaller[i]=previous.peek();
            }
            previous.push(i);
            while(!next.isEmpty() && heights[next.peek()]>=val){
                nextSmaller[next.peek()]=i;
                next.pop();
            }
            next.push(i);
        }
        while(!next.isEmpty()){
            nextSmaller[next.pop()]=n;
        }
        System.out.println(Arrays.toString(nextSmaller));
        System.out.println(Arrays.toString(previousSmaller));
        int max = 0;
        for(int i=0;i<n;i++){
            int width = nextSmaller[i]-previousSmaller[i]-1;
            int area = heights[i]*width;
            max = Math.max(max,area);
        }
        return  max;
    }
}