// this first implementation uses the classes provided in class

import java.util.ArrayList;

public class WordLadder1 {
    private String[] dic;
    private ArrayList<String> validwords=new ArrayList<String> () ;
    
    public ArrayList<String> setupvalidgragh(String file){
        In d=new In(file);
        this.dic=d.readAllLines();
        for(int i=0;i<dic.length;i++){
            if(dic[i].length()==5){
                validwords.add(dic[i]);
            }
        }
        return validwords;
    }

    public static void main(String[] args) {
        WordLadder1 x = new WordLadder1();
        ArrayList<String> a = x.setupvalidgragh("sowpods.txt");
        Graph agraph = new Graph();
        for(int i = 0; i<a.size();i++ ){
            agraph.addVertex(a.get(i));
        }

        for(int i=0;i<a.size();i++){   
            String ro=a.get(i);    
            for (int m=0;m<a.size();m++){
                int mistake=0;
                for(int j=0;j<5;j++){
                    if (ro.charAt(j)!=a.get(m).charAt(j)) mistake++;
                }   
                if (mistake==1) agraph.addEdge(ro, a.get(m));           
            }   
        }

        String s = args[0];
        String e = args[1];
		PathFinder pf = new PathFinder(agraph, s);
        
        if (s.length()>5){
            System.out.println("Word has to be 5 letters."); 
        }

        System.out.println(pf.pathTo(e));
        for (String v : pf.pathTo(e)) {
            StdOut.println("   " + v);
        }
        StdOut.println("distance " + pf.distanceTo(e));
    }

}