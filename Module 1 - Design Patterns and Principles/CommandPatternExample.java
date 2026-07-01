public class CommandPatternExample {

    // Step 2: Command Interface
    interface Command {
        void execute();
    }

    // Step 5: Receiver Class
    static class Light {

        public void turnOn() {
            System.out.println("Light is ON");
        }

        public void turnOff() {
            System.out.println("Light is OFF");
        }
    }

    // Step 3: Concrete Command
    static class LightOnCommand implements Command {

        private Light light;

        public LightOnCommand(Light light) {
            this.light = light;
        }

        public void execute() {
            light.turnOn();
        }
    }

    // Step 3: Concrete Command
    static class LightOffCommand implements Command {

        private Light light;

        public LightOffCommand(Light light) {
            this.light = light;
        }

        public void execute() {
            light.turnOff();
        }
    }

    // Step 4: Invoker Class
    static class RemoteControl {

        private Command command;

        public void setCommand(Command command) {
            this.command = command;
        }

        public void pressButton() {
            command.execute();
        }
    }

    // Step 6: Test Command Pattern
    public static void main(String[] args) {

        Light light = new Light();

        Command onCommand = new LightOnCommand(light);
        Command offCommand = new LightOffCommand(light);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(onCommand);
        remote.pressButton();

        remote.setCommand(offCommand);
        remote.pressButton();
    }
}