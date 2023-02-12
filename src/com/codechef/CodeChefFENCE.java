package com.codechef;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//https://www.codechef.com/LRNDSA03/problems/FENCE
public class CodeChefFENCE {
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

    static class Position {
        final int row;
        final int column;

        public Position(int row, int column) {
            this.row = row;
            this.column = column;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return row == position.row && column == position.column;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, column);
        }
    }


    public static void main(String[] args) throws Exception {
        FastReader fastReader = new FastReader();
        int testCases = fastReader.readInt();
        do {
            int fenceLength = 0;
            int totalRows = fastReader.readInt();
            int totalColumn = fastReader.readInt();
            int totalPlants = fastReader.readInt();
            Map<Position, Boolean> plantPositions = new HashMap<>(totalPlants);
            for(int i =0; i < totalPlants ; i++) {
                Position position = new Position(fastReader.readInt(), fastReader.readInt());
                plantPositions.put(position, true);
            }

            for (Position position : plantPositions.keySet()) {
                Position abovePosition = new Position(position.row - 1, position.column);
                if(plantPositions.get(abovePosition) == null) {
                    fenceLength++;
                }
                Position belowPosition = new Position(position.row + 1, position.column);
                if(plantPositions.get(belowPosition) == null) {
                    fenceLength++;
                }

                Position leftPosition = new Position(position.row, position.column - 1);
                if(plantPositions.get(leftPosition) == null) {
                    fenceLength++;
                }
                Position rightPosition = new Position(position.row, position.column + 1);
                if(plantPositions.get(rightPosition) == null) {
                    fenceLength++;
                }
            }
            out.write((fenceLength + "\n").getBytes());
        } while (--testCases != 0);
        out.flush();

    }
}
