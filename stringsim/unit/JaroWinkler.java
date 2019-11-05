package unit;
import uk.ac.shef.wit.simmetrics.similaritymetrics.AbstractStringMetric;

public class JaroWinkler extends UnitSimMeasure
{
 
    public JaroWinkler()
    {
    	name="Jaro Winkler";
    }
 
    public double getSimilarity(String compOne, String compTwo)
    {
		AbstractStringMetric simmetricsMetric;

		simmetricsMetric = new uk.ac.shef.wit.simmetrics.similaritymetrics.JaroWinkler();
		return simmetricsMetric.getSimilarity(compOne, compTwo);
    }
}
