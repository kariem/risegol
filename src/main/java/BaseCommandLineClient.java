import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.List;
import java.util.Scanner;

/** @author nmukhtar */
public abstract class BaseCommandLineClient {
        protected String delimiter = "\\s";

        protected void run(String[] args) {
                if (args.length < 1) {
                        printHelp();
                } else {
                        BufferedReader reader = null;
                        PrintWriter writer = null;
                        try {
                                reader = new BufferedReader(new FileReader(args[0]));
                                if (args.length > 1) {
                                        writer = new PrintWriter(new FileWriter(args[1]));
                                        process(new Scanner(reader), writer);
                                } else {
                                        process(new Scanner(reader), new PrintWriter(System.out, true));
                                }
                        } catch (Exception e) {
                                e.printStackTrace();
                        } finally {
                                closeReader(reader);
                                closeWriter(writer);
                        }
                }
        }

        protected void printHelp() {
                System.out
                                .println("The syntax to run this command line application is:");
                System.out.println("java " + getClass().getName()
                                + " <inputfilename> [<outputfilename>]");
                System.out.println("If you do not specify an output file name, output will be printed on the console.");
        }

        protected void closeReader(Reader reader) {
                if (reader != null) {
                        try {
                                reader.close();
                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                }
        }

        protected void closeWriter(Writer writer) {
                if (writer != null) {
                        try {
                                writer.close();
                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                }
        }
        
        protected String join(List<String> strings, String joiner) {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < strings.size(); i++) {
                        builder.append(strings.get(i));
                        if (i != strings.size() - 1) {
                                builder.append(joiner);
                        }
                }
                return builder.toString();
        }

        public abstract void process(Scanner input, PrintWriter output) throws Exception;
}