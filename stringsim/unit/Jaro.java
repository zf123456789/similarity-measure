package unit;
import uk.ac.shef.wit.simmetrics.similaritymetrics.AbstractStringMetric;

public class Jaro extends UnitSimMeasure
{
 
    public Jaro()
    {
    	name="Jaro";
    }
 
    public double getSimilarity(String compOne, String compTwo)
    {
		AbstractStringMetric simmetricsMetric;

		simmetricsMetric = new uk.ac.shef.wit.simmetrics.similaritymetrics.Jaro();
		return simmetricsMetric.getSimilarity(compOne, compTwo);
    }
}
