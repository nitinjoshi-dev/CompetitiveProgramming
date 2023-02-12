package com.codechef;


import java.util.HashMap;
import java.util.Map;

//https://www.codechef.com/LRNDSA03/problems/CVOTE
public class CodeChefCVOTE {
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

        String read() throws Exception {
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
    }



    public static void main(String[] args) throws Exception {
        FastReader fastReader = new FastReader();
        String winningChefName = null;
        String winningCountryName = null;
        int numberOfChefs = fastReader.readInt();
        int numberOfVotes = fastReader.readInt();
        int maxChefVotes = 0;
        int maxCountryVotes = 0;
        Map<String, String> chefNameAndCountry = new HashMap<>(numberOfChefs);
        Map<String, Integer> chefPoints = new HashMap<>(numberOfChefs);
        Map<String, Integer> countryPoints = new HashMap<>(numberOfChefs);
        for(int i = 0; i < numberOfChefs ; i++) {
            chefNameAndCountry.put(fastReader.read(), fastReader.read());
        }
        for(int i = 0; i < numberOfVotes ; i++) {
            String chefName = fastReader.read();
            String countryName = chefNameAndCountry.get(chefName);
            Integer chefVotes = chefPoints.get(chefName);
            Integer countryVotes = countryPoints.get(countryName);
            if(chefVotes == null) {
                chefVotes = 0;
            }
            chefPoints.put(chefName, ++chefVotes);
            if(countryVotes == null) {
                countryVotes = 0;
            }
            countryPoints.put(countryName, ++countryVotes);
        }
        for(String chefName : chefPoints.keySet()) {
            Integer chefVotes = chefPoints.get(chefName);
            if(maxChefVotes == chefVotes) {
                winningChefName = winningChefName.compareTo(chefName) > 0 ? chefName : winningChefName;
            } else if (maxChefVotes < chefVotes) {
                maxChefVotes = chefVotes;
                winningChefName = chefName;
            }
        }
        for(String countryName : countryPoints.keySet()) {
            Integer countryVotes = countryPoints.get(countryName);
            if(maxCountryVotes == countryVotes) {
                winningCountryName = winningCountryName.compareTo(countryName) > 0 ? countryName : winningCountryName;
            } else if (maxCountryVotes < countryVotes) {
                maxCountryVotes = countryVotes;
                winningCountryName = countryName;
            }
        }



        out.write((winningCountryName + "\n").getBytes());
        out.write((winningChefName + "\n").getBytes());
        out.flush();

    }
}
