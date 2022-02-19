## Prgms 카펫
> https://programmers.co.kr/learn/courses/30/lessons/42842

*****
카펫의 모서리 네 부분을 뺀 다음 2로 나누어서 yellow의 가로 길이와 세로 길이를 구할 수 있다. 조건에 따르면 가로가 세로보다 같거나 길다고 하였으니 반으로 나눈 값부터 1씩 가로는 + 1을 해주고 세로는 - 1 을 해주면서
탐색하면 값을 찾을 수 있다.
*****

```java
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        brown = (brown - 4) / 2;
        int ver = brown / 2;
        int hor = brown % 2 == 0 ? ver : ver + 1;
        int length = ver;
        for (int i = 0; i < length; i++) {
			if((hor + i) * (ver - i) == yellow) {
				answer[0] = hor + i + 2;
				answer[1] = ver - i + 2;
				break;
			}
		}
        
        return answer;
    }
}
```
