package command.library;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import helpers.TestHelper;

public class CmdDelTest extends CmdTest {


    @Before
    public void setUp() {
        // Check this file structure in base class: crucial to understand the tests.
        this.createTestFileStructure();

        // Add all commands which are necessary to execute this unit test
        // Important: Other commands are not available unless added here.
        this.commandInvoker.addCommand(new CmdMkFile("mkfile", this.drive));
        this.commandInvoker.addCommand(new CmdMkFile("del", this.drive));
    }

    @Test
    public void verifyDeleteFile() {
        String newFileName = "file1";
        // when
        executeCommand("mkfile " + newFileName);
        assertEquals(numbersOfFilesBeforeTest + 1, drive.getCurrentDirectory().getNumberOfContainedFiles());
        executeCommand("del " + newFileName);

        assertEquals(numbersOfFilesBeforeTest , drive.getCurrentDirectory().getNumberOfContainedFiles());

    }

    @Test
    public void verifyDeleteNonExistingFileGivesError() {
        String newFileName = "file1";
        // when
        executeCommand("del " + newFileName);

        assertEquals(numbersOfFilesBeforeTest , drive.getCurrentDirectory().getNumberOfContainedFiles());

        TestHelper.assertContains("del: "+ newFileName+" exists", testOutput.toString());;
    }

}
