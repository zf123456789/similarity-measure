package unit;
import uk.ac.shef.wit.simmetrics.similaritymetrics.AbstractStringMetric;

public class Levenshtein extends UnitSimMeasure
{
 
    public Levenshtein()
    {
    	name="Levenshtein";
    }
 
    public double getSimilarity(String compOne, String compTwo)
    {
		AbstractStringMetric simmetricsMetric;

		simmetricsMetric = new uk.ac.shef.wit.simmetrics.similaritymetrics.Levenshtein();
		return simmetricsMetric.getSimilarity(compOne, compTwo);
    }
}
