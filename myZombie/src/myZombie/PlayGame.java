package myZombie;

import java.util.Random;
import java.util.Scanner;

public class PlayGame {
	
	public static Random ran = new Random();
	public static Scanner scan = new Scanner(System.in);
	
	void play() {
		
		Hero hero     = new Hero(1, 200, 20, 10);
		Zombie zombie = new Zombie(5, 100, 10);
		Boss boss     = new Boss(9, 300, 20, 100);
		// 게임진행
		int curPosition;
		int meetZombiePosition = ran.nextInt(6)+1;
		int meetBossPosition = 9;
		
		System.out.println("msg: meetZombiePosition : " + meetZombiePosition);
		
		while(true) {
			curPosition = hero.getPlayerPosition();
			System.out.println("\n[msg] 현재 위치 = " + curPosition);
			System.out.print("[1] 앞으로 이동 [2] 종료 : ");
			int sel = scan.nextInt();
			
			if(sel == 1) {
				hero.setPlayerPosition(++curPosition);
				// 10에 도달하면 게임 종료
				if(curPosition == 10) {
					System.out.println("[msg] 길의 끝에 도달. Hero 가 승리했습니다. 게임을 종료합니다. ");
					break;
				}
				
				// 좀비를만나면
				if(curPosition == meetZombiePosition) {
					while(true) {
						System.out.print("\n[msg] 좀비를 만났습니다. 공격모드로 바뀝니다. 공격하기(1),포션마시기(2): ");
						int sel2 = scan.nextInt();
						if(sel2 == 1) {
							// 좀비랑 싸운다. 
							hero.attack(zombie);
							zombie.attack(hero);
						} else if(sel2 == 2) {
							hero.recovery();
						}
						if(hero.getCurHp() <= 0) {
							System.out.println("[msg] Hero캐릭터 사망.");
							break;
						}
						if(zombie.getCurHp() <= 0) {
							System.out.println("[msg] Zombie 사망.");
							break;
						}
					}
				} else if(curPosition == meetBossPosition) {
					while(true) {
						System.out.print("\n[msg] 보스를 만났습니다. 공격모드로 바뀝니다. 공격하기(1), 포션마시기(2):" );
						int sel2 = scan.nextInt();
						if(sel2 == 1) {
							hero.attack(boss);
							boss.attack(hero);
						} else if(sel2 == 2) {
							hero.recovery();
						}
						if(hero.getCurHp() <= 0) {
							System.out.println("[msg] Hero캐릭터 사망.");
							break;
						}
						if(boss.getCurHp() <= 0) {
							System.out.println("[msg] Boss 사망.");
							break;
						}
						
					}
				}
				
			} else if(sel == 2) {
				// 종료
				System.out.println("[msg] 게임을 종료합니다. ");
				scan.close();
				break;
			} else {
				continue;
			}
		} 
	}

}
