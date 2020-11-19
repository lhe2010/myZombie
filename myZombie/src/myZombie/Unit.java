package myZombie;

public abstract class Unit {
	
	private int playerPosition;
	private int curHp;
	private int maxHp;
	
	Unit() {}
	Unit(int playerPosition, int curHp, int maxHp){
		this.playerPosition = playerPosition;
		this.curHp = curHp;
		this.maxHp = maxHp;
	}
	public int getPlayerPosition() {
		return playerPosition;
	}
	public void setPlayerPosition(int playerPosition) {
		this.playerPosition = playerPosition;
	}
	public int getCurHp() {
		return curHp;
	}
	public void setCurHp(int curHp) {
		this.curHp = curHp;
	}
	public int getMaxHp() {
		return maxHp;
	}
	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}
	
	abstract void attack(Unit unit);
}
