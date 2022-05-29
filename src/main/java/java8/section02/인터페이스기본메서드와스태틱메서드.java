package java8.section02;

/*
Collection 인터페이스의 removeIf 메서드가 예시다.
구현체에 따라 런타임 에러가 발생할 수 있다.
그러니 문서화를 잘 해주자 (@implSpec)
그리고 구현체에서 디폴트 메서드를 재정의 할 수도 있다.

 */

public class 인터페이스기본메서드와스태틱메서드 {

    public static void main(String[] args) {

        Foo foo = new DefaultFoo("keesun");
        foo.printName();
        foo.printNameUpperCase();

        Foo.printAnything();
    }
}
