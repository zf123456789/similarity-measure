package unit;

public class LongestCommonSubstring extends UnitSimMeasure
{
    private String compOne;
    private String compTwo;
 
    public LongestCommonSubstring()
    {
    	name="Longest Common Substring";
    }
 
    public double getSimilarity(String compOne, String compTwo)
    {
    	if ((compOne.length() > 0 || !compOne.isEmpty())  || (compTwo.length() > 0 || !compTwo.isEmpty()))
        {
            this.compOne = compOne;
            this.compTwo = compTwo;
        }  
        int maxLen = 0;
        int fl = compOne.length();
        int sl = compTwo.length();
        int[][] table = new int[fl+1][sl+1];
       
        for(int s=0; s <= sl; s++)
          table[0][s] = 0;
        for(int f=0; f <= fl; f++)
          table[f][0] = 0;

        for (int i = 1; i <= fl; i++) {
            for (int j = 1; j <= sl; j++) {
                if (compOne.charAt(i-1) == compTwo.charAt(j-1)) {
                    if (i == 1 || j == 1) {
                        table[i][j] = 1;
                    }
                    else {
                        table[i][j] = table[i - 1][j - 1] + 1;
                    }
                    if (table[i][j] > maxLen) {
                        maxLen = table[i][j];
                    }
                }
            }
        }
        return maxLen*1.0/Math.max(fl,sl);
    }
}
