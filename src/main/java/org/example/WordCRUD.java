package org.example;
import java.util.Scanner;
import java.util.ArrayList;
public class WordCRUD implements ICRUD{
    Scanner s;
    ArrayList<Word> list = new ArrayList<Word>();

    public WordCRUD(Scanner s){
        this.s = s;
    }

    public Word addword(){
        int id;
        String word;
        String meaning;

        System.out.println("=> 난이도(1,2,3) & 새 단어 입력 : ");
        id = s.nextInt();
        word = s.nextLine();
        System.out.println("뜻 입력 : ");
        meaning = s.nextLine();

        return new Word(0,id,word,meaning);
    }
    @Override
    public int add() {
        Word w = addword();

        list.add(w);

        return 0;
    }

    public void listAll(){
        System.out.println("---------------------------------");
        for(int i=0; i<list.size(); i++){
            System.out.println(i+1 + " "+ list.get(i).toString());
        }
        System.out.println("---------------------------------\n");
    }

    @Override
    public int update() {
        return 0;
    }

    @Override
    public int delete() {
        return 0;
    }

    @Override
    public void select() {

    }
}
