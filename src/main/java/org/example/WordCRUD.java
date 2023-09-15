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


    public void level() {
        int j =0;
        System.out.println("레벨(1:초급,2:중급,3:고급)선택 : ");
        int level = s.nextInt();
        System.out.println("----------------------------");
        for(int i=0; i<list.size(); i++){
            if(level == list.get(i).getLevel()) {
                System.out.print(j + 1 + " ");
                System.out.println(list.get(i).toString());
                j++;
            }
        }
        System.out.println("----------------------------");
    }
    public void word() {
        int j =0;
        System.out.println("검색할 단어 입력 : ");
        String word = s.next();
        System.out.println("----------------------------");
        for(int i=0; i<list.size(); i++){
            if(list.get(i).getWord().contains(word)) {
                System.out.print(j + 1 + " ");
                System.out.println(list.get(i).toString());
                j++;
            }
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
        //Set<Integer> num1 = listAll(str);
        ArrayList<Integer> num = listAll(str);

        System.out.println("==> 수정할 번호 검색 : ");
        int cho = s.nextInt();
        s.nextLine();
        System.out.println("==> 뜻 입력 : ");
        String mean = s.nextLine();

        list.get((int)num.get(cho-1)).setMeaning(mean);
        System.out.println("\n단어 수정이 성공적으로 완료되었습니다.\n");
        return 0;
    }

    @Override
    public int delete() {
        System.out.println("삭제할 단어 검색 : ");
        String str = s.next();

        ArrayList<Integer> num = listAll(str);

        System.out.println("==> 삭제할 번호 검색 : ");
        int cho = s.nextInt();
        s.nextLine();
        System.out.println("정말 삭제하시겠습니까?(y/n) ");
        String mean = s.nextLine();
        if(mean.equalsIgnoreCase("y")) {
            list.remove((int) num.get(cho-1));
            System.out.println("\n선택한 단어 삭제 완료!!!\n");
        }
        return 0;
    }
    public void loadData(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("test.txt"));
            int j=0;
            while(true) {
                String line = br.readLine();
                if(line == null) break;
                String[] data = line.split("\\|");
                int level = Integer.parseInt(data[0]);
                list.add(new Word(0, level, data[1], data[2]));
                j++;
            }
            System.out.println("=>"+j+"개 단어 로딩 완료!");
            br.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void saveData(){
        try{
            PrintWriter pr = new PrintWriter(new FileWriter(fname));
            for(Word one : list){
                String line = one.toFileString();
                pr.write(line +"\n");
            }
            pr.close();
            System.out.println("모든 단어 파일 저장 완료!!!");
        }catch(IOException e){
            e.printStackTrace();
        }

    }
    @Override
    public void select(Object o) {

    }

}
