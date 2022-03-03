## Prgms 큰 수 만들기
> https://programmers.co.kr/learn/courses/30/lessons/42883#

********
이 문제를 그리디 방식이 아닌 방식 (ex. 완전탐색) 으로 풀었다면 시간초과가 걸렸을 것이다. 



제일 처음 숫자부터 확인해서 오른쪽으로 k 안에 이 숫자보다 큰 숫자가 나온다면 그 숫자는 Stringbuilder에 넣지 않고 k만 감소시킨다.




그리디는 처음 설계가 가장 중요하다. 처음 설계가 삐끗하면 그 것을 수정하는 데 고생한다. 모든 알고리즘이 그렇지만 특히 그리디는 더 심하다.



이 문제를 그리디로 풀어야 겠다고 확인하는 법 -> 부분 해가 모여서 전체 해가 될 수 있는가, 현재의 선택이 나중의 선택에 영향을 끼치지 않는가, 쉬운 방법(ex. 완전탐색 등)으로는 무조건 시간초과가 날 것 같다 싶을 때 
********

```java
class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        char[] arr = number.toCharArray();
        for (int i = 0; i < arr.length; i++) {
        	boolean check = false;
        	for (int j = i + 1; j <= i + k && j < arr.length; j++) {
				if(arr[j] > arr[i]) {
					check = true;
					k--;
					break;
				}
			}
        	
        	if(!check) sb.append(arr[i]);
		}
        if(k > 0) sb.delete(sb.length() - k, sb.length());
        return sb.toString();
    }
}
```
