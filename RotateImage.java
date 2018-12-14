/*
	
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. 
DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]

Example 2:

Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]


*/
import java.util.*;

class RotateImage{
	static void swap(int i, int j, int [] array){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		int n = inp.nextInt();
		int [][] array = new int[n][n];

		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				array[i][j] = inp.nextInt();
			}
		}
		// transpose of matrix..
		for(int i=0; i<n; i++){
			for(int j=i; j<n; j++){
				int d = array[i][j];
				array[i][j] = array[j][i];
				array[j][i] = d;
			}
		}
		//reverse of matrix (1D)
		for(int i=0; i<n/2; i++){			
			swap(i, array.length-1-i, array[i]);
		}
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}
}
