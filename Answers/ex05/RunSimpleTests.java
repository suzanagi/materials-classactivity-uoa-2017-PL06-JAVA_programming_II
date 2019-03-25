import java.lang.reflect.Method;

public class RunSimpleTests {
    
    /* Main Method */
    public static void main(String[] args) throws Exception {
	int tested = 0;
	int passed = 0;
	for(Method m : Class.forName(args[0]).getMethods()) {
	    if(m.isAnnotationPresent(SimpleTest.class)) {
		tested++;
		try {
		    m.invoke(Class.forName(args[0]).newInstance(), (Object[])null);
		    passed++;
		} catch(Throwable ex) {
		    System.out.println(m.getName() + " failed " + ex.getCause());
		}
	    }
	}
	System.out.println(passed + " passed out of " + tested + "tested");
    }
    
}
