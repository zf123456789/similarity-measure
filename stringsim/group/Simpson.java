// DH: 13.4.2017: Use asSet

package group;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import unit.UnitSimMeasure;

public class Simpson extends GroupSimMeasure
{
    public Simpson()
    {
    	name="Simpson";
    }
	
	public Result getSimilarity(ArrayList<String> compOne, ArrayList<String> compTwo,UnitSimMeasure measure)
    {
		compOne = asSet(compOne);
		compTwo = asSet(compTwo);
		
    	Result r=doSoftCardinalityGeneral(compOne,compTwo,measure);
		r.sim=r.sI/(float) (Math.min(r.sA,r.sB));
    	return r;
    }
}
