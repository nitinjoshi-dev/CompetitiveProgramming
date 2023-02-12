package com.codechef;

import java.util.BitSet;

//https://www.codechef.com/LRNDSA03/problems/EXUNC
public class CodeChefEXUNC {

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

    public static void main(String[] args) throws Exception {
        FastReader fastReader = new FastReader();
        int numberOfElements = fastReader.readInt();
        int numberOfOperations = fastReader.readInt();

        int[] elements = new int[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            elements[i] = fastReader.readInt();
        }
        BitSet bitSet = new BitSet(numberOfElements);
        bitSet.set(0);
        for (int i = 1; i < numberOfElements; i++) {
            if (elements[i] % elements[i - 1] != 0) {
                bitSet.set(i);
            }
        }
        for (int i = 0; i < numberOfOperations; i++) {
            int operation = fastReader.readInt();
            if (operation == 1) {
                int index = fastReader.readInt() - 1;
                int element = fastReader.readInt();
                elements[index] = element;
                bitSet.clear(index);
                if (index == 0 || element % elements[index - 1] != 0) {
                    bitSet.set(index);
                }
                if (index != numberOfElements - 1) {
                    bitSet.clear(index + 1);
                    if(elements[index + 1] % element != 0) {
                        bitSet.set(index + 1);
                    }
                }

            } else {
                int position = fastReader.readInt() - 1;
                bitSet.previousSetBit(position);
                out.write((bitSet.previousSetBit(position) + 1 + "\n").getBytes());
            }
        }
        out.flush();
    }
}
