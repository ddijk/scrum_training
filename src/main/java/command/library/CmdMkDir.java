/*
 * DOSBox, Scrum.org, Professional Scrum Developer Training
 * Authors: Rainer Grau, Daniel Tobler, Zuehlke Technology Group
 * Copyright (c) 2013 All Right Reserved
 */ 

package command.library;

import interfaces.IDrive;
import interfaces.IOutputter;
import command.framework.Command;
import filesystem.Directory;

class CmdMkDir extends Command {
    private static final String PARAMETER_CONTAINS_BACKLASH = "At least one parameter denotes a path rather than a directory name.";

    public CmdMkDir(String name, IDrive drive) {
        super(name, drive);
    }

    @Override
    protected boolean checkNumberOfParameters(int number) {
        // Commands like "mkdir dir1 dir2 dir3" are allowed too.
        return number >= 1 ? true : false;
    }

    @Override
    protected boolean checkParameterValues(IOutputter outputter) {
        for(int i=0 ; i<getParameterCount() ; i++)
        {
            if (parameterContainsBacklashes(getParameterAt(i), outputter))
                return false;
        }

        return true;
    }

    private static boolean parameterContainsBacklashes(String parameter, IOutputter outputter) {
        // Do not allow "mkdir c:\temp\dir1" to keep the command simple
        if (parameter.contains("\\") || parameter.contains("/"))
        {
            outputter.printLine(PARAMETER_CONTAINS_BACKLASH);
            return true;
        }
        return false;
    }

    @Override
    public void execute(IOutputter outputter) {
        for(int i=0 ; i<getParameterCount() ; i++)
        {
           if (!CreateDirectory(getParameterAt(i), this.getDrive())) {
                   outputter.printLine("mkdir: "+ getParameterAt(i)+" exists");
           }
        }
    }

    private static boolean CreateDirectory(String newDirectoryName, IDrive drive) {

        if ( drive.getItemFromPath(newDirectoryName) != null) {
            return false;
        }
        Directory newDirectory = new Directory(newDirectoryName);
        drive.getCurrentDirectory().add(newDirectory);
        return true;
    }
}
