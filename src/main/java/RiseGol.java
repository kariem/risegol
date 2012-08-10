import java.io.PrintWriter;
import java.util.*;

public class RiseGol extends BaseCommandLineClient {

    private Board board = new BoardImpl(new StandardRule());

    public static void main(String[] args) {
        try {
            new RiseGol().run(args);
            System.exit(0);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public void process(Scanner input, PrintWriter output) throws Exception {
        boolean[][] status = new boolean[10][10];
        int line = 0;

        while (line < status.length) {
            int col = 0;
            if (input.hasNext()) {
                String s = input.nextLine();
                while (col < 10) {
                    status[line][col] = s.charAt(col) != ' ';
                    col++;
                }
            }
            line++;
        }

        printBoard(status, output);
        board.set(status);

        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {

            String command = in.nextLine();
            if ("end".equalsIgnoreCase(command)) {
                break;
            }
            printBoard(board.tick(), output);
        }

        output.println("Thank you for choosing us.");
    }

    private void printBoard(boolean[][] status, PrintWriter pw) {
        for (int i = 0; i < status.length; i++) {
            for (int j = 0; j < status[i].length; j++) {
                pw.print(status[i][j] ? 'X' : ' ');
            }
            pw.println();
        }
        pw.println();
    }

    private String findDupes(Scanner input) {
        int[] result = calc(input);
        if (result == null || result.length == 0) {
            return "NONE";
        }

        StringBuilder b = new StringBuilder();
        for (int i : result) {
            if (b.length() > 0) {
                b.append(' ');
            }
            b.append(i);
        }
        return b.toString();
    }

    private int[] calc(Scanner input) throws NoSuchElementException {
        int k = input.nextInt();
        String s = input.next();

        Set<Integer> found = new HashSet<Integer>();
        Set<Integer> dup = new HashSet<Integer>();
        for (int p = 0; p < s.length() + 1 - k; p++) {
            int val = Integer.parseInt(s.substring(p, p + k));
            if (found.contains(val)) {
                dup.add(val);
            } else {
                found.add(val);
            }
        }

        if (dup.isEmpty()) {
            return null;
        }

        return convert(dup);
    }

    private int[] convert(Set<Integer> s) {
        int[] res = new int[s.size()];

        int pos = 0;
        for (Integer i : s) {
            res[pos++] = i;
        }

        Arrays.sort(res);
        return res;
    }

}