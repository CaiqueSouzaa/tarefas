package br.com.csouza.tasks.controllers;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.csouza.tasks.entities.Task;
import br.com.csouza.tasks.entities.dto.task.StoreTaskDTO;
import br.com.csouza.tasks.entities.dto.task.UpdateTaskDTO;
import br.com.csouza.tasks.services.TaskService;

@RestController()
@RequestMapping(AppRoutes.tasks)
public class TaskController {
	private TaskService taskService;
	
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}
	
	@PostMapping("")
	public Task store(@RequestBody() StoreTaskDTO task) {
		return this.taskService.store(task);
	}
	
	@GetMapping("")
	public Page<Task> index(@RequestParam(defaultValue = "0") String page, @RequestParam(defaultValue = "10") String size) {
		return this.taskService.index(Integer.parseInt(page), Integer.parseInt(size));
	}
	
	@GetMapping("{id}")
	public Task show(@PathVariable String id) {
		return this.taskService.show(Integer.parseInt(id));
	}
	
	@PutMapping("{id}")
	public Task update(@PathVariable String id, @RequestBody() UpdateTaskDTO task) {
		return this.taskService.update(Integer.parseInt(id), task);
	}
	
	@DeleteMapping("{id}")
	public void destroy(@PathVariable String id) {
		this.taskService.destroy(Integer.parseInt(id));
	}
}
