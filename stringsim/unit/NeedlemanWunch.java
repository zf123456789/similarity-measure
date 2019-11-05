package unit;
import uk.ac.shef.wit.simmetrics.similaritymetrics.AbstractStringMetric;

public class NeedlemanWunch extends UnitSimMeasure
{
 
    public NeedlemanWunch()
    {
    	name="Needleman Wunch";
    }
 
    public double getSimilarity(String compOne, String compTwo)
    {
		AbstractStringMetric simmetricsMetric;

		simmetricsMetric = new uk.ac.shef.wit.simmetrics.similaritymetrics.NeedlemanWunch();
		return simmetricsMetric.getSimilarity(compOne, compTwo);
    }
}
