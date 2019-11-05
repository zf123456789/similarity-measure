
// DH: 12.4.2017: Generalization of hmap1 and hmap2 type.

package group;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

import org.apache.log4j.chainsaw.Main;

public class Result {
	public String name;
	public String unit;
	public String cardinality;
	public double sim;
	public ArrayList<String> intersection;
	public double precision=-1;
	public double recall=-1;
	public double alpha=-1;
	public double A=-1;
	public double B=-1;
	public double U=-1;
	public double I=-1;
	public double sA=-1;
	public double sB=-1;
	public double sU=-1;
	public double sI=-1;
	public String selfA;
	public String selfB;
	public String union;
	public String intersectionTable;
	public String m_e;
	public double m_e_sum=-1;
	public HashMap hmap1;
	public HashMap hmap2;
	public double matrix[][];
	
	public String toString(){
		String result="";
		
		if(intersection!=null){
			result+='\n';
			result+="INTERSECTION: "+intersection+" "+"("+intersection.size()+")";
		}
		if(m_e!=null){
			result+='\n';
			result+=m_e;
			result+='\n';
		}
		if(m_e_sum!=-1){
			result+="SUM: "+String.format("%.2f", m_e_sum);
			result+='\n';
		}
		if(selfA!=null){
			result+='\n';
			result+=selfA;
			result+='\n';
		}
		if(selfB!=null){
			result+='\n';
			result+=selfB;
			result+='\n';
		}
		if(union!=null){
			result+='\n';
			result+=union;
			result+='\n';
		}
		if(intersectionTable!=null){
			result+='\n';
			result+=intersectionTable;
			result+='\n';
		}
		if(sI!=-1){
			result+=" UNION        : "+String.format("%.2f", sU)+"\n "+"INTERSECTION : "+String.format("%.2f", sI);
			result+='\n';
		}
		if(precision!=-1){
			result+="\n\n";
			result+="PRECISION: "+String.format("%.2f", precision);
		}
		if(recall!=-1){
			result+='\n';
			result+="RECALL: "+String.format("%.2f", recall);
		}
		if(alpha!=-1){
			result+='\n';
			result+="ALPHA: "+String.format("%.2f", alpha);
		}
		if(hmap1!=null){
			result+='\n';
			result+="V1: "+hmap1;
		}
		if(hmap2!=null){
			result+='\n';
			result+="V2: "+hmap2;
			result+='\n';
		}
		if(matrix!=null){
			result+='\n';
			for(int i=0;i<matrix.length;i++){
				for(int j=0;j<matrix[i].length;j++){
					result+=String.format("%.2f", matrix[i][j])+"  ";
				}
				result+='\n';
			}
		}

		result+='\n';
		result+='\n';
		result+=name+" + "+unit+" : "+String.format("%.2f", sim);//+" ["+cardinality+"]\n";
		
		return result;
	}
}
