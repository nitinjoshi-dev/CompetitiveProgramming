package com.codechef;

//https://www.codechef.com/LRNDSA01/problems/MULTHREE
public class CodeChefMULTHREE {

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

    static long readLong() throws Exception {
        long no = 0;
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
            String ans = "NO";
            long numberOfDigits = readLong();
            int firstNumber = readInt();
            int secondNumber = readInt();
            long sum = (firstNumber + secondNumber);
            if(numberOfDigits > 2) {
                long thirdDigit = sum % 10;
                long fourth = (sum << 1)% 10; //from fourth digit every element keep getting double till seventh element // 2
                long fifth = (sum << 2)% 10; // 4
                long sixth = (sum << 3)% 10; // 8
                long seventh = (sum * 6)% 10; // 6 since double of 8 is 16 % 10
                sum += thirdDigit;
                //After seventh element cycle continues to run as 2, 4, 8, 6 multiplication of sum
                long multiplyingFactor = (numberOfDigits - 3) / 4;
                int remainderToConsider = (int) ((numberOfDigits - 3) % 4);
                //So sum would be actual sum plus (4th, 5th 6th 7th digits sum multiplied by the cycle it is going to form .e. multiplyingFactor
                sum += (multiplyingFactor * (fourth + fifth + sixth + seventh));
                //Now based on remainder we add 4th, 5th or 6th element
                switch (remainderToConsider) {
                    case 3:
                        sum += sixth;
                    case 2:
                        sum += fifth;
                    case 1:
                        sum += fourth;
                }
            }
            if(sum % 3 == 0) {
                ans = "YES";
            }
            out.write((ans + "\n").getBytes());
        } while (--testCase != 0);

        out.flush();
    }
}
