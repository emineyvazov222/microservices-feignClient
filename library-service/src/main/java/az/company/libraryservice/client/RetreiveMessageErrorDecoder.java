package az.company.libraryservice.client;

import az.company.libraryservice.exceptions.BookNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;
import java.io.InputStream;

public class RetreiveMessageErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder errorDecoder = new Default();


    @Override
    public Exception decode(String s, Response response) {
        ExceptionMessage message = null;
        try (InputStream stream = response.body().asInputStream()) {
            ObjectMapper mapper = new ObjectMapper();
            message = mapper.readValue(stream, ExceptionMessage.class);
        } catch (IOException e) {
            return new Exception(e.getMessage());

        }
        if (response.status() == 404) {
            return new BookNotFoundException(message.message() != null ? message.message() : "Book not found");
        }
        return errorDecoder.decode(s, response);
    }
}
