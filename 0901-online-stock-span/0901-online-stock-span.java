class StockSpanner {
    Stack<Integer> st;
    List<Integer> list ;
    public StockSpanner() {
        st = new Stack<>();
        list = new ArrayList<>();
    }
    
    public int next(int price) {
        int count = 1;
        // System.out.println(price);
        while(!st.isEmpty() && st.peek()<=price){
            count+=list.get(list.size()-1);
            list.remove(list.size()-1);
            st.pop();
        }
        st.push(price);
        list.add(count);
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */