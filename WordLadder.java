import java.util.*;

class WordLadder {
	List<List<String>> r = new ArrayList<List<String>>();
	String beginWord, endWord;
	List<String> wordList;
	private int strLng;

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		this.beginWord = beginWord;
		this.endWord = endWord;
		this.wordList = wordList;
		strLng = beginWord.length();

		HashMap<String, Boolean> wordIsUsed = new HashMap<>();
		for(String word : wordList) {
			wordIsUsed.put(word, false);
		}

		List<String> series = new ArrayList<>();
		series.add(beginWord);
		findLaddersRecurse(series, wordIsUsed, beginWord);
		return r;
    }

    private void findLaddersRecurse(List<String> series, HashMap<String,Boolean> wordIsUsed, String currentWord) {
    	for(String word : wordList) {
	    	if(!wordIsUsed.get(word)) {
	    		int countBegin = 0;
	    		for(int j=0; j<strLng; j++) {
	    			if(word.charAt(j) == currentWord.charAt(j)) {
	    				countBegin++;
	    			}
	    		}

	    		if(countBegin == strLng-1) {
	    			series.add(word);
	    			wordIsUsed.put(word, true);
	    			// System.out.println(word + " " + wordIsUsed + " " + series);
	    			findLaddersRecurse(series, wordIsUsed, word);
	    			// wordIsUsed.put(word, false);
	    		}
	    	}
    	}

    	if(series.indexOf(endWord) != -1) {
    		r.add(series);
    	}
    }
}