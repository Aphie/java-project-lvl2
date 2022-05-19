package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import hexlet.code.Differ;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "App", header = "Compares two configuration files and shows a difference.", version = "1.0")
public class App implements Callable<String> {

    @CommandLine.Parameters(paramLabel = "filepath1", description = "path to first file")
    Path filepath1;

    @CommandLine.Parameters(paramLabel = "filepath2", description = "path to second file")
    Path filepath2;

    @Option(names = { "-f", "--format" }, defaultValue = "stylish", description = "output format [default: stylish]")
    String format;

    @Option(names = { "-h", "--help" }, usageHelp = true, description = "Show this help message and exit.")
    boolean usageHelpRequested = false;

    @Option(names = { "-v", "--version" }, versionHelp = true, description = "Print version information and exit.")
    boolean versionRequested;

    @Override
    public String call() throws Exception {
        if (!filepath1.isAbsolute()) {
            filepath1 = filepath1.toAbsolutePath();
        }

        if (!filepath2.isAbsolute()) {
            filepath2 = filepath2.toAbsolutePath();
        }

        var diff = Differ.generate(filepath1, filepath2);
        System.out.println(diff);
        return null;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

}
