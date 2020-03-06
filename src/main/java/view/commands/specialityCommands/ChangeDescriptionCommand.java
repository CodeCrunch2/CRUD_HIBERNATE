package view.commands.specialityCommands;

import controller.SpecialityController;
import dto.SpecialityDto;
import view.commands.Command;
import view.console.ConsoleUtils;

public class ChangeDescriptionCommand implements Command {
    private SpecialityController specialityController = SpecialityController.getSpecialityController();
    private ConsoleUtils consoleUtils = ConsoleUtils.getConsoleUtils();
    public void execute() {
        System.out.println("Enter a speciality id:");
        String specialityIdString = consoleUtils.getStringFromConsole();
        if (specialityIdString.equalsIgnoreCase("cancel")) {
            System.out.println("Operation canceled");
            return;
        }
        try {
            Integer.parseInt(specialityIdString);
        }
        catch (NumberFormatException e) {
            System.out.println("id must be a number");
        }
        System.out.println("Enter a description:");
        String specialityDescription = consoleUtils.getStringFromConsole();
        if (specialityDescription.equalsIgnoreCase("cancel")) {
            System.out.println("Operation canceled");
            return;
        }
        SpecialityDto specialityDto = specialityController.changeDescription(Integer.parseInt(specialityIdString), specialityDescription);
        if (specialityDto.getErrorMessage() != null) {
            System.out.println(specialityDto.getErrorMessage());
        }
    }
}
