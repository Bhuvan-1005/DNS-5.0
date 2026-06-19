import java.util.ArrayList;
import java.util.List;

public class StockMarket {
    private List<Observer> observers;
    private String stockName;
    private double price;

    public StockMarket() {
        this.observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setStockPrice(String stockName, double price) {
        this.stockName = stockName;
        this.price = price;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, price);
        }
    }
}
