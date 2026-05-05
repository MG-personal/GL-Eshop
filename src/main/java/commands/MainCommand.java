package commands;

import picocli.CommandLine;
import picocli.CommandLine.Command;

// run config add program argument "list --format table" or "list --format json"
@Command(name = "cli", subcommands = {ListCommand.class})
public class MainCommand implements Runnable {

    @Override
    public void run() {
        System.out.println("Use a subcommand");
    }

    public static void main(String[] args) {
        new CommandLine(new MainCommand()).execute(args);
    }
}