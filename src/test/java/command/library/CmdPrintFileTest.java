package command.library;

import org.junit.Before;
import org.junit.Test;

import helpers.TestHelper;

import static org.junit.Assert.*;

public class CmdPrintFileTest extends CmdTest {
    @Before
    public void setUp() {
        // Check this file structure in base class: crucial to understand the tests.
        this.createTestFileStructure();

        // Add all commands which are necessary to execute this unit test
        // Important: Other commands are not available unless added here.
        commandInvoker.addCommand(new CmdPrintFile("type", drive));
    }

    @Test
    public void ensureNotExistingFilePrintsError() {
        executeCommand("type foobar");
        TestHelper.assertContains("Unknown file: foobar", testOutput);
    }

    @Test
    public void ensureContentIsPrinted() {
        drive.changeCurrentDirectory(rootDir);
        executeCommand("type FileInRoot1");
        TestHelper.assertContains("an entry", testOutput);
    }
}
