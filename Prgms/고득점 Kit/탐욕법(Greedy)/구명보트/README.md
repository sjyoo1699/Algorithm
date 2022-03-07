## Prgms 구명보트
> https://programmers.co.kr/learn/courses/30/lessons/42885

********
처음에 효율성을 해결하지 못하여 매우 많은 시간을 들인 문제다.


처음 생각한 알고리즘 : 정렬을 한 후 가장 큰 수부터 탐색하며, 이중 반복문으로 내부의 반복문은 0부터 i - 1 까지 탐색하면서 보트에 탈 수 있는 사람들 중 가장 몸무게가 무거운 사람을 태운다.


이 알고리즘으로는 어떤한 방법을 사용해도 계속 시간초과가 발생하였다.



효율성을 해결한 알고리즘 : 단순하게 최대값과 최소값을 더해서 limit보다 작다면 보트에 태우는 방식이다. 위의 알고리즘과 이 알고리즘이 같은 결과를 도출한다는 것이 놀라웠고, "이 것이 그리디의 접근 방법이구나"라는 것을 느꼈다. 



다시 한번 마음에 되새긴다. ```조건이 지나치게 많다면 그 알고리즘은 잘못된 것이다. 그 모든 조건을 꿰뚫는 하나의 알고리즘이 존재할 것이다.```
********

```java
import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        while(left <= right) {
        	answer++;
        	if(left != right && people[right] + people[left] <= limit) {
        		left++;
        	}
        	right--;
        }
        
        return answer;
    }
}
```
