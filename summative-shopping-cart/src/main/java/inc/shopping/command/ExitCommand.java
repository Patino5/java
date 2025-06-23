package inc.shopping.command;

import inc.shopping.view.TerminalUtils;

public class ExitCommand implements Command {
    private final TerminalUtils io;

    public ExitCommand(TerminalUtils io) {
        this.io = io;
    }

    public void execute() {
        io.displayMessage("Thank you for using the Shopping Cart App!");
        System.exit(0);
    }
}
