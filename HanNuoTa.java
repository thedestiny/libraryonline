
public class HanNuoTa {

	public static void main(String[] args) {
		String A = "A";
		String B = "B";
		String C = "C";
		
		hannuo(6,A,B,C);
	}
	public static int i = 1;
	public static void hannuo(int n,String A,String B, String C){
	
		if(n == 1 ){
			move(n,A,C);
		} else{
			hannuo(n-1,A,C,B);
			move(n,A,C);
			hannuo(n-1,B,A,C);	
		}
		
	}
	private static void move(int n, String a, String c) {
		System.out.println("第" + i++ + "步： 将第 " + n + "盘子" + a + "--" +  c );
		
	}
	
	

}
