package com.abriadm.blog.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
// import org.mapstruct.factory.Mappers;

import com.abriadm.blog.domain.PostStatus;
import com.abriadm.blog.domain.dtos.CategoryDto;
import com.abriadm.blog.domain.dtos.CreateCategoryRequest;
import com.abriadm.blog.entities.Category;
import com.abriadm.blog.entities.Post;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    @Mapping(target = "postCount", source = "posts", qualifiedByName = "calculatePostCount")
    CategoryDto toDto(Category category);

    Category toEntity(CreateCategoryRequest createCategoryRequest);

    @Named("calculatePostCount")
    default long calculatePostCount(List<Post> posts) {
        if (posts == null)
            return 0;
        return posts.stream()
                .filter(post -> PostStatus.PUBLISHED.equals(post.getStatus()))
                .count();
    }
}
