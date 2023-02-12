package com.codechef;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

//https://www.codechef.com/LRNDSA02/problems/ZCO15004
public class CodeChefZCO15004 {

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

    static class Point {
        final int x;
        final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Bound {
        final int y;
        final int position;

        public Bound(int y, int position) {
            this.y = y;
            this.position = position;
        }
    }

    public static void main(String[] args) throws Exception {
        FastReader fastReader = new FastReader();
        int numberOfPoints = fastReader.readInt();
        Point[] points = new Point[numberOfPoints];
        for(int i = 0; i < numberOfPoints ; i++) {
            points[i] = new Point(fastReader.readInt(), fastReader.readInt());
        }
        Arrays.sort(points, Comparator.comparingInt(o -> o.x));
        Stack<Bound> stack = new Stack();
        int []rightBounds = new int[numberOfPoints];
        int []leftBounds = new int[numberOfPoints];
        for(int i =  0 ; i < numberOfPoints ; i++) {
            Point point = points[i];
            while(!stack.isEmpty() && stack.peek().y > point.y) {
                Bound rightBound = stack.pop();
                rightBounds[rightBound.position] = point.x;
            }
            Bound bound = new Bound(point.y, i);
            stack.push(bound);
        }
        while(!stack.isEmpty()) {
            Bound rightBound = stack.pop();
            rightBounds[rightBound.position] = 100000;
        }
        for(int i =  numberOfPoints - 1 ; i > -1 ; i--) {
            Point point = points[i];
            while(!stack.isEmpty() && stack.peek().y > point.y) {
                Bound leftBound = stack.pop();
                leftBounds[leftBound.position] = point.x;
            }
            Bound bound = new Bound(point.y, i);
            stack.push(bound);
        }
        while(!stack.isEmpty()) {
            Bound leftBound = stack.pop();
            leftBounds[leftBound.position] = 0;
        }
        int maxArea = (100000 - points[numberOfPoints -1].x) * 500;
        for(int i = 0 ; i < numberOfPoints ; i++) {
            maxArea = Math.max(maxArea, ((rightBounds[i] - leftBounds[i]) * points[i].y));
        }
        for(int i = 0; i < numberOfPoints - 1 ; i++) {
            maxArea = Math.max(maxArea, ((points[i + 1].x - points[i].x) * 500));
        }
        out.write((maxArea + "\n").getBytes());
        out.flush();

    }
}
