public class Canvas {
    private char[][] canvas;
    private String completeCanvas = "";

    public Canvas(int width, int height) {
        this.canvas = new char [height + 2][width + 2];
        for(int i = 0; i < (height + 2); i++) {
            canvas[i][0] = '|';
            canvas[i][width + 1] = '|';
        }
        for(int i = 0; i < (width + 2); i++) {
            canvas[0][i] = '-';
            canvas[height + 1][i] = '-';
        }
        for(int i = 1; i < (width + 1); i++) {
            for(int j = 1; j < (height + 1); j++) {
                canvas[j][i] = ' ';
            }
        }
    }

    public Canvas draw(int x1, int y1, int x2, int y2) {
        if(x1 == x2) {
            for(int i = 1; i < y2 + 2; i++) {
                canvas[x1 + 1][i] = 'x';
            }
        }else if(y1 == y2) {
            for(int i = 1; i < x2 + 2; i++) {
                canvas[i][y1 + 1] = 'x';
            }
        }else {
            int minValueToX = Math.min(x1, x2);
            int maxValueToX = Math.max(x1, x2);
            int minValueToY = Math.min(y1, y2);
            int maxValueToY = Math.max(y1, y2);
            for(int i = minValueToX + 1; i < maxValueToX + 2; i++) {
                canvas[y1 + 1][i] = 'x';
                canvas[y2 + 1][i] = 'x';
            }
            for(int i = minValueToY + 1; i < maxValueToY + 2; i++) {
                canvas[i][x1 +1] = 'x';
                canvas[i][x2 +1] = 'x';
            }

        }
        return this;
    }

    public Canvas fill(int x, int y, char ch) {
        if(canvas[y + 1][x + 1] == ' ') {
            canvas[y + 1][x + 1] = ch;
        }
        return this;
    }

    public String drawCanvas() {
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                completeCanvas += canvas[i][j];
            }
            if (i != canvas.length - 1) {
                completeCanvas += "\n";
            }
        }
        return completeCanvas;
    }
}
