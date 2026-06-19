public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer.Builder()
            .setCpu("Intel i9")
            .setRam("32GB")
            .setStorage("1TB SSD")
            .setGpu("NVIDIA RTX 4090")
            .setOs("Windows 11")
            .build();

        System.out.println(computer);
    }
}
