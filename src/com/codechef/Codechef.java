package com.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Codechef {
    public static void main(String[] args) throws IOException{
        Reader.init(System.in);
        StringBuilder sb = new StringBuilder("");
        int n = Reader.nextInt();
        long[] arr = new long[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Reader.nextLong();
        }
        // count the number of inversions in arr in NlogN
        long result = inversionCount(arr, n);
        System.out.println(result);
        //System.out.println(sb);
    }


    static long inversionCount(long arr[], long N)
    {
        // count number of inversions
        // against a sorted array
        int numElements = arr.length;
        long[] tempArray = new long[numElements];
        long numInversions = countInversions(arr, tempArray, 0, numElements-1);
        return numInversions;
    }

    static long countInversions(long[] arr, long[] temp, int startIndex, int endIndex) {
        long numInversions = 0;
        if(startIndex < endIndex) {
            // divide. allocate responsibilty
            int mid = startIndex + (endIndex - startIndex) / 2;
            numInversions += countInversions(arr, temp, startIndex, mid);
            numInversions += countInversions(arr, temp, mid + 1, endIndex);

            // count the number of inversions while merging the 2 arrays
            numInversions += countDuringMerging(arr, temp, startIndex, endIndex);
        }

        return numInversions;
    }

    static long countDuringMerging(long[] arr, long[] temp, int startIndex, int endIndex) {
        int leftPointer = startIndex;
        int mid = startIndex + (endIndex - startIndex)/2 + 1;
        int rightPointer = mid;
        long numInversions = 0;
        int finalArrayPointer = startIndex;

        while((leftPointer <= (mid - 1)) && (rightPointer <= endIndex)) {
            if(arr[leftPointer] <= arr[rightPointer]) {
                temp[finalArrayPointer] = arr[leftPointer];
                finalArrayPointer++;
                leftPointer++;
            } else {
                temp[finalArrayPointer] = arr[rightPointer];
                finalArrayPointer++;
                rightPointer++;
                numInversions += (mid - leftPointer);
            }
        }

        while(leftPointer <= (mid - 1)) {
            temp[finalArrayPointer] = arr[leftPointer];
            finalArrayPointer++;
            leftPointer++;
        }

        while(rightPointer <= endIndex) {
            temp[finalArrayPointer] = arr[rightPointer];
            finalArrayPointer++;
            rightPointer++;
        }

        for(int i = startIndex; i <= endIndex; i++) {
            arr[i] = temp[i];
        }

        return numInversions;

    }


}

class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                    reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }

    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
}