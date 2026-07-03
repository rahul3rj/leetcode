class StockSpanner {

    Stack<Integer> stack;
    ArrayList<Integer> list;
    public StockSpanner() {
        stack = new Stack<>();
        list = new ArrayList<>();
    }
    
    public int next(int price) {
        list.add(price);
        while(!stack.isEmpty() && list.get(stack.peek())<=price){
            stack.pop();
        }
        int prev = -1;
        if(!stack.isEmpty()){
            prev = stack.peek();
        }
        int currIdx = list.size()-1;
        int ans = currIdx - prev;
        stack.push(currIdx);
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */