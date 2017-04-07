package command.library;

import command.framework.Command;
import interfaces.IDrive;
import interfaces.IOutputter;

public class CmdDel extends Command {

    public CmdDel(String commandName, IDrive drive) {
        super(commandName, drive);
    }

    @Override
    public void execute(IOutputter outputter) {

    }
}
