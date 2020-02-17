    package by.gstu.tests;

    import by.gstu.models.entities.Account;
    import by.gstu.models.entities.Administrator;
    import by.gstu.models.entities.Client;
    import junit.framework.Assert;
    import org.junit.Test;

    import java.io.*;
    import java.util.ArrayList;
    import java.util.Collection;

    public class SerializationTest extends Assert {

        private void initData(Collection<Account> accounts) {
            accounts.add(new Client(1, "default", "a1806", "default@gmail.com",
                    "Трофимов Е.В.", 2000));
            accounts.add(new Administrator(2, "ropot", "a1806", "army@gmail.com",
                    "Ропот И.В."));
        }

        @Test
        public void writeObj() {
            Collection<Account> accounts = new ArrayList<>();
            System.out.println("Serialize:");
            Account.staticField = "static 1.0";
            try (OutputStream outputStream = new FileOutputStream("resources/serializeObj.data")) {
                try (ObjectOutputStream objStream = new ObjectOutputStream(outputStream)) {
                    initData(accounts);
                    objStream.writeObject(accounts);
                    accounts.forEach(System.out::println);
                    Assert.assertTrue(true);
                } catch (IOException e) {
                    e.printStackTrace();
                    Assert.fail();
                }
            } catch (IOException e) {
                e.printStackTrace();
                Assert.fail();
            }
        }

        @Test
        public void readObj() {
            Collection<Account> accounts = new ArrayList<>();
            System.out.println("\nDeserialize:");
            try (InputStream inStream = new FileInputStream("serializeObj.data")) {
                try (ObjectInputStream objStream = new ObjectInputStream(inStream)) {
                    initData(accounts);
                    Collection<Account> desAccounts = (Collection<Account>) objStream.readObject();
                    desAccounts.forEach(System.out::println);
                    Assert.assertTrue(true);
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                    Assert.fail();
                }
            } catch (IOException e) {
                e.printStackTrace();
                Assert.fail();
            }
        }
    }
