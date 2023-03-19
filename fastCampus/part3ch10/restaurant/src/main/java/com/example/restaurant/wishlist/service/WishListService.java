package com.example.restaurant.wishlist.service;

import com.example.restaurant.naver.NaverClient;
import com.example.restaurant.naver.dto.SearchImageRequest;
import com.example.restaurant.naver.dto.SearchLocalRequest;
import com.example.restaurant.wishlist.dto.WishListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WishListService {

    private final NaverClient naverClient;

    public WishListDto search(String query){

        //지역 검색
        var searchLocalRequest = new SearchLocalRequest();
        searchLocalRequest.setQuery(query);

        var searchLocalResponse = naverClient.searchLocal(searchLocalRequest);

        if(searchLocalResponse.getTotal() > 0){
            var localItem = searchLocalResponse.getItems().stream().findFirst().get();

            var imageQuery = localItem.getTitle().replaceAll("<[^>]*>", "");
            var searchImageRequest = new SearchImageRequest();
            searchImageRequest.setQuery(imageQuery);

            //이미지 검색
            var searchImageResponse = naverClient.searchImage(searchImageRequest);

            if(searchImageResponse.getTotal() > 0){

                var imageItem = searchImageResponse.getItems().stream().findFirst().get();
                // 결과 리턴
                var result = new WishListDto();
                result.setTitle(localItem.getTitle());
                result.setCategory(localItem.getCategory());
                result.setAddress(localItem.getAddress());
                result.setRoadAddress(localItem.getRoadAddress());
                result.setHomePageLink(localItem.getLink());
                result.setImageLink(imageItem.getLink());

                return result;
            }
        }

        return new WishListDto();
    }
}
