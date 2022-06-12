package java8.section04;

import java8.OnlineClass;
import java8.Progress;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Optional소개 {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1,"spring boot",true));
        springClasses.add(new OnlineClass(2,"spring data jpa",true));
        springClasses.add(new OnlineClass(3,"spring mvc",false));
        springClasses.add(new OnlineClass(4,"spring core",false));
        springClasses.add(new OnlineClass(5,"rest pi dev",false));

        // Optional 은 클라이언트 코드에게 명시적으로 빈 값일 수도 있다는 것을
        // 알려주고 빈값인 경우데 대한 처리를 강제한다.
        // 리턴값으로만 쓰기를 권장한다.
        // Optional 을 리턴하는 메소드에서 null 을 리턴하지 말자
        // Optional 로 Collection,Map,Stream,Array를 감싸지 말자.

        OnlineClass spring_boot = new OnlineClass(1, "spring boot", true);
        Optional<Progress> progress = spring_boot.getProgress();
        // progress 가 null 이 되면 안된다. getProgress() 에서 null 리턴 금지
        progress.ifPresent(p -> System.out.println(p.getStudyDuration()));



    }
}
