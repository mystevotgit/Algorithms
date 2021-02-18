import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class PhonebookChallenge {

    private static Map<String, String> phonebook = new HashMap<>();

    public static void main(String[] args){
        // Add a contact to the phonebook.
        phonebook.put("Olatunji", "+2348144533711");
        phonebook.put("Ola", "08123456789");

        // Remove a contact from the phonebook.
        phonebook.remove("Olatunji");

        // Edit an entry in the phonebook.
        phonebook.put("Olatunji", "+2348111122233");

        // View a single contact.
        phonebook.get("Olatunji");

        // View all the entries in the phonebook.
        Set<String> keys = phonebook.keySet();
        keys.forEach(key -> System.out.println("Name: " + key + " --->> Phone Number: " + phonebook.get(key)));
    }
}
