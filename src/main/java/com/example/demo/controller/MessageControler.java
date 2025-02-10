package com.example.demo.controller;


import com.example.demo.model.Message;
import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MessageControler {

    @Autowired
    private MessageService messageService;

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("messages", messageService.findAllMessages());
        return "index";
    }

    @PostMapping("/addMessage")
    public String addMessage(@RequestParam("content") String content, Model model) {
        Message newMessage = new Message();
        newMessage.setContent(content);
        messageService.saveMessage(newMessage);
        return "redirect:/";
    }
//    @GetMapping("/deleteMesage")
//    public String deleteMessage(@RequestParam("id") Long id) {
//        messageService.deleteMessage(id);
//        return "redirect:/";
//    }
    @PostMapping("/deleteMesage")
    public String deleteMessage(@RequestParam("id") Long id) {
        messageService.deleteMessage(id);
        return "redirect:/";
    }
//    @DeleteMapping("/deleteMesage/{id}")
//    public String deleteMessage(@PathVariable Long id) {
//        messageService.deleteMessage(id);
//        return "redirect:/";
//    }

}
