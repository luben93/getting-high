package DB;

public class History {
private int historyId;
	private User user;
private Item[] history;
private boolean[] payed;
private int size;


public History(int historyId,User user,Item[] history,boolean[] payed){
	this.setUser(user);
	this.setHistoryId(historyId);
	this.history=history;
	this.payed=payed;
	size=history.length;
}

public double getDebt(){
	double owed=0;
	for(int i=0;i<size;i++){
		if(!payed[i]){
			owed=owed+history[i].getPrice();
		}
	}
return owed;
}

public int getHistoryId() {
	return historyId;
}

private void setHistoryId(int historyid) {
	this.historyId = historyid;
}

public User getUser() {
	return user;
}

private void setUser(User user) {
	this.user = user;
}

}
