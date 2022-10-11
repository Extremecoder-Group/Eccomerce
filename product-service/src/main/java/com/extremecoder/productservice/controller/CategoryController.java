package com.extremecoder.productservice.controller;

import com.extremecoder.productservice.dto.ApiResponse;
import com.extremecoder.productservice.dto.CategoryRegistrationRequest;
import com.extremecoder.productservice.model.CategoryEntity;
import com.extremecoder.productservice.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;
    private final MessageSource messageSource;


    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody CategoryRegistrationRequest request) {
        log.info("*** CategoryController.create() ***");
        log.debug("request: " + request.toString());

//        String message = messageSource.getMessage(
//                "message.api.success", null,
//                LocaleContextHolder.getLocale());

        String message = messageSource.getMessage(
                "message.api.success", null,
                Locale.forLanguageTag("bn-BD"));

        ApiResponse<Object, Object> apiResponse = ApiResponse.builder()
                .message(message)
                .statusCode(ApiResponse.OK)
                .status(ApiResponse.translateStatus(ApiResponse.OK))
                .content(service.create(request))
                .timeStamp(new Date())
                .build();

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> update(@PathVariable Long id,
                                         @Valid @RequestBody CategoryRegistrationRequest request) {
        log.info("*** CategoryController.update() ***");
        log.debug("request: " + request.toString());

        ApiResponse<Object, Object> apiResponse = ApiResponse.builder()
                .message("Success")
                .statusCode(ApiResponse.OK)
                .status(ApiResponse.translateStatus(ApiResponse.OK))
                .content(service.update(request, id))
                .timeStamp(new Date())
                .build();

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getCategory(@PathVariable Long id) {
        log.info("*** CategoryController.getCategory() ***");
        log.debug("request id: " + id);

        ApiResponse<Object, Object> apiResponse = ApiResponse.builder()
                .message("Success")
                .statusCode(ApiResponse.OK)
                .status(ApiResponse.translateStatus(ApiResponse.OK))
                .content(service.getCategory(id))
                .timeStamp(new Date())
                .build();

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Object> getAllCategories() {
        log.info("*** CategoryController.getAllCategories() ***");

        ApiResponse<Object, Object> apiResponse = ApiResponse.builder()
                .message("Success")
                .statusCode(ApiResponse.OK)
                .status(ApiResponse.translateStatus(ApiResponse.OK))
                .content(service.getAllCategories())
                .timeStamp(new Date())
                .build();

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        log.info("*** CategoryController.delete() ***");

        service.delete(id);

        ApiResponse<Object, Object> apiResponse = ApiResponse.builder()
                .message("Success")
                .statusCode(ApiResponse.OK)
                .status(ApiResponse.translateStatus(ApiResponse.OK))
                .timeStamp(new Date())
                .build();

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/with-pagination-sorting")
    public List<CategoryEntity> categoryListWithPaginationAndSorting(@RequestParam Optional<Integer> offSet,
                                                                     @RequestParam Optional<Integer> pageSize,
                                                                     @RequestParam Optional<String> sortedField,
                                                                     @RequestParam Optional<String> sortedDirection) {

        return service.categoryListWithPaginationAndSorting(offSet, pageSize, sortedField, sortedDirection);
    }
}
