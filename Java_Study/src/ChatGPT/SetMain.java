package ChatGPT;

import java.util.*;

class StudentScoreData1 {
    private String name;
    private int kor;
    private int mat;
    private int eng;

    public StudentScoreData1(String name, int kor, int mat, int eng) {
        this.name = name;
        this.kor = kor;
        this.mat = mat;
        this.eng = eng;
    }

    public void printData() {
        int total = kor + mat + eng;
        double avg = total / 3.0;
        System.out.printf("이름: %s\t국어점수: %d\t수학점수: %d\t영어점수: %d\t총점: %d\t평균점수: %.2f%n",
                name, kor, mat, eng, total, avg);
    }

    public String getName() {
        return name;
    }

    public int getKor() {
        return kor;
    }

    public int getMat() {
        return mat;
    }

    public int getEng() {
        return eng;
    }
}

public class SetMain {
    private Scanner sc = new Scanner(System.in);
    private Set<StudentScoreData1> students = new HashSet<StudentScoreData1>();

    public static void main(String[] args) {
        SetMain program = new SetMain();
        program.run();
    }

    public void run() {
        char choice;
        do {
            displayMenu();
            int menu = sc.nextInt();
            switch (menu) {
                case 1:
                    inputScore();
                    break;
                case 2:
                    modify();
                    break;
                case 3:
                    search();
                    break;
                case 4:
                    printAll();
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
            System.out.println("계속하시겠습니까?(Y/N)");
            choice = sc.next().charAt(0);
        } while (choice == 'Y' || choice == 'y');
        System.out.println("프로그램을 종료합니다. 고생하셨습니다.");
    }

    private void displayMenu() {
        System.out.println("학생 성적 관리 프로그램입니다. 원하는 메뉴를 선택하세요.");
        System.out.println("1. 입력\t2. 수정\t3. 검색\t4. 전체출력");
    }

    private void inputScore() {
        System.out.println("학생의 데이터를 입력하세요. (이름/국어/수학/영어)");
        students.add(new StudentScoreData1(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
    }

    private void printAll() {
        System.out.println("전체 학생 성적을 출력합니다:");
        for (StudentScoreData1 student : students) {
            student.printData();
        }
    }

    private void modify() {
        System.out.println("수정할 학생의 이름을 입력하세요:");
        String name = sc.next();
        boolean found = false;
        for (StudentScoreData1 student : students) {
            if (student.getName().equals(name)) {
                found = true;
                System.out.println("수정할 점수 항목을 선택하세요:");
                System.out.println("1. 이름\t2. 국어\t3. 수학\t4. 영어");
                int option = sc.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("변경할 이름을 입력하세요:");
                        student = new StudentScoreData1(sc.next(), student.getKor(), student.getMat(), student.getEng());
                        break;
                    case 2:
                        System.out.println("변경할 국어 점수를 입력하세요:");
                        student = new StudentScoreData1(student.getName(), sc.nextInt(), student.getMat(), student.getEng());
                        break;
                    case 3:
                        System.out.println("변경할 수학 점수를 입력하세요:");
                        student = new StudentScoreData1(student.getName(), student.getKor(), sc.nextInt(), student.getEng());
                        break;
                    case 4:
                        System.out.println("변경할 영어 점수를 입력하세요:");
                        student = new StudentScoreData1(student.getName(), student.getKor(), student.getMat(), sc.nextInt());
                        break;
                    default:
                        System.out.println("잘못된 입력입니다.");
                        break;
                }
                students.remove(student);
                students.add(student);
                System.out.println("수정이 완료되었습니다.");
                break;
            }
        }
        if (!found) {
            System.out.println("해당 학생의 데이터가 존재하지 않습니다.");
        }
    }

    private void search() {
        System.out.println("어떤 항목으로 검색하시겠습니까?");
        System.out.println("1. 이름\t2. 국어\t3. 수학\t4. 영어");
        int option = sc.nextInt();
        boolean found = false;
        switch (option) {
            case 1:
                System.out.println("검색할 학생의 이름을 입력하세요:");
                String name = sc.next();
                for (StudentScoreData1 student : students) {
                    if (student.getName().equals(name)) {
                        student.printData();
                        found = true;
                        break;
                    }
                }
                break;
            case 2:
                searchBySubject("국어");
                found = true;
                break;
            case 3:
                searchBySubject("수학");
                found = true;
                break;
            case 4:
                searchBySubject("영어");
                found = true;
                break;
            default:
                System.out.println("잘못된 입력입니다.");
                break;
        }
        if (!found) {
            System.out.println("해당 학생의 데이터가 존재하지 않습니다.");
        }
    }

    private void searchBySubject(String subject) {
        System.out.println("어떤 조건으로 검색하시겠습니까?");
        System.out.println("1. 특정 점수\t2. 이상\t3. 이하");
        int option = sc.nextInt();
        System.out.println("점수를 입력하세요:");
        int score = sc.nextInt();
        for (StudentScoreData1 student : students) {
            int studentScore = 0;
            switch (subject) {
                case "국어":
                    studentScore = student.getKor();
                    break;
                case "수학":
                    studentScore = student.getMat();
                    break;
                case "영어":
                    studentScore = student.getEng();
                    break;
            }
            switch (option) {
            
                case 1:
                    if (studentScore == score) {
                        student.printData();
                    }
                    break;
                case 2:
                    if (studentScore >= score) {
                        student.printData();
                    }
                    break;
                case 3:
                    if (studentScore <= score) {
                        student.printData();
                    }
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
                    break;
            }
        }
    }
}