package DB;


public class Item {
private String name;
private String desc;
private double price;
private int saldo;
private String cat;
private int itemId;
	
	public Item(int itemId,String name,String desc,double price,int saldo, String cat){
		this.setItemId(itemId);
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
	public String getCat() {
		return cat;
	}
	private void setCat(String cat) {
		this.cat = cat;
	}
	
	public String toString(){
		String out="Item:\n";
				out=out+itemId+"\n";
				out=out+name+"\n";
				out=out+desc+"\n";
				out=out+price+"\n";
				out=out+saldo+"\n";
				out=out+cat+"\n";
				out=out+this.hashCode();
		return out;
		
	}

	public int getItemId() {
		return itemId;
	}

	private void setItemId(int itemId) {
		this.itemId = itemId;
	}
}
