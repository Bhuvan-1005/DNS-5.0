public class Main {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);

        String result = service.getCustomerById("C1001");
        System.out.println(result);
    }
}
