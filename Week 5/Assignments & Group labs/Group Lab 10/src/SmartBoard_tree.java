import java.util.ArrayList;

public class SmartBoard_tree implements Board {
    public char[][] board_array;
    private int rows;
    private int columns;
    private ArrayList<String> must_indict = new ArrayList<String>();
    public Dict_tree word_tree = new Dict_tree();

    public void setupNewBoard(String wordListFilename, int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.board_array = new char[this.getRows()][this.getColumns()];
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                this.board_array[i][j] = '_';
            }
        }
        
        In x = new In(wordListFilename);
        String[] words_list = x.readAll().split("\\s+");
        for(String word : words_list) {
            word_tree.add_node(word);
        }
    }


    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }

    public char getLetterAt(int row, int col) {
        return this.board_array[row][col];
    }

    public boolean check_insert_word_legality(Play p) {
        String word = p.getWord().toLowerCase();
        if (p.isVertical()) {
            if (p.getRow() + word.length() - 1 > this.getRows()) return false;
            for (int i = p.getRow(); i < p.getRow() + word.length(); i++) {
                if (this.board_array[i][p.getCol()] != '_' && this.board_array[i][p.getCol()] != word.charAt(i - p.getRow())) {
                    return false;
                }
            }
            return true;
        }
        else {
            if (p.getCol() + word.length() - 1 > this.getColumns()) return false;
            for (int j = p.getCol(); j < p.getCol() + word.length(); j++) {
                if (this.board_array[p.getRow()][j] != '_' && this.board_array[p.getRow()][j] != word.charAt(j - p.getCol())) {
                    return false;
                }
            }
            return true;
        }
    }

    public ArrayList<String> horizontal_words_list(Play p){
        ArrayList<String> ans = new ArrayList<String>();
        String word = p.getWord().toLowerCase();
        if (p.isVertical()) {
            for (int i = p.getRow(); i < p.getRow() + word.length(); i++) {
                int temp_begin = p.getCol();
                int temp_end = p.getCol();
                while (temp_begin - 1 >= 0 && this.board_array[i][temp_begin - 1] != '_') {
                    temp_begin -= 1;
                }
                while (temp_end + 1 <= this.getColumns() - 1 && this.board_array[i][temp_end + 1] != '_') {
                    temp_end += 1;
                }
                if (temp_begin != temp_end) {
                    String temp = "";
                    for (int q = temp_begin; q < p.getCol(); q++) {
                        temp += this.board_array[i][q];
                    }
                    temp += word.charAt(i - p.getRow());
                    for (int q = p.getCol() + 1; q <= temp_end; q++) {
                        temp += this.board_array[i][q];
                    }
                    ans.add(temp);
                }
            }
        }
        else {
            int temp_begin = p.getCol();
            int temp_end = p.getCol() + word.length() - 1;
            while (temp_begin - 1 >= 0 && this.board_array[p.getRow()][temp_begin - 1] != '_') {
                temp_begin -= 1;
            }
            while (temp_end + 1 <= this.getColumns() - 1 && this.board_array[p.getRow()][temp_end + 1] != '_') {
                temp_end += 1;
            }
            if (temp_begin != temp_end) {
                String temp = "";
                for (int j = temp_begin; j < p.getCol();j++) {
                    temp += this.board_array[p.getRow()][j];
                }
                for (int j = p.getCol(); j < p.getCol() + word.length(); j++) {
                    temp += word.charAt(j - p.getCol());
                }
                for (int j = p.getCol() + word.length(); j <= temp_end;j++) {
                    temp += this.board_array[p.getRow()][j];
                }
                ans.add(temp);
            }
        }
        return ans;
    }

    public ArrayList<String> vertical_words_list(Play p) {
        ArrayList<String> ans = new ArrayList<String>();
        String word = p.getWord().toLowerCase();
        if (p.isVertical()) {
            int temp_begin = p.getRow();
            int temp_end = p.getRow() + word.length() - 1;
            while (temp_begin - 1 >= 0 && this.board_array[temp_begin - 1][p.getCol()] != '_') {
                temp_begin -= 1;
            }
            while (temp_end + 1 <= this.getRows() - 1 && this.board_array[temp_end + 1][p.getCol()] !='_') {
                temp_end += 1;
            }
            if (temp_begin != temp_end) {
                String temp = "";
                for (int i = temp_begin; i < p.getRow(); i++) {
                    temp += this.board_array[i][p.getCol()];
                }
                for (int i = p.getRow(); i < p.getRow() + word.length(); i++) {
                    temp += word.charAt(i - p.getRow());
                }
                for (int i = p.getRow() + word.length(); i <= temp_end; i++) {
                    temp += this.board_array[i][p.getCol()];
                }
                ans.add(temp);
            }
        }
        else {
            for (int j = p.getCol(); j < p.getCol() + word.length(); j++) {
                int temp_begin = p.getRow();
                int temp_end = p.getRow();
                while (temp_begin - 1 >= 0 && this.board_array[temp_begin - 1][j] != '_') {
                    temp_begin -= 1;
                }
                while (temp_end + 1 <= this.getRows() - 1 && this.board_array[temp_end + 1][j] != '_') {
                    temp_end += 1;
                }
                if (temp_begin != temp_end) {
                    String temp = "";
                    for (int i = temp_begin; i < p.getRow(); i++) {
                        temp += this.board_array[i][j];
                    }
                    temp += word.charAt(j - p.getCol());
                    for (int i = p.getRow() + 1; i <= temp_end; i++) {
                        temp += this.board_array[i][j];
                    }
                    ans.add(temp);
                }
            }
        }
        return ans;
    }

    public boolean check_words_list(ArrayList<String> wordslist) {
        if (wordslist.size() > 0) {
            for (int i = 0; i < wordslist.size(); i++) {
                if (this.must_indict.contains(wordslist.get(i))) {
                    return true;
                }
                else {
                    if (this.word_tree.search_word(wordslist.get(i))) {
                        this.must_indict.add(wordslist.get(i));
                        return true;
                    }
                    else return false;
                }
            }
        }
        else return true;

        return false;
    }

    public String show_letters_boardchange(Play p, boolean dryRunOnly) {
        String word = p.getWord().toLowerCase();
        String ans = "";
        if (p.isVertical()) {
            for (int i = p.getRow(); i < p.getRow() + word.length(); i++) {
                if (this.board_array[i][p.getCol()] == '_') {
                    ans += word.charAt(i - p.getRow());
                    if (!dryRunOnly) {
                        this.board_array[i][p.getCol()] = word.charAt(i - p.getRow());
                    }
                }
            }
        }
        else {
            for (int j = p.getCol(); j < p.getCol() + word.length(); j++) {
                if (this.board_array[p.getRow()][j] == '_') {
                    ans += word.charAt(j - p.getCol());
                    if (!dryRunOnly) {
                        this.board_array[p.getRow()][j] = word.charAt(j - p.getCol());
                    }
                }
            }
        }
        return ans;
    }


    public String playWord(Play p, boolean dryRunOnly) {
        if (!check_insert_word_legality(p)) return null;

        if (!check_words_list(horizontal_words_list(p))) return null;

        if (!check_words_list(vertical_words_list(p))) return null;

        return show_letters_boardchange(p, dryRunOnly);
    }

    public String toString() {
        String ans = "";
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                ans += this.board_array[i][j];
            }
            ans += "\n";
        }
        return ans;
    }
}