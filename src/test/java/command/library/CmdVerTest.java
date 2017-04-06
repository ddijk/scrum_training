package command.library;

import org.junit.Before;
import org.junit.Test;

import helpers.TestHelper;

public class CmdVerTest extends CmdTest {

    @Before
    public void setUp() {
        // Check this file structure in base class: crucial to understand the tests.
        this.createTestFileStructure();

        // Add all commands which are necessary to execute this unit test
        // Important: Other commands are not available unless added here.
        this.commandInvoker.addCommand(new CmdVer("ver", this.drive));
    }

    @Test
    public void verifyVerCmdBasic()
    {
        executeCommand("ver");
        TestHelper.assertContains(CmdVer.version, testOutput.toString());
    }

    @Test
    public void verifyVerCmdVerbose()
    {
        executeCommand("ver /w");
        TestHelper.assertContains(CmdVer.version, testOutput.toString());
        TestHelper.assertContains("Developers", testOutput.toString());
    }
}
