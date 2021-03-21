package QuanLyAnPham;

public abstract class AnPham {
	int soTrang;
	String nxb;
	public int getSoTrang() {
		return soTrang;
	}
	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}
	public String getNxb() {
		return nxb;
	}
	public void setNxb(String nxb) {
		this.nxb = nxb;
	}
}
class Sach extends AnPham{
	private String tuaDe;

	public String getTuaDe() {
		return tuaDe;
	}

	public void setTuaDe(String tuaDe) {
		this.tuaDe = tuaDe;
	}
	public Sach() {}
	public Sach(String td,int st,String n) {
		this.soTrang=st;
		this.nxb=n;
		this.tuaDe=td;
	}
	@Override
	public String toString() {
		return "Sách: "+"\t"+", Tựa đề: "+tuaDe+", Số Trang: "+soTrang+", Nhà xuất bản: "+nxb;
	}

}
class Bao extends AnPham{
	public Bao() {	
	}
	public Bao(int st,String n) {
		this.soTrang=st;
		this.nxb=n;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Báo: "+"\t"+", Số Trang: "+soTrang+", Nhà xuất bản: "+nxb;
	}
}
class TapChi extends AnPham{
	private String tuaDe;
	private int soBaiViet;
	public String getTuaDe() {
		return tuaDe;
	}
	public void setTuaDe(String tuaDe) {
		this.tuaDe = tuaDe;
	}
	public int getSoBaiViet() {
		return soBaiViet;
	}
	public void setSoBaiViet(int soBaiViet) {
		this.soBaiViet = soBaiViet;
	}
	public TapChi() {}
	public TapChi(String td,int st,String n,int sbv) {
		this.soTrang=st;
		this.nxb=n;
		this.tuaDe=td;
		this.soBaiViet=sbv;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Tạp Chí: "+" Tựa đề: "+ tuaDe+", Số Trang: "+soTrang+", Nhà xuất bản: "+nxb+", Số Bài Viết: "+soBaiViet;
	}
}


