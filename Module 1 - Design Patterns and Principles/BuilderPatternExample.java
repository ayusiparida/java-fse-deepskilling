public class BuilderPatternExample {

    // Step 2: Product Class
    static class Computer {

        private String CPU;
        private int RAM;
        private int Storage;

        // Step 4: Private Constructor
        private Computer(Builder builder) {
            this.CPU = builder.CPU;
            this.RAM = builder.RAM;
            this.Storage = builder.Storage;
        }

        public void display() {
            System.out.println("CPU: " + CPU);
            System.out.println("RAM: " + RAM + " GB");
            System.out.println("Storage: " + Storage + " GB");
            System.out.println();
        }

        // Step 3: Builder Class
        static class Builder {

            private String CPU;
            private int RAM;
            private int Storage;

            public Builder setCPU(String CPU) {
                this.CPU = CPU;
                return this;
            }

            public Builder setRAM(int RAM) {
                this.RAM = RAM;
                return this;
            }

            public Builder setStorage(int Storage) {
                this.Storage = Storage;
                return this;
            }

            public Computer build() {
                return new Computer(this);
            }
        }
    }

    // Step 5: Test Builder Pattern
    public static void main(String[] args) {

        Computer computer1 = new Computer.Builder()
                .setCPU("Intel i5")
                .setRAM(8)
                .setStorage(256)
                .build();

        Computer computer2 = new Computer.Builder()
                .setCPU("Intel i7")
                .setRAM(16)
                .setStorage(512)
                .build();

        System.out.println("Computer 1:");
        computer1.display();

        System.out.println("Computer 2:");
        computer2.display();
    }
}