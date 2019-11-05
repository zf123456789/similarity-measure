package unit;

public class ExactMatch extends UnitSimMeasure
{
    private String compOne;
    private String compTwo;
 
    public ExactMatch()
    {
    	name="Exact Match";
    }
 
    public double getSimilarity(String compOne, String compTwo)
    {
    	if(compOne.equals(compTwo)){
			return 1;
		}
		return 0;
    }
}
