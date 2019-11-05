
// DH: 12.4.2017: Add 2Grams and padding choice.

package unit;
import uk.ac.shef.wit.simmetrics.similaritymetrics.AbstractStringMetric;
import uk.ac.shef.wit.simmetrics.tokenisers.*;

public class QGramsDistance extends UnitSimMeasure
{
	private InterfaceTokeniser tokeniser;
 
    public QGramsDistance(int choice)
    {
		switch(choice) {
			case 0: 
				name="2Grams Distance (no padding)";
				tokeniser=new TokeniserQGram2();
				break;
			case 1: 
				name="2Grams Distance (with padding)";
				tokeniser=new TokeniserQGram2Extended();
				break;
			case 2: 
				name="3Grams Distance (no padding)";
				tokeniser=new TokeniserQGram3();
				break;
			default: 
				name="3Grams Distance (with padding)";
				tokeniser=new TokeniserQGram3Extended();
				break;
		};
    }
 
    public double getSimilarity(String compOne, String compTwo)
    {
		AbstractStringMetric simmetricsMetric;

		simmetricsMetric = new uk.ac.shef.wit.simmetrics.similaritymetrics.QGramsDistance(tokeniser);
		return simmetricsMetric.getSimilarity(compOne, compTwo);
    }
}
