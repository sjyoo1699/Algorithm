## Prgms 가장 큰 수
> https://programmers.co.kr/learn/courses/30/lessons/42746

************
int[] 배열을 정렬해야하는 문제였다. 주어진 정보대로 정렬을 해야했기에 Comparator를 구현하기 위해 Integer 클래스로 배열을 바꿔서 담아주었다. ```Integer 배열로 옮긴 후 Comparator를 구현하는
것보다 int 배열 자체로 직접 정렬을 구현(Quick Sort)하여 사용하는 것이 더 빨랐을 수도 있겠다는 생각이 들었다.``` 



비교 부분의 알고리즘은 처음에는 가장 앞에 있는 숫자부터 비교하였다. (무조건 큰 수가 앞에 나오면 되기 때문) 하지만 테스트케이스에 궁금증이 생겨 질문하기를 보던 중 



A + B 와 B + A를 비교하면 된다는 말을 보고 그렇게 구현하였다. (숫자 그대로 더하는 것이 아니라 String의 형태로 더한 후 int의 값으로 비교)



이렇게 비교하는 것은 단순하게 생각해서 ```둘 중 어느 원소가 앞에 오는 게 더 크냐 ``` 였다.



마지막으로 결과값이 0000000 일 경우 0 으로 출력해줘야해서 그 것의 처리를 해준 후 끝난다.



``` A + B 와 B + A 를 비교하는 것을 보고 단순하게 생각하는 게 진짜 중요하다는 것을 다시 한번 깨달았다. 최대한 단순하게 ```
************

```java
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        Integer[] result = new Integer[numbers.length];
        for (int i = 0; i < result.length; i++) {
			result[i] = numbers[i];
		}
        Arrays.sort(result, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				String o1S = o1.toString();
				String o2S = o2.toString();
				return Integer.parseInt(o2S + o1S) - Integer.parseInt(o1S + o2S);
			}
		});
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
			sb.append(result[i]);
		}
        String answer = sb.toString();
        String findZero = answer.replaceAll("0", "");
        if(findZero.equals("")) answer = "0";
        return answer;
    }
}
```
