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








## 3. 외계어 사전 만들기













  
