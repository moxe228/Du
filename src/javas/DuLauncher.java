package javas;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.util.List;


public class DuLauncher {

    @Option(name = "-h", usage = "B, KB, MB, GB")
    private boolean humanReadable;

    @Option(name = "-c", usage = "Total size")
    private boolean totalSize;

    @Option(name = "--si", usage = "1024 == 1000")
    private boolean divider;

    @Argument(required = true, metaVar = "File name", usage = "File name")
    private List<String> fileName;

    public static void main(String[] args) {
        new DuLauncher().launch(args);
    }

    private void launch(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("java -jar du.jar [-h] [-c] [--si] file1 file2 file3 …");
            parser.printUsage(System.err);

        }

        Du DU = new Du(humanReadable, totalSize, divider);
        try {
            DU.du(fileName);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
