package 斗地主;

import java.util.ArrayList;
import java.util.Collections;

public class doudizhu {
	public static void main(String[] args) {
		
		//创建牌花色
		String[] colors= {"♦","♠","♥","♣"};
		//创建牌点数
		String[] points= {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
		//创建牌  拼接花色和点数
		ArrayList<String> pokers=new ArrayList<String>();
		for(String i:colors) {
			for(String j:points) {
				pokers.add(i+j);
			}
		}
		pokers.add("小王");
		pokers.add("大王");
		//洗牌
		Collections.shuffle(pokers);
		//创建玩家及堆底牌
		ArrayList<String> play1=new ArrayList<String>();
		ArrayList<String> play2=new ArrayList<String>();
		ArrayList<String> play3=new ArrayList<String>();
		ArrayList<String> bottoms=new ArrayList<String>();
		//分牌
		for(int i=0;i<pokers.size();i++) {
			if(i>=pokers.size()-3) {
				bottoms.add(pokers.get(i));
			}
			else if(i%3==0) {
				play1.add(pokers.get(i));
			}
			else if(i%3==1) {
				play2.add(pokers.get(i));
			}
			else if(i%3==2) {
				play3.add(pokers.get(i));
			}
		}
		//查看三个玩家的牌以及堆底牌
		lookPokers("玩家1",play1);
		lookPokers("玩家2",play2);
		lookPokers("玩家3",play3);
		lookPokers("堆底",bottoms);
		
		System.out.print("牌的总数是："+pokers.size());
	}

	// 查看牌的方法
	public static void lookPokers(String play_name,ArrayList<String> PokersList) {
		System.out.print(play_name+"的牌是：");
		for(String poker:PokersList) {
			System.out.print(poker+" ");
		}
		System.out.println();
	}
}
