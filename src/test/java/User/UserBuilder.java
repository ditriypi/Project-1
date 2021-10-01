package User;

public class UserBuilder {
    private static   EmailGenerator generator = new EmailGenerator();
    private  static String EMAIL = generator.getEmail();
    private static  String EMAIL_EXIST = "testData0094@gmail.com";
    private static String PASSWORD_EXIST = "testaccount0244";
    private static String NAME_EXIST = "fdfd";
    private static String  PASSWORD = "123LSQttLL";
    private static String PHONE_NUMBER = PhoneGenerator.rands();
    private static String PHONE_NUMBER_EXIST = "0664648120";
    private static String NAME = "User";

    public static IUser createUser(){

        return User.get().setName(NAME).setNumber(PHONE_NUMBER)
                .setEmail(EMAIL).setPassword(PASSWORD).build();
    }
    public static IUser existUser(){
        return User.get().setName(NAME_EXIST).setNumber(PHONE_NUMBER_EXIST)
                .setEmail(EMAIL_EXIST).setPassword(PASSWORD_EXIST).build();
    }



}
