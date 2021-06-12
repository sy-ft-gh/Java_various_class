package various_classes;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntToDoubleFunction;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public final double val = 3.14;
	
	public static int sub(int a, int b) {
		return a - b;
	}
	
	public double multiply(int a) {
		return this.val * a;
	}
	private static void sub2(IntBinaryOperator sub, int a, int b) {
		int result = sub.applyAsInt(a, b);
	}
	public static void main(String[] args) {
		// 型宣言に仮型引数が指定されているが指定されている阿合は
		// 代入するインスタンス生成で型を省略可能
		Pocket<Integer> p = new Pocket<>();
		// 情報を追加する（Integer型インスタンスでの追加が必要）
		p.put(Integer.valueOf(5));
		p.put(Integer.valueOf(2));
		p.put(Integer.valueOf(6));
		p.put(Integer.valueOf(8));
		// 3番目の要素を取得し文字列表現を出力
		System.out.println(p.get(3));
		// List<Integer>を取得し文字列表現を出力
		System.out.println(p.getAll());
		// Pocketクラスに定義した文字列表現出力メソッド(toStrinig())により
		// 文字列表現を出力
		System.out.println(p);
		System.out.println("---------------------------------------------------");
		// よく使う列挙型
		//   指定した値のみを取り扱う
		//   例：口座種別
		AccountType aType = AccountType.TOUZA;
		// switch文で条件分岐ができる
		switch (aType) {
			case FUTSU:
				System.out.println("普通預金です");
				break;
			case TOUZA:
				System.out.println("当座預金です");
				break;
			case TEIKI:
				System.out.println("定期預金です");
				break;
		}
		// 列挙型の拡張
		//  列挙子に値を持たせる
		// 列挙子指定での出力は列挙子のスペルが出力される
		// ※勿論列挙型もObjectを継承しているためtoString()をオーバーライドすると変わる
		System.out.println("Fruit.APPLE:[" + Fruit.APPLE + "]");
		// getterを用いて値を取得
		System.out.println("Fruit.APPLE.getLabel:[" + Fruit.APPLE.getLabel() + "]");
		System.out.println("Fruit.APPLE.getId:[" + Fruit.APPLE.getId() + "]");
		Fruit f = Fruit.PEACH;
		if (f == Fruit.ORANGE) {
			System.out.println(Fruit.ORANGE.getLabel() + "が好きです");
		} else {
			System.out.println(f.getLabel() + "はジュースが好きです");
		}
		// SAMインタフェースに対してメソッドを代入。右辺値は
		//   クラス名::静的メソッド名
		//   インスタンス変数名::インスタンスメソッド名
		// クラスの静的メソッドを代入
		IntBinaryOperator func1 = Main::sub;
		int a = func1.applyAsInt(5, 3);
		System.out.println("5-3=" + a);
		// インスタンスのメソッドを代入
		Main m = new Main();
		IntToDoubleFunction func2 = m::multiply;
		double b = func2.applyAsDouble(a);
		System.out.println("(5-3)*" + m.val + "=" + b);
		
		
		// Collection型のArrayListを生成
		// Java.util.Arraysを用いると引数の値を持つListインスタンスが作成できる。
		// ※ただし、Arrays.asList()によるListインスタンスは固定長のため要素の追加ができない
		//  初期化後に要素の追加を行う場合、さらにArrayListクラスのコンストラクタに渡すと
		//  Listインスタンスと同じ要素のArrayListインスタンスが作成できる
		List<String> aList = new ArrayList<String>(Arrays.asList("3", "2", "4"));
		var bList = new ArrayList<String>(Arrays.asList("3", "2", "4"));
		bList.stream().forEach(System.out::println);		
		
		// forEach（）にラムダ式を渡すことでList内の１要素毎にラムダ式を実行できる
		aList.stream().forEach(str -> System.out.println(str));
		// forEach()はSAMインタフェースにも対応しているので、１つの引数を処理する結果がvoid型のメソッド参照を
		// 関数オブジェクトとして引き渡す事もできる
		aList.stream().forEach(System.out::println);		
		// 中間操作を使用するとString→int変換と変換後の値の合計算出を１ステップで実行できる
		int sumValue = aList.stream()
							// mapメソッド(加工メソッド)の１つのmapToIntを用いると
							// 関数オブジェクトを使用し要素１つずつをint値に加工できる
							.mapToInt(Integer::parseInt)
							// 加工されたint値をsum()で合計する
							.sum();
		
        // 省略無し
        Consumer<String> f0 = new Consumer<String>(){
            @Override
            public void accept(String t) {
                System.out.println(t);                
            }
        };
        f0.accept("出力1");
        // クラス名の省略
        Consumer<String> f2 = (String t) -> {
            System.out.println(t);                
        };
        f2.accept("出力2");
        // 引数型の省略
        Consumer<String> f3 = (t) -> {
            System.out.println(t);                
        };
        f3.accept("出力3");
        // ブロックの省略
        Consumer<String> f4 = t ->System.out.println(t);    
        f4.accept("出力4");

        // 結果を返すケース
        Function<String, String> f5 = t -> t + "結果";
        System.out.println(f5.apply("出力"));
        // 省略しないと
        Function<String, String> f6 = new Function<String,String>(){
            @Override
            public String apply(String t) {
                return t + "結果";
            }
        };
        System.out.println(f6.apply("出力2"));
        // 自作でインタフェースを作成しても可能
        final String prefix = "・";
        IF2<String> if_exec =  t -> System.out.println(prefix + t);
        if_exec.exec("出力３");
	}
    public static void put(String s) {
        System.out.println(s);
    }
}

interface IF2<T> {
    void exec(T arg);
}