package helper;
import java.util.ArrayList;

public class QGrammer {	
	public static ArrayList<Unit> split(String s, int q){
		s = s.replaceAll("\\s+","");

		int num=s.length()-q+1;
		String [] components=new String[num];
		for(int i=0;i<num;i++){
			components[i]=s.substring(i, i+q);
		}
		
		return makeUnits(components);
	}

	public static ArrayList<Unit> makeUnits(String [] components){
		ArrayList<Unit> units=new ArrayList<Unit>();
		for(int i=0;i<components.length;i++){
			units.add(new Unit(components[i]));
		}
		return units;
	}
}
