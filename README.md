# bootAgit_studying

## 1. 해피 아일랜드의 수학자


**1. 문제 분석**

각 자릿수의 제곱의 합을 반복했을 경우 1이면 "1"을 출력 그게 아닐 시 "0"을 출력<br>
행복한 수가 아닌 경우의 조건은 같은 수가 반복되는 사이클이 발생할 시에 행복한 수가 아님<br>
그렇다면 행복한 수가 아닌경우에는 결과값을 가지고 판별하는것이 아닌 이전의 사이클에서 반복되는 수가 있는지 판별을 해야함<br>
  
**2. 설계**

![드로잉1](https://github.com/ImSungCae/bootAgit_studying/assets/134353202/d96da5e7-8b0b-48e3-85e5-c6face4f0fc1)

**3. 구현**

```
import java.util.ArrayList;
import java.util.Scanner;

public class LuckyNum {
    public static void main(String[] args) {

//        정수 n을 입력받기 위해 Scanner 사용
        Scanner sc = new Scanner(System.in);
        System.out.print("양의 정수 n 을 입력하시오 : ");

//      양의 정수 n 을 담을 정수형 변수 n 선언
        int n = sc.nextInt();

//        제대로 입력받았는지 확인
        // System.out.println("입력 받은 값 : " + n + "\n");

//        n의 범위를 판별하기 위한 조건문
        if (n >= 1 && n <= 1000000) {

            //      행복한 수 인지 판별하는 정수형 변수 result 선언 과 초기화
            int result = 0;

            //        입력받은 n을 각 자릿수에 넣기위한 배열 선언
            int[] digit = {};

            //      같은 수가 반복되는 사이클인지 판별하기 위한 ArrayList 선언
            ArrayList<Integer> repeatCheck = new ArrayList<>();

            //        무한루프를 사용하여 반복적으로 계산하고 조건에 부합하지 않을 경우 break;를 통해 빠져나오기
            while (true) {

                //            자릿수의 크기와 각 자릿수의 숫자를 가져오기 위한 문자열 선언
                String luckyStr = Integer.toString(n);

                //            문자열의 길이만큼 배열 크기 선언
                digit = new int[luckyStr.length()];

                for (int i = 0; i < digit.length; i++) {
                    //                i번째 배열의 해당하는 인덱스에 각 자릿수 대입
                    digit[i] = Integer.parseInt("" + luckyStr.charAt(i));
                    // 자릿수 별 배열 확인
                    // System.out.printf("digit[%d] = %d\n",i,digit[i]);
                    //                i번째 배열의 제곱수를 정수형 변수 result에 대입
                    result += (int) Math.pow(digit[i], 2);
                }

                // 각 자릿수 제곱의 합 결과 확인
                // System.out.println("result : " + result + "\n");

                //            result의 값이 1일 경우 "1"을 출력
                if (result == 1) {
                    System.out.println("1");
                    break;

                    //            result의 값이 1이 아니면서 반복되는 사이클일시 "0"을 출력
                } else if (repeatCheck.contains(result)) {
                    System.out.println("0");
                    break;
                }

                //            반복되는 조건을 찾기위해 ArrayList의 현재 result값을 대입
                repeatCheck.add(result);

                //            다음 반복문 계산을 위해 변수 n에다가 result를 대입
                n = result;
                //            result의 각자릿수를 더하기 위해 복합대입 연산자(+=)를 사용했기 때문에 초기화 과정이 필요함
                result = 0;
            }
        }else{
            //            n의 범위를 벗어났을경우
            System.out.println("n의 범위는 1 이상 1,000,000 이하입니다.");

        }

    }
}


```

**4. 테스트 및 개선**

1. 테스트 결과

![스크린샷 2024-07-10 161329](https://github.com/ImSungCae/bootAgit_studying/assets/134353202/1236e5dc-3adf-4aa9-9de9-7347291cd187)

2. 개선점
   
   코딩테스트 같은 문제를 오랜만에 접하다 보니 기억이 잘안나는 문법 (ArrayList) 같은 부분은 블로그를 참고하였습니다.<br>
   아직 기본기가 부족하다는 점에 기본기에 충실해야겠다 생각이 들었습니다.


## 2. 로마 제국의 코드 해독


**1. 문제 분석**

각 기호별로 숫자가 대입 되어있기때문에 HashMap을 사용해서 Key, Value값으로 기호에 맞는 숫자를 가져오면 좋겠다 생각했습니다.<br>
먼저 HashMap에 기호에 맞는 숫자를 put(key, value)으로 넣고 문자열을 자릿수별로 쪼개어 자릿수에 맞는 HashMap을 get(key)으로 <br>
결과값 변수에 값을 더해주면 되겠다 생각했습니다. 그러기 위해선 먼저 자릿수 길이 만큼 확장을 시켜줄 ArrayList를 사용했고,<br>
자릿수 별로 ArryayList에 넣은 **문자열** 을 HsahMap의 키로 찾아 Value의 값을 결과값에 복합대입연산자(+=) 로 연산하였습니다.<br>
이후 추가 조건에 맞게 작성해야겠다 생각했습니다.


**2. 설계**


**3. 구현**


```
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
            if(romeCodeMap.get(key) == result && romeNum.length()>1){
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

```


**4. 테스트 및 개선**

추가 조건에 대해 어려움이 있었습니다. 추가 조건에 대한 판별은 어떤식으로 생각하였나면<br>
첫번째 조건으로 문자열의 길이가 15 초과일시에 대한 조건문을 넣고<br>
두번째론 작은 기호가 큰 기호의 왼쪽에 위치한지는 반복문안에 조건문으로 ArrayList의 **i** 번째 값의 해당하는 <br>
HashMap의 Value값의 크기가 **i-1** 부터 큰지 조건을 넣었고 **i-1**을 사용하기때문에  <br>
i가 0번째가 아닌 1번째부터 조건을 판별하기 위해 **&&** 연산자를 추가로 조건을 넣었습니다. <br>
세번째로는 IIX와 VX같은 예외상황은 계산했을시에 각각 10 , 5 인데 이럴시 기호의 값과 동일하기 때문에 조건문을 넣었습니다.<br>
그러고보니 한자릿수의 (I,V,X ...) 기호를 넣는 상황과 4와 9관련된(IIII,VIIII) 수에 대한 예외 조건이 없었습니다.
ArrayList의 추가된 값이 4번 반복될시 (4 와 9 관련된 예외) 에 대한 조건을 추가하였습니다.












  
