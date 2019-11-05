// DH: 13.4.2017: Use asSet

package group;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import unit.UnitSimMeasure;

public class BraunBanquet extends GroupSimMeasure
{
    public BraunBanquet()
    {
    	name="Braun Banquet";
    }
	
	public Result getSimilarity(ArrayList<String> compOne, ArrayList<String> compTwo,UnitSimMeasure measure)
    {
		compOne = asSet(compOne);
		compTwo = asSet(compTwo);
		
    	Result r=doSoftCardinalityGeneral(compOne,compTwo,measure);
		r.sim=1.0*r.sI/(float) (Math.max(r.sA,r.sB));
    	return r;
    }
}
