package myZombie;

public class Hero extends Unit {

	int damage;
	int recoveryCount;
	
	public Hero(int playerPosition, int curHp, int maxHp, int recoveryCount) {
		super(playerPosition, curHp, maxHp);
		this.recoveryCount = recoveryCount;
	}

	@Override
	void attack(Unit unit) {
		damage = PlayGame.ran.nextInt(getMaxHp())+1;
		if(unit instanceof Boss) {
			// 보스랑 싸울때
			Boss boss = (Boss) unit;
			if(boss.getShield() < damage) {
				boss.setShield(0);
				boss.setCurHp(boss.getCurHp()-(damage - boss.getShield()));
				System.out.printf("[msg] Hero가 %d의 공격력으로 Boss를 공격함. \n"
						+ "공격한 뒤 Boss의 HP : %d\n", damage, boss.getCurHp());
			} else { // shield끝
				boss.setShield(boss.getShield()-damage);
				System.out.printf("[msg] Hero가 %d의 공격력으로 Boss를 공격함. \n"
						+ "공격한 뒤 Boss의 Shield : %d\n", damage, boss.getShield());
			}
			if(boss.getCurHp() < 0) boss.setCurHp(0);
			
		} else {
			// 좀비랑 싸울때는
			unit.setCurHp(unit.getCurHp() - damage);
			
			if(unit.getCurHp() < 0)
				unit.setCurHp(0);
			
			System.out.printf("[msg] Hero가 %d의 공격력으로 Zombie를 공격함. \n"
					+ "공격한 뒤 Zombie의 HP : %d\n", damage, unit.getCurHp());
		}
	}
	
	void recovery() {
		if(recoveryCount > 0) { // recovery 기회가 남아있는 경우 
			setCurHp(getCurHp()+100);
			recoveryCount--;			
			System.out.println("[msg] 회복 후 Hero의 HP : " + getCurHp());
		} else if( recoveryCount == 0) {// 기회가 남아있지 않는 경우 
			System.out.println("더이상 회복기회가 남아있지 않습니다. ");
		}
	}
	

}
