package java8.section02;

public interface Bar {

    // bar 가 foo 를 상속받는 인터페이스일때
    // foo의 default 메서드를 제공하고 싶지 않다? 이렇게 하면 Bar의
    // 구현체에서 재정의 하면 됨.
    //void printNameUpperCase();

    default void printNameUpperCase() {
        System.out.println("bar");
    }
}
