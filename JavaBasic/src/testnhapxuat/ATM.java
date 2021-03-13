package testnhapxuat;

import java.util.Scanner;

public class ATM {
	public static void Chiatien(int m) {
		int tam;
		//Tạo các hằng số và gán giá trị tiền tương ứng
				final int FiveHundredThousand=500000;
				final int TwoHundredThousand=200000;
				final int OneHundredThousand=100000;
				final int FiftyThousand=50000;
				
				
				//Tạo các biến lưu trữ số lượng tờ tiền
				int five=0;
				int two=0;
				int one=0;
				int fifty=0;
		five=m/FiveHundredThousand;
		tam=m%FiveHundredThousand;
		two=tam/TwoHundredThousand;
		tam%=TwoHundredThousand;
		one=tam/OneHundredThousand;
		tam%=OneHundredThousand;
		fifty=tam/FiftyThousand;
		
		System.out.println("Số tiền xuất ra: "+ FiveHundredThousand+" : "+five +" Tờ");
		System.out.println("Số tiền xuất ra: "+ TwoHundredThousand+" : "+two+" Tờ");
		System.out.println("Số tiền xuất ra: "+ OneHundredThousand+" : "+one+" Tờ");
		System.out.println("Số tiền xuất ra: "+ FiftyThousand+" : "+fifty+" Tờ");
	}
	public static void main(String[] args) {
		// Bài toán rút tiền ở cây ATM
		
		int money=0;
		Scanner sc=new Scanner(System.in);
		do {
			System.out.println("Xin mời nhập số tiền mà bạn muốn rút: ");
			money=sc.nextInt();
		}while(money % 10000 !=0);
		sc.close();
		
		System.out.println("Số tiền bạn muốn rút là: "+money);
		Chiatien(money);
	}

}
