package group;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

import unit.UnitSimMeasure;

public class Euclidean extends GroupSimMeasure
{
    public Euclidean()
    {
    	name="Euclidean";
    }
	
	public Result getSimilarity(ArrayList<String> compOne, ArrayList<String> compTwo,UnitSimMeasure measure)
    {
		HashMap<String, Integer> hmap= new HashMap<String, Integer>();
		
    	HashMap<String, Integer> hmap1 = new HashMap<String, Integer>();
		int val;
		for(int i=0;i<compOne.size();i++){
			val=0;
			if(hmap1.containsKey(compOne.get(i))){
				val=hmap1.get(compOne.get(i));
			}
			val++;
			hmap1.put(compOne.get(i), val);
			hmap.put(compOne.get(i), 1);
		}
		
		HashMap<String, Integer> hmap2 = new HashMap<String, Integer>();
		for(int i=0;i<compTwo.size();i++){
			val=0;
			if(hmap2.containsKey(compTwo.get(i))){
				val=hmap2.get(compTwo.get(i));
			}
			val++;
			hmap2.put(compTwo.get(i), val);
			hmap.put(compTwo.get(i), 1);
		}
		
		double top=Math.sqrt(doSquaredDifferenceSum(hmap1,hmap2,hmap,measure));
		double b1=doPairwiseSum(hmap1,hmap1,hmap,measure);
		double b2=doPairwiseSum(hmap2,hmap2,hmap,measure);
		double bottom=Math.sqrt(b1*b1+b2*b2);
		
    
    	Result r=new Result();
    	r.name=name;
    	r.unit=measure.name;
		r.cardinality="soft";
		r.sim=1-1.0*top/bottom;
		r.hmap1=hmap1;
		r.hmap2=hmap2;
		return r;
    }
}
