package TpFinal;

public class Par<A, B> {
	private A first;
	private B second;

	public Par(A fst, B snd){
		super();
		this.first=fst;
		this.second=snd;
	}
	
	public A getFirst() {
		return this.first;
	}
	
	public B getSecond() {
		return this.second;
	}
}
