
public class SpellChecker {


	public static void main(String[] args) {
		String word = args[0];
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
	}

	public static String tail(String str) {
		return (str.substring(1));
	}

	public static int levenshtein(String word1, String word2) {
	word1=word1.toLowerCase();
	word2=word2.toLowerCase();
	int lengthWord1=word1.length();
	int lengthWord2=word2.length();
	//the base cases
	
	if(lengthWord2==0){
		return lengthWord1;
	}else if(lengthWord1==0){ 
		return lengthWord2;
	}
	
	 
	 if(word1.charAt(0)==word2.charAt(0)){
		 return levenshtein(tail(word1), tail(word2));
	}else{
		int first=  levenshtein(tail(word1), word2);
		int second= levenshtein(word1, tail(word2));
		int third= levenshtein(tail(word1), tail(word2));
		int try1= Math.min(first, second);
		int try2= Math.min(try1, third);
		return (try2 + 1);
	
}


    
	
		 
}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);

		for(int i=0; i<dictionary.length; i++){ 
			dictionary[i]=in.readString();
		}

		return dictionary;
	}

	public static String spellChecker(String word, int threshold, String[] dictionary) {
		int N= dictionary.length;
		String selectedWord=word;
		for(int i=0; i<N;i++){
			int lev=levenshtein(word, dictionary[i]);
			if(threshold>=lev){
				threshold=lev;
				selectedWord=dictionary[i];
			}
		
	}
	return selectedWord;
	}

}
