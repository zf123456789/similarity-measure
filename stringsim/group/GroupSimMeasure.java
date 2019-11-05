// DH: 10.4.2017: doSoftGeneral -> Add ascending size order between components
// DH: 13.4.2017: Add asSet

package group;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

import unit.UnitSimMeasure;

public abstract class GroupSimMeasure {
	public String name;
	public abstract Result getSimilarity(ArrayList<String> c1, ArrayList<String> c2, UnitSimMeasure measure);
	
	protected Result doSoftCardinalityGeneral(ArrayList<String> compOne, ArrayList<String> compTwo, UnitSimMeasure measure){
		ArrayList<String> union=new ArrayList<String>();
    	union.addAll(compOne);
    	union.addAll(compTwo);
    	
    	Result r=new Result();
		
    	r.name=name;
    	r.unit=measure.name;
		r.cardinality="soft cardinality";
		
		r.A=compOne.size();
		r.B=compTwo.size();
		r.sA=softCardinality(compOne, measure);
		r.sB=softCardinality(compTwo, measure);
		r.U=union.size();
		r.sU=softCardinality(union, measure);
		r.I=r.A+r.B-r.U;
		r.sI=r.sA+r.sB-r.sU;
		r.sim=(r.sA+r.sB-r.sU)/r.sU;
		r.selfA=softCardinalityTable(compOne, measure);
		r.selfB=softCardinalityTable(compTwo, measure);
		r.union=softCardinalityTable(union, measure);
		return r;
	}
	
	protected double softCardinality(ArrayList<String> set, UnitSimMeasure measure){
		double result=0;
		for(int i=0;i<set.size();i++){
			double sum=0;
			for(int j=0;j<set.size();j++){
				sum+=measure.getSimilarity(set.get(i), set.get(j));
			}
			result+=1.0/sum;
		}
		return result;
	}
	
	protected String softCardinalityTable(ArrayList<String> set, UnitSimMeasure measure){
		String softCardString="CARDINALITY";
		int maxLength=0;
		for(int i=0;i<set.size();i++){
			maxLength=Math.max(maxLength, set.get(i).length());
		}
		maxLength=Math.max(maxLength, softCardString.length());
		maxLength+=1;
		
		String res="";
		res+=String.format("%"+maxLength+"s", "");
		for(int i=0;i<set.size();i++){
			res+=String.format("%"+maxLength+"s", set.get(i));
		}
		res+=String.format("%"+maxLength+"s", "SUM");
		res+=String.format("%"+maxLength+"s", "INVERSE");
		res+="\n";
		double result=0;
		for(int i=0;i<set.size();i++){
			double sum=0;
			res+=String.format("%"+maxLength+"s", set.get(i));
			for(int j=0;j<set.size();j++){
				double val=0;
				val=measure.getSimilarity(set.get(i), set.get(j));
				//
				res+=String.format("%"+maxLength+"s", String.format("%.2f", val));
				sum+=val;
			}
			res+=String.format("%"+maxLength+"s", String.format("%.2f", sum));
			res+=String.format("%"+maxLength+"s", String.format("%.2f", (1.0/sum)));
			result+=1.0/sum;
			res+="\n";
		}
		res+="\n "+softCardString+"  : "+String.format("%.2f", result);
		return res;
	}
		

	protected double doSquaredDifferenceSum(HashMap<String, Integer> hmap1,HashMap<String, Integer> hmap2,HashMap<String, Integer> hmap,UnitSimMeasure measure){
		double sum=0;
		
		Iterator<String> iterator1 = hmap.keySet().iterator();
		while(iterator1.hasNext()) {
			String t1=iterator1.next();
			int a=0;
			if(hmap1.get(t1)!=null){
				a=hmap1.get(t1);
			}
			 
			Iterator<String> iterator2 = hmap.keySet().iterator();
			while(iterator2.hasNext()) {
				String t2=iterator2.next(); 
				int b=0;
				if(hmap2.get(t2)!=null){
					b=hmap2.get(t2);
				}
			 
				sum+=measure.getSimilarity(t1, t2)*(a-b)*(a-b);
			}
		}
		
		return sum;
	}

	
	protected double doDifferenceSum(HashMap<String, Integer> hmap1,HashMap<String, Integer> hmap2,HashMap<String, Integer> hmap,UnitSimMeasure measure){
		double sum=0;
		
		Iterator<String> iterator1 = hmap.keySet().iterator();
		while(iterator1.hasNext()) {
			String t1=iterator1.next();
			int a=0;
			if(hmap1.get(t1)!=null){
				a=hmap1.get(t1);
			}
			 
			Iterator<String> iterator2 = hmap.keySet().iterator();
			while(iterator2.hasNext()) {
				String t2=iterator2.next(); 
				int b=0;
				if(hmap2.get(t2)!=null){
					b=hmap2.get(t2);
				}
				
				sum+=measure.getSimilarity(t1, t2)*Math.abs(a-b);
			}
		}
		return sum;
	}	
	
	protected double doPairwiseSum(HashMap<String, Integer> hmap1,HashMap<String, Integer> hmap2,HashMap<String, Integer> hmap,UnitSimMeasure measure){
		double sum=0;
		
		Iterator<String> iterator1 = hmap.keySet().iterator();
		while(iterator1.hasNext()) {
			String t1=iterator1.next();
			int a=0;
			if(hmap1.get(t1)!=null){
				a=hmap1.get(t1);
			}
			 
			Iterator<String> iterator2 = hmap.keySet().iterator();
			while(iterator2.hasNext()) {
				String t2=iterator2.next(); 
				int b=0;
				if(hmap2.get(t2)!=null){
					b=hmap2.get(t2);
				}
				
				sum+=a*b*measure.getSimilarity(t1, t2);
			}
		}
		
		return sum;
	}
	
	protected ArrayList<String> asSet(ArrayList<String> multiset) {
		final Set<String> temp = new HashSet<String>();
        temp.addAll(multiset);
        ArrayList<String> set=new ArrayList<String>();
        set.addAll(temp);
		
		return set;
	}
}


