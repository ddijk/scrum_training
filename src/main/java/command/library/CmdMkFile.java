/*
 * DOSBox, Scrum.org, Professional Scrum Developer Training
 * Authors: Rainer Grau, Daniel Tobler, Zuehlke Technology Group
 * Copyright (c) 2013 All Right Reserved
 */ 

package command.library;

import interfaces.IDrive;
import interfaces.IOutputter;
import command.framework.Command;
import filesystem.File;

class CmdMkFile extends Command {

	public CmdMkFile(String cmdName, IDrive drive) {
		super(cmdName, drive);
	}

	@Override
	public void execute(IOutputter outputter) {
		int numOfParams = this.getParameterCount();
		if ( numOfParams == 0 ) {
		    outputter.printLine("syntax of the command is incorrect");
			return;
		}

		String fileName = this.getParameterAt(0);
		if ( this.getDrive().getItemFromPath(fileName) != null) {
			outputter.printLine("mkFile: "+ fileName+" exists");
			return;

		}
		String fileContent = "";
		if ( numOfParams == 2 ) {
			fileContent = this.getParameterAt(1);
		}
		File newFile = new File(fileName, fileContent);
		this.getDrive().getCurrentDirectory().add(newFile);
	}
}
