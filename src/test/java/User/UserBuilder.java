package User;

public class UserBuilder {
    private static   EmailGenerator generator = new EmailGenerator();
    private  static String EMAIL = generator.getEmail();
    private static String  PASSWORD = "123LSQtt";
    private static String PHONE_NUMBER = "+380664740149";
    private static String NAME = "User";

    public static IUser createUser(){

        return User.get().setName(NAME).setNumber(PHONE_NUMBER)
                .setEmail(EMAIL).setPassword(PASSWORD).build();
    }

}
