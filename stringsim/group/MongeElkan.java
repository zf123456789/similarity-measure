package group;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import unit.UnitSimMeasure;

public class MongeElkan extends GroupSimMeasure
{
    public MongeElkan()
    {
    	name="Monge Elkan";
    }
	
	public Result getSimilarity(ArrayList<String> c1, ArrayList<String> c2, UnitSimMeasure measure){
		float sumMatches = 0.0f;
        float maxFound;

        int maxLength=0;
        for (Object str2Token : c2) {
        	maxLength=Math.max(maxLength, str2Token.toString().length());
        }
        maxLength+=1;

		String res="";
		res+=String.format("%"+maxLength+"s", "");
		for(int i=0;i<c2.size();i++){
			res+=String.format("%"+maxLength+"s", c2.get(i));
		}
		res+=String.format("%"+maxLength+"s", "MAX");
		res+="\n";
        for (Object str1Token : c1) {
			res+=String.format("%"+maxLength+"s", str1Token);
            maxFound = 0.0f;
            for (Object str2Token : c2) {
                final float found = (float) measure.getSimilarity((String) str1Token, (String) str2Token);
                if (found > maxFound) {
                    maxFound = found;
                }
        		res+=String.format("%"+maxLength+"s", String.format("%.2f", found));
            }
			double val=0;
			val=maxFound;

    		res+=String.format("%"+maxLength+"s", String.format("%.2f", val));
			res+="\n";
			
			sumMatches += val;
        }
		
        
        Result r=new Result();
		r.cardinality="soft";
		
    	r.sim=sumMatches / c1.size();
    	r.name=name;
    	r.unit=measure.name;
    	r.m_e=res;
    	r.m_e_sum=sumMatches;
    	return r;
	}

}
