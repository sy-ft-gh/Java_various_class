package various_classes;

import java.util.ArrayList;
import java.util.List;

enum key{
	
}
//「E」は仮型引数
//「E」という文字でも他の文字でも可
//慣例的に以下の基準でアルファベットが付与される
//	内部に持つ値となる要素はElementの「E」
//  内部に持つキーとなる要素はKeyの「K」
//	結果型を指定したい場合はResultの「R」
//内部に持つのではなく、ただ引数の型を指定したい場合はTypeの「T」
public class Pocket<E> {
	private List<E> data;
	// 仮型引数を指定してコンストラクタも指定可
	public Pocket(E data) {
		// 引数無しのコンストラクタを実行しdataインスタンスを準備
		// 勿論、フィールド宣言で初期化を行う事も可能
		this();
		this.put(data);
	}
	// 引数無しの場合はdataのインスタンス生成のみ行う
	public Pocket() {
		this.data = new ArrayList<>();
	}
	// 通常メソッドも指定可
	public void put(E data) {
		this.data.add(data);
	}
	// 通常の型を引数として持たせることも可能
	public E get(int i) {
		return this.data.get(i);
	}
	// 結果に仮型引数を指定する事も可能
	public List<E> getAll() {
		return this.data;
	}
	// toStringメソッドのオーバーライドも可能
	@Override
	public String toString() {
		// List<>にはtoString()により内部のインスタンスの文字列表現を
		// カンマ区切りで表現してくれるtoString()が実装されている
		return "Pocket [data=" + this.data.toString() + "]";
	}
	
}
