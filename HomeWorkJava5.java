import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;

public class HomeWorkJava5 {
    private Map < String, List < String >> TelephoneDirectory;
    public HomeWorkJava5() {
        TelephoneDirectory = new HashMap <> ();
    }

public void add(String lastName, String phoneNumber) {
    List < String > numbers = TelephoneDirectory.getOrDefault(lastName, new ArrayList <> ());
        numbers.add(phoneNumber);
        TelephoneDirectory.put(lastName, numbers);
    }

public List<String> get(String lastName) {
    return TelephoneDirectory.getOrDefault(lastName, Collections.emptyList());
    }

public void remove(String lastName) {
    TelephoneDirectory.remove(lastName);
    }

public void list() {
    for (Map.Entry < String, List < String >> entry : TelephoneDirectory.entrySet()) {
        String lastName = entry.getKey();
        List < String > numbers = entry.getValue();
        System.out.println(lastName + ": " + numbers);
    }
}
}















