class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // init first cell
        List<Integer> res = new ArrayList<Integer>(){{add(matrix[0][0]);}};
        int width = matrix[0].length;
        int height = matrix.length;
        int size = width * height;
        // x: horzational, y: vertical
        int currentX = 0;
        int currentY = 0;
        // vector: right => top => left => bottom
        int[] vectorX = new int[]{1, 0, -1, 0};
        int[] vectorY = new int[]{0, 1, 0, -1};
        int vectorIndex = 0;
        int leftBorder = 0;
        int rightBorder = width - 1;
        int bottomBorder = 0;
        int topBorder = height - 1;
        for (int step = 1; step < size; step++) {
            currentX += vectorX[vectorIndex];
            currentY += vectorY[vectorIndex];
            // check exceed border
            if (currentX < leftBorder || currentX > rightBorder || currentY < bottomBorder || currentY > topBorder) {
                vectorIndex = (vectorIndex + 1) % 4;
                // exceed right boreder
                if (currentX > rightBorder) {
                    currentX = rightBorder;
                    currentY++;
                    bottomBorder++;
                } 
                // exceed top border
                else if (currentY > topBorder) {
                    currentY = topBorder;
                    currentX--;
                    rightBorder--;
                }
                // exceed left border
                else if (currentX < leftBorder) {
                    currentX = leftBorder;
                    currentY--;
                    topBorder--;
                }
                // exceed bottom border
                else if (currentY < bottomBorder) {
                    currentY = bottomBorder;
                    currentX++;
                    leftBorder++;
                }
            }
            res.add(matrix[currentY][currentX]);
        }
        return res;
    }
}