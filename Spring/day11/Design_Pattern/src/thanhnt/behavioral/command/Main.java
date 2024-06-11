package thanhnt.behavioral.command;

public class Main {
    public static void main(String[] args) {
        Fan fan = new Fan();

        Command turnOnCommand = new TurnOnCommand(fan);
        Command turnOffCommand = new TurnOffCommand(fan);

        Remote remote = new Remote(turnOnCommand, turnOffCommand);

        remote.turnOnButtonClick();
        remote.turnOffButtonClick();
    }
}
