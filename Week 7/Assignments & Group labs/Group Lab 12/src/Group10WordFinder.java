import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Group10WordFinder implements WordFinder {

    private HashMap<String, List<String > >word_map=new HashMap<>();
    @Override
    public void setupIndex(String wordListFilename, int maxWordLength) {
        // TODO Auto-generated method stub
        In w_l=new In(wordListFilename);
        int sta_ind=0;String[] word_list;
        word_list=w_l.readAllStrings();
        for(int i=0;i<100;i++)if(word_list[i].equals("aa")){sta_ind=i;break;}
        for(int i=sta_ind;i<word_list.length;i++){
            if(word_list[i].length()>maxWordLength)continue;
            for(int j=0;j<word_list[i].length();j++){
                String key=word_list[i].charAt(j)+"_"+j+"_"+this.string_dict_sort(word_list[i], j );
                if(word_map.containsKey(key)){word_map.get(key).add(word_list[i]);}
                else{
                    ArrayList<String> value=new ArrayList<>();
                    value.add(word_list[i]);
                    word_map.put(key, value);
                }
            }
        }
    }
    public String string_dict_sort(String input, int index){
        char[] word=input.toCharArray();
        word[index]='z'+1;
        short[] tmp=new short[26];
        for(int i=0;i<input.length();i++){
            if(word[i]-'z'>0)continue;
            tmp[word[i]-'a']++;
        }
        String ret="";
        for(int i=0;i<26;i++){
            for(int j=0;j<tmp[i];j++){
                ret=ret+(char) (i + 'a');
            }
        }
        return ret;
    }
    public String string_dict_sort(List<String> Lettersinhand){
        short[] word=new short[26];
        for(String i :Lettersinhand)word[i.charAt(0)-'a']++;
        String ret="";
        for(int i=0;i<26;i++){
            for(int j=0;j<word[i];j++){
                ret=ret+(char) (i + 'a');
            }
        }
        return ret;
    }
    public static void concanation(String a,SortedSet<String>all_wo0){
        all_wo0.add(a);
        for(int i=0;i<a.length();i++){
            String c=a.substring(0,i)+a.substring(i+1,a.length());
            if(c.length()>0){all_wo0.add(c);
            concanation(c,all_wo0);}
        }
    }
    public boolean check_char(Board b,int i, int j){
        int row=b.getRows();
        int col=b.getColumns();
        int i0=i-1,i1=i+1;
        int j0=j-1,j1=j+1;
        if(i0>=0)if(b.getLetterAt(i0, j)!=0)return true;
        if(i1<row)if(b.getLetterAt(i1, j)!=0)return true;
        if(j1<col)if(b.getLetterAt(i, j1)!=0)return true;
        if(j0>=0)if(b.getLetterAt(i, j0)!=0)return true;
        return false;
    }

    @Override
    public SortedSet<Candidate> findCandidates(Board board, List<String> lettersInHand) {
        // TODO Auto-generated method stub
        for(String i: lettersInHand)System.out.print(i);
        System.out.println();
        SortedSet <Candidate> candidates=new TreeSet<>();
        int row=board.getRows();
        int col=board.getColumns();
        String hands=string_dict_sort(lettersInHand);
        SortedSet<String> hands_option=new TreeSet<>();
        concanation(hands,hands_option);
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                char tmp_char=board.getLetterAt(i, j );
                //horizontal
                if (tmp_char==0){if(check_char(board, i, j)){
                    for (int k0=0;k0<hands.length();k0++){
                        Play tmmp =new Play(i, j,""+hands.charAt(k0) , true);
                        if(board.playWord(tmmp, true)==null)continue;
                        SortedSet<String> hands_option_tmp = new TreeSet<>();
                        String hans=hands.substring(0, k0)+hands.substring(k0+1,hands.length());
                        concanation(hans,hands_option_tmp);
                        for(int j0=0;j0<j;j0++){
                            for(String key_post:hands_option_tmp){
                                String key=hands.charAt(k0)+"_"+j0+"_"+key_post;
                                if(word_map.containsKey(key)){
                                    for( String word_candidate : word_map.get(key)){
                                        Play p1=new Play(i, j-j0, word_candidate, false);
                                        if(board.playWord(p1, true)!=null){
                                            candidates.add(new Candidate(p1, board.playWord(p1, true)));
                                        }
                                    }
                                }
                            }
                        }
                        for(int i0=0;i0<i;i0++){
                            for(String key_post:hands_option_tmp){
                                String key=hands.charAt(k0)+"_"+i0+"_"+key_post;
                                if(word_map.containsKey(key)){
                                    for( String word_candidate : word_map.get(key)){
                                        Play p1=new Play(i-i0, j, word_candidate, true);
                                        if(board.playWord(p1, true)!=null){
                                            candidates.add(new Candidate(p1, board.playWord(p1, true)));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
                else{
                    for(int j0=0;j0<j;j0++){
                        for(String key_post:hands_option){
                            String key=tmp_char+"_"+j0+"_"+key_post;
                            if(word_map.containsKey(key)){
                                for( String word_candidate : word_map.get(key)){
                                    Play p1=new Play(i, j-j0, word_candidate, false);
                                    if(board.playWord(p1, true)!=null){
                                        candidates.add(new Candidate(p1, board.playWord(p1, true)));
                                    }
                                }
                            }
                        }
                    }
                    for(int i0=0;i0<i;i0++){
                        for(String key_post:hands_option){
                            String key=tmp_char+"_"+i0+"_"+key_post;
                            if(word_map.containsKey(key)){
                                for( String word_candidate : word_map.get(key)){
                                    Play p1=new Play(i-i0, j, word_candidate, true);
                                    if(board.playWord(p1, true)!=null){
                                        candidates.add(new Candidate(p1, board.playWord(p1, true)));
                                    }
                                }
                            }
                        }
                    }
                }
            }
            
        }
        return candidates;
    }
    public static void main(String[] args){
        Group10WordFinder a =new Group10WordFinder();
        System.out.println(a.string_dict_sort("apple",0));
        a.setupIndex("sowpods.txt", 10);
    }
}
