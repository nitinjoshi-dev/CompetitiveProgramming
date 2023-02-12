package com.codechef;

//https://www.codechef.com/LRNDSA01/problems/LADDU
class CodeChefLadduProblem {

    static java.io.BufferedInputStream in = new java.io.BufferedInputStream(System.in);
    static java.io.OutputStream out = new java.io.BufferedOutputStream(System.out);

    static int readInt() throws Exception {
        int no = 0;
        //boolean minus = false;
        int a = 10;
        while (a == 10 || a == 32)
            a = in.read();
        while (a != 10 && a != 32 && a != -1) {
            no = no * 10 + (a - '0');
            a = in.read();
            if (a == 13) {
                a = in.read();
            }
        }
        return no;
    }

    static String read() throws Exception {
        StringBuilder br = new StringBuilder("");
        int a = in.read();
        while (a != 10 && a != 32 && a != -1) {
            br.append((char)(a));
            a = in.read();
            if (a == 13) {
                a = in.read();
            }
        }
        return br + "";
    }

    public static void main(String[] args) {
        try {
            int testCase = readInt();
            do {
                int numberOfActivities = readInt();
                String origin = read();
                int minimumLadduToRedeem = "INDIAN".equals(origin) ? 200 : 400;
                int totalPoints = 0;
                for (int activityNumber = 0; activityNumber < numberOfActivities; activityNumber++) {
                    String activity = read();

                    switch (activity) {
                        case "CONTEST_WON":
                            int rank = readInt();
                            totalPoints += 300 + (rank > 19 ? 0 : 20 - rank);
                            break;
                        case "TOP_CONTRIBUTOR":
                            totalPoints += 300;
                            break;
                        case "BUG_FOUND":
                            int severity = readInt();
                            totalPoints += severity;
                            break;
                        case "CONTEST_HOSTED":
                            totalPoints += 50;
                            break;
                    }
                }
                int ans = totalPoints / minimumLadduToRedeem;
                out.write((ans + "\n").getBytes());
            }
            while (--testCase != 0);
            out.flush();
        } catch (Exception e) {
        }
    }
}
