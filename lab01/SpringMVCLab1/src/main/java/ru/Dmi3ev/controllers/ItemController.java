package ru.Dmi3ev.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.Dmi3ev.dao.ItemDAO;
import ru.Dmi3ev.model.Item;

import java.util.List;

@Controller
public class ItemController {

    @Autowired
    ItemDAO itemDAO;

    @RequestMapping("index")
    public String back(){
        return "../../index";
    }

    @GetMapping("/addItem")
    public String addItem(Model m){
        m.addAttribute("command", new Item());
        return "addItem";
    }

    @RequestMapping(value="/saveitem")
    public String saveItem(@ModelAttribute("command") Item item){
        int id = itemDAO.addItem(item);
        if (id!=-1) return "redirect:/allItem";
        else return "redirect:/error";
    }

    @GetMapping("allItem")
    public String allItem(Model m){
        List<Item> list = itemDAO.getAllItem();
        m.addAttribute("list",list);
        return "allItem";
    }

    @RequestMapping(value="/edit/{id}")
    public String edit(@PathVariable int id, Model m){
        Item item = itemDAO.getItemById(id);
        m.addAttribute("command",item);
        return "editItem";
    }

    @RequestMapping(value = "edit/apply")
    public String editSave(@ModelAttribute("command") Item item){
        System.out.println(item.getId() + item.getName() + item.getPrice());
        int id = itemDAO.update(item);
        System.out.println(item.getId() + item.getName() + item.getPrice());
        if (id!=-1) return  "redirect:../allItem";
        else return "redirect:/error";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable int id){
        int i = itemDAO.delete(id);
        if (i!=-1) return "redirect:/allItem";
        else return "redirect:/error";
    }
}
