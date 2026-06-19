public class SMSNotifierDecorator implements Notifier {
    private Notifier wrapped;

    public SMSNotifierDecorator(Notifier wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void send(String message) {
        wrapped.send(message);
        System.out.println("Sending SMS: " + message);
    }
}
