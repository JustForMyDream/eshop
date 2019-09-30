package com.wyl.learn.datastructure.linkedlist;

public class DoubleLinkedListDemo {

	public static void main(String[] args) {


	}

}
class DoubleLinkedList {

	private HeroNode2 head = new HeroNode2(0, "", "");


	public HeroNode2 getHead() {
		return head;
	}



	public void list() {
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		HeroNode2 temp = head.next;
		while (true) {
			if (temp == null) {
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}
	}

	public void add(HeroNode2 heroNode) {

		HeroNode2 temp = head;
		while (true) {
			if (temp.next == null) {//
				break;
			}
			temp = temp.next;
		}
		temp.next = heroNode;
		heroNode.pre = temp;
	}

	public void update(HeroNode2 newHeroNode) {
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		HeroNode2 temp = head.next;
		boolean flag = false;
		while (true) {
			if (temp == null) {
				break;
			}
			if (temp.no == newHeroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.name = newHeroNode.name;
			temp.nickname = newHeroNode.nickname;
		} else {
			System.out.printf("更新节点%d不存在\n", newHeroNode.no);
		}
	}

	public void del(int no) {

		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}

		HeroNode2 temp = head.next;
		boolean flag = false;
		while (true) {
			if (temp == null) {
				break;
			}
			if (temp.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}

		if (flag) {

			temp.pre.next = temp.next;
			if (temp.next != null) {
				temp.next.pre = temp.pre;
			}
		} else {
			System.out.printf("删除节点%d不存在\n", no);
		}
	}

}


class HeroNode2 {
	public int no;
	public String name;
	public String nickname;
	public HeroNode2 next;
	public HeroNode2 pre;


	public HeroNode2(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}

}
