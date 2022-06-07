package api.services;

import api.models.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
}
