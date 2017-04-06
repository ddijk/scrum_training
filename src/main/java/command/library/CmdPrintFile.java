package command.library;

import command.framework.Command;
import filesystem.File;
import filesystem.FileSystemItem;
import interfaces.IDrive;
import interfaces.IOutputter;

public class CmdPrintFile extends Command {
    protected CmdPrintFile(String commandName, IDrive drive) {
        super(commandName, drive);
    }

    @Override
    public void execute(IOutputter outputter) {
        String path = getParameterAt(0);
        FileSystemItem fsi = getDrive().getItemFromPath(path);
        if (fsi instanceof File) {
            File file = (File) fsi;
            String content = file.getFileContent();
            outputter.print(content);
        }
    }
}
