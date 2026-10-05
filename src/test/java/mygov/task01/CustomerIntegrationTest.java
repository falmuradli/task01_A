package mygov.task01;

import org.junit.jupiter.api.Test;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest (
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class CustomerIntegrationTest {

    private final TestRestTemplate restTemplate;


    CustomerIntegrationTest(TestRestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Test
    void getCustomerShouldReturnCustomers() {
        ResponseEntity<Customer[]> response =
                restTemplate.getForEntity("/customers", Customer[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertNotNull(response.getBody());

        assertTrue(response.getBody().length > 0);
    }


}
