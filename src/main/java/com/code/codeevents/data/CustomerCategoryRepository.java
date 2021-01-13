package com.code.codeevents.data;

import com.code.codeevents.models.CustomerCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerCategoryRepository extends CrudRepository<CustomerCategory, Integer> {
}
