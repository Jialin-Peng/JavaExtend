package 斗地主;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class doudizhu {
	public static void main(String[] args) {

		// 创建牌花色
		String[] colors = { "♦", "♠", "♥", "♣" };
		// 创建牌点数
		String[] points = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
		// 创建牌 拼接花色和点数
		ArrayList<String> pokers = new ArrayList<String>();
		for (String i : colors) {
			for (String j : points) {
				pokers.add(i + j);
			}
		}
		pokers.add("小王");
		pokers.add("大王");
		// 洗牌
		Collections.shuffle(pokers);
		// 创建玩家及堆底牌
		ArrayList<String> play1 = new ArrayList<String>();
		ArrayList<String> play2 = new ArrayList<String>();
		ArrayList<String> play3 = new ArrayList<String>();
		ArrayList<String> bottoms = new ArrayList<String>();
		// 分牌
		for (int i = 0; i < pokers.size(); i++) {
			if (i >= pokers.size() - 3) {
				bottoms.add(pokers.get(i));
			} else if (i % 3 == 0) {
				play1.add(pokers.get(i));
			} else if (i % 3 == 1) {
				play2.add(pokers.get(i));
			} else if (i % 3 == 2) {
				play3.add(pokers.get(i));
			}
		}
		lookPokers("玩家1排序前", play1);
		lookPokers("玩家2排序前", play2);
		lookPokers("玩家3排序前", play3);
		lookPokers("堆底排序前", bottoms);
		sortPokers(play1);
		sortPokers(play2);
		sortPokers(play3);
		sortPokers(bottoms);
		System.out.println();
		// 查看三个玩家的牌以及堆底牌
		lookPokers("玩家1排序后", play1);
		lookPokers("玩家2排序后", play2);
		lookPokers("玩家3排序后", play3);
		lookPokers("堆底排序后", bottoms);

		System.out.print("牌的总数是：" + pokers.size());
	}

	// 查看牌的方法
	public static void lookPokers(String play_name, ArrayList<String> pokers_list) {
		System.out.print(play_name + "的牌是：");
		for (String poker : pokers_list) {
			System.out.print(poker + " ");
		}
		System.out.println();
	}

	// 整理牌序的方法
	/*思路
	 * 新建一个treeSet实例，存入Poker类的实例
	 * 新建一个Poker类实现Comparable接口，重写compareTo方法
	 * 将牌拆分成花色和点数，然后存入Poker类，实例化Poker类
	 * 用TreeSet中的排序方法整理牌序
	 * 重新将treeSet集合中的牌存入到ArrayList集合中输出
	 */
	public static void sortPokers(ArrayList<String> pokers_list) {
		Set<Poker> tree_poker = new TreeSet<Poker>();
		for (String poker : pokers_list) {
			char poker_color = poker.charAt(0);
			char poker_point = poker.charAt(1);
			tree_poker.add(new Poker(poker_color, poker_point));
		}
		pokers_list.clear();
		for (Poker poker : tree_poker) {
			char poker_color = poker.getPoker_color();
			char poker_point = poker.getPoker_point();
			StringBuffer sbf = new StringBuffer();
			sbf.append(poker_color).append(poker_point);
			pokers_list.add(sbf.toString());
		}
	}

	static class Poker implements Comparable<Poker> {
		private char poker_color;
		private char poker_point;

		public Poker(char poker_color, char poker_point) {
			this.poker_color = poker_color;
			this.poker_point = poker_point;
		}

		public char getPoker_color() {
			return poker_color;
		}

		public void setPoker_color(char poker_color) {
			this.poker_color = poker_color;
		}

		public char getPoker_point() {
			return poker_point;
		}

		public void setPoker_point(char poker_point) {
			this.poker_point = poker_point;
		}

		@Override//整理牌序的方法
		public int compareTo(Poker p) {
			// TODO Auto-generated method stub
			
			int point_num = this.getPoker_point() - p.getPoker_point();

			int color_num = this.getPoker_color() - p.getPoker_color();
			return point_num == 0 ? color_num : point_num;
		}

	}
}
