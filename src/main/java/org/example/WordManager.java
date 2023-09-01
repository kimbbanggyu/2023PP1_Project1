package org.example;
import java.util.Scanner;
public class WordManager {
    Scanner s = new Scanner(System.in);
    WordCRUD a = new WordCRUD(s);
    public int Menu(){
        System.out.println("*** 영단어 마스터 ***\n");
        System.out.println("*******************");
        System.out.println("1. 모든 단어 보기");
        System.out.println("2. 수준별 단어 보기");
        System.out.println("3. 단어 검색");
        System.out.println("4. 단어 추가");
        System.out.println("5. 단어 수정");
        System.out.println("6. 단어 삭제");
        System.out.println("7. 파일 저장");
        System.out.println("0. 나가기");
        System.out.println("*******************");
        System.out.println("=> 원하는 메뉴는?");
        return s.nextInt();
    }
    public void selectMenu(){
        while(true){
            int select = Menu();
            if(select == 0) break;
            else if(select == 4){
                a.add();
            }
            else if(select == 1){
                a.listAll();
            }
        }
    }


}
