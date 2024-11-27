package P901;

import java.util.Stack;

class StockPrice {
    int price;
    int date;

    StockPrice(int date, int price) {
        this.price = price;
        this.date = date;
    }
}

class StockSpanner {

    private Stack<StockPrice> stockPrices;
    private int date;

    public StockSpanner() {
        stockPrices = new Stack<>();
        date = 1;
    }

    public int next(int price) {
        StockPrice sp = new StockPrice(date, price);
        date++;
        while (!stockPrices.isEmpty() && stockPrices.peek().price <= sp.price)
            stockPrices.pop();
        int result;
        if (stockPrices.isEmpty())
            result = sp.date;
        else
            result = sp.date - stockPrices.peek().date;
        stockPrices.push(sp);
        return result;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */