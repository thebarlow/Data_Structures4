import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class SpellChecker {
	private static HashSet<String> dictMap;
	private static ArrayList<myDict> myarr= new ArrayList<myDict>();
	
	public static void main(String[] args) throws IOException{
		dictMap=new HashSet<String>();
		
		//FIRST PARAMETER IS DICTIONARY
		FileReader dict=new FileReader(args[0]);
		Scanner ab = new Scanner(dict);
	    while(ab.hasNextLine()){
	    	String thisLine=ab.nextLine();
	    	String[] sentence = thisLine.replaceAll("[^a-zA-Z0-9'\n]","").toLowerCase().split(" ");//remove all spaces and punctuation
	    	for(int i=0;i<sentence.length;i++){
	    		dictMap.add(sentence[i]); //ADD EVERY WORD IN DICTIONARY TO HASHSET
	    	}
	    }
	    
		//words to check
		FileReader reader = new FileReader(args[1]);
		Scanner sc=new Scanner(reader);
	    int count1=0;
	    while(sc.hasNextLine()){
	    	count1++;
	    	String thisLine = sc.nextLine();
	    	String[] sentence=thisLine.replaceAll("[^a-zA-Z0-9' ]","").toLowerCase().split(" ");
	    	for(int i=0;i<sentence.length;i++){
	    		 if(!dictMap.contains(sentence[i])&& !sentence[i].isEmpty() &&sentence[i]!=null){//IF THE WORD IS MISSPELLED
	    			 updateStuff(sentence[i],count1);
	    		 }
	    	}
	    }
	    printMisspellings();
	    sc.close();
	    ab.close();
	    
	}
	//ADDS MISPELLED WORDS TO AN ARRAY
	//IF A WORD IS MISPELLED MORE THAN ONCE, IT MAKES A LIST OF LINES IT WAS MISSPELLED ON
	public static void updateStuff(String str, int num){
		myDict tempDict = new myDict(str,num);
		if(myarr.isEmpty()){
			myarr.add(tempDict);
			return;
		}
		for(int i=0;i<myarr.size();i++){
			if(myarr.get(i).getWord().equals(str)){
				myarr.get(i).addnum(num);;
				return;
			}
		}
		myarr.add(tempDict);
		return;
	}
	//PRINTS MISPELLINGS AND SUGGESTIONS FOR THEM
	public static void printMisspellings(){
		for(int i=0;i<myarr.size();i++){	
			if(!dictMap.contains(myarr.get(i).getWord())){
				System.out.println("You typed the word: "+myarr.get(i).getWord());
				System.out.println("On lines: "+myarr.get(i).getLines());
				suggestWord(myarr.get(i).getWord());
			}
		}
	}
	//SUGGESTS WORDS BASED ON THE THREE CHANGES IN 5.21
	//ONLY DOES ONE OF THE THREE AT A TIME. IF A WORD NEEDS TWO CHANGES IT WILL NOT BE HANDLED
	public static ArrayList<String> suggestWord(String str){
		//handles trivial case
		ArrayList<String> mySugg = new ArrayList<String>();
		if(str.equals("") || str==null){return null;}
		//ADDS A CHAR
		String newstr;
		char[] alphabet ="abcdefghijklmnopqrstuvwxyz'".toCharArray();
		for(int i=0;i<str.length()+1;i++){
			for(int j=0;j<alphabet.length;j++){
				newstr=str.substring(0,i)+alphabet[j]+str.substring(i);
				if (dictMap.contains(newstr)&&!mySugg.contains(newstr)){
					mySugg.add(newstr);
				}
			}
		}
		
		//REMOVES A CHAR
		String newstr2;
		for(int i=0;i<str.length();i++){
			newstr2=str.substring(0,i)+str.substring(i+1);
			if(dictMap.contains(newstr2) &&!mySugg.contains(newstr2)){
				mySugg.add(newstr2);
			}
		}
		//EXCHANGE ADJACENT CHARS
		String newstr3;
		for(int i=0;i<str.length()-1;i++){
			newstr3=str.substring(0,i)+str.substring(i+1,i+2)+str.substring(i,i+1)+str.substring(i+2);
			if(dictMap.contains(newstr3)&&!mySugg.contains(newstr3)){
				mySugg.add(newstr3);
			}		
		}
		//RETURN
		if(mySugg.size()!=0){
			System.out.print("Did you mean: ");
			for(int i=0;i<mySugg.size();i++){
				System.out.print(mySugg.get(i));
				if(i<mySugg.size()-1){
					System.out.print(", ");
				}
			}
			System.out.println("\n ");
		}
		else{
			System.out.println("Sorry, I couldn't find any suggestions! \n");
		}
		return mySugg;
	}
}
//CUSTOM CLASS WHICH HOLDS A MISSPELLED WORD AND ALL THE LINES IT APPEARS ON
class myDict implements Comparable<Object>{
	 String word;
	 ArrayList<Integer> arr = new ArrayList<Integer>();
	 public myDict(String str, int line){
		 word=str;
		 arr.add(line);
	 }
	 public ArrayList<Integer> getLines(){
		 return arr;
	 }
	 public String getWord(){
		 return word;
	 }
	 public void addnum(int num){
		 if(!arr.contains(num)){
			 arr.add(num);
		 }
	 }
	 public String toString(){
		 return word + " "+ arr;
	 }
	@Override
	public int compareTo(Object o) {
		if(this.getWord().compareTo(((myDict) o).getWord())>0){
			return 1;
		}
		else if(this.getWord().compareTo(((myDict)o).getWord())<0){
			return -1;
		}
		return 0;
	}
}
