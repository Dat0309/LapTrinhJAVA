package OOP;



public class Studen {
	private String maSV;
	private String hoTen;
	private String ngSinh;
	
	public String getMaSV() {
		return maSV;
	}
	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getNgSinh() {
		return ngSinh;
	}
	public void setNgSinh(String ngSinh) {
		this.ngSinh = ngSinh;
	}
	
	public Studen() {}
	public Studen(String maSV, String hoTen, String ngSinh) {
		super();
		this.maSV = maSV;
		this.hoTen = hoTen;
		this.ngSinh = ngSinh;
	}
	@Override
	public String toString() {
		return maSV+"\t\t"+hoTen+"\t" +ngSinh;
	
	}
//	public void Xuat() {
//		System.out.printf("%-5d %-20s %-15s ",maSV,hoTen,ngSinh);
//	}
}
