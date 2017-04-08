package codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Pancakes {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++){
			solvenextproblem(i+1);
		}
	}
	public static void solvenextproblem(int casenum) throws IOException{
		String[] pars = br.readLine().split(" ");
		int k = Integer.parseInt(pars[1]);
		char[] pancakes = pars[0].toCharArray();
		char[] target = new char[pancakes.length];
		int numflips = 0;
		for(int i = 0; i < pancakes.length; i++){
			target[i] = '+';
		}
			for(int i = 0; i <= pancakes.length-k; i++){
				if(pancakes[i] == '-'){
					pancakes = flip(pancakes, i, k);
					numflips++;
				}
			}
		
		if(Arrays.equals(pancakes, target)){
			System.out.println("Case #" + casenum + ": " + numflips);
		}else{
			System.out.println("Case #" + casenum + ": IMPOSSIBLE");
		}

	}
	public static char[] flip(char[] p, int start, int k){
		char[] ret = new char[p.length];
		for(int i = 0; i < start; i++){
			ret[i] = p[i];
		}
		for(int i = start; i < start + k; i++){
			if(p[i] == '-'){
				ret[i] = '+';
			}else
				ret[i] = '-';
		}
		for(int i = start+k; i < p.length; i++){
			ret[i] = p[i];
		}
		return ret;
	}

}
