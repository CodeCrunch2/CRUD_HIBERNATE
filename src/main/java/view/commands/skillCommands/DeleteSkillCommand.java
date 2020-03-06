package view.commands.skillCommands;

import controller.SkillController;

import dto.SkillDto;
import view.commands.Command;
import view.console.ConsoleUtils;

public class DeleteSkillCommand implements Command {
    private SkillController skillController = SkillController.getSkillController();
    private ConsoleUtils consoleUtils = ConsoleUtils.getConsoleUtils();
    public void execute() {
        System.out.println("Enter skill id:");
        String skillIdString = consoleUtils.getStringFromConsole();
        if (skillIdString.equalsIgnoreCase("cancel")) {
            System.out.println("Operation canceled");
            return;
        }
        try {
            Integer.parseInt(skillIdString);
        }
        catch (NumberFormatException e) {
            System.out.println("id must be a number");
        }
        SkillDto skillDto = skillController.deleteSkill(Integer.parseInt(skillIdString));
        if(skillDto.getErrorMessage() != null){
            System.out.println(skillDto.getErrorMessage());
        }


    }
}
