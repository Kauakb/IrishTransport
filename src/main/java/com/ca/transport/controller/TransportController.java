package com.ca.transport.controller;

import com.ca.transport.model.Transport;
import com.ca.transport.service.TransportService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Controller
@RequestMapping("/transports")
public class TransportController {

    @Autowired
    private TransportService transportService;

    // READ - list all
    @GetMapping
    public String listAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "") String search, Model model) {
        Page<Transport> transportPage;
    	Pageable pageable = PageRequest.of(page, 20);
    	if (search.isEmpty()) {
    		transportPage = transportService.getAllTransports(pageable);
    	} else {
    		transportPage = transportService.searchByName(search, pageable);
    	}
 
        model.addAttribute("transports", transportPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", transportPage.getTotalPages());
        model.addAttribute("search", search);
        return "transport/list";
    }

    // CREATE - show form
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("transport", new Transport());
        return "transport/form";
    }

    // CREATE - submit form
    @PostMapping
    public String createTransport(@Valid @ModelAttribute("transport") Transport transport,
                                   BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "transport/form";
        }
        transportService.saveTransport(transport);
        return "redirect:/transports";
    }

    // UPDATE - show form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        Transport transport = transportService.getTransportById(id)
                .orElseThrow(() -> new RuntimeException("Transport not found"));
        model.addAttribute("transport", transport);
        return "transport/form";
    }

    // update - submit
    @PostMapping("/edit/{id}")
    public String updateTransport(@PathVariable String id,
                                   @Valid @ModelAttribute("transport") Transport transport,
                                   BindingResult result) {
        if (result.hasErrors()) {
            return "transport/form";
        }
        transport.setId(id);
        transportService.updateTransport(transport);
        return "redirect:/transports";
    }

    // delete
    @GetMapping("/delete/{id}")
    public String deleteTransport(@PathVariable String id) {
        transportService.deleteTransport(id);
        return "redirect:/transports";
    }
}