package com.example.restaurant.naver;

import com.example.restaurant.naver.dto.SearchImageRequest;
import com.example.restaurant.naver.dto.SearchLocalRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NaverClientTest {

    @Autowired
    private NaverClient naverClient;

    @Test
    public void searchLocalTest() {

        var search = new SearchLocalRequest();
        search.setQuery("치킨집");

        var result = naverClient.searchLocal(search);

        System.out.println(result);
    }

    @Test
    public void searchImageTest(){
        var search = new SearchImageRequest();
        search.setQuery("치킨집");

        var result = naverClient.searchImage(search);
        System.out.println(result);
    }
}