package com.winson.spring.overview.domain;

import org.springframework.core.io.Resource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author winson
 * @date 2021/9/23
 **/
public class User {

    private String name;

    private Integer age;

    private City city;

    private City[] cityArr;

    private int id;

    private Company company;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    //    private List<City> cityList;

//    private Map<String,City> cityMap;

    private Resource resource;

//    public Map<String, City> getCityMap() {
//        return cityMap;
//    }

//    public void setCityMap(Map<String, City> cityMap) {
//        this.cityMap = cityMap;
//    }


    public User() {
        System.out.println("user init");
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

//    public List<City> getCityList() {
//        return cityList;
//    }

//    public void setCityList(List<City> cityList) {
//        this.cityList = cityList;
//    }

    public City[] getCityArr() {
        return cityArr;
    }

    public void setCityArr(City[] cityArr) {
        this.cityArr = cityArr;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", city=" + city +
                ", cityArr=" + Arrays.toString(cityArr) +
                ", id=" + id +
                ", company=" + company +
//                ", resource=" + resource +
                '}';
    }
}
