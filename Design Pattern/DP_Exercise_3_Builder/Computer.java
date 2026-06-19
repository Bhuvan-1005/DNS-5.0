public class Computer {
    private String cpu;
    private String ram;
    private String storage;
    private String gpu;
    private String os;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.gpu = builder.gpu;
        this.os = builder.os;
    }

    public String getCpu() { return cpu; }
    public String getRam() { return ram; }
    public String getStorage() { return storage; }
    public String getGpu() { return gpu; }
    public String getOs() { return os; }

    @Override
    public String toString() {
        return "Computer{CPU=" + cpu + ", RAM=" + ram + ", Storage=" + storage + ", GPU=" + gpu + ", OS=" + os + "}";
    }

    public static class Builder {
        private String cpu;
        private String ram;
        private String storage;
        private String gpu;
        private String os;

        public Builder setCpu(String cpu) { this.cpu = cpu; return this; }
        public Builder setRam(String ram) { this.ram = ram; return this; }
        public Builder setStorage(String storage) { this.storage = storage; return this; }
        public Builder setGpu(String gpu) { this.gpu = gpu; return this; }
        public Builder setOs(String os) { this.os = os; return this; }

        public Computer build() {
            return new Computer(this);
        }
    }
}
