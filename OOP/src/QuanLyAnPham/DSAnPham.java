package QuanLyAnPham;

import java.util.LinkedList;
import java.util.Scanner;



public class DSAnPham {
	Scanner sc=new Scanner(System.in);
	public LinkedList<AnPham> ds=new LinkedList<AnPham>();
	public void Them(AnPham x) {
		ds.add(x);
	}
	@Override
	public String toString() {
		String str="";
		for(AnPham item : ds)
			str+=item+"\n";
		return str;
	}
	public void Xuat() {
		System.out.println(this);
	}
	public void NhapBangTay() {
		boolean count=true;
		String line="";
		do {
			System.out.println("Xin mời nhập thông tin ấn phẩm theo định dạng: Sach(SACH,Tua de,so trang, NXB),Bao(BAO,so trang,NXB),Tap chi(TAPCHI,Tua de,so trang,NXB,So an pham) ");
			line=sc.nextLine();
			String[] str=line.split(",");
			if (str[0].compareTo("TAPCHI")==0)
				Them(new TapChi(str[1],Integer.parseInt(str[2]),str[3],Integer.parseInt(str[4])));
			else if(str[0].compareTo("BAO")==0)
				Them(new Bao(Integer.parseInt(str[1]),str[2]));
			else 
				Them(new Sach(str[1],Integer.parseInt(str[2]),str[3]));
		}while(true);
		
	}
}
