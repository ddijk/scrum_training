package command.library;

import command.framework.Command;
import interfaces.IDrive;
import interfaces.IOutputter;

public class CmdExit extends Command {
    public CmdExit(String cmd, IDrive drive) {super(cmd, drive);}

    @Override
    public void execute(IOutputter outputter) {
      // dummy
    }
}
