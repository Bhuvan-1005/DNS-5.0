public class SlackNotifierDecorator implements Notifier {
    private Notifier wrapped;

    public SlackNotifierDecorator(Notifier wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void send(String message) {
        wrapped.send(message);
        System.out.println("Sending Slack: " + message);
    }
}
