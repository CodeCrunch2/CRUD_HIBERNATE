package view.commands.specialityCommands;

import controller.SpecialityController;
import dto.SpecialityDto;
import view.commands.Command;
import view.console.ConsoleUtils;

public class DeleteSpecialityCommand implements Command {
    private SpecialityController specialityController = SpecialityController.getSpecialityController();
    private ConsoleUtils consoleUtils = ConsoleUtils.getConsoleUtils();
    public void execute() {
        System.out.println("Enter speciality id:");
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
        SpecialityDto specialityDto = specialityController.deleteSpeciality(Integer.parseInt(specialityIdString));
        if(specialityDto.getErrorMessage() != null){
            System.out.println(specialityDto.getErrorMessage());
        }
    }
}
