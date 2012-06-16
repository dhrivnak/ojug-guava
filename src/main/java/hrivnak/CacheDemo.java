package hrivnak;

import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.Uninterruptibles;

public class CacheDemo {
	public static void main(String[] args) {
		Loader loader = new Loader();
		LoadingCache<String, String> cache = CacheBuilder.newBuilder() //
		        .maximumSize(100) //
		        .expireAfterWrite(2, TimeUnit.DAYS) //
		        .build(loader);

		System.out.println("Let's try to retrieve something awesome...");
		System.out.print(cache.getUnchecked("something "));
		System.out.println(cache.getUnchecked("awesome"));
		System.out.println("Wow, that took a while. Let's retrieve them a couple more times.");
		System.out.print(cache.getUnchecked("something "));
		System.out.println(cache.getUnchecked("awesome"));
		System.out.print(cache.getUnchecked("something "));
		System.out.println(cache.getUnchecked("awesome"));
		System.out.print(cache.getUnchecked("something "));
		System.out.println(cache.getUnchecked("awesome"));

		System.out.println("Now we will invalidate awesome and then try to get something awesome again...");
		cache.invalidate("awesome");
		System.out.print(cache.getUnchecked("something "));
		System.out.println(cache.getUnchecked("awesome"));
	}

	static class Loader extends CacheLoader<String, String> {

		@Override
		public String load(String key) throws Exception {
			// let's pretend that making a string all-caps is a really expensive operation
			Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
			return key.toUpperCase();
		}

	}
}
