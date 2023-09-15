package org.example;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;


public class WordCRUD implements ICRUD{
    ArrayList<Word> list = new ArrayList<>();


    Scanner s;
    WordCRUD(Scanner s){
        this.s =s;
    }
    final String fname = "test.txt";
    public Object create(){
        int level;
        String word;
        String meaning;
        System.out.println("=> 난이도(1,2,3) & 새 단어 입력 : ");
        level = s.nextInt();
        word = s.nextLine();
        System.out.println("뜻 입력 : ");
        meaning = s.nextLine();
        return new Word(0,level,word,meaning);
    }
    @Override
    public int add() {
        Word m = (Word)create();
        list.add(m);
        System.out.println("새 단어가 단어장에 추가되었습니다. ");
        return 0;
    }

    public void listAll() {
        System.out.println("----------------------------");

        for(int i=0; i<list.size(); i++){
            System.out.print(i+1+ " ");
            System.out.println(list.get(i).toString());
        }

        System.out.println("----------------------------");
    }

    public ArrayList<Integer> listAll(String str) {
        ArrayList<Integer> list1 = new ArrayList<>();
        System.out.println("----------------------------");
        int j =0;
        for(int i=0; i<list.size(); i++){
            if(list.get(i).getWord().contains(str)) {
                System.out.print(j + 1 + " ");
                System.out.println(list.get(i).toString());
                list1.add(i);
            }
        }

        System.out.println("----------------------------");
        return list1;
    }
    public int update(){

        System.out.println("수정할 단어 검색: ") ;
        String str = s.nextLine();
        ArrayList<Integer>list1 = listAll(str);
        System.out.println("수정할 번호 선택: ") ;
        int selec = s.nextInt();
        s.nextLine();
        System.out.println("뜻 입력: ");
        String mean = s.nextLine();

        list.get((int)list1.get(selec-1)).setMeaning(mean);
        return 0;
    }

    public int delete(){
        return 0;
    }
    public void select(Object a){}


}
