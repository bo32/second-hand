package con.david.secondhand.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.david.secondhand.controllers.ObjectToSellController;
import com.david.secondhand.entities.ObjectToSell;
import com.david.secondhand.services.ObjectToSellService;

import con.david.secondhand.spring.JUnitContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@ContextConfiguration(classes={JUnitContext.class})
public class ObjectToSaleControllerTest {
	
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));
	
	@InjectMocks
	private ObjectToSellController objectToSellController;
	
	private MockMvc mock;
	
	@Mock
	private ObjectToSellService service;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mock = MockMvcBuilders.standaloneSetup(objectToSellController).build();
		
		List<ObjectToSell> results = new ArrayList<ObjectToSell>();
		ObjectToSell o = new ObjectToSell();
		o.setId(1L);
		o.setName("Nintendo 64");
		o.setDescription("Good state");
		o.setPrice(600.0);
		results.add(o);
		o = new ObjectToSell();
		o.setId(1L);
		o.setName("CD Mickael Jackson");
		o.setDescription("Awesome");
		o.setPrice(40.0);
		results.add(o);
		
		
		Mockito.when(service.getAllObjects()).thenReturn(results);
	}
	
	@Test
	public void testFindAllObjectsToSell() throws Exception {
		mock.perform(get("/objects/all"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$[0].name", is("Nintendo 64")))
				.andExpect(jsonPath("$[1].price", is(40.0)))
				.andReturn();
	}

}
