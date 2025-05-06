package com.example.uts;

import java.util.ArrayList;

public class UserRepository {
    // Menggunakan Singleton pattern agar data tetap sama di seluruh aplikasi
    private static UserRepository instance;
    private ArrayList<User> userList;

    // Constructor private untuk Singleton pattern
    private UserRepository() {
        userList = new ArrayList<>();
        // Menambahkan user awal untuk testing (opsional)
        userList.add(new User("admin", "admin@example.com", "admin123"));
    }

    // Metode untuk mendapatkan instance dari UserRepository
    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    // Metode untuk register user baru
    public boolean registerUser(String username, String email, String password) {
        // Cek apakah username atau email sudah ada
        for (User user : userList) {
            if (user.getUsername().equals(username) || user.getEmail().equals(email)) {
                return false; // Username atau email sudah digunakan
            }
        }

        // Tambahkan user baru ke ArrayList
        userList.add(new User(username, email, password));
        return true; // Registrasi berhasil
    }

    // Metode untuk login
    public boolean loginUser(String username, String password) {
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true; // Login berhasil
            }
        }
        return false; // Username atau password salah
    }

    // Metode untuk mendapatkan semua user (untuk debugging)
    public ArrayList<User> getAllUsers() {
        return userList;
    }
}
