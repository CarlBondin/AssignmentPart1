package test.AssignmentPart1.Task1Tests;

import org.AssignmentPart1.Task1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class apiTests {
    Task1 call;

    @BeforeEach
    public void setup(){
        call = new Task1();
    }
    @Test
    public void testPostAPICall() throws IOException {
        call.postRequest(
                6,
                "Jumper Windows 11 Laptop",
                "Jumper Windows 11 Laptop 1080P Display,12GB RAM 256GB SSD",
                "https://www.amazon.co.uk/Windows-Display-Ultrabook-Processor-Bluetooth",
                "https://m.media-amazon.com/images/I/712Xf2LtbJL._AC_SX679_.jpg",
                "46aba3d5-35a9-4850-b5c1-02824284c450",
                24999
        );
    }

    @Test
    public void testDeleteAPICall() throws IOException {
        call.deleteRequest("46aba3d5-35a9-4850-b5c1-02824284c450");
    }
}
