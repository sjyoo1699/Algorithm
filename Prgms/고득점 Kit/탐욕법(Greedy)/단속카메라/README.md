## Prgms 단속카메라
>https://programmers.co.kr/learn/courses/30/lessons/42884

*********
단순한 문제였는데 성과가 있었다.


primitive type으로 주어진 배열을 정렬할 때 Comparator를 사용하기 위해 자료형을 바꿔서 다시 배열을 만들거나 리스트를 만들곤 했었는데,


java8 이상 버전에서 Comparator 부분에 람다식이 가능하다는 것을 알게 되었다. 아주 간편하게 정렬을 수행할 수 있다.


또한 이 문제에서 카메라들을 리스트에 담을 필요가 없다는 것을 알게 되었다.



굳이 리스트에 담지 않고 가장 최근의 카메라의 위치만 기억하고 그 것과 비교만 하면 된다. << 이러한 발상을 하기 위해서는 문제를 코딩하기 전에 해석하는 시간을 충분히 가져야 하는 것 같다. (특히나 효율성이 중요한 문제라면)
*********

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        
        List<Integer> cameras = new ArrayList<>();
        for (int i = 0; i < routes.length; i++) {
			boolean isPassCamera = false;
			int start = routes[i][0];
			int end = routes[i][1];
			for (Integer integer : cameras) {
				if(end < integer) break;
				if(start <= integer && end >= integer) {
					isPassCamera = true;
					break;
				}
			}
			if(!isPassCamera) cameras.add(end);
		}
        
        return cameras.size();
    }
}
```
