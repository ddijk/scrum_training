package command.library;

import command.framework.Command;
import interfaces.IDrive;
import interfaces.IOutputter;

public class CmdVer extends Command {

    public static final String version = "Microsoft Windows [Version 6.1.2017]";

    public CmdVer(String cmd, IDrive drive) {super(cmd, drive);}

    @Override
    public void execute(IOutputter outputter) {
        outputter.printLine(version);
        outputter.newLine();
        int numOfParams = this.getParameterCount();
        if (numOfParams == 1 && this.getParameterAt(0).equals("/w")) {
            outputter.printLine("Developers:");
            outputter.printLine("Jaap-Jan");
            outputter.printLine("Maarten");
            outputter.printLine("Fascha");
            outputter.printLine("Dick");
        }

        if (numOfParams == 1 && !this.getParameterAt(0).equals("/w")) {
            outputter.printLine("Invalid option : " + this.getParameterAt(0));

        }
    }
}
