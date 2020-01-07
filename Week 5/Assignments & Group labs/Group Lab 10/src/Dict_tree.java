public class Dict_tree {
    public Dict_tree_node root_node;

    public Dict_tree() {
        this.root_node = new Dict_tree_node(' ');
    }

    public void add_node(String word) {
        Dict_tree_node current_node = this.root_node;
        for (int i = 0; i < word.length(); i++) {
            if (current_node.children.size() > 0) {
                for (int j = current_node.children.size() - 1; j >= 0;) {
                    if (current_node.children.get(j).data == word.charAt(i)) {
                        current_node = current_node.children.get(j);
                        break;
                    }
                    if (j == 0) {
                        current_node = current_node.add_node(word.charAt(i));
                    }
                    j--;
                }
            }
            else {
                current_node = current_node.add_node(word.charAt(i));
            }
            
        }
        current_node.add_node(' ');
    }

    public boolean search_word(String word) {
        Dict_tree_node current_node = this.root_node;
        for (int i = 0; i < word.length(); i++) {
            if (current_node.children.size() > 0) {
                for (int j = 0; j < current_node.children.size();) {
                    if (current_node.children.get(j).data == word.charAt(i)) {
                        current_node = current_node.children.get(j);
                        break;
                    }
                    if (j == current_node.children.size() - 1) {
                        return false;
                    }
                    j++;
                }
            }
            else return false;
            
        }

        for (int j = 0; j < current_node.children.size(); j++) {
            if (current_node.children.get(j).data == ' ') {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Stopwatch s = new Stopwatch();

        Dict_tree a = new Dict_tree();
        In x = new In("sowpods.txt");
        String[] words_list = x.readAll().split("\\s+");
        for (String word : words_list) {
            a.add_node(word);
        }

        double boardTime = s.elapsedTime();
        System.out.println("Time to create dict: " + (int) (boardTime * 1000) + " ms");


        System.out.println(a.search_word("duke"));
        System.out.println(a.search_word("computer"));
        System.out.println(a.search_word("science"));
        System.out.println(a.search_word("lab"));
        System.out.println(a.search_word("labanotatio"));
        
        double totalTime = s.elapsedTime();
        System.out.println("Time to search four words: " +  (totalTime - boardTime)*1000  + " ms");
    }
}