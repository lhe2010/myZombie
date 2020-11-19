package myZombie;

public class Zombie extends Unit {
	
	int damage;
	
	Zombie(int playerPosition, int curHp, int maxHp){
		super(playerPosition, curHp, maxHp);
	}

	@Override
	void attack(Unit hero) {
		damage = PlayGame.ran.nextInt(getMaxHp())+1;
		hero.setCurHp(hero.getCurHp() - damage);
		
		if(hero.getCurHp() < 0)
			hero.setCurHp(0);
		
		System.out.printf("[msg] 좀비가 %d의 공격력으로 공격함. \n"
				+ "공격한 뒤 Hero의 HP : %d\n", damage, hero.getCurHp());
	}
}
