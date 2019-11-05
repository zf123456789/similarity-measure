package helper;
import java.util.ArrayList;

public class Unit {
	private String string;
	public Unit(String s){
		this.string=s.toLowerCase();
	}

	public static String combineUnits(ArrayList<Unit> units){
		String result="";
		for(int i=0;i<units.size();i++){
			if(i!=0){
				result+=" ";
			}
			result+=units.get(i);
		}
		return result;
	}
	
	public String toString(){
		return this.string;
	}
}
