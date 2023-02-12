package com.codechef;

import java.util.Arrays;
//https://www.codechef.com/LRNDSA02/problems/ZCO12002
//Second solution can be found at https://www.codechef.com/viewsolution/46983738
public class CodeChefZCO12002 {

    static java.io.OutputStream out = new java.io.BufferedOutputStream(System.out);

    static class FastReader {
        java.io.BufferedInputStream in = new java.io.BufferedInputStream(System.in);

        int readInt() throws Exception {
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
    }

    static class Contest {
        int startTime;
        int endTime;

        public Contest(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public static void main(String[] args) throws Exception {
        FastReader fastReader = new FastReader();
        int numberOfContest = fastReader.readInt();
        int numberOfVWormHoles = fastReader.readInt();
        int numberOfWWormHoles = fastReader.readInt();
        Contest []contests = new Contest[numberOfContest];
        int []vWornHoles = new int[numberOfVWormHoles];
        int []wWornHoles = new int[numberOfWWormHoles];
        for(int i = 0; i < numberOfContest ; i++) {
            contests[i] = new Contest(fastReader.readInt(), fastReader.readInt());
        }
        for(int i = 0 ; i< numberOfVWormHoles ; i++) {
            vWornHoles[i] = fastReader.readInt();
        }
        for(int i = 0 ; i< numberOfWWormHoles ; i++) {
            wWornHoles[i] = fastReader.readInt();
        }

        int minTime = solveUsingBinarySearch(contests, vWornHoles, wWornHoles);
        out.write((minTime + "\n").getBytes());
        out.flush();

    }

    private static int solveUsingBinarySearch(Contest[] contests, int[] vWornHoles, int[] wWornHoles) {
        Arrays.sort(vWornHoles);
        Arrays.sort(wWornHoles);
        int minTimeForContest = wWornHoles[wWornHoles.length - 1] - vWornHoles[0] + 1;
        for(Contest contest: contests) {
            int startWormHoleTime = binarySearchForStartTimeWormHole(vWornHoles, contest.startTime);
            int endWormHoleTime = binarySearchForEndTimeWormHole(wWornHoles, contest.endTime);
            if(startWormHoleTime != -1 && endWormHoleTime != -1) {
                minTimeForContest = Math.min(minTimeForContest, endWormHoleTime - startWormHoleTime + 1);
            }
        }
        return minTimeForContest;
    }

    private static int binarySearchForStartTimeWormHole(int[] vWormHoles, int startTime) {
        int start = 0;
        int end = vWormHoles.length - 1;
        int probableAns = vWormHoles[start];
        if(startTime < probableAns) {
            return -1;
        }
        do {
            int mid = (start + end) >> 1;
            int midItem = vWormHoles[mid];
            if(startTime == midItem) {
                return midItem;
            } else if(startTime < midItem) {
                end = mid - 1;
            } else {
                start = mid + 1;
                probableAns = midItem;
            }
        } while(start <= end);
        return probableAns;
    }

    private static int binarySearchForEndTimeWormHole(int[] wWormHoles, int endTime) {
        int start = 0;
        int end = wWormHoles.length - 1;
        int probableAns = wWormHoles[end];
        if(endTime > probableAns) {
            return -1;
        }
        do {
            int mid = (start + end) >> 1;
            int midItem = wWormHoles[mid];
            if(endTime == midItem) {
                return midItem;
            } else if(endTime < midItem) {
                end = mid - 1;
                probableAns = midItem;
            } else {
                start = mid + 1;
            }
        } while(start <= end);
        return probableAns;
    }

}
