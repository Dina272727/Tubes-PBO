package com.kelompok5.taskhub.controller;

import com.kelompok5.taskhub.model.Users;
import com.kelompok5.taskhub.repository.UserRepository;
import com.kelompok5.taskhub.service.AuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam String username,
                          @RequestParam String password,
                          @RequestParam(required = false) String remember,
                          Model model,
                          HttpSession session) {

        boolean valid = authService.login(username, password);
        if (valid) {
            session.setAttribute("username", username);

            // ✅ Remember Me aktif jika checkbox dicentang
            if ("on".equals(remember)) {
                session.setMaxInactiveInterval(7 * 24 * 60 * 60); // 7 hari
                System.out.println("📝 Remember Me diaktifkan (7 hari)");
            } else {
                session.setMaxInactiveInterval(30 * 60); // default 30 menit
            }

            return "redirect:/dashboard";
        } else {
            model.addAttribute("error", "Username atau password yang anda masukkan salah!!.");
            return "login";
        }
    }


    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }

        model.addAttribute("username", username);
        return "dashboard";
    }

    @GetMapping("/registrasi")
    public String registerPage() {
        return "registrasi";
    }

    @PostMapping("/registrasi")
    public String doRegister(@RequestParam String username,
                             @RequestParam String email,
                             @RequestParam String password,
                             @RequestParam String role,
                             Model model) {

        // Cek spasi di username atau password
        if (username.contains(" ") || password.contains(" ")) {
            model.addAttribute("error", "Username atau password tidak boleh mengandung spasi.");
            return "registrasi";
        }

        // Validasi panjang password
        if (password.length() < 8) {
            model.addAttribute("error", "Password minimal 8 karakter.");
            return "registrasi";
        }

        // Validasi email kosong
        if (email == null || email.isBlank()) {
            model.addAttribute("error", "Email tidak boleh kosong.");
            return "registrasi";
        }

        // Cek username sudah digunakan
        Users existing = userRepository.findByUsername(username);
        if (existing != null) {
            model.addAttribute("error", "Username sudah digunakan.");
            return "registrasi";
        }

        // Simpan user baru
        Users user = new Users();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);
        userRepository.save(user);


        return "redirect:/login";
    }

}
