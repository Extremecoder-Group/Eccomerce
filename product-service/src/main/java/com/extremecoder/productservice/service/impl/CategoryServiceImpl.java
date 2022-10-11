package com.extremecoder.productservice.service.impl;import com.extremecoder.productservice.dto.CategoryDetail;import com.extremecoder.productservice.dto.CategoryRegistrationRequest;import com.extremecoder.productservice.dto.ParentCategoryDetail;import com.extremecoder.productservice.exception.InvalidRequestException;import com.extremecoder.productservice.exception.ResourceNotFoundException;import com.extremecoder.productservice.model.CategoryEntity;import com.extremecoder.productservice.repository.CategoryRepository;import com.extremecoder.productservice.service.CategoryService;import lombok.RequiredArgsConstructor;import lombok.extern.slf4j.Slf4j;import org.springframework.data.domain.Page;import org.springframework.data.domain.PageRequest;import org.springframework.data.domain.Pageable;import org.springframework.data.domain.Sort;import org.springframework.stereotype.Service;import org.springframework.util.ObjectUtils;import java.util.List;import java.util.Optional;import java.util.stream.Collectors;import static com.extremecoder.productservice.utils.Constant.DEFAULT_SEARCH_ITEM;import static com.extremecoder.productservice.utils.Constant.DEFAULT_SORTED_FIELD;@Service@Slf4j@RequiredArgsConstructorpublic class CategoryServiceImpl implements CategoryService {    private final CategoryRepository repository;    @Override    public Long create(CategoryRegistrationRequest request) {        log.info("*** CategoryServiceImpl.create() start ***");        log.debug("request: " + request);        CategoryEntity entity = new CategoryEntity();        if (request.getIsParent()) {            if (request.getParentId() == null) {                throw new InvalidRequestException("parentId can not be null", "12345");            } else {                entity.setParentCategory(getCategoryEntity(request.getParentId()));            }        }        entity.setName(request.getName());        entity.setDescription(request.getDescription());        entity.setParent(request.getIsParent());        return repository.save(entity).getId();    }    @Override    public Long update(CategoryRegistrationRequest request, Long id) {        log.info("*** CategoryServiceImpl.update() start ***");        log.debug("request: " + request);        log.debug("request id: " + id);        CategoryEntity entity = getCategoryEntity(id);        if (request.getIsParent()) {            if (request.getParentId() == null) {                throw new InvalidRequestException("parentId can not be null", "12345");            } else {                entity.setParentCategory(getCategoryEntity(request.getParentId()));            }        } else {            entity.setParentCategory(null);        }        entity.setName(request.getName());        entity.setDescription(request.getDescription());        entity.setParent(request.getIsParent());        return repository.save(entity).getId();    }    @Override    public List<CategoryDetail> getAllCategories() {        return repository.findAllByActiveStatus_Active()                .stream().map(entity -> getCategory(entity.getId())                ).collect(Collectors.toList());    }    @Override    public CategoryDetail getCategory(Long id) {        CategoryEntity entity = getCategoryEntity(id);        CategoryDetail category = new CategoryDetail();        category.setId(id);        category.setName(entity.getName());        category.setDescription(entity.getDescription());        category.setIsParent(entity.isParent());        category.setCreatedDate(entity.getCreatedDate());        category.setLastModifiedDate(entity.getLastModifiedDate());        if (!ObjectUtils.isEmpty(entity.getParentCategory())) {            category.setParentCategory(                    ParentCategoryDetail.builder()                            .id(entity.getParentCategory().getId())                            .name(entity.getParentCategory().getName())                            .description(entity.getParentCategory().getDescription())                            .build()            );        }        return category;    }    public void delete(Long id) {        log.info("*** CategoryServiceImpl.delete() start ***");        log.debug("request id: " + id);        repository.delete(getCategoryEntity(id));    }    @Override    public List<CategoryEntity> categoryListWithPaginationAndSorting(Optional<Integer> offSet,                                                                     Optional<Integer> pageSize,                                                                     Optional<String> sortedField,                                                                     Optional<String> sortedDirection) {        int currentPage = offSet.orElse(0);        int currentPerPage = pageSize.orElse(DEFAULT_SEARCH_ITEM);        String sortedBy = sortedField.orElse(DEFAULT_SORTED_FIELD);        String sortDir = sortedDirection.orElse(Sort.Direction.DESC.name());        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortedBy).ascending()                : Sort.by(sortedBy).descending();        Pageable page = PageRequest.of(currentPage, currentPerPage, sort);        Page<CategoryEntity> pageValue = repository.findAll(page);        return pageValue.hasContent() ? pageValue.getContent() : null;    }    public CategoryEntity getCategoryEntity(Long id) {        CategoryEntity entity = repository.findByIdAndActiveStatus_Active(id);        if (ObjectUtils.isEmpty(entity)) {            throw new ResourceNotFoundException("Transaction not found for id: " + id, "123");        } else {            return entity;        }    }}