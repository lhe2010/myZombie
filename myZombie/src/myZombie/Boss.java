package myZombie;

public class Boss extends Zombie {
	
	int shield;

	Boss(int playerPosition, int curHp, int maxHp, int shield) {
		super(playerPosition, curHp, maxHp);
		this.shield = shield;
	}

	public int getShield() {
		return shield;
	}
	public void setShield(int shield) {
		this.shield = shield;
	}

	public void attack (Unit hero) {
		int criticalPossibility = PlayGame.ran.nextInt(4);
		if(criticalPossibility == 0)  { // 2배 공격
			damage = 2*(PlayGame.ran.nextInt(getMaxHp())+1);
			System.out.println("[msg] Boss의 두배공격! ");
		} else
			damage = PlayGame.ran.nextInt(getMaxHp())+1;
		
		hero.setCurHp(hero.getCurHp() - damage);

		if(hero.getCurHp() < 0)
			hero.setCurHp(0);

		System.out.printf("[msg] Boss가 %d의 공격력으로 Hero를 공격함. \n"
				+ "공격한 뒤 Hero의 HP : %d\n", damage, hero.getCurHp());
	}



}
