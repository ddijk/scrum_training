package command.library;

import command.framework.Command;
import filesystem.File;
import filesystem.FileSystemItem;
import interfaces.IDrive;
import interfaces.IOutputter;

public class CmdDelete extends Command {
    protected CmdDelete(String commandName, IDrive drive) {
        super(commandName, drive);
    }

    @Override
    public void execute(IOutputter outputter) {
        String path = getParameterAt(0);
        FileSystemItem fsi = getDrive().getItemFromPath(path);
        if (fsi instanceof File) {
            File file = (File) fsi;
            if (getDrive().getCurrentDirectory().delete(file)) {
                outputter.print(String.format("Deleted file %s successfully", file.getPath()));
            }
        } else {
            outputter.printLine(String.format("Unknown file: %s", path));
        }
    }

    @Override
    protected boolean checkNumberOfParameters(int numberOfParametersEntered) {
        return numberOfParametersEntered == 1;
    }

}
