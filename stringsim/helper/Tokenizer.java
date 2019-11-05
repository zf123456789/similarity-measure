package helper;
import java.util.ArrayList;

public class Tokenizer {
	public static ArrayList<String> split(String s, String divider){
		String [] components = s.split(divider);
		
		return makeUnits(components);
	}

	public static ArrayList<String> makeUnits(String [] components){
		ArrayList<String> units=new ArrayList<String>();
		for(int i=0;i<components.length;i++){
			if(components[i].length()!=0){
				units.add(components[i].toLowerCase());
			}
		}
		return units;
	}
}
