package io.github.demony.forestparktextgame.domain;

import java.util.Objects;

public class Plant {
    private final Long id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plant plant = (Plant) o;
        return Objects.equals(id, plant.id) && Objects.equals(name, plant.name) && Objects.equals(description, plant.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }

    private String name;

    @Override
    public String toString() {
        return "Plant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    private String description;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Plant(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

}
