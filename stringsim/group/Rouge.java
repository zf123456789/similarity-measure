package group;

import java.util.ArrayList;

import unit.UnitSimMeasure;

public class Rouge extends GroupSimMeasure
{
    public Rouge()
    {
    	name="Rouge";
    }
	
	public Result getSimilarity(ArrayList<String> compOne, ArrayList<String> compTwo,UnitSimMeasure measure)
    {
    	Result r=doSoftCardinalityGeneral(compOne,compTwo,measure);
		r.precision=r.sI/r.sA;
    	r.recall=r.sI/r.sB;
    	r.alpha=0.5;
    	r.sim=1/(r.alpha/r.precision+(1-r.alpha)/r.recall);
    	return r;
    }
}
