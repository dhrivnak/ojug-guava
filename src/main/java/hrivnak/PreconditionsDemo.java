package hrivnak;

import com.google.common.base.Preconditions;

public class PreconditionsDemo {

	public void doBoringWay(String foo) {
		System.out.println("== boring way ==");
		if (foo == null) {
			throw new NullPointerException("foo must not be null");
		}
		if (foo.isEmpty()) {
			throw new IllegalArgumentException("foo must not be empty");
		}
		if (foo.length() > 7) {
			throw new IllegalArgumentException(
					"foo must be less than 7 characters; foo = " + foo);
		}
		if (foo.equals("bar")) {
			throw new IllegalStateException("foo can't be in the bar state");
		}
		System.out.println(foo);
	}

	public void doGuavaWay(String foo) {
		System.out.println("== guava way ==");
		Preconditions.checkNotNull(foo, "foo must not be null");
		Preconditions.checkArgument(!foo.isEmpty(), "foo must not be empty");
		Preconditions.checkArgument(foo.length() <= 7,
				"foo must be less than 7 characters; foo = %s", foo);
		Preconditions.checkState(!foo.equals("bar"),
				"foo can't be in the bar state");
		System.out.println(foo);
	}

	public static void main(String[] args) {
		Preconditions.checkArgument(args.length > 0,
				"must provide at least one argument");
		PreconditionsDemo demo = new PreconditionsDemo();
		for (String arg : args) {
			demo.doBoringWay(arg);
			System.out.println();
			demo.doGuavaWay(arg);
		}
	}

}
