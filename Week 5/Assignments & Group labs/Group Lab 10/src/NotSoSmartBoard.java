public class NotSoSmartBoard implements Board{
    private char[][] board;
    private String[] dic;
    private int r;
    private int c;
    
    public void setupNewBoard(String wordListFilename, int rows, int columns){
        In page = new In(wordListFilename);
        this.dic = page.readAll().split("\\s+");
        r = rows;
        c = columns;
        board = new char[r][c];
        for (int i=0;i<r;i++){
            for (int j=0;j<c;j++){
                board[i][j]='_';
            }
        }
    }

    public int getRows(){
        return r;
    } 

    public int getColumns(){
        return c;
    }

    public char getLetterAt(int row, int col){
        return board[row][col];
    }
    
    public String toString() {
        String ans = "";
            for (int i = 0; i < this.r; i++) {
                for (int j = 0; j < this.c; j++) {
                    ans += board[i][j];
                }
                ans += "\n";
            }
        return ans;
    }
    
    public String playWord(Play p, boolean dryRunOnly){
        //this test if the word is in dicionary
        String word = p.getWord();
        String finword = "";
        word = word.toLowerCase();
        for (int i = 0; i<dic.length;i++){
            if (dic[i].equals(word)==false && i == dic.length-1)
                return null;
            if (dic[i].equals(word))
                break;   
        }

        
        if (p.isVertical()==true){
            //this test if the length of word is out of board
            if (p.getRow()+word.length()-1>this.r) return null;
            
            //this test if the intentional place is occupied
            // String finword = "";
            for (int n = 0; n<word.length();n++){
                if (board[p.getRow()+n][p.getCol()]!='_' && board[p.getRow()+n][p.getCol()]!=word.charAt(n))
                    return null;
                else if (board[p.getRow()+n][p.getCol()]=='_')
                    finword += word.charAt(n);
            }


            //this put the word on board
            for (int i = p.getRow(), j=0;i<p.getRow()+word.length() && j<word.length();i++,j++){
                board[i][p.getCol()] = word.charAt(j);
            }

            //this test whether the vertical column that has been changed is still legal or not
            int begin = p.getRow();
            while (begin>0 && board[begin-1][p.getCol()]!='_'){
                begin--;
            }
            int end = p.getRow()+word.length()-1;
            while (end<this.r && board[end+1][p.getCol()]!='_'){
                end++;
            }
            String newword = ""; 
            for (int i = begin; i<end; i++){
                newword += board[i][p.getCol()];
            } 
            for (int i = 0; i<dic.length;i++){
                if (dic[i].equals(newword)==false && i == dic.length-1)
                    return null; 
                if (dic[i].equals(newword)==true)
                    break;
            }

            //this test whether all the horizontal lines starting from the first row of p are legal
            for (int begin2 = p.getRow(); begin2<p.getRow()+word.length(); begin2++){
                int bcol = 0;
                while (true){
                    while (bcol<this.c && board[begin2][bcol]=='_'){
                        bcol++;
                    }
                    int ecol = bcol;
                    while (ecol<this.c && board[begin2][ecol]!='_'){
                    ecol++;
                    }
                    if (bcol==ecol) break;
                    String nword = ""; 
                    for (int i = bcol; i<ecol; i++){
                        nword += board[begin2][i];
                    }  
                    for (int i = 0; i<dic.length;i++){
                        if (dic[i].equals(nword)==false && i == dic.length-1)
                            return null; 
                        if (dic[i].equals(newword)==true)
                            break;
                    }
                    bcol = ecol+1;
                }
            }
            return finword;   
        }
        

        if (p.isVertical()==false){
            //this test if the length of word is out of board
            if (p.getCol()+word.length()-1>this.c) return null;
            
            //this test if the intentional place is occupied
            // String finword = "";
            for (int n = 0; n<word.length();n++){
                if (board[p.getRow()][p.getCol()+n]!='_' && board[p.getRow()][p.getCol()+n]!=word.charAt(n))
                    return null;
                else if (board[p.getRow()][p.getCol()+n]=='_')
                    finword += word.charAt(n);
            }
            
            //this put the word on board
            for (int i = p.getCol(), j=0;i<p.getCol()+word.length() && j<word.length();i++,j++){
                board[p.getRow()][i] = word.charAt(j);
            }
            
            //this test whether the horizontal column that has been changed is still legal or not
            int begin = p.getCol();
            while (begin>0 && board[p.getRow()][begin-1]!='_'){
                begin--;
            }
            int end = p.getCol()+word.length()-1;
            while (end<this.c && board[p.getRow()][end+1]!='_'){
                end++;
            }
            String newword = ""; 
            for (int i = begin; i<end+1; i++){
                newword += board[p.getRow()][i];
            } 
            for (int i = 0; i<dic.length;i++){
                if (dic[i].equals(newword)==false && i == dic.length-1)
                    return null; 
                if (dic[i].equals(newword)==true)
                    break;
            }

            //this test whether all the vertical lines starting from the first column of p are legal
            for (int begin2 = p.getCol(); begin2<p.getCol()+word.length(); begin2++){
                int brow = 0;
                while (true){
                    while (brow<this.r && board[brow][begin2]=='_'){
                        brow++;
                    }
                    int erow = brow;
                    while (erow<this.r && board[erow][begin2]!='_'){
                        erow++;
                    }
                    if (brow==erow) break;
                    String nword = ""; 
                    for (int i = brow; i<erow; i++){
                        nword += board[i][begin2];
                    }  
                    for (int i = 0; i<dic.length;i++){
                        if (dic[i].equals(nword)==false && i == dic.length-1)
                            return null;
                        if (dic[i].equals(newword)==true) 
                            break;
                    }
                    brow = erow+1;
                }
            }
            // return finword;   
        }
        return finword;
    }
    
}