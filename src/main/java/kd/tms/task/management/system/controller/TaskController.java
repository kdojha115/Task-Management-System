package kd.tms.task.management.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kd.tms.task.management.system.model.Task;
import kd.tms.task.management.system.service.TaskService;

@Controller
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping({"/", "/viewTaskList"})
    public String viewAllTaskItems(Model model) {
        List<Task> tasks = service.getAllTaskItems();
        model.addAttribute("list", tasks);
        return "ViewTaskList";
    }

    @GetMapping("/updateTaskStatus/{id}")
    public String updateTaskStatus(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (service.updateStatus(id)) {
            redirectAttributes.addFlashAttribute("message", "Update Success");
        } else {
            redirectAttributes.addFlashAttribute("message", "Update Failure");
        }
        return "redirect:/viewTaskList";
    }

    @GetMapping("/addTaskItem")
    public String addTaskItem(Model model) {
        model.addAttribute("task", new Task());
        return "AddTaskItem";
    }

    @PostMapping("/saveTaskItem")
    public String saveTaskItem(@ModelAttribute Task task, RedirectAttributes redirectAttributes) {
        if (service.saveOrUpdateTaskItem(task)) {
            redirectAttributes.addFlashAttribute("message", "Task saved successfully.");
        } else {
            redirectAttributes.addFlashAttribute("error", "Failed to save task.");
        }
        return "redirect:/viewTaskList";
    }

    @GetMapping("/editTaskItem/{id}")
    public String editTaskItem(@PathVariable Long id, Model model) {
        Task task = service.getTaskItemById(id);
        model.addAttribute("task", task);
        return "EditTaskItem";
    }

    @PostMapping("/editSaveTaskItem")
    public String editSaveTaskItem(@ModelAttribute Task task, RedirectAttributes redirectAttributes) {
        if (service.saveOrUpdateTaskItem(task)) {
            redirectAttributes.addFlashAttribute("message", "Edit Success");
        } else {
            redirectAttributes.addFlashAttribute("error", "Failed to update task.");
        }
        return "redirect:/viewTaskList";
    }
    
    @GetMapping("/viewTaskItem/{id}")
    public String viewTaskItem(@PathVariable Long id, Model model) {
        Task task = service.getTaskItemById(id);
        model.addAttribute("task", task);
        return "ViewTaskItem";
    }

    @GetMapping("/deleteTaskItem/{id}")
    public String deleteTaskItem(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (service.deleteTaskItem(id)) {
            redirectAttributes.addFlashAttribute("message", "Delete Success");
        } else {
            redirectAttributes.addFlashAttribute("error", "Failed to delete task.");
        }
        return "redirect:/viewTaskList";
    }
}
