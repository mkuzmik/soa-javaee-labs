package soa.mkuzmik.ex5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Movie {
    private String title;
    private String category;
    private int year;
    private int income;

    public static List<Movie> example() {
        return Arrays.stream(new Movie[] {
                new Movie("Ojciec Chrzestny", "dramat", 1972,120000000),
                new Movie("Pluton", "wojenny", 1986, 1000000),
                new Movie("Nagi instynkt", "thriller", 1992, 60000),
        }).collect(Collectors.toList());
    }

    public Movie(String title, String category, int year, int income) {
        this.title = title;
        this.category = category;
        this.year = year;
        this.income = income;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }
}
