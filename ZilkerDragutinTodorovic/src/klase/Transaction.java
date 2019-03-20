package klase;

public class Transaction {
	private int id;
	private int from_id;
	private int to_id;
	private double amount;
	private int status;
	
	public Transaction(int f, int t, double amount) {
		this.from_id = f;
		this.to_id = t;
		this.amount = amount;
	}
	
	public Transaction(int f, int t, double amount, int status) {
		this.from_id = f;
		this.to_id = t;
		this.amount = amount;
		this.status = status;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFrom_id() {
		return from_id;
	}
	public void setFrom_id(int from_id) {
		this.from_id = from_id;
	}
	public int getTo_id() {
		return to_id;
	}
	public void setTo_id(int to_id) {
		this.to_id = to_id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return id + ", " + from_id + ", " + to_id + ", " + amount + ", " + status;
	}
	
}
