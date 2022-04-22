import java.util.*;

class TrieNode {
	HashMap<Character, TrieNode> children;
	boolean isWord;

	TrieNode() {
		children = new HashMap<Character, TrieNode>();
		isWord = false;
	}
}


public class Trie {

	TrieNode root;

	Trie() {
		root = new TrieNode();
	}


	void insert(String word) {

		TrieNode current = root;

		for (char l : word.toCharArray()) {
			//current = current.children.computeIfAbsent(l, c -> new TrieNode());
			TrieNode node = current.children.get(l);
			if (node == null) {
				node = new TrieNode();
				current.children.put(l , node);
			}
			current = node;
		}
		current.isWord = true;
	}

	boolean search(String word) {

		TrieNode current = root;
		for (char c : word.toCharArray()) {
			current = current.children.get(c);
			if (current == null) {
				return false;
			}
		}
		return current.isWord;
	}

	boolean delete(String word) {
		return delete(root, word, 0);
	}

	boolean delete(TrieNode current , String word , int index) {

		if (word.length() == index) {

			if (current.children.size() == 0) {
				return true;
			}

			if (!current.isWord) {
				return false;
			}
			current.isWord = false;
			return false;
		}

		TrieNode node = current.children.get(word.charAt(index));

		if (node == null) {
			return false;
		}
		boolean shouldDeleteThisNode = delete(node , word , index + 1);

		if (shouldDeleteThisNode) {
			current.children.remove(word.charAt(index));
		}
		return (current.children.size() == 0);
	}



	public static void main(String[] args) {

		Trie trie = new Trie();

		trie.insert("Programming");
		trie.insert("is");
		trie.insert("a");
		trie.insert("way");
		trie.insert("of");
		trie.insert("life");

		String deleteWord = "life";

		System.out.println("Search if word : " + deleteWord + " : is present : " + trie.search(deleteWord));
		trie.delete(deleteWord);
		System.out.println("After deleting ");
		System.out.println("Search if word is present : " + trie.search(deleteWord));
	}
}




