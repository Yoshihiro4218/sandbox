## UT
```
// spring のコンテキストでtest
@RunWith(SpringRunner.class)
@SpringBootTest
.
.
@Autowired
Xxxxxx target;
```
```
// Mock
@RunWith(MockitoJunitRunner.class)
.
.
@InjectMocks
Xxxxx target;
@Mock
Yyyyy yyyy;
```
```
// Controller
@RunWith(SpringRunner.class)
@WebMvcTest(XxxxxController.class)
.
.
.
private MockMvc mockMvc;
@Autowired
WebApplicationContext webApplicationContext;
@MockBean
Xxxxx xxxxx;
.
.
@Before
public void setUp() {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                             .apply(springSecurity())
                             .build();
}
.
.
mockMvc.perform(get("/....")
                .with(AuthenticationPostRequestProcessor
                          .user(8354L, "id", "name")))
----------------

public static RequestPostProcessor user(long userId, String id, String userName) {
    GrantedAuthority authority = new SimpleGrantedAuthority(UserRole.ROLE_USER.getRoleName());
    return userBuild(authority, userId, id, userName);
}
```


## https-portal
```yml
version: '3'
services:
  https-portal:
    image: steveltn/https-portal:1
    ports:
      - '80:80'
      - '443:443'
    restart: always
    environment:
      DOMAINS: 'ec2-3-113-163-32.ap-northeast-1.compute.amazonaws.com -> http://localhost:8080'
      STAGE: local
      # FORCE_RENEW: 'true'
    depends_on:
      - web
    links:
      - web
  web:
    image: nginx
    volumes:
      - ./dist:/usr/share/nginx/html
      - ./
    ports:
      - "8080:80"
```

## protectedするやつ
```$java
    /*
     * CustomLoginFlowAuthenticatorを継承し、createHttpClients()をオーバーライドしたメソッドを持つ
     * クラスのオブジェクトをテスト側で生成し、テストではcreateHttpClients()がcloseableHttpClientの
     * mockオブジェクトを返すようにするためにHttpClients.createDefault()をprotectedで切り出している
     */
    protected CloseableHttpClient createHttpClients() {
        return HttpClients.createDefault();
    }
```

テスト側
```$java
    public static class TestCustomLoginFlowAuthenticator extends CustomLoginFlowAuthenticator {
        private CloseableHttpClient closeableHttpClient;
        public TestCustomLoginFlowAuthenticator(CloseableHttpClient closeableHttpClient) {
            this.closeableHttpClient = closeableHttpClient;
        }
        @Override
        protected CloseableHttpClient createHttpClients() {
            return closeableHttpClient;
        }
    }
}
```

## S3
```java
package com.example.demo.service;
import com.amazonaws.services.s3.*;
import com.amazonaws.services.s3.model.*;
import com.example.demo.domain.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.stereotype.*;
import org.springframework.web.multipart.*;
import java.io.*;
import java.util.*;
@Service
@AllArgsConstructor
@Slf4j
public class CommodityImageService {
    private final AmazonS3 s3;
    private final ApplicationProperties applicationProperties;
    public byte[] readImage(String objectKey) throws IOException {
        GetObjectRequest getObjectRequest = new GetObjectRequest(applicationProperties.getS3().getBucketName(), objectKey);
        S3Object s3Object = s3.getObject(getObjectRequest);
        S3ObjectInputStream is = s3Object.getObjectContent();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        while (true) {
            int len = is.read(buffer);
            if (len < 0) {
                break;
            }
            os.write(buffer, 0, len);
        }
        return os.toByteArray();
    }
    public String writeImage(MultipartFile image, String imagePath) throws IOException {
//        String objectKey = UUID.randomUUID().toString() + ".jpeg";
        String objectKey = imagePath + ".jpeg";
        byte[] imgByte = image.getBytes();
        InputStream stream = new ByteArrayInputStream(imgByte);
        PutObjectRequest putObjectRequest = new PutObjectRequest(applicationProperties.getS3().getBucketName(), objectKey , stream, new ObjectMetadata());
        s3.putObject(putObjectRequest);
        return objectKey;
    }
}
```

## Event
```
@Component
@AllArgsConstructor
public class LoginEventListener implements ApplicationListener<LoginEvent> {
    private final UserService userService;
    @Override
    public void onApplicationEvent(LoginEvent event) {
        userService.findByUserName(event.getUserName())
                   .ifPresent(x -> {
                       x.setLastLoggedInAt(event.getAuthenticatedTime());
                       userService.update(x);
                   });
    }
}
@Getter
public class LoginEvent extends ApplicationEvent {
    private String userName;
    private LocalDateTime authenticatedTime;
    public LoginEvent(Object source,
                      String userName,
                      LocalDateTime authenticatedTime) {
        super(source);
        this.userName = userName;
        this.authenticatedTime = authenticatedTime;
    }
}
```