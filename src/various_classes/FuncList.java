package various_classes;

public class FuncList {
	public static boolean isOdd(int x) { return (x % 2 == 1); }
	public String addNamePrefix(boolean male, String name) {
		// 三項分岐 式の結果(true/false)により二つの値を分けて返す
		// (式) ? 値１ : 値2
		// 式がtrueの場合は値１が返却、式がfalseの場合は値２が返却される
		return male ? "Mr." + name : "Ms." + name;
	}
}
