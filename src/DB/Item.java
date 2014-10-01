package DB;


public class Item {
private String name;
private String desc;
private double price;
private int saldo;
private category cat;
	
	public Item(String name,String desc,double price,int saldo, category cat){
		this.setName(name);
		this.setDesc(desc);
		this.setPrice(price);
		this.setSaldo(saldo);
		this.setCat(cat);
	}
	public String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	private void setDesc(String desc) {
		this.desc = desc;
	}
	public double getPrice() {
		return price;
	}
	private void setPrice(double price) {
		this.price = price;
	}
	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {//TODO maybe muteble
		this.saldo = saldo;
	}
	public category getCat() {
		return cat;
	}
	private void setCat(category cat) {
		this.cat = cat;
	}
}
