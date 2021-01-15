package ru.testForJob;

import java.util.Scanner;

public class Rhombus {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int height = console.nextInt();
        int width = console.nextInt();
        printDiamond(height, width);

    }

    private static void printDiamond(int height, int width) {
        String[][] field = new String[height][width];
        int x = width / 2;
        int y = height / 2;
        int lastX = width - 1;
        int lastY = height - 1;
        field[0][width / 2] = "#";
        field[height - 1][width / 2] = "#";
        for (int i = 0; i < height; i++) {
            int oldCheckPoint = 0;
            for (int j = 0; j < width; j++) {
                int checkPoint = 0;
                if (j <= x && i <= y) {
                    checkPoint = checkVector(0, y, x, 0, j, i);
                }
                if (j > x && i <= y) {
                    checkPoint = checkVector(x, 0, lastX, y, j, i);

                }
                if (j <= x && i > y) {
                    checkPoint = checkVector(0, y, x, lastY, j, i);

                }
                if (j > x && i > y) {
                    checkPoint = checkVector(x, lastY, lastX, y, j, i);

                }
                if (checkPoint == 0) {
                    field[i][j] = "#";
                } else if (checkPoint * oldCheckPoint < 0) {
                    field[i][j] = "#";

                } else {
                    field[i][j] = " ";
                }
                oldCheckPoint = checkPoint;
                System.out.print(field[i][j]);

            }
            System.out.println();
        }
    }

    private static int checkVector(int x1, int y1, int x2, int y2, int x, int y) {
        int answer = (x - x1) * (y2 - y1) - (y - y1) * (x2 - x1);
        return answer;
    }
}



