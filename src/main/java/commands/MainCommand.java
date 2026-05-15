package commands;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

// run config add program argument
// "--url http://localhost:3000/shop-api list --format json"
// or "--url http://localhost:3000/shop-api list --format table"
// or "--url http://localhost:3000/shop-api product --id 2"
@Command(
    name = "cli",
    subcommands = {ListCommand.class, ProductCommand.class})
public class MainCommand implements Runnable {

  @Option(
      names = "--url",
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
