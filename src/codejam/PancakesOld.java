package codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pancakes {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++){
			solvenextproblem(i+1);
		}
	}
	public static void solvenextproblem(int casenum){
		br.readLine().split(" ");
		
		System.out.println("Case #" + casenum + ": " + numflips);
		
		System.out.println("Case #" + casenum + ": IMPOSSIBLE");

	}

}
