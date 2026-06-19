public class Main {
    public static void main(String[] args) {
        PayPalGateway payPalGateway = new PayPalGateway();
        PaymentProcessor paymentProcessor = new PayPalAdapter(payPalGateway);

        paymentProcessor.pay(150.00);
        paymentProcessor.pay(275.50);
    }
}
