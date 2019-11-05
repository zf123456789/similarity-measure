package group;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

import unit.UnitSimMeasure;

public class Chaudhuri extends GroupSimMeasure
{
    public Chaudhuri()
    {
    	name="Chaudhuri";
    }
	
	public Result getSimilarity(ArrayList<String> compOne, ArrayList<String> compTwo,UnitSimMeasure measure)
    {
		int len1 = compOne.size();
		int len2 = compTwo.size();
	 
		double[][] dp = new double[len1 + 1][len2 + 1];
	 
		for (int i = 0; i <= len1; i++) {
			dp[i][0] = i;
		}
	 
		for (int j = 0; j <= len2; j++) {
			dp[0][j] = j;
		}
	 
		for (int i = 0; i < len1; i++) {
			String c1 = compOne.get(i);
			for (int j = 0; j < len2; j++) {
				String c2 = compTwo.get(j);
	 
				if (c1.equals(c2)) {
					dp[i + 1][j + 1] = dp[i][j];
				} else {
					double sim=1-measure.getSimilarity(compOne.get(i), compTwo.get(j));
					double replace = dp[i][j] + sim;
					double insert = dp[i][j + 1] + sim;
					double delete = dp[i + 1][j] + sim;
					
					double min = replace > insert ? insert : replace;
					min = delete > min ? min : delete;
					dp[i + 1][j + 1] = min;
				}
			}
		}
	 
		Result r=new Result();
    	r.name=name;
    	r.unit=measure.name;
		r.cardinality="soft";
		r.sim=1-dp[len1][len2]/Math.max(len1,len2);	
		r.matrix=dp;
		return r;
    }
}
