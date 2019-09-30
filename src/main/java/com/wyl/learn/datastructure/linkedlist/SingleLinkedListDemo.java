package com.wyl.learn.datastructure.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {

	public static void main(String[] args) {
		//в
		//ȴڵ
		HeroNode hero1 = new HeroNode(1, "ν", "ʱ");
		HeroNode hero2 = new HeroNode(2, "¬", "");
		HeroNode hero3 = new HeroNode(3, "", "Ƕ");
		HeroNode hero4 = new HeroNode(4, "ֳ", "ͷ");
		
		//Ҫ
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		
		
		//
		singleLinkedList.add(hero1);
		singleLinkedList.add(hero4);
		singleLinkedList.add(hero2);
		singleLinkedList.add(hero3);

		// һµķת
		System.out.println("ԭ~~");
		singleLinkedList.list();
		
//		System.out.println("ת~~");
//		reversetList(singleLinkedList.getHead());
//		singleLinkedList.list();
		
		System.out.println("ӡ, ûиıĽṹ~~");
		reversePrint(singleLinkedList.getHead());
		
/*		
		//밴ձŵ˳
		singleLinkedList.addByOrder(hero1);
		singleLinkedList.addByOrder(hero4);
		singleLinkedList.addByOrder(hero2);
		singleLinkedList.addByOrder(hero3);
		
		//ʾһ
		singleLinkedList.list();
		
		//޸ĽڵĴ
		HeroNode newHeroNode = new HeroNode(2, "С¬", "~~");
		singleLinkedList.update(newHeroNode);
		
		System.out.println("޸ĺ~~");
		singleLinkedList.list();
		
		//ɾһڵ
		singleLinkedList.del(1);
		singleLinkedList.del(4);
		System.out.println("ɾ~~");
		singleLinkedList.list();
		
		//һ Чڵĸ
		System.out.println("ЧĽڵ=" + getLength(singleLinkedList.getHead()));//2
		
		//һ¿Ƿõ˵Kڵ
		HeroNode res = findLastIndexNode(singleLinkedList.getHead(), 3);
		System.out.println("res=" + res);
*/		
		
	}
	

	public static void reversePrint(HeroNode head) {
		if(head.next == null) {
			return;
		}
		Stack<HeroNode> stack = new Stack<HeroNode>();
		HeroNode cur = head.next;

		while(cur != null) {
			stack.push(cur);
			cur = cur.next;
		}
		while (stack.size() > 0) {
			System.out.println(stack.pop());
		}
	}

	public static void reversetList(HeroNode head) {
		if(head.next == null || head.next.next == null) {
			return ;
		}

		HeroNode cur = head.next;
		HeroNode next = null;
		HeroNode reverseHead = new HeroNode(0, "", "");
		while(cur != null) { 
			next = cur.next;
			cur.next = reverseHead.next;
			reverseHead.next = cur;
			cur = next;//cur
		}
		head.next = reverseHead.next;
	}
	

	public static HeroNode findLastIndexNode(HeroNode head, int index) {

		if(head.next == null) {
			return null;
		}
		int size = getLength(head);
		if(index <=0 || index > size) {
			return null; 
		}

		HeroNode cur = head.next; //3 // 3 - 1 = 2
		for(int i =0; i< size - index; i++) {
			cur = cur.next;
		}
		return cur;
		
	}
	

	public static int getLength(HeroNode head) {
		if(head.next == null) { //
			return 0;
		}
		int length = 0;

		HeroNode cur = head.next;
		while(cur != null) {
			length++;
			cur = cur.next; //
		}
		return length;
	}

}



class SingleLinkedList {

	private HeroNode head = new HeroNode(0, "", "");
	
	

	public HeroNode getHead() {
		return head;
	}


	public void add(HeroNode heroNode) {
		

		HeroNode temp = head;

		while(true) {

			if(temp.next == null) {//
				break;
			}

			temp = temp.next;
		}

		temp.next = heroNode;
	}
	

	public void addByOrder(HeroNode heroNode) {

		HeroNode temp = head;
		boolean flag = false;
		while(true) {
			if(temp.next == null) {
				break; //
			} 
			if(temp.next.no > heroNode.no) {
				break;
			} else if (temp.next.no == heroNode.no) {
				
				flag = true;
				break;
			}
			temp = temp.next;
		}

		if(flag) {
			System.out.printf("编号%d已经存在\n", heroNode.no);
		} else {
			heroNode.next = temp.next;
			temp.next = heroNode;
		}
	}


	public void update(HeroNode newHeroNode) {
		//жǷ
		if(head.next == null) {
			System.out.println("Ϊ~");
			return;
		}

		HeroNode temp = head.next;
		boolean flag = false;
		while(true) {
			if (temp == null) {
				break;
			}
			if(temp.no == newHeroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if(flag) {
			temp.name = newHeroNode.name;
			temp.nickname = newHeroNode.nickname;
		} else {
			System.out.printf("ûҵ  %d Ľڵ㣬޸\n", newHeroNode.no);
		}
	}

	public void del(int no) {
		HeroNode temp = head;
		boolean flag = false;
		while(true) {
			if(temp.next == null) {
				break;
			}
			if(temp.next.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if(flag) {
			//ɾ
			temp.next = temp.next.next;
		}else {
			System.out.printf("Ҫɾ %d ڵ㲻\n", no);
		}
	}

	public void list() {
		if(head.next == null) {
			System.out.println("Ϊ");
			return;
		}
		HeroNode temp = head.next;
		while(true) {
			if(temp == null) {
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}
	}
}


class HeroNode {
	public int no;
	public String name;
	public String nickname;
	public HeroNode next;
	//
	public HeroNode(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
	
}
