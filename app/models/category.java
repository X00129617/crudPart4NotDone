package models;


import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.validation.*;



/**
 * Created by wdd on 09/12/16.
 */
public class category extends Model {
    @Id
    private Long id;

    // Other fields marked as being required (for validation purposes)
    @Constraints.Required
    private String name;

    @OneToMany
    private List<Product>products;

    public  category(){

    }

    public  category (Long id, String name,List<Product>products){
        this.setId(id);
        this.setName(name);
        this.setProducts(products);
    }


    //Generic query helper for entity Computer with id Long
    public static Finder<Long,category> find = new Finder<Long,category>(category.class);

    //Find all Products in the database in ascending order by name
    public static List<category> findAll() {
        return category.find.where().orderBy("name asc").findList();
    }

    // Generate options for an HTML select control
    public static Map<String,String> options() {
        LinkedHashMap<String,String> options = new LinkedHashMap<>();

        // Get all categories from the DB and add to the options Hash map
        for(category c: category.findAll()) {
            options.put(c.getId().toString(), c.getName());
        }
        return options;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }





}
