import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmailDomainTest {

    @Test
    public void invalid_domain_email_throw_arrayIndexOutOfBound(){
        RegisterBusiness registerBusiness = new RegisterBusiness();

        Exception exception = assertThrows(InvalidEmailFormatException.class, () -> {
            registerBusiness.getEmailDomain("a@");
        });
    }
    @Test
    public void valid_domain_email_throw_arrayIndexOutOfBound(){
        RegisterBusiness registerBusiness = new RegisterBusiness();
        String result = registerBusiness.getEmailDomain("demo@gmail.com");
        assertEquals("gmail.com",result);
       
    }
}
