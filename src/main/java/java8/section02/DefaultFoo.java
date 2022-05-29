package java8.section02;

public class DefaultFoo implements Foo,Bar {
    String name;

    public DefaultFoo(String name) {
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println("DefaultFoo");
    }

    @Override
    public String getName() {
        return this.name;
    }

    // Foo, Bar 를 구현했으 땐 재정의를 해야만 컴파일 에러가 안난다.
    @Override
    public void printNameUpperCase() {
        System.out.println("abcde");
    }
}
