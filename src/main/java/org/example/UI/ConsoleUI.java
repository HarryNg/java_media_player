package org.example.UI;

import org.example.entities.Admin;
import org.example.entities.User;
import org.example.enums.UserRoles;
import org.example.services.MediaFileService;
import org.example.services.PlaylistService;
import org.example.services.UserService;

import java.util.Optional;
import java.util.Scanner;

public class ConsoleUI {
    private final UserService userService;
    private final PlaylistService playlistService;
    private final MediaFileService mediaFileService;
    private final Scanner scanner;

    public ConsoleUI(UserService userService, PlaylistService playlistService, MediaFileService mediaFileService) {
        this.userService = userService;
        this.playlistService = playlistService;
        this.mediaFileService = mediaFileService;
        this.scanner = new Scanner(System.in);
    }

    public void start(){
        welcome();
    }
    private void welcome() {
        while (true) {
            System.out.println("To signup press (1)");
            System.out.println("To signin press (2)");
            System.out.println("To exit press (3)");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    createUser();
                    break;
                case 2:
                    User currentUser = authenticate();
                    if (currentUser != null) {
                        mainMenu(currentUser);
                    }
                    break;
                default:
                    System.exit(0);
            }
        }
    }
    private void mainMenu(User currentUser) {
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Manage Users");
            System.out.println("2. Manage Playlists");
            System.out.println("3. Manage Media Files");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    if (currentUser.getRole() == UserRoles.ADMIN) {
                        manageUsers();
                    } else {
                        System.out.println("Access denied: Only admins can manage users.");
                    }
                    break;
                case 2:
                    //managePlaylists();
                    break;
                case 3:
                    //manageMediaFiles();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
    private User authenticate(){

        System.out.println("Enter username: ");
        String username= scanner.nextLine();
        System.out.println("Enter password: ");
        String password= scanner.nextLine();
        Optional<User> user = userService.listUsers().stream()
                .filter(user1 -> user1.getUsername().equalsIgnoreCase(username) && user1.getPassword().equalsIgnoreCase(password))
                .findFirst();
        if(user.isPresent()){
            return user.get();
        }else {
            System.out.println("Login failed. Please try again! ");
            System.exit(0);
            return null;
        }
    }

    private void manageUsers() {
        while (true) {
            System.out.println("\nUser Management:");
            System.out.println("1. Create User");
            System.out.println("2. Update User");
            System.out.println("3. Delete User");
            System.out.println("4. List Users");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    createUser();
                    break;
                case 2:
                    updateUser();
                    break;
                case 3:
                    deleteUser();
                    break;
                case 4:
                    listUsers();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void createUser() {
        System.out.print("Enter user ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter role (ADMIN/USER): ");
        UserRoles role = UserRoles.valueOf(scanner.nextLine().toUpperCase());

        User user = role == UserRoles.ADMIN ? new Admin(id, username, password, role) : new User(id, username, password, role);
        userService.createUser(user);
        System.out.println("User created successfully.");
    }

    private void updateUser() {
        System.out.print("Enter user ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Optional<User> userOptional = userService.getUser(id);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            System.out.print("Enter new username: ");
            String username = scanner.nextLine();
            System.out.print("Enter new password: ");
            String password = scanner.nextLine();

            user.setUsername(username);
            user.setPassword(password);
            userService.updateUser(user);
            System.out.println("User updated successfully.");
        } else {
            System.out.println("User not found.");
        }
    }

    private void deleteUser() {
        System.out.print("Enter user ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        userService.deleteUser(id);
        System.out.println("User deleted successfully.");
    }

    private void listUsers() {
        userService.listUsers().forEach(System.out::println);
    }

}
