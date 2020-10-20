import java.util.*;

public class Party {
    private List<Guest> guests = new ArrayList<>();
    private Set<String> meals = new HashSet<>();
    private Map<Integer, Guest> phoneToGuest = new HashMap<>();
    Scanner scanner = new Scanner(System.in);


    public void addGuest() {
        System.out.println("podaj imię gościa");
        String name = scanner.nextLine();
        System.out.println("podaj preferowany posiłek");
        String meal = scanner.nextLine();
        System.out.println("podaj numer telefonu");
        int phoneNumber = Integer.valueOf(scanner.nextLine());
        System.out.println("Czy jesteś weganinem? (y/n)");
        String isVeganString = scanner.nextLine();

        boolean isVegan;

        if (isVeganString.equals("y"))
            isVegan = true;
        else {
            isVegan = false;
        }

        Guest guest = new Guest(name, meal, phoneNumber, isVegan);

        meals.add(meal);
        phoneToGuest.put(phoneNumber, guest);
        guests.add(guest);
    }

    public void displayMeals(){
        for (String meal : meals) {
            System.out.println(meal);
        }
    }

    public void displayGuestByPhoneNumber() {
        System.out.println("podaj numer telefonu");
        Integer phoneNumber = Integer.valueOf(scanner.nextLine());
        Guest guest = phoneToGuest.get(phoneNumber);
        // handling NullPointerException
        if (phoneToGuest.containsKey(phoneNumber)) {
            guest.displayGuestInfrmation();
        } else {
            System.out.println("nie ma takiego numeru");
        }

    }

    public void displayGuests() {
        for (Guest guest : guests) {
            guest.displayGuestInfrmation();
            System.out.println("");
        }
    }
}
