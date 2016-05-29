/**
 * Created by hitender on 29/5/16.
 */
class Trie_Node{
    Trie_Node[] list;
    boolean isEnd;

    public Trie_Node(){
        this.list=new Trie_Node[26];
    }
}
public class Trie {
    Trie_Node root;

    public Trie(){
        root=new Trie_Node();
    }

    public void Insert(String word){
        Trie_Node p=root;
        for(int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (p.list[index] == null) {
                Trie_Node temp = new Trie_Node();
                p.list[index] = temp;
                p = temp;
            } else {
                p = p.list[index];
            }
        }
        p.isEnd=true;

            }
    public boolean search(String word){
        Trie_Node p= searchNode(word);
        if(p==null)
            return false;
        if(p.isEnd)
            return true;
        return false;

    }

    public boolean search_prefix(String word){
        Trie_Node p=searchNode(word);
        if(p==null)
            return false;
        else
            return true;
    }
    public Trie_Node searchNode(String word){
        Trie_Node temp=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            int index=c-'a';
            if(temp.list[index]!=null){
                temp=temp.list[index];
            }
            else
                return null;
        }
        if(temp==root)
            return null;

        return temp;
    }
    public static void main(String args[]){
        Trie dic=new Trie();

        dic.Insert("hitenderpratap");
        dic.Insert("triedatastructure");
        dic.Insert("datastructure");
        System.out.println(dic.search_prefix("hiten"));
        System.out.println(dic.search("hitenderprata"));
        System.out.println(dic.search_prefix("data"));
    }
}
