
class Exercise7_19 {
	public static void main(String args[]) {
		Buyer b = new Buyer();
		b.buy(new Tv());
		b.buy(new Computer());
		b.buy(new Tv());
		b.buy(new Audio());
		b.buy(new Computer());
		b.buy(new Computer());
		b.buy(new Computer());
		b.summary();
	}
}

class Buyer {
	int money = 1000;
	Product[] cart = new Product[3]; // ������ ��ǰ�� �����ϱ� ���� �迭
	int i = 0; // Product cart index �迭 �� ����

	void buy(Product p) {
		/*
		 * (1) . �Ʒ��� ������ �°� �ڵ带 �ۼ��Ͻÿ� 
		 * 1.1 . ���� ���� ������ ������ ���ؼ� ���� ���� ������ �޼��带 �����Ѵ� 
		 * 1.2 . ���� ���� ����ϸ� ��ǰ�� ������ ���� ������ ����
		 * 1.3 .(add )
		 */
		
		if(p.price<=this.money) {
			this.money -= p.price;
			add(p);
		}
		else {
			System.out.println("�ܾ��� �����Ͽ� Computer��/�� �� �� �����ϴ�.");
			return;
		}
	}

	void add(Product p) {
		Product[] newCart;
		/*
		 * (2) . �Ʒ��� ������ �°� �ڵ带 �ۼ��Ͻÿ� 
		 * 1.1 i�� ���� ��ٱ����� ũ�⺸�� ���ų� ũ�� 
		 * 1.1.1 2 . ������ ��ٱ��Ϻ��� ��
		 * ū ���ο� �迭�� �����Ѵ� 
		 * 1.1.2 . ������ ��ٱ����� ������ ���ο� �迭�� �����Ѵ� 
		 * 1.1.3 . ���ο� ��ٱ��Ͽ� ������ ��ٱ��ϸ� �ٲ۴�
		 * 1.2 (cart) . i 1 . ������ ��ٱ��� �� �����Ѵ� �׸��� �� ���� ������Ų��
		 */
		if(cart.length<=i) {
			newCart = new Product[cart.length*2];
			for(int j=0; j<cart.length; j++) {
				newCart[j] = cart[j];
			} //System.arraycopy(cart,0,newCart,0,cart.length); //�迭 ����
			cart = newCart;
		}
		cart[i] = p;
		i++;
		
	} // add(Product p)

	void summary() {
		int sum = 0;
		//String itemList[] = ""; //���� ���
		/*
		 * (3) . �Ʒ��� ������ �°� �ڵ带 �ۼ��Ͻÿ� 
		 * 1.1 . ��ٱ��Ͽ� ��� ���ǵ��� ����� ����� ����Ѵ� 
		 * 1.2 . ��ٱ��Ͽ� ��� ���ǵ��� ������ ��� ���ؼ� ����Ѵ� 
		 * 1.3 (money) . ������ ��� ���� �ݾ� �� ����Ѵ�
		 */
		System.out.println("---��ٱ��� ���---");
		for(int j=0; j<cart.length; j++) {
			System.out.print(cart[j].toString());
			if(j+1 != cart.length) System.out.print(",");
			sum += cart[j].price;
		}
		System.out.println();
		System.out.println("�� ���� : " + sum + " / " + 
							"���� �� : " + this.money);
		
	} // summary()
}

class Product {
	int price; // ��ǰ�� ����

	Product(int price) {
		this.price = price;
	}
}

class Tv extends Product {
	Tv() {
		super(100);
	}

	public String toString() {
		return "Tv";
	}
}

class Computer extends Product {
	Computer() {
		super(200);
	}

	public String toString() {
		return "Computer";
	}
}

class Audio extends Product {
	Audio() {
		super(50);
	}

	public String toString() {
		return "Audio";
	}
}
