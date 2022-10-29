package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Option;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "App", header = "Compares two configuration files and shows a difference.", version = "1.0")
public class App implements Callable<String> {

    @CommandLine.Parameters(paramLabel = "filepath1", description = "path to first file")
    private static String filepath1;

    @CommandLine.Parameters(paramLabel = "filepath2", description = "path to second file")
    private static String filepath2;

    @Option(names = { "-f", "--format" }, defaultValue = "stylish", description = "output format [default: stylish]")
    private static String format;

    @Option(names = { "-h", "--help" }, usageHelp = true, description = "Show this help message and exit.")
    private static boolean usageHelpRequested = false;

    @Option(names = { "-v", "--version" }, versionHelp = true, description = "Print version information and exit.")
    private static boolean versionRequested;

    @Override
    public final String call() {
        String resultDiff = "";

        filepath1 = checkAndConvertPaths(filepath1);
        filepath2 = checkAndConvertPaths(filepath2);

        try {
            resultDiff = Differ.generate(filepath1, filepath2, format);
            System.out.println(resultDiff);
        }  catch (IOException e) {
            System.out.println("ERROR: You've entered incorrect file, format or file that doesn't exist");
        }
        return null;
    }

    public static String checkAndConvertPaths(String filepath) {
        Path file = Paths.get(filepath);
        if (!file.isAbsolute()) {
            filepath = file.toAbsolutePath().toString();
        }
        return filepath;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

}
