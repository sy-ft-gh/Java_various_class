package various_classes;

enum AccountType {
	// 型の取り得る値を列挙子として定義
	// 列挙子1, 列挙子2, 列挙子3とカンマ区切りで記述
	FUTSU, TOUZA, TEIKI;
}

enum Fruit {
	// 列挙子は定義するが、コンストラクタに渡す値を合わせて定義する
	APPLE("リンゴ", 1),
	ORANGE("オレンジ", 2),
	PEACH("もも", 3);
	
	// 各列挙子の持つメンバフィールド
	private String label;
	private int id;
	// コンストラクタ
	// 列挙子定義時の引数を受け取る
	// ※アクセス修飾子はprivateのみ許可される
	private Fruit(String label, int id) {
		this.label = label;
		this.id = id;
	}
	
	// メンバフィールドのgetterを定義
	public String getLabel() {
		return label;
	}
	public int getId() {
		return id;
	}
}

class Outer {
	int outerField;
	static int outerStaticField;
	// InnerStatic＝Ouer内の内部クラス
	static class InnerStatic {
		void innerMethod() {
			// staticな外部クラスのメンバのみアクセスできる
			outerStaticField = 10;
		}
	}
	class Inner {
		int innerField;
		void innerMethod() {
			this.innerField = 10;
		}
	}
	// 外部クラスのメソッド
	void outerMthod() {
		// StaticなInnerクラスのインスタンス生成ができる
		InnerStatic ic = new InnerStatic();
		// インスタンスメソッドが実行できる
		ic.innerMethod();
		// Innerクラスのインスタンス生成ができる
		Inner ic2 = new Inner();
		// インスタンスメソッドが実行できる
		ic2.innerMethod();
	}
	public static void main(String[] args) {
		Outer.InnerStatic is = new Outer.InnerStatic();
		Outer o = new Outer();
		Outer.Inner i = o.new Inner();
	}
}
