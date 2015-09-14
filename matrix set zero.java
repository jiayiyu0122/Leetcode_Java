/**
 * Write and algorithm such that if an element in an MxN matrix,
 * where each pixel in the image is 4 bytes, 
 * write a method to rotate the image by 90 degrees.
 * @author sherry
 *
 */
public class Solution {
	public int[][] matrixSetZero(int[][] matrix){
		int row = matrix.length;
		int column = matrix[0].length;
		boolean[] rowboolean = new boolean[row];
		boolean[] columnboolean = new boolean[column];
		for(int i=0; i<row; i++){
			for(int j=0; j<column; j++){
				if(matrix[i][j] == 0){
					rowboolean[i] = true;
					columnboolean[j] = true;
				}
			}
		}
		for(int i=0; i<row; i++){
			if(rowboolean[i] == true){
				for(int j=0; j<column; j++){
					matrix[i][j] = 0;
				}
			}
		}
		for(int i=0; i<column; i++){
			if(columnboolean[i] == true){
				for(int j=0; j<row; j++){
					matrix[j][i] = 0;
				}
			}
		}
		
		return matrix;
		
	}
	
	public static void main(String args[]){
		int[][] matrix = {{1,0,3},{4,0,6},{7,8,9}};
		Solution temp = new Solution();
		int row = matrix.length;
		int column = matrix[0].length;
	    matrix = temp.matrixSetZero(matrix);
		for(int i=0; i<row; i++){
			for(int j=0; j<column; j++){
				System.out.print(matrix[i][j]);
			}
			System.out.print("\n");
		}
		
	}

}

