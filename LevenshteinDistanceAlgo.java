/* https://en.wikipedia.org/wiki/Levenshtein_distance */
public class LevenshteinDistanceAlgo {
	
	private static int getDistance(String word, String word1, int m, int n) {
		int [][] distance = new int[m+1][n+1];
		
		for(int i=0; i<m+1; i++)
			distance[i][0] = i;
		
		for(int j=0; j<n+1; j++)
			distance[0][j] = j;
		
		
		/*
		 * for(int i=0; i<distance.length; i++) { for(int j=0; j<distance[i].length;
		 * j++) { System.out.print(distance[i][j]+" "); } System.out.println(); }
		 */
		for(int i=1; i<distance.length; i++) {
			int cost;
			for(int j=1; j<distance[i].length; j++) {
				if(word.charAt(i-1) == word1.charAt(j-1))
					cost = 0;
				else 
					cost = 1;
				
				distance[i][j] = Math.min(Math.min(distance[i-1][j]+1, distance[i][j-1]+1), distance[i-1][j-1]+cost);
			}
		}
		return distance[m][n];
	}
	public static void main(String[] args) {
		String word = "ash";
		String word1 = "ashley";
		
		int m = word.length();
		int n = word1.length();
		
		System.out.println(getDistance(word, word1, m-1, n-1));
	}
}
