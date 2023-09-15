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


    public ArrayList<Integer> listAll(String word) {
        int j = 0;
        ArrayList<Integer> num = new ArrayList<>();
        System.out.println("----------------------------");


        for(int i=0; i<list.size(); i++){
            if(list.get(i).getWord().contains(word)) {
                System.out.print(j + 1 + " ");
                System.out.println(list.get(i).toString());
                num.add(i);
                j++;
            }
        }
        System.out.println("----------------------------");
        return num;
    }

    @Override
    public int update() {
        System.out.println("수정할 단어 검색 : ");
        String str = s.next();
        ArrayList<Integer> num = listAll(str);

        System.out.println("==> 수정할 번호 검색 : ");
        int cho = s.nextInt();
        s.nextLine();
        System.out.println("==> 뜻 입력 : ");
        String mean = s.nextLine();

        list.get((int)num.get(cho-1)).setMeaning(mean);
        System.out.println("단어 수정이 성공적으로 완료되었습니다!!");
        return 0;
    }

    @Override
    public int delete() {
        System.out.println("삭제할 단어 검색 : ");
        String str = s.next();
        ArrayList<Integer> list2 = listAll(str);
        System.out.println("삭제할 번호 선택: ");
        int selec = s.nextInt();
        s.nextLine();
        System.out.println("정말로 삭제하시겠습니까?(Y/N) ");
        String check = s.nextLine();

        if(check.equalsIgnoreCase("y")) {
            list.remove((int) list2.get(selec-1));
        }

        return 0;
    }
    public void loadData(){
        try (BufferedReader br = new BufferedReader(new FileReader(fname))) {
            while(true){
                String str = br.readLine();
                if(str == null) break;
                String[] data = str.split("\\|");
                int level = Integer.parseInt(data[0]);
                String word = data[1];
                String mean = data[2];
                list.add(new Word(0,level,word,mean));
            }
            br.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void select(Object o) {

    }

}
