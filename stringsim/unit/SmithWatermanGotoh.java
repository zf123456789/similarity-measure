package unit;
import uk.ac.shef.wit.simmetrics.similaritymetrics.AbstractStringMetric;

public class SmithWatermanGotoh extends UnitSimMeasure
{
 
    public SmithWatermanGotoh()
    {
    	name="Smith Waterman Gotoh";
    }
 
    public double getSimilarity(String compOne, String compTwo)
    {
		AbstractStringMetric simmetricsMetric;

		simmetricsMetric = new uk.ac.shef.wit.simmetrics.similaritymetrics.SmithWatermanGotoh();
		return simmetricsMetric.getSimilarity(compOne, compTwo);
    }
}
