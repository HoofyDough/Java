class Trie {
	Trie[] children;

	public Trie() {
		children = new Trie[26];
	}

	public void addWord(String s) {
		Trie node = this;
		char[] letters = s.toCharArray();

		for(int i=0; i<letters.length; i++) {
			int val = Character.getNumericValue(letters[i])-10;
			node.children[val] = new Trie();
			node = node.children[val];
		}
	}

	public boolean doesContainWord(String word) {
		return false;
	}

	public boolean doesContainWords(String[] words) {
		return false;
	}

	public void printTrie() {
		for(int i=0; i<children[])
	}
}