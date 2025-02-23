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

import br.com.csouza.tasks.entities.Status;
import br.com.csouza.tasks.entities.dto.status.StoreStatusDTO;
import br.com.csouza.tasks.entities.dto.status.UpdateStatusDTO;
import br.com.csouza.tasks.services.StatusService;

@RestController()
@RequestMapping("status")
public class StatusController {
	private StatusService statusService;
	
	public StatusController(StatusService statusService) {
		this.statusService = statusService;
	}
	
	@PostMapping("")
	public Status store(@RequestBody() StoreStatusDTO status) {		
		return this.statusService.store(status);
	}
	
	@GetMapping("")
	public Page<Status> index(@RequestParam(defaultValue = "0") String page, @RequestParam(defaultValue = "10") String size) {		
		return this.statusService.index(Integer.parseInt(page), Integer.parseInt(size));
	}
	
	@GetMapping("{id}")
	public Status show(@PathVariable String id) {
		return this.statusService.show(Integer.parseInt(id));
	}
	
	@PutMapping("{id}")
	public Status update(@PathVariable String id, @RequestBody() UpdateStatusDTO status) {
		return this.statusService.update(Integer.parseInt(id), status);
	}
	
	@DeleteMapping("{id}")
	public void destroy(@PathVariable String id) {
		this.statusService.destroy(Integer.parseInt(id));
	}
}
