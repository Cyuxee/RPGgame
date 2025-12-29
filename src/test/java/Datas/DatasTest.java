package Datas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DatasTest {

    @Test
    @DisplayName("shouldHaveDefaultCredentials_whenCreated")
    void shouldHaveDefaultCredentials_whenCreated() {
        Datas datas = new Datas(null);
        assertEquals("12345", datas.getUsername());
        assertEquals("12345", datas.getPassword());
        assertEquals(0, datas.getIndex());
    }

    @Test
    @DisplayName("shouldUpdateCredentialsAndIndex_whenSettersCalled")
    void shouldUpdateCredentialsAndIndex_whenSettersCalled() {
        Datas datas = new Datas(null);
        datas.setUsername("user");
        datas.setPassword("pass");
        datas.setIndex(3);

        assertEquals("user", datas.getUsername());
        assertEquals("pass", datas.getPassword());
        assertEquals(3, datas.getIndex());
    }
}
