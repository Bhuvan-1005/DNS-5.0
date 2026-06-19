public class Main {
    public static void main(String[] args) {
        double presentValue = 1000.0;
        double growthRate = 0.05;
        int periods = 5;

        double futureValue = Forecast.calculateFutureValue(presentValue, growthRate, periods);
        System.out.println("Present Value: $" + presentValue);
        System.out.println("Growth Rate: " + (growthRate * 100) + "%");
        System.out.println("Periods: " + periods);
        System.out.println("Future Value: $" + String.format("%.2f", futureValue));
    }
}
