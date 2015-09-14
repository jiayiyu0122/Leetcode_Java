// rotate image by 90 degrees in place.
public class Solution {
    public void rotate(int[][] matrix) {
        int size = matrix.length;
        for(int layer=0; layer<size; layer++){
            int first = layer;
            int last = size-1-layer;
            for(int i=first; i< last; i++){
                int offset = i-first;
                // save top
                int temp = matrix[first][i];
                // left -> top
                matrix[first][i] = matrix[last-offset][first];
                // bottom -> left
                matrix[last-offset][first] = matrix[last][last-offset];
                // right -> bottom
                matrix[last][last-offset] = matrix[i][last];
                // top -> right
                matrix[i][last] = temp;
            }
        }
        
    }
}