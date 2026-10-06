package mygov.task01;

import mygov.task01.data.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureTestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestConstructor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@AutoConfigureTestRestTemplate

public class CustomerIntegrationTest {

    private final TestRestTemplate restTemplate;


    public CustomerIntegrationTest(TestRestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Test
    void getCustomer_ShouldReturnCustomers() {
        ResponseEntity<Customer[]> response =
                restTemplate.getForEntity("/customers", Customer[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertNotNull(response.getBody());

        assertTrue(response.getBody().length > 0);
    }


}

