package com.baeldung.requestresponsebody;

import com.baeldung.services.ExampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class ExamplePostController {
    public static final String LOG_DEBUG = "POST received - serializing LoginForm: {1} {2}";
    private static Logger log = LoggerFactory.getLogger(ExamplePostController.class);
    @Autowired
    ExampleService exampleService;

    @PostMapping("/request")
    public ResponseEntity<Object> postController(@RequestBody LoginForm loginForm) {
        if (log.isDebugEnabled()) {
            log.debug(String.format(LOG_DEBUG, loginForm.getPassword(), loginForm.getUsername()));
        }
        exampleService.fakeAuthenticate();
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/response")
    public ResponseTransfer postResponseController(@RequestBody LoginForm loginForm) {
        if (log.isDebugEnabled()) {
            log.debug(String.format(LOG_DEBUG, loginForm.getPassword(), loginForm.getUsername()));
        }
        return new ResponseTransfer("Thanks For Posting!!!");
    }

    @PostMapping(value = "/content", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseTransfer postResponseJsonContent(@RequestBody LoginForm loginForm) {
        if (log.isDebugEnabled()) {
            log.debug(String.format(LOG_DEBUG, loginForm.getPassword(), loginForm.getUsername()));
        }
        return new ResponseTransfer("JSON Content!");
    }

    @PostMapping(value = "/content", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseTransfer postResponseXmlContent(@RequestBody LoginForm loginForm) {
        if (log.isDebugEnabled()) {
            log.debug(String.format(LOG_DEBUG, loginForm.getPassword(), loginForm.getUsername()));
        }
        return new ResponseTransfer("XML Content!");
    }
}