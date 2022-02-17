## Prgms 위장
| 타입 | 이름 | 범위 |
| --- | --- | --- |
| String[][] | clothes | 1 ~ 30 |
| String | clothes의 원소 | 1 ~ 20 |

************************

스파이가 입을 수 있는 옷의 종류와 이름이 2차원 배열로 주어진다.



스파이는 최소 하나의 옷을 입어야한다. 같은 종류의 옷은 입을 수 없다. 스파이가 입을 수 있는 의상의 종류의 수?


***********************

같은 종류의 의상의 수를 센 후, 그 수에 1을 더한 값들``` 어떠한 종류의 의상을 입을 수도 있고 안 입을 수도 있기 때문 ```을 모두 곱해주고 그 결과에서 1을 뺐다. ``` 스파이는 최소 하나의 옷을 입어야 하기 때문에 아무 옷도 입지 않는 경우 하나를 빼줌 ```


```java
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
        	if(map.containsKey(clothes[i][1])) map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
        	else map.put(clothes[i][1], 1);
		}
        
        for (Integer val : map.values()) {
			answer *= val + 1;
		}
        answer--;
        return answer;
    }
}
```
