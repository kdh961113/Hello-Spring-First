package hello.hellospring.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.*;

@Controller
public class helloController {

    private String name;
    private Model model;

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";

    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        this.name = name;
        this.model = model;
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        this.name = name;
        return "hello" + name; //"hello spring"
    }


    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        this.name = name;
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    public Model getModel() {
        return model;
    }

    public String getName() {
        return name;
    }

    static  class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    }
}


