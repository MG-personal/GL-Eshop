package commands;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

// run config add program argument "list --format table" or "list --format json"
@Command(name = "cli", subcommands = {ListCommand.class})
public class MainCommand implements Runnable {

    @Option(names = "--url",
            description = "Vendure Shop API URL",
            defaultValue = "${env:URL:-http://localhost:3000/shop-api}")
    private String url;

    @Override
    public void run() {
        System.out.println("Use a subcommand");
    }

    public String getUrl() {
        return url;
    }

    public static void main(String[] args) {
        new CommandLine(new MainCommand()).execute(args);
    }
}