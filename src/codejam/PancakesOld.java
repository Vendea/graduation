package codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class PancakesOld {
	
	static HashMap<String, Integer> visited = new HashMap<>();
	static int bestsofar = -99;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int numflips;
	char[] pchars;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++){
			solvenextproblem(i+1);
		}
	}
	public static void solvenextproblem(int casenum) throws IOException{
		visited = new HashMap<>();
		bestsofar = -99;
		String[] pars = br.readLine().split(" ");
		int k = Integer.parseInt(pars[1]);
		String pancakes = pars[0];
		String target = "";
		for(int i = 0; i < pancakes.length(); i++){
			target = target + '+';
		}
		visited.put(pancakes, 0);
		if(solveFlips(k, 0, pancakes, pancakes, target)){
			System.out.println("Case #" + casenum + ": " + visited.get(target));
		}
		else{
			System.out.println("Case #" + casenum + ": IMPOSSIBLE");
		}

	}
	public static boolean solveFlips(int k, int flips, String root, String start, String target){
		if(visited.containsKey(start)){
			if(visited.get(start) < flips){
				return false;
			}
		}
		visited.put(start, flips);
		if(start.equals(target)){
			visited.put(target, flips);
			if(bestsofar == -99){
				bestsofar = flips;
			}else{
				bestsofar = flips < bestsofar ? flips : bestsofar;
			}
			return true;
		}
		for(int i = 0; i <= start.length()-k; i++){
			solveFlips(k, flips +1, root, flip(i, k, start), target);
		}
		if(bestsofar == -99)
			return false;
		else
			return true;
	}
	
	public static String flip(int start, int len, String flapjacks){
		String ret = flapjacks.substring(0, start);
		for(int i = start; i < start+len; i++){
			if(flapjacks.charAt(i) == '+'){
				ret = ret + '-';
			} else{
				ret = ret + '+';
			}
		}
		ret = ret + flapjacks.substring(start+len);
		return ret;
	}

}
