package org.example;
import java.util.Scanner;
public class WordManager {
    Scanner s = new Scanner(System.in);
    WordCRUD w = new WordCRUD(s);
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


    public void start() {
       // w.loadData();
        while(true) {
            int menu = Menu();
            if (menu == 0) break;
            else if (menu == 1) {
                w.listAll();
            }
            else if(menu == 2){
                //w.level();
            }
            else if(menu ==3){
                //w.word();
            }
            else if(menu == 4){
                w.add();
            }
            else if(menu == 5){
                w.update();
            }
            else if(menu ==6){
                w.delete();
            }
            else if(menu == 7){
                //w.saveData();
            }
        }
    }
}
