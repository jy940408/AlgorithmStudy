package 코딩테스트;

public class 문자열압축 {

	public static int solution(String s) {
		
		int answer = 0;
		
		int s_length = s.length();
		answer = s_length;
		
//---------------------------------------------------------------------------------------------------------------------------------------//
		
		String result = "";
		
		for(int i = 0 ; i < s_length ; i++) {
			if(i > 0 && (s.substring(i, i+1)).equals(s.substring(i-1, i))) {
				System.out.println("if문 안쪽: " + s.substring(i, i+1));
			}else {
				System.out.println("else쪽: " + s.substring(i, i+1));
			}
		}
		
//---------------------------------------------------------------------------------------------------------------------------------------//

		return answer;
		
	}
	
	public static void main(String[] args) {
		
		int a = solution("tttesssst");
		
		System.out.println(a);
	
	}
}
