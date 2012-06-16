package hrivnak;

import com.google.common.base.Preconditions;

public class PreconditionsDemo {

	public void doRegularWay(String foo) {
		if (foo == null) {
			throw new NullPointerException("foo must not be null");
		}
		if (foo.isEmpty()) {
			throw new IllegalArgumentException("foo must not be empty");
		}
		if (foo.length() > 7) {
			throw new IllegalArgumentException("foo must be less than 7 characters; foo = " + foo);
		}
		if (foo.equals("bar")) {
			throw new IllegalStateException("foo can't be in the bar state");
		}
	}

	public void doGuavaWay(String foo) {
		Preconditions.checkNotNull(foo, "foo must not be null");
		Preconditions.checkArgument(!foo.isEmpty(), "foo must not be empty");
		Preconditions.checkArgument(foo.length() <= 7, "foo must be less than 7 characters; foo = %s", foo);
		Preconditions.checkState(!foo.equals("bar"), "foo can't be in the bar state");
	}

}
