package codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TidyNumbers {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i< t; i++){
			System.out.println("Case #" + i+1 + ": " + solvenextproblem());
		}

	}
	public static long solvenextproblem() throws IOException{
		long N = Long.parseLong(br.readLine());
		if(N < 10){
			return N;
		}
		long[] rep = new long[(int)Math.floor(Math.log10((double)N))+1];
		long holder = N;
		for(int i = 0; i < Math.floor(Math.log10((double)holder))+1; i++){
			rep[rep.length-i-1] = N %10;
			N/=10;
		}
		if(isTidy(rep)){
			return holder;
		}
		else{
			return makeLong(findlastTidy(rep));
		}
	}
	
	public static long findlastTidy(long[] N){
		for(int i = N.length-1; i > 0; i--){
			while(N[i] < N[i]-1){
				if(N[i] == 0){
					N[i] = 9;
					N[i-1] = N[i-1]-1;
				}else{
					N[i] = N[i-1];
				}
			}
		}
		return N;
	}

	public static boolean isTidy(long[] k){
		for(int i = 1; i < k.length; i++){
			if(k[i] < k[i-1])
				return false;
		}
		return true;
	}
	public static long makeLong(long[] k){
		long retval = 0;
		for(int i = 0; i < k.length; i++){
			retval += k[i] * Math.pow(10, i);
		}
		return retval;
	}

}
