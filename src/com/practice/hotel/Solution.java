package com.practice.hotel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'awardTopKHotels' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING positiveKeywords
     *  2. STRING negativeKeywords
     *  3. INTEGER_ARRAY hotelIds
     *  4. STRING_ARRAY reviews
     *  5. INTEGER k
     */

    public static class HotelRank implements Comparable<HotelRank> {
        int hotelId;
        int rating;

        public HotelRank(int hotelId, int rank) {
            this.hotelId = hotelId;
            this.rating = rank;
        }

        public int compareTo(HotelRank hotelRank) {
            if (hotelRank.rating == this.rating) {
                return this.hotelId - hotelRank.hotelId;
            }
            return hotelRank.rating - this.rating;
        }

    }

    public static List<Integer> awardTopKHotels(String positiveKeywords, String negativeKeywords, List<Integer> hotelIds, List<String> reviews, int k) {
        List<HotelRank> topHotelRanks = new ArrayList<>(1000000);

        List<Integer> topHotels = new ArrayList<>(k);

        Map<String, Boolean> positiveKeywordMap = new HashMap<String, Boolean>();
        Map<String, Boolean> negativeKeywordMap = new HashMap<String, Boolean>();

        for(String word : positiveKeywords.split(" ")) {
            word = word.replaceAll(",", "").replaceAll("\\.", "");
            positiveKeywordMap.put(word.toLowerCase(), true);
        }

        for(String word : negativeKeywords.split(" ")) {
            word = word.replaceAll(",", "").replaceAll("\\.", "");
            negativeKeywordMap.put(word.toLowerCase(), true);
        }

        for(int i = 0; i < 1000000; i++) {
            topHotelRanks.add(i, new HotelRank(i, 0));
        }

        for(int i = 0; i < reviews.size(); i++) {
            if(topHotelRanks.size() < hotelIds.get(i) || topHotelRanks.get(hotelIds.get(i)) == null) {
                topHotelRanks.set(hotelIds.get(i), new HotelRank(hotelIds.get(i), 0));
            }
            for(String reviewWord : reviews.get(i).split(" ")) {
                reviewWord = reviewWord.replaceAll(",", "").replaceAll("\\.", "");
                if(positiveKeywordMap.get(reviewWord.toLowerCase()) != null) {
                    topHotelRanks.get(hotelIds.get(i)).rating = topHotelRanks.get(hotelIds.get(i)).rating + 3;
                } else if (negativeKeywordMap.get(reviewWord.toLowerCase()) != null) {
                    topHotelRanks.get(hotelIds.get(i)).rating = topHotelRanks.get(hotelIds.get(i)).rating - 1;
                }
            }
        }

        Collections.sort(topHotelRanks);

        for(int i = 0; i < reviews.size() && k > 0; i++, k--) {
            topHotels.add(topHotelRanks.get(i).hotelId);
        }

        return topHotels;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String positiveKeywords = bufferedReader.readLine();

        String negativeKeywords = bufferedReader.readLine();

        int hotelIdsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> hotelIds = IntStream.range(0, hotelIdsCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int reviewsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> reviews = IntStream.range(0, reviewsCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> result = Result.awardTopKHotels(positiveKeywords, negativeKeywords, hotelIds, reviews, k);

        System.out.println(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
    }
}
