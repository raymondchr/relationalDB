package com.ray.relationalDB.Category

import com.ray.relationalDB.Category.model.CategoryResponse
import com.ray.relationalDB.Category.model.CreateNewCategory
import com.ray.relationalDB.error.NotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.postgresql.util.PSQLException
import org.springframework.dao.DataIntegrityViolationException
import java.sql.SQLException

@Service
class CategoryService(private val categoryRepository: CategoryRepository) {
    fun getAllCategory(pageable: Pageable): Page<CategoryResponse> {
        return categoryRepository.findAllCategory(pageable).map { it.toResponse() }
    }

    fun createNewCategory(createNewCategory: CreateNewCategory): CategoryResponse {

        try {
            val newCategory = Category(
                description = createNewCategory.description
            )

            categoryRepository.save(newCategory)

            return newCategory.toResponse()
        } catch (e: DataIntegrityViolationException) {
                throw IllegalArgumentException("TEST ERROR")
        }

    }

//        val existingCategory=categoryRepository.findCategoryByName(createNewCategory.description)
//        return if (existingCategory.decription != createNewCategory.description){
//            val newCategory = Category(
//                description = createNewCategory.description
//            )
//
//            categoryRepository.save(newCategory)
//
//            newCategory.toResponse()
//        }else{
//            CategoryResponse(
//                id = 0,
//                description = "ALREADY EXIST"
//            )
//        }


    fun getCategoryByIdOrThrowNull(id: Int): Category{
        return categoryRepository.findByIdOrNull(id) ?: throw NotFoundException()
    }
}