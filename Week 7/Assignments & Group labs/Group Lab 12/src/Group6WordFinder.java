import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Group6WordFinder implements WordFinder{
    private HashMap<String, ArrayList<String>> index_map = new HashMap<>();
    private String[] words_list;

    public void setupIndex(String wordListFilename, int maxWordLength) {
        In x = new In(wordListFilename);
        String[] temp_list = x.readAll().split("\\s+");
        for (int i = 0; i < temp_list.length; i++) {
            if (temp_list[i].equals("aa")) {
                this.words_list = new String[temp_list.length - i];
                for (int j = i; j < temp_list.length; j++) {
                    this.words_list[j-i] = temp_list[j];
                }
            break;
            }
        }

        for (String word : this.words_list) {
            if (word.length() <= maxWordLength) {
                for (int i = 0; i < word.length(); i++) {
                    String key = "" + word.charAt(i) + "_" + i + "_";
                    ArrayList<Character> temp = new ArrayList<>();
                    for (int j = 0; j < word.length(); j++) {
                        if (j == i) continue;
                        else {
                            temp.add(word.charAt(j));
                        }
                    }
                    Collections.sort(temp);
                    for (int j = 0; j < temp.size(); j++) {
                        key += temp.get(j);
                    }
                    if (index_map.containsKey(key))  {
                        index_map.get(key).add(word);
                    }
                    else {
                        index_map.put(key, new ArrayList<String>());
                        index_map.get(key).add(word);
                    }
                }
            }
        }
    }

    public static ArrayList<String> combine(List<String> must_have, List<String> lettersInHand) {
        ArrayList<String> result = new ArrayList<>();
        Collections.sort(lettersInHand);
        String num_two = "";
        for (int i = 0; i < lettersInHand.size(); i++) {
            num_two += "1";
        }

        if (num_two.equals("")) num_two = "0";

        int num_ten = Integer.valueOf(num_two,2);
        for (int i = num_ten; i > 0; i--) {
            String temp_two = Integer.toBinaryString(i);
            while (temp_two.length() < lettersInHand.size()) {
                temp_two = "0" + temp_two;
            }
            
            ArrayList<String> temp_ans = new ArrayList<>();

            for (int j = 0; j < lettersInHand.size(); j++) {
                if (temp_two.charAt(j) == '1') {
                    temp_ans.add(lettersInHand.get(j));
                }
            }

            for (int z = 0; z < must_have.size(); z++) {
                temp_ans.add(must_have.get(z));
            }
            Collections.sort(temp_ans);
            String ans = "";
            for (int p = 0; p < temp_ans.size(); p++) {
                ans += temp_ans.get(p);
            }

            result.add(ans);
        }
        return result;
    }

    public SortedSet<Candidate> findCandidates(Board board, List<String> lettersInHand) {
        SortedSet<Candidate> candidate_set = new TreeSet<>();
        Collections.sort(lettersInHand);
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                if (Character.isLowerCase(board.getLetterAt(i, j))) {
                    // Horizontal
                    ArrayList<String> char_have = new ArrayList<>();
                    for (int temp = j - 1; temp >= 0; temp--) {
                        if (Character.isLowerCase(board.getLetterAt(i, temp))) {
                            char_have.add(String.valueOf(board.getLetterAt(i, temp)));
                        }
                        else break;
                    }
                    for (int temp = j + 1; temp < board.getColumns(); temp++) {
                        if (Character.isLowerCase(board.getLetterAt(i, temp))) {
                            char_have.add(String.valueOf(board.getLetterAt(i, temp)));
                        }
                        else break;
                    }

                    for (int z = j; z >= 0; z--) {
                        for (String half_key : combine(char_have, lettersInHand)) {
                            String full_key = "" + board.getLetterAt(i, j) + "_" + z + "_" + half_key;
                            if (index_map.get(full_key) != null) {
                                for (String word : index_map.get(full_key)) {
                                    Play p = new Play(i, j - z, word, false);
                                    if (board.playWord(p, true) != null) {
                                        Candidate one_candidate = new Candidate(p, board.playWord(p, true));
                                        candidate_set.add(one_candidate);
                                    }
                                }
                            }
                        }
                    }
                    // Vertical
                    char_have = new ArrayList<>();
                    for (int temp = i - 1; temp >= 0; temp--) {
                        if (Character.isLowerCase(board.getLetterAt(temp, j))) {
                            char_have.add(String.valueOf(board.getLetterAt(temp, j)));
                        }
                        else break;
                    }
                    for (int temp = i + 1; temp < board.getRows(); temp++) {
                        if (Character.isLowerCase(board.getLetterAt(temp, j))) {
                            char_have.add(String.valueOf(board.getLetterAt(temp, j)));
                        }
                        else break;
                    }

                    for (int z = i; z >= 0; z--) {
                        for (String half_key : combine(char_have, lettersInHand)) {
                            String full_key = "" + board.getLetterAt(i, j) + "_" + z + "_" + half_key;
                            if (index_map.get(full_key) != null) {
                                for (String word : index_map.get(full_key)) {
                                    Play p = new Play(i - z, j, word, true);
                                    if (board.playWord(p, true) != null) {
                                        Candidate one_candidate = new Candidate(p, board.playWord(p, true));
                                        candidate_set.add(one_candidate);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return candidate_set;
    }



    
}