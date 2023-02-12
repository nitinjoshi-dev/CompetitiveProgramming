package com.codechef;

//https://www.codechef.com/LRNDSA02/problems/STFOOD
public class CodeChefSTFOOD {

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

    public static void main(String[] args) throws Exception {

        int testCase = readInt();
        do {
            int ans = 0;
            long numberOfFoodItems = readInt();
            for(int i= 0; i < numberOfFoodItems ; i++) {
                int numberOfStores = readInt();
                int numberOfPeople = readInt();
                int profitPerPerson = readInt();

                int personVisitingStore = numberOfPeople / (numberOfStores + 1);
                int dailyProfit = personVisitingStore * profitPerPerson;
                ans = ans > dailyProfit ? ans : dailyProfit;
            }
            out.write((ans + "\n").getBytes());
        } while (--testCase != 0);

        out.flush();
    }
}
