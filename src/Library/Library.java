import java.util.ArrayList;

public class Library {
    // Abstract class representing a base message
    abstract static class BaseMessage {
        private String date;
        private String author;

        public BaseMessage(String date, String author) {
            this.date = date;
            this.author = author;
        }

        public abstract void render();

        public String getAuthor() {
            return author;
        }
    }

    // Subclass representing a text message
    static class TextMessage extends BaseMessage {
        private String text;

        public TextMessage(String date, String author, String text) {
            super(date, author);
            this.text = text;
        }

        @Override
        public void render() {

        }
    }

    // Class representing a chat group
    static class Chat {
        private String chatName;
        private ArrayList<User> users;
        private ArrayList<BaseMessage> messages;

        public Chat(String chatName) {
            this.chatName = chatName;
            this.users = new ArrayList<>();
            this.messages = new ArrayList<>();
        }

        public void addUser(User user) {
            users.add(user);
        }

        public void addMessage(TextMessage message) {
            messages.add(message);
        }

        public ArrayList<BaseMessage> getAllFileMessages() {
            ArrayList<BaseMessage> fileMessages = new ArrayList<>();
            for (BaseMessage message : messages) {
                if (message != null) {
                    fileMessages.add(message);
                }
            }
            return fileMessages;
        }

        // Other methods for retrieving specific types of messages follow similar pattern
    }

    // Class representing a user
    static class User {
        private String nickname;
        private String phoneNumber;
        private String title;

        public User(String nickname, String phoneNumber, String title) {
            this.nickname = nickname;
            this.phoneNumber = phoneNumber;
            this.title = title;
        }

        public String getNickname() {
            return nickname;
        }
    }

    // Test cases
    public class MessengerTest {
        public static void main(String[] args) {
            // Create users
            User user1 = new User("Alice", "123-456-7890", "Admin");
            User user2 = new User("Bob", "987-654-3210", "User");

            // Create a chat group
            Chat chatGroup = new Chat("Group Chat");

            // Add users to the chat group
            chatGroup.addUser(user1);
            chatGroup.addUser(user2);

            // Send messages in the chat group
            chatGroup.addMessage(new TextMessage("2024-05-01", user1.getNickname(), "Hello, everyone!"));
            // Note: ImageMessage, LocationMessage, FileMessage, etc. are not defined in the provided code.

            // Display file messages in the chat group
            ArrayList<BaseMessage> fileMessages = chatGroup.getAllFileMessages();
            for (BaseMessage fileMessage : fileMessages) {
                fileMessage.render();
            }
        }
    }
}
