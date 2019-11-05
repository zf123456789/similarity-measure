// DH: 4,4,2017: if the parameters have differents lengths, the result is now 0 instead of -1.

package unit;

public class Hamming extends UnitSimMeasure
{
    private String compOne;
    private String compTwo;
 
    public Hamming()
    {
    	name="Hamming";
    }
 
    public double getSimilarity(String compOne, String compTwo)
    {
    	if ((compOne.length() > 0 || !compOne.isEmpty())  || (compTwo.length() > 0 || !compTwo.isEmpty()))
    	{
    		this.compOne = compOne;
    		this.compTwo = compTwo;
    	}    
    	  
    	if (compOne.length() != compTwo.length())
    	{
    		return 0;
    	}
    	
       	int counter = 0;

    	for (int i = 0; i < compOne.length(); i++){
    		if (compOne.charAt(i) != compTwo.charAt(i)) counter++;
    	}

    	return (compOne.length()-counter)*1.0/compOne.length();
    }
}
