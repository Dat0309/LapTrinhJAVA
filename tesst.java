package testnhapxuat;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Comparator;
import java.util.Scanner;

public class tesst {
		//tìm bội số của 7 nằm giữa 1 và 100
		public static int TongBoi() 

		{
			int sum=0;
			for(int i=1;i<15;i++)
			{
				int tam=7*i;
				sum+=tam;
			}
		return sum;
		}

		//Cộng n số hạng của dãy số giai thừa
		public static int GiaiThua(int n )
		{
			if(n==1)
				return 1;
			return n*GiaiThua(n-1);
		}
		public static int TongGiaiThua(int n)
		{
			int sum=0;
			for(int i=1;i<=n;i++)
			{
				sum+=GiaiThua(i);
			}
			return sum;
		}
		
		//Nhập vào cuỗi, xuất ra các từ được tách từ chuỗi
		public static void SplitStr()
		{
			String str;
			Scanner scanner=new Scanner(System.in);
			System.out.println("Xin mời nhập chuỗi bất kỳ: ");
			str=scanner.nextLine();
			
			System.out.println("Các từ có trong chuỗi là: ");
			String[] strout= str.split(" ");
				for(int i=0;i<strout.length;i++)
					System.out.println(strout[i]);
			
		}
		
		//Nhập vào mảng sinh viên
		public static void MangSV()
		{
			LinkedList<String> DSSV=new LinkedList<String>();
			String maSV,tenSV,NS,thongTin=null;
			Scanner scanner = new Scanner(System.in);
			do {
				System.out.println("Nhap MSSV: ");
				maSV=scanner.nextLine();
				if(!maSV.isEmpty()) {
					System.out.println("Nhap Ten SV: ");
					tenSV=scanner.nextLine();
					if(!tenSV.isEmpty()) {
						System.out.println("Nhap NS: ");
						NS=scanner.nextLine();
						thongTin=maSV+"\t"+tenSV+"\t"+NS;
						DSSV.add(thongTin);
					}
				}
			}while(!maSV.isEmpty());
			System.out.println("Masv"+"\t"+"Ho ten SV"+"\t"+"Ngay sinh");
			for(String str: DSSV)
				System.out.println(str);
			
		}
		
		
		public static void main(String[] args) {
			Scanner input=new Scanner(System.in);
			boolean cont = true;
			do
			{
				System.out.println("DANH SÁCH CHỨC NĂNG");
				System.out.println("1.Tổng các bội số của 7 nằm giữa 1 và 100");
				System.out.println("2.Cộng n số hạng của dãy sau: 1!+2!+3!+...n!");
				System.out.println("3.Nhập vào một chuỗi, xuất ra các từ được tách từ chuỗi");
				System.out.println("4.Nhập DSSV");
				System.out.println("Chọn chức năng hoặc bấm phím 0 để thoát chương trình: ");
				int chon=input.nextInt();
				switch(chon)
				{
				case 1:
					System.out.println("1.Tổng các bội số của 7 trong khoảng 1 đến 100 là: "+TongBoi() );
					System.out.println();
					break;
				case 2:
					{
						int n=6;
						System.out.println("2.Tổng giai thừa của n số hạng là: "+TongGiaiThua(6));
						System.out.println();
						break;
					}
				case 3:
					SplitStr();
					System.out.println();
					break;
				case 4:
					MangSV();
					System.out.println();
					break;
				default:
					System.out.println("Kết thúc chương trình!");
					cont = false;
					break;
				}
			}while(cont);
}
}
