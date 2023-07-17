package SourceFiles;

import java.util.Vector;

public class QuadWorld extends World{
    public QuadWorld(int width, int height) {
        round = 1;
        this.height = height;
        this.width = width;
        worldBoard = new char[height + 2][width + 2];
        for (int i = 0; i < (height + 2); i++) {
            for (int j = 0; j < (width + 2); j++) {
                if (i == 0 || i == (height + 1)) worldBoard[i][j] = '-';
                else {
                    if (j == 0 || j == (width + 1)) worldBoard[i][j] = '|';
                    else worldBoard[i][j] = ' ';
                }
            }
        }
        type = "Quad";
        organisms = new Vector<>();
        messages = new Vector<>();
    }
}
