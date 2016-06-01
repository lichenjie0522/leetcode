package medium;

/**
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * Note: You may assume that all inputs are consist of lowercase letters a-z.
 * 
 * @author lichenjie0522
 *
 */

class TrieNode {
	public boolean isWord;
	public TrieNode[] next;
	private final int R = 26;

	public TrieNode() {
		next = new TrieNode[R];
	}
}

public class No208_ImplementTrie {
	private TrieNode root;

	public No208_ImplementTrie() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		if (word == null || word.length() == 0) {
			return;
		}
		TrieNode node = root;
		int depth = 0;
		while (depth < word.length()) {
			char c = word.charAt(depth);
			if (node.next[c - 'a'] == null) {
				node.next[c - 'a'] = new TrieNode();
			}
			node = node.next[c - 'a'];
			depth++;
		}
		node.isWord = true;
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		if (word == null || word.length() == 0) {
			return false;
		}
		TrieNode node = root;
		int depth = 0;
		while (depth < word.length()) {
			char c = word.charAt(depth);
			if (node.next[c - 'a'] == null) {
				return false;
			}
			node = node.next[c - 'a'];
			depth++;
		}
		return node.isWord;
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		if (prefix == null || prefix.length() == 0) {
			return false;
		}
		TrieNode node = root;
		int depth = 0;
		while (depth < prefix.length()) {
			char c = prefix.charAt(depth);
			if (node.next[c - 'a'] == null) {
				return false;
			}
			node = node.next[c - 'a'];
			depth++;
		}
		return true;
	}

}
// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");