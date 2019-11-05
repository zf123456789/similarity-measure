package unit;
import uk.ac.shef.wit.simmetrics.similaritymetrics.AbstractStringMetric;

public class SmithWaterman extends UnitSimMeasure
{
 
    public SmithWaterman()
    {
    	name="Smith Waterman";
    }
 
    public double getSimilarity(String compOne, String compTwo)
    {
		AbstractStringMetric simmetricsMetric;

		simmetricsMetric = new uk.ac.shef.wit.simmetrics.similaritymetrics.SmithWaterman();
		return simmetricsMetric.getSimilarity(compOne, compTwo);
    }
}
