public class Main {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        MobileApp mobileApp = new MobileApp("MobileApp");
        WebApp webApp = new WebApp("WebApp");

        stockMarket.addObserver(mobileApp);
        stockMarket.addObserver(webApp);

        stockMarket.setStockPrice("AAPL", 150.25);
        stockMarket.setStockPrice("GOOGL", 2750.80);
    }
}
