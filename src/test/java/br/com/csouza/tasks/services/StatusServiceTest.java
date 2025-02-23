package br.com.csouza.tasks.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.csouza.tasks.entities.Status;
import br.com.csouza.tasks.entities.dto.status.StoreStatusDTO;
import br.com.csouza.tasks.interfaces.repositories.IStatusRepository;
import br.com.csouza.tasks.utils.Text;

public class StatusServiceTest {
	@Mock
	private IStatusRepository statusRepository;
	
	@InjectMocks
	private StatusService statusService;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	private StoreStatusDTO create() {
		return StoreStatusDTO
				.builder()
				.name(Text.randomText(10))
				.build();
	}
	
	@Test
	public void store() {
		final StoreStatusDTO statusDTO = this.create();
		final Status status = this.statusService.store(statusDTO);
		
		Assertions.assertNotNull(status.getId());;
	}
}
