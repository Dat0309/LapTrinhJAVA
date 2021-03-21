package QuanLyAnPham;

public class QLAP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DSAnPham DSAP=new DSAnPham();
		try {
			DSAP.NhapBangTay();
		} catch (Exception e) {
		}
		DSAP.Xuat();
	}

}
