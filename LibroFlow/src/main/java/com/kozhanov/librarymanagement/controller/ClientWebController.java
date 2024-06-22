package com.kozhanov.librarymanagement.controller;

import com.kozhanov.librarymanagement.model.Client;
import com.kozhanov.librarymanagement.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/clients")
public class ClientWebController {

    private final ClientService clientService;

    @Autowired
    public ClientWebController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("")
    public String showClients(
            Model model,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "16") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Client> clientPage = clientService.findAll(pageable);

        model.addAttribute("clientList", clientPage.getContent());
        model.addAttribute("totalPages", clientPage.getTotalPages());
        model.addAttribute("currentPage", page);

        return "clientList";
    }

    @GetMapping("/add")
    public String addClient() {
        return "saveClient";
    }
    @GetMapping("/edit/{id}")
    public String editClient(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Client> clientOptional = clientService.findById(id);
        if (clientOptional.isPresent()) {
            model.addAttribute("client", clientOptional.get());
            return "saveClient";
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Клиент удалена или не найден.");
            return "redirect:/clients";
        }
    }

    @PostMapping("/save")
    public String saveClient(@ModelAttribute Client client, RedirectAttributes redirectAttributes) {
        boolean success = clientService.saveOrUpdate(client);

        if (success) {
            String successMessage = client.getClientId() == null ? "Клиент успешно добавлен." : "Клиент успешно обновлен.";
            redirectAttributes.addFlashAttribute("successMessage", successMessage);
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Ошибка при сохранении клиента.");
        }

        return "redirect:/clients";
    }

}
