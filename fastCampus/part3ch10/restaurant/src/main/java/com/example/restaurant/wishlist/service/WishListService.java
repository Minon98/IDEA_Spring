package com.example.restaurant.wishlist.service;

import com.example.restaurant.naver.NaverClient;
import com.example.restaurant.naver.dto.SearchImageRequest;
import com.example.restaurant.naver.dto.SearchLocalRequest;
import com.example.restaurant.wishlist.dto.WishListDto;
import com.example.restaurant.wishlist.entity.WishListEntity;
import com.example.restaurant.wishlist.repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WishListService {
    private final NaverClient naverClient;
    private final WishListRepository wishListRepository;

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

    public WishListDto add(WishListDto wishListDto) {
        var entity = dtoToEntity(wishListDto);
        var saveEntity = wishListRepository.save(entity);

        return entityToDto(saveEntity);
    }

    private WishListEntity dtoToEntity(WishListDto wishListDto){
        var entity = new WishListEntity();
        entity.setTitle(wishListDto.getTitle());
        entity.setIndex(wishListDto.getIndex());
        entity.setCategory(wishListDto.getCategory());
        entity.setAddress(wishListDto.getAddress());
        entity.setRoadAddress(wishListDto.getRoadAddress());
        entity.setHomePageLink(wishListDto.getHomePageLink());
        entity.setImageLink(wishListDto.getImageLink());
        entity.setIsVisit(wishListDto.getIsVisit());
        entity.setVisitCount(wishListDto.getVisitCount());
        entity.setLastVisitData(wishListDto.getLastVisitData());

        return entity;
    }

    private WishListDto entityToDto(WishListEntity wishListEntity){
        var dto = new WishListDto();
        dto.setTitle(wishListEntity.getTitle());
        dto.setIndex(wishListEntity.getIndex());
        dto.setCategory(wishListEntity.getCategory());
        dto.setAddress(wishListEntity.getAddress());
        dto.setRoadAddress(wishListEntity.getRoadAddress());
        dto.setHomePageLink(wishListEntity.getHomePageLink());
        dto.setImageLink(wishListEntity.getImageLink());
        dto.setIsVisit(wishListEntity.getIsVisit());
        dto.setVisitCount(wishListEntity.getVisitCount());
        dto.setLastVisitData(wishListEntity.getLastVisitData());

        return dto;
    }

    public List<WishListDto> findAll() {
        return wishListRepository.findAll()
                .stream()
                .map(it -> entityToDto(it))
                .collect(Collectors.toList());
    }

    public void delete(int index) {
        wishListRepository.deleteById(index);
    }

    public void addVisit(int index){
        var wishItem = wishListRepository.findById(index);
        if(wishItem.isPresent()){
            var item = wishItem.get();

            item.setIsVisit(true);
            item.setVisitCount(item.getVisitCount()+1);
        }
    }
}
