package testmokito;


import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;


public class ExampleTest {
	@Test
	public void test01() {
		Example myExample = mock(Example.class);
		myExample.sumar(1, 1);
		
		verify(myExample).sumar(1,1);
	}
	
}
