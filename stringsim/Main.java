
// DH: 12.4.2017: Add Soft-TFIDF
// DH: 12.4.2017: Enlarge QgramsDistance (2Grams and padding choice)
// DH: 18.4.2017: Add option "character measure only"

import java.util.ArrayList;

import com.wcohen.ss.Levenstein;

import unit.*;
import group.*;
import helper.Tokenizer;

public class Main {
	static UnitSimMeasure unitFunction;
	static GroupSimMeasure groupFunction;
	public static double quietLevel=1;


	private static String str1="";
	private static String str2="";

	public static void main(String args[]){

		handleParameters(args);

		if(groupFunction==null){
			// character / q-gram level similarity only
			double charsim = unitFunction.getSimilarity(str1,str2);

			if(quietLevel==1){
				System.out.println(unitFunction.name+": "+String.format("%.2f", charsim));
			}else{
				System.out.println(String.format("%.2f", charsim));
			}
		} else {
			ArrayList<String> units1=Tokenizer.split(str1, " ");
			ArrayList<String> units2=Tokenizer.split(str2, " ");

			if(quietLevel==1){
				System.out.println("Tokens A: "+units1);
				System.out.println("Tokens B: "+units2);
				System.out.println();

				Result sim=groupFunction.getSimilarity(units1, units2, unitFunction);
				System.out.println(sim);
			}else{
				Result sim=groupFunction.getSimilarity(units1, units2, unitFunction);
				System.out.println(String.format("%.2f", sim.sim));
			}
		}
	}

	private static void handleParameters(String args[]){
		if(args.length<2){
			System.out.println();

			String info="Usage:"+"\n";
			info+="./stringer.sh \"<str1>\" \"<str2>\""+"\n"+"\n";;
			info+="  Options:"+"\n";
			info+="  -Un\t = Character level function        [ 1..13  , default 5 ]"+"\n";
			info+="  -Gn\t = Token level function            [ 1..10  , optional  ]"+"\n";
			info+="  -Qn\t = Quiet level                     [ 1 / 2  , default 1 ]"+"\n"+"\n";

			info+="  Character level function:"+"\n";
			info+="  1.  "+chooseUnitFunction(1).name+"\n";
			info+="  2.  "+chooseUnitFunction(2).name+"\n";
			info+="  3.  "+chooseUnitFunction(3).name+"\n";
			info+="  4.  "+chooseUnitFunction(4).name+"\n";
			info+="  5.  "+chooseUnitFunction(5).name+"\n";
			info+="  6.  "+chooseUnitFunction(6).name+"\n";
			info+="  7.  "+chooseUnitFunction(7).name+"\n";
			info+="  8.  "+chooseUnitFunction(8).name+"\n";
			info+="  9.  "+chooseUnitFunction(9).name+"\n";
			info+="  10. "+chooseUnitFunction(10).name+"\n";
			info+="  11. "+chooseUnitFunction(11).name+"\n";
			info+="  12. "+chooseUnitFunction(12).name+"\n";
			info+="  13. "+chooseUnitFunction(13).name+"\n\n";

			info+="  Token level function:"+"\n";
			info+="  1.  "+chooseGroupFunction(1).name+"\n";
			info+="  2.  "+chooseGroupFunction(2).name+"\n";
			info+="  3.  "+chooseGroupFunction(3).name+"\n";
			info+="  4.  "+chooseGroupFunction(4).name+"\n";
			info+="  5.  "+chooseGroupFunction(5).name+"\n";
			info+="  6.  "+chooseGroupFunction(6).name+"\n";
			info+="  7.  "+chooseGroupFunction(7).name+"\n";
			info+="  8.  "+chooseGroupFunction(8).name+"\n";
			info+="  9.  "+chooseGroupFunction(9).name+"\n";
			info+="  10. "+chooseGroupFunction(10).name+"\n";

			System.out.println(info);

			System.exit(-1);
		}

		str1=args[0];
		str2=args[1];

		unitFunction=new Levenshtein();
		groupFunction=null;

		for(int i=2;i<args.length;i++){
			handleOption(args[i]);
		}
	}

	private static void handleOption(String string) {
		if(string!=null){
			if(string.indexOf("-U")==0){
				string=string.substring(2);
				if(isNumeric(string)){
					unitFunction=chooseUnitFunction(Integer.parseInt(string));
				}
			}else if(string.indexOf("-G")==0){
				string=string.substring(2);
				if(isNumeric(string)){
					groupFunction=chooseGroupFunction(Integer.parseInt(string));
				}
			}else if(string.indexOf("-Q")==0){
				string=string.substring(2);
				if(isNumeric(string)){
					quietLevel=Integer.parseInt(string);
				}
			}
		}
	}

	private static boolean isNumeric(String s){
		try{  
			double d = Integer.parseInt(s);
		}  
		catch(NumberFormatException nfe){  
			return false;  
		}  
		return true;  
	}

	private static UnitSimMeasure chooseUnitFunction(int index){
		UnitSimMeasure measure=null;
		switch(index){
		case 1:measure=new DamerauLevenshtein(); break;
		case 2:measure=new Hamming(); break;
		case 3:measure=new Jaro(); break;
		case 4:measure=new JaroWinkler(); break;
		case 5:measure=new Levenshtein(); break;
		case 6:measure=new LongestCommonSubstring(); break;
		case 7:measure=new NeedlemanWunch(); break;
		case 8:measure=new QGramsDistance(1); break;
		case 9:measure=new QGramsDistance(3); break;
		case 10:measure=new SmithWaterman(); break;
		case 11:measure=new SmithWatermanGotoh(); break;
		case 12:measure=new Word2Vec(); break;
		case 13:measure=new ExactMatch(); break;
		}
		return measure;
	}

	private static GroupSimMeasure chooseGroupFunction(int index){
		GroupSimMeasure measure=null;
		switch(index){
		case 0:measure=null; break;
		case 1:measure=new BraunBanquet(); break;
		case 2:measure=new Simpson(); break;
		case 3:measure=new Jaccard(); break;
		case 4:measure=new Dice(); break;
		case 5:measure=new Rouge(); break;
		case 6:measure=new Cosine(); break;
		case 7:measure=new Euclidean(); break;
		case 8:measure=new Manhattan(); break;
		case 9:measure=new MongeElkan(); break;
		case 10:measure=new Chaudhuri(); break;
		}
		return measure;
	}
}