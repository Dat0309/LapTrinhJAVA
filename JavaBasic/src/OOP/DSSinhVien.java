package OOP;

import java.util.LinkedList;
import java.util.Scanner;

public class DSSinhVien {
	Scanner sc=new Scanner(System.in);
	public LinkedList<Studen> DSSV=new LinkedList<Studen>();
	public void Them(Studen x) {
		DSSV.add(x);
	}
	@Override
	public String toString() {
		String str="";
		for(Studen item : DSSV)
			str+=item+"\n";
		return str;
	}
	public void Xuat() {
		System.out.println("Mã sinh viên"+'\t'+"Họ tên"+"\t\t"+"Năm sinh");
		System.out.println(this);
	}
	public void NhapTuBanPhim() {
		boolean count=true;
		String line="";
		do {
			System.out.println("Xin moi nhap thong tin Sinh vien theo dinh dang: MaSV TenSV NS");
			line=sc.nextLine();
			String[] str=line.split(",");
			Them(new Studen(str[0],str[1],str[2]));

		}while(true);
	}

	
}
