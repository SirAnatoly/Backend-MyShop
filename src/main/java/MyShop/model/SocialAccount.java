package MyShop.model;

public class SocialAccount {

    private final String name;
    private final String email;

    public SocialAccount(String name, String email) {
        super();
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "SocialAccount{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
