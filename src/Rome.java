import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Rome {
    public static void main(String[] args) {
//        각 기호마다 지정된 숫자가 있기 때문에 HashMap을 사용해야겠다 생각했습니다.
        HashMap<String, Integer> romeCodeMap = new HashMap<>();
//        각 기호의 맞게 값을 추가
        romeCodeMap.put("I" , 1);
        romeCodeMap.put("V" , 5);
        romeCodeMap.put("X" , 10);
        romeCodeMap.put("L" , 50);
        romeCodeMap.put("C" , 100);
        romeCodeMap.put("D" , 500);
        romeCodeMap.put("M" , 1000);

//        로마 숫자 문자열 입력
        Scanner sc = new Scanner(System.in);
        System.out.print("로마 숫자를 입력하시오 : ");
        String romeNum = sc.next();

//        문자열의 길이가 15 초과일시
        if(romeNum.length() > 15){
            System.out.println("로마 숫자 문자열의 길이는 1 이상 15 이하 입니다.");
            return;
        }
//        결과값을 받기위한 변수 result 선언
        int result = 0;
        int repeatNumCount = 0;

//        로마 숫자 문자열의 자리마다 값을 지정하기 위해 ArrayList 선언
        ArrayList<String> romeNumArr = new ArrayList<>();

//        로마 숫자 문자열의 길이 만큼 반복문 실행
        for (int i = 0; i < romeNum.length(); i++) {
//            인덱스 값에 맞게 ArrayList의 대입
            romeNumArr.add("" + romeNum.charAt(i));

//            i-1을 쓰기 때문에 0번째가 아닌 1번째부터 조건을 넣기위해 (i != 0) 조건 추가
//            작은 기호가 큰 기호의 왼쪽에 위치하는지 판별하기 위한 조건문 romeCodeMap.get(romeNumArr.get(i)) > romeCodeMap.get(romeNumArr.get(i-1))
            if(i != 0 && romeCodeMap.get(romeNumArr.get(i)) > romeCodeMap.get(romeNumArr.get(i-1))){

//                몇가지 계산을 해봤을시에 큰값 기호의 작은값기호*2 한 값을 넣게 되면 조건에 맞게 계산이 됨
                result += romeCodeMap.get(romeNumArr.get(i)) - romeCodeMap.get(romeNumArr.get(i-1)) * 2;

//               그 외의 상황
            }else{
                result += romeCodeMap.get(romeNumArr.get(i));
            }
        }
        for(String key : romeCodeMap.keySet()){
//            IIX, VX 와 같은 예외 상황 : Map에 key의 값이 있을경우 return  (romeCodeMap.get(key) == result)
//            위에 조건만 넣을경우 단일 문자를 넣을 때(I,V,X ...) return하게 돼서 romeNum.length()>1 조건 추가
//            ArrayList 같은 기호가 4번반복 될시 조건 추가 ( || romeNumArr.lastIndexOf(key) - romeNumArr.indexOf(key) + 1  > 3)
            if(romeCodeMap.get(key) == result && romeNum.length()>1 || romeNumArr.lastIndexOf(key) - romeNumArr.indexOf(key) + 1  > 3){
                System.out.println("잘못된 로마 숫자 표기입니다.");
                return;
            }
        }
//        가장 큰 값 3999를 넘을 시
        if(result > 3999){
            System.out.println("표현할 수 없는 범위의 수입니다.");
        }else{
            System.out.println(result);
        }

    }
}
