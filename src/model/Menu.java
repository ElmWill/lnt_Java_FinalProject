package model;

public class Menu {
	int menuid;
	String nama;
	String harga;
	int stock;
	
	public Menu(String nama, String harga, int stock) {
		super();
		this.nama = nama;
		this.harga = harga;
		this.stock = stock;
	}

	public int getMenuid() {
		return menuid;
	}

	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getHarga() {
		return harga;
	}

	public void setHarga(String harga) {
		this.harga = harga;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
}
