package java8.section04;

import java8.OnlineClass;
import java8.Progress;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalAPI {

    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1,"spring boot",true));
        springClasses.add(new OnlineClass(5,"rest pi dev",false));

        Optional<OnlineClass> jpa = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("jpa"))
                .findFirst();
        boolean jpaPresent = jpa.isPresent();
        System.out.println(jpaPresent);

        Optional<OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("jpa"))
                .findFirst();
        OnlineClass onlineClass = optional.orElseGet(() -> createNewJpaClass());
        System.out.println(onlineClass.getTitle());

        Optional<OnlineClass> onlineClass1 = optional.filter(oc -> oc.isClosed());
        System.out.println(onlineClass1.isPresent());

        Optional<Progress> progress = optional.flatMap(OnlineClass::getProgress);



    }

    private static OnlineClass createNewJpaClass() {
        System.out.println("Create new online class");
        return new OnlineClass(10, "New Class", false);
    }
}
