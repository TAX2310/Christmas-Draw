// importing the random utility to genorate random numbers.
import java.util.Random;

public class ChristmasDraw {
	public static void main(String[] args) {
		// defining 2 arrays bouth filled with all family members called give and recive.
		String [] give = {"x1","x2","x3","x4","x5","y1","y2","y3","y4","y5"};
		String [] recive = {"x1","x2","x3","x4","x5","y1","y2","y3","y4","y5"};
		// defining a 2d array filled with the diforent couples within the family. 
		String [][] couples = {{"x1","y1"},{"x2","y2"},{"x3","y3"},{"x4","y4"},{"x5","y5"}} ;
		// defining a 2d array of last years draw filled with placeholder values (cant use "null" in swich statment). 
		String [][] lastYear = {{"x0","y0"},{"x0","y0"},{"x0","y0"},{"x0","y0"},{"x0","y0"},{"x0","y0"},{"x0","y0"},{"x0","y0"},{"x0","y0"},{"x0","y0"}};
		int n = 10;
		// defining r as a random object.
		Random r = new Random();
		int x = 0;

		// for loop that iterates through last year and this year.
		for (int z = 0; z < 2; z++) {
			// defining l as the first element in the array lastYear.
			String l = lastYear[0][0];
			// if statment that prints heders for last year and next year.
			if (z == 0) {
				System.out.println("List of last year's draw:");
			}
			else{
				System.out.println("List of next year's draw:");
			}
			// while loop that loops from n down to x.
			while(x < n){
				// defing i and j as random intigers between 0 and n.
				int i = r.nextInt(n);
				int j = r.nextInt(n);
				// a swich statment to check if the array lastYear has been filed or still has place holders.
				switch(l) {
					// first case if lastYear does have placeholders and an if statment that uses the check method to determin if the family members at i and j are together in the array couples. 
					case "x0": if(!check(couples, give[i], recive[j]) 
								&& !check(couples, give[j], recive[i]) ){
								// conditions that print the corect pairs and places them at the end of there arrays then decreases n by one and replaces the placeholders in lastYear.
								System.out.println(give[i] + " bought for " + recive[j]);
								String hold = give[i];
								give[i] = give[n-1];
								give[n-1] = hold;
								hold = recive[j];
								recive[j] = recive[n-1];
								recive[n-1] = hold;
								lastYear[n-1][0] = give[i];
								lastYear[n-1][1] = recive[j];
								n = n-1;
								}
					// second case if lastYear does not have placeholders and an if that does the same as in the first case but also checks if i and j are together in lastYear.
					default: if(!check(couples, give[i], recive[j]) 
								&& !check(couples, give[j], recive[i]) 
								&& !check(lastYear, give[i], recive[j]) ){
								// conditions that print the corect pairs and places them at the end of there arrays then decreases n by one.
								System.out.println(give[i] + " will buy for " + recive[j]);
								String hold = give[i];
								give[i] = give[n-1];
								give[n-1] = hold;
								hold = recive[j];
								recive[j] = recive[n-1];
								recive[n-1] = hold;
								n = n-1;
								}
				}
			}
			// make n 10 again for the next iteration of the for loop.
			n = 10;
		}
	}
	// method to check if 2 elements (x and y) are in the array (a) and checks if ther the same and returns a boolean. 
	public static boolean check(String [][] a, String x, String y) {
		for(int i = 0 ; i < a.length; i++){
			if(a[i][0].equals(x) && a[i][1].equals(y) 
				|| x.equals(y)){ 
				return true;
			}
		}
		return false;
	}
}