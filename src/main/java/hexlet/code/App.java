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

    @Option(names = { "-f", "--format" }, description = "output format [default: stylish]")
    private static String format;

    @Option(names = { "-h", "--help" }, usageHelp = true, description = "Show this help message and exit.")
    private static boolean usageHelpRequested = false;

    @Option(names = { "-v", "--version" }, versionHelp = true, description = "Print version information and exit.")
    private static boolean versionRequested;

    @Override
    public final String call() throws Exception {
        String resultDiff = "";
        Path file1 = Paths.get(filepath1);
        Path file2 = Paths.get(filepath2);

        if (!file1.isAbsolute()) {
            filepath1 = file1.toAbsolutePath().toString();
        }

        if (!file2.isAbsolute()) {
            filepath2 = file2.toAbsolutePath().toString();
        }

        if (format.isEmpty()) {
            resultDiff = Differ.generate(filepath1, filepath2);
        } else {
            resultDiff = Differ.generate(filepath1, filepath2, format);
        }

        System.out.println(resultDiff);
        return null;
    }

    public static void main(String[] args) throws IOException {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

}
