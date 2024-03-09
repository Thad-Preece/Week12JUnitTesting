package com.promineotech;



import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;



class TestDemoJUnitTest {

	private TestDemo testDemo;
	
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		}else {
			assertThatThrownBy(() ->

		    testDemo.addPositive(a, b))

		        .isInstanceOf(IllegalArgumentException.class);
		}
	}

	 static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(
		arguments(2, 4, 6, false),
		arguments(5, 5, 10, false),
		arguments(0, 5, 5, true),
		arguments(-1, 4, 3, true),
		arguments(-5, -7, -12, true)
		);
	}
	 
	 @Test
	 protected void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		 assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		 assertThat(testDemo.addPositive(50, 40)).isEqualTo(90);
		 assertThat(testDemo.addPositive(1, 3)).isEqualTo(4);
	 }
	 
	void assertThatTwoNegativeNumbersAreSubtractedCorrectly(int a, int b,
	int expected, boolean expectException) {
		
		if(!expectException) {
			assertThat(testDemo.subtractNegative(a, b)).isEqualTo(expected);
		}else {
			assertThatThrownBy(() ->

		    testDemo.subtractNegative(a, b))

		        .isInstanceOf(IllegalArgumentException.class);
		}
		
	}
	
	static Stream<Arguments> argumentsForsubtractNegative() {
		return Stream.of(
		arguments(-2, -4, 2, false),
		arguments(-5, -5, 0, false),
		arguments(0, -5, 5, true),
		arguments(-1, 4, 3, true),
		arguments(5, 7, -2, true)
		);
	}
		@Test
		protected void assertThatPairsOfNegativeNumbersAreSubtractedCorrectly() {
			assertThat(testDemo.subtractNegative(-4, -5)).isEqualTo(1);
			assertThat(testDemo.subtractNegative(-30, -20)).isEqualTo(-10);
			assertThat(testDemo.subtractNegative(-1, -1)).isEqualTo(0);
		}
		
		@Test
		protected void assertThatNumbersSquaredIsCorrect() {
			TestDemo mockDemo = spy(testDemo);
			doReturn(5).when(mockDemo).getRandomInt();
			int fiveSquared = mockDemo.randomNumberSquared();
			assertThat(fiveSquared).isEqualTo(25);
		}
}
