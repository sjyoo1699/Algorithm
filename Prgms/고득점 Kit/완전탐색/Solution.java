
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        brown = (brown - 4) / 2;
        int ver = brown / 2;
        int hor = brown % 2 == 0 ? ver : ver + 1;
        if(brown % 2 == 0) {
        	hor = brown / 2;
        	ver = brown / 2;
        } else {
        	hor = ( brown / 2 ) + 1;
        	ver = brown / 2;
        }
        
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